import java.text.SimpleDateFormat
import java.util.*

plugins {
    java
    jacoco
    `maven-publish`
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    
    implementation(project(":common"))

    testImplementation(libs.bundles.test)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

val versionFromProperty = "${project.property("version")}"
val versionFromEnv: String? = System.getenv("VERSION")

version = versionFromEnv ?: versionFromProperty
group = "${project.property("group")}"

val targetJavaVersion = libs.versions.jdk.get().toInt()
val javaVersion = JavaVersion.toVersion(targetJavaVersion)
val javaLanguageVersion = JavaLanguageVersion.of(targetJavaVersion)

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    toolchain {
        languageVersion = javaLanguageVersion
    }
    withSourcesJar()
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.property("project_name")}_recording" }
    }
    manifest {
        attributes(
            mapOf(
                "Specification-Group" to project.group,
                "Specification-Title" to project.name,
                "Specification-Version" to project.version,
                "Specification-Timestamp" to SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date()),
                "Timestamp" to System.currentTimeMillis(),
                "Built-On-Java" to "${System.getProperty("java.vm.version")} (${System.getProperty("java.vm.vendor")})"
            )
        )
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                packaging = "jar"
                url = "${project.property("git_url")}"
                artifactId = "recording"

                licenses {
                    license {
                        name.set("The MIT License (MIT)")
                        url.set("https://www.mit.edu/~amini/LICENSE.md")
                    }
                }

                scm {
                    connection.set("scm:${project.property("git_url")}.git")
                    developerConnection.set("${project.property("git_organization_url")}")
                    url.set("${project.property("git_url")}")
                }

                developers {
                    developer {
                        id.set("sibmaks")
                        name.set("Maksim Drobyshev")
                        email.set("sibmaks@vk.com")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            val releasesUrl = uri("https://nexus.sibmaks.ru/repository/maven-releases/")
            val snapshotsUrl = uri("https://nexus.sibmaks.ru/repository/maven-snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsUrl else releasesUrl
            credentials {
                username = project.findProperty("nexus_username")?.toString() ?: System.getenv("NEXUS_USERNAME")
                password = project.findProperty("nexus_password")?.toString() ?: System.getenv("NEXUS_PASSWORD")
            }
        }
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${project.property("git_path")}")
            credentials {
                username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key")?.toString() ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

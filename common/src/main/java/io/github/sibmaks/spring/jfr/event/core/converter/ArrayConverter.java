package io.github.sibmaks.spring.jfr.event.core.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author sibmaks
 * @since 0.0.4
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArrayConverter {

    /**
     * Convert string array to string
     *
     * @param values array of string
     * @return string representation of array
     */
    public static String convert(String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        var builder = new StringBuilder();

        builder.append(values.length).append('\n');
        for (var i = 0; i < values.length; i++) {
            var item = values[i];
            builder.append(item.length()).append(' ').append(item);

            if (i < values.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    /**
     * Convert string to string array
     *
     * @param values string representation of array
     * @return array of string
     */
    public static String[] convert(String values) {
        if (values == null) {
            return new String[0];
        }
        var lines = values.split("\n", 2);
        var count = Integer.parseInt(lines[0]);
        var remaining = lines[1];

        var dependencies = new String[count];
        var index = 0;
        var pos = 0;

        while (index < count && pos < remaining.length()) {
            var spaceIndex = remaining.indexOf(' ', pos);
            var length = Integer.parseInt(remaining.substring(pos, spaceIndex));
            pos = spaceIndex + 1;

            dependencies[index++] = remaining.substring(pos, pos + length);

            pos += length + 1;
        }

        return dependencies;
    }

}

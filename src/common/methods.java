package common;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class methods {

    /**
     * Returns an array of integers from a string. Commonly used for parsing arrays from user input.
     * <p>
     * dependencies: org.apache.commons.lang3.StringUtils
     *
     * @param inputString String to be parsed <p>( ex. scanner.nextLine(); )
     * @param startDelimiter First delimiter ( ex. ' { ' )
     * @param endDelimiter Second delimiter ( ex. ' } ' )
     * @param splitAt Split the string around matches of the delimiter ( ex. ' , ' or ' \n ' )
     * @return the array of integers parsed from the string
     */
    public static int[] getIntArrayFromString(String inputString, String startDelimiter, String endDelimiter, String splitAt) {
        String s = StringUtils.substringBetween(inputString, startDelimiter, endDelimiter);
        String[] arr = s.split(splitAt);

        if (arr.length == 1 && arr[0].isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(arr).mapToInt(string -> Integer.parseInt(string.trim())).toArray();
    }

    /**
     * Returns true if value is between min and max.
     *
     * @param value number to check
     * @param min lower bound
     * @param max upper bound
     * @param inclusive true if min and max are inclusive
     * @return true or false
     */
    public static boolean isBetween(int value, int min, int max, boolean inclusive) {
        if (inclusive) {
            return((value >= min) && (value <= max));
        }
        return((value > min) && (value < max));
    }

}

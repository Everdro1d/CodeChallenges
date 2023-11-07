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
     * @param delimiter1 First delimiter ( ex. ' { ' )
     * @param delimiter2 Second delimiter ( ex. ' } ' )
     * @param splitBy Split the string around matches of the delimiter ( ex. ' , ' or ' \n ' )
     * @return int[] the array of integers parsed from the string
     */
    public static int[] getArray(String inputString, String delimiter1, String delimiter2, String splitBy) {
        String s = StringUtils.substringBetween(inputString, delimiter1, delimiter2);
        String[] arr = s.split(splitBy);

        if (arr.length == 1 && arr[0].isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(arr).mapToInt(string -> Integer.parseInt(string.trim())).toArray();
    }



}

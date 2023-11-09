/*
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * Constraints:
 *  - 1 <= haystack.length, needle.length <= 10^4
 *  - haystack and needle consist of only lower-case English characters.
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 */

package leetCode.basicProgramming.basicImplementation;

public class indexOfFirstOccurrenceString {
    public static void main(String[] args) {
        String descriptor = "This program returns the index of the first occurrence of needle in haystack, " +
                "or -1 if needle is not part of haystack.\n" +
                "Enter your strings on separate lines: \nEx:\nstring1\nstring2";
        System.out.println(descriptor);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 =  sc.nextLine();
        sc.close();
        System.out.println(firstOccurrence(input1, input2));
    }

    public static int firstOccurrence(String haystack, String needle) {
        int output = -1;
        //constraints
        if ( (haystack+needle).matches("[a-z]") && !( (common.methods.isBetween(haystack.length(), 1, 10000, true) )
                || ( needle.length() > haystack.length()) ) )
        {
            return output;
        }

        //iterate through haystack
        for (int i = 0; i < haystack.length(); i++) {
            //if the current character matches the first character of needle
            if (haystack.charAt(i) == needle.charAt(0)) {
                //iterate through needle
                for (int j = 0; j < needle.length(); j++) {
                    // if statement for index out of bounds exception
                    if (i+j >= haystack.length()) {
                        break;
                    }

                    //if the current character of needle does not match the current character of haystack
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }

                    //if the current character of needle matches the current character of haystack
                    if (j == needle.length()-1) {
                        //return the index of the first character of needle
                        return i;
                    }
                }
            }
        }

        return output;
    }
}

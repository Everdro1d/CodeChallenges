/*
 * You are given two strings, word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end
 * of the merged string.
 *
 * 1 <= word1.length, word2.length <= 100
 */

package leetCode.basicProgramming.basicImplementation;

import java.util.Scanner;

public class mergeStringsAlternately {
    public static void main(String[] args) {
        String descriptor = "This program returns two merged words in alternating letter order." +
                "\nEnter your words on separate lines: \nEx:\nword1\nword2";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 =  sc.nextLine();
        sc.close();
        System.out.println(mergeAlternately(input1, input2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder output = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();

        if ( !(1 <= l1 && l1 <= 100 && 1 <= l2 && l2 <= 100) ) {
            return "Invalid input. Too large.";
        }

        //append the letters in alternating order
        for (int i = 0; i < Math.max(l1, l2); i++) {
            /* Math.max() returns the larger of the two values,
             * increasing i until it reaches the larger of the two lengths
             * however, if i exceeds the length of any word, we don't have any letters to add from that word,
             * so we ignore it and continue adding the letter from the longer word.
             */
            if (i < l1) {
                output.append(word1.charAt(i));
            }
            if ( i < l2 ) {
                output.append(word2.charAt(i));
            }
        }
        return output.toString();
    }
}

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
//Constraints:
//  - 1 <= s.length, t.length <= 5 * 10^4
//  - s and t consist of lowercase English letters.
//
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true
//
//Example 2:
//Input: s = "rat", t = "car"
//Output: false
//
//Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

package leetCode.basicProgramming.basicImplementation;

import java.util.Arrays;
import java.util.Scanner;
import static common.methods.*;

public class validAnagram {

    public static void main(String[] args) {
        String descriptor = "This program returns true if t is an anagram of s, and false otherwise." +
                "\nEnter your words on separate lines: \nEx:\nword1\nword2";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t =  sc.nextLine();
        sc.close();
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        //constraints
        if ( (s+t).matches("[a-z]") && !( (isBetween(s.length(), 1, 10000, true)
                || (common.methods.isBetween(t.length(), 1, 10000, true) ) )
                || ( t.length() > s.length()) ) )
        {
            return false;
        }

        return containsSameChars(s.toCharArray(), t.toCharArray());
    }

    public static boolean containsSameChars(char[] s, char[] t) {
        Arrays.sort(s);
        Arrays.sort(t);

        return Arrays.equals(s, t);
    }
}

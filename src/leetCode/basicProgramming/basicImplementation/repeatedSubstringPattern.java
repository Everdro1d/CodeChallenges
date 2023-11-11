//Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
//Example 1:
//Constraints:
//
//    1 <= s.length <= 104
//    s consists of lowercase English letters.


//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
//
//Example 2:
//
//Input: s = "aba"
//Output: false
//
//Example 3:
//
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

package leetCode.basicProgramming.basicImplementation;

import java.util.Scanner;
import static common.methods.*;

public class repeatedSubstringPattern {
    public static void main(String[] args) {
        String descriptor = "Given a string s, check if it can be constructed by taking a substring of it and appending" +
                " multiple copies of the substring together." +
                "\nEnter your words on separate lines: \nEx:\nabcabcabc";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(repeatedSubstring(s));
    }

    public static boolean repeatedSubstring(String s) {
        //constraints
        if ( s.matches("[a-z]") && !( isBetween(s.length(), 1, 10000, true) ) ) {
            return false;
        }
        int length = s.length();
        for (int i = length / 2; i >= 1; i--) {

            if (length % i == 0) {
                int repeats = length / i;
                String subString = s.substring(0, i);

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeats; j++) {
                    sb.append(subString);
                }

                if (sb.toString().equals(s)) {
                    System.out.println("The substring is: " + subString);
                    return true;
                }
            }
        }
        return false;
    }
}

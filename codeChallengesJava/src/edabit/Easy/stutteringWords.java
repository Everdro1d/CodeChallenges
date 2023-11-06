/* This program stutters the first two characters of a string.
 * Ex: incredible -> in... in... incredible?
 */
package edabit.Easy;

import java.util.Scanner;

public class stutteringWords {
    public static void main(String[] args) {
        System.out.println("This program stutters the first two characters of a string." +
                "\nEnter your string: Ex: incredible");
        String s = new Scanner(System.in).nextLine(); // Get the input string
        System.out.println(stutter(s)); // Print the stuttered string
    }

    private static String stutter(String s) {
        if (s.length() < 2) { // If the string is less than 2 characters long
            return "Invalid"; // Return "Invalid"
        }
        return s.substring(0, 2) + "... " + s.substring(0, 2) + "... " + s + "?"; // Return the stuttered string
    }   // The first two characters of the string, followed by "... ", followed by the first two characters of
        // the string again, followed by "... ", followed by the string, followed by "?"
}

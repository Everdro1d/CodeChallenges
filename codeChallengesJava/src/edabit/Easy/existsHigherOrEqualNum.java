/*
Write a function that returns true if there exists at least one number that is larger than or equal to n in an array.
    - Return false for an empty array {}.
Examples:
existsHigher({5, 3, 15, 22, 4}, 10) ➞ true

existsHigher({1, 2, 3, 4, 5}, 8) ➞ false

existsHigher({4, 3, 3, 3, 2, 2, 2}, 4) ➞ true

existsHigher({}, 5) ➞ false
*/
package edabit.Easy;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;
public class existsHigherOrEqualNum {
    public static void main(String[] args) {
        System.out.println
            ("This program checks if there exists at least one number that is larger than or equal to n in an array." +
                    "\nEnter your numbers: Ex: {5, 3, 15, 22, 4}, 10");
        String input = scannerStuff();
        System.out.println(existsHigherOrEqual(getArray(input), getN(input)));
    }

    private static String scannerStuff() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        return s;
    }

    private static int[] getArray(String inputString) {
        String s = StringUtils.substringBetween(inputString, "{", "}"); // Get the string between the curly braces
        String[] arr = s.split(","); // Split the string by commas

        if (arr.length == 1 && arr[0].isEmpty()) {
            return new int[0];
        }
        // Convert the array of strings to an array of ints
        return Arrays.stream(arr).mapToInt(string -> Integer.parseInt(string.trim())).toArray();
    }

    private static int getN(String inputString) {
        // Get the string after the last comma
        String s = StringUtils.substringAfterLast(inputString, ",");
        return Integer.parseInt(s.trim());
    }

    private static boolean existsHigherOrEqual(int[] arr, int n) {
        for (int i : arr) {// For each element in the array arr
            if (i >= n) {
                return true;
            }
        }
        return false;
    }
}

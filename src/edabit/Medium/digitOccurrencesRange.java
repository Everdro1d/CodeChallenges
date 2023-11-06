/* Write a function that counts the number of times a specific digit occurs in a range (inclusive).
 *     - Ranges can be negative
 *     - min <= max
 * The function will look like:
 * digitOccurrences(min, max, digit)
 * Examples:
 * digitOccurrences(51, 55, 5) ➞ 6
 * [51, 52, 53, 54, 55] : 5 occurs 6 times
 *
 * digitOccurrences(1, 8, 9) ➞ 0
 *
 * digitOccurrences(-8, -1, 8) ➞ 1
 *
 * digitOccurrences(71, 77, 2) ➞ 1
 */

package edabit.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class digitOccurrencesRange {
    public static void main(String[] args) {
        System.out.println("This program counts the number of times a specific digit occurs in a range (inclusive)." +
                "\nEnter your numbers: Ex: 51, 55, 5");
        String input = scannerStuff();
        System.out.println(digitOccurrences(getDigitsArray(input)));
    }

    private static String scannerStuff() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        return s;
    }

    private static int[] getDigitsArray(String s) {
        String[] arr = s.split(", ");
        if (arr.length == 1 && arr[0].isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(arr).mapToInt(string -> Integer.parseInt(string.trim())).toArray();
    }

    private static int digitOccurrences(int[] arr) {
        int count = 0;
        for (int i = arr[0]; i <= arr[1]; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                int k = Character.getNumericValue(s.charAt(j));
                if (k == arr[2]) { //charAt returns an ASCII value, so we need to grab the number instead
                    count++;
                }
            }
        }
        return count;
    }
}

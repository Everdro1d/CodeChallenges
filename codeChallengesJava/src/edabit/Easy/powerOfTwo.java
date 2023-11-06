/*
Write a function that returns true if an integer can be expressed as a power of base value 2 and false otherwise.

Examples:
powerOfTwo(32) ➞ true

powerOfTwo(1) ➞ true

powerOfTwo(-7) ➞ false

powerOfTwo(18) ➞ false
*/

package edabit.Easy;

import java.util.Scanner;

public class powerOfTwo {
    public static void main(String[] args) {
        System.out.println("Test whether an integer can be expressed as a power of 2.\n Enter an integer:");
        Scanner sc = new Scanner(System.in); //Create a Scanner object
        int n = sc.nextInt(); // Read user input and set to n
        System.out.println(powerOfTwo(n)); // Output result of powerOfTwo function
        sc.close(); // Close Scanner object
    }
    // Function to check if an integer can be expressed as a power of base value 2
    public static boolean powerOfTwo(int n) {
        // This comes first so that the function does not continue if n is 0
        if (n == 0) {
            return false;
        }
        // This loop will continue dividing n by 2 until n is 1
        while (n != 1) {
            if (n % 2 != 0) { // If the remainder is not 0, n is not a power of 2
                return false;
            }
        n = n / 2; // Divide n by 2 and repeat the loop
        }
        return true;
    }
}

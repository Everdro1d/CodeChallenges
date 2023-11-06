/* This program finds the number of dots in a triangle. (Triangular Number Sequence)
 * Ex: 5
 * The number of dots in the triangle is 15
 */
package edabit.Easy;

import java.util.Scanner;

public class triangularNumberSequence {
    public static void main(String[] args) {
        System.out.println("This program finds the number of dots in a triangle. (Triangular Number Sequence)" +
                "\nEnter your number: Ex: 5");
        int s = new Scanner(System.in).nextInt(); // Get the input number
        System.out.println("The number of dots in the triangle is: " + dotsInTriangle(s)); // Print the number of dots in the triangle
    }

    public static int dotsInTriangle(int n) {
        return (n * (n + 1)) / 2;
    }
}

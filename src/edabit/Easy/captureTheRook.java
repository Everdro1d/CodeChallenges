/*
Write a function that returns true if two rooks can attack each other, and false otherwise.
    - Assume no blocking pieces.
    - Two rooks can attack each other if they share the same row (letter) or column (number).
Examples:
canCapture(["A8", "E8"]) ➞ true

canCapture(["A1", "B2"]) ➞ false

canCapture(["H4", "H3"]) ➞ true

canCapture(["F5", "C8"]) ➞ false
*/

package edabit.Easy;

import java.util.Scanner;

public class captureTheRook {
    public static void main(String[] args) {
        System.out.println("This program checks if two rooks can attack each other.\nEnter the positions of the rooks: Ex: A8 E8");
        Scanner sc = new Scanner(System.in);
        String[] rooks = sc.nextLine().split(" ");
        System.out.println(canCapture(rooks));
        sc.close();
    }
    public static boolean canCapture(String[] rooks) { //Tales a string array called rooks.
        return rooks[0].charAt(0) == rooks[1].charAt(0) || rooks[0].charAt(1) == rooks[1].charAt(1);
        /*
         Returns true if the first character of the first element of the array is equal to the first character of
         the second element of the array, or if the second character of the first element of the array is equal
         to the second character of the second element of the array.
        */
    }
}

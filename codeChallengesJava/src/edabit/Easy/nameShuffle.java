/*
Create a method that accepts a string (of a person's first and last name)
and returns a string with the first and last name swapped.

Examples:
nameShuffle("Donald Trump") ➞ "Trump Donald"

nameShuffle("Rosie O'Donnell") ➞ "O'Donnell Rosie"

nameShuffle("Seymour Butts") ➞ "Butts Seymour"
*/
package edabit.Easy;

import java.util.Scanner;

public class nameShuffle {
    public static void main(String[] args) {
        System.out.println("This program swaps the first and last name of a person.\nEnter a name: Ex: Donald Trump");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(nameShuffle(s));
        sc.close();
    }

    public static String nameShuffle(String s) {
        String[] arr = s.split(" "); // split the string into an array at the character " ".
        return arr[1] + " " + arr[0]; // Returns the second element of the array, followed by the first element.
    }
}

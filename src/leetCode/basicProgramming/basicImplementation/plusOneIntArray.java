//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
//The digits are ordered from most significant to the least significant in left-to-right order.
//The large integer does not contain any leading 0's.

//Increment the large integer by one and return the resulting array of digits.

//Constraints:
//  - 1 <= digits.length <= 100
//  - 0 <= digits[i] <= 9
//  - digits does not contain any leading 0's.

//Example 1:
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//
//Example 2:
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//
//Example 3:
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].


package leetCode.basicProgramming.basicImplementation;

import java.util.Arrays;
import java.util.Scanner;

import static common.methods.*;

public class plusOneIntArray {

    public static void main(String[] args) {
        String descriptor = "This program adds a large integer in the form of an array plus one." +
                "\nEnter your number as an array: Ex:\n[2,7,1,5]";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(removeWhitespaces(Arrays.toString(plusOne(input))));
    }

    public static int[] plusOne(String input) {
        int[] nums = getIntArrayFromString(input, "[", "]", ",");

        // constraints check
        if (!(isBetween(nums.length, 1, 100, true)) || (nums[0] == 0)
                || !(Arrays.stream(nums).allMatch(i -> isBetween(i, 0, 9, true)))) {
            return new int[0];
        }

        // starting from the end of the array, if the number is less than 9, increment it and return the array
        // [5,8]->[5,9]
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 9 ) {
                nums[i]++;
                return nums;
            }
            nums[i] = 0;
        }

        // if the array is all 9's, above will return all 0's then
        // create a new array with the length of the original array + 1, and set the first element to 1
        // [9,9]->[1,0,0]
        nums = new int[nums.length + 1];
        nums[0] = 1;

        return nums;
    }
}

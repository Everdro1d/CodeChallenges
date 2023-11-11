//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.
//Constraints:
//  - 1 <= nums.length <= 10^4
//  - -2^31 <= nums[i] < 2^31

package leetCode.basicProgramming.basicImplementation;

import java.util.Arrays;
import java.util.Scanner;
import static common.methods.*;

public class movingZeroes {
    public static void main(String[] args) {
        String descriptor = "Given an integer array nums, move all 0's to the end of it while maintaining the " +
                "relative order of the non-zero elements. \nExample: \n[0,1,0,3,12]";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        sc.close();
        int[] nums = getIntArrayFromString(input1, "[", "]", ",");

        System.out.println(moveZeroes(nums));
    }

    public static String moveZeroes(int[] nums) {
        // constraints
        if (nums.length < 1 || nums.length > 10000) {
            return "Invalid input: nums.length must be between 1 and 10^4";
        }

        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0, j = 0; i < length; i++) {
            if (nums[i] != 0) {
                result[j] = nums[i];
                j++;
            } else {
                result[length - (length - j)] = nums[i];
            }
        }

        return removeWhitespaces(Arrays.toString(result));
    }

}

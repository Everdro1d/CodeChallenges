/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Constraints:
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.

 */

package leetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;
import static common.methods.*;

public class twoSumBrute {
    public static void main(String[] args) {
        String descriptor = "This program returns indices of the two numbers such that they add up to target." +
                "\nEnter your numbers: Ex:\n[2,7,11,15]\n9";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int target =  sc.nextInt();
        sc.close();
        System.out.println(Arrays.toString(twoSum(getIntArrayFromString(input, "[", "]", ","), target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    sum[0] = i;
                    sum[1] = j;
                }
            }
        }
        return sum;
    }


}

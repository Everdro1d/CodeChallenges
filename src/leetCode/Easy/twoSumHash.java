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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twoSumHash {
    public static void main(String[] args) {
        String descriptor = "This program returns indices of the two numbers such that they add up to target." +
                "\nEnter your numbers: Ex:\n[2,7,11,15]\n9";
        System.out.println(descriptor);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int target =  sc.nextInt();
        sc.close();
        System.out.println(Arrays.toString(twoSum(common.methods.getArray(input, "[", "]", ","), target)));
    }

    public static int[] twoSum(int[] nums, int target) { //uses hash map
        Map<Integer, Integer> numsMap = new HashMap<>(); //key = number, value = index
        int numsLength = nums.length;                    //ex. [2,7,11,15] -> {2=0, 7=1, 11=2, 15=3}

        for(int i = 0; i < numsLength; i++) {            //iterate through nums
            int complement = target - nums[i];           //complement = target - current number
            if(numsMap.containsKey(complement)) {                //if complement is in numsMap
                return new int[] { numsMap.get(complement), i }; //return indices of complement and current number
            }
            numsMap.put(nums[i], i);                     //put current number and index into numsMap
        }                                                //repeat until target is found, else return empty array

        return new int[0];
    }
}

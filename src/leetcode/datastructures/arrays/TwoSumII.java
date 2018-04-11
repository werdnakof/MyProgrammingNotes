package leetcode.datastructures.arrays;

import java.util.Arrays;

public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[0];

        int left = 0, right = nums.length-1;

        long sum;

        while(left < right) {
            sum = nums[left] + nums[right];

            if(sum == target) return new int[] {left+1, right+1};

            if(sum > target) right--;
            else left++;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 40}, 18)));
    }
}

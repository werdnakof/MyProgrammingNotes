package leetcode.datastructures.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];

        int pro = 1;
        for(int i = 0; i < nums.length; i++) {
            results[i] = pro;
            pro *= nums[i];
        }

        pro = nums[nums.length-1];
        for(int i = nums.length - 2; i >= 0; i--) {
            results[i] *= pro;
            pro *= nums[i];
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{9, 0, -2})));
    }
}

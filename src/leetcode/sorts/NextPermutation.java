package leetcode.sorts;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;

        int current = nums.length-1;

        while(current > 0) {
            if(nums[current-1] < nums[current]) {
                int toSwap = nums.length-1;
                while(toSwap >= current) {
                    if(nums[current-1] < nums[toSwap]) {
                        swap(nums, toSwap, current-1);
                        break;
                    }
                    toSwap--;
                }
                break;
            }
            current--;
        }

        reverseSort(nums, current, nums.length-1);
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void reverseSort(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 2, 2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}

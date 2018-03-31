package sorting;

import java.util.*;

public class Sorts {
    public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void insertion(int[] nums) {
        for(int pos = 1; pos < nums.length; pos++) {
            int shift = pos;
            while (shift-1 >= 0) {
                if(nums[shift] < nums[shift-1])
                    swap(nums, shift, shift-1);
                shift--;
            }
        }
    }

    public static void selection(int[] nums) {
        for(int pos = 0; pos < nums.length; pos++) {
            int min = Integer.MAX_VALUE;
            int minPos = pos;
            for(int j = pos; j < nums.length; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    minPos = j;
                }
            }
            swap(nums, pos, minPos);
        }
    }


    public static void main(String[] args) {
    }
}

package leetcode.sorts;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1) return 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = 0;
        int right = nums.length-1;

        while (sorted[left] == nums[left] || sorted[right] == nums[right]) {

            if(left >= right) break;

            if(sorted[left] == nums[left]) {
                left++;
            }
            if(sorted[right] == nums[right]) {
                right--;
            }
        }

        return left==right ? 0 : right-left+1;
    }

    public static int findUnsortedSubarray_leetcodeSolution(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0 || nums.length == 1) return 0;

        int max = Integer.MIN_VALUE;
        int end = -2;
        //iterate from beginning of array
        //find the last element which is smaller than the last seen max from
        //its left side and mark it as end
        for(int i = 0; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max)
                end = i;
        }

        int min = Integer.MAX_VALUE;
        int begin = -1;
        //iterate from end of array
        //find the last element which is bigger than the last seen min from
        //its right side and mark it as begin
        for(int i = nums.length - 1; i >= 0; i --){
            min = Math.min(min, nums[i]);
            if(nums[i] > min)
                begin = i;
        }

        return end - begin + 1;
    }
        public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {7, 4, 5, 5, 6, 2}));
    }
}

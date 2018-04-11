package leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length < 3) return result;

        for(int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i-1] == nums[i]) continue;

            twoSum(nums, -nums[i], i, result);
        }

        return result;
    }

    public static void twoSum(int[] nums,
                               int target,
                               int skipInd,
                               List<List<Integer>> result) {

        if(nums == null || nums.length < 2) return;

        int left = skipInd+1, right = nums.length-1;

        long sum;

        while(left < right) {

            sum = nums[left] + nums[right];

            if(sum == target) {
                result.add(
                    Arrays.asList(nums[skipInd], nums[left], nums[right]));
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
                continue;
            }

            if(sum > target) right--;
            else left++;
        }
    }

    public static void main(String[] args) {
        threeSum(new int[] {-4, 0, 0, 2, 2, 4, 4})
                .forEach(System.out::println);
        System.out.println();
    }
}

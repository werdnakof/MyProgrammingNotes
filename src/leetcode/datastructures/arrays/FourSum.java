package leetcode.datastructures.arrays;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        results = new ArrayList<>();
        Arrays.sort(nums);
        fourSum(nums, target, 0, new ArrayList<>());
        return results;
    }

    static List<List<Integer>> results;

    public static void fourSum(int[] nums,
                               int target,
                               int pos,
                               List<Integer> list) {

        Integer sum = list.stream().mapToInt(Integer::intValue).sum();

        if(list.size() == 4 && sum == target) {
            results.add(new ArrayList<>(list));
        }else if(pos < nums.length) {

            if(pos < nums.length-1 && nums[pos] == nums[pos+1]) {
                while(pos < nums.length-1 && nums[pos] == nums[pos+1]) pos++;
                pos--;
            }

            if(list.size() < 4) {
                list.add(nums[pos]);
                fourSum(nums, target, pos+1, list);
                list.remove(list.size()-1);
            }

            fourSum(nums, target, pos+1, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {-2, -1, 0, 0 ,0, 0,1, 2}, 0));
    }
}

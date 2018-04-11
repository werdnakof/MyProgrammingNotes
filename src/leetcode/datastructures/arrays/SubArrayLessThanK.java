package leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public static int numSubarrayProductLessThanK_TooSlow(int[] nums, int k) {

        int count = 0;
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();

            if(nums[i] < k) {
                tmp.add(nums[i]);
                count++;

                for(Integer j : cur) {
                    if(j * nums[i] < k) {
                        tmp.add(nums[i]*j);
                        count++;
                    }
                }
            }
            cur = tmp;
        }

        return count;
    }


    static int count;
    public static int numSubarrayProductLessThanK_StackOverFlow(int[] nums, int k) {
        count = 0;
        search(nums, k, 0);
        return count;
    }

    public static List<List<Integer>> search(int[] nums, int K, int pos) {
        if(pos == nums.length) return new ArrayList<>();

        List<List<Integer>> current = search(nums, K, pos + 1);

        List<List<Integer>> toReturn = new ArrayList<>();

        if(nums[pos] < K) {
            toReturn.add(Arrays.asList(nums[pos]));
            count++;
        }

        for(List<Integer> ls: current) {
            if(multi(ls) * nums[pos] < K) {
                List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[pos]));
                tmp.addAll(ls);
                toReturn.add(tmp);
                count++;
            }
        }

        return toReturn;
    }

    public static int multi(List<Integer> list) {
        if(list.size() == 0) return 0;
        return list.stream().reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
//        List<List<Integer>> lists = new ArrayList<>();
//        search(new int[] {10, 5, 2, 6}, 100, lists, 0);
//        for(List<Integer> k: lists) {
//            System.out.println(k);
//        }
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }
}
//[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
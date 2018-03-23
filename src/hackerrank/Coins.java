package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Coins {
    static private HashMap<Long, Integer> store = new HashMap();

    static long getWays(long target, long[] nums){
        Arrays.sort(nums);
        return getWays2(target, nums);
    }

    static long getWays2(long target, long[] nums) {

        if(store.containsKey(target)) return store.get(target);

        int idx = 0;
        int ways = 0;
        Long va;

        HashMap<Long, Boolean> checked = new HashMap();

        while(idx < nums.length && nums[idx] <= target) {

            va = nums[idx++];
            Long remain = target - va;
            if(checked.getOrDefault(remain, false)) continue;
            if(remain==0) ways += 1;
            if(remain > 0) ways += getWays2(remain, nums);
            checked.put(va, true);
        }

        store.put(target, ways);
        return ways;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        long[] c = new long[m];
//        for(int c_i=0; c_i < m; c_i++){
//            c[c_i] = in.nextLong();
//        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        System.out.println (getWays(10, new long[] {2, 3, 5, 6}));
    }
}

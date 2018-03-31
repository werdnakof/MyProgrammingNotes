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

    static int array2D(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[rows/3][cols/3];

        int largest = Integer.MIN_VALUE;
        for(int r = 0; r < rows/3; r++) {
            for(int c = 0; c < cols/3; c++) {
                int top = arr[r][c] + arr[r][c+1] + arr[r][c+2];
                int mid = arr[r+1][c+1];
                int bot = arr[r+2][c] + arr[r+2][c+1] + arr[r+2][c+2];
                result[r][c] = top + mid + bot;
                if(result[r][c] > largest) largest = result[r][c];
            }
        }

        return largest;
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
//        System.out.println (getWays(10, new long[] {2, 3, 5, 6}));
        System.out.println (Integer.MAX_VALUE);
    }
}

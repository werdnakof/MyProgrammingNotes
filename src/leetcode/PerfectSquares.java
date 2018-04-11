package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public static int numSquares_leetcodeSolution(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    static List<Integer> squares;
    public static int numSquares(int n) {
        squares = new ArrayList<>();

        // O(sqrt(n))
        for(int i = 1; i*i <= n; i++) squares.add(i*i);

        int min = Integer.MAX_VALUE;
        // O(sqrt(n) * sqrt(n)) == O(n)
        for(int i = squares.size()-1; i >= 0; i--) {
            int tmp = search(n, i);
            min = tmp < min ? tmp : min;
        }

        return min;
    }

    static int search(int target, int pos) {
        if(target == 0) return 0;
        if(target == 1) return 1;

        int multi = target / squares.get(pos);
        int remain = target - (squares.get(pos) * multi);
        pos--;

        for(int i = pos-1; i >= 0; i-- ) {
            int square = squares.get(i);
            int t = target / square;
            int r = target - (square * t);
            if(r < remain && t < multi) {
                multi = t;
                remain = r;
                pos = i;
            }
        }

        return multi + search(remain, pos);
    }


    public static void main(String[] args) {
        System.out.println(numSquares_leetcodeSolution(43));
    }
}

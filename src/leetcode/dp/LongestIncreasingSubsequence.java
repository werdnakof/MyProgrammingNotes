package leetcode.dp;

public class LongestIncreasingSubsequence {

    static int[] ns;
    public static int lengthOfLIS(int[] nums) {
        ns = nums;
        int max = 0;
        int[] mem = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            search(i, mem);
            if(mem[i] > max) max = mem[i];
        }
        return max;
    }

    public static void search(int pos, int[] mem) {
        if(pos == ns.length-1) {
            mem[pos] = 1;
        } else {
            int max = 0;
            for(int i = pos+1; i < ns.length; i++) {
                if(ns[pos] < ns[i]) {
                    if(mem[i] > max) max = mem[i];
                }
            }
            mem[pos] = 1 + max;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }
}

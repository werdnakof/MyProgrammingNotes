package leetcode.dp;

public class NumberOfSubarraysWithBoundedMaximum {
    public static int numSubarrayBoundedMax(int[] nums, int L, int R) {
        return count(nums, R) - count(nums, L-1);
    }

    public static int count(int[] nums, int bound) {
        int count = 0, current = 0;
        for(int n: nums) {
            current = n <= bound ? current + 1 : 0;
            count += current;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = numSubarrayBoundedMax(
                new int[] {73,55,36,5,55,14,9,7,72,52},
                32, 69
        );

        System.out.println(count);
    }
}

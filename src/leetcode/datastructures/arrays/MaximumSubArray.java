package leetcode.datastructures.arrays;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];
        int minPos = 0;

        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];

            if(sum[i] > max) {
                max = sum[i];
            }

            if(sum[i] - sum[minPos] > max) {
                max = sum[i] - sum[minPos];
            }

            if(sum[i] < sum[minPos]) {
                minPos = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2}));
    }
}

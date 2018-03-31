package leetcode.dp.bottomup;

//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubArray {

    static int currentMax;
    public int maxProduct(int[] nums) {
        currentMax = Integer.MIN_VALUE;
        maxProduct(nums, 0);
        return currentMax;
    }

    /**
     * O(n^2)
     * @param nums
     * @param pos
     */
    public void maxProduct(int[] nums, int pos) {
        if(pos == nums.length) return;

        int current = 1;
        for(int i = pos; i < nums.length; i++) {
            current *= nums[i];
            if(current > currentMax) {
                currentMax = current;
            }
        }
        maxProduct(nums, pos+1);
    }


    /**
     * O(N)
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        if(nums.length == 1) return nums[0];

        int imax = nums[0];
        int imin = nums[0];

        int r = nums[0];

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct2(new int[] {-4,-3,-2}));

    }
}

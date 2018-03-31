package leetcode.sorts;

import java.util.Arrays;

public class WiggleSortII {
    public static void wiggleSort(int[] nums) {

        if(nums.length == 0 || nums.length == 1) return;

        int[] result = nums.clone();
        Arrays.sort(result);

        int f = 0;
        int b = nums.length - 1;

        int index = 1;
        while(f < b) {
            nums[index-1] = result[f++];
            if(f < b) nums[index] = result[b--];
            index+=2;
        }
    }

    public static void main(String[] args) {
        int[] g = new int[] {1, 3, 2, 2, 3, 1};
        wiggleSort(g);
        System.out.println(Arrays.toString(g));
    }
}

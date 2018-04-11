package leetcode.datastructures.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n];

        int ind1 = 0, ind2 = 0, mind = 0;

        while(ind1 < m || ind2 < n) {
            if(ind1 < m && ind2 < n) {
                if(nums1[ind1] < nums2[ind2]) {
                    merge[mind++] =  nums1[ind1++];
                } else {
                    merge[mind++] =  nums2[ind2++];
                }
            } else if(ind1 < m) {
                merge[mind++] =  nums1[ind1++];
            } else if(ind2 < n) {
                merge[mind++] =  nums2[ind2++];
            }
        }

        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = merge[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {5, 7, 9, 0, 0, 0};
        int[] nums2 = new int[] {4, 6, 8, 0, 0, 0};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

package leetcode.datastructures.arrays;

import java.util.Arrays;

public class MaximumSwap {
    public static int maximumSwap(int num) {
        String number = String.valueOf(num);

        max = num;
        maxSwap = 1;

        search(number, 0, 0);
        return max;
    }

    public static int max;
    public static int maxSwap;
    public static void search(String num, int swap, int pos) {
        if(swap == maxSwap || pos == num.length()) {
            if(Integer.valueOf(num) > max) max = Integer.valueOf(num);
        } else {
            for(int i = pos+1; i < num.length(); i++) {
                if((int) num.charAt(pos) > (int) num.charAt(i)) continue;
                search(swap(num, pos, i), swap+1, pos);
            }
            search(num, swap, pos+1);
        }
    }

    public static String swap(String numbers, int i, int j) {
        StringBuilder sb = new StringBuilder(numbers);
        char ci = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ci);
        return sb.toString();
    }

    /**
     * O(n) time
     * O(1) space
     * @param num
     * @return
     */
    public int maximumSwap_leetcode(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(98368));
    }
}

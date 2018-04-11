package leetcode.datastructures.arrays;

import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        if(n == 0) return spiral;

        int rStart = 0;
        int rEnd = n-1;
        int cStart = 0;
        int cEnd = n-1;

        int num = 1;
        while(rStart <= rEnd && cStart <= cEnd) {
            for(int i = cStart; i <= cEnd; i++) {
                spiral[rStart][i] = num++;
            }
            rStart++;

            for(int i = rStart; i <= rEnd; i++) {
                spiral[i][cEnd] = num++;
            }
            cEnd--;

            for(int i = cEnd; i >= cStart; i--) {
                spiral[rEnd][i] = num++;
            }
            rEnd--;

            for(int i = rEnd; i >= rStart; i--) {
                spiral[i][cStart] = num++;
            }
            cStart++;
        }

        return spiral;
    }

    public static void main(String[] args) {
        int[][] spiral = generateMatrix(3);
        System.out.println(Arrays.toString(spiral[0]));
        System.out.println(Arrays.toString(spiral[1]));
        System.out.println(Arrays.toString(spiral[2]));
    }
}

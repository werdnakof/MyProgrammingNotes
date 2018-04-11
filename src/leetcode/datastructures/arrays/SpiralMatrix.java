package leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;

        int rStart = 0;
        int rEnd = matrix.length-1;
        int cStart = 0;
        int cEnd = matrix[0].length-1;

        while(rStart <= rEnd && cStart <= cEnd) {
            for(int i = cStart; i <= cEnd; i++) {
                list.add(matrix[rStart][i]);
            }
            rStart++;

            for(int i = rStart; i <= rEnd; i++) {
                list.add(matrix[i][cEnd]);
            }
            cEnd--;

            if(rEnd < rStart) continue;

            for(int i = cEnd; i >= cStart; i--) {
                list.add(matrix[rEnd][i]);
            }
            rEnd--;

            if(cEnd < cStart) continue;

            for(int i = rEnd; i >= rStart; i--) {
                list.add(matrix[i][cStart]);
            }
            cStart++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                new int[] {2, 3},
        };
        List<Integer> list = spiralOrder(mat);
        list.stream()
                .forEach(System.out::println);
    }
}

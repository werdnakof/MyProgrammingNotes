package leetcode.datastructures.arrays;

public class Sear2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int col = matrix[0].length-1;
        int row = 0;
        while(row < matrix.length && col > 0) {
            if(matrix[row][col] == target) return true;
            if(target < matrix[row][col]) col--;
            else row++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
            new int[]{1,   4,  7, 11, 15},
            new int[]{2,   5,  8, 12, 19},
            new int[]{3,   6,  9, 16, 22},
            new int[]{10, 13, 14, 17, 24},
            new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(mat, 17));
    }
}

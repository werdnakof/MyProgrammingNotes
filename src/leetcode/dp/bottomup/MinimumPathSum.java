package leetcode.dp.bottomup;

public class MinimumPathSum {
    static int[][] shortest;
    static int[][] currentGrid;
    public static int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        currentGrid = grid;
        shortest = new int[rows][cols];
        search(0, 0);
        return shortest[0][0];
    }

    public static void search(int row, int col) {
        int rows = shortest.length;
        int cols = shortest[0].length;

        if(row == rows-1 && col == cols-1) {
            shortest[row][col] = currentGrid[row][col];
        } else {
            if(col+1 < cols && shortest[row][col+1] == 0) search(row, col+1);
            if(row+1 < rows && shortest[row+1][col] == 0) search(row+1, col);

            int right = col+1 < cols ? shortest[row][col+1] : Integer.MAX_VALUE;
            int bottom = row+1 < rows ? shortest[row+1][col] : Integer.MAX_VALUE;

            shortest[row][col] = currentGrid[row][col] + Math.min(right, bottom);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[] {1, 3, 1, 5},
                new int[] {1, 5, 1, 4},
                new int[] {4, 2, 1, 3},
        };
        System.out.println(minPathSum(grid));
    }
}

package leetcode.datastructures.union_find;
public class FriendCircles {

    public static int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        int start = 1;
        for(int row = 0; row < M.length; row++) {
            for(int col = start; col < M.length; col++) {
                if(M[row][col] == 1) uf.union(row, col);
            }
            start++;
        }
        return uf.group.size();
    }

    public static void main(String[] args) {
        int[][] c = new int[][] {
                new int[] {1, 0, 0, 1},
                new int[] {0, 1, 1, 0},
                new int[] {0, 1, 1, 0},
                new int[] {1, 0, 0, 1}
        };
        System.out.println(findCircleNum(c));
    }
}

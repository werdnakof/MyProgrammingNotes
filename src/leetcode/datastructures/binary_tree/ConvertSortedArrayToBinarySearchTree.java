package leetcode.datastructures.binary_tree;

public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBST(int[] nums,
                                     int left,
                                     int right) {

        if(left == right) return new TreeNode(nums[left]);
        if(left > right) return null;

        int rootInd = right+(left-right)/2;
        TreeNode root = new TreeNode(nums[rootInd]);
        root.left = sortedArrayToBST(nums, left, rootInd-1);
        root.right = sortedArrayToBST(nums, rootInd+1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode tn = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }
}

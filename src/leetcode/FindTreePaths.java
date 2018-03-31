package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<String>> lists = dfs(new ArrayList<>(), root);

        List<String> result = new ArrayList<>();
        for(List<String> list: lists) {
            result.add(String.join("->", list));
        }

        return result;
    }

    public List<List<String>> dfs(List<String> list, TreeNode root) {

        if(root == null) return new ArrayList<>();

        list.add(String.valueOf(root.val));

        List<List<String>> result = new ArrayList<>();

        result.addAll(dfs(list, root.left));
        result.addAll(dfs(list, root.right));

        if(result.size() == 0) result.add(new ArrayList<>(list));

        list.remove(list.size()-1);

        return result;
    }
}

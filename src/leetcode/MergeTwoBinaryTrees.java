package leetcode;

import java.util.*;

public class MergeTwoBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

      public class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        int first = root1 == null ? 0 : root1.val;
        int second = root2 == null ? 0 : root2.val;
        int sum = first + second;

        TreeNode newRoot = new TreeNode(sum);

        if(root1 == null && root2 == null) {
            newRoot = null;
        } else if(root1 != null && root2 != null) {
            newRoot.left = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);
        }else if(root2 != null) {
            newRoot = new TreeNode(sum);
            newRoot.left = mergeTrees(null, root2.left);
            newRoot.right = mergeTrees(null, root2.right);
        }else {
            newRoot.left = mergeTrees(root1.left,null );
            newRoot.right = mergeTrees(root1.right, null);
        }

        return newRoot;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode result;

        if(l1 != null && l2 != null) {
            result = l1.val > l2.val ? new ListNode(l2.val) : new ListNode(l1.val);
            l2 = l2.next;
        } else if(l1 == null) {
            result = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            result = new ListNode(l1.val);
            l1 = l1.next;
        }

        result.next = mergeTwoLists(l1, l2);

        return result;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    public static List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int left = 0, right = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while(right < s.length()){
            char c = s.charAt(right);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            right++;

            while(counter == 0){
                if(right-left == t.length()) result.add(left);

                char tempc = s.charAt(left);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0)  counter++;
                }

                left++;
            }

        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for(int i=0; i!=len; i++) {
            int n = nums[i];
            ans = ans^n;
        }
        return ans;
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static int findKthLargest(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int maxPos = i;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                    maxPos = j;
                }
            }
            swap(nums, i, maxPos);
        }
        return nums[k-1];
    }


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        if(n == 1) {
            result.add("()");
            return result;
        }

        List<String> prev = generateParenthesis(n-1);

        LinkedHashSet<String> hprev = new LinkedHashSet<>();
        for(String str: prev) {
            hprev.add("(" + str + ")");
        }

        for(String str: prev) {
            hprev.add(str + "()");
            hprev.add("()" + str);
        }

        return new ArrayList<>(hprev);
    }

    public static List<String> generateParenthesis2(int n) {
        ArrayList<String> m=new ArrayList<>();
        generate(m, "", n, n);
        return m;
    }

    public static void generate(ArrayList m, String s, int l, int r){
        if(l==0 && r==0){
            m.add(s);
            return;
        }
        if(l>0) generate(m, s+"(",  l-1,  r);
        if(r>l) generate(m, s+")",  l,  r-1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());

        if(nums.length == 0) return result;

        int last = nums[nums.length-1];
        int[] subnums = Arrays.copyOfRange(nums, 0, nums.length-1);
        List<List<Integer>> subset = subsets(subnums);

        for(List<Integer> sub: subset) {
            List<Integer> tmp = new ArrayList<>(sub);
            tmp.add(last);
            if(sub.size() > 0) result.add(sub);
            result.add(tmp);
        }

        return result;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 1) {
            result.add(new ArrayList<>(Arrays.asList(nums[0])));
            return result;
        }

        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> sub = permute(skip(nums, i));
            for(List<Integer> s: sub) {
                s.add(nums[i]);
            }
            result.addAll(sub);
        }

        return result;
    }

    public static int[] skip(int[] nums, int idx) {
        int[] result = new int[nums.length-1];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == idx) continue;
            result[count++] = nums[i];
        }
        return result;
    }

    public int findTargetSumWays(int[] nums, int S) {
        return find(nums, new boolean[0], S);
    }

    public int find(int[] nums, boolean[] syms, int S) {
        if(nums.length == 0) return 0;
        int count = 0;

        if(syms.length < nums.length) {
            count += find(nums, expand(syms, true), S);
            count += find(nums, expand(syms, false), S);
            return count;
        }

        if(isSumOf(nums, syms, S)) count += 1;

        return count;
    }

    public boolean[] expand(boolean[] syms, boolean toAdd) {
        boolean[] result = new boolean[syms.length+1];
        for(int i = 0; i < syms.length; i++) {
            result[i] = syms[i];
        }
        result[result.length-1] = toAdd;
        return result;
    }

    public boolean isSumOf(int[] nums, boolean[] syms, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += syms[i] ? nums[i] : -nums[i];
        }
        return sum==target;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

    public int knapsack(int[] weights, int[] vals, int maxWeight) {
        int[][] table = new int[weights.length][maxWeight+1];

        for(int j = 0; j <= maxWeight; j++) {
            if(weights[0] <= j) table[0][j] = vals[0];
        }

        int max = table[0][maxWeight];

        for(int wIdx = 1; wIdx < weights.length; wIdx++) {
            for( int j = 0; j <= maxWeight; j++) {
                if(j < weights[wIdx]) {
                    continue;
                } else {
                    int remain = j-weights[wIdx];
                    table[wIdx][j] = Math.max(vals[wIdx] + table[wIdx-1][remain], table[wIdx-1][j]);
                }
            }
        }

        for(int i = 0; i < weights.length; i++) {
            if(table[i][maxWeight] > max) max = table[i][maxWeight];
        }

        return max;
    }

    public int targetSum(int[] nums, int S) {
        int[][] table = new int[nums.length][S+1];

        for(int j = 0; j <= S; j++) {
            if(nums[0] <= j) table[0][j] = nums[0];
        }

        int count = 0;

        for(int wIdx = 1; wIdx < nums.length; wIdx++) {
            for( int j = 0; j <= S; j++) {
                if(j < nums[wIdx]) {
                    continue;
                } else {
                    int remain = j-nums[wIdx];
                    int kept = nums[wIdx] + table[wIdx-1][remain];
                    int notKept = table[wIdx-1][j];

                    if(kept == S) count++;
                    if(notKept == S) count++;

                    table[wIdx][j] = Math.max(kept, notKept);
                }
            }
        }

        return count;
    }

    public static  void main(String[] args)  {
        MergeTwoBinaryTrees m = new MergeTwoBinaryTrees();

        System.out.println(m.targetSum(new int[] {1, 1, 1, 1, 1}, 3));
    }

//    public TreeNode merge(TreeNode newRoot, TreeNode root1, TreeNode root2) {
//
//    }
}

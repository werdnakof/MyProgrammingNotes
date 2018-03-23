package firecode;

import java.util.*;

public class Questions {
    public static String computeBinary(int val) {
        return Integer.toBinaryString(val);
    }

    public static String computeBinary2(int val) {
        if(val == 0) return "0";
        if(val == 1) return "1";
        return computeBinary2(val/2) + String.valueOf(val%2);
    }

    public static void rotateSquareImageCW(int[][] matrix) {
        transposeMatrix(matrix);
        invertMatrixVertically(matrix);
    }

    private static void transposeMatrix(int[][] matrix) {
        int tmp;
        int offset = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = offset; j < matrix[i].length; j++) {
                if(i == j) continue;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            offset++;
        }
    }

    private static void invertMatrixVertically(int[][] matrix) {
        int tmp;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < (matrix[0].length/2); j++) {
                int backIdx = (matrix[0].length - 1)-j;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][backIdx];
                matrix[i][backIdx] = tmp;
            }
        }
    }

    public ArrayList<Integer> levelorder(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<TreeNode> linkedList = new LinkedList();
        if(root!= null)linkedList.addLast(root);
        while (linkedList.size()>0){
            TreeNode tmp = linkedList.pollFirst();
            arrayList.add(tmp.data);
            if(tmp.left != null) linkedList.addLast(tmp.left);
            if(tmp.right != null) linkedList.addLast(tmp.right);
        }
        return arrayList;
    }

    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        if(head==null|n<=0) return null;
        ListNode forward = head;
        ListNode behind = head;
        int count = n-1;
        while(count > 0) {
            if(forward.next==null) return null;
            forward = forward.next;
            count--;
        }
        while(forward.next!=null) {
            forward = forward.next;
            behind = behind.next;
        }
        return behind;
    }

    /**
     * Write a method - isPowOfTwo to test whether or not a given positive integer is a power of 2. Your method should run in constant O(1) time and use O(1) space.
     * isPowOfTwo(5) ==> false
     * isPowOfTwo(8) ==> true
     *
     * @param num
     * @return
     */
    public static boolean isPowOfTwo(int num) {
        if(num == 1) return true;
        if(num % 2 != 0) return false;
        return isPowOfTwo(num/2);
    }
    public static boolean isPowOfTwo2(int num) {
        return (num & (num-1)) == 0;
    }

    /**
     * Given a singly-linked list, remove duplicates in the list and return head of the list. Target a worst case space complexity of O(n).
     * 1->2->2->4->3->1 ==> 1->2->4->3
     * 1 ==> 1
     * "" ==> ""
     * @param head
     * @return
     */
    public static ListNode removeDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode front = head;
        ListNode back = head;
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(head.data, true);

        if(front.next != null) {
            front = front.next;
        } else {
            return head;
        }

        while(front != null) {
            Boolean existed = map.getOrDefault(front.data, false);
            if(!existed) {
                map.put(front.data, true);
                front = front.next;
                back = back.next;
            } else {
                back.next = front.next;
                front = front.next;
            }
        }
        return head;
    }

    /**
     * Given a binary tree, write a method to find its height recursively.
     * @param root
     * @return
     */
    public static int findHeight(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = findHeight(root.left);
        int rightDepth = findHeight(root.right);
        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return depth + 1;
    }

    /**
     * insertAtPos(1<=>2<=>3,4,2) ==> 1<=>4<=>2<=>3
     * insertAtPos(1,4,3) ==> 1
     * @param head
     * @param data
     * @param pos
     * @return
     */
    public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        DoublyLinkedNode add = new DoublyLinkedNode(data);
        if(head == null) {
            if(pos > 1) return null;
            return add;
        }

        if(pos == 1) {
            head.prev = add;
            add.next = head;
            return add;
        }

        DoublyLinkedNode ret = head;
        DoublyLinkedNode tail = head;
        head = head.next;

        while(pos>2) {
            tail = tail.next;
            if(head != null) head = head.next;
            if(tail == null) return ret;
            pos--;
        }

        if(head!=null) {
            head.prev = add;
            add.next = head;
        }

        tail.next = add;
        add.prev = tail;

        return ret;
    }

    public DoublyLinkedNode insertAtPos2(DoublyLinkedNode head, int data, int pos) {
        // Add your code below this line. Do not modify any other code.
        if(pos<=1) {
            DoublyLinkedNode node = new DoublyLinkedNode(data);
            if(head!=null) {
                node.next = head;
                node.prev = head.prev;
                head.prev = node;
            }
            head = node;
        } else if(head!=null) {
            head.next = insertAtPos(head.next, data, pos-1);
        }
        return head;
        // Add your code above this line. Do not modify any other code.
    }

    /**
    Example:
            20
            /     \
            15     30
            /  \      \  diameter ==> 7
            14  18     35
            /  \    /
            17  19  32
     */
    public static int diameter(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = findHeight(root.left);
        int rightDepth = findHeight(root.right);
        return leftDepth + rightDepth + 1;
    }

    /**
     * Given a binary tree, write a method to perform the inorder traversal iteratively. Append the data of each node visited to an ArrayList. Return an empty Arraylist in the case of an empty tree.
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderItr(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        inorderItr(root, ret);
        return ret;
    }

    public void inorderItr(TreeNode root, ArrayList<Integer> arrayList) {
        if(root == null) return;
        inorderItr(root.left, arrayList);
        arrayList.add(root.data);
        inorderItr(root.right, arrayList);
    }

    /**
     * Given a List of Strings, write a method removeDuplicates that removes duplicate words from the List and returns an ArrayList of all the unique words. The returned ArrayList should be lexically alphabetically.
     *
     * Input: [Hi, Hello, Hey, Hi, Hello, Hey]
     * Output: [Hello, Hey, Hi]
     *
     * @param input
     * @return
     */
    public static ArrayList<String> removeDuplicates(List<String> input) {
        SortedMap<String, Boolean> store = new TreeMap<>();
        for(String word: input) {
            Boolean existed = store.getOrDefault(word, false);
            if(!existed) store.put(word, true);
        }
        return new ArrayList<>(store.keySet());
    }

    /**
     * Given a binary tree consisting of nodes with positive integer values,
     * write a method - maxSumPath that returns the maximum sum of data values obtained
     * by traversing nodes along a path between any 2 nodes of the tree.
     * The path must originate and terminate at 2 different nodes of the tree,
     * and the maximum sum is obtained by summing all the data values of the nodes traversed along this path.
     *
     * @param root
     * @return
     */
    public static int maxSumPath(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        return root.data + maxSum(root.left) + maxSum(root.right);
    }

    public static int maxSum(TreeNode root) {
        if(root == null) return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        return root.data + (left > right ? left : right);
    }

    /**
     * Rotate an array to the left by k positions without using extra space.k can be greater than the size of the array.
     * @param arr
     * @param k
     * @return
     */
    public static int[] rotateLeft(int[] arr, int k) {
        if(arr.length==1) return arr;
        int actual = k % (arr.length);
        flipByRange(arr, 0, arr.length-1);
        flipByRange(arr, arr.length-actual, arr.length-1);
        flipByRange(arr, 0, arr.length-actual-1);
        return arr;
    }

    public static int[] flipByRange(int[] arr, int start, int end) {
        int mid = (end-start)/2;
        int tmp;
        for(int i = 0; i <= mid; i++ ) {
            tmp = arr[start+i];
            arr[start+i] = arr[end-i];
            arr[end-i] = tmp;
        }
        return arr;
    }

    /**
     * Given an array of integers, find two numbers such that they sum up to a specific target.
     The method coupleSum should return the indices of the two numbers in the array, where index1 must be less than index2.
     Please note that the indices are not zero based, and you can assume that each input has exactly one solution. Target linear runtime and space complexity.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] coupleSum(int[] numbers, int target) {
        HashMap<Integer, Integer> store = new HashMap<>(); // number, position
        int count = 1;
        for(int i: numbers) {
            store.put(i, count);
            if(store.containsKey(target-i)) {
                return new int[] { store.get(target-i), count };
            }
            count++;
        }
        return null;
    }

    /**
     * Implement a method to insert a node into a
     Binary Search Tree
     . Return the root of the modified tree.
     * @param root
     * @param data
     * @return
     */
    public TreeNode insert(TreeNode root, int data) {
        if(root == null) return new TreeNode(data, null, null);

        if(data > root.data) {
            root.right = insert(root.right, data);
        }else if(data <= root.data) {
            root.left = insert(root.left, data);
        }
        return root;
    }

    /**
     * Given a
     Binary Search Tree
     , return the node with the minimum data.
     * @param root
     * @return
     */
    public TreeNode findMin(TreeNode root) {
        if(root == null || root.left == null) return root;
        return findMin(root.left);
    }

    /**
     * A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below :
     Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly in a cycle that does not include 1.
     * @param n
     * @return
     */
    static HashMap<Integer, Boolean> cacheIsHappyNumber = new HashMap<>();
    public static boolean isHappyNumber(int n) {
        int number = n;
        cacheIsHappyNumber.put(number, true);
        int remainder;
        int sum;
        while(true) {
            sum = 0;
            while(number > 0) {
                remainder = number % 10;
                sum += Math.pow(remainder, 2);
                number = number / 10;
            }
            if(sum == 1) return true;
            else if(cacheIsHappyNumber.containsKey(sum)) return false;
            else cacheIsHappyNumber.put(sum, true);
            number = sum;
        }
    }
    public static boolean isHappyNumber2(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int next(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }

    /**
     *  convert a binary tree into its mirror image and return the root node of the mirrored tree.
     * @param root
     * @return
     */
    public TreeNode mirror(TreeNode root) {
        if(root == null) return null;
        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static int[] selectionSortArray(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minElem = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minElem] > arr[j]){
                    minElem = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minElem];
            arr[minElem] = tmp;
        }
        return arr;
    }

    /**
     * Given two binary trees, determine if they are identical. If they are, return true otherwise return false.
     * @param root1
     * @param root2
     * @return
     */
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        LinkedList<TreeNode> ll1 = new LinkedList();
        LinkedList<TreeNode> ll2 = new LinkedList();
        ll1.add(root1);
        ll2.add(root2);

        while(ll1.size() > 0 || ll2.size() > 0) {

            TreeNode cu1 = ll1.poll();
            TreeNode cu2 = ll2.poll();

            if(cu1.data != cu2.data) return false;

            if(cu1.left != null && cu2.left != null) {
                ll1.addLast(cu1.left);
                ll2.addLast(cu2.left);
            } else if(cu1.left != null || cu2.left != null){
                return false;
            }

            if(cu1.right != null && cu2.right != null) {
                ll1.addLast(cu1.right);
                ll2.addLast(cu2.right);
            } else if(cu1.right != null || cu2.right != null){
                return false;
            }
        }
        return true;
    }
    // much better
    public boolean isIdentical2(TreeNode root1, TreeNode root2) {
        if ( root1 == null && root2 == null)
            return true;
        if ( root1 == null || root2 == null)
            return false;
        if ( root1.data != root2.data)
            return false;
        return isIdentical2( root1.left, root2.left) && isIdentical2( root1.right, root2.right);
    }

    public ListNode insertAtTail(ListNode head, int data) {
        ListNode toInsert = new ListNode(data);
        toInsert.next = toInsert;
        if(head == null) return toInsert;
        ListNode front = head;
        while(front.next != head) {
            front = front.next;
        }
        front.next = toInsert;
        toInsert.next = head;
        return head;
    }

    public static ArrayList<Integer> findSpiral(int[][] arr, int baseIdx) {
        ArrayList<Integer> ret = new ArrayList<>();
        return ret;
    }

    /**
     * Given a string, recursively compute a new string where the identical adjacent characters in the original string are separated by a "*".
     * @param s
     * @return
     */
    public static String insertPairStar(String s) {
        if(s == null) return null;
        if(s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        char backIdx = 0;
        char frontIdx = 1;
        while (frontIdx < s.length()) {
            sb.append(s.charAt(backIdx));
            if(s.charAt(backIdx) == s.charAt(frontIdx)) {
                sb.append('*');
            }
            backIdx++;
            frontIdx++;
        }
        sb.append(s.charAt(frontIdx-1));
        return sb.toString();
    }

    public  ArrayList<Integer> rangeList = new ArrayList<Integer>();
    public void printRange(TreeNode root, int a, int b) {

        if(root==null) return;

        if(root.left != null && checkRange(root.left.data, a, b)) printRange(root.left, a, b);

        if(checkRange(root.data, a, b)) rangeList.add(root.data);

        if(root.right != null && checkRange(root.right.data, a, b)) printRange(root.right, a, b);
    }

    public boolean checkRange(int num, int a, int b) {
        return num >= a && num <= b;
    }

    private static HashMap<String, Integer> pathMap = new HashMap<>();
    public static int countPaths(int m, int n){
        if(m == 1 || n == 1) return 1;

        String a = String.format("{%d} {%d}", m, n);

        if(!pathMap.containsKey(a)) {
            int count = 0;
            count += countPaths(m-1, n);
            count += countPaths(m, n-1);
            String b = String.format("{%d} {%d}", n, m);
            pathMap.put(a, count);
            pathMap.put(b, count);
        }

        return pathMap.get(a);
    }

    public static double pow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n >= 1) {
            return x * pow(x, n-1);
        } else {
            return 1 / pow(x, -n);
        }
    }

    public ArrayList<Integer> ancestorsList = new ArrayList<Integer>();
    public boolean printAncestors(TreeNode root, int nodeData) {
        if(root == null) return false;

        if(root.data == nodeData) return true;

        if(printAncestors(root.left, nodeData) || printAncestors(root.right, nodeData)) {
            ancestorsList.add(root.data);
            return true;
        }
        return false;
    }


    /**
     * A BST must satisfy the following conditions :
     * The left subtree of a node contains nodes with data < its data.
     * The right subtree of a node contains  nodes data > its data.
     * A node's left and right subtrees follow the above two conditions.
     * @param root
     * @return
     */
    public static boolean validateBSTItr(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validate(TreeNode root, int min, int max) {
        if(root == null) return true;

        if(root.data < min || root.data > max) return false;

        Boolean left = validate(root.left, min, root.data);
        Boolean right = validate(root.right, root.data, max);

        return left && right;
    }

    public static boolean validateBSTItr2(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        Stack<Integer> mins = new Stack<>();
        mins.push(Integer.MIN_VALUE);

        Stack<Integer> maxs = new Stack<>();
        maxs.push(Integer.MAX_VALUE);

        while(!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            int min = mins.pop();
            int max = maxs.pop();

            if(current.data < min || current.data >= max) return false;

            if(current.right != null) {
                nodes.push(current.right);
                mins.push(current.data + 1);
                maxs.push(max);
            }

            if(current.left != null) {
                nodes.push(current.left);
                mins.push(min);
                maxs.push(current.data);
            }

        }

        return true;
    }

    /**
     * Write a function to find the total number of half nodes in a binary tree.
     * A half node is a node which has exactly one child node. If there are no half nodes, return 0.
     * @param root
     * @return
     */
    public int numberOfHalfNodes(TreeNode root) {
//        if(root == null) return 0;
//        int left = numberOfHalfNodes(root.left);
//        int right = numberOfHalfNodes(root.right);
//        if(root.left != null && root.right == null) return left + 1;
//        if(root.left == null && root.right != null) return right + 1;
//        return left + right;

        if (root == null) return 0;
        int self = (root.left == null ^ root.right == null) ? 1 : 0;
        return self + numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
    }

    /**
     * Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints
     * in a clockwise spiral order and append the elements to an output ArrayList if Integers.
     * @param arr
     * @return
     */
    static ArrayList<Integer> spiralList;
    public static ArrayList<Integer> findSpiral(int[][] arr) {
        spiralList = new ArrayList<>();
        _findSpiral(arr, 0);
        return spiralList;
    }

    public static void _findSpiral(int[][] arr, int idx) {

        int m = arr[0].length-1-idx;
        int n = arr.length-1-idx;

        if(m < idx || n < idx) {
            return;

        }else if(m == idx && n == idx) {
            spiralList.add(arr[idx][idx]);
            return;

        }else if(m == idx && n > idx) {
            for(int i = idx; i <= n; i++) spiralList.add(arr[i][idx]);
            return;

        }else if(n == idx && m > idx) {
            for (int i = idx; i <= m; i++) spiralList.add(arr[idx][i]);
            return;
        }

        for(int i = idx; i <= m-1; i++) {
            spiralList.add(arr[idx][i]);
        }

        for(int i = idx; i <= n-1; i++) {
            spiralList.add(arr[i][m]);
        }

        for(int i = m; i >= idx+1; i--) {
            spiralList.add(arr[n][i]);
        }

        for(int i = n; i >= idx+1; i--) {
            spiralList.add(arr[i][idx]);
        }

        _findSpiral(arr, idx+1);
    }

    static HashMap<Character, Character> map;
    public static boolean isIsomorphic(String input1, String input2) {
        map =  new HashMap<>();
        int idx = 0;
        char c1, c2;
        while(idx < input1.length()) {
            c1 = input1.charAt(idx);
            c2 = input2.charAt(idx);

            if (!map.containsKey(c1) && !map.containsKey(c2)) {
                map.put(c1, c2);
                map.put(c2, c1);
            } else if (map.containsKey(c1) && map.get(c1) != c2 ||
                    map.containsKey(c2) && map.get(c2) != c1 ) {
                return false;
            }

            idx++;
        }
        return true;
    }

    public static ArrayList<ArrayList<Integer>> generatePascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        if(numRows == 0) return arr;
        arr.add(first);
        arr.get(0).add(1);
        return recur(arr,numRows-1);
    }

    public static ArrayList<ArrayList<Integer>> recur(ArrayList<ArrayList<Integer>> existing, int remain) {
        if(remain == 0) return existing;

        int back = 0;
        int front = 1;
        ArrayList<Integer> previous = existing.get(existing.size()-1);
        ArrayList<Integer> middle = new ArrayList<>();
        middle.add(1);
        while(front < previous.size()) {
            int b = previous.get(back++);
            int f = previous.get(front++);
            middle.add(b+f);
        }

        middle.add(1);
        existing.add(middle);
        return recur(existing, remain-1);
    }

    public static void main(String[] args) {
        for(ArrayList<Integer> j : generatePascalTriangle(4)) {
            System.out.println(j.toString());
        }
    }
}

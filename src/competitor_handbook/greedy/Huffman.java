package competitor_handbook.greedy;

import generics.TwoTuple;

import java.util.*;

/**
 * Huffman tree generation from string
 * based on the idea of building a table where each character has an encoding
 * None of the encoding cannot be a prefix of any others
 * see Page 74 of competitive handbook
 */
public class Huffman {

    static class Node {
        int weight;
        Character c;
        Node left;
        Node right;

        public Node(int weight) {
            this.weight = weight;
        }

        TwoTuple<Integer, Integer> getCode(Character c) {
            Node root = this;
            int count = 1;
            int value = 0;

            while(root != null) {
                if(root.left.c == c) break;
                value = value | 1;
                if(root.right.c == c) break;
                value = value << 1;
                count++;
                root = root.right;
            }

            return new TwoTuple<>(value, count);
        }
    }

    public static Node getHuffTree(String str) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for(Character i: str.toCharArray()) {
            frequency.put(i, frequency.getOrDefault(i, 0)+1);
        }

        List<Map.Entry<Character, Integer>> weights = new ArrayList<>(frequency.entrySet());

        Collections.sort(weights, Comparator.comparing(Map.Entry::getValue));

        Node root = new Node(weights.get(0).getValue());
        root.c = weights.get(0).getKey();

        for(int i = 1; i < weights.size(); i++) {

            Node left = new Node(weights.get(1).getValue());
            left.c = weights.get(i).getKey();

            Node newRoot = new Node(left.weight + root.weight);

            newRoot.right = root;
            newRoot.left = left;

            root = newRoot;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = getHuffTree("AABACDACA");
        for(char c: "ABCD".toCharArray()) {
            System.out.println(Integer.toBinaryString(root.getCode(c).first));
        }
    }
}

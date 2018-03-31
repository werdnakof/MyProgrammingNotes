package trie;

import java.util.ArrayList;

public class Trie {
    Trie[] alphabets = new Trie[26];
    boolean isWord;

    public Trie(boolean isWord) {
        this.isWord = isWord;
    }

    public void insert(Trie node, char character) {
        this.alphabets[character-'a'] = node;
    }

    static int[] contacts(String[][] queries) {
        ArrayList<Integer> results = new ArrayList<>();

        return new int[] {1};
    }
}

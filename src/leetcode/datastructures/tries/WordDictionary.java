package leetcode.datastructures.tries;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
public class WordDictionary {

    class Trie {
        public boolean isLeaf = false;
        public HashMap<Character, Trie> branches = new HashMap<>();
    }

    private Trie root = new Trie();

    /** Initialize your data structure here. */
    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        add(word, this.root);
    }

    private void add(String word, Trie node) {
        if(word.length() == 0) return;

        Character c = word.charAt(0);
        Trie trie = node.branches.getOrDefault(c, new Trie());
        node.branches.put(c, trie);

        if(word.length() == 1) {
            trie.isLeaf = true;
        } else {
            add(word.substring(1, word.length()), trie);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Trie node) {
        if(word.length() == 0) return node.isLeaf;

        Character c = word.charAt(0);

        if(c == '.') {
            for(Map.Entry<Character, Trie> entry: node.branches.entrySet()) {
                if(search(word.substring(1, word.length()), entry.getValue())) {
                    return true;
                }
            }
        }

        if(node.branches.containsKey(c)) {
            return search(word.substring(1, word.length()), node.branches.get(c));
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("abc");

        boolean b  = wd.search("abc");
        boolean c  = wd.search("..c");
        boolean j  = wd.search("a..");
        boolean d  = wd.search("...");
        boolean m  = wd.search(".ba");
        boolean nn  = wd.search("b.");
    }
}

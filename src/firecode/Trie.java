package firecode;

class Trie {
    private TrieNode root = new TrieNode();

    // Implement these methods :
    public Trie() {}
    public void insertWord(String word) {
        if(word == null || word.length()==0) return;
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            if(current.children.containsKey(c)) {
                current = (TrieNode) current.children.get(c);
            } else {
                TrieNode tmp = new TrieNode(c);
                current.children.put(c, tmp);
                current = tmp;
            }
        }
        current.isLeaf = true;
    }

    public Boolean searchWord(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            if(current.children.containsKey(c)) {
                current = (TrieNode) current.children.get(c);
            } else {
                return false;
            }
        }
        return current.isLeaf;
    }

    public Boolean searchPrefix(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()) {
            if(current.children.containsKey(c)) {
                current = (TrieNode) current.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("AB");
        trie.insertWord("ABS");
        trie.insertWord("ADS");
        trie.insertWord("ADSD");
        trie.insertWord("ACS");

        System.out.println(trie.searchWord("AC"));
        System.out.println(trie.searchPrefix("AC"));
    }
}

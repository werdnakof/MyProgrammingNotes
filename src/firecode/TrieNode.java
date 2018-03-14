package firecode;

import java.util.HashMap;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap children = new HashMap();
    public TrieNode(){}
    public TrieNode(Character c){
        this.c = c;
    }
}

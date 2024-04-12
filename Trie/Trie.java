package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> map;
    boolean endOfWord;

    public TrieNode() {
        map = new HashMap<>();
        endOfWord = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.map.get(ch);
            if (null == node) {
                node = new TrieNode();
                curr.map.put(ch, node);
            }
            curr = node;
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = curr.map.get(ch);
            if (null == node)
                return false;
            curr = node;
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = curr.map.get(ch);
            if (null == node)
                return false;
            curr = node;
        }
        return true;
    }
}

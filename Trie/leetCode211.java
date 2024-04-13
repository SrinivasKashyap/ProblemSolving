package Trie;

import java.util.HashMap;
import java.util.Map;

public class leetCode211 {
    class TrieNode {
        Map<Character, TrieNode> children;
        Boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = curr.children.get(ch);
                if (node == null) {
                    node = new TrieNode();
                    curr.children.put(ch, node);
                }
                curr = node;
            }
            curr.endOfWord = true;
        }

        public boolean search(String word) {
            return searchUtil(word, root, 0);
        }

        public boolean searchUtil(String word, TrieNode curr, int i) {
            if (i == word.length()) {
                return curr.endOfWord;
            }

            char ch = word.charAt(i);

            if ('.' == ch) {
                boolean result = false;
                for (Map.Entry<Character, TrieNode> mapElement : curr.children.entrySet()) {
                    if (searchUtil(word, mapElement.getValue(), i + 1))
                        return true;
                }
                return false;
            } else {
                TrieNode node = curr.children.get(ch);
                if (null == node)
                    return false;
                return searchUtil(word, node, i + 1);
            }
        }
    }
}

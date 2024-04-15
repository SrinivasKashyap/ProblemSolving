package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Graph.Pair;

public class leetCode212 {
    public class TrieNode {
        Map<Character, TrieNode> children;
        Boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                TrieNode node = curr.children.get(c);
                if (null == node) {
                    node = new TrieNode();
                    curr.children.put(c, node);
                }
                curr = node;
            }
            curr.endOfWord = true;
        }

        public boolean search(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                TrieNode node = curr.children.get(c);
                if (null == node)
                    return false;
                curr = node;
            }
            return true;
        }
    }

    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        // create Trie
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, new HashSet<>(), new StringBuilder(), trie.root);
            }
        }

        List<String> returnResult = new ArrayList<>();

        for (String str : result) {
            returnResult.add(str);
        }
        return returnResult;
    }

    public void dfs(int i, int j, char[][] board, Set<Pair<Integer, Integer>> visited,
            StringBuilder str, TrieNode node) {
        Pair<Integer, Integer> pair = new Pair<>(i, j);
        if (i == board.length || i < 0 || j == board[0].length || j < 0 || visited.contains(pair) ||
                null == node.children.get(board[i][j])) {
            return;
        }

        visited.add(pair);
        node = node.children.get(board[i][j]);
        str.append(board[i][j]);
        if (node.endOfWord)
            result.add(str.toString());

        dfs(i + 1, j, board, visited, str, node);
        dfs(i - 1, j, board, visited, str, node);
        dfs(i, j + 1, board, visited, str, node);
        dfs(i, j - 1, board, visited, str, node);

        visited.remove(pair);
        str.deleteCharAt(str.length() - 1);
    }
}

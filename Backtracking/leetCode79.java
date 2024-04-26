package Backtracking;

public class leetCode79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean visited[][] = new boolean[board.length][board[0].length];
                if (dfs(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, int n,
            boolean[][] visited) {
        if (n == word.length()) {
            return true;
        }
        ;
        if ((i >= board.length) || (i < 0) || (j >= board[0].length) || (j < 0)
                || visited[i][j] || board[i][j] != word.charAt(n))
            return false;

        visited[i][j] = true;
        boolean result = dfs(i + 1, j, board, word, n + 1, visited) || dfs(i - 1, j, board, word, n + 1, visited) ||
                dfs(i, j + 1, board, word, n + 1, visited) || dfs(i, j - 1, board, word, n + 1, visited);

        visited[i][j] = false;
        return result;
    }
}

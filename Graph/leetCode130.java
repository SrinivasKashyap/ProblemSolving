package Graph;

import java.util.HashSet;
import java.util.Set;

public class leetCode130 {
    public void solve(char[][] board) {
        Set<Pair<Integer, Integer>> unflip = new HashSet<Pair<Integer, Integer>>();

        for (int i = 0; i < board.length; i++) {
            int j = 0;
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
            if (!unflip.contains(pair)) {
                bfs(unflip, i, j, board);
            }
            j = board[0].length - 1;
            Pair<Integer, Integer> newPair = new Pair<Integer, Integer>(i, j);
            if (board[i][j] == 'O' && !unflip.contains(newPair)) {
                bfs(unflip, i, j, board);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            int i = 0;
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
            if (board[i][j] == 'O' && !unflip.contains(pair)) {
                bfs(unflip, i, j, board);
            }
            i = board.length - 1;
            Pair<Integer, Integer> newPair = new Pair<Integer, Integer>(i, j);
            if (board[i][j] == 'O' && !unflip.contains(newPair)) {
                bfs(unflip, i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
                if (board[i][j] == 'O' && !unflip.contains(pair))
                    board[i][j] = 'X';
            }
        }
    }

    public void bfs(Set<Pair<Integer, Integer>> unflip, int i, int j, char[][] board) {
        if (board[i][j] == 'O') {
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
            if (!unflip.contains(pair)) {
                unflip.add(pair);
                if (j - 1 >= 0)
                    bfs(unflip, i, j - 1, board);
                if (j + 1 < board[0].length)
                    bfs(unflip, i, j + 1, board);
                if (i - 1 >= 0)
                    bfs(unflip, i - 1, j, board);
                if (i + 1 < board.length)
                    bfs(unflip, i + 1, j, board);
            }
        }
    }
}

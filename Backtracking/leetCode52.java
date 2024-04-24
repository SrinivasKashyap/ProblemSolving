package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class leetCode52 {
    int result = 0;

    public int totalNQueens(int n) {
        Set<Integer> vert = new HashSet<Integer>();
        Set<Integer> posDiag = new HashSet<Integer>();
        Set<Integer> negDiag = new HashSet<Integer>();

        backtrack(0, n, vert, posDiag, negDiag);
        return result;
    }

    public void backtrack(int r, int n, Set<Integer> vert, Set<Integer> posDiag,
            Set<Integer> negDiag) {
        if (r == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (vert.contains(i) || posDiag.contains(r + i) || negDiag.contains(r - i))
                continue;
            vert.add(i);
            posDiag.add(i + r);
            negDiag.add(r - i);
            backtrack(r + 1, n, vert, posDiag, negDiag);
            vert.remove(i);
            posDiag.remove(i + r);
            negDiag.remove(r - i);
        }
    }
}

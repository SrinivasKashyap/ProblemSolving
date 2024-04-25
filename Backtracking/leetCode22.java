package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    public void dfs(int open, int close, int n, StringBuilder str, List<String> result) {
        if (close == n) {
            result.add(str.toString());
            return;
        }
        if (open < n) {
            str.append('(');
            dfs(open + 1, close, n, str, result);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(')');
            dfs(open, close + 1, n, str, result);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(n, k, i, list, result);
        }
        return result;
    }

    public void dfs(int n, int k, int x, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            List<Integer> tempList = new ArrayList<Integer>(list);
            result.add(tempList);
            return;
        }

        for (int i = x + 1; i <= n; i++) {
            list.add(i);
            dfs(n, k, i, list, result);
            list.remove(list.size() - 1);
        }
    }
}

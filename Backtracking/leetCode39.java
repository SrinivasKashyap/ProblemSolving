package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = candidates[i];
            list.add(candidates[i]);
            if (sum == target) {
                result.add(list);
            } else if (sum > target) {
                continue;
            } else {
                dfs(i, candidates, target, list, result, sum);
            }
        }
        return result;
    }

    public void dfs(int start, int[] candidates, int target, List<Integer> list, List<List<Integer>> result,
            int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, candidates, target, list, result, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}

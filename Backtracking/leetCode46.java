package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            list.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, list, set, result);
        }
        return result;
    }

    public void dfs(int[] nums, List<Integer> list, Set<Integer> set, List<List<Integer>> result) {
        if (nums.length == list.size()) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
                dfs(nums, list, set, result);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}

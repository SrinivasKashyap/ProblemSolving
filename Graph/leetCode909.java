package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class leetCode909 {
    int result = Integer.MAX_VALUE;

    public int snakesAndLadders(int[][] board) {
        // map the squares
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        boolean flag = true;
        int count = 1;
        for (int i = board.length - 1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < board[0].length; j++) {
                    map.put(count, board[i][j]);
                    // System.out.println(count + " " + map.get(count));
                    count++;
                }
                flag = false;
            } else {
                for (int j = board[0].length - 1; j >= 0; j--) {
                    map.put(count, board[i][j]);
                    // System.out.println(count + " " + map.get(count));
                    count++;
                }
                flag = true;
            }
        }

        count -= 1;

        Set<Integer> visited = new HashSet<Integer>();
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>();
        q.addFirst(new Pair<Integer, Integer>(1, 0));

        while (q.size() > 0) {
            Pair<Integer, Integer> pair = q.pollLast();
            Integer curr = pair.getKey();
            Integer steps = pair.getValue();

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (map.get(next) != -1)
                    next = map.get(next);
                if (next == count)
                    return steps + 1;
                else if (next < count) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.addFirst(new Pair<Integer, Integer>(next, steps + 1));
                    }
                }
            }
        }
        return -1;

        // if (dfs(map, 1, 0, new HashSet<Integer>(), count-1)) {
        // return result;
        // }
        // return -1;
    }

    public boolean dfs(Map<Integer, Integer> map, int curr, int count, Set<Integer> visited,
            Integer n) {
        if (visited.contains(curr))
            return false;
        if (n == curr) {
            result = Math.min(result, count);
            return true;
        }
        visited.add(curr);
        boolean possible = false;
        for (int i = 1; i <= 6; i++) {
            int next = curr + i;
            if (next <= n) {
                if (null == map.get(next))
                    System.out.println(n + " " + curr + " " + i + " " + next);
                if (map.get(next) != -1)
                    next = map.get(next);
                if (dfs(map, next, count + 1, visited, n) || possible)
                    possible = true;
            }
        }
        visited.remove(curr);
        return possible;
    }
}

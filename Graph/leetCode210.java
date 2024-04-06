package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetCode210 {
    private int j = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // make prereq map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Integer sub = prerequisites[i][0];
            Integer prereq = prerequisites[i][1];

            List<Integer> prereqs = map.get(sub);
            if (null == prereqs) {
                prereqs = new ArrayList<Integer>();
            }
            prereqs.add(prereq);
            map.put(sub, prereqs);
        }

        int[] result = new int[numCourses];
        int j = 0;
        Set<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < numCourses; i++) {
            List<Integer> tempResult = new ArrayList<Integer>();
            if (!visited.contains(i)) {
                if (!dfs(i, map, new HashSet<Integer>(), result, visited))
                    return new int[0];
            }
        }
        return result;
    }

    public boolean dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> set,
            int[] result, Set<Integer> visited) {
        if (set.contains(node))
            return false;
        if (visited.contains(node))
            return true;
        List<Integer> prereqs = map.get(node);

        if (null != prereqs && prereqs.size() > 0) {
            set.add(node);
            for (int i = 0; i < prereqs.size(); i++) {
                if (!dfs(prereqs.get(i), map, set, result, visited))
                    return false;
                map.put(prereqs.get(i), null);
            }
            map.put(node, null);
            set.remove(node);
        }
        result[j] = node;
        j++;
        visited.add(node);
        return true;
    }
}

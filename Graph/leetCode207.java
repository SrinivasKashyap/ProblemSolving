package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // making the prerequisites list
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> pre = map.get(prerequisites[i][0]);
            if (null == pre) {
                List<Integer> newPre = new ArrayList<>();
                newPre.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], newPre);
            } else {
                pre.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], pre);
            }
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(node))
            return false;
        List<Integer> pre = map.get(node);
        if (null != pre && pre.size() > 0) {
            visited.add(node);
            for (int i = 0; i < pre.size(); i++) {
                int subject = pre.get(i);
                if (!dfs(subject, map, visited))
                    return false;
                map.put(subject, null);
            }
            map.put(node, null);
            visited.remove(node);
        }
        return true;
    }
}

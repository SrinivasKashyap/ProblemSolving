package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // adjacency list
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            List<Pair<String, Double>> lA = adj.get(a);
            if (null == lA) {
                List<Pair<String, Double>> list = new ArrayList<>();
                list.add(new Pair<String, Double>(b, values[i]));
                adj.put(a, list);
            } else {
                lA.add(new Pair<String, Double>(b, values[i]));
                adj.put(a, lA);
            }

            List<Pair<String, Double>> lB = adj.get(b);
            if (null == lB) {
                List<Pair<String, Double>> list = new ArrayList<>();
                list.add(new Pair<String, Double>(a, 1 / values[i]));
                adj.put(b, list);
            } else {
                lB.add(new Pair<String, Double>(a, 1 / values[i]));
                adj.put(b, lB);
            }
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            result[i] = bfs(a, b, adj);
        }
        return result;
    }

    public double bfs(String a, String b, Map<String, List<Pair<String, Double>>> adj) {
        if (null == adj.get(a) || null == adj.get(b))
            return (double) -1;

        LinkedList<Pair<String, Double>> q = new LinkedList<>();
        Set<String> visited = new HashSet<String>();

        q.add(new Pair<String, Double>(a, (double) 1));
        visited.add(a);

        while (q.size() > 0) {
            Pair<String, Double> pair = q.pollFirst();
            String node = pair.getKey();
            Double weight = pair.getValue();

            if (node.equals(b))
                return weight;

            List<Pair<String, Double>> neighbors = adj.get(node);

            for (int i = 0; i < neighbors.size(); i++) {
                Pair<String, Double> neighbor = neighbors.get(i);
                String neighNode = neighbor.getKey();
                Double w = neighbor.getValue();
                if (!visited.contains(neighNode)) {
                    q.add(new Pair<String, Double>(neighNode, (double) weight * w));
                    visited.add(neighNode);
                }

            }
        }
        return -1;
    }
}

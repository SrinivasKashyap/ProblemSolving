package Graph;

import java.util.HashMap;
import java.util.Map;

public class leetCode133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if (null != map.get(node))
            return map.get(node);
        if (null == node)
            return null;
        Node copy = new Node(node.val);
        map.put(node, copy);

        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(dfs(node.neighbors.get(i), map));
        }
        return copy;
    }
}

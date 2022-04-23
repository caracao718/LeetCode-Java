package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraph(node, visited);
    }
    public Node cloneGraph(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node curr = new Node(node.val, new ArrayList<>());
        visited.put(node, curr);
        for (Node neighbor : node.neighbors) {
            curr.neighbors.add(cloneGraph(neighbor, visited));
        }
        return curr;
    }
}

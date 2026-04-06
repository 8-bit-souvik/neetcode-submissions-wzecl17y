/*
Definition for a Node.
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
*/

class Solution {
    // static Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){return null;};
        Map<Node, Node> visited = new HashMap<>();
        fillMap(node, visited);
        for(Node n : new ArrayList<>(visited.keySet())){
            for(Node nn: n.neighbors){
                visited.get(n).neighbors.add(visited.get(nn));
            }
        }
        return visited.get(node);
    }
    void fillMap(Node node, Map<Node, Node> visited){
        if(!visited.containsKey(node)){
            Node copy = new Node(node.val);
            visited.put(node, copy);
            for(Node n : node.neighbors){
                fillMap(n, visited);
            }
        }
    }
}
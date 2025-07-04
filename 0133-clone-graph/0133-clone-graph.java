/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        Map<Integer, Node> map = new HashMap();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map){
        //System.out.println(node.val);
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node copy = new Node(node.val);
        map.put(copy.val, copy);

        for (Node temp: node.neighbors){
            copy.neighbors.add(clone(temp, map));
        }        

        return copy;
    }            
}

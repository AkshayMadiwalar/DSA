public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Queue<Node> queue = new LinkedList<>();
        
        if(node==null)
            return null;
        Node cloneSource = new Node(node.val);
        map.put(node,cloneSource);
        queue.add(node);
        
        while(queue.size()>0){
            Node parent = queue.poll();
            List<Node> neighbors = parent.neighbors;
            Node clone = map.get(parent);
            for(Node each:neighbors){
                Node cloneEach = map.get(each);
                if(cloneEach==null){
                    queue.add(each);
                    cloneEach = new Node(each.val);
                    map.put(each,cloneEach);
                }
                clone.neighbors.add(cloneEach);
            }
        }
        return cloneSource;
    } 
}

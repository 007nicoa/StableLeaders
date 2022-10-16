import java.util.ArrayList;

public class Graph {

    ArrayList<Node> nodes;

    public Graph (int size) {
        nodes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nodes.add(new Node(1));
        }
    }

    public Node getNode (Node node) {
        return nodes.get(nodes.indexOf(node));
    }

    public ArrayList<Node> getList () {
        return nodes;
    }

}

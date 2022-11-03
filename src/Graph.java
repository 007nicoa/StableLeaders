import java.util.HashMap;

public class Graph {

    Node[] nodes;

    public Graph (int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(1);
        }
    }

    public Node[] getNodes () {
        return nodes;
    }

    public void evolve () {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].evolve();
        }
    }

}

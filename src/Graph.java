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

}

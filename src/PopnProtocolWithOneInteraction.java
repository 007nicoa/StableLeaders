import java.util.HashMap;
import java.util.Random;

public class PopnProtocolWithOneInteraction {

    static HashMap<Integer, Integer> Config;
    static Graph G;

    public static void main (String[] args) {
        int size = 10000;
        int interactions = 0;
        initializeGraph(size);
        initializeConfig(size);
        while (Config.get(1) != 1) {
            run();
            interactions++;
        }
        System.out.println("Amount of interactions to reach a leader: " + interactions);
    }

    public static void initializeGraph (int size) {
        G = new Graph(size);
    }

    public static void initializeConfig (int size) {
        Config = new HashMap<>();
        Config.put(1, size);
        Config.put(0, 0);

    }

    public static void run () {
        Random roll = new Random();

        int x = roll.nextInt(G.getNodes().length);
        int y = roll.nextInt(G.getNodes().length);
        while (y == x) {
            y = roll.nextInt(G.getNodes().length);
        }

        Node nodeOne = G.getNodes()[x];
        Node nodeTwo = G.getNodes()[y];

        if (nodeOne.getState() == 1 && nodeTwo.getState() == 1) {
            if (Math.random() < .50) {
                nodeOne.setState();
            } else {
                nodeTwo.setState();
            }
            Config.put(1, Config.get(1) - 1);
            Config.put(0, Config.get(0) + 1);
        }


    }




}

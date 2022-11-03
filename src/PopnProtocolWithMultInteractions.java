import java.util.HashMap;
import java.util.Random;

public class PopnProtocolWithMultInteractions {

    static HashMap<Integer, Integer> Config;
    static Graph G;

    public static void main (String[] args) {
        int size = 1000;
        int interactions = 1;
        int runs = 0;
        initializeGraph(size);
        initializeConfig(size);
        while (Config.get(1) != 1) {
            for (int i = 0; i < interactions; i++) {
                run();
            }
            G.evolve();
            runs++;
        }
        System.out.println("Amount of runs to reach a leader: " + runs + " and around this many interactions: " + (interactions * runs * G.getNodes().length));
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
        for (int i = 0; i < G.getNodes().length; i++) {
            Random roll = new Random();

            int x = roll.nextInt(G.getNodes().length);
            while (i == x) {
                x = roll.nextInt(G.getNodes().length);
            }

            Node nodeOne = G.getNodes()[i];
            Node nodeTwo = G.getNodes()[x];

            if (nodeOne.getState() == 1 && nodeTwo.getState() == 1) {
                if (Math.random() < .50) {
                    if (!nodeOne.willChange) {
                        Config.put(1, Config.get(1) - 1);
                        Config.put(0, Config.get(0) + 1);
                    }
                    nodeOne.setWillChange();
                } else {
                    if (!nodeTwo.willChange) {
                        Config.put(1, Config.get(1) - 1);
                        Config.put(0, Config.get(0) + 1);
                    }
                    nodeTwo.setWillChange();
                }
            }
        }


    }

}
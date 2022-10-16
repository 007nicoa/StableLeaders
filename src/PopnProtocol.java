import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PopnProtocol {

    static HashMap<Integer, Integer> Config;
    static Graph G;

    public static void main (String[] args) {
        int size = 400;
        int interactions = 1;
        int runs = 0;
        initializeGraph(size);
        initializeConfig(size);
        while (Config.get(1) != 1) {
            run1(interactions);
            runs++;
        }
        System.out.println("Amount of runs to reach a leader: " + runs);
    }

    public static void initializeGraph (int size) {
        G = new Graph(size);
    }

    public static void initializeConfig (int size) {
        Config = new HashMap<>();
        Config.put(1, size);
        Config.put(0, 0);

    }

    public static void run1 (int interactions) {
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < G.getList().size(); i++) {
            copy.add(i,i);
        }
        HashMap<Integer, Integer> count = new HashMap<>();

        Random roll = new Random();

        while (copy.size() != 0) {
            if (copy.size() <= 2) {
                break;
            }
            int first = roll.nextInt(copy.size());
            //System.out.println(first);
            Node nodeOne = G.getList().get(copy.get(first));

            if (!count.containsKey(copy.get(first))) {
                count.put(copy.get(first), 1);
            }
            count.put(copy.get(first), count.get(copy.get(first)) + 1);
            if (count.get(copy.get(first)) >= interactions) {
                //System.out.println("The count got reached " + count.get(copy.get(first)));
                copy.remove(copy.get(first));
            }

            int second = roll.nextInt(copy.size());
            while (first == second) {
                second = roll.nextInt(copy.size());
            }
            //System.out.println(second);
            Node nodeTwo = G.getList().get(copy.get(second));

            if (!count.containsKey(copy.get(second))) {
                count.put(copy.get(second), 1);
            }
            count.put(copy.get(second), count.get(copy.get(second)) + 1);
            if (count.get(copy.get(second)) >= interactions) {
                //System.out.println("The count got reached " + count.get(copy.get(second)));
                copy.remove(copy.get(second));
            }

            if (nodeOne.getState() == 1 && nodeTwo.getState() == 1) {
                if (Math.random() < .50) {
                    nodeOne.setState();
                } else {
                    nodeTwo.setState();
                }
                Config.put(1, Config.get(1) - 1);
                Config.put(0, Config.get(0) + 1);
                System.out.println("Yay");
            }



            System.out.println(Config.get(1));

        }

    }




}

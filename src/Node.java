public class Node {

    int state;
    Boolean willChange;

    public Node (int s) {
        state = s;
        willChange = false;
    }

    public void setWillChange () {
        willChange = true;
    }

    public void evolve () {
        if (this.willChange) {
            this.setState();
            willChange = true;
        }
    }

    public int getState () {
        return state;
    }

    public void setState () {
        state = 0;
    }

}

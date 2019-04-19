package akopensource.graphs;

public class Vertex {

    private int v;
    private int weight;
    private boolean isVisisted;
    private Vertex predecessor;
    private int distance;
    private int discoveryTime, finishTime; // timestamps

    public Vertex(int v, int weight) {
        this.v = v;
        this.weight = weight;
        this.distance = 0;
    }

    Vertex(int v) {
        this.v = v;
        this.distance = 0;
    }

    int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    boolean isVisisted() {
        return isVisisted;
    }

    void setVisisted(boolean visisted) {
        isVisisted = visisted;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        this.distance = distance;
    }

    int getDiscoveryTime() {
        return discoveryTime;
    }

    void setDiscoveryTime(int discoveryTime) {
        this.discoveryTime = discoveryTime;
    }

    int getFinishTime() {
        return finishTime;
    }

    void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}

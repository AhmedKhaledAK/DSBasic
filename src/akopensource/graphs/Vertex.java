package akopensource.graphs;

public class Vertex {

    private int v;
    private int weight;
    private boolean isVisisted;
    private Vertex predecessor;
    private int distance;

    public Vertex(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public Vertex(int v) {
        this.v = v;
    }

    public int getV() {
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

    public boolean isVisisted() {
        return isVisisted;
    }

    public void setVisisted(boolean visisted) {
        isVisisted = visisted;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

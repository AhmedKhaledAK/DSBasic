package akopensource.graphs;

public class Vertex {

    private int v;
    private int weight;

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
}

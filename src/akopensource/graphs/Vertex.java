package akopensource.graphs;

public class Vertex {

    private int v;
    private int weight;
    private boolean isVisisted;
    private Vertex predecessor;
    private int distance;
    private int discoveryTime, finishTime; // timestamps
    private EdgeType edgeType;
    private int weightKey;

    public enum EdgeType {
        BACK,
        FORWARD,
        TREE,
        CROSS
    }

    public Vertex(int v, int weight) {
        this.v = v;
        this.weight = weight;
        this.distance = 0;
    }

    Vertex(int v) {
        this.v = v;
        this.distance = 0;
        this.finishTime = 0;
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

    EdgeType getEdgeType() {
        return edgeType;
    }

    void setEdgeType(EdgeType edgeType) {
        this.edgeType = edgeType;
    }

    int getWeightKey() {
        return weightKey;
    }

    void setWeightKey(int weightKey) {
        this.weightKey = weightKey;
    }

    @Override
    public String toString() {
        return v+"";
    }
}

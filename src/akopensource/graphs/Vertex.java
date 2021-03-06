package akopensource.graphs;

public class Vertex implements Comparable<Vertex> {

    private int v;
    private int weight;
    private boolean isVisited;
    private Vertex predecessor;
    private int distance;
    private int discoveryTime, finishTime; // timestamps
    private EdgeType edgeType;
    private Integer weightKey; // Integer object for comparing

    @Override
    public int compareTo(Vertex vertex) {
        return this.getWeightKey().compareTo(vertex.getWeightKey());
    }

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

    boolean isVisited() {
        return isVisited;
    }

    void setVisited(boolean visited) {
        isVisited = visited;
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

    public Integer getWeightKey() {
        return weightKey;
    }

    public void setWeightKey(Integer weightKey) {
        this.weightKey = weightKey;
    }


    // these methods can be used too

    /*@Override
    public boolean equals(Object obj) {
       // System.out.println("this v: " + this.getV() + ", " + "obj v: " + ((Vertex)obj).getV());
        return this.getV() == ((Vertex)obj).getV();
    }

    @Override
    public int hashCode() {
        System.out.println("result: " + v);
        return v;
    }*/

    @Override
    public String toString() {
        return v+"";
    }
}

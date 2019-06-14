package akopensource.graphs;

public class Edge implements Comparable<Edge> {
    int src, dest;
    Integer weight;



    public Edge(int src, int dest, Integer weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}

package akopensource.graphs;

import java.util.LinkedList;

public class Graph {

    private Vertex [][] matrix;
    private LinkedList<Vertex> [] adjList;
    private int type; // 0 - undirected, 1 - directed

    public Graph(int n, int m, int type) {
        this.matrix = new Vertex[n][m];
        this.type = type;
    }

    public Graph(int size, int type) {
        this.adjList = new LinkedList[size];
        this.type = type;
    }

    public void insertInAdjList(int src, int dest){
        Vertex vertex = new Vertex(dest);
        this.adjList[src].add(vertex);

        if (this.type == 0){
            vertex = new Vertex(src);
            this.adjList[dest].add(vertex);
        }
    }

}

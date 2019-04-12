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
        initializeList(src);
        this.adjList[src].add(vertex);

        if (this.type == 0){
            vertex = new Vertex(src);
            initializeList(dest);
            this.adjList[dest].add(vertex);
        }
    }

    private void initializeList(int i) {
        if (this.adjList[i] == null)
            this.adjList[i] = new LinkedList<>();
    }

    public void printGraphAdjList(){
        for(int i = 0; i < adjList.length; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < adjList[i].size(); j++)
                System.out.print(adjList[i].get(j).getV() + " / ");
            System.out.println();
        }
    }

}

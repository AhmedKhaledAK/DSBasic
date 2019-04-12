package akopensource.graphs;

import java.util.LinkedList;

public class Graph {

    private Vertex [][] matrix; // matrix can hold one bit only, which is better. Here we're doing this to hold all the attributes of a
    // vertex and if there were weighted edges
    private LinkedList<Vertex> [] adjList;
    private int type; // 0 - undirected, 1 - directed
    private int n;

    public Graph(int n, int m, int type) {
        this.matrix = new Vertex[n][n];
        this.n = n;
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
            if(src == dest) return;
            vertex = new Vertex(src);
            initializeList(dest);
            this.adjList[dest].add(vertex);
        }
    }

    public void insertInMatrix(int src, int dest){
        Vertex vertex = new Vertex(dest);
        this.matrix[src][dest] = vertex;

        if (this.type == 0){
            if(src == dest) return;
            vertex = new Vertex(src);
            this.matrix[dest][src] = vertex;
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

    public void printGraphMatrix(){
        System.out.print("\t");
        for (int i = 0; i < n; i++)
            System.out.print(i + "\t");
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.print(i + ": ");
            for (int j = 0; j < n; j++){
                System.out.print("\t");
                System.out.print(matrix[i][j] == null ? "-1" : 1);
            }
            System.out.println();
        }
    }
}

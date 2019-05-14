package akopensource.graphs;

import akopensource.tuples.Triplet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

    private Vertex [][] matrix; // matrix can hold one bit only, which is better. Here we're doing this to hold all the
    // attributes of a vertex
    private LinkedList<Vertex> [] adjList;
    private int type; // 0 - undirected, 1 - directed
    private int n;
    private Vertex[] visited;
    private int time;
    private LinkedList<Vertex> topologicalSortedList;

    public Graph(int n, int m, int type) {
        this.matrix = new Vertex[n][n];
        this.n = n;
        this.type = type;
    }

    public Graph(int size, int type) {
        this.adjList = new LinkedList[size];
        this.type = type;
        this.visited = new Vertex[size];

        for (int i = 0; i < size; i++) {
            visited[i] = new Vertex(i);
            visited[i].setVisisted(false);
        }
        topologicalSortedList = new LinkedList<>();
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

    public void bfs(int src){
        for (Vertex vertex : visited) vertex.setVisisted(false);

        visited[src].setVisisted(true);
        visited[src].setDistance(0);

        PriorityQueue<Integer> unVisited = new PriorityQueue<>();
        unVisited.add(src);
        while (!unVisited.isEmpty()){
            int e = unVisited.poll();
            visit(e);
            for (int i = 0; i < adjList[e].size(); i++){
                int v = adjList[e].get(i).getV();
                if (!visited[v].isVisisted()){
                    visited[v].setVisisted(true);
                    visited[v].setDistance(visited[e].getDistance() + 1);
                    visited[v].setPredecessor(new Vertex(e));
                    unVisited.add(v);
                }
            }
        }
    }

    public void dfs(){
        for (Vertex vertex : visited) vertex.setVisisted(false);

        for (int i = 0; i < visited.length; i++){
            if (!visited[i].isVisisted())
                dfsVisit(visited, i, this);
        }
    }

    private void dfsVisit(Vertex[] visited, int i, Graph graph) {
        time += 1;
        visited[i].setDiscoveryTime(time);
        visited[i].setVisisted(true);
        visit(i);
        for (int j = 0; graph.adjList[i] != null && j < graph.adjList[i].size(); j++){
            int v = graph.adjList[i].get(j).getV();
            if (!visited[v].isVisisted()){
                graph.adjList[i].get(j).setEdgeType(Vertex.EdgeType.TREE);
                visited[v].setPredecessor(visited[i]);
                dfsVisit(visited, v, graph);
            }else {
                if(visited[i].getDiscoveryTime() >= visited[v].getDiscoveryTime() && visited[v].getFinishTime() == 0){
                    graph.adjList[i].get(j).setEdgeType(Vertex.EdgeType.BACK);
                }else if(visited[i].getDiscoveryTime() < visited[v].getDiscoveryTime()){
                    graph.adjList[i].get(j).setEdgeType(Vertex.EdgeType.FORWARD);
                }else if(visited[i].getDiscoveryTime() > visited[v].getDiscoveryTime() && visited[i].getFinishTime() == 0){
                    graph.adjList[i].get(j).setEdgeType(Vertex.EdgeType.CROSS);
                }
            }
        }
        time += 1;
        visited[i].setFinishTime(time);
        topologicalSortedList.addFirst(visited[i]);
    }

    private Graph transposeGraph(){
        Graph graph = new Graph(this.adjList.length, type);
        for (int i = 0; i < adjList.length; i++){
            for (int j = 0; j < adjList[i].size(); j++){
                graph.insertInAdjList(adjList[i].get(j).getV(), i);
            }
        }
        return graph;
    }

    public void getConnectedComponents(){
        Graph graph = transposeGraph();
        // this if condition is here because of the strongly connected components problem, we consider the vertices in order of
        // decreasing finishing time
        if (topologicalSortedList.isEmpty()){
            dfs();
        }
        Vertex [] visitedCopy = Arrays.copyOf(visited, this.adjList.length);
        LinkedList<Vertex> topCopy = (LinkedList<Vertex>) topologicalSortedList.clone();
        for (Vertex vertex : visitedCopy) vertex.setVisisted(false);
        for (Vertex vertex : topCopy) {
            int v = vertex.getV();
            if (!visitedCopy[v].isVisisted()) {
                dfsVisitTransposeGraph(visitedCopy, v, graph);
                System.out.println("-----------");
            }
        }
    }

    private void dfsVisitTransposeGraph(Vertex [] visited, int i , Graph graph){
        visited[i].setVisisted(true);
        visit(i);
        for (int j = 0; graph.adjList[i] != null && j < graph.adjList[i].size(); j++){
            int v = graph.adjList[i].get(j).getV();
            if (!visited[v].isVisisted()){
                graph.adjList[i].get(j).setEdgeType(Vertex.EdgeType.TREE);
                visited[v].setPredecessor(visited[i]);
                dfsVisitTransposeGraph(visited, v, graph);
            }
        }
    }


    private void visit(int e) {
        System.out.println(e);
    }

    public void printGraphAdjList(){
        for(int i = 0; i < adjList.length; i++){
            System.out.print(i + ": ");
            if (adjList[i] == null){
                System.out.println("/");
                continue;
            }
            for(int j = 0; j < adjList[i].size(); j++)
                System.out.print(adjList[i].get(j).getV() + ":> " + " edge type: " + adjList[i].get(j).getEdgeType()+ " / ");
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

    public void printVisited(){
        for (Vertex vertex : visited) {
            System.out.println(vertex.getV() + ": " + "discovery time --> " + vertex.getDiscoveryTime() + ", " +
                    "finish time " + vertex.getFinishTime());
        }
    }

    public LinkedList<Vertex> getTopologicalSortedList(){
        return topologicalSortedList;
    }
}

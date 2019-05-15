package akopensource.graphs;


import akopensource.tuples.Pair;

import java.util.*;

public class Graph {

    private Vertex [][] matrix; // matrix can hold one bit only, which is better. Here we're doing this to hold all the
    // attributes of a vertex
    private LinkedList<Vertex> [] adjList;
    private int type; // 0 - undirected, 1 - directed
    private int n;
    private Vertex[] visited;
    private Vertex[] helperArrayMST;
    private int time;
    private int size;
    private LinkedList<Vertex> topologicalSortedList;
    private LinkedList<Pair> pairs;

    public Graph(int n, int m, int type) {
        this.matrix = new Vertex[n][n];
        this.n = n;
        this.type = type;
    }

    public Graph(int size, int type) {
        this.size = size;
        this.adjList = new LinkedList[size];
        this.type = type;
        this.visited = new Vertex[size];
        this.helperArrayMST = new Vertex[size];

        for (int i = 0; i < size; i++) {
            visited[i] = new Vertex(i);
            visited[i].setVisisted(false);
        }
        topologicalSortedList = new LinkedList<>();
        pairs = new LinkedList<>();
    }

    public void insertInAdjList(int src, int dest, int weight){
        Vertex vertex = new Vertex(dest);
        vertex.setWeight(weight);
        initializeList(src);
        this.adjList[src].add(vertex);

        if (this.type == 0){
            if(src == dest) return;
            vertex = new Vertex(src);
            vertex.setWeight(weight);
            initializeList(dest);
            this.adjList[dest].add(vertex);
        }
    }

    public void insertInAdjList(int src, int dest){
        insertInAdjList(src,dest,0);
    }

    public void insertInMatrix(int src, int dest, int weight){
        Vertex vertex = new Vertex(dest);
        vertex.setWeight(weight);
        this.matrix[src][dest] = vertex;

        if (this.type == 0){
            if(src == dest) return;
            vertex = new Vertex(src);
            vertex.setWeight(weight);
            this.matrix[dest][src] = vertex;
        }
    }

    public void insertInMatrix(int src, int dest){
        insertInMatrix(src,dest,0);
    }

    private void initializeList(int i) {
        if (this.adjList[i] == null)
            this.adjList[i] = new LinkedList<>();
    }

    public void createMSTPrim(int src){
        for (int i = 0; i < this.size; i++){
            helperArrayMST[i] = new Vertex(i);
            helperArrayMST[i].setWeightKey(Integer.MAX_VALUE);
        }
        helperArrayMST[src].setWeightKey(0);

        PriorityQueue<Vertex> queue = createQueue(helperArrayMST);

        printQueue(queue);

        pairs = new LinkedList<>();
        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();
            printQueue(queue);
            int v = vertex.getV();
            System.out.println("dequeue v: " + v);

            if (vertex.getPredecessor() != null)
                pairs.add(new Pair(vertex.getPredecessor().getV(), v));

            for (int i = 0; i < adjList[v].size(); i++){

                System.out.println("helperArrayMST[adjList[v].get(i).getV()]: " + helperArrayMST[adjList[v].get(i).getV()] +
                        " weightKey: " + helperArrayMST[adjList[v].get(i).getV()].getWeightKey() +
                        ",,, adjList[v].get(i).getWeight(): " + adjList[v].get(i).getWeight());

                if (helperArrayMST[adjList[v].get(i).getV()].getWeightKey() > adjList[v].get(i).getWeight()
                        && isInQueue(queue, adjList[v].get(i))){
                    System.out.println("in queue: " + adjList[v].get(i).getV());
                    helperArrayMST[adjList[v].get(i).getV()].setWeightKey(adjList[v].get(i).getWeight());
                    helperArrayMST[adjList[v].get(i).getV()].setPredecessor(vertex);
                    heapifyQueue(queue, helperArrayMST[adjList[v].get(i).getV()]);
                    printQueue(queue);
                }
            }
        }
    }

    private void heapifyQueue(PriorityQueue<Vertex> queue, Vertex vertex) {
        queue.remove(vertex);
        queue.add(vertex);
    }

    private void printQueue(PriorityQueue<Vertex> queue) {
        System.out.println("---printing queue......");
        for (Vertex vert : queue){
            System.out.println("v: " + vert.getV() + ", " + "weightkey: " + vert.getWeightKey());
        }
        System.out.println("---end of printing queue......");
    }

    private boolean isInQueue(PriorityQueue<Vertex> queue, Vertex vertex) {
        for (Vertex vert : queue) {
            if (vert.getV() == vertex.getV())
                return true;
        }
        return false;
    }


    private PriorityQueue<Vertex> createQueue(Vertex[] helperArray) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Collections.addAll(queue, helperArray); // adding all elements in helperArrayMST to queue
        return queue;
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

    public void printMST(){
        for (Pair pair : pairs) {
            System.out.println("(" + pair.getFirstElem() + ", "
                    + pair.getSecondElem() + ")");
        }
    }
}

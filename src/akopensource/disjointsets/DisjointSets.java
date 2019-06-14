package akopensource.disjointsets;

public class DisjointSets {

    private int [] parent;
    private int [] rank;
    private int maxNumOfSets;

    public DisjointSets(int size) {
        this.maxNumOfSets = size;
        this.parent = new int[maxNumOfSets];
        this.rank = new int[maxNumOfSets];

        for (int i = 0; i < size; i++){
            parent[i] = -1;
            rank[i] = -1;
        }
    }

    public void makeSet(int v){
        parent[v] = v;
        rank[v] = 0;
    }

    private void link(int repX, int repY){
        if (repX == repY) return;
        if (rank[repX] > rank[repY])
            parent[repY] = repX;
        else{
            parent[repX] = repY;
            if (rank[repX] == rank[repY])
                rank[repY] += 1;
        }

    }

    public int findSet(int v){
        if (v == -1) {
            System.out.println("element not found in any set");
            return -1;
        }
        if (v != parent[v])
            parent[v] = findSet(parent[v]);
        return parent[v];
    }

    public void union(int v1, int v2){
        int repX = findSet(v1);
        int repY = findSet(v2);
        if (repX != -1 && repY != -1) link(repX, repY);
    }

    public void printDisjointSets(){
        System.out.println("parent array: ");
        for (int i = 0; i < maxNumOfSets; i++){
            System.out.print(i + ": " + parent[i] + " /// ");
        }
        System.out.println("\nrank array: ");
        for (int i = 0; i < maxNumOfSets; i++){
            System.out.print(i + ": " + rank[i] + " /// ");
        }
    }
}

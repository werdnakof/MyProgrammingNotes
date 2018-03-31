package graphs;

public class Graph {
    public int MAXV = 100;
    public EdgeNode[] edges = new EdgeNode[MAXV];
    public int[] degree = new int[MAXV];
    public int nvertices;
    public int nedges = 0;
    public boolean directed;

    public Graph(int nvertices, boolean directed) {
        this.nvertices = nvertices;
        this.directed = directed;
    }

    public void insertEdge(int x, int y, boolean directed) {
        EdgeNode p = new EdgeNode(y, 0);
        p.next = edges[x];
        this.edges[x] = p;

        this.degree[x]++;

        if(!directed)
            insertEdge(y, x, true);
        else
            this.nedges++;
    }

    public void printGraph() {
        for(int i = 0; i <= this.nvertices - 1; i++) {
            System.out.format("\n%d:", i);
            EdgeNode p = this.edges[i];
            while(p != null) {
                System.out.format(" %d", p.y);
                p = p.next;
            }
        }
    }

    public static void main(String[] vars) {
        Graph g = new Graph(5, true);
        g.insertEdge(0, 1, true);
        g.insertEdge(1, 2, true);
        g.insertEdge(2, 3, true);
        g.insertEdge(3, 4, true);
        g.insertEdge(0, 3, true);
        g.printGraph();
    }
}

package graphs;

import java.util.Arrays;

public class DFS {
    public boolean[] processed;
    public boolean[] discovered;
    public int[] entryTime;
    public int[] exitTime;
    int time = 0;
    public int[] parents;
    public Graph graph;

    /**
     * @param graph
     *
     * DFS transverse all nodes via maximum depth first
     * (recursive visit first child until no more children)
     *
     * During each node visit,
     * - save node's parent
     * - mark node as discovered
     * - mark node as processed once all its child have been transversed
     * - only dfs a node if it is un discovered
     *
     * edges in Graph is stored as a linked list i.e. each child is linked to the other child
     */
    public DFS(Graph graph) {
        this.graph = graph;

        this.parents = new int[graph.nvertices];
        this.processed = new boolean[graph.nvertices];
        this.discovered = new boolean[graph.nvertices];

        this.entryTime = new int[graph.nvertices];
        this.exitTime = new int[graph.nvertices];

        init();
    }

    private void init() {
        for(int i = 0; i <= graph.nvertices-1; i++) {
            parents[i] = -1;
        }

        for(int i = 0; i <= graph.nvertices-1; i++) {
            this.processed[i] = this.discovered[i] = false;
        }
    }

    public void dfs(int idx) {
        EdgeNode node = graph.edges[idx];

        discovered[idx] = true;
        entryTime[idx] = time++;

        while( node != null ) {

            int y = node.y;

            if(!discovered[y]) {

                parents[y] = idx;

                dfs(y);

            } else if(!processed[y] || graph.directed) checkCycle(idx, y);

            if(graph.directed) edgeClassification(idx, y);

            node = node.next;
        }

        processed[idx] = true;
        exitTime[idx] = time++;
    }

    public void processEdge(int x, int y) {

    }

    public void checkCycle(int x, int y) {
        if(parents[x] != y) { // found back edge
            System.out.printf("Cycle from %d to %d:",y,x);
            findPath(y, x);
            System.out.printf("\n\n");
        }
    }

    public void findPath(int start, int end) {
        if(start == end || end == -1) {
            System.out.printf("\n%d", start);
        } else {
            findPath(start, parents[end]);
            System.out.printf(" %d", end);
        }
    }

    public void edgeClassification(int x, int y) {
        if(parents[y] == x) System.out.printf("Tree edge (%d,%d)\n",x, y);
        else if(discovered[y] && !processed[y]) System.out.printf("Back edge (%d,%d)\n",x, y);
        else if(processed[y] && (entryTime[y] > entryTime[x])) System.out.printf("Forward edge (%d,%d)\n",x, y);
        else if(processed[y] && (entryTime[y] < entryTime[x])) System.out.printf("Cross edge (%d,%d)\n",x, y);
    }

    public static void main(String[] vars) {
        Graph g = new Graph(7, true);
        g.insertEdge(0, 1, true);
        g.insertEdge(1, 4, true);
        g.insertEdge(4, 3, false);
        g.insertEdge(2, 4, true);
        g.insertEdge(2, 5, true);
        g.insertEdge(1, 0, true);

        DFS dfs = new DFS(g);
        dfs.dfs(0);

        System.out.print("\n"+ Arrays.toString(dfs.parents));
        System.out.print("\n"+ Arrays.toString(dfs.entryTime));
        System.out.print("\n"+ Arrays.toString(dfs.exitTime));
    }
}

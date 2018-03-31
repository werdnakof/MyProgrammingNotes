package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public Graph graph;
    public int[] parents;
    public boolean[] discovered;
    public boolean[] processed;
    public int nedges = 0;

    public BFS(Graph graph) {
        this.graph = graph;
        this.parents = new int[graph.nvertices];
        this.processed = new boolean[graph.nvertices];
        this.discovered = new boolean[graph.nvertices];
        this.init();
    }

    private void init() {
        for(int i = 0; i <= graph.nvertices-1; i++) {
            parents[i] = -1;
        }

        for(int i = 0; i <= graph.nvertices-1; i++) {
            this.processed[i] = this.discovered[i] = false;
        }
    }

    public void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        discovered[root] = true;

        while(!queue.isEmpty()) {

            int next = queue.poll();

            processed[next] = true;

            EdgeNode node = graph.edges[next];

            while (node != null) {

                int y = node.y;

                if(!processed[y] || graph.directed) processEdge(next, y);

                if(!discovered[y]) {
                    discovered[y] = true;
                    queue.add(y);
                    parents[y] = next;
                }

                node = node.next;
            }
        }
    }

    private void processEdge(int x, int y) {
        System.out.printf("processed edge (%d,%d)\n",x,y);
        nedges++;
    }

    public void findPath(int start, int end) {
        if(start == end || end == -1) {
            System.out.printf("\n%d", start);
        } else {
            findPath(start, parents[end]);
            System.out.printf(" %d", end);
        }
    }

    public static void main(String[] vars) {
        Graph g = new Graph(5, true);
        g.insertEdge(0, 1, true);
        g.insertEdge(1, 2, true);
        g.insertEdge(2, 3, true);
        g.insertEdge(3, 4, true);
        g.insertEdge(0, 3, true);

        BFS nfs = new BFS(g);
        nfs.bfs(0);
        nfs.findPath(0, 4);

        System.out.print("\nParents: "+Arrays.toString(nfs.parents));
    }
}

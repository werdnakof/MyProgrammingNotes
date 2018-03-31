package graphs;

import javax.management.QueryEval;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsByArray {

    public static class Graph {
        int[][] vertices;
        int[] indices;
        int[] branches;
        int count;

        public Graph(int nodeCount) {
            this.vertices = new int[nodeCount][nodeCount];
            this.indices = new int[nodeCount];
            this.branches = new int[nodeCount];
            this.count = nodeCount;
        }

        public void addNewVertex(int from, int to) {
            vertices[from][to] = 1;
            indices[to]++;
            branches[from]++;
        }
    }

    Graph graph;
    boolean[] visited;
    boolean cycleDetected;

    public DfsByArray(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.count];
        this.cycleDetected = false;
    }

    public List<List<Integer>> dfs(List<Integer> list, int start) {

        List<List<Integer>> result = new ArrayList<>();

        if(visited[start]) {
            cycleDetected = true;
            result.add(new ArrayList<>(list));
            return result;
        }

        visited[start] = true;

        list.add(start);

        if(graph.branches[start] == 0) { // leaf node
            result.add(new ArrayList<>(list));
        } else {

            for(int i = 0; i < graph.count; i++) {

                if(graph.vertices[start][i] == 1) {
                    result.addAll(dfs(list, i));
                }
            }
        }


        list.remove(list.size()-1);
        visited[start] = false;
        return result;
    }


    public List<List<Integer>> bfs(int start) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        int[] parent = new int[graph.count];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        while(queue.size() != 0) {
            Integer current = queue.poll();
            visited[current] = true;

            for(int i = 0; i < graph.count; i++) {
                if(graph.vertices[current][i] == 1 && !visited[i]) {
                    parent[i] = current;
                    queue.add(i);
                }
            }

//            visited[current] = false;
        }

        for(int i = 0; i < parent.length; i++) {
            if(i == start) continue;
            int p = i;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            while(p != start && p != -1) {
                list.add(0, parent[p]);
                p = parent[p];
            }
            result.add(list);
        }

        return  result;
    }

    public  static void main(String[] args) {
        Graph g = new Graph(6);
        g.addNewVertex(0, 1);
        g.addNewVertex(1, 2);
        g.addNewVertex(0, 2);
        g.addNewVertex(0, 3);

        g.addNewVertex(3, 1);

        g.addNewVertex(3, 4);

        g.addNewVertex(4, 5);

        g.addNewVertex(5, 3);
        g.addNewVertex(3, 5);

        DfsByArray df = new DfsByArray(g);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = df.bfs(0);
        for(List ls: result) {
            System.out.println(ls);
        }
    }
}

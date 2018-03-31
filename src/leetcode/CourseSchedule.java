package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] vertices = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {

            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];

            if (vertices[pre][ready] == 0)
                indegree[ready]++; //duplicate case

            vertices[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (vertices[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.add(i);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        int[][] vertices = new int[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int required = pre[1];
            vertices[course][required] = 1;
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(vertices, visited, i)) return false;
        }

        return true;
    }

    public boolean dfs(int[][] vertices, boolean[] visited, int course) {
        if(visited[course]) return false;
        visited[course] = true;

        for(int i = 0; i < vertices[course].length; i++) {
            if(vertices[course][i] == 1) {
                if(!dfs(vertices, visited, i)) {
                    return false;
                }
            }
        }

        visited[course] = false;
        return true;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[][] vertices = new int[numCourses][numCourses];
        int[] indices = new int[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int required = pre[1];
            vertices[course][required] = 1;
            indices[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indices[i] == 0) queue.add(i);
        }

        int count = 0;
        while(queue.size() != 0) {
            int course = queue.poll();
            count++;

            for(int i = 0; i < numCourses; i++) {
                if(vertices[i][course] == 1) {
                    if(--indices[i] == 0) queue.add(i);
                }
            }
        }

        return count == numCourses;
    }
}

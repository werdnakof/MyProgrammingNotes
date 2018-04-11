package leetcode.datastructures.union_find;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=0jNmHPfA_yE
public class UnionFind {

    int[] arr;
    Map<Integer, Integer> group; // parent, group size

    public UnionFind(int n) {
        arr = new int[n];
        int i = 0;
        group = new HashMap<>();

        while(i < n) {
            arr[i] = i;
            group.put(i, 1);
            i++;
        }
    }

    public void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if(pA == pB) return;

        int sizeA = group.get(pA);
        int sizeB = group.get(pB);

        if(sizeA < sizeB) {
            arr[pA] = pB;
            group.put(pB, sizeB + sizeA);
            group.remove(pA);
        } else {
            arr[pB] = pA;
            group.put(pA, sizeB + sizeA);
            group.remove(pB);
        }

    }

    public int find(int a) {
        if(arr[a] == a) return a;
        return find(arr[a]);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(12);
        System.out.println();
    }
}

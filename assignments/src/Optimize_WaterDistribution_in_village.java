// Approach: Graph Disjoint Set Union Find
// Time: O((v + e)log(v + e))
// Space: O(v + e)

import java.util.*;

class Optimize_WaterDistribution_in_village {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i<=n; i++) {
            edges.add(new Edge(0,i,wells[i-1]));
        }

        for (int[] pipe : pipes) {
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }

        Collections.sort(edges, (a,b) -> a.c - b.c);

        DSU dsu = new DSU(n+1);

        int cost = 0;
        for (Edge edge : edges) {
            if (dsu.union(edge.h1, edge.h2)) {
                cost += edge.c;
            }
        }
        return cost;
    }
}

class Edge {
    int h1, h2, c;

    Edge(int h1, int h2, int c) {
        this.h1 = h1;
        this.h2 = h2;
        this.c = c;
    }
}

class DSU {

    private int[] parent;
    private int[] depth;

    public DSU (int n) {
        parent = new int[n];
        depth = new int[n];

        for (int i = 0; i<n; i++) {
            parent[i] = i;
            depth[i] = 1;
        }
    }

    boolean union(int a, int b) {
        int pa = find(a);           // parent of a
        int pb = find(b);           // parent of b

        if (pa == pb) return false;

        int da = depth[a], db = depth[b];

        if (da < db) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;

            if (da == db) {
                depth[da]++;
            }
        }
        return true;
    }

    int find (int a) {          // will return parent of a
        if (parent[a] == a)
            return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
}
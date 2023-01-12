import java.util.Arrays;

//Time Complexity: O((N+M)⋅log⁡(N+M))
//Space Complexity: O(N+M)
class Solution {
    private class Node {
        int val;
        int left;
        int right;

        public Node(int val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "[" + val + ":" + left + "," + right + "]";
        }
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Node[] nodes = new Node[wells.length + pipes.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            nodes[j++] = new Node(wells[i], i + 1, 0);
        }

        for (int i = 0; i < pipes.length; i++) {
            nodes[j++] = new Node(pipes[i][2], pipes[i][0], pipes[i][1]);
        }

        int total = 0;
        int[] parents = new int[n + 1];
        for (int i = 1; i < parents.length; i++) parents[i] = i;
        Arrays.sort(nodes, (x, y) -> x.val - y.val);
        for (Node node : nodes) {
            int pl = find(node.left, parents);
            int pr = find(node.right, parents);
            if (pl == pr) continue;
            union(pl, pr, parents);
            total += node.val;
        }

        return total;
    }

    private int find(int n, int[] parents) {
        if (parents[n] != n) {
            parents[n] = find(parents[n], parents);
        }
        return parents[n];
    }

    private void union(int p1, int p2, int[] parents) {
        parents[p1] = p2;
    }
}
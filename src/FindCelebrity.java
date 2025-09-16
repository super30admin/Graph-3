public class FindCelebrity {
    static int[][] graph;
    static boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }
    static int findCelebrity(int n) {
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (knows(i, j)) {
                    in[i]--;
                    in[j]++;
                }
                if (knows(j, i)) {
                    in[j]--;
                    in[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (in[i] == n - 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        graph = new int[][] {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int celebrity = findCelebrity(graph.length);
        if (celebrity == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity is person: " + celebrity);
        }
    }
}

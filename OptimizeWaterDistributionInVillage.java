// Time Complexity : O(N) 
// Space Complexity : O(N+M), where N are the number of wells(villages), M are the pipe connections,
// and N+M are the total number of edges

class Solution {
	
	private int[] rep;
	private int[] rank;

	// init each entry/point/node with rank 0 and rep as itself
	private void makeSet(int size) {
		rep = new int[size];
		rank = new int[size];
		for(int i = 0; i < size; i++){
			rep[i] = i;
		}
	}

	// find also performs path compression
	// this is the crux that makes union-find so efficient
	private int find(int x) {
		if(rep[x] != x) {
			rep[x] = find(rep[x]);
		}
		return rep[x];
	}

	// union x and y
	// return true if union was actually performed
	// false if both are already in the same set
	boolean uion(int x, int y) {
		int repX = find(x), repY = find(y);

		if(repX == repY) {
			// already in same set
			return false;
		} else if (rank[repX] < rank[repY]) {
			rep[repX] = repY;
		} else if (rank[repY] < rank[repX]) {
			rep[repY] = repX;
		} else {
			rep[repY] = repX;
			rank[repX]++;
		}
		return true;
	}

	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

		List<int[]> edges = new ArrayList<>();
		for(int[] pipe: pipes) {
			edges.add(pipe);
		}

		for(int i = 0; i < n; i++) {
			edges.add(new int[]{0, i+1, wells[i]});
		}

		
		// kruskal's
		Collections.sort(edges, (a, b) -> a[2] - b[2]);

		makeSet(n+1);

		int cost = 0;

		for(int[] edge : edges) {
			if(union(edge[0], edge[1])) {
				cost += edge[2];
			}
		}

		return cost;
	}
}
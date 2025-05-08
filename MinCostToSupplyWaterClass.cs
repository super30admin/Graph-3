// TC => O(n+mlog(n+m))
// SC => O(n+m)
public class Solution {
    int[] uf;
    public int MinCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n == 0){
            return 0;
        }
        uf = new int[n + 1];
        for(int i = 0; i< n+1; i++){
            uf[i] = i;
        }

        List<int[]> edges = new List<int[]>();
        for(int i = 0; i< n; i++){
            edges.Add([0, i+1, wells[i]]);
        }

        foreach(var pipe in pipes){
            edges.Add(pipe);
        }

        edges.Sort(Comparer<int[]>.Create((a,b) => 
        {
            return a[2] - b[2];
        }));

        int total = 0;
        foreach(var edge in edges){
            int x = edge[0];
            int y = edge[1];
            int cost = edge[2];
            int px = Find(x);
            int py = Find(y);
            if(px != py){
                total += cost;
                uf[px] = py;
            }
        }
        return total;
    }
    public int Find(int x){
        if(x != uf[x]){
            uf[x] = Find(uf[x]);
        }

        return uf[x];
    }
}


//Kruskal: O((n+m) log(n+m)) time, O(n+m) space
//Kruskal algo
int[] parent;
int res=0;
public int minCostToSupplyWater(int n, int[] wells, int[][] pipes)
{
    this.parent= new int[n+1];
    for(int i=0;i<=n;i++)
    {
        parent[i]=i;
    }
    List<int[]> edges= new ArrayList<>();
    for(int i=1;i<=n;i++)
    {
        edges.add(new int[]{0,i,wells[i-1]});
    }
    for(int[] pipe:pipes)
    {
        edges.add(pipe);
    }
    Collections.sort(edges,(a,b)->a[2]-b[2]);

    for(int[] edge: edges)
    {
        int x= edge[0];
        int y=edge[1];
        int cost= edge[2];
        int px= find(x);
        int py= find(y);
        if(px!=py)
        {
            res+=cost;
            parent[px]=py;
        }
    }
    return res;
}
private int find(int x)
{
    if(parent[x]!=x)
    {
        parent[x]=find(parent[x]);
    }
    return parent[x];
}
//Prim (PQ): O((n+m) log(n+m)) (or O((n+m) log(n))) time, O(n+m) space
//prims
public int minCostToSupplyWater1(int n, int[] wells, int[][] pipes)
{
    int res=0;
    List<int[]> edges= new ArrayList<>();
    for(int i=1;i<=n;i++)
    {
        edges.add(new int[]{0,i,wells[i-1]});
    }
    for(int[] pipe:pipes)
    {
        edges.add(pipe);
    }
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    for(int[] edge:edges)
    {
        map.putIfAbsent(edge[0], new ArrayList<>());
        map.putIfAbsent(edge[1], new ArrayList<>());
        map.get(edge[0]).add(new int[]{edge[1],edge[2]});
        map.get(edge[1]).add(new int[]{edge[0],edge[2]});
    }
    boolean[] visited= new boolean[n+1];
    PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
    pq.offer(new int[]{0,0});
    while (!pq.isEmpty())
    {
        int[] cur= pq.poll();
        int node = cur[0];
        int cost= cur[1];
       if (visited[node])
       {
           continue;
       }
       res+=cost;
       visited[node]=true;
       for(int[] ne:map.get(node))
       {
           if(visited[ne[0]]){continue;}
           pq.add(ne);
       }

    }
    return res;
}
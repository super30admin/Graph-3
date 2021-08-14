//Time: O(V + ElogE) Because of sorting 
//Space: 0(V+E) where V and E are the vertices and edges 
using Edge = vector<int>; //{src,dest,cost}
bool comparator(Edge a ,Edge b){
    return a[2] <= b[2];
}
class Solution {
    vector<Edge> edges;
    vector<int> unionFind;
public:
    int find(int val){
        if(unionFind[val] == val) return val;
        return find(unionFind[val]);
        
    }
    int minCostToSupplyWater(int n, vector<int>& wells, vector<vector<int>>& pipes) {
        unionFind.resize(n+1);
        int minCount= 0;
        for(int i = 0; i <= n; i++) unionFind[i] = i;
        for(Edge pipe : pipes) edges.push_back(pipe);
        for(int i = 1; i <= wells.size(); i++){
            edges.push_back({0,i,wells[i-1]});
        }
        sort(edges.begin(),edges.end(),comparator);
        for(Edge ed : edges){
            int px = find(ed[0]);
            int py = find(ed[1]);
            if(px != py){
                minCount += ed[2];
                unionFind[px] = py;
            }
        }
        return minCount;
    }
};
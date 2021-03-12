//Time - O(n)
//Space - O(n)
class Solution {
    
  public:
    bool static comp(vector<int> a, vector<int> b){
        return a[2]<b[2];
    }
    vector<int> parent;
    
    
    int waterDistribution(vector<int> wells, vector<vector<int>> pipes, int n){
        parent = vector<int> (n+1);
        int cost = 0;
        for(int i = 0;i<parent.size();i++){
            parent[i] = i;
        }
        
        vector<vector<int>> edges;
        for(int i = 0;i<wells.size();i++){
            edges.push_back({0,i+1,wells[i]});
        }
        
        for(int i = 0;i<pipes.size();i++){
            edges.push_back(pipes[i]);
        }
        sort(edges.begin(),edges.end(),comp);

        for(int i = 0;i<edges.size();i++){
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            if(x!=y){
                parent[y] = x;
                cost += edges[i][2]; 
            }
        }
        return cost;
    }
    
    int find(int x){
        if(x!=parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
};

int main() {
    std::cout << "Hello World!\n";
    Solution sol;
    int n = 3;
    vector<int> wells {1,2,2};
    vector<vector<int>> pipes = {{1,2,1},{2,3,1}};
    
    cout<<sol.waterDistribution(wells, pipes, n);
    return 0;

}

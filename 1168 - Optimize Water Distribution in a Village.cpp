#include <bits/stdc++.h>
using namespace std;

// Reads two integers and prints their sum
int n,m,a;

vector<int> par;

struct edge{
    int x,w;
    edge(int _x, int _w){
        x = _x; w = _w;
    }
    
    bool operator<(const edge e) const{
        return w > e.w;
    }
};

vector<vector<edge>> edges;
vector<int> wells
priority_queue<edge> q;
vector<int> vis;

using ll = long long;

ll prims(){
    ll cost = 0, aeros = 0;
    while(!q.empty())  q.pop();
    vis = vector(n+1,0);
    
    for(int i=1;i<=n;i++){
        if(vis[i])  continue;
        q.push(edge(i,0));
        aeros++; cost += a;
        //cout<<i<<endl; 
        
        while(!q.empty()){
            edge e = q.top();
            q.pop();
            if(vis[e.x] || e.w >= wells[e.x-1])  continue;
            vis[e.x] = 1;

            cost += e.w;
            //cout<<e.x<< " "<<e.w<<endl;
            for(auto adj: edges[e.x])
                q.push(adj);
        }
    }
    
    return cost;
}

int minCostToSupplyWater(int n, vector<int>& wells, vector<vector<int>>& pipes) {
    this->wells = wells;
    
    par = vector(n+1,0);
    
    for(int i=1;i<=n;i++)  par[i] = i;
    edges = vector(n+1,vector<edge>());

    for(auto &p: pipes){
        edges[p[0]].push_back(edge(p[1], p[2]));
        edges[p[1]].push_back(edge(p[0], p[2]));
    }

    return prims();
}


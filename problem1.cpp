/*
// Time Complexity : O(E+V)log(E+V)
// Space Complexity : O(E+V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
it's kruskal'a algorithm using disjoint set data structure
first make a virtual well at index 0 that give water to all the wells, which is equivalent of well being constructed there\
Then make a priority queue min heap that stores the edges u,v and sort them based on the weights that connect these vertices
Initially create a forest that has trees , where each tree is nothing but the vertices themselves
Solve until priority queue is empty
if you find that the vertices u,v using find function, you take the weight of their edge add it to the cost and merge the vertices
Use the union methoed to merge different trees that the vertices belong to 
The find operation also uses path compression for auxillay cost of O(1) to find the root parent
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

struct CustomComparator{
    bool operator()(vector<int>& v1,vector<int>& v2){
        return v1.at(2)>v2.at(2); //if greater than will go at the back because of min heap
    }
};


class Solution {

    vector<int> water_head{};

    int find(int u){
        int root = u;
        while(water_head.at(root)!= root){
            root = water_head.at(root);
        }

        int child = u;
        while(water_head.at(child)!=root){
            int temp = water_head.at(child);
            water_head.at(child) = root;
            child = temp;
        }
        return root;
    }

    void merge_rank(int u,int v){
        int root1 = find(u);
        int root2 = find(v);
        if (root1 == root2) return;
        if (root1<root2){
            water_head.at(root2) = root1; 
        }
        else{
            water_head.at(root1) = root2;
        }
        
    }



public:
    int minCostToSupplyWater(int n, vector<int>& wells, vector<vector<int>>& pipes) {
        // create array for union
        water_head.resize(n+1,0);
        for(int i{};i<n+1;++i){
            water_head.at(i) = i;
        }
        // create a min heap of the edges
        priority_queue<vector<int>,vector<vector<int>>,CustomComparator> pq;
        for(int i{};i<wells.size();++i){
            vector<int> temp{0,i+1,wells.at(i)};
            pq.push(temp);
        }
        for(vector<int>& temp:pipes){
            pq.push(temp);
        }
        // this was to display
        // while(!pq.empty()){
        //     vector<int> temp = pq.top();
        //     pq.pop();
        //     for(int i=0;i<3;++i){
        //         cout<<temp.at(i)<<" ";
        //     }
        //     cout<<endl;
        // }
        //define variable to store cost to create a pipe or well
        int cost{};
        while(!pq.empty()){
            vector<int> temp = pq.top();
            pq.pop();
            int u = temp.at(0);
            int v = temp.at(1);
            if (find(u)!=find(v)){
                cost += temp.at(2);
                merge_rank(u,v);
            }
        }
        return cost;
    }
};
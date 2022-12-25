# Graph-3

## Problem1: Distribute Water in a Village (https://leetcode.com/problems/optimize-water-distribution-in-a-village/)

// Use Disjoint Union find technique here
// Consiter an extra house with house no. as 0, and this the the borewell location
// For all the houses the borewell cost would be associated with house 0
// The pipes array would be used to add the edges for pipes
// Now we will have the graph with costs
// The sum of cost of minimum spanning tree would be our answer
// Now we will use the Kruskal algo to solve this and return the sum

## Problem 2:Find Celebrity(https://leetcode.com/problems/find-the-celebrity/)

// Take 0 as initial celebrity, and loop through 1 to n
// If current knows the other, other can be celebrity candidate
// We will reassign the candidate, 
// Once we get the candidate we can check if it knows no one
// and everybody knows him and return -1 if condition doesn't satisfy
// We will return clebrity value if the condition satisfies
//The knows API is defined in the parent class Relation.
     // boolean knows(int a, int b); 



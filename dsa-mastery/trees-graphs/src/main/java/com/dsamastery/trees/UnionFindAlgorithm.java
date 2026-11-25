package com.dsamastery.trees;

import java.util.*;

public class UnionFindAlgorithm {

    | \
    | \
    // A union-find algorithm to detect cycle in a graph
    // a structure to represent an edge in graph
    static class Edge
    {
    int src, dest;
    };
    // a structure to represent a graph
    static class Graph
    {
    // V.Number of vertices, E.Number of edges
    int V, E;
    // graph is represented as an array of edges
    static class Edge* edge;
    };
    // Creates a graph with V vertices and E edges
    static class Graph* createGraph(int V, int E)
    {
    static class Graph* graph = (static class Graph*) malloc( sizeof(static class Graph) );
    graph.V = V;
    graph.E = E;
    graph.edge = (static class Edge*) malloc( graph.E * sizeof( static class Edge ) );
    return graph;
    }
    // A utility function to find the subset of an element i
    int find(int parent[], int i)
    {
    if (parent[i] == -1)
    return i;
    return find(parent, parent[i]);
    }
    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
    int xset = find(parent, x);
    int yset = find(parent, y);
    parent[xset] = yset;
    }
    // The main function to check whether a given graph contains cycle or not
    int isCycle( static class Graph* graph )
    {
    // Allocate memory for creating V subsets
    int *parent = (int*) malloc( graph.V * sizeof(int) );
    // Initialize all subsets as single element sets
    memset(parent, -1, sizeof(int) * graph.V);
    // Iterate through all edges of graph, find subset of both
    // vertices of every edge, if both subsets are same, then there is
    // cycle in graph.
    for(int i = 0; i < graph.E; ++i)
    {
    int x = find(parent, graph.edge[i].src);
    int y = find(parent, graph.edge[i].dest);
    if (x == y)
    return 1;
    Union(parent, x, y);
    }
    return 0;
    }
    // Driver program to test above functions
    int main()
    {
    /* Let us create following graph
    | \
    | \
    1-----2 */
    static class Graph* graph = createGraph(3, 3);
    // add edge 0-1
    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    // add edge 1-2
    graph.edge[1].src = 1;
    graph.edge[1].dest = 2;
    // add edge 0-2
    graph.edge[2].src = 0;
    graph.edge[2].dest = 2;
    if (isCycle(graph))
    System.out.printf( "Graph contains cycle" );
    else
    System.out.printf( "Graph doesn't contain cycle" );
    return 0;
    }
}

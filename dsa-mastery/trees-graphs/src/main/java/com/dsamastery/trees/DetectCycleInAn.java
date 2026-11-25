package com.dsamastery.trees;

import java.util.*;

public class DetectCycleInAn {

    // A C++ Program to detect cycle in an undirected graph
    // Class for an undirected graph
    class Graph
    {
    int V; // No. of vertices
    list<int> *adj; // Pointer to an array containing adjacency lists
    boolean isCyclicUtil(int v, boolean visited[], int parent);
    public:
    Graph(int V); // Constructor
    void addEdge(int v, int w); // to add an edge to graph
    boolean isCyclic(); // returns true if there is a cycle
    };
    {
    this.V = V;
    adj = new list<int>[V];
    }
    void Graph::addEdge(int v, int w)
    {
    adj[v].push_back(w); // Add w to v’s list.
    adj[w].push_back(v); // Add v to w’s list.
    }
    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    boolean Graph::isCyclicUtil(int v, boolean visited[], int parent)
    {
    // Mark the current node as visited
    visited[v] = true;
    // Recur for all the vertices adjacent to this vertex
    list<int>::iterator i;
    for (i = adj[v].begin(); i != adj[v].end(); ++i)
    {
    // If an adjacent is not visited, then recur for that adjacent
    if (!visited[*i])
    {
    if (isCyclicUtil(*i, visited, v))
    return true;
    }
    // If an adjacent is visited and not parent of current vertex,
    // then there is a cycle.
    else if (*i != parent)
    return true;
    }
    return false;
    }
    // Returns true if the graph contains a cycle, else false.
    boolean Graph::isCyclic()
    {
    // Mark all the vertices as not visited and not part of recursion
    // stack
    boolean *visited = new boolean[V];
    for (int i = 0; i < V; i++)
    visited[i] = false;
    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for (int u = 0; u < V; u++)
    if (!visited[u]) // Don't recur for u if it is already visited
    if (isCyclicUtil(u, visited, -1))
    return true;
    return false;
    }
    // Driver program to test above functions
    int main()
    {
    Graph g1(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 0);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    g1.isCyclic()? cout << "Graph contains cycle\n":
    System.out.print("Graph doesn't contain cycle\n");
    Graph g2(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    g2.isCyclic()? cout << "Graph contains cycle\n":
    System.out.print("Graph doesn't contain cycle\n");
    return 0;
    }
}

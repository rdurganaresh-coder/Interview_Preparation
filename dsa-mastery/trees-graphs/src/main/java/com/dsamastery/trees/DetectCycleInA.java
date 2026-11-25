package com.dsamastery.trees;

import java.util.*;

public class DetectCycleInA {

    return false. For example, the following graph contains three cycles 0.2.0,
    // A C++ Program to detect cycle in a graph
    class Graph
    {
    int V; // No. of vertices
    list<int> *adj; // Pointer to an array containing adjacency lists
    boolean isCyclicUtil(int v, boolean visited[], boolean *rs); // used by isCyclic()
    public:
    Graph(int V); // Constructor
    void addEdge(int v, int w); // to add an edge to graph
    boolean isCyclic(); // returns true if there is a cycle in this graph
    };
    {
    this.V = V;
    adj = new list<int>[V];
    }
    void Graph::addEdge(int v, int w)
    {
    adj[v].push_back(w); // Add w to v’s list.
    }
    // This function is a variation of DFSUytil() in http://www.geeksforgeeks.org/archives/18212
    boolean Graph::isCyclicUtil(int v, boolean visited[], boolean *recStack)
    {
    if(visited[v] == false)
    {
    // Mark the current node as visited and part of recursion stack
    visited[v] = true;
    recStack[v] = true;
    // Recur for all the vertices adjacent to this vertex
    list<int>::iterator i;
    for(i = adj[v].begin(); i != adj[v].end(); ++i)
    {
    if ( !visited[*i] && isCyclicUtil(*i, visited, recStack) )
    return true;
    else if (recStack[*i])
    return true;
    }
    }
    recStack[v] = false; // remove the vertex from recursion stack
    return false;
    }
    // Returns true if the graph contains a cycle, else false.
    // This function is a variation of DFS() in http://www.geeksforgeeks.org/archives/18212
    boolean Graph::isCyclic()
    {
    // Mark all the vertices as not visited and not part of recursion
    // stack
    boolean *visited = new boolean[V];
    boolean *recStack = new boolean[V];
    for(int i = 0; i < V; i++)
    {
    visited[i] = false;
    recStack[i] = false;
    }
    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for(int i = 0; i < V; i++)
    if (isCyclicUtil(i, visited, recStack))
    return true;
    return false;
    }
    int main()
    {
    // Create a graph given in the above diagram
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    if(g.isCyclic())
    System.out.print("Graph contains cycle");
    else
    System.out.print("Graph doesn't contain cycle");
    return 0;
    }
}

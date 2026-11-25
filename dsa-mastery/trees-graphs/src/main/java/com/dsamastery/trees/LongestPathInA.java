package com.dsamastery.trees;

import java.util.*;

public class LongestPathInA {

    int _w) { v = _v; weight = _w;} int getV() { return v; } int getWeight()
    longestPath void topologicalSortUtil(int v, boolean visited[], stack<int> &Stack);
    void addEdge(int u, int v, int weight); // Finds longest distances from given
    u, int v, int weight) { AdjListNode node(v, weight); adj[u].push_back(node);
    // Add v to u’s list } // A recursive function used by longestPath. See be-
    Topological Sort // starting from all vertices one by one for (int i = 0; i < V;
    distances to all vertices as inﬁnite and distance // to source as 0 for (int i = 0;
    while (Stack.empty() == false) { // Get the next vertex from topological order
    int u = Stack.top(); Stack.pop(); // Update distances of all adjacent vertices
    list<AdjListNode>::iterator i; if (dist[u] != NINF) { for (i = adj[u].begin(); i !=
    adj[u].end(); ++i)if(dist[i.getV()]<dist[u]+i.getWeight())dist[i.getV()]
    = dist[u] + i.getWeight(); } } // Print the calculated longest distances for (int
    i = 0; i < V; i++) (dist[i] == NINF)? System.out.print(“INF ”: cout << dist[i] << ” “);
    mappings: // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z Graph g(6); g.addEdge(0, 1, 5);
    g.addEdge(0, 2, 3); g.addEdge(1, 3, 6); g.addEdge(1, 2, 2); g.addEdge(2, 4, 4);
    g.addEdge(2, 5, 2); g.addEdge(2, 3, 7); g.addEdge(3, 5, 1); g.addEdge(3, 4, -1);
    source vertex ” << s <<” \n”; g.longestPath(s); return 0; }
}

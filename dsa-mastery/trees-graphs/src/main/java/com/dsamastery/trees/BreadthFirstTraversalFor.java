package com.dsamastery.trees;

import java.util.*;

public class BreadthFirstTraversalFor {

    // Program to print BFS traversal from a given source vertex. BFS(int s)
    // traverses vertices reachable from s.
    // This class represents a directed graph using adjacency list representation
    class Graph
    {
    int V; // No. of vertices
    list<int> *adj; // Pointer to an array containing adjacency lists
    public:
    Graph(int V); // Constructor
    void addEdge(int v, int w); // function to add an edge to graph
    void BFS(int s); // prints BFS traversal from a given source s
    };
    {
    this.V = V;
    adj = new list<int>[V];
    }
    void Graph::addEdge(int v, int w)
    {
    adj[v].push_back(w); // Add w to v’s list.
    }
    void Graph::BFS(int s)
    {
    // Mark all the vertices as not visited
    boolean *visited = new boolean[V];
    for(int i = 0; i < V; i++)
    visited[i] = false;
    // Create a queue for BFS
    list<int> queue;
    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.push_back(s);
    // 'i' will be used to get all adjacent vertices of a vertex
    list<int>::iterator i;
    while(!queue.empty())
    {
    // Dequeue a vertex from queue and print it
    s = queue.front();
    System.out.print(s << " ");
    queue.pop_front();
    // Get all adjacent vertices of the dequeued vertex s
    // If a adjacent has not been visited, then mark it visited
    // and enqueue it
    for(i = adj[s].begin(); i != adj[s].end(); ++i)
    {
    if(!visited[*i])
    {
    visited[*i] = true;
    queue.push_back(*i);
    }
    }
    }
    }
    // Driver program to test methods of graph class
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
    System.out.print("Following is Breadth First Traversal (starting from vertex 2) \n");
    g.BFS(2);
    return 0;
    }
    // Java program to print BFS traversal from a given source vertex.
    // BFS(int s) traverses vertices reachable from s.
    import java.io.*;
    import java.util.*;
    // This class represents a directed graph using adjacency list
    // representation
    class Graph
    {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    // Constructor
    Graph(int v)
    {
    V = v;
    adj = new LinkedList[v];
    for (int i=0; i<v; ++i)
    adj[i] = new LinkedList();
    }
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
    adj[v].add(w);
    }
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean visited[] = new boolean[V];
    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // Mark the current node as visited and enqueue it
    visited[s]=true;
    queue.add(s);
    while (queue.size() != 0)
    {
    // Dequeue a vertex from queue and print it
    s = queue.poll();
    System.out.print(s+" ");
    // Get all adjacent vertices of the dequeued vertex s
    // If a adjacent has not been visited, then mark it
    // visited and enqueue it
    Iterator<Integer> i = adj[s].listIterator();
    while (i.hasNext())
    {
    int n = i.next();
    if (!visited[n])
    {
    visited[n] = true;
    queue.add(n);
    }
    }
    }
    }
    // Driver method to
    public static void main(String args[])
    {
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    System.out.println("Following is Breadth First Traversal "+
    "(starting from vertex 2)");
    g.BFS(2);
    }
    }
    // This code is contributed by Aakash Hasija
    Following is Breadth First Traversal (starting from vertex 2)
}

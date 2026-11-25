package com.dsamastery.trees;

import java.util.*;

public class GraphAndIts {

    // A C Program to demonstrate adjacency list representation of graphs
    // A structure to represent an adjacency list node
    static class AdjListNode
    {
    int dest;
    static class AdjListNode* next;
    };
    // A structure to represent an adjacency liat
    static class AdjList
    {
    static class AdjListNode *head; // pointer to head node of list
    };
    // A structure to represent a graph. A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices in graph)
    static class Graph
    {
    int V;
    static class AdjList* array;
    };
    // A utility function to create a new adjacency list node
    static class AdjListNode* newAdjListNode(int dest)
    {
    static class AdjListNode* newNode =
    (static class AdjListNode*) malloc(sizeof(static class AdjListNode));
    newNode.dest = dest;
    newNode.next = null;
    return newNode;
    }
    // A utility function that creates a graph of V vertices
    static class Graph* createGraph(int V)
    {
    static class Graph* graph = (static class Graph*) malloc(sizeof(static class Graph));
    graph.V = V;
    // Create an array of adjacency lists. Size of array will be V
    graph.array = (static class AdjList*) malloc(V * sizeof(static class AdjList));
    // Initialize each adjacency list as empty by making head as null
    int i;
    for (i = 0; i < V; ++i)
    graph.array[i].head = null;
    return graph;
    }
    // Adds an edge to an undirected graph
    void addEdge(static class Graph* graph, int src, int dest)
    {
    // Add an edge from src to dest. A new node is added to the adjacency
    // list of src. The node is added at the begining
    static class AdjListNode* newNode = newAdjListNode(dest);
    newNode.next = graph.array[src].head;
    graph.array[src].head = newNode;
    // Since graph is undirected, add an edge from dest to src also
    newNode = newAdjListNode(src);
    newNode.next = graph.array[dest].head;
    graph.array[dest].head = newNode;
    }
    // A utility function to print the adjacenncy list representation of graph
    void printGraph(static class Graph* graph)
    {
    int v;
    for (v = 0; v < graph.V; ++v)
    {
    static class AdjListNode* pCrawl = graph.array[v].head;
    System.out.printf("\n Adjacency list of vertex %d\n head ", v);
    while (pCrawl)
    {
    System.out.printf("-> %d", pCrawl.dest);
    pCrawl = pCrawl.next;
    }
    System.out.printf("\n");
    }
    }
    // Driver program to test above functions
    int main()
    {
    // create the graph given in above fugure
    int V = 5;
    static class Graph* graph = createGraph(V);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);
    // print the adjacency list representation of the above graph
    printGraph(graph);
    return 0;
    }
}

package com.dsamastery.trees;

import java.util.*;

public class PrimSMstFor {

    // C / C++ program for Prim's MST for adjacency list representation of graph
    // A structure to represent a node in adjacency list
    static class AdjListNode
    {
    int dest;
    int weight;
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
    static class AdjListNode* newAdjListNode(int dest, int weight)
    {
    static class AdjListNode* newNode =
    (static class AdjListNode*) malloc(sizeof(static class AdjListNode));
    newNode.dest = dest;
    newNode.weight = weight;
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
    for (int i = 0; i < V; ++i)
    graph.array[i].head = null;
    return graph;
    }
    // Adds an edge to an undirected graph
    void addEdge(static class Graph* graph, int src, int dest, int weight)
    {
    // Add an edge from src to dest. A new node is added to the adjacency
    // list of src. The node is added at the begining
    static class AdjListNode* newNode = newAdjListNode(dest, weight);
    newNode.next = graph.array[src].head;
    graph.array[src].head = newNode;
    // Since graph is undirected, add an edge from dest to src also
    newNode = newAdjListNode(src, weight);
    newNode.next = graph.array[dest].head;
    graph.array[dest].head = newNode;
    }
    // Structure to represent a min heap node
    static class MinHeapNode
    {
    int v;
    int key;
    };
    // Structure to represent a min heap
    static class MinHeap
    {
    int size; // Number of heap nodes present currently
    int capacity; // Capacity of min heap
    int *pos; // This is needed for decreaseKey()
    static class MinHeapNode **array;
    };
    // A utility function to create a new Min Heap Node
    static class MinHeapNode* newMinHeapNode(int v, int key)
    {
    static class MinHeapNode* minHeapNode =
    (static class MinHeapNode*) malloc(sizeof(static class MinHeapNode));
    minHeapNode.v = v;
    minHeapNode.key = key;
    return minHeapNode;
    }
    // A utilit function to create a Min Heap
    static class MinHeap* createMinHeap(int capacity)
    {
    static class MinHeap* minHeap =
    (static class MinHeap*) malloc(sizeof(static class MinHeap));
    minHeap.pos = (int *)malloc(capacity * sizeof(int));
    minHeap.size = 0;
    minHeap.capacity = capacity;
    minHeap.array =
    (static class MinHeapNode**) malloc(capacity * sizeof(static class MinHeapNode*));
    return minHeap;
    }
    // A utility function to swap two nodes of min heap. Needed for min heapify
    void swapMinHeapNode(static class MinHeapNode** a, static class MinHeapNode** b)
    {
    static class MinHeapNode* t = *a;
    *a = *b;
    *b = t;
    }
    // A standard function to heapify at given idx
    // This function also updates position of nodes when they are swapped.
    // Position is needed for decreaseKey()
    void minHeapify(static class MinHeap* minHeap, int idx)
    {
    int smallest, left, right;
    smallest = idx;
    left = 2 * idx + 1;
    right = 2 * idx + 2;
    if (left < minHeap.size &&
    minHeap.array[left]->key < minHeap.array[smallest]->key )
    smallest = left;
    if (right < minHeap.size &&
    minHeap.array[right]->key < minHeap.array[smallest]->key )
    smallest = right;
    if (smallest != idx)
    {
    // The nodes to be swapped in min heap
    MinHeapNode *smallestNode = minHeap.array[smallest];
    MinHeapNode *idxNode = minHeap.array[idx];
    // Swap positions
    minHeap.pos[smallestNode.v] = idx;
    minHeap.pos[idxNode.v] = smallest;
    // Swap nodes
    swapMinHeapNode(&minHeap.array[smallest], &minHeap.array[idx]);
    minHeapify(minHeap, smallest);
    }
    }
    // A utility function to check if the given minHeap is ampty or not
    int isEmpty(static class MinHeap* minHeap)
    {
    return minHeap.size == 0;
    }
    // Standard function to extract minimum node from heap
    static class MinHeapNode* extractMin(static class MinHeap* minHeap)
    {
    if (isEmpty(minHeap))
    return null;
    // Store the root node
    static class MinHeapNode* root = minHeap.array[0];
    // Replace root node with last node
    static class MinHeapNode* lastNode = minHeap.array[minHeap.size - 1];
    minHeap.array[0] = lastNode;
    // Update position of last node
    minHeap.pos[root.v] = minHeap.size-1;
    minHeap.pos[lastNode.v] = 0;
    // Reduce heap size and heapify root
    --minHeap.size;
    minHeapify(minHeap, 0);
    return root;
    }
    // Function to decreasy key value of a given vertex v. This function
    // uses pos[] of min heap to get the current index of node in min heap
    void decreaseKey(static class MinHeap* minHeap, int v, int key)
    {
    // Get the index of v in heap array
    int i = minHeap.pos[v];
    // Get the node and update its key value
    minHeap.array[i]->key = key;
    // Travel up while the complete tree is not hepified.
    // This is a O(Logn) loop
    while (i && minHeap.array[i]->key < minHeap.array[(i - 1) / 2]->key)
    {
    // Swap this node with its parent
    minHeap.pos[minHeap.array[i]->v] = (i-1)/2;
    minHeap.pos[minHeap.array[(i-1)/2]->v] = i;
    swapMinHeapNode(&minHeap.array[i], &minHeap.array[(i - 1) / 2]);
    // move to parent index
    i = (i - 1) / 2;
    }
    }
    // A utility function to check if a given vertex
    // 'v' is in min heap or not
    boolean isInMinHeap(static class MinHeap *minHeap, int v)
    {
    if (minHeap.pos[v] < minHeap.size)
    return true;
    return false;
    }
    // A utility function used to print the constructed MST
    void printArr(int arr[], int n)
    {
    for (int i = 1; i < n; ++i)
    System.out.printf("%d - %d\n", arr[i], i);
    }
    // The main function that constructs Minimum Spanning Tree (MST)
    // using Prim's algorithm
    void PrimMST(static class Graph* graph)
    {
    int V = graph.V;// Get the number of vertices in graph
    int parent[V]; // Array to store constructed MST
    int key[V]; // Key values used to pick minimum weight edge in cut
    // minHeap represents set E
    static class MinHeap* minHeap = createMinHeap(V);
    // Initialize min heap with all vertices. Key value of
    // all vertices (except 0th vertex) is initially infinite
    for (int v = 1; v < V; ++v)
    {
    parent[v] = -1;
    key[v] = INT_MAX;
    minHeap.array[v] = newMinHeapNode(v, key[v]);
    minHeap.pos[v] = v;
    }
    // Make key value of 0th vertex as 0 so that it
    // is extracted first
    key[0] = 0;
    minHeap.array[0] = newMinHeapNode(0, key[0]);
    minHeap.pos[0] = 0;
    // Initially size of min heap is equal to V
    minHeap.size = V;
    // In the followin loop, min heap contains all nodes
    // not yet added to MST.
    while (!isEmpty(minHeap))
    {
    // Extract the vertex with minimum key value
    static class MinHeapNode* minHeapNode = extractMin(minHeap);
    int u = minHeapNode.v; // Store the extracted vertex number
    // Traverse through all adjacent vertices of u (the extracted
    // vertex) and update their key values
    static class AdjListNode* pCrawl = graph.array[u].head;
    while (pCrawl != null)
    {
    int v = pCrawl.dest;
    // If v is not yet included in MST and weight of u-v is
    // less than key value of v, then update key value and
    // parent of v
    if (isInMinHeap(minHeap, v) && pCrawl.weight < key[v])
    {
    key[v] = pCrawl.weight;
    parent[v] = u;
    decreaseKey(minHeap, v, key[v]);
    }
    pCrawl = pCrawl.next;
    }
    }
    // print edges of MST
    printArr(parent, V);
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create the graph given in above fugure
    int V = 9;
    static class Graph* graph = createGraph(V);
    addEdge(graph, 0, 1, 4);
    addEdge(graph, 0, 7, 8);
    addEdge(graph, 1, 2, 8);
    addEdge(graph, 1, 7, 11);
    addEdge(graph, 2, 3, 7);
    addEdge(graph, 2, 8, 2);
    addEdge(graph, 2, 5, 4);
    addEdge(graph, 3, 4, 9);
    addEdge(graph, 3, 5, 14);
    addEdge(graph, 4, 5, 10);
    addEdge(graph, 5, 6, 2);
    addEdge(graph, 6, 7, 1);
    addEdge(graph, 6, 8, 6);
    addEdge(graph, 7, 8, 7);
    PrimMST(graph);
    return 0;
    }
}

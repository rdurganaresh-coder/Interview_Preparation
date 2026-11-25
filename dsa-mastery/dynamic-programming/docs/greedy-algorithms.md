# Greedy Algorithms

> **Original PDF:** [Greedy Algorithms.pdf](../../docs/Greedy Algorithms.pdf)

## Table of Contents

- [Chapter 1: Greedy Algorithms | Set 1 (Activity](#chapter-1-greedy-algorithms-set-1-activity)
- [Chapter 2: Job Sequencing Problem | Set 1](#chapter-2-job-sequencing-problem-set-1)
- [Chapter 3: Greedy Algorithms | Set 3 (Huﬀman](#chapter-3-greedy-algorithms-set-3-huﬀman)
- [Chapter 4: Greedy Algorithms | Set 4 (Eﬃcient](#chapter-4-greedy-algorithms-set-4-eﬃcient)
- [Chapter 5: Dijsktra’s algorith](#chapter-5-dijsktras-algorith)
- [Chapter 6: Greedy Algorithms | Set 8 (Dijkstra’s](#chapter-6-greedy-algorithms-set-8-dijkstras)
- [Chapter 7: Greedy Algorithms | Set 2 (Kruskal’s](#chapter-7-greedy-algorithms-set-2-kruskals)
- [Chapter 8: Greedy Algorithms | Set 5 (Prim’s](#chapter-8-greedy-algorithms-set-5-prims)
- [Chapter 9: Greedy Algorithms | Set 6 (Prim’s](#chapter-9-greedy-algorithms-set-6-prims)
- [Chapter 10: K Centers Problem | Set 1 (Greedy](#chapter-10-k-centers-problem-set-1-greedy)

---

## Chapter 1: Greedy Algorithms | Set 1 (Activity

> **Java Implementation:** [`GreedyAlgorithms.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms.java) (`dynamic-programming`)

Selection Problem) Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that oﬀers the most obvious and immediate beneﬁt. Greedy algorithms are used for optimization problems.
An optimization problem can be solved using Greedy if the problem has the following property: At every step, we can make a choice that looks best at the moment, and we get the optimal solution of the complete problem.
If a Greedy Algorithm can solve a problem, then it generally becomes the best method to solve that problem as the Greedy algorithms are in general more eﬃcient than other techniques like Dynamic Programming.
But Greedy algorithms cannot always be applied. For example, Fractional Knapsack problem (See this) can be solved using Greedy, but 0-1 Knapsack cannot be solved using Greedy.
Following are some standard algorithms that are Greedy algorithms.
1) Kruskal’s Minimum Spanning Tree (MST): In Kruskal’s algorithm, we create a MST by picking edges one by one. The Greedy Choice is to pick the smallest weight edge that doesn’t cause a cycle in the MST constructed so far.
2) Prim’s Minimum Spanning Tree: In Prim’s algorithm also, we create a MST by picking edges one by one. We maintain two sets: set of the vertices already included in MST and the set of the vertices not yet included. The Greedy Choice is to pick the smallest weight edge that connects the two sets.
3) Dijkstra’s Shortest Path: The Dijkstra’s algorithm is very similar to Prim’s algorithm. The shortest path tree is built up, edge by edge. We maintain two sets: set of the vertices already included in the tree and the set of the vertices not yet included. The Greedy Choice is to pick the edge that connects the two sets and is on the smallest weight path from source to the set that contains not yet included vertices.
4) Huﬀman Coding: Huﬀman Coding is a loss-less compression technique. It assigns variable length bit codes to diﬀerent characters. The Greedy Choice is to assign least bit length code to the most frequent character.
The greedy algorithms are sometimes also used to get an approximation for Hard optimization problems.
For example, Traveling Salesman Problem is a NP Hard problem. A Greedy choice for this problem is to pick the nearest unvisited city from the current city at every step. This solutions doesn’t always produce the best optimal solution, but can be used to get an approximate optimal solution.
Let us consider the Activity Selection problem as our ﬁrst example of Greedy algorithms. Following is the problem statement.
You are given n activities with their start and ﬁnish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

### Example

Consider the following 6 activities.

```java
start[] = {1, 3, 0, 5, 8, 5};
finish[] = {2, 4, 6, 7, 9, 9};
```

The maximum set of activities that can be executed

```java
by a single person is {0, 1, 3, 4}
```

The greedy choice is to always pick the next activity whose ﬁnish time is least among the remaining activities and the start time is more than or equal to the ﬁnish time of previously selected activity. We can sort the activities according to their ﬁnishing time so that we always consider the next activity as minimum ﬁnishing time activity.
1) Sort the activities according to their ﬁnishing time 2) Select the ﬁrst activity from the sorted array and print it.
3) Do following for remaining activities in the sorted array.
…….a) If the start time of this activity is greater than the ﬁnish time of previously selected activity then select this activity and print it.
In the following C implementation, it is assumed that the activities are already sorted according to their ﬁnish time.

```java
#include<stdio.h>
// Prints a maximum set of activities that can be done by a single
// person, one at a time.
// n --> Total number of activities
// s[] --> An array that contains start time of all activities
// f[] --> An array that contains finish time of all activities
void printMaxActivities(int s[], int f[], int n)
{
int i, j;
printf ("Following activities are selected \n");
// The first activity always gets selected
i = 0;
printf("%d ", i);
// Consider rest of the activities
for (j = 1; j < n; j++)
{
// If this activity has start time greater than or equal to the finish
// time of previously selected activity, then select it
if (s[j] >= f[i])
{
printf ("%d ", j);
i = j;
}
}
}
// driver program to test above function
int main()
{
int s[] = {1, 3, 0, 5, 8, 5};
int f[] = {2, 4, 6, 7, 9, 9};
int n = sizeof(s)/sizeof(s[0]);
printMaxActivities(s, f, n);
getchar();
return 0;
}
```

### Output

Following activities are selected 0 1 3 4 How does Greedy Choice work for Activities sorted according to ﬁnish time?
Let the give set of activities be S = {1, 2, 3, ..n} and activities be sorted by ﬁnish time. The greedy choice is to always pick activity 1. How come the activity 1 always provides one of the optimal solutions. We can prove it by showing that if there is another solution B with ﬁrst activity other than 1, then there is also a solution A of same size with activity 1 as ﬁrst activity. Let the ﬁrst activity selected by B be k, then there always exist A = {B – {k}} U {1}.(Note that the activities in B are independent and k has smallest ﬁnishing time among all. Since k is not 1, ﬁnish(k) >= ﬁnish(1)).

### References

Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Cliﬀord Stein Algorithms by S. Dasgupta, C.H. Papadimitriou, and U.V. Vazirani
- [Reference Link](http://en.wikipedia.org/wiki/Greedy_algorithm)
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 2: Job Sequencing Problem | Set 1

> **Java Implementation:** [`JobSequencingProblem.java`](../src/main/java/com/dsamastery/dp/JobSequencingProblem.java) (`dynamic-programming`)

(Greedy Algorithm) Given an array of jobs where every job has a deadline and associated proﬁt if the job is ﬁnished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total proﬁt if only one job can be scheduled at a time.

### Examples

Input: Four Jobs with following deadlines and profits JobID Deadline Profit a 4 20 b 1 10 c 1 40 d 1 30 Output: Following is maximum profit sequence of jobs c, a Input: Five Jobs with following deadlines and profits JobID Deadline Profit a 2 100 b 1 19 c 2 27 d 1 25 e 3 15 Output: Following is maximum profit sequence of jobs c, a, e We strongly recommend to minimize your browser and try this yourself ﬁrst.
A Simple Solution is to generate all subsets of given set of jobs and check individual subset for feasibility of jobs in that subset. Keep track of maximum proﬁt among all feasible subsets. The time complexity of this solution is exponential.
This is a standard Greedy Algorithmproblem. Following is algorithm.
1) Sort all jobs in decreasing order of profit.
2) Initialize the result sequence as first job in sorted jobs.
3) Do following for remaining n-1 jobs .......a) If the current job can fit in the current result sequence without missing the deadline, add current job to the result.
Else ignore the current job.
The Following is C++ implementation of above algorithm.

```java
// Program to find the maximum profit job sequence from a given array
// of jobs with deadlines and profits
#include<iostream>
#include<algorithm>
using namespace std;
// A structure to represent a job
struct Job
{
char id; // Job Id
int dead; // Deadline of job
int profit; // Profit if job is over before or on deadline
};
// This function is used for sorting all jobs according to profit
bool comparison(Job a, Job b)
{
return (a.profit > b.profit);
}
// Returns minimum number of platforms reqquired
void printJobScheduling(Job arr[], int n)
{
// Sort all jobs according to decreasing order of prfit
sort(arr, arr+n, comparison);
int result[n]; // To store result (Sequence of jobs)
bool slot[n]; // To keep track of free time slots
// Initialize all slots to be free
for (int i=0; i<n; i++)
slot[i] = false;
// Iterate through all given jobs
for (int i=0; i<n; i++)
{
// Find a free slot for this job (Note that we start
// from the last possible slot)
for (int j=min(n, arr[i].dead)-1; j>=0; j--)
{
// Free slot found
if (slot[j]==false)
{
result[j] = i; // Add this job to result
slot[j] = true; // Make this slot occupied
break;
}
}
}
// Print the result
for (int i=0; i<n; i++)
if (slot[i])
cout << arr[result[i]].id << " ";
}
// Driver program to test methods
int main()
{
Job arr[5] = { {'a', 2, 100}, {'b', 1, 19}, {'c', 2, 27},
{'d', 1, 25}, {'e', 3, 15}};
int n = sizeof(arr)/sizeof(arr[0]);
cout << "Following is maximum profit sequence of jobs\n";
printJobScheduling(arr, n);
return 0;
}
```

### Output

Following is maximum profit sequence of jobs c a e Time Complexity of the above solution is O(n2). It can be optimized to almost O(n) by using union-ﬁnd data structure. We will son be discussing the optimized solution.
Sources:
- [Reference Link](http://ocw.mit.edu/courses/civil-and-environmental-engineering/1-204-computer-algorithms-in-systems-engineering-spring-2010/)
lecture-notes/MIT1_204S10_lec10.pdf This article is contributed by Shubham. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/)
Category: Misc Tags: Greedy Algorithm

[↑ Back to Top](#table-of-contents)

---

## Chapter 3: Greedy Algorithms | Set 3 (Huﬀman

> **Java Implementation:** [`GreedyAlgorithms2.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms2.java) (`dynamic-programming`)

Coding) Huﬀman coding is a lossless data compression algorithm. The idea is to assign variable-legth codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters. The most frequent character gets the smallest code and the least frequent character gets the largest code.
The variable-length codes assigned to input characters are Preﬁx Codes, means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not preﬁx of code assigned to any other character. This is how Huﬀman Coding makes sure that there is no ambiguity when decoding the generated bit stream.
Let us understand preﬁx codes with a counter example. Let there be four characters a, b, c and d, and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity because code assigned to c is preﬁx of codes assigned to a and b. If the compressed bit stream is 0001, the de-compressed output may be “cccd” or “ccb” or “acd” or “ab”.
See this for applications of Huﬀman Coding.
There are mainly two major parts in Huﬀman Coding 1) Build a Huﬀman Tree from input characters.
2) Traverse the Huﬀman Tree and assign codes to characters.
Steps to build Huﬀman Tree Input is array of unique characters along with their frequency of occurrences and output is Huﬀman Tree.
1. Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency ﬁeld is used to compare two nodes in min heap. Initially, the least frequent character is at root) 2. Extract two nodes with the minimum frequency from the min heap.
3. Create a new internal node with frequency equal to the sum of the two nodes frequencies. Make the ﬁrst extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
4. Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
Let us understand the algorithm with an example:
character Frequency a 5 b 9 c 12 d 13 e 16 f 45 Step 1. Build a min heap that contains 6 nodes where each node represents root of a tree with single node.
Step 2 Extract two minimum frequency nodes from min heap. Add a new internal node with frequency 5 + 9 = 14.
Now min heap contains 5 nodes where 4 nodes are roots of trees with single element each, and one heap node is root of tree with 3 elements character Frequency c 12 d 13 Internal Node 14 e 16 f 45 Step 3: Extract two minimum frequency nodes from heap. Add a new internal node with frequency 12 + 13 = 25 Now min heap contains 4 nodes where 2 nodes are roots of trees with single element each, and two heap nodes are root of tree with more than one nodes.
character Frequency Internal Node 14 e 16 Internal Node 25 f 45 Step 4: Extract two minimum frequency nodes. Add a new internal node with frequency 14 + 16 = 30 Now min heap contains 3 nodes.
character Frequency Internal Node 25 Internal Node 30 f 45 Step 5: Extract two minimum frequency nodes. Add a new internal node with frequency 25 + 30 = 55 Now min heap contains 2 nodes.
character Frequency f 45 Internal Node 55 Step 6: Extract two minimum frequency nodes. Add a new internal node with frequency 45 + 55 = 100 Now min heap contains only one node.
character Frequency Internal Node 100 Since the heap contains only one node, the algorithm stops here.
Steps to print codes from Huﬀman Tree:
Traverse the tree formed starting from the root. Maintain an auxiliary array. While moving to the left child, write 0 to the array. While moving to the right child, write 1 to the array. Print the array when a leaf node is encountered.
The codes are as follows:
character code-word f 0 c 100 d 101 a 1100 b 1101 e 111

```java
// C program for Huffman Coding
#include <stdio.h>
#include <stdlib.h>
// This constant can be avoided by explicitly calculating height of Huffman Tree
#define MAX_TREE_HT 100
// A Huffman tree node
struct MinHeapNode
{
char data; // One of the input characters
unsigned freq; // Frequency of the character
struct MinHeapNode *left, *right; // Left and right child of this node
};
// A Min Heap: Collection of min heap (or Hufmman tree) nodes
struct MinHeap
{
unsigned size; // Current size of min heap
unsigned capacity; // capacity of min heap
struct MinHeapNode **array; // Attay of minheap node pointers
};
// A utility function allocate a new min heap node with given character
// and frequency of the character
struct MinHeapNode* newNode(char data, unsigned freq)
{
struct MinHeapNode* temp =
(struct MinHeapNode*) malloc(sizeof(struct MinHeapNode));
temp->left = temp->right = NULL;
temp->data = data;
temp->freq = freq;
return temp;
}
// A utility function to create a min heap of given capacity
struct MinHeap* createMinHeap(unsigned capacity)
{
struct MinHeap* minHeap =
(struct MinHeap*) malloc(sizeof(struct MinHeap));
minHeap->size = 0; // current size is 0
minHeap->capacity = capacity;
minHeap->array =
(struct MinHeapNode**)malloc(minHeap->capacity * sizeof(struct MinHeapNode*));
return minHeap;
}
// A utility function to swap two min heap nodes
void swapMinHeapNode(struct MinHeapNode** a, struct MinHeapNode** b)
{
struct MinHeapNode* t = *a;
*a = *b;
*b = t;
}
// The standard minHeapify function.
void minHeapify(struct MinHeap* minHeap, int idx)
{
int smallest = idx;
int left = 2 * idx + 1;
int right = 2 * idx + 2;
if (left < minHeap->size &&
minHeap->array[left]->freq < minHeap->array[smallest]->freq)
smallest = left;
if (right < minHeap->size &&
minHeap->array[right]->freq < minHeap->array[smallest]->freq)
smallest = right;
if (smallest != idx)
{
swapMinHeapNode(&minHeap->array[smallest], &minHeap->array[idx]);
minHeapify(minHeap, smallest);
}
}
// A utility function to check if size of heap is 1 or not
int isSizeOne(struct MinHeap* minHeap)
{
return (minHeap->size == 1);
}
// A standard function to extract minimum value node from heap
struct MinHeapNode* extractMin(struct MinHeap* minHeap)
{
struct MinHeapNode* temp = minHeap->array[0];
minHeap->array[0] = minHeap->array[minHeap->size - 1];
--minHeap->size;
minHeapify(minHeap, 0);
return temp;
}
// A utility function to insert a new node to Min Heap
void insertMinHeap(struct MinHeap* minHeap, struct MinHeapNode* minHeapNode)
{
++minHeap->size;
int i = minHeap->size - 1;
while (i && minHeapNode->freq < minHeap->array[(i - 1)/2]->freq)
{
minHeap->array[i] = minHeap->array[(i - 1)/2];
i = (i - 1)/2;
}
minHeap->array[i] = minHeapNode;
}
// A standard funvtion to build min heap
void buildMinHeap(struct MinHeap* minHeap)
{
int n = minHeap->size - 1;
int i;
for (i = (n - 1) / 2; i >= 0; --i)
minHeapify(minHeap, i);
}
// A utility function to print an array of size n
void printArr(int arr[], int n)
{
int i;
for (i = 0; i < n; ++i)
printf("%d", arr[i]);
printf("\n");
}
// Utility function to check if this node is leaf
int isLeaf(struct MinHeapNode* root)
{
return !(root->left) && !(root->right) ;
}
// Creates a min heap of capacity equal to size and inserts all character of
// data[] in min heap. Initially size of min heap is equal to capacity
struct MinHeap* createAndBuildMinHeap(char data[], int freq[], int size)
{
struct MinHeap* minHeap = createMinHeap(size);
for (int i = 0; i < size; ++i)
minHeap->array[i] = newNode(data[i], freq[i]);
minHeap->size = size;
buildMinHeap(minHeap);
return minHeap;
}
// The main function that builds Huffman tree
struct MinHeapNode* buildHuffmanTree(char data[], int freq[], int size)
{
struct MinHeapNode *left, *right, *top;
// Step 1: Create a min heap of capacity equal to size. Initially, there are
// modes equal to size.
struct MinHeap* minHeap = createAndBuildMinHeap(data, freq, size);
// Iterate while size of heap doesn't become 1
while (!isSizeOne(minHeap))
{
// Step 2: Extract the two minimum freq items from min heap
left = extractMin(minHeap);
right = extractMin(minHeap);
// Step 3: Create a new internal node with frequency equal to the
// sum of the two nodes frequencies. Make the two extracted node as
// left and right children of this new node. Add this node to the min heap
// '$' is a special value for internal nodes, not used
top = newNode('$', left->freq + right->freq);
top->left = left;
top->right = right;
insertMinHeap(minHeap, top);
}
// Step 4: The remaining node is the root node and the tree is complete.
return extractMin(minHeap);
}
// Prints huffman codes from the root of Huffman Tree. It uses arr[] to
// store codes
void printCodes(struct MinHeapNode* root, int arr[], int top)
{
// Assign 0 to left edge and recur
if (root->left)
{
arr[top] = 0;
printCodes(root->left, arr, top + 1);
}
// Assign 1 to right edge and recur
if (root->right)
{
arr[top] = 1;
printCodes(root->right, arr, top + 1);
}
// If this is a leaf node, then it contains one of the input
// characters, print the character and its code from arr[]
if (isLeaf(root))
{
printf("%c: ", root->data);
printArr(arr, top);
}
}
// The main function that builds a Huffman Tree and print codes by traversing
// the built Huffman Tree
void HuffmanCodes(char data[], int freq[], int size)
{
// Construct Huffman Tree
struct MinHeapNode* root = buildHuffmanTree(data, freq, size);
// Print Huffman codes using the Huffman tree built above
int arr[MAX_TREE_HT], top = 0;
printCodes(root, arr, top);
}
// Driver program to test above functions
int main()
{
char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
int freq[] = {5, 9, 12, 13, 16, 45};
int size = sizeof(arr)/sizeof(arr[0]);
HuffmanCodes(arr, freq, size);
return 0;
}
```

f: 0 c: 100 d: 101 a: 1100 b: 1101 e: 111 Time complexity: O(nlogn) where n is the number of unique characters. If there are n nodes, extractMin() is called 2*(n – 1) times. extractMin() takes O(logn) time as it calles minHeapify(). So, overall complexity is O(nlogn).
If the input array is sorted, there exists a linear time algorithm. We will soon be discussing in our next post.
Reference:
- [Reference Link](http://en.wikipedia.org/wiki/Huffman_coding)
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/)
Category: Misc Tags: Greedy Algorithm, Huﬀman Coding

[↑ Back to Top](#table-of-contents)

---

## Chapter 4: Greedy Algorithms | Set 4 (Eﬃcient

> **Java Implementation:** [`GreedyAlgorithms3.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms3.java) (`dynamic-programming`)

Huﬀman Coding for Sorted Input) We recommend to read following post as a prerequisite for this.
Greedy Algorithms | Set 3 (Huﬀman Coding) Time complexity of the algorithm discussed in above post is O(nLogn). If we know that the given array is sorted (by non-decreasing order of frequency), we can generate Huﬀman codes in O(n) time. Following is a O(n) algorithm for sorted input.
1. Create two empty queues.
2. Create a leaf node for each unique character and Enqueue it to the ﬁrst queue in non-decreasing order of frequency. Initially second queue is empty.
3. Dequeue two nodes with the minimum frequency by examining the front of both queues. Repeat following steps two times …..a) If second queue is empty, dequeue from ﬁrst queue.
…..b) If ﬁrst queue is empty, dequeue from second queue.
…..c) Else, compare the front of two queues and dequeue the minimum.
4. Create a new internal node with frequency equal to the sum of the two nodes frequencies. Make the ﬁrst Dequeued node as its left child and the second Dequeued node as right child. Enqueue this node to second queue.
5. Repeat steps#3 and #4 until there is more than one node in the queues. The remaining node is the root node and the tree is complete.

```java
// C Program for Efficient Huffman Coding for Sorted input
#include <stdio.h>
#include <stdlib.h>
// This constant can be avoided by explicitly calculating height of Huffman Tree
#define MAX_TREE_HT 100
// A node of huffman tree
struct QueueNode
{
char data;
unsigned freq;
struct QueueNode *left, *right;
};
// Structure for Queue: collection of Huffman Tree nodes (or QueueNodes)
struct Queue
{
int front, rear;
int capacity;
struct QueueNode **array;
};
// A utility function to create a new Queuenode
struct QueueNode* newNode(char data, unsigned freq)
{
struct QueueNode* temp =
(struct QueueNode*) malloc(sizeof(struct QueueNode));
temp->left = temp->right = NULL;
temp->data = data;
temp->freq = freq;
return temp;
}
// A utility function to create a Queue of given capacity
struct Queue* createQueue(int capacity)
{
struct Queue* queue = (struct Queue*) malloc(sizeof(struct Queue));
queue->front = queue->rear = -1;
queue->capacity = capacity;
queue->array =
(struct QueueNode**) malloc(queue->capacity * sizeof(struct QueueNode*));
return queue;
}
// A utility function to check if size of given queue is 1
int isSizeOne(struct Queue* queue)
{
return queue->front == queue->rear && queue->front != -1;
}
// A utility function to check if given queue is empty
int isEmpty(struct Queue* queue)
{
return queue->front == -1;
}
// A utility function to check if given queue is full
int isFull(struct Queue* queue)
{
return queue->rear == queue->capacity - 1;
}
// A utility function to add an item to queue
void enQueue(struct Queue* queue, struct QueueNode* item)
{
if (isFull(queue))
return;
queue->array[++queue->rear] = item;
if (queue->front == -1)
++queue->front;
}
// A utility function to remove an item from queue
struct QueueNode* deQueue(struct Queue* queue)
{
if (isEmpty(queue))
return NULL;
struct QueueNode* temp = queue->array[queue->front];
if (queue->front == queue->rear) // If there is only one item in queue
queue->front = queue->rear = -1;
else
++queue->front;
return temp;
}
// A utility function to get from of queue
struct QueueNode* getFront(struct Queue* queue)
{
if (isEmpty(queue))
return NULL;
return queue->array[queue->front];
}
/* A function to get minimum item from two queues */
struct QueueNode* findMin(struct Queue* firstQueue, struct Queue* secondQueue)
{
// Step 3.a: If second queue is empty, dequeue from first queue
if (isEmpty(firstQueue))
return deQueue(secondQueue);
// Step 3.b: If first queue is empty, dequeue from second queue
if (isEmpty(secondQueue))
return deQueue(firstQueue);
// Step 3.c: Else, compare the front of two queues and dequeue minimum
if (getFront(firstQueue)->freq < getFront(secondQueue)->freq)
return deQueue(firstQueue);
return deQueue(secondQueue);
}
// Utility function to check if this node is leaf
int isLeaf(struct QueueNode* root)
{
return !(root->left) && !(root->right) ;
}
// A utility function to print an array of size n
void printArr(int arr[], int n)
{
int i;
for (i = 0; i < n; ++i)
printf("%d", arr[i]);
printf("\n");
}
// The main function that builds Huffman tree
struct QueueNode* buildHuffmanTree(char data[], int freq[], int size)
{
struct QueueNode *left, *right, *top;
// Step 1: Create two empty queues
struct Queue* firstQueue = createQueue(size);
struct Queue* secondQueue = createQueue(size);
// Step 2:Create a leaf node for each unique character and Enqueue it to
// the first queue in non-decreasing order of frequency. Initially second
// queue is empty
for (int i = 0; i < size; ++i)
enQueue(firstQueue, newNode(data[i], freq[i]));
// Run while Queues contain more than one node. Finally, first queue will
// be empty and second queue will contain only one node
while (!(isEmpty(firstQueue) && isSizeOne(secondQueue)))
{
// Step 3: Dequeue two nodes with the minimum frequency by examining
// the front of both queues
left = findMin(firstQueue, secondQueue);
right = findMin(firstQueue, secondQueue);
// Step 4: Create a new internal node with frequency equal to the sum
// of the two nodes frequencies. Enqueue this node to second queue.
top = newNode('$' , left->freq + right->freq);
top->left = left;
top->right = right;
enQueue(secondQueue, top);
}
return deQueue(secondQueue);
}
// Prints huffman codes from the root of Huffman Tree. It uses arr[] to
// store codes
void printCodes(struct QueueNode* root, int arr[], int top)
{
// Assign 0 to left edge and recur
if (root->left)
{
arr[top] = 0;
printCodes(root->left, arr, top + 1);
}
// Assign 1 to right edge and recur
if (root->right)
{
arr[top] = 1;
printCodes(root->right, arr, top + 1);
}
// If this is a leaf node, then it contains one of the input
// characters, print the character and its code from arr[]
if (isLeaf(root))
{
printf("%c: ", root->data);
printArr(arr, top);
}
}
// The main function that builds a Huffman Tree and print codes by traversing
// the built Huffman Tree
void HuffmanCodes(char data[], int freq[], int size)
{
// Construct Huffman Tree
struct QueueNode* root = buildHuffmanTree(data, freq, size);
// Print Huffman codes using the Huffman tree built above
int arr[MAX_TREE_HT], top = 0;
printCodes(root, arr, top);
}
// Driver program to test above functions
int main()
{
char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
int freq[] = {5, 9, 12, 13, 16, 45};
int size = sizeof(arr)/sizeof(arr[0]);
HuffmanCodes(arr, freq, size);
return 0;
}
```

### Output

f: 0 c: 100 d: 101 a: 1100 b: 1101 e: 111 Time complexity: O(n) If the input is not sorted, it need to be sorted ﬁrst before it can be processed by the above algorithm. Sorting can be done using heap-sort or merge-sort both of which run in Theta(nlogn). So, the overall time complexity becomes O(nlogn) for unsorted input.
Reference:
- [Reference Link](http://en.wikipedia.org/wiki/Huffman_coding)
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding-set-2/)
Category: Misc Tags: Greedy Algorithm, Huﬀman Coding

[↑ Back to Top](#table-of-contents)

---

## Chapter 5: Dijsktra’s algorith

> **Java Implementation:** [`DijsktraSAlgorith.java`](../src/main/java/com/dsamastery/dp/DijsktraSAlgorith.java) (`dynamic-programming`)

Given a graph and a source vertex in graph, ﬁnd shortest paths from source to all vertices in the given graph.
Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree. Like Prim’s MST, we generate a SPT (shortest path tree) with given source as root. We maintain two sets, one set contains vertices included in shortest path tree, other set includes vertices not yet included in shortest path tree. At every step of the algorithm, we ﬁnd a vertex which is in the other set (set of not yet included) and has minimum distance from source.
Below are the detailed steps used in Dijkstra’s algorithm to ﬁnd the shortest path from a single source vertex to all other vertices in the given graph.
Algorithm 1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, i.e., whose minimum distance from source is calculated and ﬁnalized. Initially, this set is empty.
2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE.
Assign distance value as 0 for the source vertex so that it is picked ﬁrst.
3) While sptSet doesn’t include all vertices ….a) Pick a vertex u which is not there in sptSetand has minimum distance value.
….b) Include u to sptSet.
….c) Update distance value of all adjacent vertices of u. To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
Let us understand with the following example:
The set sptSetis initially empty and distances assigned to vertices are {0, INF, INF, INF, INF, INF, INF, INF} where INF indicates inﬁnite. Now pick the vertex with minimum distance value. The vertex 0 is picked, include it in sptSet. So sptSet becomes {0}. After including 0 to sptSet, update distance values of its adjacent vertices. Adjacent vertices of 0 are 1 and 7. The distance values of 1 and 7 are updated as 4 and 8. Following subgraph shows vertices and their distance values, only the vertices with ﬁnite distance values are shown. The vertices included in SPT are shown in green color.
Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). The vertex 1 is picked and added to sptSet. So sptSet now becomes {0, 1}. Update the distance values of adjacent vertices of 1. The distance value of vertex 2 becomes 12.
Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). Vertex 7 is picked. So sptSet now becomes {0, 1, 7}. Update the distance values of adjacent vertices of 7. The distance value of vertex 6 and 8 becomes ﬁnite (15 and 9 respectively).
Pick the vertex with minimum distance value and not already included in SPT (not in sptSET). Vertex 6 is picked. So sptSet now becomes {0, 1, 7, 6}. Update the distance values of adjacent vertices of 6. The distance value of vertex 5 and 8 are updated.
We repeat the above steps until sptSet doesn’t include all vertices of given graph. Finally, we get the following Shortest Path Tree (SPT).
How to implement the above algorithm?
We use a boolean array sptSet[] to represent the set of vertices included in SPT. If a value sptSet[v] is true, then vertex v is included in SPT, otherwise not. Array dist[] is used to store shortest distance values of all vertices.

```java
// A C / C++ program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
#include <stdio.h>
#include <limits.h>
// Number of vertices in the graph
#define V 9
// A utility function to find the vertex with minimum distance value, from
// the set of vertices not yet included in shortest path tree
int minDistance(int dist[], bool sptSet[])
{
// Initialize min value
int min = INT_MAX, min_index;
for (int v = 0; v < V; v++)
if (sptSet[v] == false && dist[v] <= min)
min = dist[v], min_index = v;
return min_index;
}
// A utility function to print the constructed distance array
int printSolution(int dist[], int n)
{
printf("Vertex Distance from Source\n");
for (int i = 0; i < V; i++)
printf("%d \t\t %d\n", i, dist[i]);
}
// Funtion that implements Dijkstra's single source shortest path algorithm
// for a graph represented using adjacency matrix representation
void dijkstra(int graph[V][V], int src)
{
int dist[V]; // The output array. dist[i] will hold the shortest
// distance from src to i
bool sptSet[V]; // sptSet[i] will true if vertex i is included in shortest
// path tree or shortest distance from src to i is finalized
// Initialize all distances as INFINITE and stpSet[] as false
for (int i = 0; i < V; i++)
dist[i] = INT_MAX, sptSet[i] = false;
// Distance of source vertex from itself is always 0
dist[src] = 0;
// Find shortest path for all vertices
for (int count = 0; count < V-1; count++)
{
// Pick the minimum distance vertex from the set of vertices not
// yet processed. u is always equal to src in first iteration.
int u = minDistance(dist, sptSet);
// Mark the picked vertex as processed
sptSet[u] = true;
// Update dist value of the adjacent vertices of the picked vertex.
for (int v = 0; v < V; v++)
// Update dist[v] only if is not in sptSet, there is an edge from
// u to v, and total weight of path from src to v through u is
// smaller than current value of dist[v]
if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX
&& dist[u]+graph[u][v] < dist[v])
dist[v] = dist[u] + graph[u][v];
}
// print the constructed distance array
printSolution(dist, V);
}
// driver program to test above function
int main()
{
/* Let us create the example graph discussed above */
int graph[V][V] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
{4, 0, 8, 0, 0, 0, 0, 11, 0},
{0, 8, 0, 7, 0, 4, 0, 0, 2},
{0, 0, 7, 0, 9, 14, 0, 0, 0},
{0, 0, 0, 9, 0, 10, 0, 0, 0},
{0, 0, 4, 0, 10, 0, 2, 0, 0},
{0, 0, 0, 14, 0, 2, 0, 1, 6},
{8, 11, 0, 0, 0, 0, 1, 0, 7},
{0, 0, 2, 0, 0, 0, 6, 7, 0}
};
dijkstra(graph, 0);
return 0;
}
```

### Output

Vertex Distance from Source 0 0 1 4 2 12 3 19 4 21 5 11 6 9 7 8 8 14 Notes:
1) The code calculates shortest distance, but doesn’t calculate the path information. We can create a parent array, update the parent array when distance is updated (like prim’s implementation) and use it show the shortest path from source to diﬀerent vertices.
2) The code is for undirected graph, same dijekstra function can be used for directed graphs also.
3) The code ﬁnds shortest distances from source to all vertices. If we are interested only in shortest distance from source to a single target, we can break the for loop when the picked minimum distance vertex is equal to target (Step 3.a of algorithm).
4) Time Complexity of the implementation is O(Vˆ2). If the input graph is represented using adjacency list, it can be reduced to O(E log V) with the help of binary heap. Please see Dijkstra’s Algorithm for Adjacency List Representation for more details.
5) Dijkstra’s algorithm doesn’t work for graphs with negative weight edges. For graphs with negative weight edges, Bellman–Ford algorithm can be used, we will soon be discussing it as a separate post.
Dijkstra’s Algorithm for Adjacency List Representation Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/)
Category: Graph Tags: Dijkstra, Graph, Greedy Algorithm

[↑ Back to Top](#table-of-contents)

---

## Chapter 6: Greedy Algorithms | Set 8 (Dijkstra’s

> **Java Implementation:** [`GreedyAlgorithms4.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms4.java) (`dynamic-programming`)

Algorithm for Adjacency List Representation) We recommend to read following two posts as a prerequisite of this post.
1. Greedy Algorithms | Set 7 (Dijkstra’s shortest path algorithm) 2. Graph and its representations We have discussed Dijkstra’s algorithm and its implementation for adjacency matrix representation of graphs.
ThetimecomplexityforthematrixrepresentationisO(Vˆ2). Inthispost, O(ELogV)algorithmforadjacency list representation is discussed.
As discussed in the previous post, in Dijkstra’s algorithm, two sets are maintained, one set contains list of vertices already included in SPT (Shortest Path Tree), other set contains vertices not yet included. With adjacency list representation, all vertices of a graph can be traversed in O(V+E) time using BFS. The idea is to traverse all vertices of graph using BFS and use a Min Heap to store the vertices not yet included in SPT (or the vertices for which shortest distance is not ﬁnalized yet). Min Heap is used as a priority queue to get the minimum distance vertex from set of not yet included vertices. Time complexity of operations like extract-min and decrease-key value is O(LogV) for Min Heap.
Following are the detailed steps.
1) Create a Min Heap of size V where V is the number of vertices in the given graph. Every node of min heap contains vertex number and distance value of the vertex.
2) Initialize Min Heap with source vertex as root (the distance value assigned to source vertex is 0). The distance value assigned to all other vertices is INF (inﬁnite).
3) While Min Heap is not empty, do following …..a) Extract the vertex with minimum distance value node from Min Heap. Let the extracted vertex be u.
…..b) For every adjacent vertex v of u, check if v is in Min Heap. If v is in Min Heap and distance value is more than weight of u-v plus distance value of u, then update the distance value of v.
Let us understand with the following example. Let the given source vertex be 0 Initially, distance value of source vertex is 0 and INF (inﬁnite) for all other vertices. So source vertex is extracted from Min Heap and distance values of vertices adjacent to 0 (1 and 7) are updated. Min Heap contains all vertices except vertex 0.
The vertices in green color are the vertices for which minimum distances are ﬁnalized and are not in Min Heap Since distance value of vertex 1 is minimum among all nodes in Min Heap, it is extracted from Min Heap and distance values of vertices adjacent to 1 are updated (distance is updated if the a vertex is not in Min Heap and distance through 1 is shorter than the previous distance). Min Heap contains all vertices except vertex 0 and 1.
Pick the vertex with minimum distance value from min heap. Vertex 7 is picked. So min heap now contains all vertices except 0, 1 and 7. Update the distance values of adjacent vertices of 7. The distance value of vertex 6 and 8 becomes ﬁnite (15 and 9 respectively).
Pick the vertex with minimum distance from min heap. Vertex 6 is picked. So min heap now contains all vertices except 0, 1, 7 and 6. Update the distance values of adjacent vertices of 6. The distance value of vertex 5 and 8 are updated.
Above steps are repeated till min heap doesn’t become empty. Finally, we get the following shortest path tree.

```java
// C / C++ program for Dijkstra's shortest path algorithm for adjacency
// list representation of graph
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
// A structure to represent a node in adjacency list
struct AdjListNode
{
int dest;
int weight;
struct AdjListNode* next;
};
// A structure to represent an adjacency liat
struct AdjList
{
struct AdjListNode *head; // pointer to head node of list
};
// A structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)
struct Graph
{
int V;
struct AdjList* array;
};
// A utility function to create a new adjacency list node
struct AdjListNode* newAdjListNode(int dest, int weight)
{
struct AdjListNode* newNode =
(struct AdjListNode*) malloc(sizeof(struct AdjListNode));
newNode->dest = dest;
newNode->weight = weight;
newNode->next = NULL;
return newNode;
}
// A utility function that creates a graph of V vertices
struct Graph* createGraph(int V)
{
struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph));
graph->V = V;
// Create an array of adjacency lists. Size of array will be V
graph->array = (struct AdjList*) malloc(V * sizeof(struct AdjList));
// Initialize each adjacency list as empty by making head as NULL
for (int i = 0; i < V; ++i)
graph->array[i].head = NULL;
return graph;
}
// Adds an edge to an undirected graph
void addEdge(struct Graph* graph, int src, int dest, int weight)
{
// Add an edge from src to dest. A new node is added to the adjacency
// list of src. The node is added at the begining
struct AdjListNode* newNode = newAdjListNode(dest, weight);
newNode->next = graph->array[src].head;
graph->array[src].head = newNode;
// Since graph is undirected, add an edge from dest to src also
newNode = newAdjListNode(src, weight);
newNode->next = graph->array[dest].head;
graph->array[dest].head = newNode;
}
// Structure to represent a min heap node
struct MinHeapNode
{
int v;
int dist;
};
// Structure to represent a min heap
struct MinHeap
{
int size; // Number of heap nodes present currently
int capacity; // Capacity of min heap
int *pos; // This is needed for decreaseKey()
struct MinHeapNode **array;
};
// A utility function to create a new Min Heap Node
struct MinHeapNode* newMinHeapNode(int v, int dist)
{
struct MinHeapNode* minHeapNode =
(struct MinHeapNode*) malloc(sizeof(struct MinHeapNode));
minHeapNode->v = v;
minHeapNode->dist = dist;
return minHeapNode;
}
// A utility function to create a Min Heap
struct MinHeap* createMinHeap(int capacity)
{
struct MinHeap* minHeap =
(struct MinHeap*) malloc(sizeof(struct MinHeap));
minHeap->pos = (int *)malloc(capacity * sizeof(int));
minHeap->size = 0;
minHeap->capacity = capacity;
minHeap->array =
(struct MinHeapNode**) malloc(capacity * sizeof(struct MinHeapNode*));
return minHeap;
}
// A utility function to swap two nodes of min heap. Needed for min heapify
void swapMinHeapNode(struct MinHeapNode** a, struct MinHeapNode** b)
{
struct MinHeapNode* t = *a;
*a = *b;
*b = t;
}
// A standard function to heapify at given idx
// This function also updates position of nodes when they are swapped.
// Position is needed for decreaseKey()
void minHeapify(struct MinHeap* minHeap, int idx)
{
int smallest, left, right;
smallest = idx;
left = 2 * idx + 1;
right = 2 * idx + 2;
if (left < minHeap->size &&
minHeap->array[left]->dist < minHeap->array[smallest]->dist )
smallest = left;
if (right < minHeap->size &&
minHeap->array[right]->dist < minHeap->array[smallest]->dist )
smallest = right;
if (smallest != idx)
{
// The nodes to be swapped in min heap
MinHeapNode *smallestNode = minHeap->array[smallest];
MinHeapNode *idxNode = minHeap->array[idx];
// Swap positions
minHeap->pos[smallestNode->v] = idx;
minHeap->pos[idxNode->v] = smallest;
// Swap nodes
swapMinHeapNode(&minHeap->array[smallest], &minHeap->array[idx]);
minHeapify(minHeap, smallest);
}
}
// A utility function to check if the given minHeap is ampty or not
int isEmpty(struct MinHeap* minHeap)
{
return minHeap->size == 0;
}
// Standard function to extract minimum node from heap
struct MinHeapNode* extractMin(struct MinHeap* minHeap)
{
if (isEmpty(minHeap))
return NULL;
// Store the root node
struct MinHeapNode* root = minHeap->array[0];
// Replace root node with last node
struct MinHeapNode* lastNode = minHeap->array[minHeap->size - 1];
minHeap->array[0] = lastNode;
// Update position of last node
minHeap->pos[root->v] = minHeap->size-1;
minHeap->pos[lastNode->v] = 0;
// Reduce heap size and heapify root
--minHeap->size;
minHeapify(minHeap, 0);
return root;
}
// Function to decreasy dist value of a given vertex v. This function
// uses pos[] of min heap to get the current index of node in min heap
void decreaseKey(struct MinHeap* minHeap, int v, int dist)
{
// Get the index of v in heap array
int i = minHeap->pos[v];
// Get the node and update its dist value
minHeap->array[i]->dist = dist;
// Travel up while the complete tree is not hepified.
// This is a O(Logn) loop
while (i && minHeap->array[i]->dist < minHeap->array[(i - 1) / 2]->dist)
{
// Swap this node with its parent
minHeap->pos[minHeap->array[i]->v] = (i-1)/2;
minHeap->pos[minHeap->array[(i-1)/2]->v] = i;
swapMinHeapNode(&minHeap->array[i], &minHeap->array[(i - 1) / 2]);
// move to parent index
i = (i - 1) / 2;
}
}
// A utility function to check if a given vertex
// 'v' is in min heap or not
bool isInMinHeap(struct MinHeap *minHeap, int v)
{
if (minHeap->pos[v] < minHeap->size)
return true;
return false;
}
// A utility function used to print the solution
void printArr(int dist[], int n)
{
printf("Vertex Distance from Source\n");
for (int i = 0; i < n; ++i)
printf("%d \t\t %d\n", i, dist[i]);
}
// The main function that calulates distances of shortest paths from src to all
// vertices. It is a O(ELogV) function
void dijkstra(struct Graph* graph, int src)
{
int V = graph->V;// Get the number of vertices in graph
int dist[V]; // dist values used to pick minimum weight edge in cut
// minHeap represents set E
struct MinHeap* minHeap = createMinHeap(V);
// Initialize min heap with all vertices. dist value of all vertices
for (int v = 0; v < V; ++v)
{
dist[v] = INT_MAX;
minHeap->array[v] = newMinHeapNode(v, dist[v]);
minHeap->pos[v] = v;
}
// Make dist value of src vertex as 0 so that it is extracted first
minHeap->array[src] = newMinHeapNode(src, dist[src]);
minHeap->pos[src] = src;
dist[src] = 0;
decreaseKey(minHeap, src, dist[src]);
// Initially size of min heap is equal to V
minHeap->size = V;
// In the followin loop, min heap contains all nodes
// whose shortest distance is not yet finalized.
while (!isEmpty(minHeap))
{
// Extract the vertex with minimum distance value
struct MinHeapNode* minHeapNode = extractMin(minHeap);
int u = minHeapNode->v; // Store the extracted vertex number
// Traverse through all adjacent vertices of u (the extracted
// vertex) and update their distance values
struct AdjListNode* pCrawl = graph->array[u].head;
while (pCrawl != NULL)
{
int v = pCrawl->dest;
// If shortest distance to v is not finalized yet, and distance to v
// through u is less than its previously calculated distance
if (isInMinHeap(minHeap, v) && dist[u] != INT_MAX &&
pCrawl->weight + dist[u] < dist[v])
{
dist[v] = dist[u] + pCrawl->weight;
// update distance value in min heap also
decreaseKey(minHeap, v, dist[v]);
}
pCrawl = pCrawl->next;
}
}
// print the calculated shortest distances
printArr(dist, V);
}
// Driver program to test above functions
int main()
{
// create the graph given in above fugure
int V = 9;
struct Graph* graph = createGraph(V);
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
dijkstra(graph, 0);
return 0;
}
```

### Output

Vertex Distance from Source 0 0 1 4 2 12 3 19 4 21 5 11 6 9 7 8 8 14 Time Complexity: The time complexity of the above code/algorithm looks O(Vˆ2) as there are two nested while loops. If we take a closer look, we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS). The inner loop has decreaseKey() operation which takes O(LogV) time. So overall time complexity is O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV) Note that the above code uses Binary Heap for Priority Queue implementation. Time complexity can be reduced to O(E + VLogV) using Fibonacci Heap. The reason is, Fibonacci Heap takes O(1) time for decrease-key operation while Binary Heap takes O(Logn) time.
Notes:
1) The code calculates shortest distance, but doesn’t calculate the path information. We can create a parent array, update the parent array when distance is updated (like prim’s implementation) and use it show the shortest path from source to diﬀerent vertices.
2) The code is for undirected graph, same dijekstra function can be used for directed graphs also.
3) The code ﬁnds shortest distances from source to all vertices. If we are interested only in shortest distance from source to a single target, we can break the for loop when the picked minimum distance vertex is equal to target (Step 3.a of algorithm).
4) Dijkstra’s algorithm doesn’t work for graphs with negative weight edges. For graphs with negative weight edges, Bellman–Ford algorithm can be used, we will soon be discussing it as a separate post.

### References

Introduction to Algorithms by Cliﬀord Stein, Thomas H. Cormen, Charles E. Leiserson, Ronald L.
Algorithms by Sanjoy Dasgupta, Christos Papadimitriou, Umesh Vazirani Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-7-dijkstras-algorithm-for-adjacency-list-representation/)
Category: Graph Tags: Dijkstra, Graph, Greedy Algorithm

[↑ Back to Top](#table-of-contents)

---

## Chapter 7: Greedy Algorithms | Set 2 (Kruskal’s

> **Java Implementation:** [`GreedyAlgorithms5.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms5.java) (`dynamic-programming`)

Minimum Spanning Tree Algorithm) What is Minimum Spanning Tree?
Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many diﬀerent spanning trees. A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected and undirected graph is a spanning tree with weight less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.
How many edges does a minimum spanning tree has?
A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
What are the applications of Minimum Spanning Tree?
See thisfor applications of MST.
Below are the steps for ﬁnding MST using Kruskal’s algorithm 1. Sort all the edges in non-decreasing order of their weight.
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it.
3. Repeat step#2 until there are (V-1) edges in the spanning tree.
The step#2 uses Union-Find algorithm to detect cycle. So we recommend to read following post as a prerequisite.
Union-Find Algorithm | Set 1 (Detect Cycle in a Graph) Union-Find Algorithm | Set 2 (Union By Rank and Path Compression) The algorithm is a Greedy Algorithm. The Greedy Choice is to pick the smallest weight edge that does not cause a cycle in the MST constructed so far. Let us understand it with an example: Consider the below input graph.
The graph contains 9 vertices and 14 edges. So, the minimum spanning tree formed will be having (9 – 1) = 8 edges.
After sorting:
Weight Src Dest 1 7 6 2 8 2 2 6 5 4 0 1 4 2 5 6 8 6 7 2 3 7 7 8 8 0 7 8 1 2 9 3 4 10 5 4 11 1 7 14 3 5 Now pick all edges one by one from sorted list of edges 1. Pick edge 7-6: No cycle is formed, include it.
2. Pick edge 8-2: No cycle is formed, include it.
3. Pick edge 6-5: No cycle is formed, include it.
4. Pick edge 0-1: No cycle is formed, include it.
5. Pick edge 2-5: No cycle is formed, include it.
6. Pick edge 8-6: Since including this edge results in cycle, discard it.
7. Pick edge 2-3: No cycle is formed, include it.
8. Pick edge 7-8: Since including this edge results in cycle, discard it.
9. Pick edge 0-7: No cycle is formed, include it.
10. Pick edge 1-2: Since including this edge results in cycle, discard it.
11. Pick edge 3-4: No cycle is formed, include it.
Since the number of edges included equals (V – 1), the algorithm stops here.

```java
// Kruskal's algortihm to find Minimum Spanning Tree of a given connected,
// undirected and weighted graph
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// a structure to represent a weighted edge in graph
struct Edge
{
int src, dest, weight;
};
// a structure to represent a connected, undirected and weighted graph
struct Graph
{
// V-> Number of vertices, E-> Number of edges
int V, E;
// graph is represented as an array of edges. Since the graph is
// undirected, the edge from src to dest is also edge from dest
// to src. Both are counted as 1 edge here.
struct Edge* edge;
};
// Creates a graph with V vertices and E edges
struct Graph* createGraph(int V, int E)
{
struct Graph* graph = (struct Graph*) malloc( sizeof(struct Graph) );
graph->V = V;
graph->E = E;
graph->edge = (struct Edge*) malloc( graph->E * sizeof( struct Edge ) );
return graph;
}
// A structure to represent a subset for union-find
struct subset
{
int parent;
int rank;
};
// A utility function to find set of an element i
// (uses path compression technique)
int find(struct subset subsets[], int i)
{
// find root and make root as parent of i (path compression)
if (subsets[i].parent != i)
subsets[i].parent = find(subsets, subsets[i].parent);
return subsets[i].parent;
}
// A function that does union of two sets of x and y
// (uses union by rank)
void Union(struct subset subsets[], int x, int y)
{
int xroot = find(subsets, x);
int yroot = find(subsets, y);
// Attach smaller rank tree under root of high rank tree
// (Union by Rank)
if (subsets[xroot].rank < subsets[yroot].rank)
subsets[xroot].parent = yroot;
else if (subsets[xroot].rank > subsets[yroot].rank)
subsets[yroot].parent = xroot;
// If ranks are same, then make one as root and increment
// its rank by one
else
{
subsets[yroot].parent = xroot;
subsets[xroot].rank++;
}
}
// Compare two edges according to their weights.
// Used in qsort() for sorting an array of edges
int myComp(const void* a, const void* b)
{
struct Edge* a1 = (struct Edge*)a;
struct Edge* b1 = (struct Edge*)b;
return a1->weight > b1->weight;
}
// The main function to construct MST using Kruskal's algorithm
void KruskalMST(struct Graph* graph)
{
int V = graph->V;
struct Edge result[V]; // Tnis will store the resultant MST
int e = 0; // An index variable, used for result[]
int i = 0; // An index variable, used for sorted edges
// Step 1: Sort all the edges in non-decreasing order of their weight
// If we are not allowed to change the given graph, we can create a copy of
// array of edges
qsort(graph->edge, graph->E, sizeof(graph->edge[0]), myComp);
// Allocate memory for creating V ssubsets
struct subset *subsets =
(struct subset*) malloc( V * sizeof(struct subset) );
// Create V subsets with single elements
for (int v = 0; v < V; ++v)
{
subsets[v].parent = v;
subsets[v].rank = 0;
}
// Number of edges to be taken is equal to V-1
while (e < V - 1)
{
// Step 2: Pick the smallest edge. And increment the index
// for next iteration
struct Edge next_edge = graph->edge[i++];
int x = find(subsets, next_edge.src);
int y = find(subsets, next_edge.dest);
// If including this edge does't cause cycle, include it
// in result and increment the index of result for next edge
if (x != y)
{
result[e++] = next_edge;
Union(subsets, x, y);
}
// Else discard the next_edge
}
// print the contents of result[] to display the built MST
printf("Following are the edges in the constructed MST\n");
for (i = 0; i < e; ++i)
printf("%d -- %d == %d\n", result[i].src, result[i].dest,
result[i].weight);
return;
}
// Driver program to test above functions
int main()
{
/* Let us create following weighted graph
0--------1
| \ |
6| 5\ |15
| \ |
2--------3
4 */
int V = 4; // Number of vertices in graph
int E = 5; // Number of edges in graph
struct Graph* graph = createGraph(V, E);
// add edge 0-1
graph->edge[0].src = 0;
graph->edge[0].dest = 1;
graph->edge[0].weight = 10;
// add edge 0-2
graph->edge[1].src = 0;
graph->edge[1].dest = 2;
graph->edge[1].weight = 6;
// add edge 0-3
graph->edge[2].src = 0;
graph->edge[2].dest = 3;
graph->edge[2].weight = 5;
// add edge 1-3
graph->edge[3].src = 1;
graph->edge[3].dest = 3;
graph->edge[3].weight = 15;
// add edge 2-3
graph->edge[4].src = 2;
graph->edge[4].dest = 3;
graph->edge[4].weight = 4;
KruskalMST(graph);
return 0;
}
```

Following are the edges in the constructed MST 2 -- 3 == 4 0 -- 3 == 5 0 -- 1 == 10 Time Complexity: O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. After sorting, we iterate through all edges and apply ﬁnd-union algorithm. The ﬁnd and union operations can take atmost O(LogV) time. So overall complexity is O(ELogE + ELogV) time. The value of E can be atmost Vˆ2, so O(LogV) are O(LogE) same. Therefore, overall time complexity is O(ElogE) or O(ElogV)

### References

- [Reference Link](http://www.ics.uci.edu/~eppstein/161/960206.html)
- [Reference Link](http://en.wikipedia.org/wiki/Minimum_spanning_tree)
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 8: Greedy Algorithms | Set 5 (Prim’s

> **Java Implementation:** [`GreedyAlgorithms6.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms6.java) (`dynamic-programming`)

Minimum Spanning Tree (MST)) We have discussed Kruskal’s algorithm for Minimum Spanning Tree. Like Kruskal’s algorithm, Prim’s algorithm is also a Greedy algorithm. It starts with an empty spanning tree. The idea is to maintain two sets of vertices. The ﬁrst set contains the vertices already included in the MST, the other set contains the vertices not yet included. At every step, it considers all the edges that connect the two sets, and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST.
A group of edges that connects two set of vertices in a graph is called cut in graph theory. So, at every step of Prim’s algorithm, we ﬁnd a cut (of two sets, one contains the vertices already included in MST and other contains rest of the verices), pick the minimum weight edge from the cut and include this vertex to MST Set (the set that contains already included vertices).
How does Prim’s Algorithm Work? The idea behind Prim’s algorithm is simple, a spanning tree means all vertices must be connected. So the two disjoint subsets (discussed above) of vertices must be connected to make a Spanning Tree. And they must be connected with the minimum weight edge to make it a Minimum Spanning Tree.
Algorithm 1) Create a set mstSet that keeps track of vertices already included in MST.
2) Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE. Assign key value as 0 for the ﬁrst vertex so that it is picked ﬁrst.
3) While mstSet doesn’t include all vertices ….a) Pick a vertex u which is not there in mstSet and has minimum key value.
….b) Include u to mstSet.
….c) Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v The idea of using key values is to pick the minimum weight edge from cut. The key values are used only for vertices which are not yet included in MST, the key value for these vertices indicate the minimum weight edges connecting them to the set of vertices included in MST.
Let us understand with the following example:

```java
The set mstSet is initially empty and keys assigned to vertices are {0, INF, INF, INF, INF, INF, INF, INF}
```

where INF indicates inﬁnite. Now pick the vertex with minimum key value. The vertex 0 is picked, include it in mstSet. So mstSet becomes {0}. After including to mstSet, update key values of adjacent vertices.
Adjacent vertices of 0 are 1 and 7. The key values of 1 and 7 are updated as 4 and 8. Following subgraph shows vertices and their key values, only the vertices with ﬁnite key values are shown. The vertices included in MST are shown in green color.
Pick the vertex with minimum key value and not already included in MST (not in mstSET). The vertex 1 is picked and added to mstSet. So mstSet now becomes {0, 1}. Update the key values of adjacent vertices of 1. The key value of vertex 2 becomes 8.
Pick the vertex with minimum key value and not already included in MST (not in mstSET). We can either pick vertex 7 or vertex 2, let vertex 7 is picked. So mstSet now becomes {0, 1, 7}. Update the key values of adjacent vertices of 7. The key value of vertex 6 and 8 becomes ﬁnite (7 and 1 respectively).
Pick the vertex with minimum key value and not already included in MST (not in mstSET). Vertex 6 is picked. So mstSet now becomes {0, 1, 7, 6}. Update the key values of adjacent vertices of 6. The key value of vertex 5 and 8 are updated.
We repeat the above steps until mstSet includes all vertices of given graph. Finally, we get the following graph.
How to implement the above algorithm?
We use a boolean array mstSet[] to represent the set of vertices included in MST. If a value mstSet[v] is true, then vertex v is included in MST, otherwise not. Array key[] is used to store key values of all vertices.
Another array parent[] to store indexes of parent nodes in MST. The parent array is the output array which is used to show the constructed MST.

```java
// A C / C++ program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph
#include <stdio.h>
#include <limits.h>
// Number of vertices in the graph
#define V 5
// A utility function to find the vertex with minimum key value, from
// the set of vertices not yet included in MST
int minKey(int key[], bool mstSet[])
{
// Initialize min value
int min = INT_MAX, min_index;
for (int v = 0; v < V; v++)
if (mstSet[v] == false && key[v] < min)
min = key[v], min_index = v;
return min_index;
}
// A utility function to print the constructed MST stored in parent[]
int printMST(int parent[], int n, int graph[V][V])
{
printf("Edge Weight\n");
for (int i = 1; i < V; i++)
printf("%d - %d %d \n", parent[i], i, graph[i][parent[i]]);
}
// Function to construct and print MST for a graph represented using adjacency
// matrix representation
void primMST(int graph[V][V])
{
int parent[V]; // Array to store constructed MST
int key[V]; // Key values used to pick minimum weight edge in cut
bool mstSet[V]; // To represent set of vertices not yet included in MST
// Initialize all keys as INFINITE
for (int i = 0; i < V; i++)
key[i] = INT_MAX, mstSet[i] = false;
// Always include first 1st vertex in MST.
key[0] = 0; // Make key 0 so that this vertex is picked as first vertex
parent[0] = -1; // First node is always root of MST
// The MST will have V vertices
for (int count = 0; count < V-1; count++)
{
// Pick thd minimum key vertex from the set of vertices
// not yet included in MST
int u = minKey(key, mstSet);
// Add the picked vertex to the MST Set
mstSet[u] = true;
// Update key value and parent index of the adjacent vertices of
// the picked vertex. Consider only those vertices which are not yet
// included in MST
for (int v = 0; v < V; v++)
// graph[u][v] is non zero only for adjacent vertices of m
// mstSet[v] is false for vertices not yet included in MST
// Update the key only if graph[u][v] is smaller than key[v]
if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])
parent[v] = u, key[v] = graph[u][v];
}
// print the constructed MST
printMST(parent, V, graph);
}
// driver program to test above function
int main()
{
/* Let us create the following graph
2 3
(0)--(1)--(2)
| / \ |
6| 8/ \5 |7
| / \ |
(3)-------(4)
9 */
int graph[V][V] = {{0, 2, 0, 6, 0},
{2, 0, 3, 8, 5},
{0, 3, 0, 0, 7},
{6, 8, 0, 0, 9},
{0, 5, 7, 9, 0},
};
// Print the solution
primMST(graph);
return 0;
}
```

### Output

Edge Weight 0 - 1 2 1 - 2 3 0 - 3 6 1 - 4 5 Time Complexity of the above program is O(Vˆ2). If the input graph is represented using adjacency list, then the time complexity of Prim’s algorithm can be reduced to O(E log V) with the help of binary heap.
Please see Prim’s MST for Adjacency List Representation for more details.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/)
Category: Graph Tags: Graph, Greedy, Greedy Algorithm, Minimum Spanning Tree, Prim’s Algorithm →

[↑ Back to Top](#table-of-contents)

---

## Chapter 9: Greedy Algorithms | Set 6 (Prim’s

> **Java Implementation:** [`GreedyAlgorithms7.java`](../src/main/java/com/dsamastery/dp/GreedyAlgorithms7.java) (`dynamic-programming`)

MST for Adjacency List Representation) We recommend to read following two posts as a prerequisite of this post.
1. Greedy Algorithms | Set 5 (Prim’s Minimum Spanning Tree (MST)) 2. Graph and its representations We have discussed Prim’s algorithm and its implementation for adjacency matrix representation of graphs.
ThetimecomplexityforthematrixrepresentationisO(Vˆ2). Inthispost, O(ELogV)algorithmforadjacency list representation is discussed.
Asdiscussedinthepreviouspost, inPrim’salgorithm, twosetsaremaintained, onesetcontainslistofvertices already included in MST, other set contains vertices not yet included. With adjacency list representation, all vertices of a graph can be traversed in O(V+E) time using BFS. The idea is to traverse all vertices of graph using BFSand use a Min Heap to store the vertices not yet included in MST. Min Heap is used as a priority queue to get the minimum weight edge from the cut. Min Heap is used as time complexity of operations like extracting minimum element and decreasing key value is O(LogV) in Min Heap.
Following are the detailed steps.
1) Create a Min Heap of size V where V is the number of vertices in the given graph. Every node of min heap contains vertex number and key value of the vertex.
2) Initialize Min Heap with ﬁrst vertex as root (the key value assigned to ﬁrst vertex is 0). The key value assigned to all other vertices is INF (inﬁnite).
3) While Min Heap is not empty, do following …..a) Extract the min value node from Min Heap. Let the extracted vertex be u.
…..b) For every adjacent vertex v of u, check if v is in Min Heap (not yet included in MST). If v is in Min Heap and its key value is more than weight of u-v, then update the key value of v as weight of u-v.
Let us understand the above algorithm with the following example:
Initially, key value of ﬁrst vertex is 0 and INF (inﬁnite) for all other vertices. So vertex 0 is extracted from Min Heap and key values of vertices adjacent to 0 (1 and 7) are updated. Min Heap contains all vertices except vertex 0.
The vertices in green color are the vertices included in MST.
Since key value of vertex 1 is minimum among all nodes in Min Heap, it is extracted from Min Heap and key values of vertices adjacent to 1 are updated (Key is updated if the a vertex is not in Min Heap and previous key value is greater than the weight of edge from 1 to the adjacent). Min Heap contains all vertices except vertex 0 and 1.
Since key value of vertex 7 is minimum among all nodes in Min Heap, it is extracted from Min Heap and key values of vertices adjacent to 7 are updated (Key is updated if the a vertex is not in Min Heap and previous key value is greater than the weight of edge from 7 to the adjacent). Min Heap contains all vertices except vertex 0, 1 and 7.
Since key value of vertex 6 is minimum among all nodes in Min Heap, it is extracted from Min Heap and key values of vertices adjacent to 6 are updated (Key is updated if the a vertex is not in Min Heap and previous key value is greater than the weight of edge from 6 to the adjacent). Min Heap contains all vertices except vertex 0, 1, 7 and 6.
The above steps are repeated for rest of the nodes in Min Heap till Min Heap becomes empty

```java
// C / C++ program for Prim's MST for adjacency list representation of graph
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
// A structure to represent a node in adjacency list
struct AdjListNode
{
int dest;
int weight;
struct AdjListNode* next;
};
// A structure to represent an adjacency liat
struct AdjList
{
struct AdjListNode *head; // pointer to head node of list
};
// A structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)
struct Graph
{
int V;
struct AdjList* array;
};
// A utility function to create a new adjacency list node
struct AdjListNode* newAdjListNode(int dest, int weight)
{
struct AdjListNode* newNode =
(struct AdjListNode*) malloc(sizeof(struct AdjListNode));
newNode->dest = dest;
newNode->weight = weight;
newNode->next = NULL;
return newNode;
}
// A utility function that creates a graph of V vertices
struct Graph* createGraph(int V)
{
struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph));
graph->V = V;
// Create an array of adjacency lists. Size of array will be V
graph->array = (struct AdjList*) malloc(V * sizeof(struct AdjList));
// Initialize each adjacency list as empty by making head as NULL
for (int i = 0; i < V; ++i)
graph->array[i].head = NULL;
return graph;
}
// Adds an edge to an undirected graph
void addEdge(struct Graph* graph, int src, int dest, int weight)
{
// Add an edge from src to dest. A new node is added to the adjacency
// list of src. The node is added at the begining
struct AdjListNode* newNode = newAdjListNode(dest, weight);
newNode->next = graph->array[src].head;
graph->array[src].head = newNode;
// Since graph is undirected, add an edge from dest to src also
newNode = newAdjListNode(src, weight);
newNode->next = graph->array[dest].head;
graph->array[dest].head = newNode;
}
// Structure to represent a min heap node
struct MinHeapNode
{
int v;
int key;
};
// Structure to represent a min heap
struct MinHeap
{
int size; // Number of heap nodes present currently
int capacity; // Capacity of min heap
int *pos; // This is needed for decreaseKey()
struct MinHeapNode **array;
};
// A utility function to create a new Min Heap Node
struct MinHeapNode* newMinHeapNode(int v, int key)
{
struct MinHeapNode* minHeapNode =
(struct MinHeapNode*) malloc(sizeof(struct MinHeapNode));
minHeapNode->v = v;
minHeapNode->key = key;
return minHeapNode;
}
// A utilit function to create a Min Heap
struct MinHeap* createMinHeap(int capacity)
{
struct MinHeap* minHeap =
(struct MinHeap*) malloc(sizeof(struct MinHeap));
minHeap->pos = (int *)malloc(capacity * sizeof(int));
minHeap->size = 0;
minHeap->capacity = capacity;
minHeap->array =
(struct MinHeapNode**) malloc(capacity * sizeof(struct MinHeapNode*));
return minHeap;
}
// A utility function to swap two nodes of min heap. Needed for min heapify
void swapMinHeapNode(struct MinHeapNode** a, struct MinHeapNode** b)
{
struct MinHeapNode* t = *a;
*a = *b;
*b = t;
}
// A standard function to heapify at given idx
// This function also updates position of nodes when they are swapped.
// Position is needed for decreaseKey()
void minHeapify(struct MinHeap* minHeap, int idx)
{
int smallest, left, right;
smallest = idx;
left = 2 * idx + 1;
right = 2 * idx + 2;
if (left < minHeap->size &&
minHeap->array[left]->key < minHeap->array[smallest]->key )
smallest = left;
if (right < minHeap->size &&
minHeap->array[right]->key < minHeap->array[smallest]->key )
smallest = right;
if (smallest != idx)
{
// The nodes to be swapped in min heap
MinHeapNode *smallestNode = minHeap->array[smallest];
MinHeapNode *idxNode = minHeap->array[idx];
// Swap positions
minHeap->pos[smallestNode->v] = idx;
minHeap->pos[idxNode->v] = smallest;
// Swap nodes
swapMinHeapNode(&minHeap->array[smallest], &minHeap->array[idx]);
minHeapify(minHeap, smallest);
}
}
// A utility function to check if the given minHeap is ampty or not
int isEmpty(struct MinHeap* minHeap)
{
return minHeap->size == 0;
}
// Standard function to extract minimum node from heap
struct MinHeapNode* extractMin(struct MinHeap* minHeap)
{
if (isEmpty(minHeap))
return NULL;
// Store the root node
struct MinHeapNode* root = minHeap->array[0];
// Replace root node with last node
struct MinHeapNode* lastNode = minHeap->array[minHeap->size - 1];
minHeap->array[0] = lastNode;
// Update position of last node
minHeap->pos[root->v] = minHeap->size-1;
minHeap->pos[lastNode->v] = 0;
// Reduce heap size and heapify root
--minHeap->size;
minHeapify(minHeap, 0);
return root;
}
// Function to decreasy key value of a given vertex v. This function
// uses pos[] of min heap to get the current index of node in min heap
void decreaseKey(struct MinHeap* minHeap, int v, int key)
{
// Get the index of v in heap array
int i = minHeap->pos[v];
// Get the node and update its key value
minHeap->array[i]->key = key;
// Travel up while the complete tree is not hepified.
// This is a O(Logn) loop
while (i && minHeap->array[i]->key < minHeap->array[(i - 1) / 2]->key)
{
// Swap this node with its parent
minHeap->pos[minHeap->array[i]->v] = (i-1)/2;
minHeap->pos[minHeap->array[(i-1)/2]->v] = i;
swapMinHeapNode(&minHeap->array[i], &minHeap->array[(i - 1) / 2]);
// move to parent index
i = (i - 1) / 2;
}
}
// A utility function to check if a given vertex
// 'v' is in min heap or not
bool isInMinHeap(struct MinHeap *minHeap, int v)
{
if (minHeap->pos[v] < minHeap->size)
return true;
return false;
}
// A utility function used to print the constructed MST
void printArr(int arr[], int n)
{
for (int i = 1; i < n; ++i)
printf("%d - %d\n", arr[i], i);
}
// The main function that constructs Minimum Spanning Tree (MST)
// using Prim's algorithm
void PrimMST(struct Graph* graph)
{
int V = graph->V;// Get the number of vertices in graph
int parent[V]; // Array to store constructed MST
int key[V]; // Key values used to pick minimum weight edge in cut
// minHeap represents set E
struct MinHeap* minHeap = createMinHeap(V);
// Initialize min heap with all vertices. Key value of
// all vertices (except 0th vertex) is initially infinite
for (int v = 1; v < V; ++v)
{
parent[v] = -1;
key[v] = INT_MAX;
minHeap->array[v] = newMinHeapNode(v, key[v]);
minHeap->pos[v] = v;
}
// Make key value of 0th vertex as 0 so that it
// is extracted first
key[0] = 0;
minHeap->array[0] = newMinHeapNode(0, key[0]);
minHeap->pos[0] = 0;
// Initially size of min heap is equal to V
minHeap->size = V;
// In the followin loop, min heap contains all nodes
// not yet added to MST.
while (!isEmpty(minHeap))
{
// Extract the vertex with minimum key value
struct MinHeapNode* minHeapNode = extractMin(minHeap);
int u = minHeapNode->v; // Store the extracted vertex number
// Traverse through all adjacent vertices of u (the extracted
// vertex) and update their key values
struct AdjListNode* pCrawl = graph->array[u].head;
while (pCrawl != NULL)
{
int v = pCrawl->dest;
// If v is not yet included in MST and weight of u-v is
// less than key value of v, then update key value and
// parent of v
if (isInMinHeap(minHeap, v) && pCrawl->weight < key[v])
{
key[v] = pCrawl->weight;
parent[v] = u;
decreaseKey(minHeap, v, key[v]);
}
pCrawl = pCrawl->next;
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
struct Graph* graph = createGraph(V);
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
```

### Output

0 - 1 5 - 2 2 - 3 3 - 4 6 - 5 7 - 6 0 - 7 2 - 8 Time Complexity: The time complexity of the above code/algorithm looks O(Vˆ2) as there are two nested while loops. If we take a closer look, we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS). The inner loop has decreaseKey() operation which takes O(LogV) time. So overall time complexity is O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV) (For a connected graph, V = O(E))

### References

Introduction to Algorithms by Cliﬀord Stein, Thomas H. Cormen, Charles E. Leiserson, Ronald L.
- [Reference Link](http://en.wikipedia.org/wiki/Prim’s_algorithm)
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-mst-for-adjacency-list-representation/)
Category: Graph Tags: Graph, Greedy Algorithm cally Increasing Subsequence (N log N) →

[↑ Back to Top](#table-of-contents)

---

## Chapter 10: K Centers Problem | Set 1 (Greedy

> **Java Implementation:** [`KCentersProblem.java`](../src/main/java/com/dsamastery/dp/KCentersProblem.java) (`dynamic-programming`)

Approximate Algorithm) Given n cities and distances between every pair of cities, select k cities to place warehouses (or ATMs) such that the maximum distance of a city to a warehouse (or ATM) is minimized.
For example consider the following four cities, 0, 1, 2 and 3 and distances between them, how do place 2 ATMs among these 4 cities so that the maximum distance of a city to an ATM is minimized.
There is no polynomial time solution available for this problem as the problem is a known NP-Hard problem.
There is a polynomial time Greedy approximate algorithm, the greedy algorithm provides a solution which is never worse that twice the optimal solution. The greedy solution works only if the distances between cities follow Triangular Inequality (Distance between two points is always smaller than sum of distances through a third point).
The 2-Approximate Greedy Algorithm:
1) Choose the ﬁrst center arbitrarily.
2) Choose remaining k-1 centers using the following criteria.
Let c1, c2, c3, … ci be the already chosen centers. Choose (i+1)’th center by picking the city which is farthest from already selected centers, i.e, the point p which has following value as maximum Min[dist(p, c1), dist(p, c2), dist(p, c3), …. dist(p, ci)] The following diagram taken from hereillustrates above algorithm.

```java
Example (k = 3 in the above shown Graph)
```

a) Let the ﬁrst arbitrarily picked vertex be 0.
b) The next vertex is 1 because 1 is the farthest vertex from 0.
c) Remaining cities are 2 and 3. Calculate their distances from already selected centers (0 and 1). The greedy algorithm basically calculates following values.
Minimum of all distanced from 2 to already considered centers Min[dist(2, 0), dist(2, 1)] = Min[7, 8] = 7 Minimum of all distanced from 3 to already considered centers Min[dist(3, 0), dist(3, 1)] = Min[6, 5] = 5 After computing the above values, the city 2 is picked as the value corresponding to 2 is maximum.
Note that the greedy algorithm doesn’t give best solution for k = 2 as this is just an approximate algorithm with bound as twice of optimal.
Proof that the above greedy algorithm is 2 approximate.
Let OPT be the maximum distance of a city from a center in the Optimal solution. We need to show that the maximum distance obtained from Greedy algorithm is 2*OPT.
The proof can be done using contradiction.
a) Assume that the distance from the furthest point to all centers is > 2·OPT.
b) This means that distances between all centers are also > 2·OPT.
c) We have k + 1 points with distances > 2·OPT between every pair.
d) Each point has a center of the optimal solution with distance ? OPT to it.
e) There exists a pair of points with the same center X in the optimal solution (pigeonhole principle: k optimal centers, k+1 points) f) The distance between them is at most 2·OPT (triangle inequality) which is a contradiction.
Source:
- [Reference Link](http://algo2.iti.kit.edu/vanstee/courses/kcenter.pdf)
This article is contributed by Harshit. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/k-centers-problem-set-1-greedy-approximate-algorithm/)

[↑ Back to Top](#table-of-contents)
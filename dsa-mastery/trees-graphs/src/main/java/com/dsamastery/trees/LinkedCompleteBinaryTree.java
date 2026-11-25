package com.dsamastery.trees;

import java.util.*;

public class LinkedCompleteBinaryTree {

    / \
    / \
    / \
    / \
    // Program for linked implementation of complete binary tree
    // For Queue Size
    // A tree node
    static class node
    {
    int data;
    static class node *right,*left;
    };
    // A queue node
    static class Queue
    {
    int front, rear;
    int size;
    static class node* *array;
    };
    // A utility function to create a new tree node
    static class node* newNode(int data)
    {
    static class node* temp = (static class node*) malloc(sizeof( static class node ));
    temp.data = data;
    temp.left = temp.right = null;
    return temp;
    }
    // A utility function to create a new Queue
    static class Queue* createQueue(int size)
    {
    static class Queue* queue = (static class Queue*) malloc(sizeof( static class Queue ));
    queue.front = queue.rear = -1;
    queue.size = size;
    queue.array = (static class node**) malloc(queue.size * sizeof( static class node* ));
    int i;
    for (i = 0; i < size; ++i)
    queue.array[i] = null;
    return queue;
    }
    // Standard Queue Functions
    int isEmpty(static class Queue* queue)
    {
    return queue.front == -1;
    }
    int isFull(static class Queue* queue)
    { return queue.rear == queue.size - 1; }
    int hasOnlyOneItem(static class Queue* queue)
    { return queue.front == queue.rear; }
    void Enqueue(static class node *root, static class Queue* queue)
    {
    if (isFull(queue))
    return;
    queue.array[++queue.rear] = root;
    if (isEmpty(queue))
    ++queue.front;
    }
    static class node* Dequeue(static class Queue* queue)
    {
    if (isEmpty(queue))
    return null;
    static class node* temp = queue.array[queue.front];
    if (hasOnlyOneItem(queue))
    queue.front = queue.rear = -1;
    else
    ++queue.front;
    return temp;
    }
    static class node* getFront(static class Queue* queue)
    { return queue.array[queue.front]; }
    // A utility function to check if a tree node has both left and right children
    int hasBothChild(static class node* temp)
    {
    return temp && temp.left && temp.right;
    }
    // Function to insert a new node in complete binary tree
    void insert(static class node **root, int data, static class Queue* queue)
    {
    // Create a new node for given data
    static class node *temp = newNode(data);
    // If the tree is empty, initialize the root with new node.
    if (!*root)
    *root = temp;
    else
    {
    // get the front node of the queue.
    static class node* front = getFront(queue);
    // If the left child of this front node doesn’t exist, set the
    // left child as the new node
    if (!front.left)
    front.left = temp;
    // If the right child of this front node doesn’t exist, set the
    // right child as the new node
    else if (!front.right)
    front.right = temp;
    // If the front node has both the left child and right child,
    // Dequeue() it.
    if (hasBothChild(front))
    Dequeue(queue);
    }
    // Enqueue() the new node for later insertions
    Enqueue(temp, queue);
    }
    // Standard level order traversal to test above function
    void levelOrder(static class node* root)
    {
    static class Queue* queue = createQueue(SIZE);
    Enqueue(root, queue);
    while (!isEmpty(queue))
    {
    static class node* temp = Dequeue(queue);
    System.out.printf("%d ", temp.data);
    if (temp.left)
    Enqueue(temp.left, queue);
    if (temp.right)
    Enqueue(temp.right, queue);
    }
    }
    // Driver program to test above functions
    int main()
    {
    static class node* root = null;
    static class Queue* queue = createQueue(SIZE);
    int i;
    for(i = 1; i <= 12; ++i)
    insert(&root, i, queue);
    levelOrder(root);
    return 0;
    }
}

package com.dsamastery.trees;

import java.util.*;

public class CheckWhetherAGiven {

    / \
    / \
    / \
    \
    / \
    \ / \
    / \
    / \
    / \
    \
    // A program to check if a given binary tree is complete or not
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* frunction prototypes for functions needed for Queue data
    structure. A queue is needed for level order tarversal */
    static class node** createQueue(int *, int *);
    void enQueue(static class node **, int *, static class node *);
    static class node *deQueue(static class node **, int *);
    boolean isQueueEmpty(int *front, int *rear);
    /* Given a binary tree, return true if the tree is complete
    else false */
    boolean isCompleteBT(static class node* root)
    {
    // Base Case: An empty tree is complete Binary Tree
    if (root == null)
    return true;
    // Create an empty queue
    int rear, front;
    static class node **queue = createQueue(&front, &rear);
    // Create a flag variable which will be set true
    // when a non full node is seen
    boolean flag = false;
    // Do level order traversal using queue.
    enQueue(queue, &rear, root);
    while(!isQueueEmpty(&front, &rear))
    {
    static class node *temp_node = deQueue(queue, &front);
    /* Ceck if left child is present*/
    if(temp_node.left)
    {
    // If we have seen a non full node, and we see a node
    // with non-empty left child, then the given tree is not
    // a complete Binary Tree
    if (flag == true)
    return false;
    enQueue(queue, &rear, temp_node.left); // Enqueue Left Child
    }
    else // If this a non-full node, set the flag as true
    flag = true;
    /* Ceck if right child is present*/
    if(temp_node.right)
    {
    // If we have seen a non full node, and we see a node
    // with non-empty left child, then the given tree is not
    // a complete Binary Tree
    if(flag == true)
    return false;
    enQueue(queue, &rear, temp_node.right); // Enqueue Right Child
    }
    else // If this a non-full node, set the flag as true
    flag = true;
    }
    // If we reach here, then the tree is complete Bianry Tree
    return true;
    }
    /*UTILITY FUNCTIONS*/
    static class node** createQueue(int *front, int *rear)
    {
    static class node **queue =
    (static class node **)malloc(sizeof(static class node*)*MAX_Q_SIZE);
    *front = *rear = 0;
    return queue;
    }
    void enQueue(static class node **queue, int *rear, static class node *new_node)
    {
    queue[*rear] = new_node;
    (*rear)++;
    }
    static class node *deQueue(static class node **queue, int *front)
    {
    (*front)++;
    return queue[*front - 1];
    }
    boolean isQueueEmpty(int *front, int *rear)
    {
    return (*rear == *front);
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Let us construct the following Binary Tree which
    is not a complete Binary Tree
    / \
    2 3
    / \ \
    4 5 6
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.right = newNode(6);
    if ( isCompleteBT(root) == true )
    System.out.printf("Complete Binary Tree");
    else
    System.out.printf("NOT Complete Binary Tree");
    return 0;
    }
}

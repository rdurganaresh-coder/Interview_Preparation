package com.dsamastery.trees;

import java.util.*;

public class LevelOrderTreeTraversal {

    METHOD 1 (Use function to print a given level)
    /*Function to print level order traversal of tree*/
    printLevelorder(tree)
    printGivenLevel(tree, d);
    /*Function to print all nodes at a given level*/
    printGivenLevel(tree, level)
    if tree is null then return;
    print(tree.data);
    else if level greater than 1, then
    printGivenLevel(tree.left, level-1);
    printGivenLevel(tree.right, level-1);
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /*Function protoypes*/
    void printGivenLevel(static class node* root, int level);
    int height(static class node* node);
    static class node* newNode(int data);
    /* Function to print level order traversal a tree*/
    void printLevelOrder(static class node* root)
    {
    int h = height(root);
    int i;
    for(i=1; i<=h; i++)
    printGivenLevel(root, i);
    }
    /* Print nodes at a given level */
    void printGivenLevel(static class node* root, int level)
    {
    if(root == null)
    return;
    if(level == 1)
    System.out.printf("%d ", root.data);
    else if (level > 1)
    {
    printGivenLevel(root.left, level-1);
    printGivenLevel(root.right, level-1);
    }
    }
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the height of each subtree */
    int lheight = height(node.left);
    int rheight = height(node.right);
    /* use the larger one */
    if (lheight > rheight)
    return(lheight+1);
    else return(rheight+1);
    }
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
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Level Order traversal of binary tree is \n");
    printLevelOrder(root);
    getchar();
    return 0;
    }
    METHOD 2 (Use Queue)
    printLevelorder(tree)
    2) temp_node = root /*start from root*/
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* frunction prototypes */
    static class node** createQueue(int *, int *);
    void enQueue(static class node **, int *, static class node *);
    static class node *deQueue(static class node **, int *);
    /* Given a binary tree, print its nodes in level order
    using array for implementing queue */
    void printLevelOrder(static class node* root)
    {
    int rear, front;
    static class node **queue = createQueue(&front, &rear);
    static class node *temp_node = root;
    while(temp_node)
    {
    System.out.printf("%d ", temp_node.data);
    /*Enqueue left child */
    if(temp_node.left)
    enQueue(queue, &rear, temp_node.left);
    /*Enqueue right child */
    if(temp_node.right)
    enQueue(queue, &rear, temp_node.right);
    /*Dequeue node and make it temp_node*/
    temp_node = deQueue(queue, &front);
    }
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
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Level Order traversal of binary tree is \n");
    printLevelOrder(root);
    getchar();
    return 0;
    }
}

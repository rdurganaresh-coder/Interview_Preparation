package com.dsamastery.trees;

import java.util.*;

public class PrintAncestorsOfA {

    / \
    / \ / \
    // C program to print all ancestors of a given key
    // Maximum stack size
    // Structure for a tree node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // Structure for Stack
    static class Stack
    {
    int size;
    int top;
    static class Node* *array;
    };
    // A utility function to create a new tree node
    static class Node* newNode(int data)
    {
    static class Node* node = (static class Node*) malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // A utility function to create a stack of given size
    static class Stack* createStack(int size)
    {
    static class Stack* stack = (static class Stack*) malloc(sizeof(static class Stack));
    stack.size = size;
    stack.top = -1;
    stack.array = (static class Node**) malloc(stack.size * sizeof(static class Node*));
    return stack;
    }
    // BASIC OPERATIONS OF STACK
    int isFull(static class Stack* stack)
    {
    return ((stack.top + 1) == stack.size);
    }
    int isEmpty(static class Stack* stack)
    {
    return stack.top == -1;
    }
    void push(static class Stack* stack, static class Node* node)
    {
    if (isFull(stack))
    return;
    stack.array[++stack.top] = node;
    }
    static class Node* pop(static class Stack* stack)
    {
    if (isEmpty(stack))
    return null;
    return stack.array[stack.top--];
    }
    static class Node* peek(static class Stack* stack)
    {
    if (isEmpty(stack))
    return null;
    return stack.array[stack.top];
    }
    // Iterative Function to print all ancestors of a given key
    void printAncestors(static class Node *root, int key)
    {
    if (root == null) return;
    // Create a stack to hold ancestors
    static class Stack* stack = createStack(MAX_SIZE);
    // Traverse the complete tree in postorder way till we find the key
    while (1)
    {
    // Traverse the left side. While traversing, push the nodes into
    // the stack so that their right subtrees can be traversed later
    while (root && root.data != key)
    {
    push(stack, root); // push current node
    root = root.left; // move to next node
    }
    // If the node whose ancestors are to be printed is found,
    // then break the while loop.
    if (root && root.data == key)
    break;
    // Check if right sub-tree exists for the node at top
    // If not then pop that node because we don't need this
    // node any more.
    if (peek(stack)->right == null)
    {
    root = pop(stack);
    // If the popped node is right child of top, then remove the top
    // as well. Left child of the top must have processed before.
    // Consider the following tree for example and key = 3. If we
    // remove the following loop, the program will go in an
    // infinite loop after reaching 5.
    // 1
    // / \
    // 2 3
    // \
    // 4
    // \
    // 5
    while (!isEmpty(stack) && peek(stack)->right == root)
    root = pop(stack);
    }
    // if stack is not empty then simply set the root as right child
    // of top and start traversing right sub-tree.
    root = isEmpty(stack)? null: peek(stack)->right;
    }
    // If stack is not empty, print contents of stack
    // Here assumption is that the key is there in tree
    while (!isEmpty(stack))
    System.out.printf("%d ", pop(stack)->data);
    }
    // Driver program to test above functions
    int main()
    {
    // Let us construct a binary tree
    static class Node* root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.left.left.left = newNode(8);
    root.left.right.right = newNode(9);
    root.right.right.left = newNode(10);
    System.out.printf("Following are all keys and their ancestors\n");
    for (int key = 1; key <= 10; key++)
    {
    System.out.printf("%d: ", key);
    printAncestors(root, key);
    System.out.printf("\n");
    }
    getchar();
    return 0;
    }
}

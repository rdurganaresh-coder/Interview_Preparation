package com.dsamastery.trees;

import java.util.*;

public class IterativePostorderTraversal {

    // C program for iterative postorder traversal using one stack
    // Maximum stack size
    // A tree node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // Stack type
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
    { return stack.top - 1 == stack.size; }
    int isEmpty(static class Stack* stack)
    { return stack.top == -1; }
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
    // An iterative function to do postorder traversal of a given binary tree
    void postOrderIterative(static class Node* root)
    {
    // Check for empty tree
    if (root == null)
    return;
    static class Stack* stack = createStack(MAX_SIZE);
    do
    {
    // Move to leftmost node
    while (root)
    {
    // Push root's right child and then root to stack.
    if (root.right)
    push(stack, root.right);
    push(stack, root);
    // Set root as root's left child
    root = root.left;
    }
    // Pop an item from stack and set it as root
    root = pop(stack);
    // If the popped item has a right child and the right child is not
    // processed yet, then make sure right child is processed before root
    if (root.right && peek(stack) == root.right)
    {
    pop(stack); // remove right child from stack
    push(stack, root); // push root back to stack
    root = root.right; // change root so that the right
    // child is processed next
    }
    else // Else print root's data and set root as null
    {
    System.out.printf("%d ", root.data);
    root = null;
    }
    } while (!isEmpty(stack));
    }
    // Driver program to test above functions
    int main()
    {
    // Let us construct the tree shown in above figure
    static class Node* root = null;
    root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    postOrderIterative(root);
    return 0;
    }
}

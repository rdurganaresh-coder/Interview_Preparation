package com.dsamastery.trees;

import java.util.*;

public class IterativePostorderTraversal {

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
    static class Stack* stack =
    (static class Stack*) malloc(sizeof(static class Stack));
    stack.size = size;
    stack.top = -1;
    stack.array =
    (static class Node**) malloc(stack.size * sizeof(static class Node*));
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
    // An iterative function to do post order traversal of a given binary tree
    void postOrderIterative(static class Node* root)
    {
    // Create two stacks
    static class Stack* s1 = createStack(MAX_SIZE);
    static class Stack* s2 = createStack(MAX_SIZE);
    // push root to first stack
    push(s1, root);
    static class Node* node;
    // Run while first stack is not empty
    while (!isEmpty(s1))
    {
    // Pop an item from s1 and push it to s2
    node = pop(s1);
    push(s2, node);
    // Push left and right children of removed item to s1
    if (node.left)
    push(s1, node.left);
    if (node.right)
    push(s1, node.right);
    }
    // Print all elements of second stack
    while (!isEmpty(s2))
    {
    node = pop(s2);
    System.out.printf("%d ", node.data);
    }
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

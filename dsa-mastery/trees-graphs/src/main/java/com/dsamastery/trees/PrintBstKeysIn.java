package com.dsamastery.trees;

import java.util.*;

public class PrintBstKeysIn {

    /* A tree node structure */
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    };
    /* The functions prints all the keys which in the given range [k1..k2].
    The function assumes than k1 < k2 */
    void Print(static class node *root, int k1, int k2)
    {
    /* base case */
    if ( null == root )
    return;
    /* Since the desired o/p is sorted, recurse for left subtree first
    If root.data is greater than k1, then only we can get o/p keys
    in left subtree */
    if ( k1 < root.data )
    Print(root.left, k1, k2);
    /* if root's data lies in range, then prints root's data */
    if ( k1 <= root.data && k2 >= root.data )
    System.out.printf("%d ", root.data );
    /* If root.data is smaller than k2, then only we can get o/p keys
    in right subtree */
    if ( k2 > root.data )
    Print(root.right, k1, k2);
    }
    /* Utility function to create a new Binary Tree node */
    static class node* newNode(int data)
    {
    static class node *temp = new static class node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    /* Driver function to test above functions */
    int main()
    {
    static class node *root = new static class node;
    int k1 = 10, k2 = 25;
    /* Constructing tree given in the above figure */
    root = newNode(20);
    root.left = newNode(8);
    root.right = newNode(22);
    root.left.left = newNode(4);
    root.left.right = newNode(12);
    Print(root, k1, k2);
    getchar();
    return 0;
    }
}

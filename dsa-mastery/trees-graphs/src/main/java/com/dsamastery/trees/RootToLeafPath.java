package com.dsamastery.trees;

import java.util.*;

public class RootToLeafPath {

    Recursively check if left or right child has path sum equal to ( number – value at current node)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /*
    Given a tree and a sum, return true if there is a path from the root
    down to a leaf, such that adding up all the values along the path
    equals the given sum.
    Strategy: subtract the node value from the sum when recurring down,
    and check to see if the sum is 0 when you run out of tree.
    */
    boolean hasPathSum(static class node* node, int sum)
    {
    /* return true if we run out of tree and sum==0 */
    if (node == null)
    {
    return (sum == 0);
    }
    else
    {
    boolean ans = 0;
    /* otherwise check both subtrees */
    int subSum = sum - node.data;
    /* If we reach a leaf node and sum becomes 0 then return true*/
    if ( subSum == 0 && node.left == null && node.right == null )
    return 1;
    if(node.left)
    ans = ans || hasPathSum(node.left, subSum);
    if(node.right)
    ans = ans || hasPathSum(node.right, subSum);
    return ans;
    }
    }
    /* UTILITY FUNCTIONS */
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newnode(int data)
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
    int sum = 21;
    /* Constructed binary tree is
    / \
    8 2
    / \ /
    3 5 2
    */
    static class node *root = newnode(10);
    root.left = newnode(8);
    root.right = newnode(2);
    root.left.left = newnode(3);
    root.left.right = newnode(5);
    root.right.left = newnode(2);
    if(hasPathSum(root, sum))
    System.out.printf("There is a root-to-leaf path with sum %d", sum);
    else
    System.out.printf("There is no root-to-leaf path with sum %d", sum);
    getchar();
    return 0;
    }
}

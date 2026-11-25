package com.dsamastery.trees;

import java.util.*;

public class InorderTreeTraversalWithout {

    /* A binary tree tNode has data, pointer to left child
    and a pointer to right child */
    static class tNode
    {
    int data;
    static class tNode* left;
    static class tNode* right;
    };
    /* Function to traverse binary tree without recursion and
    without stack */
    void MorrisTraversal(static class tNode *root)
    {
    static class tNode *current,*pre;
    if(root == null)
    return;
    current = root;
    while(current != null)
    {
    if(current.left == null)
    {
    System.out.printf(" %d ", current.data);
    current = current.right;
    }
    else
    {
    /* Find the inorder predecessor of current */
    pre = current.left;
    while(pre.right != null && pre.right != current)
    pre = pre.right;
    /* Make current as right child of its inorder predecessor */
    if(pre.right == null)
    {
    pre.right = current;
    current = current.left;
    }
    /* Revert the changes made in if part to restore the original
    tree i.e., fix the right child of predecssor */
    else
    {
    pre.right = null;
    System.out.printf(" %d ",current.data);
    current = current.right;
    } /* End of if condition pre.right == null */
    } /* End of if condition current.left == null*/
    } /* End of while */
    }
    /* UTILITY FUNCTIONS */
    /* Helper function that allocates a new tNode with the
    given data and null left and right pointers. */
    static class tNode* newtNode(int data)
    {
    static class tNode* tNode = (static class tNode*)
    malloc(sizeof(static class tNode));
    tNode.data = data;
    tNode.left = null;
    tNode.right = null;
    return(tNode);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    2 3
    / \
    4 5
    */
    static class tNode *root = newtNode(1);
    root.left = newtNode(2);
    root.right = newtNode(3);
    root.left.left = newtNode(4);
    root.left.right = newtNode(5);
    MorrisTraversal(root);
    getchar();
    return 0;
    }
}

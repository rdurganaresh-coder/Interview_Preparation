package com.dsamastery.trees;

import java.util.*;

public class FindKThSmallest {

    /* initialization */
    set initial stack element as null (sentinal)
    /* traverse upto left extreme */
    while(pCrawl is valid )
    /* process other nodes */
    while( pCrawl = stack.pop() is valid )
    if( pCrawl.right is valid )
    while( pCrawl is valid )
    /* just add elements to test */
    /* NOTE: A sorted array results in skewed tree */
    int ele[] = { 20, 8, 22, 4, 12, 10, 14 };
    /* same alias */
    /* Binary tree node */
    static class node_t
    {
    int data;
    node_t* left;
    node_t* right;
    };
    /* simple stack that stores node addresses */
    /* initial element always null, uses as sentinal */
    static class stack_t
    {
    node_t* base[ARRAY_SIZE(ele) + 1];
    int stackIndex;
    };
    /* pop operation of stack */
    node_t *pop(stack_t *st)
    {
    node_t *ret = null;
    if( st && st.stackIndex > 0 )
    {
    ret = st.base[st.stackIndex];
    st.stackIndex--;
    }
    return ret;
    }
    /* push operation of stack */
    void push(stack_t *st, node_t *node)
    {
    if( st )
    {
    st.stackIndex++;
    st.base[st.stackIndex] = node;
    }
    }
    /* Iterative insertion
    Recursion is least preferred unless we gain something
    */
    node_t *insert_node(node_t *root, node_t* node)
    {
    /* A crawling pointer */
    node_t *pTraverse = root;
    node_t *currentParent = root;
    // Traverse till appropriate node
    while(pTraverse)
    {
    currentParent = pTraverse;
    if( node.data < pTraverse.data )
    {
    /* left subtree */
    pTraverse = pTraverse.left;
    }
    else
    {
    /* right subtree */
    pTraverse = pTraverse.right;
    }
    }
    /* If the tree is empty, make it as root node */
    if( !root )
    {
    root = node;
    }
    else if( node.data < currentParent.data )
    {
    /* Insert on left side */
    currentParent.left = node;
    }
    else
    {
    /* Insert on right side */
    currentParent.right = node;
    }
    return root;
    }
    /* Elements are in an array. The function builds binary tree */
    node_t* binary_search_tree(node_t *root, int keys[], int const size)
    {
    int iterator;
    node_t *new_node = null;
    for(iterator = 0; iterator < size; iterator++)
    {
    new_node = (node_t *)malloc( sizeof(node_t) );
    /* initialize */
    new_node.data = keys[iterator];
    new_node.left = null;
    new_node.right = null;
    /* insert into BST */
    root = insert_node(root, new_node);
    }
    return root;
    }
    node_t *k_smallest_element_inorder(stack_t *stack, node_t *root, int k)
    {
    stack_t *st = stack;
    node_t *pCrawl = root;
    /* move to left extremen (minimum) */
    while( pCrawl )
    {
    push(st, pCrawl);
    pCrawl = pCrawl.left;
    }
    /* pop off stack and process each node */
    while( pCrawl = pop(st) )
    {
    /* each pop operation emits one element
    in the order
    */
    if( !--k )
    {
    /* loop testing */
    st.stackIndex = 0;
    break;
    }
    /* there is right subtree */
    if( pCrawl.right )
    {
    /* push the left subtree of right subtree */
    pCrawl = pCrawl.right;
    while( pCrawl )
    {
    push(st, pCrawl);
    pCrawl = pCrawl.left;
    }
    /* pop off stack and repeat */
    }
    }
    /* node having k-th element or null node */
    return pCrawl;
    }
    /* Driver program to test above functions */
    int main(void)
    {
    node_t* root = null;
    stack_t stack = { {0}, 0 };
    node_t *kNode = null;
    int k = 5;
    /* Creating the tree given in the above diagram */
    root = binary_search_tree(root, ele, ARRAY_SIZE(ele));
    kNode = k_smallest_element_inorder(&stack, root, k);
    if( kNode )
    {
    System.out.printf("kth smallest elment for k = %d is %d", k, kNode.data);
    }
    else
    {
    System.out.printf("There is no such element");
    }
    getchar();
    return 0;
    }
    else if K > root.leftElements
    else
    /* Binary tree node */
    static class node_t
    {
    int data;
    int lCount;
    node_t* left;
    node_t* right;
    };
    /* Iterative insertion
    Recursion is least preferred unless we gain something
    */
    node_t *insert_node(node_t *root, node_t* node)
    {
    /* A crawling pointer */
    node_t *pTraverse = root;
    node_t *currentParent = root;
    // Traverse till appropriate node
    while(pTraverse)
    {
    currentParent = pTraverse;
    if( node.data < pTraverse.data )
    {
    /* We are branching to left subtree
    increment node count */
    pTraverse.lCount++;
    /* left subtree */
    pTraverse = pTraverse.left;
    }
    else
    {
    /* right subtree */
    pTraverse = pTraverse.right;
    }
    }
    /* If the tree is empty, make it as root node */
    if( !root )
    {
    root = node;
    }
    else if( node.data < currentParent.data )
    {
    /* Insert on left side */
    currentParent.left = node;
    }
    else
    {
    /* Insert on right side */
    currentParent.right = node;
    }
    return root;
    }
    /* Elements are in an array. The function builds binary tree */
    node_t* binary_search_tree(node_t *root, int keys[], int const size)
    {
    int iterator;
    node_t *new_node = null;
    for(iterator = 0; iterator < size; iterator++)
    {
    new_node = (node_t *)malloc( sizeof(node_t) );
    /* initialize */
    new_node.data = keys[iterator];
    new_node.lCount = 0;
    new_node.left = null;
    new_node.right = null;
    /* insert into BST */
    root = insert_node(root, new_node);
    }
    return root;
    }
    int k_smallest_element(node_t *root, int k)
    {
    int ret = -1;
    if( root )
    {
    /* A crawling pointer */
    node_t *pTraverse = root;
    /* Go to k-th smallest */
    while(pTraverse)
    {
    if( (pTraverse.lCount + 1) == k )
    {
    ret = pTraverse.data;
    break;
    }
    else if( k > pTraverse.lCount )
    {
    /* There are less nodes on left subtree
    Go to right subtree */
    k = k - (pTraverse.lCount + 1);
    pTraverse = pTraverse.right;
    }
    else
    {
    /* The node is on left subtree */
    pTraverse = pTraverse.left;
    }
    }
    }
    return ret;
    }
    /* Driver program to test above functions */
    int main(void)
    {
    /* just add elements to test */
    /* NOTE: A sorted array results in skewed tree */
    int ele[] = { 20, 8, 22, 4, 12, 10, 14 };
    int i;
    node_t* root = null;
    /* Creating the tree given in the above diagram */
    root = binary_search_tree(root, ele, ARRAY_SIZE(ele));
    /* It should print the sorted array */
    for(i = 1; i <= ARRAY_SIZE(ele); i++)
    {
    System.out.printf("\n kth smallest elment for k = %d is %d",
    i, k_smallest_element(root, i));
    }
    getchar();
    return 0;
    }
}

package com.dsamastery.trees;

import java.util.*;

public class TernarySearchTree {

    // C program to demonstrate Ternary Search Tree (TST) insert, travese
    // and search operations
    // A node of ternary search tree
    static class Node
    {
    char data;
    // True if this character is last character of one of the words
    unsigned isEndOfString: 1;
    static class Node *left, *eq, *right;
    };
    // A utility function to create a new ternary search tree node
    static class Node* newNode(char data)
    {
    static class Node* temp = (static class Node*) malloc(sizeof( static class Node ));
    temp.data = data;
    temp.isEndOfString = 0;
    temp.left = temp.eq = temp.right = null;
    return temp;
    }
    // Function to insert a new word in a Ternary Search Tree
    void insert(static class Node** root, char *word)
    {
    // Base Case: Tree is empty
    if (!(*root))
    *root = newNode(*word);
    // If current character of word is smaller than root's character,
    // then insert this word in left subtree of root
    if ((*word) < (*root)->data)
    insert(&( (*root)->left ), word);
    // If current character of word is greate than root's character,
    // then insert this word in right subtree of root
    else if ((*word) > (*root)->data)
    insert(&( (*root)->right ), word);
    // If current character of word is same as root's character,
    else
    {
    if (*(word+1))
    insert(&( (*root)->eq ), word+1);
    // the last character of the word
    else
    (*root)->isEndOfString = 1;
    }
    }
    // A recursive function to traverse Ternary Search Tree
    void traverseTSTUtil(static class Node* root, char* buffer, int depth)
    {
    if (root)
    {
    // First traverse the left subtree
    traverseTSTUtil(root.left, buffer, depth);
    // Store the character of this node
    buffer[depth] = root.data;
    if (root.isEndOfString)
    {
    buffer[depth+1] = '\0';
    System.out.printf( "%s\n", buffer);
    }
    // Traverse the subtree using equal pointer (middle subtree)
    traverseTSTUtil(root.eq, buffer, depth + 1);
    // Finally Traverse the right subtree
    traverseTSTUtil(root.right, buffer, depth);
    }
    }
    // The main function to traverse a Ternary Search Tree.
    // It mainly uses traverseTSTUtil()
    void traverseTST(static class Node* root)
    {
    char buffer[MAX];
    traverseTSTUtil(root, buffer, 0);
    }
    // Function to search a given word in TST
    int searchTST(static class Node *root, char *word)
    {
    if (!root)
    return 0;
    if (*word < (root)->data)
    return searchTST(root.left, word);
    else if (*word > (root)->data)
    return searchTST(root.right, word);
    else
    {
    if (*(word+1) == '\0')
    return root.isEndOfString;
    return searchTST(root.eq, word+1);
    }
    }
    // Driver program to test above functions
    int main()
    {
    static class Node *root = null;
    insert(&root, "cat");
    insert(&root, "cats");
    insert(&root, "up");
    insert(&root, "bug");
    System.out.printf("Following is traversal of ternary search tree\n");
    traverseTST(root);
    System.out.printf("\nFollowing are search results for cats, bu and cat respectively\n");
    searchTST(root, "cats")? System.out.printf("Found\n"): System.out.printf("Not Found\n");
    searchTST(root, "bu")? System.out.printf("Found\n"): System.out.printf("Not Found\n");
    searchTST(root, "cat")? System.out.printf("Found\n"): System.out.printf("Not Found\n");
    return 0;
    }
}

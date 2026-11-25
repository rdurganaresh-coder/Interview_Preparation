package com.dsamastery.misc;

import java.util.*;

public class PrintUniqueRowsIn {

    {0, 1, 0, 0, 1}
    {1, 0, 1, 1, 0}
    {0, 1, 0, 0, 1}
    {1, 1, 1, 0, 0}
    Method 1 (Simple)
    Method 2 (Use Binary Search Tree)
    Method 3 (Use Trie data structure)
    //Given a binary matrix of M X N of integers, you need to return only unique rows of binary array
    // A Trie node
    {
    boolean isEndOfCol;
    static class Node *child[2]; // Only two children needed for 0 and 1
    } Node;
    // A utility function to allocate memory for a new Trie node
    Node* newNode()
    {
    Node* temp = (Node *)malloc( sizeof( Node ) );
    temp.isEndOfCol = 0;
    temp.child[0] = temp.child[1] = null;
    return temp;
    }
    // Inserts a new matrix row to Trie. If row is already
    // present, then returns 0, otherwise insets the row and
    // return 1
    boolean insert( Node** root, int (*M)[COL], int row, int col )
    {
    // base case
    if ( *root == null )
    *root = newNode();
    // Recur if there are more entries in this row
    if ( col < COL )
    return insert ( &( (*root)->child[ M[row][col] ] ), M, row, col+1 );
    else // If all entries of this row are processed
    {
    // unique row found, return 1
    if ( !( (*root)->isEndOfCol ) )
    return (*root)->isEndOfCol = 1;
    // duplicate row found, return 0
    return 0;
    }
    }
    // A utility function to print a row
    void printRow( int (*M)[COL], int row )
    {
    int i;
    for( i = 0; i < COL; ++i )
    System.out.printf( "%d ", M[row][i] );
    System.out.printf("\n");
    }
    // The main function that prints all unique rows in a
    // given matrix.
    void findUniqueRows( int (*M)[COL] )
    {
    Node* root = null; // create an empty Trie
    int i;
    // Iterate through all rows
    for ( i = 0; i < ROW; ++i )
    // insert row to TRIE
    if ( insert(&root, M, i, 0) )
    // unique row found, print it
    printRow( M, i );
    }
    // Driver program to test above functions
    int main()
    {
    int M[ROW][COL] = {{0, 1, 0, 0, 1},
    {1, 0, 1, 1, 0},
    {0, 1, 0, 0, 1},
    {1, 0, 1, 0, 0}
    };
    findUniqueRows( M );
    return 0;
    }
}

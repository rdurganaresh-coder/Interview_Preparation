package com.dsamastery.arrays;

import java.util.*;

public class SortElementsByFrequency {

    // Implementation of above algorithm in C++.
    /* A BST node has data, freq, left and right pointers */
    static class BSTNode
    {
    static class BSTNode *left;
    int data;
    int freq;
    static class BSTNode *right;
    };
    // A structure to store data and its frequency
    static class dataFreq
    {
    int data;
    int freq;
    };
    /* Function for qsort() implementation. Compare frequencies to
    sort the array according to decreasing order of frequency */
    int compare(const void *a, const void *b)
    {
    return ( (*(const dataFreq*)b).freq - (*(const dataFreq*)a).freq );
    }
    /* Helper function that allocates a new node with the given data,
    frequency as 1 and null left and right pointers.*/
    BSTNode* newNode(int data)
    {
    static class BSTNode* node = new BSTNode;
    node.data = data;
    node.left = null;
    node.right = null;
    node.freq = 1;
    return (node);
    }
    // A utility function to insert a given key to BST. If element
    // is already present, then increases frequency
    BSTNode *insert(BSTNode *root, int data)
    {
    if (root == null)
    return newNode(data);
    if (data == root.data) // If already present
    root.freq += 1;
    else if (data < root.data)
    root.left = insert(root.left, data);
    else
    root.right = insert(root.right, data);
    return root;
    }
    // Function to copy elements and their frequencies to count[].
    void store(BSTNode *root, dataFreq count[], int *index)
    {
    // Base Case
    if (root == null) return;
    // Recur for left substree
    store(root.left, count, index);
    // Store item from root and increment index
    count[(*index)].freq = root.freq;
    count[(*index)].data = root.data;
    (*index)++;
    // Recur for right subtree
    store(root.right, count, index);
    }
    // The main function that takes an input array as an argument
    // and sorts the array items according to frequency
    void sortByFrequency(int arr[], int n)
    {
    // Create an empty BST and insert all array items in BST
    static class BSTNode *root = null;
    for (int i = 0; i < n; ++i)
    root = insert(root, arr[i]);
    // Create an auxiliary array 'count[]' to store data and
    // frequency pairs. The maximum size of this array would
    // be n when all elements are different
    dataFreq count[n];
    int index = 0;
    store(root, count, &index);
    // Sort the count[] array according to frequency (or count)
    qsort(count, index, sizeof(count[0]), compare);
    // Finally, traverse the sorted count[] array and copy the
    // i'th item 'freq' times to original array 'arr[]'
    int j = 0;
    for (int i = 0; i < index; i++)
    {
    for (int freq = count[i].freq; freq > 0; freq--)
    arr[j++] = count[i].data;
    }
    }
    // A utility function to print an array of size n
    void printArray(int arr[], int n)
    {
    for (int i = 0; i < n; i++)
    System.out.print(arr[i] << " ");
    System.out.print(endl);
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
    int n = sizeof(arr)/sizeof(arr[0]);
    sortByFrequency(arr, n);
    printArray(arr, n);
    return 0;
    }
}

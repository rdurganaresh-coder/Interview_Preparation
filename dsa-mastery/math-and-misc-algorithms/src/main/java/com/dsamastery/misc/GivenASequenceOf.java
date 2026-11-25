package com.dsamastery.misc;

import java.util.*;

public class GivenASequenceOf {

    // An efficient program to print all anagrams together
    // Structure to represent list node for indexes of words in
    // the given sequence. The list nodes are used to connect
    // anagrams at leaf nodes of Trie
    static class IndexNode
    {
    int index;
    static class IndexNode* next;
    };
    // Structure to represent a Trie Node
    static class TrieNode
    {
    boolean isEnd; // indicates end of word
    static class TrieNode* child[NO_OF_CHARS]; // 26 slots each for 'a' to 'z'
    static class IndexNode* head; // head of the index list
    };
    // A utility function to create a new Trie node
    static class TrieNode* newTrieNode()
    {
    static class TrieNode* temp = new TrieNode;
    temp.isEnd = 0;
    temp.head = null;
    for (int i = 0; i < NO_OF_CHARS; ++i)
    temp.child[i] = null;
    return temp;
    }
    /* Following function is needed for library function qsort(). Refer
    http://www.cplusplus.com/reference/clibrary/cstdlib/qsort/ */
    int compare(const void* a, const void* b)
    { return *(char*)a - *(char*)b; }
    /* A utility function to create a new linked list node */
    static class IndexNode* newIndexNode(int index)
    {
    static class IndexNode* temp = new IndexNode;
    temp.index = index;
    temp.next = null;
    return temp;
    }
    // A utility function to insert a word to Trie
    void insert(static class TrieNode** root, char* word, int index)
    {
    // Base case
    if (*root == null)
    *root = newTrieNode();
    if (*word != '\0')
    insert( &( (*root)->child[tolower(*word) - 'a'] ), word+1, index );
    else // If end of the word reached
    {
    // Insert index of this word to end of index linked list
    if ((*root)->isEnd)
    {
    IndexNode* pCrawl = (*root)->head;
    while( pCrawl.next )
    pCrawl = pCrawl.next;
    pCrawl.next = newIndexNode(index);
    }
    else // If Index list is empty
    {
    (*root)->isEnd = 1;
    (*root)->head = newIndexNode(index);
    }
    }
    }
    // This function traverses the built trie. When a leaf node is reached,
    // all words connected at that leaf node are anagrams. So it traverses
    // the list at leaf node and uses stored index to print original words
    void printAnagramsUtil(static class TrieNode* root, char *wordArr[])
    {
    if (root == null)
    return;
    // If a lead node is reached, print all anagrams using the indexes
    // stored in index linked list
    if (root.isEnd)
    {
    // traverse the list
    IndexNode* pCrawl = root.head;
    while (pCrawl != null)
    {
    System.out.printf( "%s \n", wordArr[ pCrawl.index ] );
    pCrawl = pCrawl.next;
    }
    }
    for (int i = 0; i < NO_OF_CHARS; ++i)
    printAnagramsUtil(root.child[i], wordArr);
    }
    // The main function that prints all anagrams together. wordArr[] is input
    // sequence of words.
    void printAnagramsTogether(char* wordArr[], int size)
    {
    // Create an empty Trie
    static class TrieNode* root = null;
    // Iterate through all input words
    for (int i = 0; i < size; ++i)
    {
    // Create a buffer for this word and copy the word to buffer
    int len = strlen(wordArr[i]);
    char *buffer = new char[len+1];
    strcpy(buffer, wordArr[i]);
    // Sort the buffer
    qsort( (void*)buffer, strlen(buffer), sizeof(char), compare );
    // Insert the sorted buffer and its original index to Trie
    insert(&root, buffer, i);
    }
    // Traverse the built Trie and print all anagrms together
    printAnagramsUtil(root, wordArr);
    }
    // Driver program to test above functions
    int main()
    {
    char* wordArr[] = {"cat", "dog", "tac", "god", "act", "gdo"};
    int size = sizeof(wordArr) / sizeof(wordArr[0]);
    printAnagramsTogether(wordArr, size);
    return 0;
    }
}

package com.dsamastery.trees;

import java.util.*;

public class Trie {

    static class trie_node
    {
    int value; /* Used to mark leaf nodes */
    trie_node_t *children[ALPHABET_SIZE];
    };
    / \ \
    // Alphabet size (# of symbols)
    // Converts key current character into index
    // use only 'a' through 'z' and lower case
    // trie node
    static class trie_node
    {
    int value;
    trie_node_t *children[ALPHABET_SIZE];
    };
    // trie ADT
    static class trie
    {
    trie_node_t *root;
    int count;
    };
    // Returns new trie node (initialized to NULLs)
    trie_node_t *getNode(void)
    {
    trie_node_t *pNode = null;
    pNode = (trie_node_t *)malloc(sizeof(trie_node_t));
    if( pNode )
    {
    int i;
    pNode.value = 0;
    for(i = 0; i < ALPHABET_SIZE; i++)
    {
    pNode.children[i] = null;
    }
    }
    return pNode;
    }
    // Initializes trie (root is dummy node)
    void initialize(trie_t *pTrie)
    {
    pTrie.root = getNode();
    pTrie.count = 0;
    }
    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
    void insert(trie_t *pTrie, char key[])
    {
    int level;
    int length = strlen(key);
    int index;
    trie_node_t *pCrawl;
    pTrie.count++;
    pCrawl = pTrie.root;
    for( level = 0; level < length; level++ )
    {
    index = CHAR_TO_INDEX(key[level]);
    if( !pCrawl.children[index] )
    {
    pCrawl.children[index] = getNode();
    }
    pCrawl = pCrawl.children[index];
    }
    // mark last node as leaf
    pCrawl.value = pTrie.count;
    }
    // Returns non zero, if key presents in trie
    int search(trie_t *pTrie, char key[])
    {
    int level;
    int length = strlen(key);
    int index;
    trie_node_t *pCrawl;
    pCrawl = pTrie.root;
    for( level = 0; level < length; level++ )
    {
    index = CHAR_TO_INDEX(key[level]);
    if( !pCrawl.children[index] )
    {
    return 0;
    }
    pCrawl = pCrawl.children[index];
    }
    return (0 != pCrawl && pCrawl.value);
    }
    // Driver
    int main()
    {
    // Input keys (use only 'a' through 'z' and lower case)
    char keys[][8] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
    trie_t trie;
    char output[][32] = {"Not present in trie", "Present in trie"};
    initialize(&trie);
    // Construct trie
    for(int i = 0; i < ARRAY_SIZE(keys); i++)
    {
    insert(&trie, keys[i]);
    }
    // Search for different keys
    System.out.printf("%s --- %s\n", "the", output[search(&trie, "the")] );
    System.out.printf("%s --- %s\n", "these", output[search(&trie, "these")] );
    System.out.printf("%s --- %s\n", "their", output[search(&trie, "their")] );
    System.out.printf("%s --- %s\n", "thaw", output[search(&trie, "thaw")] );
    return 0;
    }
}

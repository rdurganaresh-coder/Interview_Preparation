package com.dsamastery.dp;

import java.util.*;

public class WordBreak {

    cream, icecream, man, go, mango}
    // A recursive program to test whether a given string can be segmented into
    // space separated words in dictionary
    /* A utility function to check whether a word is present in dictionary or not.
    An array of strings is used for dictionary. Using array of strings for
    dictionary is definitely not a good idea. We have used for simplicity of
    the program*/
    int dictionaryContains(string word)
    {
    string dictionary[] = {"mobile","samsung","sam","sung","man","mango",
    "icecream","and","go","i","like","ice","cream"};
    int size = sizeof(dictionary)/sizeof(dictionary[0]);
    for (int i = 0; i < size; i++)
    if (dictionary[i].compare(word) == 0)
    return true;
    return false;
    }
    // returns true if string can be segmented into space separated
    // words, otherwise returns false
    boolean wordBreak(string str)
    {
    int size = str.size();
    // Base case
    if (size == 0) return true;
    // Try all prefixes of lengths from 1 to size
    for (int i=1; i<=size; i++)
    {
    // The parameter for dictionaryContains is str.substr(0, i)
    // str.substr(0, i) which is prefix (of input string) of
    // length 'i'. We first check whether current prefix is in
    // dictionary. Then we recursively check for remaining string
    // str.substr(i, size-i) which is suffix of length size-i
    if (dictionaryContains( str.substr(0, i) ) &&
    wordBreak( str.substr(i, size-i) ))
    return true;
    }
    // If we have tried all prefixes and none of them worked
    return false;
    }
    // Driver program to test above functions
    int main()
    {
    wordBreak("ilikesamsung")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("iiiiiiii")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("ilikelikeimangoiii")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("samsungandmango")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("samsungandmangok")? System.out.print("Yes\n": cout << "No\n");
    return 0;
    }
    // A Dynamic Programming based program to test whether a given string can
    // be segmented into space separated words in dictionary
    /* A utility function to check whether a word is present in dictionary or not.
    An array of strings is used for dictionary. Using array of strings for
    dictionary is definitely not a good idea. We have used for simplicity of
    the program*/
    int dictionaryContains(string word)
    {
    string dictionary[] = {"mobile","samsung","sam","sung","man","mango",
    "icecream","and","go","i","like","ice","cream"};
    int size = sizeof(dictionary)/sizeof(dictionary[0]);
    for (int i = 0; i < size; i++)
    if (dictionary[i].compare(word) == 0)
    return true;
    return false;
    }
    // Returns true if string can be segmented into space separated
    // words, otherwise returns false
    boolean wordBreak(string str)
    {
    int size = str.size();
    if (size == 0) return true;
    // Create the DP table to store results of subroblems. The value wb[i]
    // will be true if str[0..i-1] can be segmented into dictionary words,
    // otherwise false.
    boolean wb[size+1];
    memset(wb, 0, sizeof(wb)); // Initialize all values as false.
    for (int i=1; i<=size; i++)
    {
    // if wb[i] is false, then check if current prefix can make it true.
    // Current prefix is "str.substr(0, i)"
    if (wb[i] == false && dictionaryContains( str.substr(0, i) ))
    wb[i] = true;
    // wb[i] is true, then check for all substrings starting from
    // (i+1)th character and store their results.
    if (wb[i] == true)
    {
    // If we reached the last prefix
    if (i == size)
    return true;
    for (int j = i+1; j <= size; j++)
    {
    // Update wb[j] if it is false and can be updated
    // Note the parameter passed to dictionaryContains() is
    // substring starting from index 'i' and length 'j-i'
    if (wb[j] == false && dictionaryContains( str.substr(i, j-i) ))
    wb[j] = true;
    // If we reached the last character
    if (j == size && wb[j] == true)
    return true;
    }
    }
    }
    /* Uncomment these lines to print DP table "wb[]"
    for (int i = 1; i <= size; i++)
    System.out.print(" " << wb[i]); */
    // If we have tried all prefixes and none of them worked
    return false;
    }
    // Driver program to test above functions
    int main()
    {
    wordBreak("ilikesamsung")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("iiiiiiii")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("ilikelikeimangoiii")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("samsungandmango")? System.out.print("Yes\n": cout << "No\n");
    wordBreak("samsungandmangok")? System.out.print("Yes\n": cout << "No\n");
    return 0;
    }
}

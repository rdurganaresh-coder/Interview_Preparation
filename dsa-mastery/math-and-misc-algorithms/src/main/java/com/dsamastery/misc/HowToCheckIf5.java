package com.dsamastery.misc;

import java.util.*;

public class HowToCheckIf {

    Input: set1[] = {12, 34, 11, 9, 3}
    set2[] = {2, 1, 3, 5}
    Input: set1[] = {12, 34, 11, 9, 3}
    set2[] = {7, 2, 1, 5}
    Method 1 (Simple)
    // A Simple C++ program to check if two sets are disjoint
    // Returns true if set1[] and set2[] are disjoint, else false
    boolean areDisjoint(int set1[], int set2[], int m, int n)
    {
    // Take every element of set1[] and search it in set2
    for (int i=0; i<m; i++)
    for (int j=0; j<n; j++)
    if (set1[i] == set2[j])
    return false;
    // If no element of set1 is present in set2
    return true;
    }
    // Driver program to test above function
    int main()
    {
    int set1[] = {12, 34, 11, 9, 3};
    int set2[] = {7, 2, 1, 5};
    int m = sizeof(set1)/sizeof(set1[0]);
    int n = sizeof(set2)/sizeof(set2[0]);
    areDisjoint(set1, set2, m, n)? System.out.print("Yes" : cout << " No");
    return 0;
    }
    Method 2 (Use Sorting and Merging)
    // A Simple C++ program to check if two sets are disjoint
    // Returns true if set1[] and set2[] are disjoint, else false
    boolean areDisjoint(int set1[], int set2[], int m, int n)
    {
    // Sort the given two sets
    sort(set1, set1+m);
    sort(set2, set2+n);
    // Check for same elements using merge like process
    int i = 0, j = 0;
    while (i < m && j < n)
    {
    if (set1[i] < set2[j])
    i++;
    else if (set2[j] < set1[i])
    j++;
    else /* if set1[i] == set2[j] */
    return false;
    }
    return true;
    }
    // Driver program to test above function
    int main()
    {
    int set1[] = {12, 34, 11, 9, 3};
    int set2[] = {7, 2, 1, 5};
    int m = sizeof(set1)/sizeof(set1[0]);
    int n = sizeof(set2)/sizeof(set2[0]);
    areDisjoint(set1, set2, m, n)? System.out.print("Yes" : cout << " No");
    return 0;
    }
    Method 3 (Use Sorting and Binary Search)
    Time complexity of this method is O(mLogm + nLogm)
    Method 4 (Use Binary Search Tree)
    Method 5 (Use Hashing)
    else ignore the element.
    /* Java program to check if two sets are distinct or not */
    import java.util.*;
    class Main
    {
    // This function prints all distinct elements
    static boolean areDisjoint(int set1[], int set2[])
    {
    // Creates an empty hashset
    HashSet<Integer> set = new HashSet<>();
    // Traverse the first set and store its elements in hash
    for (int i=0; i<set1.length; i++)
    set.add(set1[i]);
    // Traverse the second set and check if any element of it
    // is already in hash or not.
    for (int i=0; i<set2.length; i++)
    if (set.contains(set2[i]))
    return false;
    return true;
    }
    // Driver method to test above method
    public static void main (String[] args)
    {
    int set1[] = {10, 5, 3, 4, 6};
    int set2[] = {8, 7, 9, 3};
    if (areDisjoint(set1, set2)
    System.out.println("Yes");
    else
    System.out.println("No");
    }
    }
}

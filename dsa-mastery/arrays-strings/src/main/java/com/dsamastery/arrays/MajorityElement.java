package com.dsamastery.arrays;

import java.util.*;

public class MajorityElement {

    METHOD 1 (Basic)
    METHOD 2 (Using Binary Search Tree)
    static class tree
    {
    int element;
    int count;
    }BST;
    METHOD 3 (Using Moore’s Voting Algorithm)
    findCandidate(a[], size)
    count--;
    maj_index = i;
    printMajority (a[], size)
    /* Program for finding out majority element in an array */
    int findCandidate(int *, int);
    boolean isMajority(int *, int, int);
    /* Function to print Majority Element */
    void printMajority(int a[], int size)
    {
    /* Find the candidate for Majority*/
    int cand = findCandidate(a, size);
    /* Print the candidate if it is Majority*/
    if(isMajority(a, size, cand))
    System.out.printf(" %d ", cand);
    else
    System.out.printf("NO Majority Element");
    }
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)
    {
    int maj_index = 0, count = 1;
    int i;
    for(i = 1; i < size; i++)
    {
    if(a[maj_index] == a[i])
    count++;
    else
    count--;
    if(count == 0)
    {
    maj_index = i;
    count = 1;
    }
    }
    return a[maj_index];
    }
    /* Function to check if the candidate occurs more than n/2 times */
    boolean isMajority(int a[], int size, int cand)
    {
    int i, count = 0;
    for (i = 0; i < size; i++)
    if(a[i] == cand)
    count++;
    if (count > size/2)
    return 1;
    else
    return 0;
    }
    /* Driver function to test above functions */
    int main()
    {
    int a[] = {1, 3, 3, 1, 2};
    printMajority(a, 5);
    getchar();
    return 0;
    }
}

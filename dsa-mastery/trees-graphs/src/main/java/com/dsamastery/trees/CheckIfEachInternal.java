package com.dsamastery.trees;

import java.util.*;

public class CheckIfEachInternal {

    Input: pre[] = {20, 10, 11, 13, 12}
    \
    \
    Approach 1 (Naive)
    boolean hasOnlyOneChild(int pre[], int size)
    {
    int nextDiff, lastDiff;
    for (int i=0; i<size-1; i++)
    {
    nextDiff = pre[i] - pre[i+1];
    lastDiff = pre[i] - pre[size-1];
    if (nextDiff*lastDiff < 0)
    return false;;
    }
    return true;
    }
    // driver program to test above function
    int main()
    {
    int pre[] = {8, 3, 5, 7, 6};
    int size = sizeof(pre)/sizeof(pre[0]);
    if (hasOnlyOneChild(pre, size) == true )
    System.out.printf("Yes");
    else
    System.out.printf("No");
    return 0;
    }
    int hasOnlyOneChild(int pre[], int size)
    {
    // Initialize min and max using last two elements
    int min, max;
    if (pre[size-1] > pre[size-2])
    {
    max = pre[size-1];
    min = pre[size-2]):
    else
    {
    max = pre[size-2];
    min = pre[size-1];
    }
    // Every element must be either smaller than min or
    // greater than max
    for (int i=size-3; i>=0; i--)
    {
    if (pre[i] < min)
    min = pre[i];
    else if (pre[i] > max)
    max = pre[i];
    else
    return false;
    }
    return true;
    }
    // Driver program to test above function
    int main()
    {
    int pre[] = {8, 3, 5, 7, 6};
    int size = sizeof(pre)/sizeof(pre[0]);
    if (hasOnlyOneChild(pre,size))
    System.out.printf("Yes");
    else
    System.out.printf("No");
    return 0;
    }
    Output:
    Yes
    Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic
    discussed above
    Source
    http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
}

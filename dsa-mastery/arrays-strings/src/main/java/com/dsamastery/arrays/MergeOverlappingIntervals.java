package com.dsamastery.arrays;

import java.util.*;

public class MergeOverlappingIntervals {

    For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4}
    be merged and become {5, 8}
    // A C++ program for merging overlapping intervals
    // An interval has start time and end time
    static class Interval
    {
    int start, end;
    };
    // Compares two intervals according to their staring time.
    // This is needed for sorting the intervals using library
    // function std::sort(). See http://goo.gl/iGspV
    boolean compareInterval(Interval i1, Interval i2)
    {
    return (i1.start < i2.start);
    }
    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    void mergeIntervals(Interval arr[], int n)
    {
    // Test if the given set has at least one interval
    if (n <= 0)
    return;
    // Create an empty stack of intervals
    stack<Interval> s;
    // sort the intervals in increasing order of start time
    sort(arr, arr+n, compareInterval);
    // push the first interval to stack
    s.push(arr[0]);
    // Start from the next interval and merge if necessary
    for (int i = 1 ; i < n; i++)
    {
    // get interval from stack top
    Interval top = s.top();
    // if current interval is not overlapping with stack top,
    // push it to the stack
    if (top.end < arr[i].start)
    s.push(arr[i]);
    // Otherwise update the ending time of top if ending of current
    // interval is more
    else if (top.end < arr[i].end)
    {
    top.end = arr[i].end;
    s.pop();
    s.push(top);
    }
    }
    // Print contents of stack
    System.out.print("\n The Merged Intervals are: ");
    while (!s.empty())
    {
    Interval t = s.top();
    System.out.print("[" << t.start << "," << t.end << "] ");
    s.pop();
    }
    return;
    }
    // Driver program
    int main()
    {
    Interval arr[] = { {6,8}, {1,9}, {2,4}, {4,7} };
    int n = sizeof(arr)/sizeof(arr[0]);
    mergeIntervals(arr, n);
    return 0;
    }
    // C++ program to merge overlapping Intervals in
    // O(n Log n) time and O(1) extra space.
    // An Interval
    static class Interval
    {
    int s, e;
    };
    // Function used in sort
    boolean mycomp(Interval a, Interval b)
    { return a.s > b.s; }
    void mergeIntervals(Interval arr[], int n)
    {
    // Sort Intervals in decreasing order of
    // start time
    sort(arr, arr+n, mycomp);
    int index = 0; // Stores index of last element
    // in output array (modified arr[])
    // Traverse all input Intervals
    for (int i=0; i<n; i++)
    {
    // If this is not first Interval and overlaps
    // with the previous one
    if (index != 0 && arr[index-1].s <= arr[i].e)
    {
    // Merge previous and current Intervals
    arr[index-1].e = max(arr[index-1].e, arr[i].e);
    arr[index-1].s = min(arr[index-1].s, arr[i].s);
    }
    else // Doesn't overlap with previous, add to
    { // solution
    arr[index] = arr[i];
    index++;
    }
    }
    // Now arr[0..index-1] stores the merged Intervals
    System.out.print("\n The Merged Intervals are: ");
    for (int i = 0; i < index; i++)
    System.out.print("[" << arr[i].s << ", " << arr[i].e << "] ");
    }
    // Driver program
    int main()
    {
    Interval arr[] = { {6,8}, {1,9}, {2,4}, {4,7} };
    int n = sizeof(arr)/sizeof(arr[0]);
    mergeIntervals(arr, n);
    return 0;
    }
}

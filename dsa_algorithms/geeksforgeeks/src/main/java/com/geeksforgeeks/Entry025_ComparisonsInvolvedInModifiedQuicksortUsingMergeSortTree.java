package com.geeksforgeeks;// Java code
import java.util.*;

public class Entry025_ComparisonsInvolvedInModifiedQuicksortUsingMergeSortTree {

    static final int MAX = 1000;

    // Constructs a segment tree and stores tree[]
    public static void buildTree(int treeIndex, int l,
                                 int r, int[] arr,
                                 Vector<Integer>[] tree)
    {

        /*
         * l => start of range, r => ending of a range,
         * treeIndex => index in the Segment Tree/Merge Sort
         * Tree
         */
        /* leaf node */
        if (l == r) {
            tree[treeIndex].add(arr[l - 1]);
            return;
        }

        int mid = (l + r) / 2;

        /* building left subtree */
        buildTree(2 * treeIndex, l, mid, arr, tree);

        /* building left subtree */
        buildTree(2 * treeIndex + 1, mid + 1, r, arr, tree);

        /* merging left and right child in sorted order */
        Collections.sort(tree[2 * treeIndex]);
        Collections.sort(tree[2 * treeIndex + 1]);
        tree[treeIndex].addAll(tree[2 * treeIndex]);
        tree[treeIndex].addAll(tree[2 * treeIndex + 1]);
    }

    // Returns the Kth smallest number in query range
    public static int queryRec(int segmentStart,
                               int segmentEnd,
                               int queryStart, int queryEnd,
                               int treeIndex, int K,
                               Vector<Integer>[] tree)
    {

        /*
         * segmentStart => start of a Segment, segmentEnd =>
         * ending of a Segment, queryStart => start of a
         * query range, queryEnd => ending of a query range,
         * treeIndex => index in the Segment Tree/Merge Sort
         * Tree, K => kth smallest number to find
         */
        if (segmentStart == segmentEnd)
            return tree[treeIndex].get(0);

        int mid = (segmentStart + segmentEnd) / 2;

        // finds the last index in the segment which is <=
        // queryEnd
        int lastInQueryRange = Collections.binarySearch(
                tree[2 * treeIndex], queryEnd);
        if (lastInQueryRange < 0) {
            lastInQueryRange = Math.abs(lastInQueryRange);
            lastInQueryRange--;
        }

        // finds the first index in the segment which is >=
        // queryStart
        int firstInQueryRange = Collections.binarySearch(
                tree[2 * treeIndex], queryStart);
        if (firstInQueryRange < 0) {
            firstInQueryRange = Math.abs(firstInQueryRange);
            firstInQueryRange--;
        }

        int M = lastInQueryRange - firstInQueryRange;

        if (M >= K) {

            // Kth smallest is in left subtree, so
            // recursively call left subtree for Kth
            // smallest number
            return queryRec(segmentStart, mid, queryStart,
                    queryEnd, 2 * treeIndex, K,
                    tree);
        }
        else {

            // Kth smallest is in right subtree, so
            // recursively call right subtree for the
            // (K-M)th smallest number
            return queryRec(mid + 1, segmentEnd, queryStart,
                    queryEnd, 2 * treeIndex + 1,
                    K - M, tree);
        }
    }

    // A wrapper over query()
    public static int query(int queryStart, int queryEnd,
                            int K, int n, int[] arr,
                            Vector<Integer>[] tree)
    {

        return queryRec(1, n, queryStart, queryEnd, 1, K,
                tree);
    }

    /*
     * Calculates total Comparisons Involved in Quick Sort
     * Has the following parameters:
     *
     * start => starting index of array end => ending index
     * of array n => size of array tree => Merge Sort Tree
     */
    public static int
    quickSortComparisons(int start, int end, int n,
                         int[] arr, Vector<Integer>[] tree)
    {

        /* Base Case */
        if (start >= end)
            return 0;

        // Compute the middle point of range and the pivot
        int middlePoint = (end - start + 2) / 2;
        int pivot
                = query(start, end, middlePoint, n, arr, tree);

        /* Total Comparisons = (Comparisons in Left part +
                            Comparisons of right +
                            Comparisons in parent) */

        // count comparisons in parent array
        int comparisons_in_parent = (end - start + 1);

        // count comparisons involved in left partition
        int comparisons_in_left_part = quickSortComparisons(
                start, pivot - 1, n, arr, tree);

        // count comparisons involved in right partition
        int comparisons_in_right_part
                = quickSortComparisons(pivot + 1, end, n, arr,
                tree);

        // Return Total Comparisons
        return comparisons_in_left_part
                + comparisons_in_parent
                + comparisons_in_right_part;
    }

    // Driver code
    public static void main(String[] args)
    {

        int[] arr = { 4, 3, 5, 1, 2 };

        int n = arr.length;

        // Construct segment tree in tree[]
        Vector<Integer>[] tree = new Vector[MAX];
        for (int i = 0; i < MAX; i++) {
            tree[i] = new Vector<>();
        }
        buildTree(1, 1, n, arr, tree);

        System.out.println(
                "Number of Comparisons = "
                        + quickSortComparisons(1, n, n, arr, tree));
    }
}
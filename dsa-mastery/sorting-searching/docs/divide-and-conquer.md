# Divide And Conquer

> **Original PDF:** [Divide and Conquer.pdf](../../docs/Divide and Conquer.pdf)

## Table of Contents

- [Chapter 1: Divide and Conquer | Set 1](#chapter-1-divide-and-conquer-set-1)
- [Chapter 2: Write a C program to calculate](#chapter-2-write-a-c-program-to-calculate)
- [Chapter 3: Median of two sorted arrays](#chapter-3-median-of-two-sorted-arrays)
- [Chapter 4: Count Inversions in an array](#chapter-4-count-inversions-in-an-array)
- [Chapter 5: Divide and Conquer | Set 2 (Closest](#chapter-5-divide-and-conquer-set-2-closest)
- [Chapter 6: Divide and Conquer | Set 5](#chapter-6-divide-and-conquer-set-5)

---

## Chapter 1: Divide and Conquer | Set 1

(Introduction) Like Greedyand Dynamic Programming, Divide and Conquer is an algorithmic paradigm. A typical Divide and Conquer algorithm solves a problem using following three steps.
1. Divide: Break the given problem into subproblems of same type.
2. Conquer: Recursively solve these subproblems 3. Combine: Appropriately combine the answers Following are some standard algorithms that are Divide and Conquer algorithms.
1) Binary Search is a searching algorithm. In each step, the algorithm compares the input element x with the value of the middle element in array. If the values match, return the index of middle. Otherwise, if x is less than the middle element, then the algorithm recurs for left side of middle element, else recurs for right side of middle element.
2) Quicksort is a sorting algorithm. The algorithm picks a pivot element, rearranges the array elements in such a way that all elements smaller than the picked pivot element move to left side of pivot, and all greater elements move to right side. Finally, the algorithm recursively sorts the subarrays on left and right of pivot element.
3) Merge Sort is also a sorting algorithm. The algorithm divides the array in two halves, recursively sorts them and ﬁnally merges the two sorted halves.
4) Closest Pair of Points The problem is to ﬁnd the closest pair of points in a set of points in x-y plane.
The problem can be solved in O(nˆ2) time by calculating distances of every pair of points and comparing the distances to ﬁnd the minimum. The Divide and Conquer algorithm solves the problem in O(nLogn) time.
5) Strassen’s Algorithm is an eﬃcient algorithm to multiply two matrices. A simple method to multiply two matrices need 3 nested loops and is O(nˆ3). Strassen’s algorithm multiplies two matrices in O(nˆ2.8974) time.
6) Cooley–Tukey Fast Fourier Transform (FFT) algorithm is the most common algorithm for FFT.
It is a divide and conquer algorithm which works in O(nlogn) time.
7) Karatsuba algorithm for fast multiplication it does multiplication of two n-digit numbers in at most single-digit multiplications in general (and exactly when n is a power of 2). It is therefore faster than the classicalalgorithm, which requires n2 single-digit products. If n = 210 = 1024, in particular, the exact counts are 310 = 59,049 and (210)2 = 1,048,576, respectively.
We will publishing above algorithms in separate posts.
Divide and Conquer (D & C) vs Dynamic Programming (DP) Both paradigms (D & C and DP) divide the given problem into subproblems and solve subproblems. How to choose one of them for a given problem? Divide and Conquer should be used when same subproblems are not evaluated many times. Otherwise Dynamic Programming or Memoization should be used. For example, Binary Search is a Divide and Conquer algorithm, we never evaluate the same subproblems again. On the other hand, for calculating nth Fibonacci number, Dynamic Programming should be preferred (See thisfor details).
References Algorithms by Sanjoy Dasgupta, Christos Papadimitriou, Umesh Vazirani Introduction to Algorithms by Cliﬀord Stein, Thomas H. Cormen, Charles E. Leiserson, Ronald L.
- [Reference Link](http://en.wikipedia.org/wiki/Karatsuba_algorithm)
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/divide-and-conquer-set-1-find-closest-pair-of-points/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 2: Write a C program to calculate

> **Java Implementation:** [`WriteACProgram.java`](../src/main/java/com/dsamastery/sorting/WriteACProgram.java) (`sorting-searching`)

```java
pow(x,n)
```

Below solution divides the problem into subproblems of size y/2 and call the subproblems recursively.

```java
#include<stdio.h>
/* Function to calculate x raised to the power y */
int power(int x, unsigned int y)
{
if( y == 0)
return 1;
else if (y%2 == 0)
return power(x, y/2)*power(x, y/2);
else
return x*power(x, y/2)*power(x, y/2);
}
/* Program to test function power */
int main()
{
int x = 2;
unsigned int y = 3;
printf("%d", power(x, y));
getchar();
return 0;
}
```

Time Complexity: O(n) Space Complexity: O(1) Algorithmic Paradigm: Divide and conquer.
Above function can be optimized to O(logn) by calculating power(x, y/2) only once and storing it.

```java
/* Function to calculate x raised to the power y in O(logn)*/
int power(int x, unsigned int y)
{
int temp;
if( y == 0)
return 1;
temp = power(x, y/2);
if (y%2 == 0)
return temp*temp;
else
return x*temp*temp;
}
```

Time Complexity of optimized solution: O(logn) Let us extend the pow function to work for negative y and ﬂoat x.

```java
/* Extended version of power function that can work
for float x and negative y*/
#include<stdio.h>
float power(float x, int y)
{
float temp;
if( y == 0)
return 1;
temp = power(x, y/2);
if (y%2 == 0)
return temp*temp;
else
{
if(y > 0)
return x*temp*temp;
else
return (temp*temp)/x;
}
}
/* Program to test function power */
int main()
{
float x = 2;
int y = -3;
printf("%f", power(x, y));
getchar();
return 0;
}
```

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/)
Category: C/C++ Puzzles Tags: Divide and Conquer

[↑ Back to Top](#table-of-contents)

---

## Chapter 3: Median of two sorted arrays

> **Java Implementation:** [`MedianOfTwoSorted3.java`](../../arrays-strings/src/main/java/com/dsamastery/arrays/MedianOfTwoSorted3.java) (`arrays-strings`)

Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to ﬁnd the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)) Median: In probability theory and statistics, a median is described as the number separating the higher half of a sample, a population, or a probability distribution, from the lower half.
The median of a ﬁnite list of numbers can be found by arranging all the numbers from lowest value to highest value and picking the middle one.
For getting the median of input array { 12, 11, 15, 10, 20 }, ﬁrst sort the array. We get { 10, 11, 12, 15, 20 } after sorting. Median is the middle element of the sorted array which is 12.
There are diﬀerent conventions to take median of an array with even number of elements, one can take the mean of the two middle values, or ﬁrst middle value, or second middle value.
Let us see diﬀerent methods to get the median of two sorted arrays of size n each. Since size of the set for which we are looking for median is even (2n), we are taking average of middle two numbers in all below solutions.

```java
Method 1 (Simply count while Merging)
```

Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays. If count becomes n(For 2n elements), we have reached the median. Take the average of the elements at indexes n-1 and n in the merged array. See the below implementation.
Implementation:

```java
#include <stdio.h>
/* This function returns median of ar1[] and ar2[].
Assumptions in this function:
Both ar1[] and ar2[] are sorted arrays
Both have n elements */
int getMedian(int ar1[], int ar2[], int n)
{
int i = 0; /* Current index of i/p array ar1[] */
int j = 0; /* Current index of i/p array ar2[] */
int count;
int m1 = -1, m2 = -1;
/* Since there are 2n elements, median will be average
of elements at index n-1 and n in the array obtained after
merging ar1 and ar2 */
for (count = 0; count <= n; count++)
{
/*Below is to handle case where all elements of ar1[] are
smaller than smallest(or first) element of ar2[]*/
if (i == n)
{
m1 = m2;
m2 = ar2[0];
break;
}
/*Below is to handle case where all elements of ar2[] are
smaller than smallest(or first) element of ar1[]*/
else if (j == n)
{
m1 = m2;
m2 = ar1[0];
break;
}
if (ar1[i] < ar2[j])
{
m1 = m2; /* Store the prev median */
m2 = ar1[i];
i++;
}
else
{
m1 = m2; /* Store the prev median */
m2 = ar2[j];
j++;
}
}
return (m1 + m2)/2;
}
/* Driver program to test above function */
int main()
{
int ar1[] = {1, 12, 15, 26, 38};
int ar2[] = {2, 13, 17, 30, 45};
int n1 = sizeof(ar1)/sizeof(ar1[0]);
int n2 = sizeof(ar2)/sizeof(ar2[0]);
if (n1 == n2)
printf("Median is %d", getMedian(ar1, ar2, n1));
else
printf("Doesn't work for arrays of unequal size");
getchar();
return 0;
}
```

Time Complexity: O(n)

```java
Method 2 (By comparing the medians of two arrays)
```

This method works by ﬁrst getting medians of the two sorted arrays and then comparing them.
Let ar1 and ar2 be the input arrays.
Algorithm:
1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.

```java
return m1 (or m2)
```

3) If m1 is greater than m2, then median is present in one of the below two subarrays.
a) From first element of ar1 to m1 (ar1[0...|_n/2_|]) b) From m2 to last element of ar2 (ar2[|_n/2_|...n-1]) 4) If m2 is greater than m1, then median is present in one of the below two subarrays.
a) From m1 to last element of ar1 (ar1[|_n/2_|...n-1]) b) From first element of ar2 to m2 (ar2[0...|_n/2_|]) 5) Repeat the above process until size of both the subarrays becomes 2.
6) If size of the two arrays is 2 then use below formula to get the median.
Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2

### Example

```java
ar1[] = {1, 12, 15, 26, 38}
ar2[] = {2, 13, 17, 30, 45}
```

For above two arrays m1 = 15 and m2 = 17 For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of the following two subarrays.
[15, 26, 38] and [2, 13, 17] Let us repeat the process for above two subarrays:
m1 = 26 m2 = 13.
m1 is greater than m2. So the subarrays become [15, 26] and [13, 17] Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2 = (max(15, 13) + min(26, 17))/2 = (15 + 17)/2 = 16 Implementation:

```java
#include<stdio.h>
int max(int, int); /* to get maximum of two integers */
int min(int, int); /* to get minimum of two integeres */
int median(int [], int); /* to get median of a sorted array */
/* This function returns median of ar1[] and ar2[].
Assumptions in this function:
Both ar1[] and ar2[] are sorted arrays
Both have n elements */
int getMedian(int ar1[], int ar2[], int n)
{
int m1; /* For median of ar1 */
int m2; /* For median of ar2 */
/* return -1 for invalid input */
if (n <= 0)
return -1;
if (n == 1)
return (ar1[0] + ar2[0])/2;
if (n == 2)
return (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1])) / 2;
m1 = median(ar1, n); /* get the median of the first array */
m2 = median(ar2, n); /* get the median of the second array */
/* If medians are equal then return either m1 or m2 */
if (m1 == m2)
return m1;
/* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
if (m1 < m2)
{
if (n % 2 == 0)
return getMedian(ar1 + n/2 - 1, ar2, n - n/2 +1);
else
return getMedian(ar1 + n/2, ar2, n - n/2);
}
/* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
else
{
if (n % 2 == 0)
return getMedian(ar2 + n/2 - 1, ar1, n - n/2 + 1);
else
return getMedian(ar2 + n/2, ar1, n - n/2);
}
}
/* Function to get median of a sorted array */
int median(int arr[], int n)
{
if (n%2 == 0)
return (arr[n/2] + arr[n/2-1])/2;
else
return arr[n/2];
}
/* Driver program to test above function */
int main()
{
int ar1[] = {1, 2, 3, 6};
int ar2[] = {4, 6, 8, 10};
int n1 = sizeof(ar1)/sizeof(ar1[0]);
int n2 = sizeof(ar2)/sizeof(ar2[0]);
if (n1 == n2)
printf("Median is %d", getMedian(ar1, ar2, n1));
else
printf("Doesn't work for arrays of unequal size");
getchar();
return 0;
}
/* Utility functions */
int max(int x, int y)
{
return x > y? x : y;
}
int min(int x, int y)
{
return x > y? y : x;
}
```

Time Complexity: O(logn) Algorithmic Paradigm: Divide and Conquer Method 3 (By doing binary search for the median):
The basic idea is that if you are given two arrays ar1[] and ar2[] and know the length of each, you can check whether an element ar1[i] is the median in constant time. Suppose that the median is ar1[i]. Since the array is sorted, it is greater than exactly i values in array ar1[]. Then if it is the median, it is also greater than exactly j = n – i – 1 elements in ar2[].
It requires constant time to check if ar2[j] 1) Get the middle element of ar1[] using array indexes left and right. Let index of the middle element be i. 2) Calculate the corresponding index j of ar2[] j = n – i – 1 3) If ar1[i] >= ar2[j] and ar1[i]

### Example

```java
ar1[] = {1, 5, 7, 10, 13}
ar2[] = {11, 15, 23, 30, 45}
```

Middle element of ar1[] is 7. Let us compare 7 with 23 and 30, since 7 smaller than both 23 and 30, move to right in ar1[]. Do binary search in {10, 13}, this step will pick 10. Now compare 10 with 15 and 23. Since 10 is smaller than both 15 and 23, again move to right. Only 13 is there in right side now. Since 13 is greater than 11 and smaller than 15, terminate here. We have got the median as 12 (average of 11 and 13) Implementation:

```java
#include<stdio.h>
int getMedianRec(int ar1[], int ar2[], int left, int right, int n);
/* This function returns median of ar1[] and ar2[].
Assumptions in this function:
Both ar1[] and ar2[] are sorted arrays
Both have n elements */
int getMedian(int ar1[], int ar2[], int n)
{
return getMedianRec(ar1, ar2, 0, n-1, n);
}
/* A recursive function to get the median of ar1[] and ar2[]
using binary search */
int getMedianRec(int ar1[], int ar2[], int left, int right, int n)
{
int i, j;
/* We have reached at the end (left or right) of ar1[] */
if (left > right)
return getMedianRec(ar2, ar1, 0, n-1, n);
i = (left + right)/2;
j = n - i - 1; /* Index of ar2[] */
/* Recursion terminates here.*/
if (ar1[i] > ar2[j] && (j == n-1 || ar1[i] <= ar2[j+1]))
{
/* ar1[i] is decided as median 2, now select the median 1
(element just before ar1[i] in merged array) to get the
average of both*/
if (i == 0 || ar2[j] > ar1[i-1])
return (ar1[i] + ar2[j])/2;
else
return (ar1[i] + ar1[i-1])/2;
}
/*Search in left half of ar1[]*/
else if (ar1[i] > ar2[j] && j != n-1 && ar1[i] > ar2[j+1])
return getMedianRec(ar1, ar2, left, i-1, n);
/*Search in right half of ar1[]*/
else /* ar1[i] is smaller than both ar2[j] and ar2[j+1]*/
return getMedianRec(ar1, ar2, i+1, right, n);
}
/* Driver program to test above function */
int main()
{
int ar1[] = {1, 12, 15, 26, 38};
int ar2[] = {2, 13, 17, 30, 45};
int n1 = sizeof(ar1)/sizeof(ar1[0]);
int n2 = sizeof(ar2)/sizeof(ar2[0]);
if (n1 == n2)
printf("Median is %d", getMedian(ar1, ar2, n1));
else
printf("Doesn't work for arrays of unequal size");
getchar();
return 0;
}
```

Time Complexity: O(logn) Algorithmic Paradigm: Divide and Conquer The above solutions can be optimized for the cases when all elements of one array are smaller than all elements of other array. For example, in method 3, we can change the getMedian() function to following so that these cases can be handled in O(1) time. Thanks to nutcracker for suggesting this optimization.

```java
/* This function returns median of ar1[] and ar2[].
Assumptions in this function:
Both ar1[] and ar2[] are sorted arrays
Both have n elements */
int getMedian(int ar1[], int ar2[], int n)
{
// If all elements of array 1 are smaller then
// median is average of last element of ar1 and
// first element of ar2
if (ar1[n-1] < ar2[0])
return (ar1[n-1]+ar2[0])/2;
// If all elements of array 1 are smaller then
// median is average of first element of ar1 and
// last element of ar2
if (ar2[n-1] < ar1[0])
return (ar2[n-1]+ar1[0])/2;
return getMedianRec(ar1, ar2, 0, n-1, n);
}
```

### References

- [Reference Link](http://en.wikipedia.org/wiki/Median)
- [Reference Link](http://ocw.alfaisal.edu/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-)
E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf ds3etph5wn Asked by Snehal Please write comments if you ﬁnd the above codes/algorithms incorrect, or ﬁnd other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/median-of-two-sorted-arrays/)
Category: Arrays Tags: Divide and Conquer

[↑ Back to Top](#table-of-contents)

---

## Chapter 4: Count Inversions in an array

> **Java Implementation:** [`CountInversionsInAn2.java`](../../arrays-strings/src/main/java/com/dsamastery/arrays/CountInversionsInAn2.java) (`arrays-strings`)

Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

```java
METHOD 1 (Simple)
```

For each element, count number of elements which are on right side of it and are smaller than it.

```java
int getInvCount(int arr[], int n)
{
int inv_count = 0;
int i, j;
for(i = 0; i < n - 1; i++)
for(j = i+1; j < n; j++)
if(arr[i] > arr[j])
inv_count++;
return inv_count;
}
/* Driver progra to test above functions */
int main(int argv, char** args)
{
int arr[] = {1, 20, 6, 4, 5};
printf(" Number of inversions are %d \n", getInvCount(arr, 5));
getchar();
return 0;
}
```

Time Complexity: O(nˆ2)

```java
METHOD 2(Enhance Merge Sort)
```

Suppose we know the number of inversions in the left half and right half of the array (let be inv1 and inv2), what kinds of inversions are not accounted for in Inv1 + Inv2? The answer is – the inversions we have to count during the merge step. Therefore, to get number of inversions, we need to add number of inversions in left subarray, right subarray and merge().
How to get number of inversions in merge()?
In merge process, let i is used for indexing left sub-array and j for right sub-array. At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j] The complete picture:
Implementation:

```java
#include <stdio.h>
#include <stdlib.h>
int _mergeSort(int arr[], int temp[], int left, int right);
int merge(int arr[], int temp[], int left, int mid, int right);
/* This function sorts the input array and returns the
number of inversions in the array */
int mergeSort(int arr[], int array_size)
{
int *temp = (int *)malloc(sizeof(int)*array_size);
return _mergeSort(arr, temp, 0, array_size - 1);
}
/* An auxiliary recursive function that sorts the input array and
returns the number of inversions in the array. */
int _mergeSort(int arr[], int temp[], int left, int right)
{
int mid, inv_count = 0;
if (right > left)
{
/* Divide the array into two parts and call _mergeSortAndCountInv()
for each of the parts */
mid = (right + left)/2;
/* Inversion count will be sum of inversions in left-part, right-part
and number of inversions in merging */
inv_count = _mergeSort(arr, temp, left, mid);
inv_count += _mergeSort(arr, temp, mid+1, right);
/*Merge the two parts*/
inv_count += merge(arr, temp, left, mid+1, right);
}
return inv_count;
}
/* This funt merges two sorted arrays and returns inversion count in
the arrays.*/
int merge(int arr[], int temp[], int left, int mid, int right)
{
int i, j, k;
int inv_count = 0;
i = left; /* i is index for left subarray*/
j = mid; /* i is index for right subarray*/
k = left; /* i is index for resultant merged subarray*/
while ((i <= mid - 1) && (j <= right))
{
if (arr[i] <= arr[j])
{
temp[k++] = arr[i++];
}
else
{
temp[k++] = arr[j++];
/*this is tricky -- see above explanation/diagram for merge()*/
inv_count = inv_count + (mid - i);
}
}
/* Copy the remaining elements of left subarray
(if there are any) to temp*/
while (i <= mid - 1)
temp[k++] = arr[i++];
/* Copy the remaining elements of right subarray
(if there are any) to temp*/
while (j <= right)
temp[k++] = arr[j++];
/*Copy back the merged elements to original array*/
for (i=left; i <= right; i++)
arr[i] = temp[i];
return inv_count;
}
/* Driver progra to test above functions */
int main(int argv, char** args)
{
int arr[] = {1, 20, 6, 4, 5};
printf(" Number of inversions are %d \n", mergeSort(arr, 5));
getchar();
return 0;
}
```

Note that above code modiﬁes (or sorts) the input array. If we want to count only inversions then we need to create a copy of original array and call mergeSort() on copy.
Time Complexity: O(nlogn) Algorithmic Paradigm: Divide and Conquer

### References

- [Reference Link](http://www.cs.umd.edu/class/fall2009/cmsc451/lectures/Lec08-inversions.pdf)
- [Reference Link](http://www.cp.eng.chula.ac.th/~piak/teaching/algo/algo2008/count-inv.htm)
Please write comments if you ﬁnd any bug in the above program/algorithm or other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/counting-inversions/)
Category: Arrays Tags: Divide and Conquer

[↑ Back to Top](#table-of-contents)

---

## Chapter 5: Divide and Conquer | Set 2 (Closest

> **Java Implementation:** [`DivideAndConquer2.java`](../src/main/java/com/dsamastery/sorting/DivideAndConquer2.java) (`sorting-searching`)

Pair of Points) We are given an array of n points in the plane, and the problem is to ﬁnd out the closest pair of points in the array. This problem arises in a number of applications. For example, in air-traﬃc control, you may want to monitor planes that come too close together, since this may indicate a possible collision. Recall the following formula for distance between two points p and q.
The Brute force solution is O(nˆ2), compute the distance between each pair and return the smallest. We can calculate the smallest distance in O(nLogn) time using Divide and Conquer strategy. In this post, a O(n x (Logn)ˆ2) approach is discussed. We will be discussing a O(nLogn) approach in a separate post.
Algorithm Following are the detailed steps of a O(n (Logn)ˆ2) algortihm.
Input: An array of n points P[] Output: The smallest distance between two points in the given array.
As a pre-processing step, input array is sorted according to x coordinates.
1) Find the middle point in the sorted array, we can take P[n/2] as middle point.
2) Divide the given array in two halves. The ﬁrst subarray contains points from P[0] to P[n/2]. The second subarray contains points from P[n/2+1] to P[n-1].
3) Recursively ﬁnd the smallest distances in both subarrays. Let the distances be dl and dr. Find the minimum of dl and dr. Let the minimum be d.
4) From above 3 steps, we have an upper bound d of minimum distance. Now we need to consider the pairs such that one point in pair is from left half and other is from right half. Consider the vertical line passing through passing through P[n/2] and ﬁnd all points whose x coordinate is closer than d to the middle vertical line. Build an array strip[] of all such points.
5) Sort the array strip[] according to y coordinates. This step is O(nLogn). It can be optimized to O(n) by recursively sorting and merging.
6) Find the smallest distance in strip[]. This is tricky. From ﬁrst look, it seems to be a O(nˆ2) step, but it is actually O(n). It can be proved geometrically that for every point in strip, we only need to check at most 7 points after it (note that strip is sorted according to Y coordinate). See thisfor more analysis.
7) Finally return the minimum of d and distance calculated in above step (step 6) Implementation Following is C/C++ implementation of the above algorithm.

```java
// A divide and conquer program in C/C++ to find the smallest distance from a
// given set of points.
#include <stdio.h>
#include <float.h>
#include <stdlib.h>
#include <math.h>
// A structure to represent a Point in 2D plane
struct Point
{
int x, y;
};
/* Following two functions are needed for library function qsort().
Refer: http://www.cplusplus.com/reference/clibrary/cstdlib/qsort/ */
// Needed to sort array of points according to X coordinate
int compareX(const void* a, const void* b)
{
Point *p1 = (Point *)a, *p2 = (Point *)b;
return (p1->x - p2->x);
}
// Needed to sort array of points according to Y coordinate
int compareY(const void* a, const void* b)
{
Point *p1 = (Point *)a, *p2 = (Point *)b;
return (p1->y - p2->y);
}
// A utility function to find the distance between two points
float dist(Point p1, Point p2)
{
return sqrt( (p1.x - p2.x)*(p1.x - p2.x) +
(p1.y - p2.y)*(p1.y - p2.y)
);
}
// A Brute Force method to return the smallest distance between two points
// in P[] of size n
float bruteForce(Point P[], int n)
{
float min = FLT_MAX;
for (int i = 0; i < n; ++i)
for (int j = i+1; j < n; ++j)
if (dist(P[i], P[j]) < min)
min = dist(P[i], P[j]);
return min;
}
// A utility function to find minimum of two float values
float min(float x, float y)
{
return (x < y)? x : y;
}
// A utility function to find the distance beween the closest points of
// strip of given size. All points in strip[] are sorted accordint to
// y coordinate. They all have an upper bound on minimum distance as d.
// Note that this method seems to be a O(n^2) method, but it's a O(n)
// method as the inner loop runs at most 6 times
float stripClosest(Point strip[], int size, float d)
{
float min = d; // Initialize the minimum distance as d
qsort(strip, size, sizeof(Point), compareY);
// Pick all points one by one and try the next points till the difference
// between y coordinates is smaller than d.
// This is a proven fact that this loop runs at most 6 times
for (int i = 0; i < size; ++i)
for (int j = i+1; j < size && (strip[j].y - strip[i].y) < min; ++j)
if (dist(strip[i],strip[j]) < min)
min = dist(strip[i], strip[j]);
return min;
}
// A recursive function to find the smallest distance. The array P contains
// all points sorted according to x coordinate
float closestUtil(Point P[], int n)
{
// If there are 2 or 3 points, then use brute force
if (n <= 3)
return bruteForce(P, n);
// Find the middle point
int mid = n/2;
Point midPoint = P[mid];
// Consider the vertical line passing through the middle point
// calculate the smallest distance dl on left of middle point and
// dr on right side
float dl = closestUtil(P, mid);
float dr = closestUtil(P + mid, n-mid);
// Find the smaller of two distances
float d = min(dl, dr);
// Build an array strip[] that contains points close (closer than d)
// to the line passing through the middle point
Point strip[n];
int j = 0;
for (int i = 0; i < n; i++)
if (abs(P[i].x - midPoint.x) < d)
strip[j] = P[i], j++;
// Find the closest points in strip. Return the minimum of d and closest
// distance is strip[]
return min(d, stripClosest(strip, j, d) );
}
// The main functin that finds the smallest distance
// This method mainly uses closestUtil()
float closest(Point P[], int n)
{
qsort(P, n, sizeof(Point), compareX);
// Use recursive function closestUtil() to find the smallest distance
return closestUtil(P, n);
}
// Driver program to test above functions
int main()
{
Point P[] = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
int n = sizeof(P) / sizeof(P[0]);
printf("The smallest distance is %f ", closest(P, n));
return 0;
}
```

### Output

The smallest distance is 1.414214 Time Complexity Let Time complexity of above algorithm be T(n). Let us assume that we use a O(nLogn) sorting algorithm. The above algorithm divides all points in two sets and recursively calls for two sets. After dividing, it ﬁnds the strip in O(n) time, sorts the strip in O(nLogn) time and ﬁnally ﬁnds the closest points in strip in O(n) time. So T(n) can expressed as follows T(n) = 2T(n/2) + O(n) + O(nLogn) + O(n) T(n) = 2T(n/2) + O(nLogn) T(n) = T(n x Logn x Logn) Notes 1) Time complexity can be improved to O(nLogn) by optimizing step 5 of the above algorithm. We will soon be discussing the optimized solution in a separate post.
2) The code ﬁnds smallest distance. It can be easily modiﬁed to ﬁnd the points with smallest distance.
3) The code uses quick sort which can be O(nˆ2) in worst case. To have the upper bound as O(n (Logn)ˆ2), a O(nLogn) sorting algorithm like merge sort or heap sort can be used

### References

- [Reference Link](http://www.cs.umd.edu/class/fall2013/cmsc451/Lects/lect10.pdf)
- [Reference Link](http://www.youtube.com/watch?v=vS4Zn1a9KUc)
- [Reference Link](http://www.youtube.com/watch?v=T3T7T8Ym20M)
- [Reference Link](http://en.wikipedia.org/wiki/Closest_pair_of_points_problem)

### Source

- [Reference Link](http://www.geeksforgeeks.org/closest-pair-of-points/)
Category: Misc Tags: Closest Pair of Points, Divide and Conquer keyword in C++ and Java →

[↑ Back to Top](#table-of-contents)

---

## Chapter 6: Divide and Conquer | Set 5

> **Java Implementation:** [`DivideAndConquer3.java`](../src/main/java/com/dsamastery/sorting/DivideAndConquer3.java) (`sorting-searching`)

(Strassen’s Matrix Multiplication) Given two square matrices A and B of size n x n each, ﬁnd their multiplication matrix.
Naive Method Following is a simple way to multiply two matrices.

```java
void multiply(int A[][N], int B[][N], int C[][N])
{
for (int i = 0; i < N; i++)
{
for (int j = 0; j < N; j++)
{
C[i][j] = 0;
for (int k = 0; k < N; k++)
{
C[i][j] += A[i][k]*B[k][j];
}
}
}
}
```

Time Complexity of above method is O(N3).
Divide and Conquer Following is simple Divide and Conquer method to multiply two square matrices.
1) Divide matrices A and B in 4 sub-matrices of size N/2 x N/2 as shown in the below diagram.
2) Calculate following values recursively. ae + bg, af + bh, ce + dg and cf + dh.
In the above method, we do 8 multiplications for matrices of size N/2 x N/2 and 4 additions. Addition of two matrices takes O(N2) time. So the time complexity can be written as T(N) = 8T(N/2) + O(N2) From Master's Theorem, time complexity of above method is O(N3) which is unfortunately same as the above naive method.
Simple Divide and Conquer also leads to O(N3), can there be a better way?
In the above divide and conquer method, the main component for high time complexity is 8 recursive calls.
The idea of Strassen’s method is to reduce the number of recursive calls to 7. Strassen’s method is similar to above simple divide and conquer method in the sense that this method also divide matrices to sub-matrices of size N/2 x N/2 as shown in the above diagram, but in Strassen’s method, the four sub-matrices of result are calculated using following formulae.
Time Complexity of Strassen’s Method Addition and Subtraction of two matrices takes O(N2) time. So time complexity can be written as T(N) = 7T(N/2) + O(N2) From Master's Theorem, time complexity of above method is O(NLog7) which is approximately O(N2.8074) Generally Strassen’s Method is not preferred for practical applications for following reasons.
1) The constants used in Strassen’s method are high and for a typical application Naive method works better.
2) For Sparse matrices, there are better methods especially designed for them.
3) The submatrices in recursion take extra space.
4) Because of the limited precision of computer arithmetic on noninteger values, larger errors accumulate in Strassen’s algorithm than in Naive Method (Source: CLRS Book)

### References

Introduction to Algorithms 3rd Edition by Cliﬀord Stein, Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest
- [Reference Link](https://www.youtube.com/watch?v=LOLebQ8nKHA)
- [Reference Link](https://www.youtube.com/watch?v=QXY4RskLQcI)
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/strassens-matrix-multiplication/)

[↑ Back to Top](#table-of-contents)
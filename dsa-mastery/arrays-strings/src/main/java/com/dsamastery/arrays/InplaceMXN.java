package com.dsamastery.arrays;

import java.util.*;

public class InplaceMXN {

    // Program for in-place matrix transpose
    // A utility function to print a 2D array of size nr x nc and base address A
    void Print2DArray(int *A, int nr, int nc)
    {
    for(int r = 0; r < nr; r++)
    {
    for(int c = 0; c < nc; c++)
    System.out.printf("%4d", *(A + r*nc + c));
    System.out.printf("\n");
    }
    System.out.printf("\n\n");
    }
    // Non-square matrix transpose of matrix of size r x c and base address A
    void MatrixInplaceTranspose(int *A, int r, int c)
    {
    int size = r*c - 1;
    int t; // holds element to be replaced, eventually becomes next element to move
    int next; // location of 't' to be moved
    int cycleBegin; // holds start of cycle
    int i; // iterator
    bitset<HASH_SIZE> b; // hash to mark moved elements
    b.reset();
    b[0] = b[size] = 1;
    i = 1; // Note that A[0] and A[size-1] won't move
    while (i < size)
    {
    cycleBegin = i;
    t = A[i];
    do
    {
    // Input matrix [r x c]
    // Output matrix 1
    // i_new = (i*r)%(N-1)
    next = (i*r)%size;
    swap(A[next], t);
    b[i] = 1;
    i = next;
    }
    while (i != cycleBegin);
    // Get Next Move (what about querying random location?)
    for (i = 1; i < size && b[i]; i++)
    ;
    System.out.print(endl);
    }
    }
    // Driver program to test above function
    int main(void)
    {
    int r = 5, c = 6;
    int size = r*c;
    int *A = new int[size];
    for(int i = 0; i < size; i++)
    A[i] = i+1;
    Print2DArray(A, r, c);
    MatrixInplaceTranspose(A, r, c);
    Print2DArray(A, c, r);
    delete[] A;
    return 0;
    }
    void Print2DArray(char A[], int nr, int nc) {
    int size = nr*nc;
    for(int i = 0; i < size; i++)
    System.out.printf("%4c", *(A + i));
    System.out.printf("\n");
    }
    void MatrixTransposeInplaceArrangement(data_t A[], int r, int c) {
    int size = r*c - 1;
    data_t t; // holds element to be replaced, eventually becomes next element to move
    int next; // location of 't' to be moved
    int cycleBegin; // holds start of cycle
    int i; // iterator
    bitset<HASH_SIZE> b; // hash to mark moved elements
    b.reset();
    b[0] = b[size] = 1;
    i = 1; // Note that A[0] and A[size-1] won't move
    while( i < size ) {
    cycleBegin = i;
    t = A[i];
    do {
    // Input matrix [r x c]
    // Output matrix 1
    // i_new = (i*r)%size
    next = (i*r)%size;
    swap(A[next], t);
    b[i] = 1;
    i = next;
    } while( i != cycleBegin );
    // Get Next Move (what about querying random location?)
    for(i = 1; i < size && b[i]; i++)
    ;
    System.out.print(endl);
    }
    }
    void Fill(data_t buf[], int size) {
    // Fill abcd ...
    for(int i = 0; i < size; i++)
    buf[i] = 'a'+i;
    // Fill 0123 ...
    buf += size;
    for(int i = 0; i < size; i++)
    buf[i] = '0'+i;
    }
    void TestCase_01(void) {
    int r = 2, c = 10;
    int size = r*c;
    data_t *A = new data_t[size];
    Fill(A, c);
    Print2DArray(A, r, c), System.out.print(endl);
    MatrixTransposeInplaceArrangement(A, r, c);
    Print2DArray(A, c, r), System.out.print(endl);
    delete[] A;
    }
    int main() {
    TestCase_01();
    return 0;
    }
}

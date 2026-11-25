package com.dsamastery.arrays;

import java.util.*;

public class PrintMatrixDiagonally {

    // A utility function to find min of two integers
    int min(int a, int b)
    { return (a < b)? a: b; }
    // A utility function to find min of three integers
    int min(int a, int b, int c)
    { return min(min(a, b), c);}
    // A utility function to find max of two integers
    int max(int a, int b)
    { return (a > b)? a: b; }
    // The main function that prints given matrix in diagonal order
    void diagonalOrder(int matrix[][COL])
    {
    // There will be ROW+COL-1 lines in the output
    for (int line=1; line<=(ROW + COL -1); line++)
    {
    /* Get column index of the first element in this line of output.
    The index is 0 for first ROW lines and line - ROW for remaining
    lines */
    int start_col = max(0, line-ROW);
    /* Get count of elements in this line. The count of elements is
    equal to minimum of line number, COL-start_col and ROW */
    int count = min(line, (COL-start_col), ROW);
    /* Print elements of this line */
    for (int j=0; j<count; j++)
    System.out.printf("%5d ", matrix[min(ROW, line)-j-1][start_col+j]);
    /* Ptint elements of next diagonal on next line */
    System.out.printf("\n");
    }
    }
    // Utility function to print a matrix
    void printMatrix(int matrix[ROW][COL])
    {
    for (int i=0; i< ROW; i++)
    {
    for (int j=0; j<COL; j++)
    System.out.printf("%5d ", matrix[i][j]);
    System.out.printf("\n");
    }
    }
    // Driver program to test above functions
    int main()
    {
    int M[ROW][COL] = {{1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16},
    {17, 18, 19, 20},
    };
    System.out.printf("Given matrix is \n");
    printMatrix(M);
    System.out.printf("\nDiagonal printing of matrix is \n");
    diagonalOrder(M);
    return 0;
    }
    boolean isvalid(int i, int j)
    {
    if (i < 0 || i >= R || j >= C || j < 0) return false;
    return true;
    }
    void diagonalOrder(int arr[][C])
    {
    /* through this for loop we choose each element of first column
    as starting point and print diagonal starting at it.
    arr[0][0], arr[1][0]....arr[R-1][0] are all starting points */
    for (int k = 0; k < R; k++)
    {
    System.out.print(arr[k][0] << " ");
    int i = k-1; // set row index for next point in diagonal
    int j = 1; // set column index for next point in diagonal
    /* Print Diagonally upward */
    while (isvalid(i,j))
    {
    System.out.print(arr[i][j] << " ");
    i--;
    j++; // move in upright direction
    }
    System.out.print(endl);
    }
    /* through this for loop we choose each element of last row
    as starting point (except the [0][c-1] it has already been
    processed in previous for loop) and print diagonal starting at it.
    arr[R-1][0], arr[R-1][1]....arr[R-1][c-1] are all starting points */
    //Note : we start from k = 1 to C-1;
    for (int k = 1; k < C; k++)
    {
    System.out.print(arr[R-1][k] << " ");
    int i = R-2; // set row index for next point in diagonal
    int j = k+1; // set column index for next point in diagonal
    /* Print Diagonally upward */
    while (isvalid(i,j))
    {
    System.out.print(arr[i][j] << " ");
    i--;
    j++; // move in upright direction
    }
    System.out.print(endl);
    }
    }
    // Driver program to test above
    int main()
    {
    int arr[][C] = {{1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16},
    {17, 18, 19, 20},
    };
    diagonalOrder(arr);
    return 0;
    }
}

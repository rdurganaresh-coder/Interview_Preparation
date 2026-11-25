package com.dsamastery.arrays;

import java.util.*;

public class ABooleanMatrixQuestion {

    Method 1 (Use two temporary arrays)
    void modifyMatrix(boolean mat[R][C])
    {
    boolean row[R];
    boolean col[C];
    int i, j;
    /* Initialize all values of row[] as 0 */
    for (i = 0; i < R; i++)
    {
    row[i] = 0;
    }
    /* Initialize all values of col[] as 0 */
    for (i = 0; i < C; i++)
    {
    col[i] = 0;
    }
    /* Store the rows and columns to be marked as 1 in row[] and col[]
    arrays respectively */
    for (i = 0; i < R; i++)
    {
    for (j = 0; j < C; j++)
    {
    if (mat[i][j] == 1)
    {
    row[i] = 1;
    col[j] = 1;
    }
    }
    }
    /* Modify the input matrix mat[] using the above constructed row[] and
    col[] arrays */
    for (i = 0; i < R; i++)
    {
    for (j = 0; j < C; j++)
    {
    if ( row[i] == 1 || col[j] == 1 )
    {
    mat[i][j] = 1;
    }
    }
    }
    }
    /* A utility function to print a 2D matrix */
    void printMatrix(boolean mat[R][C])
    {
    int i, j;
    for (i = 0; i < R; i++)
    {
    for (j = 0; j < C; j++)
    {
    System.out.printf("%d ", mat[i][j]);
    }
    System.out.printf("\n");
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    boolean mat[R][C] = { {1, 0, 0, 1},
    {0, 0, 1, 0},
    {0, 0, 0, 0},
    };
    System.out.printf("Input Matrix \n");
    printMatrix(mat);
    modifyMatrix(mat);
    System.out.printf("Matrix after modification \n");
    printMatrix(mat);
    return 0;
    }
    Method 2 (A Space Optimized Version of Method 1)
}

# A. Rook

*Rating: 800 | Tags: implementation | [https://codeforces.com/problemset/problem/1907/A](https://codeforces.com/problemset/problem/1907/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

As you probably know, chess is a game that is played on a board with 64 squares arranged in an $8\times 8$ grid. Columns of this board are labeled with letters from a to h, and rows are labeled with digits from 1 to 8. Each square is described by the row and column it belongs to.

 ![](https://espresso.codeforces.com/47121ab1618eef1f0d41aa54223134101ea3d337.png) 

The rook is a piece in the game of chess. During its turn, it may move any non-zero number of squares horizontally or vertically. Your task is to find all possible moves for a rook on an empty chessboard.

### Input

The first line of input contains single integer $t$ ($1 \le t \le 64$) — the number of test cases. The descriptions of test cases follow.

Each test case contains one string of two characters, description of the square where rook is positioned. The first character is a letter from a to h, the label of column, and the second character is a digit from 1 to 8, the label of row.

The same position may occur in more than one test case.

### Output

For each test case, output descriptions of all squares where the rook can move, in the same format as in the input.

You can output squares in any order per test case.

### Example

Input

```
1
d5
```

Output

```
d1
d2
b5
g5
h5
d3
e5
f5
d8
a5
d6
d7
c5
d4
```

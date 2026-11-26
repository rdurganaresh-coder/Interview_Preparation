# A. Mahmoud and Longest Uncommon Subsequence

*Rating: 1000 | Tags: constructive algorithms, strings | [https://codeforces.com/problemset/problem/766/A](https://codeforces.com/problemset/problem/766/A)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

standard input

output

standard output

While Mahmoud and Ehab were practicing for IOI, they found a problem which name was Longest common subsequence. They solved it, and then Ehab challenged Mahmoud with another problem.

Given two strings *a* and *b*, find the length of their longest uncommon subsequence, which is the longest string that is a subsequence of one of them and not a subsequence of the other.

A subsequence of some string is a sequence of characters that appears in the same order in the string, The appearances don't have to be consecutive, for example, strings "ac", "bc", "abc" and "a" are subsequences of string "abc" while strings "abbc" and "acb" are not. The empty string is a subsequence of any string. Any string is a subsequence of itself.

### Input

The first line contains string *a*, and the second line — string *b*. Both of these strings are non-empty and consist of lowercase letters of English alphabet. The length of each string is not bigger than 105 characters.

### Output

If there's no uncommon subsequence, print "-1". Otherwise print the length of the longest uncommon subsequence of *a* and *b*.

### Examples

Input

```
abcddefgh
```

Output

```
5
```

Input

```
aa
```

Output

```
-1
```

### Note

In the first example: you can choose "defgh" from string *b* as it is the longest subsequence of string *b* that doesn't appear as a subsequence of string *a*.

# C. Hamburgers

*Rating: 1600 | Tags: binary search, brute force | [https://codeforces.com/problemset/problem/371/C](https://codeforces.com/problemset/problem/371/C)*


time limit per test

1 second

memory limit per test

256 megabytes

input

stdin

output

stdout

Polycarpus loves hamburgers very much. He especially adores the hamburgers he makes with his own hands. Polycarpus thinks that there are only three decent ingredients to make hamburgers from: a bread, sausage and cheese. He writes down the recipe of his favorite "Le Hamburger de Polycarpus" as a string of letters 'B' (bread), 'S' (sausage) и 'C' (cheese). The ingredients in the recipe go from bottom to top, for example, recipe "ВSCBS" represents the hamburger where the ingredients go from bottom to top as bread, sausage, cheese, bread and sausage again.

Polycarpus has *n**b* pieces of bread, *n**s* pieces of sausage and *n**c* pieces of cheese in the kitchen. Besides, the shop nearby has all three ingredients, the prices are *p**b* rubles for a piece of bread, *p**s* for a piece of sausage and *p**c* for a piece of cheese.

Polycarpus has *r* rubles and he is ready to shop on them. What maximum number of hamburgers can he cook? You can assume that Polycarpus cannot break or slice any of the pieces of bread, sausage or cheese. Besides, the shop has an unlimited number of pieces of each ingredient.

### Input

The first line of the input contains a non-empty string that describes the recipe of "Le Hamburger de Polycarpus". The length of the string doesn't exceed 100, the string contains only letters 'B' (uppercase English B), 'S' (uppercase English S) and 'C' (uppercase English C).

The second line contains three integers *n**b*, *n**s*, *n**c* (1 ≤ *n**b*, *n**s*, *n**c* ≤ 100) — the number of the pieces of bread, sausage and cheese on Polycarpus' kitchen. The third line contains three integers *p**b*, *p**s*, *p**c* (1 ≤ *p**b*, *p**s*, *p**c* ≤ 100) — the price of one piece of bread, sausage and cheese in the shop. Finally, the fourth line contains integer *r* (1 ≤ *r* ≤ 1012) — the number of rubles Polycarpus has.

Please, do not write the %lld specifier to read or write 64-bit integers in С++. It is preferred to use the cin, cout streams or the %I64d specifier.

### Output

Print the maximum number of hamburgers Polycarpus can make. If he can't make any hamburger, print 0.

### Examples

Input

```
BBBSSC6 4 11 2 34
```

Output

```
2
```

Input

```
BBC1 10 11 10 121
```

Output

```
7
```

Input

```
BSC1 1 11 1 31000000000000
```

Output

```
200000000001
```

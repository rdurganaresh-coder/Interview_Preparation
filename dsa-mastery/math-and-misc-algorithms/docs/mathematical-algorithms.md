# Mathematical Algorithms

> **Original PDF:** [Mathematical Algorithms.pdf](../../docs/Mathematical Algorithms.pdf)

## Table of Contents

- [Chapter 1: Write an Eﬃcient Method to Check if](#chapter-1-write-an-eﬃcient-method-to-check-if)
- [Chapter 2: Eﬃcient way to multiply with 7](#chapter-2-eﬃcient-way-to-multiply-with-7)
- [Chapter 3: Write a C program to print all](#chapter-3-write-a-c-program-to-print-all)
- [Chapter 4: Lucky Numbers](#chapter-4-lucky-numbers)
- [Chapter 5: Write a program to add two numbers](#chapter-5-write-a-program-to-add-two-numbers)
- [Chapter 6: Babylonian method for square root](#chapter-6-babylonian-method-for-square-root)
- [Chapter 7: Multiply two integers without using](#chapter-7-multiply-two-integers-without-using)
- [Chapter 8: Print all combinations of points that](#chapter-8-print-all-combinations-of-points-that)
- [Chapter 9: Write you own Power without using](#chapter-9-write-you-own-power-without-using)
- [Chapter 10: Program for Fibonacci numbers](#chapter-10-program-for-fibonacci-numbers)
- [Chapter 11: Average of a stream of numbers](#chapter-11-average-of-a-stream-of-numbers)
- [Chapter 12: Count numbers that don’t contain 3](#chapter-12-count-numbers-that-dont-contain-3)
- [Chapter 13: Magic Square](#chapter-13-magic-square)
- [Chapter 14: Sieve of Eratosthenes](#chapter-14-sieve-of-eratosthenes)
- [Chapter 15: Find day of the week for a given date](#chapter-15-find-day-of-the-week-for-a-given-date)
- [Chapter 16: DFA based division](#chapter-16-dfa-based-division)
- [Chapter 17: Generate integer from 1 to 7 with](#chapter-17-generate-integer-from-1-to-7-with)
- [Chapter 18: Given a number, ﬁnd the next](#chapter-18-given-a-number-ﬁnd-the-next)
- [Chapter 19: Make a fair coin from a biased coin](#chapter-19-make-a-fair-coin-from-a-biased-coin)
- [Chapter 20: Check divisibility by 7](#chapter-20-check-divisibility-by-7)
- [Chapter 21: Find the largest multiple of 3](#chapter-21-find-the-largest-multiple-of-3)
- [Chapter 22: Lexicographic rank of a string](#chapter-22-lexicographic-rank-of-a-string)
- [Chapter 23: Print all permutations in sorted](#chapter-23-print-all-permutations-in-sorted)
- [Chapter 24: Shuﬄe a given array](#chapter-24-shuﬄe-a-given-array)
- [Chapter 25: Space and time eﬃcient Binomial](#chapter-25-space-and-time-eﬃcient-binomial)
- [Chapter 26: Reservoir Sampling](#chapter-26-reservoir-sampling)
- [Chapter 27: Pascal’s Triangle](#chapter-27-pascals-triangle)
- [Chapter 28: Select a random number from stream,](#chapter-28-select-a-random-number-from-stream)
- [Chapter 29: Find the largest multiple of 2, 3 and 5](#chapter-29-find-the-largest-multiple-of-2-3-and-5)
- [Chapter 30: Eﬃcient program to calculate eˆx](#chapter-30-eﬃcient-program-to-calculate-eˆx)
- [Chapter 31: Measure one litre using two vessels](#chapter-31-measure-one-litre-using-two-vessels)
- [Chapter 32: Eﬃcient program to print all prime](#chapter-32-eﬃcient-program-to-print-all-prime)
- [Chapter 33: Print all possible combinations of r](#chapter-33-print-all-possible-combinations-of-r)
- [Chapter 34: Random number generator in](#chapter-34-random-number-generator-in)
- [Chapter 35: How to check if a given number is](#chapter-35-how-to-check-if-a-given-number-is)
- [Chapter 36: Russian Peasant Multiplication](#chapter-36-russian-peasant-multiplication)
- [Chapter 37: Count all possible groups of size 2 or](#chapter-37-count-all-possible-groups-of-size-2-or)
- [Chapter 38: Horner’s Method for Polynomial](#chapter-38-horners-method-for-polynomial)
- [Chapter 39: Count trailing zeroes in factorial of a](#chapter-39-count-trailing-zeroes-in-factorial-of-a)
- [Chapter 40: Program for nth Catalan Number](#chapter-40-program-for-nth-catalan-number)
- [Chapter 41: Write a function that generates one of](#chapter-41-write-a-function-that-generates-one-of)
- [Chapter 42: Find Excel column name from a given](#chapter-42-find-excel-column-name-from-a-given)
- [Chapter 43: Find next greater number with same](#chapter-43-find-next-greater-number-with-same)
- [Chapter 44: Count Possible Decodings of a given](#chapter-44-count-possible-decodings-of-a-given)
- [Chapter 45: Calculate the angle between hour](#chapter-45-calculate-the-angle-between-hour)
- [Chapter 46: Count number of binary strings](#chapter-46-count-number-of-binary-strings)
- [Chapter 47: Find the smallest number whose](#chapter-47-find-the-smallest-number-whose)
- [Chapter 48: How to check if an instance of 8](#chapter-48-how-to-check-if-an-instance-of-8)
- [Chapter 49: Birthday Paradox](#chapter-49-birthday-paradox)
- [Chapter 50: Multiply two polynomials](#chapter-50-multiply-two-polynomials)
- [Chapter 51: Count Distinct Non-Negative Integer](#chapter-51-count-distinct-non-negative-integer)
- [Chapter 52: Count ways to reach the n’th stair](#chapter-52-count-ways-to-reach-the-nth-stair)

---

## Chapter 1: Write an Eﬃcient Method to Check if

> **Java Implementation:** [`WriteAnECient3.java`](../src/main/java/com/dsamastery/misc/WriteAnECient3.java) (`math-and-misc-algorithms`)

a Number is Multiple of 3 The very ﬁrst solution that comes to our mind is the one that we learned in school. If sum of digits in a number is multiple of 3 then number is multiple of 3 e.g., for 612 sum of digits is 9 so it’s a multiple of 3.
But this solution is not eﬃcient. You have to get all decimal digits one by one, add them and then check if sum is multiple of 3.
There is a pattern in binary representation of the number that can be used to ﬁnd if number is a multiple of 3. If diﬀerence between count of odd set bits (Bits set at odd positions) and even set bits is multiple of 3 then is the number.
Example: 23 (00..10111) 1) Get count of all set bits at odd positions (For 23 it’s 3). 2) Get count of all set bits at even positions (For 23 it’s 1). 3) If diﬀerence of above two counts is a multiple of 3 then number is also a multiple of 3.
(For 23 it’s 2 so 23 is not a multiple of 3) Take some more examples like 21, 15, etc… Algorithm: isMutlipleOf3(n) 1) Make n positive if n is negative.
2) If number is 0 then return 1 3) If number is 1 then return 0 4) Initialize: odd_count = 0, even_count = 0 5) Loop while n != 0 a) If rightmost bit is set then increment odd count.
b) Right-shift n by 1 bit c) If rightmost bit is set then increment even count.
d) Right-shift n by 1 bit 6) return isMutlipleOf3(odd_count - even_count) Proof: Above can be proved by taking the example of 11 in decimal numbers. (In this context 11 in decimal numbers is same as 3 in binary numbers) If diﬀerence between sum of odd digits and even digits is multiple of 11 then decimal number is multiple of 11. Let’s see how.
Let’s take the example of 2 digit numbers in decimal AB = 11A -A + B = 11A + (B – A) So if (B – A) is a multiple of 11 then is AB.
Let us take 3 digit numbers.
ABC = 99A + A + 11B – B + C = (99A + 11B) + (A + C – B) So if (A + C – B) is a multiple of 11 then

```java
is (A+C-B)
```

Let us take 4 digit numbers now. ABCD = 1001A + D + 11C – C + 999B + B – A = (1001A – 999B + 11C) + (D + B – A -C ) So, if (B + D – A – C) is a multiple of 11 then is ABCD.
This can be continued for all decimal numbers. Above concept can be proved for 3 in binary numbers in the same way. Time Complexity: O(logn) Program:

```java
#include<stdio.h>
/* Fnction to check if n is a multiple of 3*/
int isMultipleOf3(int n)
{
int odd_count = 0;
int even_count = 0;
/* Make no positive if +n is multiple of 3
then is -n. We are doing this to avoid
stack overflow in recursion*/
if(n < 0) n = -n;
if(n == 0) return 1;
if(n == 1) return 0;
while(n)
{
/* If odd bit is set then
increment odd counter */
if(n & 1)
odd_count++;
n = n>>1;
/* If even bit is set then
increment even counter */
if(n & 1)
even_count++;
n = n>>1;
}
return isMultipleOf3(abs(odd_count - even_count));
}
/* Program to test function isMultipleOf3 */
int main()
{
int num = 23;
if (isMultipleOf3(num))
printf("num is multiple of 3");
else
printf("num is not a multiple of 3");
getchar();
return 0;
}
```

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 2: Eﬃcient way to multiply with 7

> **Java Implementation:** [`ECientWayTo2.java`](../src/main/java/com/dsamastery/misc/ECientWayTo2.java) (`math-and-misc-algorithms`)

We can multiply a number by 7 using bitwise operator. First left shift the number by 3 bits (you will get 8n) then subtract the original numberfrom the shifted number and return the diﬀerence (8n – n). Program:
# include<stdio.h>

```java
int multiplyBySeven(unsigned int n)
{
/* Note the inner bracket here. This is needed
because precedence of '-' operator is higher
than '<<' */
return ((n<<3) - n);
}
/* Driver program to test above function */
int main()
{
unsigned int n = 4;
printf("%u", multiplyBySeven(n));
getchar();
return 0;
}
```

Time Complexity: O(1) Space Complexity: O(1) Note: Works only for positive integers. Same concept can be used for fast multiplication by 9 or other numbers.

### Source

- [Reference Link](http://www.geeksforgeeks.org/efficient-way-to-multiply-with-7/)
Category: Bit Magic Tags: Bit Magic, MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 3: Write a C program to print all

> **Java Implementation:** [`WriteACProgram2.java`](../src/main/java/com/dsamastery/misc/WriteACProgram2.java) (`math-and-misc-algorithms`)

permutations of a given string A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation. Source:

```java
Mathword(http://mathworld.wolfram.com/Permutation.html)
```

Below are the permutations of string ABC. ABC, ACB, BAC, BCA, CAB, CBA Here is a solution using backtracking.

```java
// C program to print all permutations with duplicates allowed
#include <stdio.h>
#include <string.h>
/* Function to swap values at two pointers */
void swap(char *x, char *y)
{
char temp;
temp = *x;
*x = *y;
*y = temp;
}
/* Function to print permutations of string
This function takes three parameters:
1. String
2. Starting index of the string
3. Ending index of the string. */
void permute(char *a, int l, int r)
{
int i;
if (l == r)
printf("%s\n", a);
else
{
for (i = l; i <= r; i++)
{
swap((a+l), (a+i));
permute(a, l+1, r);
swap((a+l), (a+i)); //backtrack
}
}
}
/* Driver program to test above functions */
int main()
{
char str[] = "ABC";
int n = strlen(str);
permute(str, 0, n-1);
return 0;
}
```

### Output

ABC ACB BAC BCA CBA CAB Algorithm Paradigm: Backtracking Time Complexity: O(n*n!) Please write comments if you ﬁnd the above codes/algorithms incorrect, or ﬁnd other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/)
Category: Strings Tags: Backtracking, MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 4: Lucky Numbers

> **Java Implementation:** [`LuckyNumbers.java`](../src/main/java/com/dsamastery/misc/LuckyNumbers.java) (`math-and-misc-algorithms`)

Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers, Take the set of integers 1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,…… First, delete every second number, we get following reduced set. 1,3,5,7,9,11,13,15,17,19,………… Now, delete every third number, we get 1, 3, 7, 9, 13, 15, 19,….….
Continue this process indeﬁnitely…… Any number that does NOT get deleted due to above process is called “lucky”.
Therefore, set of lucky numbers is 1, 3, 7, 13,……… Now, given an integer ‘n’, write a function to say whether this number is lucky or not.

```java
bool isLucky(int n)
```

Algorithm: Before every iteration, if we calculate position of the given no, then in a given iteration, we can determine if the no will be deleted. Suppose calculated position for the given no. is P before some iteration, and each Ith no. is going to be removed in this iteration, if P Recursive Way:

```java
#include <stdio.h>
#define bool int
/* Returns 1 if n is a lucky no. ohterwise returns 0*/
bool isLucky(int n)
{
static int counter = 2;
/*variable next_position is just for readability of
the program we can remove it and use n only */
int next_position = n;
if(counter > n)
return 1;
if(n%counter == 0)
return 0;
/*calculate next position of input no*/
next_position -= next_position/counter;
counter++;
return isLucky(next_position);
}
/*Driver function to test above function*/
int main()
{
int x = 5;
if( isLucky(x) )
printf("%d is a lucky no.", x);
else
printf("%d is not a lucky no.", x);
getchar();
}
```

Example: Let’s us take an example of 19 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,17,18,19,20,21,…… 1,3,5,7,9,11,13,15,17,19,….. 1,3,7,9,13,15,19,……….
1,3,7,13,15,19,……… 1,3,7,13,19,……… In next step every 6th no .in sequence will be deleted. 19 will not be deleted after this step because position of 19 is 5th after this step. Therefore, 19 is lucky. Let’s see how above C code ﬁnds out:
Current function call Position after this call Counter for next call Next Call isLucky(19 ) 10 3 isLucky(10) isLucky(10) 7 4 isLucky(7) isLucky(7) 6 5 isLucky(6) isLucky(6) 5 6 isLucky(5) When isLucky(6) is called, it returns 1 (because counter > n).
Iterative Way: Please see this comment for another simple and elegant implementation of the above algorithm.
Please write comments if you ﬁnd any bug in the given programs or other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/lucky-numbers/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 5: Write a program to add two numbers

> **Java Implementation:** [`WriteAProgramTo.java`](../src/main/java/com/dsamastery/misc/WriteAProgramTo.java) (`math-and-misc-algorithms`)

in base 14 Asked by Anshya.
Below are the diﬀerent ways to add base 14 numbers.
Method 1 Thanks to Raj for suggesting this method.
1. Convert both i/p base 14 numbers to base 10.
2. Add numbers.
3. Convert the result back to base 14.
Method 2 Just add the numbers in base 14 in same way we add in base 10. Add numerals of both numbers one by one from right to left. If there is a carry while adding two numerals, consider the carry for adding next numerals.
Let us consider the presentation of base 14 numbers same as hexadecimal numbers A --> 10 B --> 11 C --> 12 D --> 13

### Example

num1 = 1 2 A num2 = C D 3 1. Add A and 3, we get 13(D). Since 13 is smaller than 14, carry becomes 0 and resultant numeral becomes D 2. Add 2, D and carry(0). we get 15. Since 15 is greater than 13, carry becomes 1 and resultant numeral is 15 - 14 = 1 3. Add 1, C and carry(1). we get 14. Since 14 is greater than 13, carry becomes 1 and resultant numeral is 14 - 14 = 0 Finally, there is a carry, so 1 is added as leftmost numeral and the result becomes 101D Implementation of Method 2
# include <stdio.h>
# include <stdlib.h>
# define bool int

```java
int getNumeralValue(char );
char getNumeral(int );
/* Function to add two numbers in base 14 */
char *sumBase14(char *num1, char *num2)
{
int l1 = strlen(num1);
int l2 = strlen(num2);
char *res;
int i;
int nml1, nml2, res_nml;
bool carry = 0;
if(l1 != l2)
{
printf("Function doesn't support numbers of different"
" lengths. If you want to add such numbers then"
" prefix smaller number with required no. of zeroes");
getchar();
assert(0);
}
/* Note the size of the allocated memory is one
more than i/p lenghts for the cases where we
have carry at the last like adding D1 and A1 */
res = (char *)malloc(sizeof(char)*(l1 + 1));
/* Add all numerals from right to left */
for(i = l1-1; i >= 0; i--)
{
/* Get decimal values of the numerals of
i/p numbers*/
nml1 = getNumeralValue(num1[i]);
nml2 = getNumeralValue(num2[i]);
/* Add decimal values of numerals and carry */
res_nml = carry + nml1 + nml2;
/* Check if we have carry for next addition
of numerals */
if(res_nml >= 14)
{
carry = 1;
res_nml -= 14;
}
else
{
carry = 0;
}
res[i+1] = getNumeral(res_nml);
}
/* if there is no carry after last iteration
then result should not include 0th character
of the resultant string */
if(carry == 0)
return (res + 1);
/* if we have carry after last iteration then
result should include 0th character */
res[0] = '1';
return res;
}
/* Function to get value of a numeral
For example it returns 10 for input 'A'
1 for '1', etc */
int getNumeralValue(char num)
{
if( num >= '0' && num <= '9')
return (num - '0');
if( num >= 'A' && num <= 'D')
return (num - 'A' + 10);
/* If we reach this line caller is giving
invalid character so we assert and fail*/
assert(0);
}
/* Function to get numeral for a value.
For example it returns 'A' for input 10
'1' for 1, etc */
char getNumeral(int val)
{
if( val >= 0 && val <= 9)
return (val + '0');
if( val >= 10 && val <= 14)
return (val + 'A' - 10);
/* If we reach this line caller is giving
invalid no. so we assert and fail*/
assert(0);
}
/*Driver program to test above functions*/
int main()
{
char *num1 = "DC2";
char *num2 = "0A3";
printf("Result is %s", sumBase14(num1, num2));
getchar();
return 0;
}
```

Notes: Above approach can be used to add numbers in any base. We don’t have to do string operations if base is smaller than 10.
You can try extending the above program for numbers of diﬀerent lengths.
Please comment if you ﬁnd any bug in the program or a better approach to do the same.

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-a-program-to-add-two-numbers-in-base-14/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 6: Babylonian method for square root

> **Java Implementation:** [`BabylonianMethodForSquare.java`](../src/main/java/com/dsamastery/misc/BabylonianMethodForSquare.java) (`math-and-misc-algorithms`)

Algorithm: This method can be derived from (but predates) Newton–Raphson method.
1 Start with an arbitrary positive start value x (the closer to the root, the better).
2 Initialize y = 1.
3. Do following until desired approximation is achieved.
a) Get the next approximation for root using average of x and y b) Set y = n/x Implementation:

```java
/*Returns the square root of n. Note that the function */
float squareRoot(float n)
{
/*We are using n itself as initial approximation
This can definitely be improved */
float x = n;
float y = 1;
float e = 0.000001; /* e decides the accuracy level*/
while(x - y > e)
{
x = (x + y)/2;
y = n/x;
}
return x;
}
/* Driver program to test above function*/
int main()
{
int n = 50;
printf ("Square root of %d is %f", n, squareRoot(n));
getchar();
}
```

### Example

```java
n = 4 /*n itself is used for initial approximation*/
```

Initialize x = 4, y = 1 Next Approximation x = (x + y)/2 (= 2.500000), y = n/x (=1.600000) Next Approximation x = 2.050000, y = 1.951220 Next Approximation x = 2.000610, y = 1.999390 Next Approximation x = 2.000000, y = 2.000000 Terminate as (x - y) > e now.
If we are sure that n is a perfect square, then we can use following method. The method can go in inﬁnite loop for non-perfect-square numbers. For example, for 3 the below while loop will never terminate.

```java
/*Returns the square root of n. Note that the function
will not work for numbers which are not perfect squares*/
unsigned int squareRoot(int n)
{
int x = n;
int y = 1;
while(x > y)
{
x = (x + y)/2;
y = n/x;
}
return x;
}
/* Driver program to test above function*/
int main()
{
int n = 49;
printf (" root of %d is %d", n, squareRoot(n));
getchar();
}
```

References; http://en.wikipedia.org/wiki/Square_root http://en.wikipedia.org/wiki/Babylonian_ method#Babylonian_method Asked by Snehal Please write comments if you ﬁnd any bug in the above program/algorithm, or if you want to share more information about Babylonian method.

### Source

- [Reference Link](http://www.geeksforgeeks.org/square-root-of-a-perfect-square/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 7: Multiply two integers without using

> **Java Implementation:** [`MultiplyTwoIntegersWithout.java`](../src/main/java/com/dsamastery/misc/MultiplyTwoIntegersWithout.java) (`math-and-misc-algorithms`)

multiplication, division and bitwise operators, and no loops Asked by Kapil By making use of recursion, we can multiply two integers with the given constraints.
To multiply x and y, recursively add x y times.
Thanks to geek4ufor suggesting this method.

```java
#include<stdio.h>
/* function to multiply two numbers x and y*/
int multiply(int x, int y)
{
/* 0 multiplied with anything gives 0 */
if(y == 0)
return 0;
/* Add x one by one */
if(y > 0 )
return (x + multiply(x, y-1));
/* the case where y is negative */
if(y < 0 )
return -multiply(x, -y);
}
int main()
{
printf("\n %d", multiply(5, -11));
getchar();
return 0;
}
```

Time Complexity: O(y) where y is the second argument to function multiply().
Please write comments if you ﬁnd any of the above code/algorithm incorrect, or ﬁnd better ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/multiply-two-numbers-without-using-multiply-division-bitwise-operators-and-no-loops/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 8: Print all combinations of points that

> **Java Implementation:** [`PrintAllCombinationsOf.java`](../src/main/java/com/dsamastery/misc/PrintAllCombinationsOf.java) (`math-and-misc-algorithms`)

can compose a given number You can win three kinds of basketball points, 1 point, 2 points, and 3 points. Given a total score n, print out all the combination to compose n.
Examples: For n = 1, the program should print following: 1 For n = 2, the program should print following: 1 1 2 For n = 3, the program should print following: 1 1 1 1 2 2 1 3 For n = 4, the program should print following: 1 1 1 1 1 1 2 1 2 1 1 3 2 1 1 2 2 3 1 and so on … Algorithm: At ﬁrst position we can have three numbers 1 or 2 or 3. First put 1 at ﬁrst position and recursively call for n-1. Then put 2 at ﬁrst position and recursively call for n-2. Then put 3 at ﬁrst position and recursively call for n-3. If n becomes 0 then we have formed a combination that compose n, so print the current combination.
Below is a generalized implementation. In the below implementation, we can change MAX_POINT if there are higher points (more than 3) in the basketball game.

```java
#define MAX_POINT 3
#define ARR_SIZE 100
#include<stdio.h>
/* Utility function to print array arr[] */
void printArray(int arr[], int arr_size);
/* The function prints all combinations of numbers 1, 2, ...MAX_POINT
that sum up to n.
i is used in recursion keep track of index in arr[] where next
element is to be added. Initital value of i must be passed as 0 */
void printCompositions(int n, int i)
{
/* array must be static as we want to keep track
of values stored in arr[] using current calls of
printCompositions() in function call stack*/
static int arr[ARR_SIZE];
if (n == 0)
{
printArray(arr, i);
}
else if(n > 0)
{
int k;
for (k = 1; k <= MAX_POINT; k++)
{
arr[i]= k;
printCompositions(n-k, i+1);
}
}
}
/* UTILITY FUNCTIONS */
/* Utility function to print array arr[] */
void printArray(int arr[], int arr_size)
{
int i;
for (i = 0; i < arr_size; i++)
printf("%d ", arr[i]);
printf("\n");
}
/* Driver function to test above functions */
int main()
{
int n = 5;
printf("Differnt compositions formed by 1, 2 and 3 of %d are\n", n);
printCompositions(n, 0);
getchar();
return 0;
}
```

Asked by Aloe Please write comments if you ﬁnd any bug in above code/algorithm, or ﬁnd other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/print-all-combinations-of-points-that-can-compose-a-given-number/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 9: Write you own Power without using

> **Java Implementation:** [`WriteYouOwnPower.java`](../src/main/java/com/dsamastery/misc/WriteYouOwnPower.java) (`math-and-misc-algorithms`)

multiplication(*) and division(/) operators

```java
Method 1 (Using Nested Loops)
```

We can calculate power by using repeated addition.
For example to calculate 5ˆ6. 1) First 5 times add 5, we get 25. (5ˆ2) 2) Then 5 times add 25, we get 125.
(5ˆ3) 3) Then 5 time add 125, we get 625 (5ˆ4) 4) Then 5 times add 625, we get 3125 (5ˆ5) 5) Then 5 times add 3125, we get 15625 (5ˆ6)

```java
/* Works only if a >= 0 and b >= 0 */
int pow(int a, int b)
{
if (b == 0)
return 1;
int answer = a;
int increment = a;
int i, j;
for(i = 1; i < b; i++)
{
for(j = 1; j < a; j++)
{
answer += increment;
}
increment = answer;
}
return answer;
}
/* driver program to test above function */
int main()
{
printf("\n %d", pow(5, 3));
getchar();
return 0;
}
```

Method 2 (Using Recursion) Recursively add a to get the multiplication of two numbers. And recursively multiply to get a raise to the power b.

```java
#include<stdio.h>
/* A recursive function to get a^b
Works only if a >= 0 and b >= 0 */
int pow(int a, int b)
{
if(b)
return multiply(a, pow(a, b-1));
else
return 1;
}
/* A recursive function to get x*y */
int multiply(int x, int y)
{
if(y)
return (x + multiply(x, y-1));
else
return 0;
}
/* driver program to test above functions */
int main()
{
printf("\n %d", pow(5, 3));
getchar();
return 0;
}
```

Please write comments if you ﬁnd any bug in above code/algorithm, or ﬁnd other ways to solve the same problem.

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 10: Program for Fibonacci numbers

> **Java Implementation:** [`ProgramForFibonacciNumbers.java`](../src/main/java/com/dsamastery/misc/ProgramForFibonacciNumbers.java) (`math-and-misc-algorithms`)

The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 141, ……..
In mathematical terms, the sequence Fn of Fibonacci numbers is deﬁned by the recurrence relation Fn = Fn-1 + Fn-2 with seed values F0 = 0 and F1 = 1.
Write a function int ﬁb(int n) that returns Fn. For example, if n = 0, then ﬁb() should return 0. If n = 1, then it should return 1. For n > 1, it should return Fn-1 + Fn-2 Following are diﬀerent methods to get the nth Fibonacci number.
Method 1 ( Use recursion ) A simple method that is a direct recusrive implementation mathematical recurance relation given above.

```java
#include<stdio.h>
int fib(int n)
{
if (n <= 1)
return n;
return fib(n-1) + fib(n-2);
}
int main ()
{
int n = 9;
printf("%d", fib(n));
getchar();
return 0;
}
```

Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential. We can observe that this implementation does a lot of repeated work (see the following recursion tree). So this is a bad implementation for nth Fibonacci number.

```java
fib(5)
/ \
```

fib(4) fib(3)

```java
/ \ / \
```

fib(3) fib(2) fib(2) fib(1)

```java
/ \ / \ / \
```

fib(2) fib(1) fib(1) fib(0) fib(1) fib(0)

```java
/ \
```

fib(1) fib(0) Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
Method 2 ( Use Dynamic Programming ) We can avoid the repeated work done is the method 1 by storing the Fibonacci numbers calculated so far.

```java
#include<stdio.h>
int fib(int n)
{
/* Declare an array to store Fibonacci numbers. */
int f[n+1];
int i;
/* 0th and 1st number of the series are 0 and 1*/
f[0] = 0;
f[1] = 1;
for (i = 2; i <= n; i++)
{
/* Add the previous 2 numbers in the series
and store it */
f[i] = f[i-1] + f[i-2];
}
return f[n];
}
int main ()
{
int n = 9;
printf("%d", fib(n));
getchar();
return 0;
}
```

Time Complexity: O(n) Extra Space: O(n) Method 3 ( Space Otimized Method 2 ) We can optimize the space used in method 2 by storing the previous two numbers only because that is all we need to get the next Fibannaci number in series.

```java
#include<stdio.h>
int fib(int n)
{
int a = 0, b = 1, c, i;
if( n == 0)
return a;
for (i = 2; i <= n; i++)
{
c = a + b;
a = b;
b = c;
}
return b;
}
int main ()
{
int n = 9;
printf("%d", fib(n));
getchar();
return 0;
}
```

Time Complexity: O(n) Extra Space: O(1) Method 4 ( Using power of the matrix {{1,1},{1,0}} ) This another O(n) which relies on the fact that if we n times multiply the matrix M = {{1,1},{1,0}} to itself (in other words calculate power(M, n )), then we get the (n+1)th Fibonacci number as the element at row and column (0, 0) in the resultant matrix.
ThematrixrepresentationgivesthefollowingclosedexpressionfortheFibonaccinumbers:

```java
#include <stdio.h>
/* Helper function that multiplies 2 matricies F and M of size 2*2, and
puts the multiplication result back to F[][] */
void multiply(int F[2][2], int M[2][2]);
/* Helper function that calculates F[][] raise to the power n and puts the
result in F[][]
Note that this function is desinged only for fib() and won't work as general
power function */
void power(int F[2][2], int n);
int fib(int n)
{
int F[2][2] = {{1,1},{1,0}};
if (n == 0)
return 0;
power(F, n-1);
return F[0][0];
}
void multiply(int F[2][2], int M[2][2])
{
int x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
int y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
int z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
int w = F[1][0]*M[0][1] + F[1][1]*M[1][1];
F[0][0] = x;
F[0][1] = y;
F[1][0] = z;
F[1][1] = w;
}
void power(int F[2][2], int n)
{
int i;
int M[2][2] = {{1,1},{1,0}};
// n - 1 times multiply the matrix to {{1,0},{0,1}}
for (i = 2; i <= n; i++)
multiply(F, M);
}
/* Driver program to test above function */
int main()
{
int n = 9;
printf("%d", fib(n));
getchar();
return 0;
}
```

Time Complexity: O(n) Extra Space: O(1) Method 5 ( Optimized Method 4 ) The method 4 can be optimized to work in O(Logn) time complexity.
We can do recursive multiplication to get power(M, n) in the prevous method (Similar to the optimization done in thispost)

```java
#include <stdio.h>
void multiply(int F[2][2], int M[2][2]);
void power(int F[2][2], int n);
/* function that returns nth Fibonacci number */
int fib(int n)
{
int F[2][2] = {{1,1},{1,0}};
if (n == 0)
return 0;
power(F, n-1);
return F[0][0];
}
/* Optimized version of power() in method 4 */
void power(int F[2][2], int n)
{
if( n == 0 || n == 1)
return;
int M[2][2] = {{1,1},{1,0}};
power(F, n/2);
multiply(F, F);
if (n%2 != 0)
multiply(F, M);
}
void multiply(int F[2][2], int M[2][2])
{
int x = F[0][0]*M[0][0] + F[0][1]*M[1][0];
int y = F[0][0]*M[0][1] + F[0][1]*M[1][1];
int z = F[1][0]*M[0][0] + F[1][1]*M[1][0];
int w = F[1][0]*M[0][1] + F[1][1]*M[1][1];
F[0][0] = x;
F[0][1] = y;
F[1][0] = z;
F[1][1] = w;
}
/* Driver program to test above function */
int main()
{
int n = 9;
printf("%d", fib(9));
getchar();
return 0;
}
```

Time Complexity: O(Logn) Extra Space: O(Logn) if we consider the function call stack size, otherwise O(1).
Please write comments if you ﬁnd the above codes/algorithms incorrect, or ﬁnd other ways to solve the same problem.
References: http://en.wikipedia.org/wiki/Fibonacci_number http://www.ics.uci.edu/~eppstein/161/ 960109.html

### Source

- [Reference Link](http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 11: Average of a stream of numbers

> **Java Implementation:** [`AverageOfAStream.java`](../src/main/java/com/dsamastery/misc/AverageOfAStream.java) (`math-and-misc-algorithms`)

Diﬃculty Level: Rookie Given a stream of numbers, print average (or mean) of the stream at every point.
For example, let us consider the stream as 10, 20, 30, 40, 50, 60, … Average of 1 numbers is 10.00 Average of 2 numbers is 15.00 Average of 3 numbers is 20.00 Average of 4 numbers is 25.00 Average of 5 numbers is 30.00 Average of 6 numbers is 35.00 ..................
To print mean of a stream, we need to ﬁnd out how to ﬁnd average when a new number is being added to the stream. To do this, all we need is count of numbers seen so far in the stream, previous average and new number. Let n be the count, prev_avg be the previous average and x be the new number being added. The average after including x number can be written as (prev_avg*n + x)/(n+1).

```java
#include <stdio.h>
// Returns the new average after including x
float getAvg(float prev_avg, int x, int n)
{
return (prev_avg*n + x)/(n+1);
}
// Prints average of a stream of numbers
void streamAvg(float arr[], int n)
{
float avg = 0;
for(int i = 0; i < n; i++)
{
avg = getAvg(avg, arr[i], i);
printf("Average of %d numbers is %f \n", i+1, avg);
}
return;
}
// Driver program to test above functions
int main()
{
float arr[] = {10, 20, 30, 40, 50, 60};
int n = sizeof(arr)/sizeof(arr[0]);
streamAvg(arr, n);
return 0;
}
```

The above function getAvg() can be optimized using following changes. We can avoid the use of prev_avg and number of elements by using static variables (Assuming that only this function is called for average of stream). Following is the oprimnized version.

```java
#include <stdio.h>
// Returns the new average after including x
float getAvg (int x)
{
static int sum, n;
sum += x;
return (((float)sum)/++n);
}
// Prints average of a stream of numbers
void streamAvg(float arr[], int n)
{
float avg = 0;
for(int i = 0; i < n; i++)
{
avg = getAvg(arr[i]);
printf("Average of %d numbers is %f \n", i+1, avg);
}
return;
}
// Driver program to test above functions
int main()
{
float arr[] = {10, 20, 30, 40, 50, 60};
int n = sizeof(arr)/sizeof(arr[0]);
streamAvg(arr, n);
return 0;
}
```

Thanks to Abhijeet Deshpande for suggesting this optimized version.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/average-of-a-stream-of-numbers/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 12: Count numbers that don’t contain 3

> **Java Implementation:** [`CountNumbersThatDon.java`](../src/main/java/com/dsamastery/misc/CountNumbersThatDon.java) (`math-and-misc-algorithms`)

Given a number n, write a function that returns count of numbers from 1 to n that don’t contain digit 3 in their decimal representation.

### Examples

Input: n = 10 Output: 9 Input: n = 45 Output: 31

```java
// Numbers 3, 13, 23, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 43 contain digit 3.
```

Input: n = 578 Ouput: 385 Solution: We can solve it recursively. Let count(n) be the function that counts such numbers.
'msd' --> the most significant digit in n 'd' --> number of digits in n.
count(n) = n if n 10 and msd is not 3 count(n) = count( msd * (10^(d-1)) - 1) if n > 10 and msd is 3 Let us understand the solution with n = 578.
count(578) = 4*count(99) + 4 + count(78) The middle term 4 is added to include numbers 100, 200, 400 and 500.
Let us take n = 35 as another example.
count(35) = count (3*10 - 1) = count(29)

```java
#include <stdio.h>
/* returns count of numbers which are in range from 1 to n and don't contain 3
as a digit */
int count(int n)
{
// Base cases (Assuming n is not negative)
if (n < 3)
return n;
if (n >= 3 && n < 10)
return n-1;
// Calculate 10^(d-1) (10 raise to the power d-1) where d is
// number of digits in n. po will be 100 for n = 578
int po = 1;
while (n/po > 9)
po = po*10;
// find the most significant digit (msd is 5 for 578)
int msd = n/po;
if (msd != 3)
// For 578, total will be 4*count(10^2 - 1) + 4 + count(78)
return count(msd)*count(po - 1) + count(msd) + count(n%po);
else
// For 35, total will be equal to count(29)
return count(msd*po - 1);
}
// Driver program to test above function
int main()
{
printf ("%d ", count(578));
return 0;
}
```

### Output

Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-numbers-that-dont-contain-3/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 13: Magic Square

> **Java Implementation:** [`MagicSquare.java`](../src/main/java/com/dsamastery/misc/MagicSquare.java) (`math-and-misc-algorithms`)

A magic square of order n is an arrangement of nˆ2 numbers, usually distinct integers, in a square, such that the n numbers in all rows, all columns, and both diagonals sum to the same constant. A magic square contains the integers from 1 to nˆ2.
The constant sum in every row, column and diagonal is called the magic constant or magic sum, M. The magic constant of a normal magic square depends only on n and has the following value: M = n(nˆ2+1)/2 For normal magic squares of order n = 3, 4, 5, …, the magic constants are: 15, 34, 65, 111, 175, 260, … In this post, we will discuss how programmatically we can generate a magic square of size n. Before we go further, consider the below examples:
Magic Square of size 3
-----------------------
2 7 6 9 5 1 4 3 8 Sum in each row & each column = 3*(3^2+1)/2 = 15 Magic Square of size 5
----------------------
9 3 22 16 15 2 21 20 14 8 25 19 13 7 1 18 12 6 5 24 11 10 4 23 17 Sum in each row & each column = 5*(5^2+1)/2 = 65 Magic Square of size 7
----------------------
20 12 4 45 37 29 28 11 3 44 36 35 27 19 2 43 42 34 26 18 10 49 41 33 25 17 9 1 40 32 24 16 8 7 48 31 23 15 14 6 47 39 22 21 13 5 46 38 30 Sum in each row & each column = 7*(7^2+1)/2 = 175 Did you ﬁnd any pattern in which the numbers are stored? In any magic square, the ﬁrst number i.e. 1 is stored at position (n/2, n-1). Let this position be (i,j). The next number is stored at position (i-1, j+1) where we can consider each row & column as circular array i.e. they wrap around.
Three conditions hold:
1. The position of next number is calculated by decrementing row number of previous number by 1, and incrementing the column number of previous number by 1. At any time, if the calculated row position becomes -1, it will wrap around to n-1. Similarly, if the calculated column position becomes n, it will wrap around to 0.
2. If the magic square already contains a number at the calculated position, calculated column position will be decremented by 2, and calculated row position will be incremented by 1.
3. If the calculated row position is -1 & calculated column position is n, the new position would be: (0, n-2).

### Example

Magic Square of size 3
----------------------
2 7 6 9 5 1 4 3 8 Steps:
1. position of number 1 = (3/2, 3-1) = (1, 2) 2. position of number 2 = (1-1, 2+1) = (0, 0) 3. position of number 3 = (0-1, 0+1) = (3-1, 1) = (2, 1) 4. position of number 4 = (2-1, 1+1) = (1, 2) Since, at this position, 1 is there. So, apply condition 2.

```java
new position=(1+1,2-2)=(2,0)
```

5. position of number 5=(2-1,0+1)=(1,1) 6. position of number 6=(1-1,1+1)=(0,2) 7. position of number 7 = (0-1, 2+1) = (-1,3) // this is tricky, see condition 3

```java
new position = (0, 3-2) = (0,1)
```

8. position of number 8=(0-1,1+1)=(-1,2)=(2,2) //wrap around 9. position of number 9=(2-1,2+1)=(1,3)=(1,0) //wrap around Based on the above approach, following is the working code:

```java
#include<stdio.h>
#include<string.h>
// A function to generate odd sized magic squares
void generateSquare(int n)
{
int magicSquare[n][n];
// set all slots as 0
memset(magicSquare, 0, sizeof(magicSquare));
// Initialize position for 1
int i = n/2;
int j = n-1;
// One by one put all values in magic square
for (int num=1; num <= n*n; )
{
if (i==-1 && j==n) //3rd condition
{
j = n-2;
i = 0;
}
else
{
//1st condition helper if next number goes to out of square's right side
if (j == n)
j = 0;
//1st condition helper if next number is goes to out of square's upper side
if (i < 0)
i=n-1;
}
if (magicSquare[i][j]) //2nd condition
{
j -= 2;
i++;
continue;
}
else
magicSquare[i][j] = num++; //set number
j++; i--; //1st condition
}
// print magic square
printf("The Magic Square for n=%d:\nSum of each row or column %d:\n\n",
n, n*(n*n+1)/2);
for(i=0; i<n; i++)
{
for(j=0; j<n; j++)
printf("%3d ", magicSquare[i][j]);
printf("\n");
}
}
// Driver program to test above function
int main()
{
int n = 7; // Works only when n is odd
generateSquare (n);
return 0;
}
```

### Output

The Magic Square for n=7:
Sum of each row or column 175:
20 12 4 45 37 29 28 11 3 44 36 35 27 19 2 43 42 34 26 18 10 49 41 33 25 17 9 1 40 32 24 16 8 7 48 31 23 15 14 6 47 39 22 21 13 5 46 38 30 NOTE: This approach works only for odd values of n.
References: http://en.wikipedia.org/wiki/Magic_square This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/magic-square/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 14: Sieve of Eratosthenes

> **Java Implementation:** [`SieveOfEratosthenes.java`](../src/main/java/com/dsamastery/misc/SieveOfEratosthenes.java) (`math-and-misc-algorithms`)

Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number. For example, if n is 10, the output should be “2, 3, 5, 7￿. If n is 20, the output should be “2, 3, 5, 7, 11, 13, 17, 19￿.
The sieve of Eratosthenes is one of the most eﬃcient ways to ﬁnd all primes smaller than n when n is smaller than 10 million or so (Ref Wiki).
Followingisthealgorithmtoﬁndalltheprimenumberslessthanorequaltoagivenintegern byEratosthenes’ method:
1. Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
2. Initially, let p equal 2, the ﬁrst prime number.
3. Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list. These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked.
4. Find the ﬁrst number greater than p in the list that is not marked. If there was no such number, stop.
Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.
When the algorithm terminates, all the numbers in the list that are not marked are prime.
Explanation with Example: Let us take an example when n = 50. So we need to print all print numbers smaller than or equal to 50.
Wecreatealistofallnumbersfrom2to50.
Accordingtothealgorithmwewillmarkallthenumberswhicharedivisibleby2.
Now we move to our next unmarked number 3 and mark all the numbers which are multiples of 3.
Wemovetoournextunmarkednumber5andmarkallmultiplesof5.
Wecontinuethisprocessandourﬁnaltablewilllooklikebelow:
So the prime numbers are the unmarked ones: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47.
Thanks toKrishan Kumar for providing above explanation.
Implementation: Following is C++ implementation of the above algorithm. In the following implementa- tion, a boolean array arr[] of size n is used to mark multiples of prime numbers.

```java
#include <stdio.h>
#include <string.h>
// marks all mutiples of 'a' ( greater than 'a' but less than equal to 'n') as 1.
void markMultiples(bool arr[], int a, int n)
{
int i = 2, num;
while ( (num = i*a) <= n )
{
arr[ num-1 ] = 1; // minus 1 because index starts from 0.
++i;
}
}
// A function to print all prime numbers smaller than n
void SieveOfEratosthenes(int n)
{
// There are no prime numbers smaller than 2
if (n >= 2)
{
// Create an array of size n and initialize all elements as 0
bool arr[n];
memset(arr, 0, sizeof(arr));
/* Following property is maintained in the below for loop
arr[i] == 0 means i + 1 is prime
arr[i] == 1 means i + 1 is not prime */
for (int i=1; i<n; ++i)
{
if ( arr[i] == 0 )
{
//(i+1) is prime, print it and mark its multiples
printf("%d ", i+1);
markMultiples(arr, i+1, n);
}
}
}
}
// Driver Program to test above function
int main()
{
int n = 30;
printf("Following are the prime numbers below %d\n", n);
SieveOfEratosthenes(n);
return 0;
}
```

### Output

Following are the prime numbers below 30 2 3 5 7 11 13 17 19 23 29 References: http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes This article is compiled by Abhinav Priyadarshi and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/sieve-of-eratosthenes/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 15: Find day of the week for a given date

> **Java Implementation:** [`FindDayOfThe.java`](../src/main/java/com/dsamastery/misc/FindDayOfThe.java) (`math-and-misc-algorithms`)

Write a function that calculates the day of the week for any particular date in the past or future. A typical application is to calculate the day of the week on which someone was born or some other special event occurred.
Following is a simple C function suggested by Sakamoto, Lachman, Keith and Craver to calculate day. The following function returns 0 for Sunday, 1 for Monday, etc.

```java
/* A program to find day of a given date */
#include<stdio.h>
int dayofweek(int d, int m, int y)
{
static int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
y -= m < 3;
return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
}
/* Driver function to test above function */
int main()
{
int day = dayofweek(30, 8, 2010);
printf ("%d", day);
return 0;
}
```

Output: 1 (Monday) See thisfor explanation of the above function.
References: http://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week This article is compiled by Dheeraj Jain and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-day-of-the-week-for-a-given-date/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 16: DFA based division

> **Java Implementation:** [`DfaBasedDivision.java`](../src/main/java/com/dsamastery/misc/DfaBasedDivision.java) (`math-and-misc-algorithms`)

Deterministic Finite Automaton (DFA) can be used to check whether a number “num” is divisible by “k” or not. If the number is not divisible, remainder can also be obtained using DFA.
We consider the binary representation of ‘num’ and build a DFA with k states. The DFA has transition function for both 0 and 1. Once the DFA is built, we process ‘num’ over the DFA to get remainder.
Let us walk through an example. Suppose we want to check whether a given number ‘num’ is divisible by 3 or not. Any number can be written in the form: num = 3*a + b where ‘a’ is the quotient and ‘b’ is the remainder. For 3, there can be 3 states in DFA, each corresponding to remainder 0, 1 and 2. And each state can have two transitions corresponding 0 and 1 (considering the binary representation of given ‘num’). The transition function F(p, x) = q tells that on reading alphabet x, we move from state p to state q. Let us name the states as 0, 1 and 2. The initial state will always be 0. The ﬁnal state indicates the remainder. If the ﬁnal state is 0, the number is divisible.
In the above diagram, double circled state is ﬁnal state.
1. When we are at state 0 and read 0, we remain at state 0. 2. When we are at state 0 and read 1, we move to state 1, why? The number so formed(1) in decimal gives remainder 1. 3. When we are at state 1 and read 0, we move to state 2, why? The number so formed(10) in decimal gives remainder 2. 4. When we are at state 1 and read 1, we move to state 0, why? The number so formed(11) in decimal gives remainder 0. 5.
When we are at state 2 and read 0, we move to state 1, why? The number so formed(100) in decimal gives remainder 1. 6. When we are at state 2 and read 1, we remain at state 2, why? The number so formed(101) in decimal gves remainder 2.
The transition table looks like following:
state 0 1 _____________ 0 0 1 1 2 0 2 1 2 Let us check whether 6 is divisible by 3? Binary representation of 6 is 110 state = 0 1. state=0, we read 1,

```java
new state=1 2. state=1, we read 1, new state=0 3. state=0, we read 0, new state=0 Since the ﬁnal state is
```

0, the number is divisible by 3.
Let us take another example number as 4 state=0 1. state=0, we read 1, new state=1 2. state=1, we read 0,

```java
new state=2 3. state=2, we read 0, new state=1 Since, the ﬁnal state is not 0, the number is not divisible
```

by 3. The remainder is 1.
Note that the ﬁnal state gives the remainder.
We can extend the above solution for any value of k. For a value k, the states would be 0, 1, …. , k-1. How to calculate the transition if the decimal equivalent of the binary bits seen so far, crosses the range k? If we are at state p, we have read p (in decimal). Now we read 0, new read number becomes 2*p. If we read 1,

```java
new read number becomes 2*p+1. The new state can be obtained by subtracting k from these values (2p
```

or 2p+1) where 0 #include <stdio.h> #include <stdlib.h> // Function to build DFA for divisor k void preprocess(int k, int Table[][2]) { int trans0, trans1; // The following loop calculates the two transitions for each state, // starting from state 0 for (int state=0; state<k; ++state) { // Calculate next state for bit 0 trans0 = state<<1; Table[state][0] = (trans0 < k)? trans0: trans0-k; // Calculate next state for bit 1 trans1 = (state<<1) + 1; Table[state][1] = (trans1 < k)? trans1: trans1-k; } } // A recursive utility function that takes a ‘num’ and DFA (transition // table) as input and process ‘num’ bit by bit over DFA void isDivisibleUtil(int num, int* state, int Table[][2]) { // process “num” bit by bit from MSB to LSB if (num != 0) { isDivisibleUtil(num>>1, state, Table); *state = Table[*state][num&1]; } } // The main function that divides ‘num’ by k and returns the remainder int isDivisible (int num, int k) { // Allocate memory for transition table. The table will have k*2 entries int (*Table)[2] = (int (*)[2])malloc(k*sizeof(*Table)); // Fill the transition table preprocess(k, Table); // Process ‘num’ over DFA and get the remainder int state =

```java
0; isDivisibleUtil(num, &state, Table); // Note that the ﬁnal value of state is the remainder return state; }
// Driver program to test above functions int main() { int num = 47; // Number to be divided int k = 5;
// Divisor int remainder = isDivisible (num, k); if (remainder == 0) printf(“Divisible\n”); else printf(“Not
Divisible: Remainder is %d\n”, remainder); return 0; }
```

### Output

Not Divisible: Remainder is 2 DFA based division can be useful if we have a binary stream as input and we want to check for divisibility of the decimal value of stream at any time.
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/dfa-based-division/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 17: Generate integer from 1 to 7 with

> **Java Implementation:** [`GenerateIntegerFrom1.java`](../src/main/java/com/dsamastery/misc/GenerateIntegerFrom1.java) (`math-and-misc-algorithms`)

equal probability Given a function foo() that returns integers from 1 to 5 with equal probability, write a function that returns integers from 1 to 7 with equal probability using foo() only. Minimize the number of calls to foo() method.
Also, use of any other library function is not allowed and no ﬂoating point arithmetic allowed.
Solution: We know foo() returns integers from 1 to 5. How we can ensure that integers from 1 to 7 occur with equal probability? If we somehow generate integers from 1 to a-multiple-of-7 (like 7, 14, 21, …) with equal probability, we can use modulo division by 7 followed by adding 1 to get the numbers from 1 to 7 with equal probability.
We can generate from 1 to 21 with equal probability using the following expression.
5*foo() + foo() -5 Let us see how above expression can be used. 1. For each value of ﬁrst foo(), there can be 5 possible combinations for values of second foo(). So, there are total 25 combinations possible. 2. The range of values returned by the above equation is 1 to 25, each integer occurring exactly once. 3. If the value of the equation comes out to be less than 22, return modulo division by 7 followed by adding 1. Else, again call the method recursively. The probability of returning each integer thus becomes 1/7.
The below program shows that the expression returns each integer from 1 to 25 exactly once.

```java
#include <stdio.h>
int main()
{
int first, second;
for ( first=1; first<=5; ++first )
for ( second=1; second<=5; ++second )
printf ("%d \n", 5*first + second - 5);
return 0;
}
```

### Output

.
.
The below program depicts how we can use foo() to return 1 to 7 with equal probability.

```java
#include <stdio.h>
int foo() // given method that returns 1 to 5 with equal probability
{
// some code here
}
int my_rand() // returns 1 to 7 with equal probability
{
int i;
i = 5*foo() + foo() - 5;
if (i < 22)
return i%7 + 1;
return my_rand();
}
int main()
{
printf ("%d ", my_rand());
return 0;
}
```

This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 18: Given a number, ﬁnd the next

> **Java Implementation:** [`GivenANumberNd.java`](../src/main/java/com/dsamastery/misc/GivenANumberNd.java) (`math-and-misc-algorithms`)

smallest palindrome Given a number, ﬁnd the next smallest palindrome larger than this number. For example, if the input number is “2 3 5 4 5￿, the output should be “2 3 6 3 2￿. And if the input number is “9 9 9￿, the output should be “1 0 0 1￿.
The input is assumed to be an array. Every entry in array represents a digit in input number. Let the array be ‘num[]’ and size of array be ‘n’ There can be three diﬀerent types of inputs that need to be handled separately. 1) The input number is palindrome and has all 9s. For example “9 9 9￿. Output should be “1 0 0 1￿ 2) The input number is not palindrome. For example “1 2 3 4￿. Output should be “1 3 3 1￿ 3) The input number is palindrome and doesn’t have all 9s. For example “1 2 2 1￿. Output should be “1 3 3 1￿.
Solution for input type 1 is easy. The output contains n + 1 digits where the corner digits are 1, and all digits between corner digits are 0.
Now let us ﬁrst talk about input type 2 and 3. How to convert a given number to a greater palindrome? To understand the solution, let us ﬁrst deﬁne the following two terms: Left Side: The left half of given number.
Left side of “1 2 3 4 5 6￿ is “1 2 3￿ and left side of “1 2 3 4 5￿ is “1 2￿ Right Side: The right half of given number. Right side of “1 2 3 4 5 6￿ is “4 5 6￿ and right side of “1 2 3 4 5￿ is “4 5￿ To convert to palindrome, we can either take the mirror of its left side or take mirror of its right side. However, if we take the mirror of the right side, then the palindrome so formed is not guaranteed to be next larger palindrome. So, we must take the mirror of left side and copy it to right side. But there are some cases that must be handled in diﬀerent ways. See the following steps.
We will start with two indices i and j. i pointing to the two middle elements (or pointing to two elements around the middle element in case of n being odd). We one by one move i and j away from each other.
Step 1. Initially, ignore the part of left side which is same as the corresponding part of right side. For example, if the number is “8 3 4 2 2 4 6 9￿, we ignore the middle four elements. i now points to element 3 and j now points to element 6.
Step 2. After step 1, following cases arise:
Case 1: Indices i & j cross the boundary. This case occurs when the input number is palindrome. In this case, we just add 1 to the middle digit (or digits in case n is even) propagate the carry towards MSB digit of left side and simultaneously copy mirror of the left side to the right side. For example, if the given number is “1 2 9 2 1￿, we increment 9 to 10 and propagate the carry. So the number becomes “1 3 0 3 1￿ Case 2: There are digits left between left side and right side which are not same. So, we just mirror the left side to the right side & try to minimize the number formed to guarantee the next smallest palindrome.
In this case, there can be two sub-cases.
2.1) Copying the left side to the right side is suﬃcient, we don’t need to increment any digits and the result is just mirror of left side. Following are some examples of this sub-case. Next palindrome for “7 8 3 3 2 2￿ is “7 8 3 3 8 7￿ Next palindrome for “1 2 5 3 2 2￿ is “1 2 5 5 2 1￿ Next palindrome for “1 4 5 8 7 6 7 8 3 2 2￿ is “1 4 5 8 7 6 7 8 5 4 1￿ How do we check for this sub-case? All we need to check is the digit just after the ignored part in step 1. This digit is highlighted in above examples. If this digit is greater than the corresponding digit in right side digit, then copying the left side to the right side is suﬃcient and we don’t need to do anything else.
2.2) Copying the left side to the right side is NOT suﬃcient. This happens when the above deﬁned digit of left side is smaller. Following are some examples of this case. Next palindrome for “7 1 3 3 2 2￿ is “7 1 4 4 1 7￿ Next palindrome for “1 2 3 4 6 2 8￿ is “1 2 3 5 3 2 1￿ Next palindrome for “9 4 1 8 7 9 7 8 3 2 2￿ is “9 4 1 8 8 0 8 8 1 4 9￿ We handle this subcase like Case 1. We just add 1 to the middle digit (or digits in ase n is even) propagate the carry towards MSB digit of left side and simultaneously copy mirror of the left side to the right side.

```java
#include <stdio.h>
// A utility function to print an array
void printArray (int arr[], int n);
// A utility function to check if num has all 9s
int AreAll9s (int num[], int n );
// Returns next palindrome of a given number num[].
// This function is for input type 2 and 3
void generateNextPalindromeUtil (int num[], int n )
{
// find the index of mid digit
int mid = n/2;
// A bool variable to check if copy of left side to right is sufficient or not
bool leftsmaller = false;
// end of left side is always 'mid -1'
int i = mid - 1;
// Begining of right side depends if n is odd or even
int j = (n % 2)? mid + 1 : mid;
// Initially, ignore the middle same digits
while (i >= 0 && num[i] == num[j])
i--,j++;
// Find if the middle digit(s) need to be incremented or not (or copying left
// side is not sufficient)
if ( i < 0 || num[i] < num[j])
leftsmaller = true;
// Copy the mirror of left to tight
while (i >= 0)
{
num[j] = num[i];
j++;
i--;
}
// Handle the case where middle digit(s) must be incremented.
// This part of code is for CASE 1 and CASE 2.2
if (leftsmaller == true)
{
int carry = 1;
i = mid - 1;
// If there are odd digits, then increment
// the middle digit and store the carry
if (n%2 == 1)
{
num[mid] += carry;
carry = num[mid] / 10;
num[mid] %= 10;
j = mid + 1;
}
else
j = mid;
// Add 1 to the rightmost digit of the left side, propagate the carry
// towards MSB digit and simultaneously copying mirror of the left side
// to the right side.
while (i >= 0)
{
num[i] += carry;
carry = num[i] / 10;
num[i] %= 10;
num[j++] = num[i--]; // copy mirror to right
}
}
}
// The function that prints next palindrome of a given number num[]
// with n digits.
void generateNextPalindrome( int num[], int n )
{
int i;
printf("\nNext palindrome is:\n");
// Input type 1: All the digits are 9, simply o/p 1
// followed by n-1 0's followed by 1.
if( AreAll9s( num, n ) )
{
printf( "1 ");
for( i = 1; i < n; i++ )
printf( "0 " );
printf( "1" );
}
// Input type 2 and 3
else
{
generateNextPalindromeUtil ( num, n );
// print the result
printArray (num, n);
}
}
// A utility function to check if num has all 9s
int AreAll9s( int* num, int n )
{
int i;
for( i = 0; i < n; ++i )
if( num[i] != 9 )
return 0;
return 1;
}
/* Utility that prints out an array on a line */
void printArray(int arr[], int n)
{
int i;
for (i=0; i < n; i++)
printf("%d ", arr[i]);
printf("\n");
}
// Driver Program to test above function
int main()
{
int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
int n = sizeof (num)/ sizeof(num[0]);
generateNextPalindrome( num, n );
return 0;
}
```

### Output

Next palindrome is:
9 4 1 8 8 0 8 8 1 4 9 Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 19: Make a fair coin from a biased coin

> **Java Implementation:** [`MakeAFairCoin.java`](../src/main/java/com/dsamastery/misc/MakeAFairCoin.java) (`math-and-misc-algorithms`)

You are given a function foo() that represents a biased coin. When foo() is called, it returns 0 with 60% probability, and 1 with 40% probability. Write a new function that returns 0 and 1 with 50% probability each. Your function should use only foo(), no other library method.
Solution: We know foo() returns 0 with 60% probability. How can we ensure that 0 and 1 are returned with 50% probability? The solution is similar to thispost. If we can somehow get two cases with equal probability, then we are done. We call foo() two times. Both calls will return 0 with 60% probability. So the two pairs (0, 1) and (1, 0) will be generated with equal probability from two calls of foo(). Let us see how.
(0, 1): The probability to get 0 followed by 1 from two calls of foo() = 0.6 * 0.4 = 0.24 (1, 0): The probability to get 1 followed by 0 from two calls of foo() = 0.4 * 0.6 = 0.24 So the two cases appear with equal probability. The idea is to return consider only the above two cases, return 0 in one case, return 1 in other case. For other cases [(0, 0) and (1, 1)], recur until you end up in any of the above two cases.
The below program depicts how we can use foo() to return 0 and 1 with equal probability.

```java
#include <stdio.h>
int foo() // given method that returns 0 with 60% probability and 1 with 40%
{
// some code here
}
// returns both 0 and 1 with 50% probability
int my_fun()
{
int val1 = foo();
int val2 = foo();
if (val1 == 0 && val2 == 1)
return 0; // Will reach here with 0.24 probability
if (val1 == 1 && val2 == 0)
return 1; // // Will reach here with 0.24 probability
return my_fun(); // will reach here with (1 - 0.24 - 0.24) probability
}
int main()
{
printf ("%d ", my_fun());
return 0;
}
```

References: http://en.wikipedia.org/wiki/Fair_coin#Fair_results_from_a_biased_coin This article is compiled by Shashank Sinha and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above. If you like GeeksforGeeks and would like to contribute, you can also write an article and mail your article to contribute@geeksforgeeks.org. See your article appearing on the GeeksforGeeks main page and help other Geeks.

### Source

- [Reference Link](http://www.geeksforgeeks.org/print-0-and-1-with-50-probability/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 20: Check divisibility by 7

> **Java Implementation:** [`CheckDivisibilityBy7.java`](../src/main/java/com/dsamastery/misc/CheckDivisibilityBy7.java) (`math-and-misc-algorithms`)

Given a number, check if it is divisible by 7. You are not allowed to use modulo operator, ﬂoating point arithmetic is also not allowed.
A simple method is repeated subtraction. Following is another interesting method.
Divisibility by 7 can be checked by a recursive method. A number of the form 10a + b is divisible by 7 if and only if a – 2b is divisible by 7. In other words, subtract twice the last digit from the number formed by the remaining digits. Continue to do this until a small number.
Example: the number 371: 37 – (2×1) = 37 – 2 = 35; 3 – (2 × 5) = 3 – 10 = -7; thus, since -7 is divisible by 7, 371 is divisible by 7.
Following is C implementation of the above method

```java
// A Program to check whether a number is divisible by 7
#include <stdio.h>
int isDivisibleBy7( int num )
{
// If number is negative, make it positive
if( num < 0 )
return isDivisibleBy7( -num );
// Base cases
if( num == 0 || num == 7 )
return 1;
if( num < 10 )
return 0;
// Recur for ( num / 10 - 2 * num % 10 )
return isDivisibleBy7( num / 10 - 2 * ( num - num / 10 * 10 ) );
}
// Driver program to test above function
int main()
{
int num = 616;
if( isDivisibleBy7(num ) )
printf( "Divisible" );
else
printf( "Not Divisible" );
return 0;
}
```

### Output

Divisible How does this work? Let ‘b’ be the last digit of a number ‘n’ and let ‘a’ be the number we get when we split oﬀ ‘b’. The representation of the number may also be multiplied by any number relatively prime to the divisor without changing its divisibility. After observing that 7 divides 21, we can perform the following:
10.a + b after multiplying by 2, this becomes 20.a + 2.b and then 21.a - a + 2.b Eliminating the multiple of 21 gives
-a + 2b
and multiplying by -1 gives a - 2b There are other interesting methods to check divisibility by 7 and other numbers. See following Wiki page for details.
References: http://en.wikipedia.org/wiki/Divisibility_rule Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/divisibility-by-7/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 21: Find the largest multiple of 3

> **Java Implementation:** [`FindTheLargestMultiple.java`](../src/main/java/com/dsamastery/misc/FindTheLargestMultiple.java) (`math-and-misc-algorithms`)

Given an array of non-negative integers. Find the largest multiple of 3 that can be formed from array elements.
For example, if the input array is {8, 1, 9}, the output should be “9 8 1￿, and if the input array is {8, 1, 7, 6, 0}, output should be “8 7 6 0￿.
Method 1 (Brute Force) The simple & straight forward approach is to generate all the combinations of the elements and keep track of the largest number formed which is divisible by 3.
Time Complexity: O(n x 2ˆn). There will be 2ˆn combinations of array elements. To compare each combination with the largest number so far may take O(n) time. Auxiliary Space: O(n) // to avoid integer overﬂow, the largest number is assumed to be stored in the form of array.
Method 2 (Tricky) This problem can be solved eﬃciently with the help of O(n) extra space. This method is based on the following facts about numbers which are multiple of 3.
1) A number is multiple of 3 if and only if the sum of digits of number is multiple of 3. For example, let us consider 8760, it is a multiple of 3 because sum of digits is 8 + 7+ 6+ 0 = 21, which is a multiple of 3.
2) If a number is multiple of 3, then all permutations of it are also multiple of 3. For example, since 6078 is a multiple of 3, the numbers 8760, 7608, 7068, ….. are also multiples of 3.
3) We get the same remainder when we divide the number and sum of digits of the number. For example, if divide number 151 and sum of it digits 7, by 3, we get the same remainder 1.
What is the idea behind above facts? The value of 10%3 and 100%3 is 1. The same is true for all the higher powers of 10, because 3 divides 9, 99, 999, … etc. Let us consider a 3 digit number n to prove above facts.
Let the ﬁrst, second and third digits of n be ‘a’, ‘b’ and ‘c’ respectively. n can be written as n = 100.a + 10.b + c Since (10ˆx)%3 is 1 for any x, the above expression gives the same remainder as following expression 1.a + 1.b + c So the remainder obtained by sum of digits and ‘n’ is same.
Following is a solution based on the above observation.
1. Sort the array in non-decreasing order.
2. Take three queues. One for storing elements which on dividing by 3 gives remainder as 0.The second queue stores digits which on dividing by 3 gives remainder as 1. The third queue stores digits which on dividing by 3 gives remainder as 2. Call them as queue0, queue1 and queue2 3. Find the sum of all the digits.
4. Three cases arise: ……4.1 The sum of digits is divisible by 3. Dequeue all the digits from the three queues.
Sort them in non-increasing order. Output the array.
……4.2 The sum of digits produces remainder 1 when divided by 3. Remove one item from queue1. If queue1 is empty, remove two items from queue2. If queue2 contains less than two items, the number is not possible.
……4.3 The sum of digits produces remainder 2 when divided by 3. Remove one item from queue2. If queue2 is empty, remove two items from queue1. If queue1 contains less than two items, the number is not possible.
5. Finally empty all the queues into an auxiliary array. Sort the auxiliary array in non-increasing order.
Output the auxiliary array.
Based on the above, below is C implementation:
The below code works only if the input arrays has numbers from 0 to 9. It can be easily extended for any positive integer array. We just have to modify the part where we sort the array in decreasing order, at the end of code.

```java
/* A program to find the largest multiple of 3 from an array of elements */
#include <stdio.h>
#include <stdlib.h>
// A queue node
typedef struct Queue
{
int front;
int rear;
int capacity;
int* array;
} Queue;
// A utility function to create a queue with given capacity
Queue* createQueue( int capacity )
{
Queue* queue = (Queue *) malloc (sizeof(Queue));
queue->capacity = capacity;
queue->front = queue->rear = -1;
queue->array = (int *) malloc (queue->capacity * sizeof(int));
return queue;
}
// A utility function to check if queue is empty
int isEmpty (Queue* queue)
{
return queue->front == -1;
}
// A function to add an item to queue
void Enqueue (Queue* queue, int item)
{
queue->array[ ++queue->rear ] = item;
if ( isEmpty(queue) )
++queue->front;
}
// A function to remove an item from queue
int Dequeue (Queue* queue)
{
int item = queue->array[ queue->front ];
if( queue->front == queue->rear )
queue->front = queue->rear = -1;
else
queue->front++;
return item;
}
// A utility function to print array contents
void printArr (int* arr, int size)
{
int i;
for (i = 0; i< size; ++i)
printf ("%d ", arr[i]);
}
/* Following two functions are needed for library function qsort().
Refer following link for help of qsort()
http://www.cplusplus.com/reference/clibrary/cstdlib/qsort/ */
int compareAsc( const void* a, const void* b )
{
return *(int*)a > *(int*)b;
}
int compareDesc( const void* a, const void* b )
{
return *(int*)a < *(int*)b;
}
// This function puts all elements of 3 queues in the auxiliary array
void populateAux (int* aux, Queue* queue0, Queue* queue1,
```

Queue* queue2, int* top )

```java
{
// Put all items of first queue in aux[]
while ( !isEmpty(queue0) )
aux[ (*top)++ ] = Dequeue( queue0 );
// Put all items of second queue in aux[]
while ( !isEmpty(queue1) )
aux[ (*top)++ ] = Dequeue( queue1 );
// Put all items of third queue in aux[]
while ( !isEmpty(queue2) )
aux[ (*top)++ ] = Dequeue( queue2 );
}
// The main function that finds the largest possible multiple of
// 3 that can be formed by arr[] elements
int findMaxMultupleOf3( int* arr, int size )
{
// Step 1: sort the array in non-decreasing order
qsort( arr, size, sizeof( int ), compareAsc );
// Create 3 queues to store numbers with remainder 0, 1
// and 2 respectively
Queue* queue0 = createQueue( size );
Queue* queue1 = createQueue( size );
Queue* queue2 = createQueue( size );
// Step 2 and 3 get the sum of numbers and place them in
// corresponding queues
int i, sum;
for ( i = 0, sum = 0; i < size; ++i )
{
sum += arr[i];
if ( (arr[i] % 3) == 0 )
Enqueue( queue0, arr[i] );
else if ( (arr[i] % 3) == 1 )
Enqueue( queue1, arr[i] );
else
Enqueue( queue2, arr[i] );
}
// Step 4.2: The sum produces remainder 1
if ( (sum % 3) == 1 )
{
// either remove one item from queue1
if ( !isEmpty( queue1 ) )
Dequeue( queue1 );
// or remove two items from queue2
else
{
if ( !isEmpty( queue2 ) )
Dequeue( queue2 );
else
return 0;
if ( !isEmpty( queue2 ) )
Dequeue( queue2 );
else
return 0;
}
}
// Step 4.3: The sum produces remainder 2
else if ((sum % 3) == 2)
{
// either remove one item from queue2
if ( !isEmpty( queue2 ) )
Dequeue( queue2 );
// or remove two items from queue1
else
{
if ( !isEmpty( queue1 ) )
Dequeue( queue1 );
else
return 0;
if ( !isEmpty( queue1 ) )
Dequeue( queue1 );
else
return 0;
}
}
int aux[size], top = 0;
// Empty all the queues into an auxiliary array.
populateAux (aux, queue0, queue1, queue2, &top);
// sort the array in non-increasing order
qsort (aux, top, sizeof( int ), compareDesc);
// print the result
printArr (aux, top);
return top;
}
// Driver program to test above functions
int main()
{
int arr[] = {8, 1, 7, 6, 0};
int size = sizeof(arr)/sizeof(arr[0]);
if (findMaxMultupleOf3( arr, size ) == 0)
printf( "Not Possible" );
return 0;
}
```

The above method can be optimized in following ways. 1) We can use Heap Sort or Merge Sort to make the time complexity O(nLogn).
2) We can avoid extra space for queues. We know at most two items will be removed from the input array.
So we can keep track of two items in two variables.
3) At the end, instead of sorting the array again in descending order, we can print the ascending sorted array in reverse order. While printing in reverse order, we can skip the two elements to be removed.
Time Complexity: O(nLogn), assuming a O(nLogn) algorithm is used for sorting.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 22: Lexicographic rank of a string

> **Java Implementation:** [`LexicographicRankOfA.java`](../../trees-graphs/src/main/java/com/dsamastery/trees/LexicographicRankOfA.java) (`trees-graphs`)

Given a string, ﬁnd its rank among all its permutations sorted lexicographically. For example, rank of “abc” is 1, rank of “acb” is 2, and rank of “cba” is 6.
For simplicity, let us assume that the string does not contain any duplicated characters.
One simple solution is to initialize rank as 1, generate all permutations in lexicographic order. After gener- ating a permutation, check if the generated permutation is same as given string, if same, then return rank, if not, then increment the rank by 1. The time complexity of this solution will be exponential in worst case.
Following is an eﬃcient solution.
Let the given string be “STRING”. In the input string, ‘S’ is the ﬁrst character. There are total 6 characters and 4 of them are smaller than ‘S’. So there can be 4 * 5! smaller strings where ﬁrst character is smaller than ‘S’, like following R X X X X X I X X X X X N X X X X X G X X X X X Now let us Fix S’ and ﬁnd the smaller strings staring with ‘S’.
Repeat the same process for T, rank is 4*5! + 4*4! +… Now ﬁx T and repeat the same process for R, rank is 4*5! + 4*4! + 3*3! +… Now ﬁx R and repeat the same process for I, rank is 4*5! + 4*4! + 3*3! + 1*2! +… Now ﬁx I and repeat the same process for N, rank is 4*5! + 4*4! + 3*3! + 1*2! + 1*1! +… Now ﬁx N and repeat the same process for G, rank is 4*5! + 4*4 + 3*3! + 1*2! + 1*1! + 0*0!
Rank = 4*5! + 4*4! + 3*3! + 1*2! + 1*1! + 0*0! = 597 Since the value of rank starts from 1, the ﬁnal rank = 1 + 597 = 598

```java
#include <stdio.h>
#include <string.h>
// A utility function to find factorial of n
int fact(int n)
{
return (n <= 1)? 1 :n * fact(n-1);
}
// A utility function to count smaller characters on right
// of arr[low]
int findSmallerInRight(char* str, int low, int high)
{
int countRight = 0, i;
for (i = low+1; i <= high; ++i)
if (str[i] < str[low])
++countRight;
return countRight;
}
// A function to find rank of a string in all permutations
// of characters
int findRank (char* str)
{
int len = strlen(str);
int mul = fact(len);
int rank = 1;
int countRight;
int i;
for (i = 0; i < len; ++i)
{
mul /= len - i;
// count number of chars smaller than str[i]
// fron str[i+1] to str[len-1]
countRight = findSmallerInRight(str, i, len-1);
rank += countRight * mul ;
}
return rank;
}
// Driver program to test above function
int main()
{
char str[] = "string";
printf ("%d", findRank(str));
return 0;
}
```

Output The time complexity of the above solution is O(nˆ2). We can reduce the time complexity to O(n) by creating an auxiliary array of size 256. See following code.

```java
// A O(n) solution for finding rank of string
#include <stdio.h>
#include <string.h>
#define MAX_CHAR 256
// A utility function to find factorial of n
int fact(int n)
{
return (n <= 1)? 1 :n * fact(n-1);
}
// Construct a count array where value at every index
// contains count of smaller characters in whole string
void populateAndIncreaseCount (int* count, char* str)
{
int i;
for( i = 0; str[i]; ++i )
++count[ str[i] ];
for( i = 1; i < 256; ++i )
count[i] += count[i-1];
}
// Removes a character ch from count[] array
// constructed by populateAndIncreaseCount()
void updatecount (int* count, char ch)
{
int i;
for( i = ch; i < MAX_CHAR; ++i )
--count[i];
}
// A function to find rank of a string in all permutations
// of characters
int findRank (char* str)
{
int len = strlen(str);
int mul = fact(len);
int rank = 1, i;
int count[MAX_CHAR] = {0}; // all elements of count[] are initialized with 0
// Populate the count array such that count[i] contains count of
// characters which are present in str and are smaller than i
populateAndIncreaseCount( count, str );
for (i = 0; i < len; ++i)
{
mul /= len - i;
// count number of chars smaller than str[i]
// fron str[i+1] to str[len-1]
rank += count[ str[i] - 1] * mul;
// Reduce count of characters greater than str[i]
updatecount (count, str[i]);
}
return rank;
}
// Driver program to test above function
int main()
{
char str[] = "string";
printf ("%d", findRank(str));
return 0;
}
```

The above programs don’t work for duplicate characters. To make them work for duplicate characters, ﬁnd all the characters that are smaller (include equal this time also), do the same as above but, this time divide the rank so formed by p! where p is the count of occurrences of the repeating character.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 23: Print all permutations in sorted

> **Java Implementation:** [`PrintAllPermutationsIn.java`](../../sorting-searching/src/main/java/com/dsamastery/sorting/PrintAllPermutationsIn.java) (`sorting-searching`)

(lexicographic) order Given a string, print all permutations of it in sorted order. For example, if the input string is “ABC”, then output should be “ABC, ACB, BAC, BCA, CAB, CBA”.
We have discussed a program to print all permutations in this post, but here we must print the permutations in increasing order.
Following are the steps to print the permutations lexicographic-ally 1. Sort the given string in non-decreasing order and print it. The ﬁrst permutation is always the string sorted in non-decreasing order.
2. Start generating next higher permutation. Do it until next higher permutation is not possible. If we reach a permutation where all characters are sorted in non-increasing order, then that permutation is the last permutation.
Steps to generate the next higher permutation: 1. Take the previously printed permutation and ﬁnd the rightmost character in it, which is smaller than its next character. Let us call this character as ‘ﬁrst character’.
2. Now ﬁnd the ceiling of the ‘ﬁrst character’. Ceiling is the smallest character on right of ‘ﬁrst character’, which is greater than ‘ﬁrst character’. Let us call the ceil character as ‘second character’.
3. Swap the two characters found in above 2 steps.
4. Sort the substring (in non-decreasing order) after the original index of ‘ﬁrst character’.
Let us consider the string “ABCDEF”. Let previously printed permutation be “DCFEBA”. The next permu- tation in sorted order should be “DEABCF”. Let us understand above steps to ﬁnd next permutation. The ‘ﬁrst character’ will be ‘C’. The ‘second character’ will be ‘E’. After swapping these two, we get “DEFCBA”.
The ﬁnal step is to sort the substring after the character original index of ‘ﬁrst character’. Finally, we get “DEABCF”.
Following is C++ implementation of the algorithm.

```java
// Program to print all permutations of a string in sorted order.
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* Following function is needed for library function qsort(). Refer
http://www.cplusplus.com/reference/clibrary/cstdlib/qsort/ */
int compare (const void *a, const void * b)
{ return ( *(char *)a - *(char *)b ); }
// A utility function two swap two characters a and b
void swap (char* a, char* b)
{
char t = *a;
*a = *b;
*b = t;
}
// This function finds the index of the smallest character
// which is greater than 'first' and is present in str[l..h]
int findCeil (char str[], char first, int l, int h)
{
// initialize index of ceiling element
int ceilIndex = l;
// Now iterate through rest of the elements and find
// the smallest character greater than 'first'
for (int i = l+1; i <= h; i++)
if (str[i] > first && str[i] < str[ceilIndex])
ceilIndex = i;
return ceilIndex;
}
// Print all permutations of str in sorted order
void sortedPermutations ( char str[] )
{
// Get size of string
int size = strlen(str);
// Sort the string in increasing order
qsort( str, size, sizeof( str[0] ), compare );
// Print permutations one by one
bool isFinished = false;
while ( ! isFinished )
{
// print this permutation
printf ("%s \n", str);
// Find the rightmost character which is smaller than its next
// character. Let us call it 'first char'
int i;
for ( i = size - 2; i >= 0; --i )
if (str[i] < str[i+1])
break;
// If there is no such chracter, all are sorted in decreasing order,
// means we just printed the last permutation and we are done.
if ( i == -1 )
isFinished = true;
else
{
// Find the ceil of 'first char' in right of first character.
// Ceil of a character is the smallest character greater than it
int ceilIndex = findCeil( str, str[i], i + 1, size - 1 );
// Swap first and second characters
swap( &str[i], &str[ceilIndex] );
// Sort the string on right of 'first char'
qsort( str + i + 1, size - i - 1, sizeof(str[0]), compare );
}
}
}
// Driver program to test above function
int main()
{
char str[] = "ABCD";
sortedPermutations( str );
return 0;
}
```

### Output

ABCD ABDC ....
....
DCAB DCBA The upper bound on time complexity of the above program is O(nˆ2 x n!). We can optimize step 4 of the above algorithm for ﬁnding next permutation. Instead of sorting the subarray after the ‘ﬁrst character’, we can reverse the subarray, because the subarray we get after swapping is always sorted in non-increasing order.
This optimization makes the time complexity as O(n x n!). See following optimized code.

```java
// An optimized version that uses reverse instead of sort for
// finding the next permutation
// A utility function to reverse a string str[l..h]
void reverse(char str[], int l, int h)
{
while (l < h)
{
swap(&str[l], &str[h]);
l++;
h--;
}
}
// Print all permutations of str in sorted order
void sortedPermutations ( char str[] )
{
// Get size of string
int size = strlen(str);
// Sort the string in increasing order
qsort( str, size, sizeof( str[0] ), compare );
// Print permutations one by one
bool isFinished = false;
while ( ! isFinished )
{
// print this permutation
printf ("%s \n", str);
// Find the rightmost character which is smaller than its next
// character. Let us call it 'first char'
int i;
for ( i = size - 2; i >= 0; --i )
if (str[i] < str[i+1])
break;
// If there is no such chracter, all are sorted in decreasing order,
// means we just printed the last permutation and we are done.
if ( i == -1 )
isFinished = true;
else
{
// Find the ceil of 'first char' in right of first character.
// Ceil of a character is the smallest character greater than it
int ceilIndex = findCeil( str, str[i], i + 1, size - 1 );
// Swap first and second characters
swap( &str[i], &str[ceilIndex] );
// reverse the string on right of 'first char'
reverse( str, i + 1, size - 1 );
}
}
}
```

The above programs print duplicate permutation when characters are repeated. We can avoid it by keeping track of the previous permutation. While printing, if the current permutation is same as previous permuta- tion, we won’t print it.
This article is compiled by Aashish Barnwal and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/lexicographic-permutations-of-string/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 24: Shuﬄe a given array

> **Java Implementation:** [`ShuEAGiven2.java`](../../arrays-strings/src/main/java/com/dsamastery/arrays/ShuEAGiven2.java) (`arrays-strings`)

Given an array, write a program to generate a random permutation of array elements. This question is also asked as “shuﬄe a deck of cards” or “randomize a given array”.
Let the given array be arr[]. A simple solution is to create an auxiliary array temp[] which is initially a copy of arr[]. Randomly select an element from temp[], copy the randomly selected element to arr[0] and remove the selected element from temp[]. Repeat the same process n times and keep copying elements to arr[1], arr[2], … . The time complexity of this solution will be O(nˆ2).
Fisher–Yates shuﬄe Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates random number in O(1) time. The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last). Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the ﬁrst element.
Following is the detailed algorithm To shuffle an array a of n elements (indices 0..n-1):
for i from n - 1 downto 1 do j = random integer with 0 Following is C++ implementation of this algorithm.

```java
// C Program to shuffle a given array
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// A utility function to swap to integers
void swap (int *a, int *b)
{
int temp = *a;
*a = *b;
*b = temp;
}
// A utility function to print an array
void printArray (int arr[], int n)
{
for (int i = 0; i < n; i++)
printf("%d ", arr[i]);
printf("\n");
}
// A function to generate a random permutation of arr[]
void randomize ( int arr[], int n )
{
// Use a different seed value so that we don't get same
// result each time we run this program
srand ( time(NULL) );
// Start from the last element and swap one by one. We don't
// need to run for the first element that's why i > 0
for (int i = n-1; i > 0; i--)
{
// Pick a random index from 0 to i
int j = rand() % (i+1);
// Swap arr[i] with the element at random index
swap(&arr[i], &arr[j]);
}
}
// Driver program to test above function.
int main()
{
int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
int n = sizeof(arr)/ sizeof(arr[0]);
randomize (arr, n);
printArray(arr, n);
return 0;
}
```

### Output

7 8 4 6 3 1 2 5 The above function assumes that rand() generates a random number.
Time Complexity: O(n), assuming that the function rand() takes O(1) time.
How does this work? The probability that ith element (including the last one) goes to last position is 1/n, because we randomly pick an element in ﬁrst iteration.
The probability that ith element goes to second last position can be proved to be 1/n by dividing it in two cases. Case 1: i = n-1 (index of last element): The probability of last element going to second last position is = (probability that last element doesn’t stay at its original position) x (probability that the index picked in previous step is picked again so that the last element is swapped) So the probability = ((n-1)/n) x (1/(n-1)) = 1/n Case 2: 0 : The probability of ith element going to second position = (probability that ith element is not picked in previous iteration) x (probability that ith element is picked in this iteration) So the probability = ((n-1)/n) x (1/(n-1)) = 1/n We can easily generalize above proof for any other position.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/shuffle-a-given-array/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 25: Space and time eﬃcient Binomial

> **Java Implementation:** [`SpaceAndTimeE.java`](../src/main/java/com/dsamastery/misc/SpaceAndTimeE.java) (`math-and-misc-algorithms`)

Coeﬃcient Write a function that takes two parameters n and k and returns the value of Binomial Coeﬃcient C(n, k).
For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
We have discussed a O(n*k) time and O(k) extra space algorithm in thispost. The value of C(n, k) can be calculated in O(k) time and O(1) extra space.
C(n, k) = n! / (n-k)! * k!
= [n * (n-1) *....* 1] / [ ( (n-k) * (n-k-1) * .... * 1) * ( k * (k-1) * .... * 1 ) ] After simplifying, we get C(n, k) = [n * (n-1) * .... * (n-k+1)] / [k * (k-1) * .... * 1] Also, C(n, k) = C(n, n-k) // we can change r to n-r if r > n-r

```java
Following implementation uses above formula to calculate C(n, k)
// Program to calculate C(n ,k)
#include <stdio.h>
// Returns value of Binomial Coefficient C(n, k)
int binomialCoeff(int n, int k)
{
int res = 1;
// Since C(n, k) = C(n, n-k)
if ( k > n - k )
k = n - k;
// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
for (int i = 0; i < k; ++i)
{
res *= (n - i);
res /= (i + 1);
}
return res;
}
/* Drier program to test above function*/
int main()
{
int n = 8, k = 2;
printf ("Value of C(%d, %d) is %d ", n, k, binomialCoeff(n, k) );
return 0;
}
```

Value of C(8, 2) is 28 Time Complexity: O(k) Auxiliary Space: O(1) This article is compiled by Aashish Barnwaland reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/space-and-time-efficient-binomial-coefficient/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 26: Reservoir Sampling

> **Java Implementation:** [`ReservoirSampling.java`](../src/main/java/com/dsamastery/misc/ReservoirSampling.java) (`math-and-misc-algorithms`)

Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items, where n is either a very large or unknown number. Typically n is large enough that the list doesn’t ﬁt into main memory. For example, a list of search queries in Google and Facebook.
So we are given a big array (or stream) of numbers (to simplify), and we need to write an eﬃcient function to randomly select k numbers where 1 . Let the input array be stream[].
A simple solution is to create an array reservoir[] of maximum size k. One by one randomly select an item from stream[0..n-1]. If the selected item is not previously selected, then put it in reservoir[]. To check if an item is previously selected or not, we need to search the item in reservoir[]. The time complexity of this algorithm will be O(kˆ2). This can be costly if k is big. Also, this is not eﬃcient if the input is in the form of a stream.
It can be solved in O(n) time. The solution also suits well for input in the form of stream. The idea is similar to thispost. Following are the steps.
1) Create an array reservoir[0..k-1] and copy ﬁrst k items of stream[] to it. 2) Now one by one consider all items from (k+1)th item to nth item. …a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j. …b) If j is in range 0 to k-1, replace reservoir[j] with arr[i] Following is C implementation of the above algorithm.

```java
// An efficient program to randomly select k items from a stream of items
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// A utility function to print an array
void printArray(int stream[], int n)
{
for (int i = 0; i < n; i++)
printf("%d ", stream[i]);
printf("\n");
}
// A function to randomly select k items from stream[0..n-1].
void selectKItems(int stream[], int n, int k)
{
int i; // index for elements in stream[]
// reservoir[] is the output array. Initialize it with
// first k elements from stream[]
int reservoir[k];
for (i = 0; i < k; i++)
reservoir[i] = stream[i];
// Use a different seed value so that we don't get
// same result each time we run this program
srand(time(NULL));
// Iterate from the (k+1)th element to nth element
for (; i < n; i++)
{
// Pick a random index from 0 to i.
int j = rand() % (i+1);
// If the randomly picked index is smaller than k, then replace
// the element present at the index with new element from stream
if (j < k)
reservoir[j] = stream[i];
}
printf("Following are k randomly selected items \n");
printArray(reservoir, k);
}
// Driver program to test above function.
int main()
{
int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
int n = sizeof(stream)/sizeof(stream[0]);
int k = 5;
selectKItems(stream, n, k);
return 0;
}
```

### Output

Following are k randomly selected items 6 2 11 8 12 Time Complexity: O(n) How does this work? To prove that this solution works perfectly, we must prove that the probability that any item stream[i] where 0 will be in ﬁnal reservoir[] is k/n. Let us divide the proof in two cases as ﬁrst k items are treated diﬀerently.
Case 1: For last n-k stream items, i.e., for stream[i] where k For every such stream item stream[i], we pick a random index from 0 to i and if the picked index is one of the ﬁrst k indexes, we replace the element at picked index with stream[i] To simplify the proof, let us ﬁrst consider the last item. The probability that the last item is in ﬁnal reservoir = The probability that one of the ﬁrst k indexes is picked for last item = k/n (the probability of picking one of the k items from a list of size n) Let us now consider the second last item. The probability that the second last item is in ﬁnal reservoir[] = [Probability that one of the ﬁrst k indexes is picked in iteration for stream[n-2]] X [Probability that the index picked in iteration for stream[n-1] is not same as index picked for stream[n-2] ] = [k/(n-1)]*[(n-1)/n] = k/n.
Similarly, we can consider other items for all stream items from stream[n-1] to stream[k] and generalize the proof.
Case 2: For ﬁrst k stream items, i.e., for stream[i] where 0 The ﬁrst k items are initially copied to reservoir[] and may be removed later in iterations for stream[k] to stream[n]. The probability that an item from stream[0..k-1] is in ﬁnal array = Probability that the item is not picked when items stream[k], stream[k+1], …. stream[n-1] are considered = [k/(k+1)] x [(k+1)/(k+2)] x [(k+2)/(k+3)] x … x [(n-1)/n] = k/n References: http://en.wikipedia.org/wiki/Reservoir_sampling Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/reservoir-sampling/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 27: Pascal’s Triangle

> **Java Implementation:** [`PascalSTriangle.java`](../src/main/java/com/dsamastery/misc/PascalSTriangle.java) (`math-and-misc-algorithms`)

Pascal’s triangle is a triangular array of the binomial coeﬃcients. Write a function that takes an integer value n as input and prints ﬁrst n lines of the Pascal’s triangle. Following are the ﬁrst 6 rows of Pascal’s Triangle.
1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1 Method 1 ( O(nˆ3) time complexity ) Number of entries in every line is equal to line number. For example, the ﬁrst line has “1”, the second line has “1 1￿, the third line has “1 2 1￿,.. and so on. Every entry in a line is value of a Binomial Coeﬃcient. The value of ith entry in line number line is C(line, i). The value can be calculated using following formula.
C(line, i) = line! / ( (line-i)! * i! ) A simple method is to run two loops and calculate the value of Binomial Coeﬃcient in inner loop.

```java
// A simple O(n^3) program for Pascal's Triangle
#include <stdio.h>
// See http://www.geeksforgeeks.org/archives/25621 for details of this function
int binomialCoeff(int n, int k);
// Function to print first n lines of Pascal's Triangle
void printPascal(int n)
{
// Iterate through every line and print entries in it
for (int line = 0; line < n; line++)
{
// Every line has number of integers equal to line number
for (int i = 0; i <= line; i++)
printf("%d ", binomialCoeff(line, i));
printf("\n");
}
}
// See http://www.geeksforgeeks.org/archives/25621 for details of this function
int binomialCoeff(int n, int k)
{
int res = 1;
if (k > n - k)
k = n - k;
for (int i = 0; i < k; ++i)
{
res *= (n - i);
res /= (i + 1);
}
return res;
}
// Driver program to test above function
int main()
{
int n = 7;
printPascal(n);
return 0;
}
```

Time complexity of this method is O(nˆ3). Following are optimized methods.
Method 2( O(nˆ2) time and O(nˆ2) extra space ) If we take a closer at the triangle, we observe that every entry is sum of the two values above it. So we can create a 2D array that stores previously generated values. To generate a value in a line, we can use the previously stored values from array.

```java
// A O(n^2) time and O(n^2) extra space method for Pascal's Triangle
void printPascal(int n)
{
int arr[n][n]; // An auxiliary array to store generated pscal triangle values
// Iterate through every line and print integer(s) in it
for (int line = 0; line < n; line++)
{
// Every line has number of integers equal to line number
for (int i = 0; i <= line; i++)
{
// First and last values in every row are 1
if (line == i || i == 0)
arr[line][i] = 1;
else // Other values are sum of values just above and left of above
arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
printf("%d ", arr[line][i]);
}
printf("\n");
}
}
```

This method can be optimized to use O(n) extra space as we need values only from previous row. So we can create an auxiliary array of size n and overwrite values. Following is another method uses only O(1) extra space.
Method 3 ( O(nˆ2) time and O(1) extra space ) This method is based on method 1. We know that ith entry in a line number line is Binomial Coeﬃcient C(line, i) and all lines start with value 1. The idea is to calculate C(line, i) using C(line, i-1). It can be calculated in O(1) time using the following.
C(line, i) = line! / ( (line-i)! * i! ) C(line, i-1) = line! / ( (line - i + 1)! * (i-1)! ) We can derive following expression from above two expressions.
C(line, i) = C(line, i-1) * (line - i + 1) / i So C(line, i) can be calculated from C(line, i-1) in O(1) time

```java
// A O(n^2) time and O(1) extra space function for Pascal's Triangle
void printPascal(int n)
{
for (int line = 1; line <= n; line++)
{
int C = 1; // used to represent C(line, i)
for (int i = 1; i <= line; i++)
{
printf("%d ", C); // The first value in a line is always 1
C = C * (line - i) / i;
}
printf("\n");
}
}
```

So method 3 is the best method among all, but it may cause integer overﬂow for large values of n as it multiplies two integers to obtain values.
This article is compiled by Rahul and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/pascal-triangle/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 28: Select a random number from stream,

> **Java Implementation:** [`SelectARandomNumber.java`](../src/main/java/com/dsamastery/misc/SelectARandomNumber.java) (`math-and-misc-algorithms`)

with O(1) space Given a stream of numbers, generate a random number from the stream. You are allowed to use only O(1) space and the input is in the form of stream, so can’t store the previously seen numbers.
So how do we generate a random number from the whole stream such that the probability of picking any number is 1/n. with O(1) extra space? This problem is a variation of Reservoir Sampling. Here the value of k is 1.
1) Initialize ‘count’ as 0, ‘count’ is used to store count of numbers seen so far in stream. 2) For each number ‘x’ from stream, do following …..a) Increment ‘count’ by 1. …..b) If count is 1, set result as x, and return result. …..c) Generate a random number from 0 to ‘count-1￿. Let the generated random number be i. …..d) If i is equal to ‘count – 1￿, update the result as x.

```java
// An efficient program to randomly select a number from stream of numbers.
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// A function to randomly select a item from stream[0], stream[1], .. stream[i-1]
int selectRandom(int x)
{
static int res; // The resultant random number
static int count = 0; //Count of numbers visited so far in stream
count++; // increment count of numbers seen so far
// If this is the first element from stream, return it
if (count == 1)
res = x;
else
{
// Generate a random number from 0 to count - 1
int i = rand() % count;
// Replace the prev random number with new number with 1/count probability
if (i == count - 1)
res = x;
}
return res;
}
// Driver program to test above function.
int main()
{
int stream[] = {1, 2, 3, 4};
int n = sizeof(stream)/sizeof(stream[0]);
// Use a different seed value for every run.
srand(time(NULL));
for (int i = 0; i < n; ++i)
printf("Random number from first %d numbers is %d \n",
i+1, selectRandom(stream[i]));
return 0;
}
```

### Output

Random number from first 1 numbers is 1 Random number from first 2 numbers is 1 Random number from first 3 numbers is 3 Random number from first 4 numbers is 4 Auxiliary Space: O(1) How does this work We need to prove that every element is picked with 1/n probability where n is the number of items seen so far. For every new stream item x, we pick a random number from 0 to ‘count -1￿, if the picked number is ‘count-1￿, we replace the previous result with x.
To simplify proof, let us ﬁrst consider the last element, the last element replaces the previously stored result with 1/n probability. So probability of getting last element as result is 1/n.
Let us now talk about second last element. When second last element processed ﬁrst time, the probability that it replaced the previous result is 1/(n-1). The probability that previous result stays when nth item is considered is (n-1)/n. So probability that the second last element is picked in last iteration is [1/(n-1)] * [(n-1)/n] which is 1/n.
Similarly, we can prove for third last element and others.
References: Reservoir Sampling Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 29: Find the largest multiple of 2, 3 and 5

An array of size n is given. The array contains digits from 0 to 9. Generate the largest number using the digits in the array such that the number is divisible by 2, 3 and 5. For example, if the arrays is {1, 8, 7, 6, 0}, output must be: 8760. And if the arrays is {7, 7, 7, 6}, output must be: “no number can be formed”.
Source: Amazon Interview | Set 7 This problem is a variation of “Find the largest multiple of 3“.
Since the number has to be divisible by 2 and 5, it has to have last digit as 0. So if the given array doesn’t contain any zero, then no solution exists.
Once a 0 is available, extract 0 from the given array. Only thing left is, the number should be is divisible by 3 and the largest of all. Which has been discussed here.
Thanks to shashank for suggesting this solution. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-the-largest-multiple-of-2-3-and-5/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 30: Eﬃcient program to calculate eˆx

> **Java Implementation:** [`ECientProgramTo.java`](../src/main/java/com/dsamastery/misc/ECientProgramTo.java) (`math-and-misc-algorithms`)

The value of Exponential Function eˆx can be expressed using following Taylor Series.
e^x = 1 + x/1! + x^2/2! + x^3/3! + ......
How to eﬃciently calculate the sum of above series? The series can be re-written as e^x = 1 + (x/1) (1 + (x/2) (1 + (x/3) (........) ) ) Let the sum needs to be calculated for n terms, we can calculate sum using following loop.

```java
for (i = n - 1, sum = 1; i > 0; --i )
sum = 1 + x * sum / i;
```

Following is implementation of the above idea.

```java
// Efficient program to calculate e raise to the power x
#include <stdio.h>
//Returns approximate value of e^x using sum of first n terms of Taylor Series
float exponential(int n, float x)
{
float sum = 1.0f; // initialize sum of series
for (int i = n - 1; i > 0; --i )
sum = 1 + x * sum / i;
return sum;
}
// Driver program to test above function
int main()
{
int n = 10;
float x = 1.0f;
printf("e^x = %f", exponential(n, x));
return 0;
}
```

### Output

e^x = 2.718282 This article is compiled by Rahul and reviewed by GeeksforGeeks team. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/program-to-efficiently-calculate-ex/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 31: Measure one litre using two vessels

> **Java Implementation:** [`MeasureOneLitreUsing.java`](../src/main/java/com/dsamastery/misc/MeasureOneLitreUsing.java) (`math-and-misc-algorithms`)

and inﬁnite water suppl There are two vessels of capacities ‘a’ and ‘b’ respectively. We have inﬁnite water supply. Give an eﬃcient algorithm to make exactly 1 litre of water in one of the vessels. You can throw all the water from any vessel any point of time. Assume that ‘a’ and ‘b’ are Coprimes.
Following are the steps: Let V1 be the vessel of capacity ‘a’ and V2 be the vessel of capacity ‘b’ and ‘a’ is smaller than ‘b’. 1) Do following while the amount of water in V1 is not 1. ….a) If V1 is empty, then completely ﬁll V1 ….b) Transfer water from V1 to V2. If V2 becomes full, then keep the remaining water in V1 and empty V2 2) V1 will have 1 litre after termination of loop in step 1. Return.
Following is C++ implementation of the above algorithm.

```java
/* Sample run of the Algo for V1 with capacity 3 and V2 with capacity 7
1. Fill V1: V1 = 3, V2 = 0
2. Transfer from V1 to V2, and fill V1: V1 = 3, V2 = 3
2. Transfer from V1 to V2, and fill V1: V1 = 3, V2 = 6
3. Transfer from V1 to V2, and empty V2: V1 = 2, V2 = 0
4. Transfer from V1 to V2, and fill V1: V1 = 3, V2 = 2
5. Transfer from V1 to V2, and fill V1: V1 = 3, V2 = 5
6. Transfer from V1 to V2, and empty V2: V1 = 1, V2 = 0
7. Stop as V1 now contains 1 litre.
Note that V2 was made empty in steps 3 and 6 because it became full */
#include <iostream>
using namespace std;
// A utility function to get GCD of two numbers
int gcd(int a, int b) { return b? gcd(b, a % b) : a; }
// Class to represent a Vessel
class Vessel
{
// A vessel has capacity, and current amount of water in it
int capacity, current;
public:
// Constructor: initializes capacity as given, and current as 0
Vessel(int capacity) { this->capacity = capacity; current = 0; }
// The main function to fill one litre in this vessel. Capacity of V2
// must be greater than this vessel and two capacities must be co-prime
void makeOneLitre(Vessel &V2);
// Fills vessel with given amount and returns the amount of water
// transferred to it. If the vessel becomes full, then the vessel
// is made empty.
int transfer(int amount);
};
// The main function to fill one litre in this vessel. Capacity
// of V2 must be greater than this vessel and two capacities
// must be coprime
void Vessel:: makeOneLitre(Vessel &V2)
{
// solution exists iff a and b are co-prime
if (gcd(capacity, V2.capacity) != 1)
return;
while (current != 1)
{
// fill A (smaller vessel)
if (current == 0)
current = capacity;
cout << "Vessel 1: " << current << " Vessel 2: "
<< V2.current << endl;
// Transfer water from V1 to V2 and reduce current of V1 by
// the amount equal to transferred water
current = current - V2.transfer(current);
}
// Finally, there will be 1 litre in vessel 1
cout << "Vessel 1: " << current << " Vessel 2: "
<< V2.current << endl;
}
// Fills vessel with given amount and returns the amount of water
// transferred to it. If the vessel becomes full, then the vessel
// is made empty
int Vessel::transfer(int amount)
{
// If the vessel can accommodate the given amount
if (current + amount < capacity)
{
current += amount;
return amount;
}
// If the vessel cannot accommodate the given amount, then
// store the amount of water transferred
int transferred = capacity - current;
// Since the vessel becomes full, make the vessel
// empty so that it can be filled again
current = 0;
return transferred;
}
// Driver program to test above function
int main()
{
int a = 3, b = 7; // a must be smaller than b
// Create two vessels of capacities a and b
Vessel V1(a), V2(b);
// Get 1 litre in first vessel
V1.makeOneLitre(V2);
return 0;
}
```

### Output

Vessel 1: 3 Vessel 2: 0 Vessel 1: 3 Vessel 2: 3 Vessel 1: 3 Vessel 2: 6 Vessel 1: 2 Vessel 2: 0 Vessel 1: 3 Vessel 2: 2 Vessel 1: 3 Vessel 2: 5 Vessel 1: 1 Vessel 2: 0 How does this work?
To prove that the algorithm works, we need to proof that after certain number of iterations in the while loop, we will get 1 litre in V1. Let ‘a’ be the capacity of vessel V1 and ‘b’ be the capacity of V2. Since we repeatedly transfer water from V1 to V2 until V2 becomes full, we will have ‘a – b (mod a)’ water in V1 when V2 becomes full ﬁrst time . Once V2 becomes full, it is emptied. We will have ‘a – 2b (mod a)’ water in V1 when V2 is full second time. We repeat the above steps, and get ‘a – nb (mod a)’ water in V1 after the vessel V2 is ﬁlled and emptied ‘n’ times. We need to prove that the value of ‘a – nb (mod a)’ will be 1 for a ﬁnite integer ‘n’. To prove this, let us consider the following property of coprime numbers. For any two coprime integers ‘a’ and ‘b’, the integer ‘b’ has a multiplicative inverse modulo ‘a’. In other words, there exists an integer ‘y’ such that ‘b*y ￿ 1(mod)a’ (See 3rd point here). After ‘(a – 1)*y’ iterations, we will have ‘a – [(a-1)*y*b (mod a)]’ water in V1, the value of this expression is ‘a – [(a – 1) * 1] mod a’ which is 1. So the algorithm converges and we get 1 litre in V1.
This article is compiled by Aashish Barnwal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/measure-1-litre-from-two-vessels-infinite-water-supply/)
Category: Misc Tags: MathematicalAlgo given number →

[↑ Back to Top](#table-of-contents)

---

## Chapter 32: Eﬃcient program to print all prime

> **Java Implementation:** [`ECientProgramTo2.java`](../src/main/java/com/dsamastery/misc/ECientProgramTo2.java) (`math-and-misc-algorithms`)

factors of a given numbe Given a number n, write an eﬃcient function to print all prime factors of n. For example, if the input number is 12, then output should be “2 2 3￿. And if the input number is 315, then output should be “3 3 5 7￿.
Following are the steps to ﬁnd all prime factors. 1) While n is divisible by 2, print 2 and divide n by 2. 2) After step 1, n must be odd. Now start a loop from i = 3 to square root of n. While i divides n, print i and divide n by i, increment i by 2 and continue. 3) If n is a prime number and is greater than 2, then n will not become 1 by above two steps. So print n if it is greater than 2.

```java
// Program to print all prime factors
```

# include <stdio.h>
# include <math.h>

```java
// A function to print all prime factors of a given number n
void primeFactors(int n)
{
// Print the number of 2s that divide n
while (n%2 == 0)
{
printf("%d ", 2);
n = n/2;
}
// n must be odd at this point. So we can skip one element (Note i = i +2)
for (int i = 3; i <= sqrt(n); i = i+2)
{
// While i divides n, print i and divide n
while (n%i == 0)
{
printf("%d ", i);
n = n/i;
}
}
// This condition is to handle the case whien n is a prime number
// greater than 2
if (n > 2)
printf ("%d ", n);
}
/* Driver program to test above function */
int main()
{
int n = 315;
primeFactors(n);
return 0;
}
```

### Output

3 3 5 7 How does this work? The steps 1 and 2 take care of composite numbers and step 3 takes care of prime numbers. To prove that the complete algorithm works, we need to prove that steps 1 and 2 actually take care of composite numbers. This is clear that step 1 takes care of even numbers. And after step 1, all remaining prime factor must be odd (diﬀerence of two prime factors must be at least 2), this explains why i is incremented by 2. Now the main part is, the loop runs till square root of n not till. To prove that this optimization works, let us consider the following property of composite numbers. Every composite number has at least one prime factor less than or equal to square root of itself. This property can be proved using counter statement. Let a and b be two factors of n such that a*b = n. If both are greater than √n, then a.b
> √n, * √n, which contradicts the expression “a * b = n”.
In step 2 of the above algorithm, we run a loop and do following in loop a) Find the least prime factor i (must be less than √n,) b) Remove all occurrences i from n by repeatedly dividing n by i. c) Repeat steps a and b for divided n and i = i + 2. The steps a and b are repeated till n becomes either 1 or a prime number.
Thanks to Vishwas Garg for suggesting the above algorithm. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 33: Print all possible combinations of r

> **Java Implementation:** [`PrintAllPossibleCombinations.java`](../src/main/java/com/dsamastery/misc/PrintAllPossibleCombinations.java) (`math-and-misc-algorithms`)

elements in a given array of size n Given an array of size n, generate and print all possible combinations of r elements in array. For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
Following are two methods to do this.
Method 1 (Fix Elements and Recur) We create a temporary array ‘data[]’ which stores all outputs one by one. The idea is to start from ﬁrst index (index = 0) in data[], one by one ﬁx elements at this index and recur for remaining indexes. Let the input array be {1, 2, 3, 4, 5} and r be 3. We ﬁrst ﬁx 1 at index 0 in data[], then recur for remaining indexes, then we ﬁx 2 at index 0 and recur. Finally, we ﬁx 3 and recur for remaining indexes. When number of elements in data[] becomes equal to r (size of a combination), we print data[].
Following diagram shows recursion tree for same input.
Following is C++ implementation of above approach.

```java
// Program to print all combination of size r in an array of size n
#include <stdio.h>
void combinationUtil(int arr[], int data[], int start, int end, int index, int r);
// The main function that prints all combinations of size r
// in arr[] of size n. This function mainly uses combinationUtil()
void printCombination(int arr[], int n, int r)
{
// A temporary array to store all combination one by one
int data[r];
// Print all combination using temprary array 'data[]'
combinationUtil(arr, data, 0, n-1, 0, r);
}
/* arr[] ---> Input Array
data[] ---> Temporary array to store current combination
start & end ---> Staring and Ending indexes in arr[]
index ---> Current index in data[]
r ---> Size of a combination to be printed */
void combinationUtil(int arr[], int data[], int start, int end, int index, int r)
{
// Current combination is ready to be printed, print it
if (index == r)
{
for (int j=0; j<r; j++)
printf("%d ", data[j]);
printf("\n");
return;
}
// replace index with all possible elements. The condition
// "end-i+1 >= r-index" makes sure that including one element
// at index will make a combination with remaining elements
// at remaining positions
for (int i=start; i<=end && end-i+1 >= r-index; i++)
{
data[index] = arr[i];
combinationUtil(arr, data, i+1, end, index+1, r);
}
}
// Driver program to test above functions
int main()
{
int arr[] = {1, 2, 3, 4, 5};
int r = 3;
int n = sizeof(arr)/sizeof(arr[0]);
printCombination(arr, n, r);
}
```

### Output

1 2 3 1 2 4 1 2 5 1 3 4 1 3 5 1 4 5 2 3 4 2 3 5 2 4 5 3 4 5 How to handle duplicates? Note that the above method doesn’t handle duplicates. For example, if input array is {1, 2, 1} and r is 2, then the program prints {1, 2} and {2, 1} as two diﬀerent combinations. We can avoid duplicates by adding following two additional things to above code. 1) Add code to sort the array before calling combinationUtil() in printCombination() 2) Add following lines at the end of for loop in

```java
combinationUtil()
// Since the elements are sorted, all occurrences of an element
// must be together
while (arr[i] == arr[i+1])
i++;
```

See thisfor an implementation that handles duplicates.
Method 2 (Include and Exclude every element) Like the above method, We create a temporary array data[]. The idea here is similar to Subset Sum Problem. We one by one consider every element of input array, and recur for two cases:
1) The element is included in current combination (We put the element in data[] and increment next available index in data[]) 2) The element is excluded in current combination (We do not put the element and do not change index) When number of elements in data[] become equal to r (size of a combination), we print it.
This method is mainly based on Pascal’s Identity, i.e. ncr = n-1cr + n-1cr-1 Following is C++ implementation of method 2.

```java
// Program to print all combination of size r in an array of size n
#include<stdio.h>
void combinationUtil(int arr[],int n,int r,int index,int data[],int i);
// The main function that prints all combinations of size r
// in arr[] of size n. This function mainly uses combinationUtil()
void printCombination(int arr[], int n, int r)
{
// A temporary array to store all combination one by one
int data[r];
// Print all combination using temprary array 'data[]'
combinationUtil(arr, n, r, 0, data, 0);
}
/* arr[] ---> Input Array
n ---> Size of input array
r ---> Size of a combination to be printed
index ---> Current index in data[]
data[] ---> Temporary array to store current combination
i ---> index of current element in arr[] */
void combinationUtil(int arr[], int n, int r, int index, int data[], int i)
{
// Current cobination is ready, print it
if (index == r)
{
for (int j=0; j<r; j++)
printf("%d ",data[j]);
printf("\n");
return;
}
// When no more elements are there to put in data[]
if (i >= n)
return;
// current is included, put next at next location
data[index] = arr[i];
combinationUtil(arr, n, r, index+1, data, i+1);
// current is excluded, replace it with next (Note that
// i+1 is passed, but index is not changed)
combinationUtil(arr, n, r, index, data, i+1);
}
// Driver program to test above functions
int main()
{
int arr[] = {1, 2, 3, 4, 5};
int r = 3;
int n = sizeof(arr)/sizeof(arr[0]);
printCombination(arr, n, r);
return 0;
}
```

### Output

1 2 3 1 2 4 1 2 5 1 3 4 1 3 5 1 4 5 2 3 4 2 3 5 2 4 5 3 4 5 How to handle duplicates in method 2? Like method 1, we can following two things to handle duplicates.
1) Add code to sort the array before calling combinationUtil() in printCombination() 2) Add following lines between two recursive calls of combinationUtil() in combinationUtil()

```java
// Since the elements are sorted, all occurrences of an element
// must be together
while (arr[i] == arr[i+1])
i++;
```

See thisfor an implementation that handles duplicates.
This article is contributed by Bateesh. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/)
Category: Arrays Tags: MathematicalAlgo, Recursion

[↑ Back to Top](#table-of-contents)

---

## Chapter 34: Random number generator in

> **Java Implementation:** [`RandomNumberGeneratorIn.java`](../src/main/java/com/dsamastery/misc/RandomNumberGeneratorIn.java) (`math-and-misc-algorithms`)

arbitrary probability distribution fashion Given n numbers, each with some frequency of occurrence. Return a random number with probability proportional to its frequency of occurrence.

### Example

Let following be the given numbers.

```java
arr[] = {10, 30, 20, 40}
```

Let following be the frequencies of given numbers.

```java
freq[] = {1, 6, 2, 1}
```

The output should be 10 with probability 1/10 30 with probability 6/10 20 with probability 2/10 40 with probability 1/10 It is quite clear that the simple random number generator won’t work here as it doesn’t keep track of the frequency of occurrence.
We need to somehow transform the problem into a problem whose solution is known to us.
One simple method is to take an auxiliary array (say aux[]) and duplicate the numbers according to their frequency of occurrence. Generate a random number(say r) between 0 to Sum-1(including both), where Sum represents summation of frequency array (freq[] in above example). Return the random number aux[r] (Implementation of this method is left as an exercise to the readers).
The limitation of the above method discussed above is huge memory consumption when frequency of occur- rence is high. If the input is 997, 8761 and 1, this method is clearly not eﬃcient.
How can we reduce the memory consumption? Following is detailed algorithm that uses O(n) extra space where n is number of elements in input arrays.
1. Take an auxiliary array (say preﬁx[]) of size n. 2. Populate it with preﬁx sum, such that preﬁx[i] represents sum of numbers from 0 to i. 3. Generate a random number(say r) between 1 to Sum(including both), where Sum represents summation of input frequency array. 4. Find index of Ceil of random number generated in step #3 in the preﬁx array. Let the index be indexc. 5. Return the random number arr[indexc], where arr[] contains the input n numbers.
Before we go to the implementation part, let us have quick look at the algorithm with an example: arr[]:
{10, 20, 30} freq[]: {2, 3, 1} Preﬁx[]: {2, 5, 6} Since last entry in preﬁx is 6, all possible values of r are [1, 2, 3, 4, 5, 6] 1: Ceil is 2. Random number generated is 10. 2: Ceil is 2. Random number generated is 10. 3: Ceil is 5. Random number generated is 20. 4: Ceil is 5. Random number generated is 20. 5: Ceil is 5. Random number generated is 20. 6. Ceil is 6. Random number generated is 30. In the above example 10 is generated with probability 2/6. 20 is generated with probability 3/6. 30 is generated with probability 1/6.
How does this work? Any number input[i] is generated as many times as its frequency of occurrence because there exists count of integers in range(preﬁx[i – 1], preﬁx[i]] is input[i]. Like in the above example 3 is generated thrice, as there exists 3 integers 3, 4 and 5 whose ceil is 5.

```java
//C program to generate random numbers according to given frequency distribution
#include <stdio.h>
#include <stdlib.h>
// Utility function to find ceiling of r in arr[l..h]
int findCeil(int arr[], int r, int l, int h)
{
int mid;
while (l < h)
{
mid = l + ((h - l) >> 1); // Same as mid = (l+h)/2
(r > arr[mid]) ? (l = mid + 1) : (h = mid);
}
return (arr[l] >= r) ? l : -1;
}
// The main function that returns a random number from arr[] according to
// distribution array defined by freq[]. n is size of arrays.
int myRand(int arr[], int freq[], int n)
{
// Create and fill prefix array
int prefix[n], i;
prefix[0] = freq[0];
for (i = 1; i < n; ++i)
prefix[i] = prefix[i - 1] + freq[i];
// prefix[n-1] is sum of all frequencies. Generate a random number
// with value from 1 to this sum
int r = (rand() % prefix[n - 1]) + 1;
// Find index of ceiling of r in prefix arrat
int indexc = findCeil(prefix, r, 0, n - 1);
return arr[indexc];
}
// Driver program to test above functions
int main()
{
int arr[] = {1, 2, 3, 4};
int freq[] = {10, 5, 20, 100};
int i, n = sizeof(arr) / sizeof(arr[0]);
// Use a different seed value for every run.
srand(time(NULL));
// Let us generate 10 random numbers accroding to
// given distribution
for (i = 0; i < 5; i++)
printf("%d\n", myRand(arr, freq, n));
return 0;
}
```

Output: May be diﬀerent for diﬀerent runs This article is compiled by Aashish Barnwal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/random-number-generator-in-arbitrary-probability-distribution-fashion/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 35: How to check if a given number is

> **Java Implementation:** [`HowToCheckIf3.java`](../src/main/java/com/dsamastery/misc/HowToCheckIf3.java) (`math-and-misc-algorithms`)

Fibonacci number?
Given a number ‘n’, how to check if n is a Fibonacci number.
A simple way is to generate Fibonacci numbers until the generated number is greater than or equal to ‘n’.
Following is an interesting property about Fibonacci numbers that can also be used to check if a given number is Fibonacci or not. A number is Fibonacci if and only if one or both of (5*n2 + 4) or (5*n2 – 4) is a perfect square (Source: Wiki). Following is a simple program based on this concept.

```java
// C++ program to check if x is a perfect square
#include <iostream>
#include <math.h>
using namespace std;
// A utility function that returns true if x is perfect square
bool isPerfectSquare(int x)
{
int s = sqrt(x);
return (s*s == x);
}
// Returns true if n is a Fibinacci Number, else false
bool isFibonacci(int n)
{
// n is Fibinacci if one of 5*n*n + 4 or 5*n*n - 4 or both
// is a perferct square
return isPerfectSquare(5*n*n + 4) ||
isPerfectSquare(5*n*n - 4);
}
// A utility function to test above functions
int main()
{
for (int i = 1; i <= 10; i++)
isFibonacci(i)? cout << i << " is a Fibonacci Number \n":
cout << i << " is a not Fibonacci Number \n" ;
return 0;
}
```

### Output

1 is a Fibonacci Number 2 is a Fibonacci Number 3 is a Fibonacci Number 4 is a not Fibonacci Number 5 is a Fibonacci Number 6 is a not Fibonacci Number 7 is a not Fibonacci Number 8 is a Fibonacci Number 9 is a not Fibonacci Number 10 is a not Fibonacci Number This article is contributed by Abhay Rathi. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/check-number-fibonacci-number/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 36: Russian Peasant Multiplication

> **Java Implementation:** [`RussianPeasantMultiplication.java`](../src/main/java/com/dsamastery/misc/RussianPeasantMultiplication.java) (`math-and-misc-algorithms`)

Given two integers, write a function to multiply them without using multiplication operator.
There are many other ways to multiply two numbers (For example, see this). One interesting method is the Russian peasant algorithm. The idea is to double the ﬁrst number and halve the second number repeatedly till the second number doesn’t become 1. In the process, whenever the second number become odd, we add the ﬁrst number to result (result is initialized as 0) The following is simple algorithm.
Let the two given numbers be 'a' and 'b' 1) Initialize result 'res' as 0.
2) Do following while 'b' is greater than 0 a) If 'b' is odd, add 'a' to 'res' b) Double 'a' and halve 'b' 3) Return 'res'.

```java
#include <iostream>
using namespace std;
// A method to multiply two numbers using Russian Peasant method
unsigned int russianPeasant(unsigned int a, unsigned int b)
{
int res = 0; // initialize result
// While second number doesn't become 1
while (b > 0)
{
// If second number becomes odd, add the first number to result
if (b & 1)
res = res + a;
// Double the first number and halve the second number
a = a << 1;
b = b >> 1;
}
return res;
}
// Driver program to test above function
int main()
{
cout << russianPeasant(18, 1) << endl;
cout << russianPeasant(20, 12) << endl;
return 0;
}
```

### Output

How does this work? The value of a*b is same as (a*2)*(b/2) if b is even, otherwise the value is same as ((a*2)*(b/2) + a). In the while loop, we keep multiplying ‘a’ with 2 and keep dividing ‘b’ by 2. If ‘b’ becomes odd in loop, we add ‘a’ to ‘res’. When value of ‘b’ becomes 1, the value of ‘res’ + ‘a’, gives us the result. Note that when ‘b’ is a power of 2, the ‘res’ would remain 0 and ‘a’ would have the multiplication.
See the reference for more information.
Reference: http://mathforum.org/dr.math/faq/faq.peasant.html This article is compiled by Shalki Agarwal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/fast-multiplication-method-without-using-multiplication-operator-russian-peasants-algorithm/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 37: Count all possible groups of size 2 or

> **Java Implementation:** [`CountAllPossibleGroups.java`](../src/main/java/com/dsamastery/misc/CountAllPossibleGroups.java) (`math-and-misc-algorithms`)

3 that have sum as multiple of 3 Given an unsorted integer (positive values only) array of size ‘n’, we can form a group of two or three, the group should be such that the sum of all elements in that group is a multiple of 3. Count all possible number of groups that can be generated in this way.

```java
Input: arr[] = {3, 6, 7, 2, 9}
```

Output: 8

```java
// Groups are {3,6}, {3,9}, {9,6}, {7,2}, {3,6,9},
// {3,7,2}, {7,2,6}, {7,2,9}
Input: arr[] = {2, 1, 3, 4}
```

Output: 4

```java
// Groups are {2,1}, {2,4}, {2,1,3}, {2,4,3}
```

We strongly recommend to minimize the browser and try this yourself ﬁrst.
The idea is to see remainder of every element when divided by 3. A set of elements can form a group only if sun of their remainders is multiple of 3. Since the task is to enumerate groups, we count all elements with diﬀerent remainders.
1. Hash all elements in a count array based on remainder, i.e,

```java
for all elements a[i], do c[a[i]%3]++;
```

2. Now c[0] contains the number of elements which when divided by 3 leave remainder 0 and similarly c[1] for remainder 1 and c[2] for 2.
3. Now for group of 2, we have 2 possibilities a. 2 elements of remainder 0 group. Such possibilities are c[0]*(c[0]-1)/2 b. 1 element of remainder 1 and 1 from remainder 2 group Such groups are c[1]*c[2].
4. Now for group of 3,we have 4 possibilities a. 3 elements from remainder group 0.
No. of such groups are c[0]C3 b. 3 elements from remainder group 1.
No. of such groups are c[1]C3 c. 3 elements from remainder group 2.
No. of such groups are c[2]C3 d. 1 element from each of 3 groups.
No. of such groups are c[0]*c[1]*c[2].
5. Add all the groups in steps 3 and 4 to obtain the result.

```java
#include<stdio.h>
// Returns count of all possible groups that can be formed from elements
// of a[].
int findgroups(int arr[], int n)
{
// Create an array C[3] to store counts of elements with remainder
// 0, 1 and 2. c[i] would store count of elements with remainder i
int c[3] = {0}, i;
int res = 0; // To store the result
// Count elements with remainder 0, 1 and 2
for (i=0; i<n; i++)
c[arr[i]%3]++;
// Case 3.a: Count groups of size 2 from 0 remainder elements
res += ((c[0]*(c[0]-1))>>1);
// Case 3.b: Count groups of size 2 with one element with 1
// remainder and other with 2 remainder
res += c[1] * c[2];
// Case 4.a: Count groups of size 3 with all 0 remainder elements
res += (c[0] * (c[0]-1) * (c[0]-2))/6;
// Case 4.b: Count groups of size 3 with all 1 remainder elements
res += (c[1] * (c[1]-1) * (c[1]-2))/6;
// Case 4.c: Count groups of size 3 with all 2 remainder elements
res += ((c[2]*(c[2]-1)*(c[2]-2))/6);
// Case 4.c: Count groups of size 3 with different remainders
res += c[0]*c[1]*c[2];
// Return total count stored in res
return res;
}
// Driver program to test above functions
int main()
{
int arr[] = {3, 6, 7, 2, 9};
int n = sizeof(arr)/sizeof(arr[0]);
printf("Required number of groups are %d\n", findgroups(arr,n));
return 0;
}
```

### Output

Required number of groups are 8 Time Complexity: O(n) Auxiliary Space: O(1) This article is contributed by Amit Jain. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/)
Category: Arrays

[↑ Back to Top](#table-of-contents)

---

## Chapter 38: Horner’s Method for Polynomial

> **Java Implementation:** [`HornerSMethodFor.java`](../src/main/java/com/dsamastery/misc/HornerSMethodFor.java) (`math-and-misc-algorithms`)

Evaluation Given a polynomial of the form cnxn + cn-1xn-1 + cn-2xn-2 + … + c1x + c0 and a value of x, ﬁnd the value of polynomial for a given value of x. Here cn, cn-1, .. are integers (may be negative) and n is a positive integer.
Input is in the form of an array say poly[] where poly[0] represents coeﬃcient for xn and poly[1] represents coeﬃcient for xn-1 and so on.

### Examples

```java
// Evaluate value of 2x3 - 6x2 + 2x - 1 for x = 3
```

Input: poly[] = {2, -6, 2, -1}, x = 3 Output: 5

```java
// Evaluate value of 2x3 + 3x + 1 for x = 2
```

Input: poly[] = {2, 0, 3, 1}, x = 2 Output: 23 A naive way to evaluate a polynomial is to one by one evaluate all terms. First calculate xn, multiply the value with cn, repeat the same steps for other terms and return the sum. Time complexity of this approach is O(n2) if we use a simple loop for evaluation of xn. Time complexity can be improved to O(nLogn) if we use O(Logn) approach for evaluation of xn.
Horner’s method can be used to evaluate polynomial in O(n) time. To understand the method, let us consider the example of 2x3 – 6x2 + 2x – 1. The polynomial can be evaluated as ((2x – 6)x + 2)x – 1. The idea is to initialize result as coeﬃcient of xn which is 2 in this case, repeatedly multiply result with x and add next coeﬃcient to result. Finally return result.
Following is C++ implementation of Horner’s Method.

```java
#include <iostream>
using namespace std;
// returns value of poly[0]x(n-1) + poly[1]x(n-2) + .. + poly[n-1]
int horner(int poly[], int n, int x)
{
int result = poly[0]; // Initialize result
// Evaluate value of polynomial using Horner's method
for (int i=1; i<n; i++)
result = result*x + poly[i];
return result;
}
// Driver program to test above function.
int main()
{
// Let us evaluate value of 2x3 - 6x2 + 2x - 1 for x = 3
int poly[] = {2, -6, 2, -1};
int x = 3;
int n = sizeof(poly)/sizeof(poly[0]);
cout << "Value of polynomial is " << horner(poly, n, x);
return 0;
}
```

### Output

Value of polynomial is 5 Time Complexity: O(n) Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/horners-method-polynomial-evaluation/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 39: Count trailing zeroes in factorial of a

> **Java Implementation:** [`CountTrailingZeroesIn.java`](../src/main/java/com/dsamastery/misc/CountTrailingZeroesIn.java) (`math-and-misc-algorithms`)

number Given an integer n, write a function that returns count of trailing zeroes in n!.

### Examples

Input: n = 5 Output: 1 Factorial of 5 is 20 which has one trailing 0.
Input: n = 20 Output: 4 Factorial of 20 is 2432902008176640000 which has 4 trailing zeroes.
Input: n = 100 Output: 24 A simple method is to ﬁrst calculate factorial of n, then count trailing 0s in the result (We can count trailing 0s by repeatedly dividing the factorial by 10 till the remainder is 0).
The above method can cause overﬂow for a slightly bigger numbers as factorial of a number is a big number (See factorial of 20 given in above examples). The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. If we can count the number of 5s and 2s, our task is done.
Consider the following examples.
n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So count of trailing 0s is 1.
n = 11: There are two 5s and three 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So count of trailing 0s is 2.
We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done. How to count total number of 5s in prime factors of n!?
A simple way is to calculate ﬂoor(n/5). For example, 7! has one 5, 10! has two 5s. It is done yet, there is one more thing to consider. Numbers like 25, 125, etc have more than one 5. For example if we consider 28!, we get one extra 5 and number of 0s become 6. Handling this is simple, ﬁrst divide n by 5 and remove all single 5s, then divide by 25 to remove extra 5s and so on. Following is the summarized formula for counting trailing 0s.
Trailing 0s in n! = Count of 5s in prime factors of n!
= floor(n/5) + floor(n/25) + floor(n/125) + ....
Following is C++ program based on above formula.

```java
// C++ program to count trailing 0s in n!
#include <iostream>
using namespace std;
// Function to return trailing 0s in factorial of n
int findTrailingZeros(int n)
{
// Initialize result
int count = 0;
// Keep dividing n by powers of 5 and update count
for (int i=5; n/i>=1; i *= 5)
count += n/i;
return count;
}
// Driver program to test above function
int main()
{
int n = 100;
cout << "Count of trailing 0s in " << 100
<< "! is " << findTrailingZeros(n);
return 0;
}
```

### Output

Count of trailing 0s in 100! is 24 This article is contributed by Rahul Jain. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 40: Program for nth Catalan Number

> **Java Implementation:** [`ProgramForNthCatalan.java`](../src/main/java/com/dsamastery/misc/ProgramForNthCatalan.java) (`math-and-misc-algorithms`)

Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
2) Count the number of possible Binary Search Trees with n keys (See this) 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
See thisfor more applications.
The ﬁrst few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, … RecursiveSolutionCatalannumberssatisfythefollowingrecursiveformula.
Following is C++ implementation of above recursive formula.

```java
#include<iostream>
using namespace std;
// A recursive function to find nth catalan number
unsigned long int catalan(unsigned int n)
{
// Base case
if (n <= 1) return 1;
// catalan(n) is sum of catalan(i)*catalan(n-i-1)
unsigned long int res = 0;
for (int i=0; i<n; i++)
res += catalan(i)*catalan(n-i-1);
return res;
}
// Driver program to test above function
int main()
{
for (int i=0; i<10; i++)
cout << catalan(i) << " ";
return 0;
}
```

Output :
1 1 2 5 14 42 132 429 1430 4862 Timecomplexityofaboveimplementationisequivalenttonthcatalannumber.
The value of nth catalan number is exponential that makes the time complexity exponential.
Dynamic Programming Solution We can observe that the above recursive implementation does a lot of repeated work (we can the same by drawing recursion tree). Since there are overlapping subproblems, we can use dynamic programming for this. Following is a Dynamic programming based implementation in C++.

```java
#include<iostream>
using namespace std;
// A dynamic programming based function to find nth
// Catalan number
unsigned long int catalanDP(unsigned int n)
{
// Table to store results of subproblems
unsigned long int catalan[n+1];
// Initialize first two values in table
catalan[0] = catalan[1] = 1;
// Fill entries in catalan[] using recursive formula
for (int i=2; i<=n; i++)
{
catalan[i] = 0;
for (int j=0; j<i; j++)
catalan[i] += catalan[j] * catalan[i-j-1];
}
// Return last entry
return catalan[n];
}
// Driver program to test above function
int main()
{
for (int i = 0; i < 10; i++)
cout << catalanDP(i) << " ";
return 0;
}
```

### Output

1 1 2 5 14 42 132 429 1430 4862 Time Complexity: Time complexity of above implementation is O(n2) Using Binomial Coeﬃcient We can also use the below formula to ﬁnd nth catalan number in O(n) time.
We have discussed aO(n) approach to ﬁnd binomial coeﬃcient nCr.

```java
#include<iostream>
using namespace std;
// Returns value of Binomial Coefficient C(n, k)
unsigned long int binomialCoeff(unsigned int n, unsigned int k)
{
unsigned long int res = 1;
// Since C(n, k) = C(n, n-k)
if (k > n - k)
k = n - k;
// Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
for (int i = 0; i < k; ++i)
{
res *= (n - i);
res /= (i + 1);
}
return res;
}
// A Binomial coefficient based function to find nth catalan
// number in O(n) time
unsigned long int catalan(unsigned int n)
{
// Calculate value of 2nCn
unsigned long int c = binomialCoeff(2*n, n);
// return 2nCn/(n+1)
return c/(n+1);
}
// Driver program to test above functions
int main()
{
for (int i = 0; i < 10; i++)
cout << catalan(i) << " ";
return 0;
}
```

### Output

1 1 2 5 14 42 132 429 1430 4862 Time Complexity: Time complexity of above implementation is O(n).
WecanalsousebelowformulatoﬁndnthcatalannumberinO(n)time.
References: http://en.wikipedia.org/wiki/Catalan_number Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/program-nth-catalan-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 41: Write a function that generates one of

> **Java Implementation:** [`WriteAFunctionThat.java`](../src/main/java/com/dsamastery/misc/WriteAFunctionThat.java) (`math-and-misc-algorithms`)

3 numbers according to given probabilities You are given a function rand(a, b) which generates equiprobable random numbers between [a, b] inclusive.
Generate 3 numbers x, y, z with probability P(x), P(y), P(z) such that P(x) + P(y) + P(z) = 1 using the given rand(a,b) function.
The idea is to utilize the equiprobable feature of the rand(a,b) provided. Let the given probabilities be in percentage form, for example P(x)=40%, P(y)=25%, P(z)=35%..
Following are the detailed steps. 1) Generate a random number between 1 and 100. Since they are equiprob- able, the probability of each number appearing is 1/100. 2) Following are some important points to note about generated random number ‘r’. a) ‘r’ is smaller than or equal to P(x) with probability P(x)/100. b) ‘r’ is greater than P(x) and smaller than or equal P(x) + P(y) with P(y)/100. c) ‘r’ is greater than P(x) + P(y) and smaller than or equal 100 (or P(x) + P(y) + P(z)) with probability P(z)/100.

```java
// This function generates 'x' with probability px/100, 'y' with
// probability py/100 and 'z' with probability pz/100:
// Assumption: px + py + pz = 100 where px, py and pz lie
// between 0 to 100
int random(int x, int y, int z, int px, int py, int pz)
{
// Generate a number from 1 to 100
int r = rand(1, 100);
// r is smaller than px with probability px/100
if (r <= px)
return x;
// r is greater than px and smaller than or equal to px+py
// with probability py/100
if (r <= (px+py))
return y;
// r is greater than px+py and smaller than or equal to 100
// with probability pz/100
else
return z;
}
```

This function will solve the purpose of generating 3 numbers with given three probabilities.
This article is contributed by Harsh Agarwal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/write-a-function-to-generate-3-numbers-according-to-given-probabilities/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 42: Find Excel column name from a given

> **Java Implementation:** [`FindExcelColumnName.java`](../src/main/java/com/dsamastery/misc/FindExcelColumnName.java) (`math-and-misc-algorithms`)

column number MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB …..
etc. In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”.
Given a column number, ﬁnd its corresponding Excel column name. Following are more examples.
Input Output 26 Z 51 AY 52 AZ 80 CB 676 YZ 702 ZZ 705 AAC We strongly recommend to minimize the browser and try this yourself ﬁrst.
Thanks to Mrigank Dembla for suggesting the below solution in a comment.
Suppose we have a number n, let’s say 28. so corresponding to it we need to print the column name. We need to take remainder with 26.
If remainder with 26 comes out to be 0 (meaning 26, 52 and so on) then we put ‘Z’ in the output string and

```java
new n becomes n/26 -1 because here we are considering 26 to be ‘Z’ while in actual it’s 25th with respect to
```

‘A’.
Similarly if the remainder comes out to be non zero. (like 1, 2, 3 and so on) then we need to just insert the

```java
char accordingly in the string and do n = n/26.
```

Finally we reverse the string and print.
Example: n = 700 Remainder (n%26) is 24. So we put ‘X’ in output string and n becomes n/26 which is 26.
Remainder (26%26) is 0. So we put ‘Z’ in output string and n becomes n/26 -1 which is 0.
Following is C++ implementation of above approach.

```java
#include<iostream>
#include<cstring>
#define MAX 50
using namespace std;
// Function to print Excel column name for a given column number
void printString(int n)
{
char str[MAX]; // To store result (Excel column name)
int i = 0; // To store current index in str which is result
while (n>0)
{
// Find remainder
int rem = n%26;
// If remainder is 0, then a 'Z' must be there in output
if (rem==0)
{
str[i++] = 'Z';
n = (n/26)-1;
}
else // If remainder is non-zero
{
str[i++] = (rem-1) + 'A';
n = n/26;
}
}
str[i] = '\0';
// Reverse the string and print result
cout << strrev(str) << endl;
return;
}
// Driver program to test above function
int main()
{
printString(26);
printString(51);
printString(52);
printString(80);
printString(676);
printString(702);
printString(705);
return 0;
}
```

Output Z AY AZ CB YZ ZZ AAC This article is contributed by Kartik. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-excel-column-name-given-number/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 43: Find next greater number with same

> **Java Implementation:** [`FindNextGreaterNumber.java`](../src/main/java/com/dsamastery/misc/FindNextGreaterNumber.java) (`math-and-misc-algorithms`)

set of digits Given a number n, ﬁnd the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.
Examples: For simplicity of implementation, we have considered input number as a string.
Input: n = "218765" Output: "251678" Input: n = "1234" Output: "1243" Input: n = "4321" Output: "Not Possible" Input: n = "534976" Output: "536479" We strongly recommend to minimize the browser and try this yourself ﬁrst.
Following are few observations about the next greater number. 1) If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321. 2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234. 3) For other cases, we need to process the number from

```java
rightmost side (why? because we need to ﬁnd the smallest of all greater numbers)
```

You can now try developing an algorithm yourself.
Following is the algorithm for ﬁnding the next greater number. I) Traverse the given number from rightmost digit, keep traversing till you ﬁnd a digit which is smaller than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9. If we do not ﬁnd such a digit, then output is “Not Possible”.
II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. For “534976￿, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.
III) Swap the above found two digits, we get 536974 in above example.
IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
Following is C++ implementation of above approach.

```java
// C++ program to find the smallest number which greater than a given number
// and has same set of digits as given number
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
// Utility function to swap two digits
void swap(char *a, char *b)
{
char temp = *a;
*a = *b;
*b = temp;
}
// Given a number as a char array number[], this function finds the
// next greater number. It modifies the same array to store the result
void findNext(char number[], int n)
{
int i, j;
// I) Start from the right most digit and find the first digit that is
// smaller than the digit next to it.
for (i = n-1; i > 0; i--)
if (number[i] > number[i-1])
break;
// If no such digit is found, then all digits are in descending order
// means there cannot be a greater number with same set of digits
if (i==0)
{
cout << "Next number is not possible";
return;
}
// II) Find the smallest digit on right side of (i-1)'th digit that is
// greater than number[i-1]
int x = number[i-1], smallest = i;
for (j = i+1; j < n; j++)
if (number[j] > x && number[j] < number[smallest])
smallest = j;
// III) Swap the above found smallest digit with number[i-1]
swap(&number[smallest], &number[i-1]);
// IV) Sort the digits after (i-1) in ascending order
sort(number + i, number + n);
cout << "Next number with same set of digits is " << number;
return;
}
// Driver program to test above function
int main()
{
char digits[] = "534976";
int n = strlen(digits);
findNext(digits, n);
return 0;
}
```

### Output

Next number with same set of digits is 536479 The above implementation can be optimized in following ways. 1) We can use binary search in step II instead of linear search. 2) In step IV, instead of doing simple sort, we can apply some clever technique to do it in linear time. Hint: We know that all digits are linearly sorted in reverse order except one digit which was swapped.
With above optimizations, we can say that the time complexity of this method is O(n).
This article is contributed by Rahul Jain. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-next-greater-number-set-digits/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 44: Count Possible Decodings of a given

> **Java Implementation:** [`CountPossibleDecodingsOf.java`](../src/main/java/com/dsamastery/misc/CountPossibleDecodingsOf.java) (`math-and-misc-algorithms`)

Digit Sequence Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.

### Examples

Input: digits[] = "121" Output: 3

```java
// The possible decodings are "ABA", "AU", "LA"
```

Input: digits[] = "1234" Output: 3

```java
// The possible decodings are "ABCD", "LCD", "AWD"
```

An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and there are no leading 0’s, no extra trailing 0’s and no two or more consecutive 0’s.
We strongly recommend to minimize the browser and try this yourself ﬁrst.
This problem is recursive and can be broken in sub-problems. We start from end of the given digit sequence.
We initialize the total count of decodings as 0. We recur for two subproblems. 1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count. 2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.
Following is C++ implementation of the above approach.

```java
// A naive recursive C++ implementation to count number of decodings
// that can be formed from a given digit sequence
#include <iostream>
#include <cstring>
using namespace std;
// Given a digit sequence of length n, returns count of possible
// decodings by replacing 1 with A, 2 woth B, ... 26 with Z
int countDecoding(char *digits, int n)
{
// base cases
if (n == 0 || n == 1)
return 1;
int count = 0; // Initialize count
// If the last digit is not 0, then last digit must add to
// the number of words
if (digits[n-1] > '0')
count = countDecoding(digits, n-1);
// If the last two digits form a number smaller than or equal to 26,
// then consider last two digits and recur
if (digits[n-2] < '2' || (digits[n-2] == '2' && digits[n-1] < '7') )
count += countDecoding(digits, n-2);
return count;
}
// Driver program to test above function
int main()
{
char digits[] = "1234";
int n = strlen(digits);
cout << "Count is " << countDecoding(digits, n);
return 0;
}
```

### Output

Count is 3 The time complexity of above the code is exponential. If we take a closer look at the above program, we can observe that the recursive solution is similar to Fibonacci Numbers. Therefore, we can optimize the above solution to work in O(n) time using Dynamic Programming. Following is C++ implementation for the same.

```java
// A Dynamic Programming based C++ implementation to count decodings
#include <iostream>
#include <cstring>
using namespace std;
// A Dynamic Programming based function to count decodings
int countDecodingDP(char *digits, int n)
{
int count[n+1]; // A table to store results of subproblems
count[0] = 1;
count[1] = 1;
for (int i = 2; i <= n; i++)
{
count[i] = 0;
// If the last digit is not 0, then last digit must add to
// the number of words
if (digits[i-1] > '0')
count[i] = count[i-1];
// If second last digit is smaller than 2 and last digit is
// smaller than 7, then last two digits form a valid character
if (digits[i-2] < '2' || (digits[i-2] == '2' && digits[i-1] < '7') )
count[i] += count[i-2];
}
return count[n];
}
// Driver program to test above function
int main()
{
char digits[] = "1234";
int n = strlen(digits);
cout << "Count is " << countDecodingDP(digits, n);
return 0;
}
```

### Output

Count is 3 Time Complexity of the above solution is O(n) and it requires O(n) auxiliary space. We can reduce auxiliary space to O(1) by using space optimized version discussed in the Fibonacci Number Post.
Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/)
Category: Strings Tags: Dynamic Programming, Fibonacci numbers, MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 45: Calculate the angle between hour

> **Java Implementation:** [`CalculateTheAngleBetween.java`](../src/main/java/com/dsamastery/misc/CalculateTheAngleBetween.java) (`math-and-misc-algorithms`)

hand and minute hand This problem is know as Clock angle problem where we need to ﬁnd angle between hands of an analog clock at .

### Examples

Input: h = 12:00, m = 30.00 Output: 165 degree Input: h = 3.00, m = 30.00 Output: 75 degree The idea is to take 12:00 (h = 12, m = 0) as a reference. Following are detailed steps.
1) Calculate the angle made by hour hand with respect to 12:00 in h hours and m minutes. 2) Calculate the angle made by minute hand with respect to 12:00 in h hours and m minutes. 3) The diﬀerence between two angles is the angle between two hands.
How to calculate the two angles with respect to 12:00? The minute hand moves 360 degree in 60 minute(or 6 degree in one minute) and hour hand moves 360 degree in 12 hours(or 0.5 degree in 1 minute).
In h hours and m minutes, the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.

```java
// C program to find angle between hour and minute hands
#include <stdio.h>
#include <stdlib.h>
// Utility function to find minimum of two integers
int min(int x, int y) { return (x < y)? x: y; }
int calcAngle(double h, double m)
{
// validate the input
if (h <0 || m < 0 || h >12 || m > 60)
printf("Wrong input");
if (h == 12) h = 0;
if (m == 60) m = 0;
// Calculate the angles moved by hour and minute hands
// with reference to 12:00
int hour_angle = 0.5 * (h*60 + m);
int minute_angle = 6*m;
// Find the difference between two angles
int angle = abs(hour_angle - minute_angle);
// Return the smaller angle of two possible angles
angle = min(360-angle, angle);
return angle;
}
// Driver program to test above function
int main()
{
printf("%d \n", calcAngle(9, 60));
printf("%d \n", calcAngle(3, 30));
return 0;
}
```

### Output

Exercise: Find all times when hour and minute hands get superimposed.
This article is contributed by Ashish Bansal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/calculate-angle-hour-hand-minute-hand/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 46: Count number of binary strings

> **Java Implementation:** [`CountNumberOfBinary.java`](../../arrays-strings/src/main/java/com/dsamastery/arrays/CountNumberOfBinary.java) (`arrays-strings`)

without consecutive 1’s Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

### Examples

Input: N = 2 Output: 3

```java
// The 3 strings are 00, 01, 10
```

Input: N = 3 Output: 5

```java
// The 5 strings are 000, 001, 010, 100, 101
```

This problem can be solved using Dynamic Programming. Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s and which end in 0. Similarly, let b[i] be the number of such strings which end in 1. We can append either 0 or 1 to a string ending in 0, but we can only append 0 to a string ending in 1. This yields the recurrence relation:
a[i] = a[i - 1] + b[i - 1] b[i] = a[i - 1] The base cases of above recurrence are a[1] = b[1] = 1. The total number of strings of length i is just a[i] + b[i].
Following is C++ implementation of above solution. In the following implementation, indexes start from 0.
So a[i] represents the number of binary strings for input length i+1. Similarly, b[i] represents binary strings for input length i+1.

```java
// C++ program to count all distinct binary strings
// without two consecutive 1's
#include <iostream>
using namespace std;
int countStrings(int n)
{
int a[n], b[n];
a[0] = b[0] = 1;
for (int i = 1; i < n; i++)
{
a[i] = a[i-1] + b[i-1];
b[i] = a[i-1];
}
return a[n-1] + b[n-1];
}
// Driver program to test above functions
int main()
{
cout << countStrings(3) << endl;
return 0;
}
```

### Output

Source: courses.csail.mit.edu/6.006/oldquizzes/solutions/q2-f2009-sol.pdf This article is contributed by Rahul Jain. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/)
Category: Arrays Tags: Dynamic Programming

[↑ Back to Top](#table-of-contents)

---

## Chapter 47: Find the smallest number whose

> **Java Implementation:** [`FindTheSmallestNumber.java`](../src/main/java/com/dsamastery/misc/FindTheSmallestNumber.java) (`math-and-misc-algorithms`)

digits multiply to a given number n Given a number ‘n’, ﬁnd the smallest number ‘p’ such that if we multiply all digits of ‘p’, we get ‘n’. The result ‘p’ should have minimum two digits.

### Examples

Input: n = 36 Output: p = 49

```java
// Note that 4*9 = 36 and 49 is the smallest such number
```

Input: n = 100 Output: p = 455

```java
// Note that 4*5*5 = 100 and 455 is the smallest such number
```

Input: n = 1 Output:p = 11

```java
// Note that 1*1 = 1
```

Input: n = 13 Output: Not Possible For a given n, following are the two cases to be considered. Case 1: n When n is smaller than n, the output is always n+10. For example for n = 7, output is 17. For n = 9, output is 19.
Case 2: n >= 10 Find all factors of n which are between 2 and 9 (both inclusive). The idea is to start searching from 9 so that the number of digits in result are minimized. For example 9 is preferred over 33 and 8 is preferred over 24. Store all found factors in an array. The array would contain digits in non-increasing order, so ﬁnally print the array in reverse order.
Following is C implementation of above concept.

```java
#include<stdio.h>
// Maximum number of digits in output
#define MAX 50
// prints the smallest number whose digits multiply to n
void findSmallest(int n)
{
int i, j=0;
int res[MAX]; // To sore digits of result in reverse order
// Case 1: If number is smaller than 10
if (n < 10)
{
printf("%d", n+10);
return;
}
// Case 2: Start with 9 and try every possible digit
for (i=9; i>1; i--)
{
// If current digit divides n, then store all
// occurrences of current digit in res
while (n%i == 0)
{
n = n/i;
res[j] = i;
j++;
}
}
// If n could not be broken in form of digits (prime factors of n
// are greater than 9)
if (n > 10)
{
printf("Not possible");
return;
}
// Print the result array in reverse order
for (i=j-1; i>=0; i--)
printf("%d", res[i]);
}
// Driver program to test above function
int main()
{
findSmallest(7);
printf("\n");
findSmallest(36);
printf("\n");
findSmallest(13);
printf("\n");
findSmallest(100);
return 0;
}
```

### Output

Not possible This article is contributed by Ashish Bansal. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given-number-n/)
Category: Misc Tags: MathematicalAlgo

[↑ Back to Top](#table-of-contents)

---

## Chapter 48: How to check if an instance of 8

> **Java Implementation:** [`HowToCheckIf4.java`](../src/main/java/com/dsamastery/misc/HowToCheckIf4.java) (`math-and-misc-algorithms`)

puzzle is solvable?
What is 8 puzzle? Given a 3×3 board with 8 tiles (every tile has one number from 1 to 8) and one empty space. The objective is to place the numbers on tiles in order using the empty space. We can slide four adjacent (left, right, above and below) tiles into the empty space.
How to ﬁnd if given state is solvable? Following are two examples, the ﬁrst example can reach goal state byaseriesofslides. Thesecondexamplecannot.
Following is simple rule to check if a 8 puzzle is solvable. It is not possible to solve an instance of 8 puzzle if number of inversions is odd in the input state. In the examples given in above ﬁgure, the ﬁrst example has 10 inversions, therefore solvable. The second example has 11 inversions, therefore unsolvable.
What is inversion? A pair of tiles form an inversion if the the values on tiles are in reverse order of their appearance in goal state. For example, the following instance of 8 puzzle has two inversions, (8, 6) and (8, 7).
1 2 3 4 _ 5 8 6 7 Following is a simple C++ program to check whether a given instance of 8 puzzle is solvable or not. The idea is simple, we count inversions in the given 8 puzzle.

```java
// C++ program to check if a given instance of 8 puzzle is solvable or not
#include <iostream>
using namespace std;
// A utility function to count inversions in given array 'arr[]'
int getInvCount(int arr[])
{
int inv_count = 0;
for (int i = 0; i < 9 - 1; i++)
for (int j = i+1; j < 9; j++)
// Value 0 is used for empty space
if (arr[j] && arr[i] && arr[i] > arr[j])
inv_count++;
return inv_count;
}
// This function returns true if given 8 puzzle is solvable.
bool isSolvable(int puzzle[3][3])
{
// Count inversions in given 8 puzzle
int invCount = getInvCount((int *)puzzle);
// return true if inversion count is even.
return (invCount%2 == 0);
}
/* Driver progra to test above functions */
int main(int argv, int** args)
{
int puzzle[3][3] = {{1, 8, 2},
{0, 4, 3}, // Value 0 is used for empty space
{7, 6, 5}};
isSolvable(puzzle)? cout << "Solvable":
cout << "Not Solvable";
return 0;
}
```

### Output

Solvable Note that the above implementation uses simple algorithm for inversion count. It is done this way for simplicity. The code can be optimized to O(nLogn) using the merge sort based algorithm for inversion count.
How does this work? The idea is based on the fact the parity of inversions remains same after a set of moves, i.e., if the inversion count is odd in initial stage, then it remain odd after any sequence of moves and if the inversion count is even, then it remains even after any sequence of moves. In the goal state, there are 0 inversions. So we can reach goal state only from a state which has even inversion count.
How parity of inversion count is invariant? When we slide a tile, we either make a row move (moving a left or right tile into the blank space), or make a column move (moving a up or down tile to the blank space).
a) A row move doesn’t change the inversion count. See following example 1 2 3 Row Move 1 2 3 4 _ 5 ----------> _ 4 5 8 6 7 8 6 7 Inversion count remains 2 after the move 1 2 3 Row Move 1 2 3 4 _ 5 ----------> 4 5 _ 8 6 7 8 6 7 Inversion count remains 2 after the move b) A column move does one of the following three. …..(i) Increases inversion count by 2. See following example.
1 2 3 Column Move 1 _ 3 4 _ 5 -----------> 4 2 5 8 6 7 8 6 7

```java
Inversion count increases by 2 (changes from 2 to 4)
```

…..(ii) Decreases inversion count by 2 1 3 4 Column Move 1 3 4 5 _ 6 ------------> 5 2 6 7 2 8 7 _ 8

```java
Inversion count decreases by 2 (changes from 5 to 3)
```

…..(iii) Keeps the inversion count same.
1 2 3 Column Move 1 2 3 4 _ 5 ------------> 4 6 5 7 6 8 7 _ 8 Inversion count remains 1 after the move So if a move either increases/decreases inversion count by 2, or keeps the inversion count same, then it is not possible to change parity of a state by any sequence of row/column moves.
Exercise: How to check if a given instance of 15 puzzle is solvable or not. In a 15 puzzle, we have 4×4 board where 15 tiles have a number and one empty space. Note that the above simple rules of inversion count don’t directly work for 15 puzzle, the rules need to be modiﬁed for 15 puzzle.
This article is contributed by Ishan. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 49: Birthday Paradox

> **Java Implementation:** [`BirthdayParadox.java`](../src/main/java/com/dsamastery/misc/BirthdayParadox.java) (`math-and-misc-algorithms`)

How many people must be there in a room to make the probability 100% that two people in the room have same birthday? Answer: 367 (since there are 366 possible birthdays, including February 29). The above question was simple. Try the below question yourself.
How many people must be there in a room to make the probability 50% that two people in the room have same birthday? Answer: 23 The number is surprisingly very low. In fact, we need only 70 people to make the probability 99.9 %.
Let us discuss the generalized formula.
What is the probability that two persons among n have same birthday? Let the probability that two people in a room with n have same birthday be P(same). P(Same) can be easily evaluated in terms of P(diﬀerent) where P(diﬀerent) is the probability that all of them have diﬀerent birthday.
P(same) = 1 – P(diﬀerent) P(diﬀerent) can be written as 1 x (364/365) x (363/365) x (362/365) x …. x (1 – (n-1)/365) How did we get the above expression? Persons from ﬁrst to last can get birthdays in following order for all birthdays to be distinct: The ﬁrst person can have any birthday among 365 The second person should have a birthday which is not same as ﬁrst person The third person should have a birthday which is not same as ﬁrst two persons. ……………. …………… The n’th person should have a birthday which is not same as any of the earlier considered (n-1) persons.
Approximation of above expression The above expression can be approximated using Taylor’s Series.
provides a ﬁrst-order approximation for ex for x To apply this approximation to the ﬁrst expression derived for p(diﬀerent), set x = -a / 365. Thus, The above expression derived for p(diﬀerent) can be written as 1 x (1 – 1/365) x (1 – 2/365) x (1 – 3/365) x …. x (1 – (n-1)/365) By putting the value of 1 – a/365 as e-a/365, we get following.
Therefore, p(same) = 1- p(diﬀerent) An even coarser approximation is given by p(same) By taking Log on both sides, we get the reverse formula.
Using the above approximate formula, we can approximate number of people for a given probability. For example the following C++ function ﬁnd() returns the smallest n for which the probability is greater than the given p.
C++ Implementationof approximateformula. The following is C++ program to approximatenumber of people for a given probability.

```java
// C++ program to approximate number of people in Birthday Paradox
// problem
#include <cmath>
#include <iostream>
using namespace std;
// Returns approximate number of people for a given probability
int find(double p)
{
return ceil(sqrt(2*365*log(1/(1-p))));
}
int main()
{
cout << find(0.70);
}
```

### Output

Source: http://en.wikipedia.org/wiki/Birthday_problem Applications: 1) Birthday Paradox is generally discussed with hashing to show importance of collision handling even for a small set of keys. 2) Birthday Attack This article is contributed by Shubham. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/birthday-paradox/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 50: Multiply two polynomials

> **Java Implementation:** [`MultiplyTwoPolynomials.java`](../src/main/java/com/dsamastery/misc/MultiplyTwoPolynomials.java) (`math-and-misc-algorithms`)

Given two polynomials represented by two arrays, write a function that multiplies given two polynomials.

### Example

```java
Input: A[] = {5, 0, 10, 6}
B[] = {1, 2, 4}
Output: prod[] = {5, 10, 30, 26, 52, 24}
```

The first input array represents "5 + 0x^1 + 10x^2 + 6x^3" The second array represents "1 + 2x^1 + 4x^2" And Output is "5 + 10x^1 + 30x^2 + 26x^3 + 52x^4 + 24x^5" We strongly recommend to minimize your browser and try this yourself ﬁrst.
A simple solution is to one by one consider every term of ﬁrst polynomial and multiply it with every term of second polynomial. Following is algorithm of this simple method.

```java
multiply(A[0..m-1], B[0..n01])
```

1) Create a product array prod[] of size m+n-1.
2) Initialize all entries in prod[] as 0.
3) Travers array A[] and do following for every element A[i] ...(3.a) Traverse array B[] and do following for every element B[j] prod[i+j] = prod[i+j] + A[i] * B[j] 4) Return prod[].
The following is C++ implementation of above algorithm.

```java
// Simple C++ program to multiply two polynomials
#include <iostream>
using namespace std;
// A[] represents coefficients of first polynomial
// B[] represents coefficients of second polynomial
// m and n are sizes of A[] and B[] respectively
int *multiply(int A[], int B[], int m, int n)
{
int *prod = new int[m+n-1];
// Initialize the porduct polynomial
for (int i = 0; i<m+n-1; i++)
prod[i] = 0;
// Multiply two polynomials term by term
// Take ever term of first polynomial
for (int i=0; i<m; i++)
{
// Multiply the current term of first polynomial
// with every term of second polynomial.
for (int j=0; j<n; j++)
prod[i+j] += A[i]*B[j];
}
return prod;
}
// A utility function to print a polynomial
void printPoly(int poly[], int n)
{
for (int i=0; i<n; i++)
{
cout << poly[i];
if (i != 0)
cout << "x^" << i ;
if (i != n-1)
cout << " + ";
}
}
// Driver program to test above functions
int main()
{
// The following array represents polynomial 5 + 10x^2 + 6x^3
int A[] = {5, 0, 10, 6};
// The following array represents polynomial 1 + 2x + 4x^2
int B[] = {1, 2, 4};
int m = sizeof(A)/sizeof(A[0]);
int n = sizeof(B)/sizeof(B[0]);
cout << "First polynomial is \n";
printPoly(A, m);
cout << "\nSecond polynomial is \n";
printPoly(B, n);
int *prod = multiply(A, B, m, n);
cout << "\nProduct polynomial is \n";
printPoly(prod, m+n-1);
return 0;
}
```

Output First polynomial is 5 + 0x^1 + 10x^2 + 6x^3 Second polynomial is 1 + 2x^1 + 4x^2 Product polynomial is 5 + 10x^1 + 30x^2 + 26x^3 + 52x^4 + 24x^5 Time complexity of the above solution is O(mn). If size of two polynomials same, then time complexity is O(n2).
Can we do better? There are methods to do multiplication faster than O(n2) time. These methods are mainly based on divide and conquer. Following is one simple method that divides the given polynomial (of degree n) into two polynomials one containing lower degree terms(lower than n/2) and other containing

```java
higher degree terns (higher than or equal to n/2)
```

Let the two given polynomials be A and B.
For simplicity, Let us assume that the given two polynomials are of same degree and have degree in powers of 2, i.e., n = 2i The polynomial 'A' can be written as A0 + A1*xn/2 The polynomial 'B' can be written as B0 + B1*xn/2 For example 1 + 10x + 6x2 - 4x3 + 5x4 can be written as (1 + 10x) + (6 - 4x + 5x2)*x2 A * B = (A0 + A1*xn/2) * (B0 + B1*xn/2) = A0*B0 + A0*B1*xn/2 + A1*B0*xn/2 + A1*B1*xn = A0*B0 + (A0*B1 + A1*B0)xn/2 + A1*B1*xn So the above divide and conquer approach requires 4 multiplications and O(n) time to add all 4 results.
Therefore the time complexity is T(n) = 4T(n/2) + O(n). The solution of the recurrence is O(n2) which is same as the above simple solution.
The idea is to reduce number of multiplications to 3 and make the recurrence as T(n) = 3T(n/2) + O(n) How to reduce number of multiplications? This requires a little trick similar toStrassen’s Matrix Multiplication. We do following 3 multiplications.
X = (A0 + A1)*(B0 + B1) // First Multiplication Y = A0B0 // Second Z = A1B1 // Third The missing middle term in above multiplication equation A0*B0 + (A0*B1 + A1*B0)xn/2 + A1*B1*xn can obtained using below.
A0B1 + A1B0 = X - Y - Z So the time taken by this algorithm is T(n) = 3T(n/2) + O(n) The solution of above recurrence is O(nLg3) which is better than O(n2).
We will soon be discussing implementation of above approach.
There is a O(nLogn) algorithm also that uses Fast Fourier Transform to multiply two polynomials (Refer this and thisfor details) Sources: http://www.cse.ust.hk/~dekai/271/notes/L03/L03.pdf This article is contributed by Harsh. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/multiply-two-polynomials-2/)

[↑ Back to Top](#table-of-contents)

---

## Chapter 51: Count Distinct Non-Negative Integer

> **Java Implementation:** [`CountDistinctNonNegative.java`](../src/main/java/com/dsamastery/misc/CountDistinctNonNegative.java) (`math-and-misc-algorithms`)

Pairs (x, y) that Satisfy the Inequality x*x + y*y Given a positive number n, count all distinct Non-Negative Integer pairs (x, y) that satisfy the inequality x*x + y*y

### Examples

Input: n = 5 Output: 6 The pairs are (0, 0), (0, 1), (1, 0), (1, 1), (2, 0), (0, 2) Input: n = 6 Output: 8 The pairs are (0, 0), (0, 1), (1, 0), (1, 1), (2, 0), (0, 2), (1, 2), (2, 1) A Simple Solution is to run two loops. The outer loop goes for all possible values of x (from 0 to √n).
The inner loops picks all possible values of y for current value of x (picked by outer loop). Following is C++ implementation of simple solution.

```java
#include <iostream>
using namespace std;
// This function counts number of pairs (x, y) that satisfy
// the inequality x*x + y*y < n.
int countSolutions(int n)
{
int res = 0;
for (int x = 0; x*x < n; x++)
for (int y = 0; x*x + y*y < n; y++)
res++;
return res;
}
// Driver program to test above function
int main()
{
cout << "Total Number of distinct Non-Negative pairs is "
<< countSolutions(6) << endl;
return 0;
}
```

### Output

Total Number of distinct Non-Negative pairs is 8 An upper bound for time complexity of the above solution is O(n). The outer loop runs √n times. The inner loop runs at most √n times.
Using an Eﬃcient Solution, we can ﬁnd the count in O(√n) time. The idea is to ﬁrst ﬁnd the count of all y values corresponding the 0 value of x. Let count of distinct y values be yCount. We can ﬁnd yCount by running a loop and comparing yCount*yCount with n. After we have initial yCount, we can one by one increase value of x and ﬁnd the next value of yCount by reducing yCount.

```java
// An efficient C program to find different (x, y) pairs that
// satisfy x*x + y*y < n.
#include <iostream>
using namespace std;
// This function counts number of pairs (x, y) that satisfy
// the inequality x*x + y*y < n.
int countSolutions(int n)
{
int x = 0, yCount, res = 0;
// Find the count of different y values for x = 0.
for (yCount = 0; yCount*yCount < n; yCount++) ;
// One by one increase value of x, and find yCount for
// current x. If yCount becomes 0, then we have reached
// maximum possible value of x.
while (yCount != 0)
{
// Add yCount (count of different possible values of y
// for current x) to result
res += yCount;
// Increment x
x++;
// Update yCount for current x. Keep reducing yCount while
// the inequality is not satisfied.
while (yCount != 0 && (x*x + (yCount-1)*(yCount-1) >= n))
yCount--;
}
return res;
}
// Driver program to test above function
int main()
{
cout << "Total Number of distinct Non-Negative pairs is "
<< countSolutions(6) << endl;
return 0;
}
```

### Output

Total Number of distinct Non-Negative pairs is 8 Time Complexity of the above solution seems more but if we take a closer look, we can see that it is O(√n).
In every step inside the inner loop, value of yCount is decremented by 1. The value yCount can decrement at most O(√n) times as yCount is count y values for x = 0. In the outer loop, the value of x is incremented.
The value of x can also increment at most O(√n) times as the last x is for yCount equals to 1.
This article is contributed by Sachin Gupta. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above.

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-distinct-non-negative-pairs-x-y-satisfy-inequality-xx-yy-n-2/)
Category: Misc Tags: MathematicalAlgo (Oﬀ-Campus for SDE-1) →

[↑ Back to Top](#table-of-contents)

---

## Chapter 52: Count ways to reach the n’th stair

> **Java Implementation:** [`CountWaysToReach.java`](../src/main/java/com/dsamastery/misc/CountWaysToReach.java) (`math-and-misc-algorithms`)

There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
Consider the example shown in diagram. The value of n is 3. There are 3 ways to reach the top. The diagram is taken from Easier Fibonacci puzzles More Examples:
Input: n = 1 Output: 1 There is only one way to climb 1 stair Input: n = 2 Output: 2 There are two ways: (1, 1) and (2) Input: n = 4 Output: 5 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2) We can easily ﬁnd recursive nature in above problem. The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair. Let the total number of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’ can be written as following.
ways(n) = ways(n-1) + ways(n-2) The above expression is actually the expression for Fibonacci numbers, but there is one thing to notice, the value of ways(n) is equal to ﬁbonacci(n+1).
ways(1) = ﬁb(2) = 1 ways(2) = ﬁb(3) = 2 ways(3) = ﬁb(4) = 3 So we can use function for ﬁbonacci numbers to ﬁnd the value of ways(n). Following is C++ implementation of the above idea.

```java
// A C program to count number of ways to reach n't stair when
// a person can climb 1, 2, ..m stairs at a time.
#include<stdio.h>
// A simple recursive program to find n'th fibonacci number
int fib(int n)
{
if (n <= 1)
return n;
return fib(n-1) + fib(n-2);
}
// Returns number of ways to reach s'th stair
int countWays(int s)
{
return fib(s + 1);
}
// Driver program to test above functions
int main ()
{
int s = 4;
printf("Number of ways = %d", countWays(s));
getchar();
return 0;
}
```

### Output

Number of ways = 5 The time complexity of the above implementation is exponential (golden ratio raised to power n). It can be optimized to work in O(Logn) time using the previously discussed Fibonacci function optimizations.
Generalization of the above problem How to count number of ways if the person can climb up to m stairs for a given value m? For example if m is 4, the person can climb 1 stair or 2 stairs or 3 stairs or 4 stairs at a time.
We can write the recurrence as following.
ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m) Following is C++ implementation of above recurrence.

```java
// A C program to count number of ways to reach n't stair when
// a person can climb either 1 or 2 stairs at a time
#include<stdio.h>
// A recursive function used by countWays
int countWaysUtil(int n, int m)
{
if (n <= 1)
return n;
int res = 0;
for (int i = 1; i<=m && i<=n; i++)
res += countWaysUtil(n-i, m);
return res;
}
// Returns number of ways to reach s'th stair
int countWays(int s, int m)
{
return countWaysUtil(s+1, m);
}
// Driver program to test above functions
int main ()
{
int s = 4, m = 2;
printf("Nuber of ways = %d", countWays(s, m));
return 0;
}
```

### Output

Number of ways = 5 The time complexity of above solution is exponential. It can be optimized to O(mn) by using dynamic programming. Following is dynamic programming based solution. We build a table res[] in bottom up manner.

```java
// A C program to count number of ways to reach n't stair when
// a person can climb 1, 2, ..m stairs at a time
#include<stdio.h>
// A recursive function used by countWays
int countWaysUtil(int n, int m)
{
int res[n];
res[0] = 1; res[1] = 1;
for (int i=2; i<n; i++)
{
res[i] = 0;
for (int j=1; j<=m && j<=i; j++)
res[i] += res[i-j];
}
return res[n-1];
}
// Returns number of ways to reach s'th stair
int countWays(int s, int m)
{
return countWaysUtil(s+1, m);
}
// Driver program to test above functions
int main ()
{
int s = 4, m = 2;
printf("Nuber of ways = %d", countWays(s, m));
return 0;
}
```

### Output

Number of ways = 5 This article is contributed by Abhishek. Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic discussed above

### Source

- [Reference Link](http://www.geeksforgeeks.org/count-ways-reach-nth-stair/)

[↑ Back to Top](#table-of-contents)
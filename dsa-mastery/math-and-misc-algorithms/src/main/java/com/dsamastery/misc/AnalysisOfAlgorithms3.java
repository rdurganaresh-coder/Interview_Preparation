package com.dsamastery.misc;

import java.util.*;

public class AnalysisOfAlgorithms {

    // set of non-recursive and non-loop statements
    // Here c is a constant
    for (int i = 1; i
    // Here c is a positive integer constant
    for (int i = 1; i 0; i -= c) {
    // some O(1) expressions
    }
    for (int i = 1; i <=n; i += c) {
    for (int j = 1; j <=n; j += c) {
    // some O(1) expressions
    }
    }
    for (int i = n; i > 0; i += c) {
    for (int j = i+1; j <=n; j += c) {
    // some O(1) expressions
    }
    For example Selection sort and Insertion Sort have O(n2) time complexity.
    4) O(Logn) Time Complexity of a loop is considered as O(Logn) if the loop variables is divided / multiplied
    by a constant amount.
    for (int i = 1; i <=n; i *= c) {
    // some O(1) expressions
    }
    for (int i = n; i > 0; i /= c) {
    // some O(1) expressions
    }
    For example Binary Search(refer iterative implementation) has O(Logn) time complexity.
    5) O(LogLogn) Time Complexity of a loop is considered as O(LogLogn) if the loop variables is reduced /
    increased exponentially by a constant amount.
    // Here c is a constant greater than 1
    for (int i = 2; i <=n; i = pow(i, c)) {
    // some O(1) expressions
    }
    //Here fun is sqrt or cuberoot or any other constant root
    for (int i = n; i > 0; i = fun(i)) {
    // some O(1) expressions
    }
    See thisfor more explanation.
    How to combine time complexities of consecutive loops?
    When there are consecutive loops, we calculate time complexity as sum of time complexities of individual
    loops.
    for (int i = 1; i <=m; i += c) {
    // some O(1) expressions
    }
    for (int i = 1; i <=n; i += c) {
    // some O(1) expressions
    }
    Time complexity of above code is O(m) + O(n) which is O(m+n)
    If m == n, the time complexity becomes O(2n) which is O(n).
    How to calculate time complexity when there are many if, else statements inside loops?
    As discussed here, worst case time complexity is the most useful among best, average and worst. Therefore
    we need to consider worst case. We evaluate the situation when values in if-else conditions cause maximum
    number of statements to be executed.
    For example consider the linear search function where we consider the case when element is present at the
    end or not present at all.
    When the code is too complex to consider all if-else cases, we can get an upper bound by ignoring if else and
    other complex control statements.
    How to calculate time complexity of recursive functions?
    Time complexity of a recursive function can be written as a mathematical recurrence relation. To calculate
    time complexity, we must know how to solve recurrences. We will soon be discussing recurrence solving
    techniques as a separate post.
    Quiz on Analysis of Algorithms
    Please write comments if you ﬁnd anything incorrect, or you want to share more information about the topic
    discussed above.
    Source
    http://www.geeksforgeeks.org/analysis-of-algorithms-set-4-analysis-of-loops/
}

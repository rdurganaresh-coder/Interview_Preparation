package com.dsamastery.misc;

import java.util.*;

public class DfaBasedDivision {

    new state=1 2. state=1, we read 1, new state=0 3. state=0, we read 0, new state=0 Since the ﬁnal state is
    new state=2 3. state=2, we read 0, new state=1 Since, the ﬁnal state is not 0, the number is not divisible
    new read number becomes 2*p+1. The new state can be obtained by subtracting k from these values (2p
    0; isDivisibleUtil(num, &state, Table); // Note that the ﬁnal value of state is the remainder return state; }
    // Driver program to test above functions int main() { int num = 47; // Number to be divided int k = 5;
    // Divisor int remainder = isDivisible (num, k); if (remainder == 0) System.out.printf(“Divisible\n”); else System.out.printf(“Not
    Divisible: Remainder is %d\n”, remainder); return 0; }
}

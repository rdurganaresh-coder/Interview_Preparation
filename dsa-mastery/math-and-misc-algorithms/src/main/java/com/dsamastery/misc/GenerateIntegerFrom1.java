package com.dsamastery.misc;

import java.util.*;

public class GenerateIntegerFrom1 {

    int main()
    {
    int first, second;
    for ( first=1; first<=5; ++first )
    for ( second=1; second<=5; ++second )
    System.out.printf("%d \n", 5*first + second - 5);
    return 0;
    }
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
    System.out.printf("%d ", my_rand());
    return 0;
    }
}

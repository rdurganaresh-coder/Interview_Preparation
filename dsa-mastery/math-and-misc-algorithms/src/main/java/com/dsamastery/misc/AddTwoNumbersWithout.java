package com.dsamastery.misc;

import java.util.*;

public class AddTwoNumbersWithout {

    required sum y = carry << 1; } return x; } int main() { System.out.printf(“%d”, Add(15, 32)); return 0; }
    int Add(int x, int y)
    {
    if (y == 0)
    return x;
    else
    return Add( x ^ y, (x & y) << 1);
    }
}

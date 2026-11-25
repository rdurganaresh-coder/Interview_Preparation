package com.dsamastery.misc;

import java.util.*;

public class BirthdayParadox {

    // C++ program to approximate number of people in Birthday Paradox
    // problem
    // Returns approximate number of people for a given probability
    int find(double p)
    {
    return ceil(sqrt(2*365*log(1/(1-p))));
    }
    int main()
    {
    System.out.print(find(0.70));
    }
}

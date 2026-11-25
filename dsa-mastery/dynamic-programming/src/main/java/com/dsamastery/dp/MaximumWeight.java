package com.dsamastery.dp;

import java.util.*;

public class MaximumWeight {

    If (n == 1)
    // Max of two cases: First character considered separately
    // First pair considered separately
    // Max of two cases: First character considered separately
    // First pair considered separately
    // Since first two characters are same and a toggle is
    // required to form a pair, 3 is added for pair instead
    // of 4
    // C++ program to find maximum weight transformation
    // of a given string
    // Returns wieght of the maximum weight
    // transformation
    int getMaxRec(string &str, int i, int n, int lookup[])
    {
    // Base case
    if (i >= n) return 0;
    //If this subproblem is already solved
    if (lookup[i] != -1) return lookup[i];
    // Don't make pair, so weight gained is 1
    int ans = 1 + getMaxRec(str, i+1, n, lookup);
    // If we can make pair
    if (i+1 < n)
    {
    // If elements are dissmilar, weight gained is 4
    if (str[i] != str[i+1])
    ans = max(4 + getMaxRec(str, i+2, n, lookup),
    ans);
    // if elements are similar so for making a pair
    // we toggle any of them. Since toggle cost is
    // 1 so overall weight gain becomes 3
    else ans = max(3 + getMaxRec(str, i+2, n, lookup),
    ans);
    }
    // save and return maximum of above cases
    return lookup[i] = ans;
    }
    // Initializes lookup table and calls getMaxRec()
    int getMaxWeight(string str)
    {
    int n = str.length();
    // Create and initialize lookup table
    int lookup[n];
    memset(lookup, -1, sizeof lookup);
    // Call recursive function
    return getMaxRec(str, 0, str.length(), lookup);
    }
    // Driver program
    int main()
    {
    string str = "AAAAABB";
    cout << "Maximum weight of a transformation of "
    << str << " is " << getMaxWeight(str);
    return 0;
    }
}

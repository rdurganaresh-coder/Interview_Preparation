package com.dsamastery.dp;

import java.util.*;

public class RecursiveFunctions {

    // Assuming n-th disk is bottom disk (count down)
    void tower(int n, char sourcePole, char destinationPole, char auxiliaryPole)
    {
    // Base case (termination condition)
    if(0 == n)
    return;
    // Move first n-1 disks from source pole
    // to auxiliary pole using destination as
    // temporary pole
    tower(n-1, sourcePole, auxiliaryPole,
    destinationPole);
    // Move the remaining disk from source
    // pole to destination pole
    System.out.printf("Move the disk %d from %c to %c\n", n,
    sourcePole, destinationPole);
    // Move the n-1 disks from auxiliary (now source)
    // pole to destination pole using source pole as
    // temporary (auxiliary) pole
    tower(n-1, auxiliaryPole, destinationPole,
    sourcePole);
    }
    void main()
    {
    tower(3, 'S', 'D', 'A');
    }
    void recursive(int data)
    {
    static callDepth;
    if(callDepth > MAX_DEPTH)
    return;
    // Increase call depth
    callDepth++;
    // do other processing
    recursive(data);
    // do other processing
    // Decrease call depth
    callDepth--;
    }
}

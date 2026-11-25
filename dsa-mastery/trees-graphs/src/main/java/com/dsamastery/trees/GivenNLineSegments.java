package com.dsamastery.trees;

import java.util.*;

public class GivenNLineSegments {

    // Process all 2n points
    // If this point is left end of its line
    if (Points[i].isLeft)
    // Check if this points intersects with its predecessor and successor
    if ( doIntersect(Points[i].line(), T.pred(Points[i].line()) )
    return true
    if ( doIntersect(Points[i].line(), T.succ(Points[i].line()) )
    return true
    else // If it's a right end of its line
    // Check if its predecessor and successor intersect with each other
    if ( doIntersect(T.pred(Points[i].line(), T.succ(Points[i].line()))
    return true
}

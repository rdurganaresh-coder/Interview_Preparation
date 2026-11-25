package com.dsamastery.dp;

import java.util.*;

public class FindTheMinimumCost {

    {INF, INF, INF, 0}
    };
    minCost(0, N-2) + cost[N-2][n-1] }
    // A naive recursive solution to find min cost path from station 0
    // to station N-1
    // infinite value
    // Number of stations
    // A recursive function to find the shortest path from
    // source 's' to destination 'd'.
    int minCostRec(int cost[][N], int s, int d)
    {
    // If source is same as destination
    // or destination is next to source
    if (s == d || s+1 == d)
    return cost[s][d];
    // Initialize min cost as direct ticket from
    // source 's' to destination 'd'.
    int min = cost[s][d];
    // Try every intermediate vertex to find minimum
    for (int i = s+1; i<d; i++)
    {
    int c = minCostRec(cost, s, i) +
    minCostRec(cost, i, d);
    if (c < min)
    min = c;
    }
    return min;
    }
    // This function returns the smallest possible cost to
    // reach station N-1 from station 0. This function mainly
    // uses minCostRec().
    int minCost(int cost[][N])
    {
    return minCostRec(cost, 0, N-1);
    }
    // Driver program to test above function
    int main()
    {
    int cost[N][N] = { {0, 15, 80, 90},
    {INF, 0, 40, 50},
    {INF, INF, 0, 70},
    {INF, INF, INF, 0}
    };
    cout << "The Minimum cost to reach station "
    << N << " is " << minCost(cost);
    return 0;
    }
    // A Dynamic Programming based solution to find min cost
    // to reach station N-1 from station 0.
    // This function returns the smallest possible cost to
    // reach station N-1 from station 0.
    int minCost(int cost[][N])
    {
    // dist[i] stores minimum cost to reach station i
    // from station 0.
    int dist[N];
    for (int i=0; i<N; i++)
    dist[i] = INF;
    dist[0] = 0;
    // Go through every station and check if using it
    // as an intermediate station gives better path
    for (int i=0; i<N; i++)
    for (int j=i+1; j<N; j++)
    if (dist[j] > dist[i] + cost[i][j])
    dist[j] = dist[i] + cost[i][j];
    return dist[N-1];
    }
    // Driver program to test above function
    int main()
    {
    int cost[N][N] = { {0, 15, 80, 90},
    {INF, 0, 40, 50},
    {INF, INF, 0, 70},
    {INF, INF, INF, 0}
    };
    cout << "The Minimum cost to reach station "
    << N << " is " << minCost(cost);
    return 0;
    }
}

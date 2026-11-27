package com.leetcode.arrays_hashing_greedy;

class Solution1333 {
    public List<Integer> filterRestaurants(
        int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        List<Integer> ans = new ArrayList<>();
        for (int[] r : restaurants) {
            if (r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance) {
                ans.add(r[0]);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1333 _tcSol = new Solution1333();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10");
        try {
            int[][] restaurants = new int[][]{new int[]{1, 4, 1, 40, 10}, new int[]{2, 8, 0, 50, 5}, new int[]{3, 8, 1, 30, 4}, new int[]{4, 10, 0, 10, 3}, new int[]{5, 1, 1, 15, 1}};
            int veganFriendly = 1;
            int maxPrice = 50;
            int maxDistance = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 50, maxDistance = 10");
        try {
            int[][] restaurants = new int[][]{new int[]{1, 4, 1, 40, 10}, new int[]{2, 8, 0, 50, 5}, new int[]{3, 8, 1, 30, 4}, new int[]{4, 10, 0, 10, 3}, new int[]{5, 1, 1, 15, 1}};
            int veganFriendly = 0;
            int maxPrice = 50;
            int maxDistance = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,2,1,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 0, maxPrice = 30, maxDistance = 3");
        try {
            int[][] restaurants = new int[][]{new int[]{1, 4, 1, 40, 10}, new int[]{2, 8, 0, 50, 5}, new int[]{3, 8, 1, 30, 4}, new int[]{4, 10, 0, 10, 3}, new int[]{5, 1, 1, 15, 1}};
            int veganFriendly = 0;
            int maxPrice = 30;
            int maxDistance = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,5]");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] vis = new boolean[n];
        int ans = n;
        for (int x : fruits) {
            for (int i = 0; i < n; ++i) {
                if (baskets[i] >= x && !vis[i]) {
                    vis[i] = true;
                    --ans;
                    break;
                }
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
        Solution3477 _tcSol = new Solution3477();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fruits = [4,2,5], baskets = [3,5,4]");
        try {
            int[] fruits = new int[]{4, 2, 5};
            int[] baskets = new int[]{3, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfUnplacedFruits(fruits, baskets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fruits = [3,6,1], baskets = [6,4,7]");
        try {
            int[] fruits = new int[]{3, 6, 1};
            int[] baskets = new int[]{6, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfUnplacedFruits(fruits, baskets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
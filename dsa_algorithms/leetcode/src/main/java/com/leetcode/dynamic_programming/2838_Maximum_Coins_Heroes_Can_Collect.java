package com.leetcode.dynamic_programming;

class Solution2838 {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int m = monsters.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }

        Arrays.sort(idx, Comparator.comparingInt(j -> monsters[j]));
        long[] s = new long[m + 1];
        for (int i = 0; i < m; ++i) {
            s[i + 1] = s[i] + coins[idx[i]];
        }
        int n = heroes.length;
        long[] ans = new long[n];
        for (int k = 0; k < n; ++k) {
            int i = search(monsters, idx, heroes[k]);
            ans[k] = s[i];
        }
        return ans;
    }

    private int search(int[] nums, Integer[] idx, int x) {
        int l = 0, r = idx.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[idx[mid]] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2838 _tcSol = new Solution2838();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heroes = [1,4,2], monsters = [1,1,5,2,3], coins = [2,3,4,5,6]");
        try {
            int[] heroes = new int[]{1, 4, 2};
            int[] monsters = new int[]{1, 1, 5, 2, 3};
            int[] coins = new int[]{2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCoins(heroes, monsters, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,16,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heroes = [5], monsters = [2,3,1,2], coins = [10,6,5,2]");
        try {
            int[] heroes = new int[]{5};
            int[] monsters = new int[]{2, 3, 1, 2};
            int[] coins = new int[]{10, 6, 5, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCoins(heroes, monsters, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[23]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heroes = [4,4], monsters = [5,7,8], coins = [1,1,1]");
        try {
            int[] heroes = new int[]{4, 4};
            int[] monsters = new int[]{5, 7, 8};
            int[] coins = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCoins(heroes, monsters, coins)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int left = 0, right = m;
            while (left < right) {
                int mid = (left + right) >> 1;
                if ((long) spells[i] * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - left;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2300 _tcSol = new Solution2300();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "spells = [5,1,3], potions = [1,2,3,4,5], success = 7");
        try {
            int[] spells = new int[]{5, 1, 3};
            int[] potions = new int[]{1, 2, 3, 4, 5};
            long success = 7L;
            System.out.println("  Output  : " + _tcShow(_tcSol.successfulPairs(spells, potions, success)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "spells = [3,1,2], potions = [8,5,8], success = 16");
        try {
            int[] spells = new int[]{3, 1, 2};
            int[] potions = new int[]{8, 5, 8};
            long success = 16L;
            System.out.println("  Output  : " + _tcShow(_tcSol.successfulPairs(spells, potions, success)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,2]");
        System.out.println();
    }
}
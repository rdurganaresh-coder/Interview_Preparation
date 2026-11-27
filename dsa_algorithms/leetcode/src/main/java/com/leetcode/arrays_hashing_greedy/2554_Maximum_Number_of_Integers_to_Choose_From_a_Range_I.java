package com.leetcode.arrays_hashing_greedy;

class Solution2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>(banned.length);
        for (int x : banned) {
            ban.add(x);
        }
        int ans = 0, s = 0;
        for (int i = 1; i <= n && s + i <= maxSum; ++i) {
            if (!ban.contains(i)) {
                ++ans;
                s += i;
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
        Solution2554 _tcSol = new Solution2554();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "banned = [1,6,5], n = 5, maxSum = 6");
        try {
            int[] banned = new int[]{1, 6, 5};
            int n = 5;
            int maxSum = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(banned, n, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1");
        try {
            int[] banned = new int[]{1, 2, 3, 4, 5, 6, 7};
            int n = 8;
            int maxSum = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(banned, n, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "banned = [11], n = 7, maxSum = 50");
        try {
            int[] banned = new int[]{11};
            int n = 7;
            int maxSum = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxCount(banned, n, maxSum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
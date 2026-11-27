package com.leetcode.arrays_hashing_greedy;

class Solution0274_2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int x : citations) {
            ++cnt[Math.min(x, n)];
        }
        for (int h = n, s = 0;; --h) {
            s += cnt[h];
            if (s >= h) {
                return h;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0274_2 _tcSol = new Solution0274_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "citations = [3,0,6,1,5]");
        try {
            int[] citations = new int[]{3, 0, 6, 1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.hIndex(citations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "citations = [1,3,1]");
        try {
            int[] citations = new int[]{1, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.hIndex(citations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
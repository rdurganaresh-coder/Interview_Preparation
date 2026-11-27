package com.leetcode.arrays_hashing_greedy;

class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long s = 0;
        for (int x : beans) {
            s += x;
        }
        long ans = s;
        int n = beans.length;
        for (int i = 0; i < n; ++i) {
            ans = Math.min(ans, s - (long) beans[i] * (n - i));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2171 _tcSol = new Solution2171();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "beans = [4,1,6,5]");
        try {
            int[] beans = new int[]{4, 1, 6, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRemoval(beans)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "beans = [2,10,3,2]");
        try {
            int[] beans = new int[]{2, 10, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRemoval(beans)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
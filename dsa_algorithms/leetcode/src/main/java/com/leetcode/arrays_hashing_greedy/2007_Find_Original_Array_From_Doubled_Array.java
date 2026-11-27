package com.leetcode.arrays_hashing_greedy;

class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        int[] cnt = new int[changed[n - 1] + 1];
        for (int x : changed) {
            ++cnt[x];
        }
        int[] ans = new int[n >> 1];
        int i = 0;
        for (int x : changed) {
            if (cnt[x] == 0) {
                continue;
            }
            --cnt[x];
            int y = x << 1;
            if (y >= cnt.length || cnt[y] <= 0) {
                return new int[0];
            }
            --cnt[y];
            ans[i++] = x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2007 _tcSol = new Solution2007();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "changed = [1,3,4,2,6,8]");
        try {
            int[] changed = new int[]{1, 3, 4, 2, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOriginalArray(changed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "changed = [6,3,0,1]");
        try {
            int[] changed = new int[]{6, 3, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOriginalArray(changed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "changed = [1]");
        try {
            int[] changed = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOriginalArray(changed)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
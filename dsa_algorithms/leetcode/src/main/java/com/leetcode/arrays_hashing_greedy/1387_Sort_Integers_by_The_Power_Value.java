package com.leetcode.arrays_hashing_greedy;

class Solution1387 {
    public int getKth(int lo, int hi, int k) {
        Integer[] nums = new Integer[hi - lo + 1];
        for (int i = lo; i <= hi; ++i) {
            nums[i - lo] = i;
        }
        Arrays.sort(nums, (a, b) -> {
            int fa = f(a), fb = f(b);
            return fa == fb ? a - b : fa - fb;
        });
        return nums[k - 1];
    }

    private int f(int x) {
        int ans = 0;
        for (; x != 1; ++ans) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
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
        Solution1387 _tcSol = new Solution1387();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "lo = 12, hi = 15, k = 2");
        try {
            int lo = 12;
            int hi = 15;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getKth(lo, hi, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "lo = 7, hi = 11, k = 4");
        try {
            int lo = 7;
            int hi = 11;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.getKth(lo, hi, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
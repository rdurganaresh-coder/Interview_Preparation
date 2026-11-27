package com.leetcode.arrays_hashing_greedy;

class Solution1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int l = 0, r = 0;
        for (int v : sweetness) {
            r += v;
        }
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(sweetness, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int x, int k) {
        int s = 0, cnt = 0;
        for (int v : nums) {
            s += v;
            if (s >= x) {
                s = 0;
                ++cnt;
            }
        }
        return cnt > k;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1231 _tcSol = new Solution1231();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "sweetness = [1,2,3,4,5,6,7,8,9], k = 5");
        try {
            int[] sweetness = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSweetness(sweetness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "sweetness = [5,6,7,8,9,1,2,3,4], k = 8");
        try {
            int[] sweetness = new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4};
            int k = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSweetness(sweetness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "sweetness = [1,2,2,1,2,2,1,2,2], k = 2");
        try {
            int[] sweetness = new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSweetness(sweetness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
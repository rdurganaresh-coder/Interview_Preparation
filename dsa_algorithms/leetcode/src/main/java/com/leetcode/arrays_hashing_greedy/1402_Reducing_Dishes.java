package com.leetcode.arrays_hashing_greedy;

class Solution1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0, s = 0;
        for (int i = satisfaction.length - 1; i >= 0; --i) {
            s += satisfaction[i];
            if (s <= 0) {
                break;
            }
            ans += s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1402 _tcSol = new Solution1402();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "satisfaction = [-1,-8,0,5,-9]");
        try {
            int[] satisfaction = new int[]{-1, -8, 0, 5, -9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSatisfaction(satisfaction)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "14");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "satisfaction = [4,3,2]");
        try {
            int[] satisfaction = new int[]{4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSatisfaction(satisfaction)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "satisfaction = [-1,-4,-5]");
        try {
            int[] satisfaction = new int[]{-1, -4, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSatisfaction(satisfaction)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
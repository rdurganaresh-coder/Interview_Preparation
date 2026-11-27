package com.leetcode.arrays_hashing_greedy;

class Solution1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + calories[i];
        }
        int ans = 0;
        for (int i = 0; i < n - k + 1; ++i) {
            int t = s[i + k] - s[i];
            if (t < lower) {
                --ans;
            } else if (t > upper) {
                ++ans;
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
        Solution1176 _tcSol = new Solution1176();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3");
        try {
            int[] calories = new int[]{1, 2, 3, 4, 5};
            int k = 1;
            int lower = 3;
            int upper = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.dietPlanPerformance(calories, k, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "calories = [3,2], k = 2, lower = 0, upper = 1");
        try {
            int[] calories = new int[]{3, 2};
            int k = 2;
            int lower = 0;
            int upper = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.dietPlanPerformance(calories, k, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "calories = [6,5,0,0], k = 2, lower = 1, upper = 5");
        try {
            int[] calories = new int[]{6, 5, 0, 0};
            int k = 2;
            int lower = 1;
            int upper = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.dietPlanPerformance(calories, k, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
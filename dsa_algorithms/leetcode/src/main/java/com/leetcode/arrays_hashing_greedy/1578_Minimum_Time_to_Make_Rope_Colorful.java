package com.leetcode.arrays_hashing_greedy;

class Solution1578 {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = neededTime.length;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            int s = 0, mx = 0;
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                s += neededTime[j];
                mx = Math.max(mx, neededTime[j]);
                ++j;
            }
            if (j - i > 1) {
                ans += s - mx;
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
        Solution1578 _tcSol = new Solution1578();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = \"abaac\", neededTime = [1,2,3,4,5]");
        try {
            String colors = "abaac";
            int[] neededTime = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(colors, neededTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = \"abc\", neededTime = [1,2,3]");
        try {
            String colors = "abc";
            int[] neededTime = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(colors, neededTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "colors = \"aabaa\", neededTime = [1,2,3,4,1]");
        try {
            String colors = "aabaa";
            int[] neededTime = new int[]{1, 2, 3, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(colors, neededTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; candies > 0; ++i) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1103 _tcSol = new Solution1103();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candies = 7, num_people = 4");
        try {
            int candies = 7;
            int num_people = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(candies, num_people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candies = 10, num_people = 3");
        try {
            int candies = 10;
            int num_people = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(candies, num_people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2,3]");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution1395 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0, r = 0;
            for (int j = 0; j < i; ++j) {
                if (rating[j] < rating[i]) {
                    ++l;
                }
            }
            for (int j = i + 1; j < n; ++j) {
                if (rating[j] > rating[i]) {
                    ++r;
                }
            }
            ans += l * r;
            ans += (i - l) * (n - i - 1 - r);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1395 _tcSol = new Solution1395();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rating = [2,5,3,4,1]");
        try {
            int[] rating = new int[]{2, 5, 3, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rating = [2,1,3]");
        try {
            int[] rating = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rating = [1,2,3,4]");
        try {
            int[] rating = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
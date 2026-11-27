package com.leetcode.arrays_hashing_greedy;

class Solution3175 {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        k = Math.min(k, n - 1);
        int i = 0, cnt = 0;
        for (int j = 1; j < n; ++j) {
            if (skills[i] < skills[j]) {
                i = j;
                cnt = 1;
            } else {
                ++cnt;
            }
            if (cnt == k) {
                break;
            }
        }
        return i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3175 _tcSol = new Solution3175();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "skills = [4,2,6,3,9], k = 2");
        try {
            int[] skills = new int[]{4, 2, 6, 3, 9};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findWinningPlayer(skills, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "skills = [2,5,4], k = 3");
        try {
            int[] skills = new int[]{2, 5, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findWinningPlayer(skills, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2383 {
    public int minNumberOfHours(int x, int y, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; ++i) {
            int dx = energy[i], dy = experience[i];
            if (x <= dx) {
                ans += dx + 1 - x;
                x = dx + 1;
            }
            if (y <= dy) {
                ans += dy + 1 - y;
                y = dy + 1;
            }
            x -= dx;
            y += dy;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2383 _tcSol = new Solution2383();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]");
        try {
            int x = 5;
            int y = 3;
            int[] energy = new int[]{1, 4, 3, 2};
            int[] experience = new int[]{2, 6, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfHours(x, y, energy, experience)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "initialEnergy = 2, initialExperience = 4, energy = [1], experience = [3]");
        try {
            int x = 2;
            int y = 4;
            int[] energy = new int[]{1};
            int[] experience = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfHours(x, y, energy, experience)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}

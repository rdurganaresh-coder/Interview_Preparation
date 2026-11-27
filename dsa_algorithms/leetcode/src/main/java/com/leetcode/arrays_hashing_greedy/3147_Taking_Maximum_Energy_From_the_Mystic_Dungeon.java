package com.leetcode.arrays_hashing_greedy;

class Solution3147 {
    public int maximumEnergy(int[] energy, int k) {
        int ans = -(1 << 30);
        int n = energy.length;
        for (int i = n - k; i < n; ++i) {
            for (int j = i, s = 0; j >= 0; j -= k) {
                s += energy[j];
                ans = Math.max(ans, s);
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
        Solution3147 _tcSol = new Solution3147();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "energy = [5,2,-10,-5,1], k = 3");
        try {
            int[] energy = new int[]{5, 2, -10, -5, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumEnergy(energy, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "energy = [-2,-3,-1], k = 2");
        try {
            int[] energy = new int[]{-2, -3, -1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumEnergy(energy, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
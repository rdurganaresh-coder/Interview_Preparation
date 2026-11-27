package com.leetcode.arrays_hashing_greedy;

class Solution3207 {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if (currentEnergy < enemyEnergies[0]) {
            return 0;
        }
        long ans = 0;
        for (int i = enemyEnergies.length - 1; i >= 0; --i) {
            ans += currentEnergy / enemyEnergies[0];
            currentEnergy %= enemyEnergies[0];
            currentEnergy += enemyEnergies[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3207 _tcSol = new Solution3207();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "enemyEnergies = [3,2,2], currentEnergy = 2");
        try {
            int[] enemyEnergies = new int[]{3, 2, 2};
            int currentEnergy = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPoints(enemyEnergies, currentEnergy)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "enemyEnergies = [2], currentEnergy = 10");
        try {
            int[] enemyEnergies = new int[]{2};
            int currentEnergy = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumPoints(enemyEnergies, currentEnergy)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
};
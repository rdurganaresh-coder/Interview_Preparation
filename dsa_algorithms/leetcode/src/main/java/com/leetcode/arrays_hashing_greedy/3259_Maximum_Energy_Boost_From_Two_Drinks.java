package com.leetcode.arrays_hashing_greedy;

class Solution3259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] f = new long[n][2];
        f[0][0] = energyDrinkA[0];
        f[0][1] = energyDrinkB[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0] + energyDrinkA[i], f[i - 1][1]);
            f[i][1] = Math.max(f[i - 1][1] + energyDrinkB[i], f[i - 1][0]);
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3259 _tcSol = new Solution3259();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]");
        try {
            int[] energyDrinkA = new int[]{1, 3, 1};
            int[] energyDrinkB = new int[]{3, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEnergyBoost(energyDrinkA, energyDrinkB)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]");
        try {
            int[] energyDrinkA = new int[]{4, 1, 1};
            int[] energyDrinkB = new int[]{1, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEnergyBoost(energyDrinkA, energyDrinkB)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}

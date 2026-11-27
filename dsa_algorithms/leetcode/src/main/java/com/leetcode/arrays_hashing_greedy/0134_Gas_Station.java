package com.leetcode.arrays_hashing_greedy;

class Solution0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = n - 1, j = n - 1;
        int cnt = 0, s = 0;
        while (cnt < n) {
            s += gas[j] - cost[j];
            ++cnt;
            j = (j + 1) % n;
            while (s < 0 && cnt < n) {
                --i;
                s += gas[i] - cost[i];
                ++cnt;
            }
        }
        return s < 0 ? -1 : i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0134 _tcSol = new Solution0134();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "gas = [1,2,3,4,5], cost = [3,4,5,1,2]");
        try {
            int[] gas = new int[]{1, 2, 3, 4, 5};
            int[] cost = new int[]{3, 4, 5, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCompleteCircuit(gas, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "gas = [2,3,4], cost = [3,4,3]");
        try {
            int[] gas = new int[]{2, 3, 4};
            int[] cost = new int[]{3, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCompleteCircuit(gas, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
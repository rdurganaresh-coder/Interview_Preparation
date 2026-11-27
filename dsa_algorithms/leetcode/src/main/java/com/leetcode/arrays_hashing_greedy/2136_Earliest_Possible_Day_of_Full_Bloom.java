package com.leetcode.arrays_hashing_greedy;

class Solution2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> growTime[j] - growTime[i]);
        int ans = 0, t = 0;
        for (int i : idx) {
            t += plantTime[i];
            ans = Math.max(ans, t + growTime[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2136 _tcSol = new Solution2136();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "plantTime = [1,4,3], growTime = [2,3,1]");
        try {
            int[] plantTime = new int[]{1, 4, 3};
            int[] growTime = new int[]{2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestFullBloom(plantTime, growTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "plantTime = [1,2,3,2], growTime = [2,1,2,1]");
        try {
            int[] plantTime = new int[]{1, 2, 3, 2};
            int[] growTime = new int[]{2, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestFullBloom(plantTime, growTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "plantTime = [1], growTime = [1]");
        try {
            int[] plantTime = new int[]{1};
            int[] growTime = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestFullBloom(plantTime, growTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
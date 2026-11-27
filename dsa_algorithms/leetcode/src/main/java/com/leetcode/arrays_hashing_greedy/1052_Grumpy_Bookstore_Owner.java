package com.leetcode.arrays_hashing_greedy;

class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int cnt = 0;
        int tot = 0;
        for (int i = 0; i < minutes; ++i) {
            cnt += customers[i] * grumpy[i];
            tot += customers[i] * (grumpy[i] ^ 1);
        }
        int mx = cnt;
        int n = customers.length;
        for (int i = minutes; i < n; ++i) {
            cnt += customers[i] * grumpy[i];
            cnt -= customers[i - minutes] * grumpy[i - minutes];
            mx = Math.max(mx, cnt);
            tot += customers[i] * (grumpy[i] ^ 1);
        }
        return tot + mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1052 _tcSol = new Solution1052();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3");
        try {
            int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
            int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
            int minutes = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSatisfied(customers, grumpy, minutes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "customers = [1], grumpy = [0], minutes = 1");
        try {
            int[] customers = new int[]{1};
            int[] grumpy = new int[]{0};
            int minutes = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSatisfied(customers, grumpy, minutes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
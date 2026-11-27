package com.leetcode.arrays_hashing_greedy;

class Solution0464 {
    private Map<Integer, Boolean> f = new HashMap<>();
    private int maxChoosableInteger;
    private int desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        return dfs(0, 0);
    }

    private boolean dfs(int mask, int s) {
        if (f.containsKey(mask)) {
            return f.get(mask);
        }
        for (int i = 0; i < maxChoosableInteger; ++i) {
            if ((mask >> i & 1) == 0) {
                if (s + i + 1 >= desiredTotal || !dfs(mask | 1 << i, s + i + 1)) {
                    f.put(mask, true);
                    return true;
                }
            }
        }
        f.put(mask, false);
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0464 _tcSol = new Solution0464();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maxChoosableInteger = 10, desiredTotal = 11");
        try {
            int maxChoosableInteger = 10;
            int desiredTotal = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.canIWin(maxChoosableInteger, desiredTotal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maxChoosableInteger = 10, desiredTotal = 0");
        try {
            int maxChoosableInteger = 10;
            int desiredTotal = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.canIWin(maxChoosableInteger, desiredTotal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maxChoosableInteger = 10, desiredTotal = 1");
        try {
            int maxChoosableInteger = 10;
            int desiredTotal = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.canIWin(maxChoosableInteger, desiredTotal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
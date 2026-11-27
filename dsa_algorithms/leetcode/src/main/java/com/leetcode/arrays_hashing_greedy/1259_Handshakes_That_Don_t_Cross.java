package com.leetcode.arrays_hashing_greedy;

class Solution1259 {
    private int[] f;
    private final int mod = (int) 1e9 + 7;

    public int numberOfWays(int numPeople) {
        f = new int[numPeople + 1];
        return dfs(numPeople);
    }

    private int dfs(int i) {
        if (i < 2) {
            return 1;
        }
        if (f[i] != 0) {
            return f[i];
        }
        for (int l = 0; l < i; l += 2) {
            int r = i - l - 2;
            f[i] = (int) ((f[i] + (1L * dfs(l) * dfs(r) % mod)) % mod);
        }
        return f[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1259 _tcSol = new Solution1259();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numPeople = 4");
        try {
            int numPeople = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(numPeople)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numPeople = 6");
        try {
            int numPeople = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWays(numPeople)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
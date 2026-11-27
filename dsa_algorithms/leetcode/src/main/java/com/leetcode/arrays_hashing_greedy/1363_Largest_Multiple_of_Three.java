package com.leetcode.arrays_hashing_greedy;

class Solution1363 {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int n = digits.length;
        int[][] f = new int[n + 1][3];
        final int inf = 1 << 30;
        for (var g : f) {
            Arrays.fill(g, -inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 3; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][(j - digits[i - 1] % 3 + 3) % 3] + 1);
            }
        }
        if (f[n][0] <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n, j = 0; i > 0; --i) {
            int k = (j - digits[i - 1] % 3 + 3) % 3;
            if (f[i - 1][k] + 1 == f[i][j]) {
                sb.append(digits[i - 1]);
                j = k;
            }
        }
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            ++i;
        }
        return sb.substring(i);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1363 _tcSol = new Solution1363();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = [8,1,9]");
        try {
            int[] digits = new int[]{8, 1, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestMultipleOfThree(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"981\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = [8,6,7,1,0]");
        try {
            int[] digits = new int[]{8, 6, 7, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestMultipleOfThree(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"8760\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "digits = [1]");
        try {
            int[] digits = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestMultipleOfThree(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
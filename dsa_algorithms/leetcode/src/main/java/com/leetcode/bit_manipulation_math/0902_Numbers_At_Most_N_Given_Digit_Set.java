package com.leetcode.bit_manipulation_math;

class Solution0902 {
    private Set<Integer> nums = new HashSet<>();
    private char[] s;
    private Integer[] f;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = String.valueOf(n).toCharArray();
        f = new Integer[s.length];
        for (var x : digits) {
            nums.add(Integer.parseInt(x));
        }
        return dfs(0, true, true);
    }

    private int dfs(int i, boolean lead, boolean limit) {
        if (i >= s.length) {
            return lead ? 0 : 1;
        }
        if (!lead && !limit && f[i] != null) {
            return f[i];
        }
        int up = limit ? s[i] - '0' : 9;
        int ans = 0;
        for (int j = 0; j <= up; ++j) {
            if (j == 0 && lead) {
                ans += dfs(i + 1, true, limit && j == up);
            } else if (nums.contains(j)) {
                ans += dfs(i + 1, false, limit && j == up);
            }
        }
        if (!lead && !limit) {
            f[i] = ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0902 _tcSol = new Solution0902();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = [\"1\",\"3\",\"5\",\"7\"], n = 100");
        try {
            String[] digits = new String[]{"1", "3", "5", "7"};
            int n = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.atMostNGivenDigitSet(digits, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = [\"1\",\"4\",\"9\"], n = 1000000000");
        try {
            String[] digits = new String[]{"1", "4", "9"};
            int n = 1000000000;
            System.out.println("  Output  : " + _tcShow(_tcSol.atMostNGivenDigitSet(digits, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "29523");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "digits = [\"7\"], n = 8");
        try {
            String[] digits = new String[]{"7"};
            int n = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.atMostNGivenDigitSet(digits, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2578_2 {
    public int splitNum(int num) {
        char[] s = (num + "").toCharArray();
        Arrays.sort(s);
        int[] ans = new int[2];
        for (int i = 0; i < s.length; ++i) {
            ans[i & 1] = ans[i & 1] * 10 + s[i] - '0';
        }
        return ans[0] + ans[1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2578_2 _tcSol = new Solution2578_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 4325");
        try {
            int num = 4325;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitNum(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "59");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 687");
        try {
            int num = 687;
            System.out.println("  Output  : " + _tcShow(_tcSol.splitNum(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "75");
        System.out.println();
    }
}
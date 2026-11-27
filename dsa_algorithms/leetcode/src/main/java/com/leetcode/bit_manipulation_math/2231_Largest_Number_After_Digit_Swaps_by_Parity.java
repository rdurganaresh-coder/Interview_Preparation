package com.leetcode.bit_manipulation_math;

class Solution2231 {
    public int largestInteger(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int[] cnt = new int[10];
        for (char c : s) {
            ++cnt[c - '0'];
        }
        int[] idx = {8, 9};
        int ans = 0;
        for (char c : s) {
            int x = c - '0';
            while (cnt[idx[x & 1]] == 0) {
                idx[x & 1] -= 2;
            }
            ans = ans * 10 + idx[x & 1];
            cnt[idx[x & 1]]--;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2231 _tcSol = new Solution2231();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 1234");
        try {
            int num = 1234;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestInteger(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3412");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 65875");
        try {
            int num = 65875;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestInteger(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "87655");
        System.out.println();
    }
}

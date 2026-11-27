package com.leetcode.arrays_hashing_greedy;

class Solution1556 {
    public String thousandSeparator(int n) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        while (true) {
            int v = n % 10;
            n /= 10;
            ans.append(v);
            ++cnt;
            if (n == 0) {
                break;
            }
            if (cnt == 3) {
                ans.append('.');
                cnt = 0;
            }
        }
        return ans.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1556 _tcSol = new Solution1556();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 987");
        try {
            int n = 987;
            System.out.println("  Output  : " + _tcShow(_tcSol.thousandSeparator(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"987\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1234");
        try {
            int n = 1234;
            System.out.println("  Output  : " + _tcShow(_tcSol.thousandSeparator(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1.234\"");
        System.out.println();
    }
}
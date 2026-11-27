package com.leetcode.dynamic_programming;

class Solution2384 {
    public String largestPalindromic(String num) {
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            ++cnt[c - '0'];
        }
        String mid = "";
        for (int i = 9; i >= 0; --i) {
            if (cnt[i] % 2 == 1) {
                mid += i;
                --cnt[i];
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            if (cnt[i] > 0) {
                cnt[i] >>= 1;
                sb.append(("" + i).repeat(cnt[i]));
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String t = sb.toString();
        String ans = sb.reverse().toString() + mid + t;
        return "".equals(ans) ? "0" : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2384 _tcSol = new Solution2384();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"444947137\"");
        try {
            String num = "444947137";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPalindromic(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"7449447\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"00009\"");
        try {
            String num = "00009";
            System.out.println("  Output  : " + _tcShow(_tcSol.largestPalindromic(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"9\"");
        System.out.println();
    }
}
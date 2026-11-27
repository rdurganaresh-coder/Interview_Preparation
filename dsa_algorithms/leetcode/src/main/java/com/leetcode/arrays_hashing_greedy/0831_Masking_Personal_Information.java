package com.leetcode.arrays_hashing_greedy;

class Solution0831 {
    public String maskPII(String s) {
        if (Character.isLetter(s.charAt(0))) {
            s = s.toLowerCase();
            int i = s.indexOf('@');
            return s.substring(0, 1) + "*****" + s.substring(i - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        s = sb.toString();
        int cnt = s.length() - 10;
        String suf = "***-***-" + s.substring(s.length() - 4);
        return cnt == 0 ? suf
                        : "+"
                + "*".repeat(cnt) + "-" + suf;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0831 _tcSol = new Solution0831();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"LeetCode@LeetCode.com\"");
        try {
            String s = "LeetCode@LeetCode.com";
            System.out.println("  Output  : " + _tcShow(_tcSol.maskPII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"l*****e@leetcode.com\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"AB@qq.com\"");
        try {
            String s = "AB@qq.com";
            System.out.println("  Output  : " + _tcShow(_tcSol.maskPII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"a*****b@qq.com\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1(234)567-890\"");
        try {
            String s = "1(234)567-890";
            System.out.println("  Output  : " + _tcShow(_tcSol.maskPII(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"***-***-7890\"");
        System.out.println();
    }
}
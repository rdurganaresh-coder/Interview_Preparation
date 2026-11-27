package com.leetcode.stacks_queues;

class Solution0899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length() - 1; ++i) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(ans) < 0) {
                    ans = sb.toString();
                }
            }
            return ans;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0899 _tcSol = new Solution0899();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"cba\", k = 1");
        try {
            String s = "cba";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.orderlyQueue(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"acb\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"baaca\", k = 3");
        try {
            String s = "baaca";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.orderlyQueue(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aaabc\"");
        System.out.println();
    }
}
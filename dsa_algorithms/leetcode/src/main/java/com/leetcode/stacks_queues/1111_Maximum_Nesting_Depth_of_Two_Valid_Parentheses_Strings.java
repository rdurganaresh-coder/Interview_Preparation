package com.leetcode.stacks_queues;

class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        for (int i = 0, x = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                ans[i] = x++ & 1;
            } else {
                ans[i] = --x & 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1111 _tcSol = new Solution1111();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "seq = \"(()())\"");
        try {
            String seq = "(()())";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepthAfterSplit(seq)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,1,1,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "seq = \"()(())()\"");
        try {
            String seq = "()(())()";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDepthAfterSplit(seq)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,0,1,1,0,1,1]");
        System.out.println();
    }
}
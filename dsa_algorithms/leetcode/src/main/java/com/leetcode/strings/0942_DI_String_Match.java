package com.leetcode.strings;

class Solution0942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }
        ans[n] = low;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0942 _tcSol = new Solution0942();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"IDID\"");
        try {
            String s = "IDID";
            System.out.println("  Output  : " + _tcShow(_tcSol.diStringMatch(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,4,1,3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"III\"");
        try {
            String s = "III";
            System.out.println("  Output  : " + _tcShow(_tcSol.diStringMatch(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"DDI\"");
        try {
            String s = "DDI";
            System.out.println("  Output  : " + _tcShow(_tcSol.diStringMatch(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,0,1]");
        System.out.println();
    }
}
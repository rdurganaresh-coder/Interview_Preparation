package com.leetcode.strings;

class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < n; ++j) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0014 _tcSol = new Solution0014();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"flower\",\"flow\",\"flight\"]");
        try {
            String[] strs = new String[]{"flower", "flow", "flight"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"fl\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"dog\",\"racecar\",\"car\"]");
        try {
            String[] strs = new String[]{"dog", "racecar", "car"};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonPrefix(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
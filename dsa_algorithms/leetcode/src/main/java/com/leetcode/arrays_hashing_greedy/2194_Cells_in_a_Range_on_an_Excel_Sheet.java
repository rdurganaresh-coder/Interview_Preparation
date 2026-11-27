package com.leetcode.arrays_hashing_greedy;

class Solution2194 {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        for (char i = s.charAt(0); i <= s.charAt(3); ++i) {
            for (char j = s.charAt(1); j <= s.charAt(4); ++j) {
                ans.add(i + "" + j);
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
        Solution2194 _tcSol = new Solution2194();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"K1:L2\"");
        try {
            String s = "K1:L2";
            System.out.println("  Output  : " + _tcShow(_tcSol.cellsInRange(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"K1\",\"K2\",\"L1\",\"L2\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"A1:F1\"");
        try {
            String s = "A1:F1";
            System.out.println("  Output  : " + _tcShow(_tcSol.cellsInRange(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"A1\",\"B1\",\"C1\",\"D1\",\"E1\",\"F1\"]");
        System.out.println();
    }
}
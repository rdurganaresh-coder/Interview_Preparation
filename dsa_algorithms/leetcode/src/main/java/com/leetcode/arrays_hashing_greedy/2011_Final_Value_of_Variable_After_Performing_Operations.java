package com.leetcode.arrays_hashing_greedy;

class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (var s : operations) {
            ans += (s.charAt(1) == '+' ? 1 : -1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2011 _tcSol = new Solution2011();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "operations = [\"--X\",\"X++\",\"X++\"]");
        try {
            String[] operations = new String[]{"--X", "X++", "X++"};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalValueAfterOperations(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "operations = [\"++X\",\"++X\",\"X++\"]");
        try {
            String[] operations = new String[]{"++X", "++X", "X++"};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalValueAfterOperations(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "operations = [\"X++\",\"++X\",\"--X\",\"X--\"]");
        try {
            String[] operations = new String[]{"X++", "++X", "--X", "X--"};
            System.out.println("  Output  : " + _tcShow(_tcSol.finalValueAfterOperations(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
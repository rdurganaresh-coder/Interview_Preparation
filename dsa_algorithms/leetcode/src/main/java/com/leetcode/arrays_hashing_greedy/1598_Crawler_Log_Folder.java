package com.leetcode.arrays_hashing_greedy;

class Solution1598 {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (var v : logs) {
            if ("../".equals(v)) {
                ans = Math.max(0, ans - 1);
            } else if (v.charAt(0) != '.') {
                ++ans;
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
        Solution1598 _tcSol = new Solution1598();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "logs = [\"d1/\",\"d2/\",\"../\",\"d21/\",\"./\"]");
        try {
            String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "logs = [\"d1/\",\"d2/\",\"./\",\"d3/\",\"../\",\"d31/\"]");
        try {
            String[] logs = new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "logs = [\"d1/\",\"../\",\"../\",\"../\"]");
        try {
            String[] logs = new String[]{"d1/", "../", "../", "../"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
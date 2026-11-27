package com.leetcode.arrays_hashing_greedy;

class Solution2224 {
    public int convertTime(String current, String correct) {
        int a = Integer.parseInt(current.substring(0, 2)) * 60
            + Integer.parseInt(current.substring(3));
        int b = Integer.parseInt(correct.substring(0, 2)) * 60
            + Integer.parseInt(correct.substring(3));
        int ans = 0, d = b - a;
        for (int i : Arrays.asList(60, 15, 5, 1)) {
            ans += d / i;
            d %= i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2224 _tcSol = new Solution2224();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "current = \"02:30\", correct = \"04:35\"");
        try {
            String current = "02:30";
            String correct = "04:35";
            System.out.println("  Output  : " + _tcShow(_tcSol.convertTime(current, correct)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "current = \"11:00\", correct = \"11:01\"");
        try {
            String current = "11:00";
            String correct = "11:01";
            System.out.println("  Output  : " + _tcShow(_tcSol.convertTime(current, correct)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
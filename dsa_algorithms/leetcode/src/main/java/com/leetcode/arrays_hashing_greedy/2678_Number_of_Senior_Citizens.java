package com.leetcode.arrays_hashing_greedy;

class Solution2678 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (var x : details) {
            int age = Integer.parseInt(x.substring(11, 13));
            if (age > 60) {
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
        Solution2678 _tcSol = new Solution2678();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "details = [\"7868190130M7522\",\"5303914400F9211\",\"9273338290F4010\"]");
        try {
            String[] details = new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSeniors(details)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "details = [\"1313579440F2036\",\"2921522980M5644\"]");
        try {
            String[] details = new String[]{"1313579440F2036", "2921522980M5644"};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSeniors(details)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
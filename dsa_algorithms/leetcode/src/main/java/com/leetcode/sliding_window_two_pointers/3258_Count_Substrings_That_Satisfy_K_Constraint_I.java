package com.leetcode.sliding_window_two_pointers;

class Solution3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int[] cnt = new int[2];
        int ans = 0, l = 0;
        for (int r = 0; r < s.length(); ++r) {
            ++cnt[s.charAt(r) - '0'];
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            ans += r - l + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3258 _tcSol = new Solution3258();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"10101\", k = 1");
        try {
            String s = "10101";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKConstraintSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1010101\", k = 2");
        try {
            String s = "1010101";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKConstraintSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"11111\", k = 1");
        try {
            String s = "11111";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countKConstraintSubstrings(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}

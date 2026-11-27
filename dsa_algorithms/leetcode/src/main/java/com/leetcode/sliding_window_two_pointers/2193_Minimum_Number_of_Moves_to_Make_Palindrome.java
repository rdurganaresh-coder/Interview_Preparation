package com.leetcode.sliding_window_two_pointers;

class Solution2193 {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 0, j = n - 1; i < j; ++i) {
            boolean even = false;
            for (int k = j; k != i; --k) {
                if (cs[i] == cs[k]) {
                    even = true;
                    for (; k < j; ++k) {
                        char t = cs[k];
                        cs[k] = cs[k + 1];
                        cs[k + 1] = t;
                        ++ans;
                    }
                    --j;
                    break;
                }
            }
            if (!even) {
                ans += n / 2 - i;
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
        Solution2193 _tcSol = new Solution2193();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aabb\"");
        try {
            String s = "aabb";
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToMakePalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"letelt\"");
        try {
            String s = "letelt";
            System.out.println("  Output  : " + _tcShow(_tcSol.minMovesToMakePalindrome(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
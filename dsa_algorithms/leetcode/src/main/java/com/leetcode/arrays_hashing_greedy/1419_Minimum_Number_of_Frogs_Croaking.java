package com.leetcode.arrays_hashing_greedy;

class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if (n % 5 != 0) {
            return -1;
        }
        int[] idx = new int[26];
        String s = "croak";
        for (int i = 0; i < 5; ++i) {
            idx[s.charAt(i) - 'a'] = i;
        }
        int[] cnt = new int[5];
        int ans = 0, x = 0;
        for (int k = 0; k < n; ++k) {
            int i = idx[croakOfFrogs.charAt(k) - 'a'];
            ++cnt[i];
            if (i == 0) {
                ans = Math.max(ans, ++x);
            } else {
                if (--cnt[i - 1] < 0) {
                    return -1;
                }
                if (i == 4) {
                    --x;
                }
            }
        }
        return x > 0 ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1419 _tcSol = new Solution1419();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "croakOfFrogs = \"croakcroak\"");
        try {
            String croakOfFrogs = "croakcroak";
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfFrogs(croakOfFrogs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "croakOfFrogs = \"crcoakroak\"");
        try {
            String croakOfFrogs = "crcoakroak";
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfFrogs(croakOfFrogs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "croakOfFrogs = \"croakcrook\"");
        try {
            String croakOfFrogs = "croakcrook";
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOfFrogs(croakOfFrogs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
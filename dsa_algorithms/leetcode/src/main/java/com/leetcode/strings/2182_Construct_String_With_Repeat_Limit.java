package com.leetcode.strings;

class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 25, j = 24; i >= 0; --i) {
            j = Math.min(j, i - 1);
            while (true) {
                for (int k = Math.min(cnt[i], repeatLimit); k > 0; --k) {
                    ans.append((char) ('a' + i));
                    --cnt[i];
                }
                if (cnt[i] == 0) {
                    break;
                }
                while (j >= 0 && cnt[j] == 0) {
                    --j;
                }
                if (j < 0) {
                    break;
                }
                ans.append((char) ('a' + j));
                --cnt[j];
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2182 _tcSol = new Solution2182();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"cczazcc\", repeatLimit = 3");
        try {
            String s = "cczazcc";
            int repeatLimit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatLimitedString(s, repeatLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"zzcccac\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aababab\", repeatLimit = 2");
        try {
            String s = "aababab";
            int repeatLimit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.repeatLimitedString(s, repeatLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"bbabaa\"");
        System.out.println();
    }
}
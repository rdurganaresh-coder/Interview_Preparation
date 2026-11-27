package com.leetcode.bit_manipulation_math;

class Solution2380 {
    public int secondsToRemoveOccurrences(String s) {
        char[] cs = s.toCharArray();
        boolean find = true;
        int ans = 0;
        while (find) {
            find = false;
            for (int i = 0; i < cs.length - 1; ++i) {
                if (cs[i] == '0' && cs[i + 1] == '1') {
                    char t = cs[i];
                    cs[i] = cs[i + 1];
                    cs[i + 1] = t;
                    ++i;
                    find = true;
                }
            }
            if (find) {
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
        Solution2380 _tcSol = new Solution2380();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0110101\"");
        try {
            String s = "0110101";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondsToRemoveOccurrences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"11100\"");
        try {
            String s = "11100";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondsToRemoveOccurrences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
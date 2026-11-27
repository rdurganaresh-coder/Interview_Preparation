package com.leetcode.sliding_window_two_pointers;

class Solution1147 {
    public int longestDecomposition(String text) {
        int ans = 0;
        for (int i = 0, j = text.length() - 1; i <= j;) {
            boolean ok = false;
            for (int k = 1; i + k - 1 < j - k + 1; ++k) {
                if (check(text, i, j - k + 1, k)) {
                    ans += 2;
                    i += k;
                    j -= k;
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                ++ans;
                break;
            }
        }
        return ans;
    }

    private boolean check(String s, int i, int j, int k) {
        while (k-- > 0) {
            if (s.charAt(i++) != s.charAt(j++)) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1147 _tcSol = new Solution1147();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"ghiabcdefhelloadamhelloabcdefghi\"");
        try {
            String text = "ghiabcdefhelloadamhelloabcdefghi";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestDecomposition(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"merchant\"");
        try {
            String text = "merchant";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestDecomposition(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "text = \"antaprezatepzapreanta\"");
        try {
            String text = "antaprezatepzapreanta";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestDecomposition(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}
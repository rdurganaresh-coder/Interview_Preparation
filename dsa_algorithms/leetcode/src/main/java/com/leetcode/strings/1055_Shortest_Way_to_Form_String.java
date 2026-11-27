package com.leetcode.strings;

class Solution1055 {
    public int shortestWay(String source, String target) {
        int m = source.length(), n = target.length();
        int ans = 0, j = 0;
        while (j < n) {
            int i = 0;
            boolean ok = false;
            while (i < m && j < n) {
                if (source.charAt(i) == target.charAt(j)) {
                    ok = true;
                    ++j;
                }
                ++i;
            }
            if (!ok) {
                return -1;
            }
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1055 _tcSol = new Solution1055();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = \"abc\", target = \"abcbc\"");
        try {
            String source = "abc";
            String target = "abcbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestWay(source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = \"abc\", target = \"acdbc\"");
        try {
            String source = "abc";
            String target = "acdbc";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestWay(source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "source = \"xyz\", target = \"xzyxz\"");
        try {
            String source = "xyz";
            String target = "xzyxz";
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestWay(source, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2868 {
    public boolean canAliceWin(String[] a, String[] b) {
        int i = 1, j = 0;
        boolean k = true;
        String w = a[0];
        while (true) {
            if (k) {
                if (j == b.length) {
                    return true;
                }
                if ((b[j].charAt(0) == w.charAt(0) && w.compareTo(b[j]) < 0)
                    || b[j].charAt(0) - w.charAt(0) == 1) {
                    w = b[j];
                    k = !k;
                }
                ++j;
            } else {
                if (i == a.length) {
                    return false;
                }
                if ((a[i].charAt(0) == w.charAt(0) && w.compareTo(a[i]) < 0)
                    || a[i].charAt(0) - w.charAt(0) == 1) {
                    w = a[i];
                    k = !k;
                }
                ++i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2868 _tcSol = new Solution2868();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = [\"avokado\",\"dabar\"], b = [\"brazil\"]");
        try {
            String[] a = new String[]{"avokado", "dabar"};
            String[] b = new String[]{"brazil"};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = [\"ananas\",\"atlas\",\"banana\"], b = [\"albatros\",\"cikla\",\"nogomet\"]");
        try {
            String[] a = new String[]{"ananas", "atlas", "banana"};
            String[] b = new String[]{"albatros", "cikla", "nogomet"};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = [\"hrvatska\",\"zastava\"], b = [\"bijeli\",\"galeb\"]");
        try {
            String[] a = new String[]{"hrvatska", "zastava"};
            String[] b = new String[]{"bijeli", "galeb"};
            System.out.println("  Output  : " + _tcShow(_tcSol.canAliceWin(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
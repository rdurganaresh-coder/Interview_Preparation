package com.leetcode.sliding_window_two_pointers;

class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check1(a, b) || check1(b, a);
    }

    private boolean check1(String a, String b) {
        int i = 0;
        int j = b.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        return i >= j || check2(a, i, j) || check2(b, i, j);
    }

    private boolean check2(String a, int i, int j) {
        while (i < j && a.charAt(i) == a.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1616 _tcSol = new Solution1616();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = \"xbdef\", b = \"xecab\"");
        try {
            String a = "xbdef";
            String b = "xecab";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkPalindromeFormation(a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
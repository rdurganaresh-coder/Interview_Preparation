package com.leetcode.bit_manipulation_math;

class Solution0761 {
    public String makeLargestSpecial(String s) {
        if ("".equals(s)) {
            return "";
        }
        List<String> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                String t = "1" + makeLargestSpecial(s.substring(j + 1, i)) + "0";
                ans.add(t);
                j = i + 1;
            }
        }
        ans.sort(Comparator.reverseOrder());
        return String.join("", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0761 _tcSol = new Solution0761();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"11011000\"");
        try {
            String s = "11011000";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeLargestSpecial(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11100100\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"10\"");
        try {
            String s = "10";
            System.out.println("  Output  : " + _tcShow(_tcSol.makeLargestSpecial(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"10\"");
        System.out.println();
    }
}
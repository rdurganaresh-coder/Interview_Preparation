package com.leetcode.strings;

class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (j < spaces.length && i == spaces[j]) {
                ans.append(' ');
                ++j;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2109 _tcSol = new Solution2109();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"LeetcodeHelpsMeLearn\", spaces = [8,13,15]");
        try {
            String s = "LeetcodeHelpsMeLearn";
            int[] spaces = new int[]{8, 13, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.addSpaces(s, spaces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Leetcode Helps Me Learn\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"icodeinpython\", spaces = [1,5,7,9]");
        try {
            String s = "icodeinpython";
            int[] spaces = new int[]{1, 5, 7, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.addSpaces(s, spaces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"i code in py thon\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"spacing\", spaces = [0,1,2,3,4,5,6]");
        try {
            String s = "spacing";
            int[] spaces = new int[]{0, 1, 2, 3, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.addSpaces(s, spaces)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\" s p a c i n g\"");
        System.out.println();
    }
}
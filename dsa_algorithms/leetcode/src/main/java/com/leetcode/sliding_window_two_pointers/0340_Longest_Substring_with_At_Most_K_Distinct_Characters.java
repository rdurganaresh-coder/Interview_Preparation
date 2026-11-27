package com.leetcode.sliding_window_two_pointers;

class Solution0340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            cnt.merge(c, 1, Integer::sum);
            if (cnt.size() > k) {
                if (cnt.merge(cs[l], -1, Integer::sum) == 0) {
                    cnt.remove(cs[l]);
                }
                ++l;
            }
        }
        return cs.length - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0340 _tcSol = new Solution0340();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"eceba\", k = 2");
        try {
            String s = "eceba";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubstringKDistinct(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aa\", k = 1");
        try {
            String s = "aa";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubstringKDistinct(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
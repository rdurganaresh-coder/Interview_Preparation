package com.leetcode.dynamic_programming;

class Solution1525 {
    public int numSplits(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        Set<Character> vis = new HashSet<>();
        int ans = 0;
        for (char c : s.toCharArray()) {
            vis.add(c);
            if (cnt.merge(c, -1, Integer::sum) == 0) {
                cnt.remove(c);
            }
            if (vis.size() == cnt.size()) {
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
        Solution1525 _tcSol = new Solution1525();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aacaba\"");
        try {
            String s = "aacaba";
            System.out.println("  Output  : " + _tcShow(_tcSol.numSplits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\"");
        try {
            String s = "abcd";
            System.out.println("  Output  : " + _tcShow(_tcSol.numSplits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
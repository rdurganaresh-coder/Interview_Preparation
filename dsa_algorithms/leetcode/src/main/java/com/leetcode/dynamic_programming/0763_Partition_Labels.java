package com.leetcode.dynamic_programming;

class Solution0763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int mx = 0, j = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, last[s.charAt(i) - 'a']);
            if (mx == i) {
                ans.add(i - j + 1);
                j = i + 1;
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
        Solution0763 _tcSol = new Solution0763();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ababcbacadefegdehijhklij\"");
        try {
            String s = "ababcbacadefegdehijhklij";
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionLabels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,7,8]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"eccbbbbdec\"");
        try {
            String s = "eccbbbbdec";
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionLabels(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10]");
        System.out.println();
    }
}
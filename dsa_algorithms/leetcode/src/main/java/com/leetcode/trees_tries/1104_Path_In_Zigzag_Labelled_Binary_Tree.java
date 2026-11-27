package com.leetcode.trees_tries;

class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int x = 1, i = 1;
        while ((x << 1) <= label) {
            x <<= 1;
            ++i;
        }
        List<Integer> ans = new ArrayList<>();
        for (; i > 0; --i) {
            ans.add(label);
            label = ((1 << (i - 1)) + (1 << i) - 1 - label) >> 1;
        }
        Collections.reverse(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1104 _tcSol = new Solution1104();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "label = 14");
        try {
            int label = 14;
            System.out.println("  Output  : " + _tcShow(_tcSol.pathInZigZagTree(label)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,4,14]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "label = 26");
        try {
            int label = 26;
            System.out.println("  Output  : " + _tcShow(_tcSol.pathInZigZagTree(label)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,6,10,26]");
        System.out.println();
    }
}
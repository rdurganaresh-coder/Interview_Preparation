package com.leetcode.backtracking;

class Solution0216_3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << 9; ++mask) {
            if (Integer.bitCount(mask) == k) {
                List<Integer> t = new ArrayList<>();
                int s = 0;
                for (int i = 0; i < 9; ++i) {
                    if ((mask >> i & 1) == 1) {
                        s += (i + 1);
                        t.add(i + 1);
                    }
                }
                if (s == n) {
                    ans.add(t);
                }
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
        Solution0216_3 _tcSol = new Solution0216_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 3, n = 7");
        try {
            int k = 3;
            int n = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 3, n = 9");
        try {
            int k = 3;
            int n = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,6],[1,3,5],[2,3,4]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 4, n = 1");
        try {
            int k = 4;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.combinationSum3(k, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
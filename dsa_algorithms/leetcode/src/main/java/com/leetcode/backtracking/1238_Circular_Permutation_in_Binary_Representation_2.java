package com.leetcode.backtracking;

class Solution1238_2 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            ans.add(i ^ (i >> 1) ^ start);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1238_2 _tcSol = new Solution1238_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, start = 3");
        try {
            int n = 2;
            int start = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.circularPermutation(n, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2,0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, start = 2");
        try {
            int n = 3;
            int start = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.circularPermutation(n, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,6,7,5,4,0,1,3]");
        System.out.println();
    }
}
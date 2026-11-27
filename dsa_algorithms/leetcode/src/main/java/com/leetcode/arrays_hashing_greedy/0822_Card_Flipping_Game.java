package com.leetcode.arrays_hashing_greedy;

class Solution0822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> s = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; ++i) {
            if (fronts[i] == backs[i]) {
                s.add(fronts[i]);
            }
        }
        int ans = 9999;
        for (int v : fronts) {
            if (!s.contains(v)) {
                ans = Math.min(ans, v);
            }
        }
        for (int v : backs) {
            if (!s.contains(v)) {
                ans = Math.min(ans, v);
            }
        }
        return ans % 9999;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0822 _tcSol = new Solution0822();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "fronts = [1,2,4,4,7], backs = [1,3,4,1,3]");
        try {
            int[] fronts = new int[]{1, 2, 4, 4, 7};
            int[] backs = new int[]{1, 3, 4, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.flipgame(fronts, backs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "fronts = [1], backs = [1]");
        try {
            int[] fronts = new int[]{1};
            int[] backs = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.flipgame(fronts, backs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
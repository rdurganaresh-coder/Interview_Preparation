package com.leetcode.backtracking;

class Solution2275 {
    public int largestCombination(int[] candidates) {
        int mx = Arrays.stream(candidates).max().getAsInt();
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(mx);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int cnt = 0;
            for (int x : candidates) {
                cnt += x >> i & 1;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2275 _tcSol = new Solution2275();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candidates = [16,17,71,62,12,24,14]");
        try {
            int[] candidates = new int[]{16, 17, 71, 62, 12, 24, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestCombination(candidates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candidates = [8,8]");
        try {
            int[] candidates = new int[]{8, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestCombination(candidates)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}

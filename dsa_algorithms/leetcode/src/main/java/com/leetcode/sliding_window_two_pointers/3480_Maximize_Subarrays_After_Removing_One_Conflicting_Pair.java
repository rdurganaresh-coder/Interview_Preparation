package com.leetcode.sliding_window_two_pointers;

class Solution3480 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            if (a > b) {
                int c = a;
                a = b;
                b = c;
            }
            g[a].add(b);
        }
        long[] cnt = new long[n + 2];
        long ans = 0, add = 0;
        int b1 = n + 1, b2 = n + 1;
        for (int a = n; a > 0; --a) {
            for (int b : g[a]) {
                if (b < b1) {
                    b2 = b1;
                    b1 = b;
                } else if (b < b2) {
                    b2 = b;
                }
            }
            ans += b1 - a;
            cnt[b1] += b2 - b1;
            add = Math.max(add, cnt[b1]);
        }
        ans += add;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3480 _tcSol = new Solution3480();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, conflictingPairs = [[2,3],[1,4]]");
        try {
            int n = 4;
            int[][] conflictingPairs = new int[][]{new int[]{2, 3}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrays(n, conflictingPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, conflictingPairs = [[1,2],[2,5],[3,5]]");
        try {
            int n = 5;
            int[][] conflictingPairs = new int[][]{new int[]{1, 2}, new int[]{2, 5}, new int[]{3, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubarrays(n, conflictingPairs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}

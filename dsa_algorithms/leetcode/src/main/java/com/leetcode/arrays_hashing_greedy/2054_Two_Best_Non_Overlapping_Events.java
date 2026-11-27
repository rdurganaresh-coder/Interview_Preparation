package com.leetcode.arrays_hashing_greedy;

class Solution2054 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = Math.max(f[i + 1], events[i][2]);
        }
        int ans = 0;
        for (int[] e : events) {
            int v = e[2];
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (events[mid][0] > e[1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left < n) {
                v += f[left];
            }
            ans = Math.max(ans, v);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2054 _tcSol = new Solution2054();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "events = [[1,3,2],[4,5,2],[2,4,3]]");
        try {
            int[][] events = new int[][]{new int[]{1, 3, 2}, new int[]{4, 5, 2}, new int[]{2, 4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTwoEvents(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "events = [[1,3,2],[4,5,2],[1,5,5]]");
        try {
            int[][] events = new int[][]{new int[]{1, 3, 2}, new int[]{4, 5, 2}, new int[]{1, 5, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTwoEvents(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "events = [[1,5,3],[1,5,1],[6,6,5]]");
        try {
            int[][] events = new int[][]{new int[]{1, 5, 3}, new int[]{1, 5, 1}, new int[]{6, 6, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTwoEvents(events)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}
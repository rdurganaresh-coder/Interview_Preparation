package com.leetcode.dynamic_programming;

class Solution2813 {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        int n = items.length;
        long tot = 0;
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> dup = new ArrayDeque<>();
        for (int i = 0; i < k; ++i) {
            int p = items[i][0], c = items[i][1];
            tot += p;
            if (!vis.add(c)) {
                dup.push(p);
            }
        }
        long ans = tot + (long) vis.size() * vis.size();
        for (int i = k; i < n; ++i) {
            int p = items[i][0], c = items[i][1];
            if (vis.contains(c) || dup.isEmpty()) {
                continue;
            }
            vis.add(c);
            tot += p - dup.pop();
            ans = Math.max(ans, tot + (long) vis.size() * vis.size());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2813 _tcSol = new Solution2813();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "items = [[3,2],[5,1],[10,1]], k = 2");
        try {
            int[][] items = new int[][]{new int[]{3, 2}, new int[]{5, 1}, new int[]{10, 1}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumElegance(items, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "items = [[3,1],[3,1],[2,2],[5,3]], k = 3");
        try {
            int[][] items = new int[][]{new int[]{3, 1}, new int[]{3, 1}, new int[]{2, 2}, new int[]{5, 3}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumElegance(items, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "items = [[1,1],[2,1],[3,1]], k = 3");
        try {
            int[][] items = new int[][]{new int[]{1, 1}, new int[]{2, 1}, new int[]{3, 1}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumElegance(items, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
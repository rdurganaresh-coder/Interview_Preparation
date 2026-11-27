package com.leetcode.sliding_window_two_pointers;

class Solution1168 {
    private int[] p;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[][] nums = Arrays.copyOf(pipes, pipes.length + n);
        for (int i = 0; i < n; i++) {
            nums[pipes.length + i] = new int[] {0, i + 1, wells[i]};
        }
        Arrays.sort(nums, (a, b) -> a[2] - b[2]);
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        int ans = 0;
        for (var x : nums) {
            int a = x[0], b = x[1], c = x[2];
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                p[pa] = pb;
                ans += c;
                if (--n == 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1168 _tcSol = new Solution1168();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]");
        try {
            int n = 3;
            int[] wells = new int[]{1, 2, 2};
            int[][] pipes = new int[][]{new int[]{1, 2, 1}, new int[]{2, 3, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostToSupplyWater(n, wells, pipes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, wells = [1,1], pipes = [[1,2,1],[1,2,2]]");
        try {
            int n = 2;
            int[] wells = new int[]{1, 1};
            int[][] pipes = new int[][]{new int[]{1, 2, 1}, new int[]{1, 2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCostToSupplyWater(n, wells, pipes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
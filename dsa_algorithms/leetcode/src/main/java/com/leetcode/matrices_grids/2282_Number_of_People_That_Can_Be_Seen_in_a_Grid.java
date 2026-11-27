package com.leetcode.matrices_grids;

class Solution2282 {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] ans = new int[m][0];
        for (int i = 0; i < m; ++i) {
            ans[i] = f(heights[i]);
        }
        for (int j = 0; j < n; ++j) {
            int[] nums = new int[m];
            for (int i = 0; i < m; ++i) {
                nums[i] = heights[i][j];
            }
            int[] add = f(nums);
            for (int i = 0; i < m; ++i) {
                ans[i][j] += add[i];
            }
        }
        return ans;
    }

    private int[] f(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                stk.pop();
                ++ans[i];
            }
            if (!stk.isEmpty()) {
                ++ans[i];
            }
            while (!stk.isEmpty() && stk.peek() == nums[i]) {
                stk.pop();
            }
            stk.push(nums[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2282 _tcSol = new Solution2282();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [[3,1,4,2,5]]");
        try {
            int[][] heights = new int[][]{new int[]{3, 1, 4, 2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.seePeople(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,1,2,1,0]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [[5,1],[3,1],[4,1]]");
        try {
            int[][] heights = new int[][]{new int[]{5, 1}, new int[]{3, 1}, new int[]{4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.seePeople(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[3,1],[2,1],[1,0]]");
        System.out.println();
    }
}
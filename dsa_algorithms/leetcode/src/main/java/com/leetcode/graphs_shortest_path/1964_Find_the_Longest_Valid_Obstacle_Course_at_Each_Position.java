package com.leetcode.graphs_shortest_path;

class BinaryIndexedTree1964 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1964(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s = Math.max(s, c[x]);
            x -= x & -x;
        }
        return s;
    }
}

class Solution1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] nums = obstacles.clone();
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[n];
        BinaryIndexedTree1964 tree = new BinaryIndexedTree1964(n);
        for (int k = 0; k < n; ++k) {
            int x = obstacles[k];
            int i = Arrays.binarySearch(nums, x) + 1;
            ans[k] = tree.query(i) + 1;
            tree.update(i, ans[k]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1964 _tcSol = new Solution1964();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "obstacles = [1,2,3,2]");
        try {
            int[] obstacles = new int[]{1, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestObstacleCourseAtEachPosition(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "obstacles = [2,2,1]");
        try {
            int[] obstacles = new int[]{2, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestObstacleCourseAtEachPosition(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "obstacles = [3,1,5,6,4,2]");
        try {
            int[] obstacles = new int[]{3, 1, 5, 6, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestObstacleCourseAtEachPosition(obstacles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,2,3,2,2]");
        System.out.println();
    }
}
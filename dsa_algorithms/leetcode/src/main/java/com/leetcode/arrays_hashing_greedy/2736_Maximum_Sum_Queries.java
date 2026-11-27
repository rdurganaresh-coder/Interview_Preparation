package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2736 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2736(int n) {
        this.n = n;
        c = new int[n + 1];
        Arrays.fill(c, -1);
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mx = -1;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}

class Solution2736 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] nums = new int[n][0];
        for (int i = 0; i < n; ++i) {
            nums[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        Arrays.sort(nums2);
        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][0] - queries[i][0]);
        int[] ans = new int[m];
        int j = 0;
        BinaryIndexedTree2736 tree = new BinaryIndexedTree2736(n);
        for (int i : idx) {
            int x = queries[i][0], y = queries[i][1];
            for (; j < n && nums[j][0] >= x; ++j) {
                int k = n - Arrays.binarySearch(nums2, nums[j][1]);
                tree.update(k, nums[j][0] + nums[j][1]);
            }
            int p = Arrays.binarySearch(nums2, y);
            int k = p >= 0 ? n - p : n + p + 1;
            ans[i] = tree.query(k);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2736 _tcSol = new Solution2736();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]");
        try {
            int[] nums1 = new int[]{4, 3, 1, 2};
            int[] nums2 = new int[]{2, 4, 9, 5};
            int[][] queries = new int[][]{new int[]{4, 1}, new int[]{1, 3}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumQueries(nums1, nums2, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,10,7]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]");
        try {
            int[] nums1 = new int[]{3, 2, 5};
            int[] nums2 = new int[]{2, 3, 4};
            int[][] queries = new int[][]{new int[]{4, 4}, new int[]{3, 2}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumQueries(nums1, nums2, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,9,9]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]");
        try {
            int[] nums1 = new int[]{2, 1};
            int[] nums2 = new int[]{2, 3};
            int[][] queries = new int[][]{new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumQueries(nums1, nums2, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();
    }
}
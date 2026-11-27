package com.leetcode.arrays_hashing_greedy;

class Solution1923 {
    int N = 100010;
    long[] h = new long[N];
    long[] p = new long[N];
    private int[][] paths;
    Map<Long, Integer> cnt = new HashMap<>();
    Map<Long, Integer> inner = new HashMap<>();

    public int longestCommonSubpath(int n, int[][] paths) {
        int left = 0, right = N;
        for (int[] path : paths) {
            right = Math.min(right, path.length);
        }
        this.paths = paths;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int mid) {
        cnt.clear();
        inner.clear();
        p[0] = 1;
        for (int j = 0; j < paths.length; ++j) {
            int n = paths[j].length;
            for (int i = 1; i <= n; ++i) {
                p[i] = p[i - 1] * 133331;
                h[i] = h[i - 1] * 133331 + paths[j][i - 1];
            }
            for (int i = mid; i <= n; ++i) {
                long val = get(i - mid + 1, i);
                if (!inner.containsKey(val) || inner.get(val) != j) {
                    inner.put(val, j);
                    cnt.put(val, cnt.getOrDefault(val, 0) + 1);
                }
            }
        }
        int max = 0;
        for (int val : cnt.values()) {
            max = Math.max(max, val);
        }
        return max == paths.length;
    }

    private long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1923 _tcSol = new Solution1923();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, paths = [[0,1,2,3,4], [2,3,4], [4,0,1,2,3]]");
        try {
            int n = 5;
            int[][] paths = new int[][]{new int[]{0, 1, 2, 3, 4}, new int[]{2, 3, 4}, new int[]{4, 0, 1, 2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubpath(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, paths = [[0],[1],[2]]");
        try {
            int n = 3;
            int[][] paths = new int[][]{new int[]{0}, new int[]{1}, new int[]{2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubpath(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, paths = [[0,1,2,3,4], [4,3,2,1,0]]");
        try {
            int n = 5;
            int[][] paths = new int[][]{new int[]{0, 1, 2, 3, 4}, new int[]{4, 3, 2, 1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestCommonSubpath(n, paths)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
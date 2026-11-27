package com.leetcode.arrays_hashing_greedy;

class Solution1722 {
    private int[] p;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] a : allowedSwaps) {
            p[find(a[0])] = find(a[1]);
        }
        Map<Integer, Map<Integer, Integer>> cnt = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int j = find(i);
            cnt.computeIfAbsent(j, k -> new HashMap<>()).merge(source[i], 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = find(i);
            Map<Integer, Integer> t = cnt.get(j);
            if (t.merge(target[i], -1, Integer::sum) < 0) {
                ++ans;
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
        Solution1722 _tcSol = new Solution1722();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]");
        try {
            int[] source = new int[]{1, 2, 3, 4};
            int[] target = new int[]{2, 1, 4, 5};
            int[][] allowedSwaps = new int[][]{new int[]{0, 1}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHammingDistance(source, target, allowedSwaps)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []");
        try {
            int[] source = new int[]{1, 2, 3, 4};
            int[] target = new int[]{1, 3, 2, 4};
            int[][] allowedSwaps = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHammingDistance(source, target, allowedSwaps)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]");
        try {
            int[] source = new int[]{5, 1, 2, 4, 3};
            int[] target = new int[]{1, 5, 4, 2, 3};
            int[][] allowedSwaps = new int[][]{new int[]{0, 4}, new int[]{4, 2}, new int[]{1, 3}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHammingDistance(source, target, allowedSwaps)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
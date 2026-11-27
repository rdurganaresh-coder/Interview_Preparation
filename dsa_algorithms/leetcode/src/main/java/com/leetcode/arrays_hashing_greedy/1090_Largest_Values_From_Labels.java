package com.leetcode.arrays_hashing_greedy;

class Solution1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[] {values[i], labels[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0, num = 0;
        for (int i = 0; i < n && num < numWanted; ++i) {
            int v = pairs[i][0], l = pairs[i][1];
            if (cnt.getOrDefault(l, 0) < useLimit) {
                cnt.merge(l, 1, Integer::sum);
                num += 1;
                ans += v;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1090 _tcSol = new Solution1090();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1");
        try {
            int[] values = new int[]{5, 4, 3, 2, 1};
            int[] labels = new int[]{1, 1, 2, 2, 3};
            int numWanted = 3;
            int useLimit = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestValsFromLabels(values, labels, numWanted, useLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2");
        try {
            int[] values = new int[]{5, 4, 3, 2, 1};
            int[] labels = new int[]{1, 3, 3, 3, 2};
            int numWanted = 3;
            int useLimit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestValsFromLabels(values, labels, numWanted, useLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1");
        try {
            int[] values = new int[]{9, 8, 8, 7, 6};
            int[] labels = new int[]{0, 0, 0, 1, 1};
            int numWanted = 3;
            int useLimit = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.largestValsFromLabels(values, labels, numWanted, useLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
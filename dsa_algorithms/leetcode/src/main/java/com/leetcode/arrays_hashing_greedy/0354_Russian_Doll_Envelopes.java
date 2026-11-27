package com.leetcode.arrays_hashing_greedy;

class Solution0354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> { return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]; });
        int n = envelopes.length;
        int[] d = new int[n + 1];
        d[1] = envelopes[0][1];
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int x = envelopes[i][1];
            if (x > d[size]) {
                d[++size] = x;
            } else {
                int left = 1, right = size;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] >= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                int p = d[left] >= x ? left : 1;
                d[p] = x;
            }
        }
        return size;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0354 _tcSol = new Solution0354();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "envelopes = [[5,4],[6,4],[6,7],[2,3]]");
        try {
            int[][] envelopes = new int[][]{new int[]{5, 4}, new int[]{6, 4}, new int[]{6, 7}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEnvelopes(envelopes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "envelopes = [[1,1],[1,1],[1,1]]");
        try {
            int[][] envelopes = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEnvelopes(envelopes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
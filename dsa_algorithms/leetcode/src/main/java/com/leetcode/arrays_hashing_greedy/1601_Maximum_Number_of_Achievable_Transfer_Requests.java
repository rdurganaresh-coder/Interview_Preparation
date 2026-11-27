package com.leetcode.arrays_hashing_greedy;

class Solution1601 {
    private int m;
    private int n;
    private int[][] requests;

    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;
        this.n = n;
        this.requests = requests;
        int ans = 0;
        for (int mask = 0; mask < 1 << m; ++mask) {
            int cnt = Integer.bitCount(mask);
            if (ans < cnt && check(mask)) {
                ans = cnt;
            }
        }
        return ans;
    }

    private boolean check(int mask) {
        int[] cnt = new int[n];
        for (int i = 0; i < m; ++i) {
            if ((mask >> i & 1) == 1) {
                int f = requests[i][0], t = requests[i][1];
                --cnt[f];
                ++cnt[t];
            }
        }
        for (int v : cnt) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1601 _tcSol = new Solution1601();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]");
        try {
            int n = 4;
            int[][] requests = new int[][]{new int[]{0, 3}, new int[]{3, 1}, new int[]{1, 2}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRequests(n, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution1024 {
    public int videoStitching(int[][] clips, int time) {
        int[] last = new int[time];
        for (var e : clips) {
            int a = e[0], b = e[1];
            if (a < time) {
                last[a] = Math.max(last[a], b);
            }
        }
        int ans = 0, mx = 0, pre = 0;
        for (int i = 0; i < time; ++i) {
            mx = Math.max(mx, last[i]);
            if (mx <= i) {
                return -1;
            }
            if (pre == i) {
                ++ans;
                pre = mx;
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
        Solution1024 _tcSol = new Solution1024();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10");
        try {
            int[][] clips = new int[][]{new int[]{0, 2}, new int[]{4, 6}, new int[]{8, 10}, new int[]{1, 9}, new int[]{1, 5}, new int[]{5, 9}};
            int time = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.videoStitching(clips, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "clips = [[0,1],[1,2]], time = 5");
        try {
            int[][] clips = new int[][]{new int[]{0, 1}, new int[]{1, 2}};
            int time = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.videoStitching(clips, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9");
        try {
            int[][] clips = new int[][]{new int[]{0, 1}, new int[]{6, 8}, new int[]{0, 2}, new int[]{5, 6}, new int[]{0, 4}, new int[]{0, 3}, new int[]{6, 7}, new int[]{1, 3}, new int[]{4, 7}, new int[]{1, 4}, new int[]{2, 5}, new int[]{2, 6}, new int[]{3, 4}, new int[]{4, 5}, new int[]{5, 7}, new int[]{6, 9}};
            int time = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.videoStitching(clips, time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
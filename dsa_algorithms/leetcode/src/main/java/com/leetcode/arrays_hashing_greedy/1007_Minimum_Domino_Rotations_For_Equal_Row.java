package com.leetcode.arrays_hashing_greedy;

class Solution1007 {
    private int n;
    private int[] tops;
    private int[] bottoms;

    public int minDominoRotations(int[] tops, int[] bottoms) {
        n = tops.length;
        this.tops = tops;
        this.bottoms = bottoms;
        int ans = Math.min(f(tops[0]), f(bottoms[0]));
        return ans > n ? -1 : ans;
    }

    private int f(int x) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; ++i) {
            if (tops[i] != x && bottoms[i] != x) {
                return n + 1;
            }
            cnt1 += tops[i] == x ? 1 : 0;
            cnt2 += bottoms[i] == x ? 1 : 0;
        }
        return n - Math.max(cnt1, cnt2);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1007 _tcSol = new Solution1007();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]");
        try {
            int[] tops = new int[]{2, 1, 2, 4, 2, 2};
            int[] bottoms = new int[]{5, 2, 6, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDominoRotations(tops, bottoms)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]");
        try {
            int[] tops = new int[]{3, 5, 1, 2, 3};
            int[] bottoms = new int[]{3, 6, 3, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDominoRotations(tops, bottoms)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
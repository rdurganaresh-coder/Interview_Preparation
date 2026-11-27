package com.leetcode.arrays_hashing_greedy;

class Solution2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int n = tiles.length;
        int s = 0, ans = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
                s += tiles[j][1] - tiles[j][0] + 1;
                ++j;
            }
            if (j < n && tiles[i][0] + carpetLen > tiles[j][0]) {
                ans = Math.max(ans, s + tiles[i][0] + carpetLen - tiles[j][0]);
            } else {
                ans = Math.max(ans, s);
            }
            s -= (tiles[i][1] - tiles[i][0] + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2271 _tcSol = new Solution2271();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tiles = [[1,5],[10,11],[12,18],[20,25],[30,32]], carpetLen = 10");
        try {
            int[][] tiles = new int[][]{new int[]{1, 5}, new int[]{10, 11}, new int[]{12, 18}, new int[]{20, 25}, new int[]{30, 32}};
            int carpetLen = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumWhiteTiles(tiles, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tiles = [[10,11],[1,1]], carpetLen = 2");
        try {
            int[][] tiles = new int[][]{new int[]{10, 11}, new int[]{1, 1}};
            int carpetLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumWhiteTiles(tiles, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
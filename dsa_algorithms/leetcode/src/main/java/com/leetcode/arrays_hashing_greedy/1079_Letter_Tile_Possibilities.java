package com.leetcode.arrays_hashing_greedy;

class Solution1079 {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++res;
                --cnt[i];
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1079 _tcSol = new Solution1079();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tiles = \"AAB\"");
        try {
            String tiles = "AAB";
            System.out.println("  Output  : " + _tcShow(_tcSol.numTilePossibilities(tiles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tiles = \"AAABBC\"");
        try {
            String tiles = "AAABBC";
            System.out.println("  Output  : " + _tcShow(_tcSol.numTilePossibilities(tiles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "188");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tiles = \"V\"");
        try {
            String tiles = "V";
            System.out.println("  Output  : " + _tcShow(_tcSol.numTilePossibilities(tiles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
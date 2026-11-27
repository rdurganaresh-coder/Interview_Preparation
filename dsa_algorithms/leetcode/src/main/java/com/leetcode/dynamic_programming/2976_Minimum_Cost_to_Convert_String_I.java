package com.leetcode.dynamic_programming;

class Solution2976 {
    public long minimumCost(
        String source, String target, char[] original, char[] changed, int[] cost) {
        final int inf = 1 << 29;
        int[][] g = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < original.length; ++i) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            int z = cost[i];
            g[x][y] = Math.min(g[x][y], z);
        }
        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        long ans = 0;
        int n = source.length();
        for (int i = 0; i < n; ++i) {
            int x = source.charAt(i) - 'a';
            int y = target.charAt(i) - 'a';
            if (x != y) {
                if (g[x][y] >= inf) {
                    return -1;
                }
                ans += g[x][y];
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
        Solution2976 _tcSol = new Solution2976();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = \"abcd\", target = \"acbe\", original = [\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"], changed = [\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"], cost = [2,5,5,1,2,20]");
        try {
            String source = "abcd";
            String target = "acbe";
            char[] original = new char[]{'a', 'b', 'c', 'c', 'e', 'd'};
            char[] changed = new char[]{'b', 'c', 'b', 'e', 'b', 'e'};
            int[] cost = new int[]{2, 5, 5, 1, 2, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = \"aaaa\", target = \"bbbb\", original = [\"a\",\"c\"], changed = [\"c\",\"b\"], cost = [1,2]");
        try {
            String source = "aaaa";
            String target = "bbbb";
            char[] original = new char[]{'a', 'c'};
            char[] changed = new char[]{'c', 'b'};
            int[] cost = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "source = \"abcd\", target = \"abce\", original = [\"a\"], changed = [\"e\"], cost = [10000]");
        try {
            String source = "abcd";
            String target = "abce";
            char[] original = new char[]{'a'};
            char[] changed = new char[]{'e'};
            int[] cost = new int[]{10000};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
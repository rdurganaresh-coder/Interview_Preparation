package com.leetcode.dynamic_programming;

class Node2977 {
    Node2977[] children = new Node2977[26];
    int v = -1;
}

class Solution2977 {
    private final long inf = 1L << 60;
    private Node2977 root = new Node2977();
    private int idx;

    private long[][] g;
    private char[] s;
    private char[] t;
    private Long[] f;

    public long minimumCost(
        String source, String target, String[] original, String[] changed, int[] cost) {
        int m = cost.length;
        g = new long[m << 1][m << 1];
        s = source.toCharArray();
        t = target.toCharArray();
        for (int i = 0; i < g.length; ++i) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < m; ++i) {
            int x = insert(original[i]);
            int y = insert(changed[i]);
            g[x][y] = Math.min(g[x][y], cost[i]);
        }
        for (int k = 0; k < idx; ++k) {
            for (int i = 0; i < idx; ++i) {
                if (g[i][k] >= inf) {
                    continue;
                }
                for (int j = 0; j < idx; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        f = new Long[s.length];
        long ans = dfs(0);
        return ans >= inf ? -1 : ans;
    }

    private int insert(String w) {
        Node2977 node = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Node2977();
            }
            node = node.children[i];
        }
        if (node.v < 0) {
            node.v = idx++;
        }
        return node.v;
    }

    private long dfs(int i) {
        if (i >= s.length) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        long res = s[i] == t[i] ? dfs(i + 1) : inf;
        Node2977 p = root, q = root;
        for (int j = i; j < s.length; ++j) {
            p = p.children[s[j] - 'a'];
            q = q.children[t[j] - 'a'];
            if (p == null || q == null) {
                break;
            }
            if (p.v < 0 || q.v < 0) {
                continue;
            }
            long t = g[p.v][q.v];
            if (t < inf) {
                res = Math.min(res, t + dfs(j + 1));
            }
        }
        return f[i] = res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2977 _tcSol = new Solution2977();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "source = \"abcd\", target = \"acbe\", original = [\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"], changed = [\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"], cost = [2,5,5,1,2,20]");
        try {
            String source = "abcd";
            String target = "acbe";
            String[] original = new String[]{"a", "b", "c", "c", "e", "d"};
            String[] changed = new String[]{"b", "c", "b", "e", "b", "e"};
            int[] cost = new int[]{2, 5, 5, 1, 2, 20};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "source = \"abcdefgh\", target = \"acdeeghh\", original = [\"bcd\",\"fgh\",\"thh\"], changed = [\"cde\",\"thh\",\"ghh\"], cost = [1,3,5]");
        try {
            String source = "abcdefgh";
            String target = "acdeeghh";
            String[] original = new String[]{"bcd", "fgh", "thh"};
            String[] changed = new String[]{"cde", "thh", "ghh"};
            int[] cost = new int[]{1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "source = \"abcdefgh\", target = \"addddddd\", original = [\"bcd\",\"defgh\"], changed = [\"ddd\",\"ddddd\"], cost = [100,1578]");
        try {
            String source = "abcdefgh";
            String target = "addddddd";
            String[] original = new String[]{"bcd", "defgh"};
            String[] changed = new String[]{"ddd", "ddddd"};
            int[] cost = new int[]{100, 1578};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(source, target, original, changed, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}

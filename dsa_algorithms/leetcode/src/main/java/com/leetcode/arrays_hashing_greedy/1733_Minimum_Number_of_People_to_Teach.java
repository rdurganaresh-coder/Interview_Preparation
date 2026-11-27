package com.leetcode.arrays_hashing_greedy;

class Solution1733 {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> s = new HashSet<>();
        for (var e : friendships) {
            int u = e[0], v = e[1];
            if (!check(u, v, languages)) {
                s.add(u);
                s.add(v);
            }
        }
        if (s.isEmpty()) {
            return 0;
        }
        int[] cnt = new int[n + 1];
        for (int u : s) {
            for (int l : languages[u - 1]) {
                ++cnt[l];
            }
        }
        int mx = 0;
        for (int v : cnt) {
            mx = Math.max(mx, v);
        }
        return s.size() - mx;
    }

    private boolean check(int u, int v, int[][] languages) {
        for (int x : languages[u - 1]) {
            for (int y : languages[v - 1]) {
                if (x == y) {
                    return true;
                }
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1733 _tcSol = new Solution1733();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]");
        try {
            int n = 2;
            int[][] languages = new int[][]{new int[]{1}, new int[]{2}, new int[]{1, 2}};
            int[][] friendships = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTeachings(n, languages, friendships)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]");
        try {
            int n = 3;
            int[][] languages = new int[][]{new int[]{2}, new int[]{1, 3}, new int[]{1, 2}, new int[]{3}};
            int[][] friendships = new int[][]{new int[]{1, 4}, new int[]{1, 2}, new int[]{3, 4}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTeachings(n, languages, friendships)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
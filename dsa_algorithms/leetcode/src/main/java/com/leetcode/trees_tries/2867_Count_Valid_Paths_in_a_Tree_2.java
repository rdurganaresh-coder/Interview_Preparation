package com.leetcode.trees_tries;

class Solution2867_2 {
    public long countPaths(int n, int[][] edges) {
        List<Boolean> prime = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            prime.add(true);
        }
        prime.set(1, false);

        List<Integer> all = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            if (prime.get(i)) {
                all.add(i);
            }
            for (int x : all) {
                int temp = i * x;
                if (temp > n) {
                    break;
                }
                prime.set(temp, false);
                if (i % x == 0) {
                    break;
                }
            }
        }

        List<List<Integer>> con = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            con.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            con.get(e[0]).add(e[1]);
            con.get(e[1]).add(e[0]);
        }

        long[] r = {0};
        dfs(1, 0, con, prime, r);
        return r[0];
    }

    private long mul(long x, long y) {
        return x * y;
    }

    private class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private Pair dfs(int x, int f, List<List<Integer>> con, List<Boolean> prime, long[] r) {
        Pair v = new Pair(!prime.get(x) ? 1 : 0, prime.get(x) ? 1 : 0);
        for (int y : con.get(x)) {
            if (y == f) continue;
            Pair p = dfs(y, x, con, prime, r);
            r[0] += mul(p.first, v.second) + mul(p.second, v.first);
            if (prime.get(x)) {
                v.second += p.first;
            } else {
                v.first += p.first;
                v.second += p.second;
            }
        }
        return v;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2867_2 _tcSol = new Solution2867_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]");
        try {
            int n = 5;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}, new int[]{2, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]");
        try {
            int n = 6;
            int[][] edges = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}, new int[]{3, 5}, new int[]{3, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPaths(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
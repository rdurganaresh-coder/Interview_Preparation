package com.leetcode.graphs_shortest_path;

class Solution1462_2 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] f = new boolean[n][n];
        List<Integer>[] g = new List[n];
        int[] indeg = new int[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var p : prerequisites) {
            g[p[0]].add(p[1]);
            ++indeg[p[1]];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                f[i][j] = true;
                for (int h = 0; h < n; ++h) {
                    f[h][j] |= f[h][i];
                }
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (var qry : queries) {
            ans.add(f[qry[0]][qry[1]]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1462_2 _tcSol = new Solution1462_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]");
        try {
            int n = 2;
            int[][] prerequisites = new int[][]{new int[]{1, 0}};
            int[][] queries = new int[][]{new int[]{0, 1}, new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,true]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]");
        try {
            int n = 2;
            int[][] prerequisites = new int[][]{};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]");
        try {
            int n = 3;
            int[][] prerequisites = new int[][]{new int[]{1, 2}, new int[]{1, 0}, new int[]{2, 0}};
            int[][] queries = new int[][]{new int[]{1, 0}, new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkIfPrerequisite(n, prerequisites, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,true]");
        System.out.println();
    }
}
package com.leetcode.graphs_shortest_path;

class Solution0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (var p : prerequisites) {
            int a = p[0], b = p[1];
            g[b].add(a);
            ++indeg[a];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ans[cnt++] = i;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return cnt == numCourses ? ans : new int[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0210 _tcSol = new Solution0210();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [[1,0]]");
        try {
            int numCourses = 2;
            int[][] prerequisites = new int[][]{new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOrder(numCourses, prerequisites)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]");
        try {
            int numCourses = 4;
            int[][] prerequisites = new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOrder(numCourses, prerequisites)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,1,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "numCourses = 1, prerequisites = []");
        try {
            int numCourses = 1;
            int[][] prerequisites = new int[][]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.findOrder(numCourses, prerequisites)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();
    }
}
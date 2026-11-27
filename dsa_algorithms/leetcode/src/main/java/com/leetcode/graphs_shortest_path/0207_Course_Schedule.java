package com.leetcode.graphs_shortest_path;

class Solution0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!q.isEmpty()) {
            int i = q.poll();
            --numCourses;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return numCourses == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0207 _tcSol = new Solution0207();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [[1,0]]");
        try {
            int numCourses = 2;
            int[][] prerequisites = new int[][]{new int[]{1, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canFinish(numCourses, prerequisites)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numCourses = 2, prerequisites = [[1,0],[0,1]]");
        try {
            int numCourses = 2;
            int[][] prerequisites = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.canFinish(numCourses, prerequisites)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}

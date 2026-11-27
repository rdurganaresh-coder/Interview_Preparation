package com.leetcode.graphs_shortest_path;

class Solution2246_2 {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        int[] down = new int[n];
        int ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], state = cur[1];
            if (state == 0) {
                stk.push(new int[] {i, 1});
                for (int j : g[i]) {
                    stk.push(new int[] {j, 0});
                }
            } else {
                int mx = 0;
                for (int j : g[i]) {
                    int x = down[j] + 1;
                    if (s.charAt(i) != s.charAt(j)) {
                        ans = Math.max(ans, mx + x);
                        mx = Math.max(mx, x);
                    }
                }
                down[i] = mx;
            }
        }
        return ans + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2246_2 _tcSol = new Solution2246_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,2], s = \"abacbe\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 1, 1, 2};
            String s = "abacbe";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPath(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,0,0], s = \"aabc\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 0};
            String s = "aabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.longestPath(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}

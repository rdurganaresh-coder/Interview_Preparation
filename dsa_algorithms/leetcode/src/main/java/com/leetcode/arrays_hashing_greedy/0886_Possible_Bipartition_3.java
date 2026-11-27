package com.leetcode.arrays_hashing_greedy;

class Solution0886_3 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : dislikes) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        int[] color = new int[n];
        for (int start = 0; start < n; ++start) {
            if (color[start] != 0) {
                continue;
            }
            color[start] = 1;
            Deque<Integer> stk = new ArrayDeque<>();
            stk.push(start);
            while (!stk.isEmpty()) {
                int i = stk.pop();
                for (int j : g[i]) {
                    if (color[j] == color[i]) {
                        return false;
                    }
                    if (color[j] == 0) {
                        color[j] = 3 - color[i];
                        stk.push(j);
                    }
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0886_3 _tcSol = new Solution0886_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, dislikes = [[1,2],[1,3],[2,4]]");
        try {
            int n = 4;
            int[][] dislikes = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleBipartition(n, dislikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, dislikes = [[1,2],[1,3],[2,3]]");
        try {
            int n = 3;
            int[][] dislikes = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.possibleBipartition(n, dislikes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}

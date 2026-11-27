package com.leetcode.arrays_hashing_greedy;

class Solution3310_2 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] f = new List[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(f, i -> new ArrayList<>());
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : invocations) {
            int a = e[0], b = e[1];
            f[a].add(b);
            f[b].add(a);
            g[a].add(b);
        }
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(k);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            for (int j : g[i]) {
                if (!suspicious[j]) {
                    suspicious[j] = true;
                    stk.push(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (suspicious[i] || vis[i]) {
                continue;
            }
            vis[i] = true;
            stk.push(i);
            while (!stk.isEmpty()) {
                int u = stk.pop();
                for (int j : f[u]) {
                    if (!vis[j]) {
                        suspicious[j] = false;
                        vis[j] = true;
                        stk.push(j);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!suspicious[i]) {
                ans.add(i);
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
        Solution3310_2 _tcSol = new Solution3310_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]");
        try {
            int n = 4;
            int k = 1;
            int[][] invocations = new int[][]{new int[]{1, 2}, new int[]{0, 1}, new int[]{3, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.remainingMethods(n, k, invocations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]");
        try {
            int n = 5;
            int k = 0;
            int[][] invocations = new int[][]{new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 1}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.remainingMethods(n, k, invocations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]");
        try {
            int n = 3;
            int k = 2;
            int[][] invocations = new int[][]{new int[]{1, 2}, new int[]{0, 1}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.remainingMethods(n, k, invocations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}

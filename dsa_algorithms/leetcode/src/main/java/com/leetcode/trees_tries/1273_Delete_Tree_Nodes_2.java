package com.leetcode.trees_tries;

class Solution1273_2 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<Integer>[] g = new List[nodes];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < nodes; ++i) {
            g[parent[i]].add(i);
        }
        int[] sum = new int[nodes];
        int[] cnt = new int[nodes];
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
                int s = value[i], m = 1;
                for (int j : g[i]) {
                    s += sum[j];
                    m += cnt[j];
                }
                if (s == 0) {
                    m = 0;
                }
                sum[i] = s;
                cnt[i] = m;
            }
        }
        return cnt[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1273_2 _tcSol = new Solution1273_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]");
        try {
            int nodes = 7;
            int[] parent = new int[]{-1, 0, 0, 1, 2, 2, 2};
            int[] value = new int[]{1, -2, 4, 0, -2, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteTreeNodes(nodes, parent, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]");
        try {
            int nodes = 7;
            int[] parent = new int[]{-1, 0, 0, 1, 2, 2, 2};
            int[] value = new int[]{1, -2, 4, 0, -2, -1, -2};
            System.out.println("  Output  : " + _tcShow(_tcSol.deleteTreeNodes(nodes, parent, value)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}

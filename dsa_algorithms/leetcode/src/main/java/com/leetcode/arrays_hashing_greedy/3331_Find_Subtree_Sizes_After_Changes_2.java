package com.leetcode.arrays_hashing_greedy;

class Solution3331_2 {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = s.length();
        List<Integer>[] g = new List[n];
        List<Integer>[] d = new List[26];
        Arrays.setAll(g, k -> new ArrayList<>());
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        int[] ans = new int[n];
        char[] cs = s.toCharArray();
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            int idx = cs[i] - 'a';
            if (state == 0) {
                ans[i] = 1;
                d[idx].add(i);
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    stk.push(new int[] {j, i, 0});
                }
            } else {
                int k = d[idx].size() > 1 ? d[idx].get(d[idx].size() - 2) : fa;
                if (k >= 0) {
                    ans[k] += ans[i];
                }
                d[idx].remove(d[idx].size() - 1);
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
        Solution3331_2 _tcSol = new Solution3331_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,1], s = \"abaabc\"");
        try {
            int[] parent = new int[]{-1, 0, 0, 1, 1, 1};
            String s = "abaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubtreeSizes(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,3,1,1,1,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,4,0,1], s = \"abbba\"");
        try {
            int[] parent = new int[]{-1, 0, 4, 0, 1};
            String s = "abbba";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSubtreeSizes(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,2,1,1,1]");
        System.out.println();
    }
}

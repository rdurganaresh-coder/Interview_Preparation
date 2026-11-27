package com.leetcode.linked_lists;

class Solution2876 {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] ans = new int[n];
        int[] vis = new int[n];
        for (int i = 0; i < n; ++i) {
            if (ans[i] == 0) {
                int cnt = 0, j = i;
                while (vis[j] == 0) {
                    vis[j] = ++cnt;
                    j = edges.get(j);
                }
                int cycle = 0, total = cnt + ans[j];
                if (ans[j] == 0) {
                    cycle = cnt - vis[j] + 1;
                }
                j = i;
                while (ans[j] == 0) {
                    ans[j] = Math.max(total--, cycle);
                    j = edges.get(j);
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2876 _tcSol = new Solution2876();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "edges = [1,2,0,0]");
        try {
            List<Integer> edges = _tcL(1, 2, 0, 0);
            System.out.println("  Output  : " + _tcShow(_tcSol.countVisitedNodes(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "edges = [1,2,3,4,0]");
        try {
            List<Integer> edges = _tcL(1, 2, 3, 4, 0);
            System.out.println("  Output  : " + _tcShow(_tcSol.countVisitedNodes(edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,5,5,5,5]");
        System.out.println();
    }
}
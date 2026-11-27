package com.leetcode.arrays_hashing_greedy;

class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var cnt = new int[n];
        for (var e : edges) {
            ++cnt[e.get(1)];
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (cnt[i] == 0) {
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

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution1557 _tcSol = new Solution1557();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]");
        try {
            int n = 6;
            List<List<Integer>> edges = _tcL(_tcL(0, 1), _tcL(0, 2), _tcL(2, 5), _tcL(3, 4), _tcL(4, 2));
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestSetOfVertices(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]");
        try {
            int n = 5;
            List<List<Integer>> edges = _tcL(_tcL(0, 1), _tcL(2, 1), _tcL(3, 1), _tcL(1, 4), _tcL(2, 4));
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestSetOfVertices(n, edges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,3]");
        System.out.println();
    }
}
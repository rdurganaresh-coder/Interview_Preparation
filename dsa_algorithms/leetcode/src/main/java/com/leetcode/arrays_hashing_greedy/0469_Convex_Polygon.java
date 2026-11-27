package com.leetcode.arrays_hashing_greedy;

class Solution0469 {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long pre = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            var p1 = points.get(i);
            var p2 = points.get((i + 1) % n);
            var p3 = points.get((i + 2) % n);
            int x1 = p2.get(0) - p1.get(0);
            int y1 = p2.get(1) - p1.get(1);
            int x2 = p3.get(0) - p1.get(0);
            int y2 = p3.get(1) - p1.get(1);
            cur = x1 * y2 - x2 * y1;
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
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
        Solution0469 _tcSol = new Solution0469();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[0,0],[0,5],[5,5],[5,0]]");
        try {
            List<List<Integer>> points = _tcL(_tcL(0, 0), _tcL(0, 5), _tcL(5, 5), _tcL(5, 0));
            System.out.println("  Output  : " + _tcShow(_tcSol.isConvex(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[0,0],[0,10],[10,10],[10,0],[5,5]]");
        try {
            List<List<Integer>> points = _tcL(_tcL(0, 0), _tcL(0, 10), _tcL(10, 10), _tcL(10, 0), _tcL(5, 5));
            System.out.println("  Output  : " + _tcShow(_tcSol.isConvex(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
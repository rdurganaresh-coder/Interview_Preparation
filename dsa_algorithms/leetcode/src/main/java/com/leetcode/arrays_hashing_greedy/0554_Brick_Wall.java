package com.leetcode.arrays_hashing_greedy;

class Solution0554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (var row : wall) {
            long s = 0;
            for (int i = 0; i + 1 < row.size(); ++i) {
                s += row.get(i);
                cnt.merge(s, 1, Integer::sum);
            }
        }
        int mx = 0;
        for (var x : cnt.values()) {
            mx = Math.max(mx, x);
        }
        return wall.size() - mx;
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
        Solution0554 _tcSol = new Solution0554();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]");
        try {
            List<List<Integer>> wall = _tcL(_tcL(1, 2, 2, 1), _tcL(3, 1, 2), _tcL(1, 3, 2), _tcL(2, 4), _tcL(3, 1, 2), _tcL(1, 3, 1, 1));
            System.out.println("  Output  : " + _tcShow(_tcSol.leastBricks(wall)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "wall = [[1],[1],[1]]");
        try {
            List<List<Integer>> wall = _tcL(_tcL(1), _tcL(1), _tcL(1));
            System.out.println("  Output  : " + _tcShow(_tcSol.leastBricks(wall)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}

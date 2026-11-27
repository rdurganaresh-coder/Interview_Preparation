package com.leetcode.arrays_hashing_greedy;

class Solution1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> v = new ArrayList<>();
        int x = location.get(0), y = location.get(1);
        int same = 0;
        for (List<Integer> p : points) {
            int xi = p.get(0), yi = p.get(1);
            if (xi == x && yi == y) {
                ++same;
                continue;
            }
            v.add(Math.atan2(yi - y, xi - x));
        }
        Collections.sort(v);
        int n = v.size();
        for (int i = 0; i < n; ++i) {
            v.add(v.get(i) + 2 * Math.PI);
        }
        int mx = 0;
        Double t = angle * Math.PI / 180;
        for (int i = 0, j = 0; j < 2 * n; ++j) {
            while (i < j && v.get(j) - v.get(i) > t) {
                ++i;
            }
            mx = Math.max(mx, j - i + 1);
        }
        return mx + same;
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
        Solution1610 _tcSol = new Solution1610();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[2,1],[2,2],[3,3]], angle = 90, location = [1,1]");
        try {
            List<List<Integer>> points = _tcL(_tcL(2, 1), _tcL(2, 2), _tcL(3, 3));
            int angle = 90;
            List<Integer> location = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.visiblePoints(points, angle, location)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[2,1],[2,2],[3,4],[1,1]], angle = 90, location = [1,1]");
        try {
            List<List<Integer>> points = _tcL(_tcL(2, 1), _tcL(2, 2), _tcL(3, 4), _tcL(1, 1));
            int angle = 90;
            List<Integer> location = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.visiblePoints(points, angle, location)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[1,0],[2,1]], angle = 13, location = [1,1]");
        try {
            List<List<Integer>> points = _tcL(_tcL(1, 0), _tcL(2, 1));
            int angle = 13;
            List<Integer> location = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.visiblePoints(points, angle, location)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
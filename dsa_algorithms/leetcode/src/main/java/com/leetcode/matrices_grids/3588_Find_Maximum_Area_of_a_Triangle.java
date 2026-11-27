package com.leetcode.matrices_grids;

class Solution3588 {
    public long maxArea(int[][] coords) {
        long ans = calc(coords);
        for (int[] c : coords) {
            int tmp = c[0];
            c[0] = c[1];
            c[1] = tmp;
        }
        ans = Math.max(ans, calc(coords));
        return ans > 0 ? ans : -1;
    }

    private long calc(int[][] coords) {
        int mn = Integer.MAX_VALUE, mx = 0;
        Map<Integer, Integer> f = new HashMap<>();
        Map<Integer, Integer> g = new HashMap<>();

        for (int[] c : coords) {
            int x = c[0], y = c[1];
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
            if (f.containsKey(x)) {
                f.put(x, Math.min(f.get(x), y));
                g.put(x, Math.max(g.get(x), y));
            } else {
                f.put(x, y);
                g.put(x, y);
            }
        }

        long ans = 0;
        for (var e : f.entrySet()) {
            int x = e.getKey();
            int y = e.getValue();
            int d = g.get(x) - y;
            ans = Math.max(ans, (long) d * Math.max(mx - x, x - mn));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3588 _tcSol = new Solution3588();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coords = [[1,1],[1,2],[3,2],[3,3]]");
        try {
            int[][] coords = new int[][]{new int[]{1, 1}, new int[]{1, 2}, new int[]{3, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(coords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coords = [[1,1],[2,2],[3,3]]");
        try {
            int[][] coords = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxArea(coords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}

package com.leetcode.matrices_grids;

class Solution0939 {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> d = new TreeMap<>();
        for (var p : points) {
            int x = p[0], y = p[1];
            d.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        }
        Map<Integer, Integer> pos = new HashMap<>();
        int ans = 1 << 30;
        for (var e : d.entrySet()) {
            int x = e.getKey();
            var ys = e.getValue();
            Collections.sort(ys);
            int n = ys.size();
            for (int i = 0; i < n; ++i) {
                int y1 = ys.get(i);
                for (int j = i + 1; j < n; ++j) {
                    int y2 = ys.get(j);
                    int p = y1 * 40001 + y2;
                    if (pos.containsKey(p)) {
                        ans = Math.min(ans, (x - pos.get(p)) * (y2 - y1));
                    }
                    pos.put(p, x);
                }
            }
        }
        return ans == 1 << 30 ? 0 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0939 _tcSol = new Solution0939();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[1,1],[1,3],[3,1],[3,3],[2,2]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{1, 3}, new int[]{3, 1}, new int[]{3, 3}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAreaRect(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{1, 3}, new int[]{3, 1}, new int[]{3, 3}, new int[]{4, 1}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minAreaRect(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
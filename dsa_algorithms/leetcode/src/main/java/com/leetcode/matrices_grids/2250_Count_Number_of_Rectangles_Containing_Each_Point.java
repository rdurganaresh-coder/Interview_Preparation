package com.leetcode.matrices_grids;

class Solution2250 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = 101;
        List<Integer>[] d = new List[n];
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int[] r : rectangles) {
            d[r[1]].add(r[0]);
        }
        for (List<Integer> v : d) {
            Collections.sort(v);
        }
        int m = points.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int x = points[i][0], y = points[i][1];
            int cnt = 0;
            for (int h = y; h < n; ++h) {
                List<Integer> xs = d[h];
                int left = 0, right = xs.size();
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (xs.get(mid) >= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                cnt += xs.size() - left;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2250 _tcSol = new Solution2250();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]");
        try {
            int[][] rectangles = new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 5}};
            int[][] points = new int[][]{new int[]{2, 1}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countRectangles(rectangles, points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rectangles = [[1,1],[2,2],[3,3]], points = [[1,3],[1,1]]");
        try {
            int[][] rectangles = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            int[][] points = new int[][]{new int[]{1, 3}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countRectangles(rectangles, points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3]");
        System.out.println();
    }
}
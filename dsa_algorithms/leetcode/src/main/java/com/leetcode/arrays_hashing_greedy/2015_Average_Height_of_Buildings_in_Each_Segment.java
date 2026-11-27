package com.leetcode.arrays_hashing_greedy;

class Solution2015 {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (var e : buildings) {
            int start = e[0], end = e[1], height = e[2];
            cnt.merge(start, 1, Integer::sum);
            cnt.merge(end, -1, Integer::sum);
            d.merge(start, height, Integer::sum);
            d.merge(end, -height, Integer::sum);
        }
        int s = 0, m = 0;
        int last = -1;
        List<int[]> ans = new ArrayList<>();
        for (var e : d.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if (m > 0) {
                int avg = s / m;
                if (!ans.isEmpty() && ans.get(ans.size() - 1)[2] == avg
                    && ans.get(ans.size() - 1)[1] == last) {
                    ans.get(ans.size() - 1)[1] = k;
                } else {
                    ans.add(new int[] {last, k, avg});
                }
            }
            s += v;
            m += cnt.get(k);
            last = k;
        }
        return ans.toArray(new int[0][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2015 _tcSol = new Solution2015();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "buildings = [[1,4,2],[3,9,4]]");
        try {
            int[][] buildings = new int[][]{new int[]{1, 4, 2}, new int[]{3, 9, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageHeightOfBuildings(buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3,2],[3,4,3],[4,9,4]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "buildings = [[1,3,2],[2,5,3],[2,8,3]]");
        try {
            int[][] buildings = new int[][]{new int[]{1, 3, 2}, new int[]{2, 5, 3}, new int[]{2, 8, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageHeightOfBuildings(buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,3,2],[3,8,3]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "buildings = [[1,2,1],[5,6,1]]");
        try {
            int[][] buildings = new int[][]{new int[]{1, 2, 1}, new int[]{5, 6, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.averageHeightOfBuildings(buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,2,1],[5,6,1]]");
        System.out.println();
    }
}

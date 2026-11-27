package com.leetcode.arrays_hashing_greedy;

class Solution3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> g1 = new HashMap<>();
        Map<Integer, List<Integer>> g2 = new HashMap<>();

        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            g1.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            g2.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        for (var e : g1.entrySet()) {
            Collections.sort(e.getValue());
        }
        for (var e : g2.entrySet()) {
            Collections.sort(e.getValue());
        }

        int ans = 0;

        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            List<Integer> l1 = g1.get(x);
            List<Integer> l2 = g2.get(y);

            if (l2.get(0) < x && x < l2.get(l2.size() - 1) && l1.get(0) < y
                && y < l1.get(l1.size() - 1)) {
                ans++;
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
        Solution3531 _tcSol = new Solution3531();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]");
        try {
            int n = 3;
            int[][] buildings = new int[][]{new int[]{1, 2}, new int[]{2, 2}, new int[]{3, 2}, new int[]{2, 1}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCoveredBuildings(n, buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]");
        try {
            int n = 3;
            int[][] buildings = new int[][]{new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCoveredBuildings(n, buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]");
        try {
            int n = 5;
            int[][] buildings = new int[][]{new int[]{1, 3}, new int[]{3, 2}, new int[]{3, 3}, new int[]{3, 5}, new int[]{5, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCoveredBuildings(n, buildings)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
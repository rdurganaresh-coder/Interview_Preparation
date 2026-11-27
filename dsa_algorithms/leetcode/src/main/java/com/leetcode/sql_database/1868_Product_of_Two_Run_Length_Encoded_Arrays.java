package com.leetcode.sql_database;

class Solution1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = 0;
        for (var e : encoded1) {
            int vi = e[0], fi = e[1];
            while (fi > 0) {
                int f = Math.min(fi, encoded2[j][1]);
                int v = vi * encoded2[j][0];
                int m = ans.size();
                if (m > 0 && ans.get(m - 1).get(0) == v) {
                    ans.get(m - 1).set(1, ans.get(m - 1).get(1) + f);
                } else {
                    ans.add(new ArrayList<>(List.of(v, f)));
                }
                fi -= f;
                encoded2[j][1] -= f;
                if (encoded2[j][1] == 0) {
                    ++j;
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

    public static void main(String[] args) {
        Solution1868 _tcSol = new Solution1868();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "encoded1 = [[1,3],[2,3]], encoded2 = [[6,3],[3,3]]");
        try {
            int[][] encoded1 = new int[][]{new int[]{1, 3}, new int[]{2, 3}};
            int[][] encoded2 = new int[][]{new int[]{6, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRLEArray(encoded1, encoded2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[6,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "encoded1 = [[1,3],[2,1],[3,2]], encoded2 = [[2,3],[3,3]]");
        try {
            int[][] encoded1 = new int[][]{new int[]{1, 3}, new int[]{2, 1}, new int[]{3, 2}};
            int[][] encoded2 = new int[][]{new int[]{2, 3}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRLEArray(encoded1, encoded2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[2,3],[6,1],[9,2]]");
        System.out.println();
    }
}
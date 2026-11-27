package com.leetcode.matrices_grids;

class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m];
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            idx.add(i);
            int[] row = mat[i];
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] == 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = left;
        }
        idx.sort(Comparator.comparingInt(a -> res[a]));
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = idx.get(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1337 _tcSol = new Solution1337();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,1,0,0,0], [1,1,1,1,0], [1,0,0,0,0], [1,1,0,0,0], [1,1,1,1,1]], k = 3");
        try {
            int[][] mat = new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kWeakestRows(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[1,0,0,0], [1,1,1,1], [1,0,0,0], [1,0,0,0]], k = 2");
        try {
            int[][] mat = new int[][]{new int[]{1, 0, 0, 0}, new int[]{1, 1, 1, 1}, new int[]{1, 0, 0, 0}, new int[]{1, 0, 0, 0}};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kWeakestRows(mat, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();
    }
}
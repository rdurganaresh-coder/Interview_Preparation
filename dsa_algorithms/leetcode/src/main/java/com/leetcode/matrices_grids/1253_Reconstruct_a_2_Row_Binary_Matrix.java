package com.leetcode.matrices_grids;

class Solution1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (int j = 0; j < n; ++j) {
            int a = 0, b = 0;
            if (colsum[j] == 2) {
                a = b = 1;
                upper--;
                lower--;
            } else if (colsum[j] == 1) {
                if (upper > lower) {
                    upper--;
                    a = 1;
                } else {
                    lower--;
                    b = 1;
                }
            }
            if (upper < 0 || lower < 0) {
                break;
            }
            first.add(a);
            second.add(b);
        }
        return upper == 0 && lower == 0 ? List.of(first, second) : List.of();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1253 _tcSol = new Solution1253();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "upper = 2, lower = 1, colsum = [1,1,1]");
        try {
            int upper = 2;
            int lower = 1;
            int[] colsum = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.reconstructMatrix(upper, lower, colsum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,0],[0,0,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "upper = 2, lower = 3, colsum = [2,2,1,1]");
        try {
            int upper = 2;
            int lower = 3;
            int[] colsum = new int[]{2, 2, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.reconstructMatrix(upper, lower, colsum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]");
        try {
            int upper = 5;
            int lower = 5;
            int[] colsum = new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.reconstructMatrix(upper, lower, colsum)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]");
        System.out.println();
    }
}
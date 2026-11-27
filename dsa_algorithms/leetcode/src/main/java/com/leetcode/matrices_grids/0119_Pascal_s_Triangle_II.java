package com.leetcode.matrices_grids;

class Solution0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; ++i) {
            f.add(1);
        }
        for (int i = 2; i < rowIndex + 1; ++i) {
            for (int j = i - 1; j > 0; --j) {
                f.set(j, f.get(j) + f.get(j - 1));
            }
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0119 _tcSol = new Solution0119();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rowIndex = 3");
        try {
            int rowIndex = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getRow(rowIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,3,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rowIndex = 0");
        try {
            int rowIndex = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getRow(rowIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rowIndex = 1");
        try {
            int rowIndex = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getRow(rowIndex)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1]");
        System.out.println();
    }
}
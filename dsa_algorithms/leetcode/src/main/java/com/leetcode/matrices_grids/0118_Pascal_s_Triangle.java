package com.leetcode.matrices_grids;

class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        f.add(List.of(1));
        for (int i = 0; i < numRows - 1; ++i) {
            List<Integer> g = new ArrayList<>();
            g.add(1);
            for (int j = 1; j < f.get(i).size(); ++j) {
                g.add(f.get(i).get(j - 1) + f.get(i).get(j));
            }
            g.add(1);
            f.add(g);
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0118 _tcSol = new Solution0118();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numRows = 5");
        try {
            int numRows = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.generate(numRows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numRows = 1");
        try {
            int numRows = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.generate(numRows)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1]]");
        System.out.println();
    }
}
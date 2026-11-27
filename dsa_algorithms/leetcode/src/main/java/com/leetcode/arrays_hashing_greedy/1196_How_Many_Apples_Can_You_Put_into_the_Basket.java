package com.leetcode.arrays_hashing_greedy;

class Solution1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int s = 0;
        for (int i = 0; i < weight.length; ++i) {
            s += weight[i];
            if (s > 5000) {
                return i;
            }
        }
        return weight.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1196 _tcSol = new Solution1196();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "weight = [100,200,150,1000]");
        try {
            int[] weight = new int[]{100, 200, 150, 1000};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfApples(weight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "weight = [900,950,800,1000,700,800]");
        try {
            int[] weight = new int[]{900, 950, 800, 1000, 700, 800};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfApples(weight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}
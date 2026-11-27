package com.leetcode.dynamic_programming;

class Solution1547 {
    public int minCost(int n, int[] cuts) {
        List<Integer> nums = new ArrayList<>();
        for (int x : cuts) {
            nums.add(x);
        }
        nums.add(0);
        nums.add(n);
        Collections.sort(nums);
        int m = nums.size();
        int[][] f = new int[m][m];
        for (int l = 2; l < m; ++l) {
            for (int i = 0; i + l < m; ++i) {
                int j = i + l;
                f[i][j] = 1 << 30;
                for (int k = i + 1; k < j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + nums.get(j) - nums.get(i));
                }
            }
        }
        return f[0][m - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1547 _tcSol = new Solution1547();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 7, cuts = [1,3,4,5]");
        try {
            int n = 7;
            int[] cuts = new int[]{1, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(n, cuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 9, cuts = [5,6,1,4,2]");
        try {
            int n = 9;
            int[] cuts = new int[]{5, 6, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(n, cuts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();
    }
}
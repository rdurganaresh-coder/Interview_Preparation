package com.leetcode.arrays_hashing_greedy;

class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; ++i) {
            var e = variables[i];
            int a = e[0], b = e[1], c = e[2], m = e[3];
            if (qpow(qpow(a, b, 10), c, m) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int qpow(long a, int n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2961 _tcSol = new Solution2961();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2");
        try {
            int[][] variables = new int[][]{new int[]{2, 3, 3, 10}, new int[]{3, 3, 3, 1}, new int[]{6, 1, 1, 4}};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getGoodIndices(variables, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "variables = [[39,3,1000,1000]], target = 17");
        try {
            int[][] variables = new int[][]{new int[]{39, 3, 1000, 1000}};
            int target = 17;
            System.out.println("  Output  : " + _tcShow(_tcSol.getGoodIndices(variables, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
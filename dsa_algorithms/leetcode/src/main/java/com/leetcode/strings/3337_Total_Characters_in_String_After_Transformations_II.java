package com.leetcode.strings;

class Solution3337 {
    private final int mod = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int m = 26;

        int[] cnt = new int[m];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            int num = nums.get(i);
            for (int j = 1; j <= num; j++) {
                matrix[i][(i + j) % m] = 1;
            }
        }

        int[][] factor = matpow(matrix, t, m);
        int[] result = vectorMatrixMultiply(cnt, factor);
        int ans = 0;
        for (int val : result) {
            ans = (ans + val) % mod;
        }
        return ans;
    }

    private int[][] matmul(int[][] a, int[][] b) {
        int n = a.length;
        int p = b.length;
        int q = b[0].length;
        int[][] res = new int[n][q];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < p; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < q; j++) {
                    res[i][j] = (int) ((res[i][j] + 1L * a[i][k] * b[k][j]) % mod);
                }
            }
        }
        return res;
    }

    private int[][] matpow(int[][] mat, int power, int m) {
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++) {
            res[i][i] = 1;
        }
        while (power > 0) {
            if ((power & 1) != 0) {
                res = matmul(res, mat);
            }
            mat = matmul(mat, mat);
            power >>= 1;
        }
        return res;
    }

    private int[] vectorMatrixMultiply(int[] vector, int[][] matrix) {
        int n = matrix.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + 1L * vector[j] * matrix[j][i]) % mod;
            }
            result[i] = (int) sum;
        }
        return result;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3337 _tcSol = new Solution3337();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcyy\", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]");
        try {
            String s = "abcyy";
            int t = 2;
            List<Integer> nums = _tcL(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthAfterTransformations(s, t, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"azbk\", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]");
        try {
            String s = "azbk";
            int t = 1;
            List<Integer> nums = _tcL(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthAfterTransformations(s, t, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}

package com.leetcode.bit_manipulation_math;

class Solution3044 {
    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int a = -1; a <= 1; ++a) {
                    for (int b = -1; b <= 1; ++b) {
                        if (a == 0 && b == 0) {
                            continue;
                        }
                        int x = i + a, y = j + b, v = mat[i][j];
                        while (x >= 0 && x < m && y >= 0 && y < n) {
                            v = v * 10 + mat[x][y];
                            if (isPrime(v)) {
                                cnt.merge(v, 1, Integer::sum);
                            }
                            x += a;
                            y += b;
                        }
                    }
                }
            }
        }
        int ans = -1, mx = 0;
        for (var e : cnt.entrySet()) {
            int v = e.getKey(), x = e.getValue();
            if (mx < x || (mx == x && ans < v)) {
                mx = x;
                ans = v;
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3044 _tcSol = new Solution3044();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mat = [[1,1],[9,9],[1,1]]");
        try {
            int[][] mat = new int[][]{new int[]{1, 1}, new int[]{9, 9}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentPrime(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mat = [[7]]");
        try {
            int[][] mat = new int[][]{new int[]{7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentPrime(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "mat = [[9,7,8],[4,6,5],[2,8,6]]");
        try {
            int[][] mat = new int[][]{new int[]{9, 7, 8}, new int[]{4, 6, 5}, new int[]{2, 8, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequentPrime(mat)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "97");
        System.out.println();
    }
}
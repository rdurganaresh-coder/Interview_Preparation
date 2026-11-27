package com.leetcode.dynamic_programming;

class Solution1340 {
    private int n;
    private int d;
    private int[] arr;
    private Integer[] f;

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        this.d = d;
        this.arr = arr;
        f = new Integer[n];
        int ans = 1;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dfs(i));
        }
        return ans;
    }

    private int dfs(int i) {
        if (f[i] != null) {
            return f[i];
        }
        int ans = 1;
        for (int j = i - 1; j >= 0; --j) {
            if (i - j > d || arr[j] >= arr[i]) {
                break;
            }
            ans = Math.max(ans, 1 + dfs(j));
        }
        for (int j = i + 1; j < n; ++j) {
            if (j - i > d || arr[j] >= arr[i]) {
                break;
            }
            ans = Math.max(ans, 1 + dfs(j));
        }
        return f[i] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1340 _tcSol = new Solution1340();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2");
        try {
            int[] arr = new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
            int d = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxJumps(arr, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [3,3,3,3,3], d = 3");
        try {
            int[] arr = new int[]{3, 3, 3, 3, 3};
            int d = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxJumps(arr, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [7,6,5,4,3,2,1], d = 1");
        try {
            int[] arr = new int[]{7, 6, 5, 4, 3, 2, 1};
            int d = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxJumps(arr, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}

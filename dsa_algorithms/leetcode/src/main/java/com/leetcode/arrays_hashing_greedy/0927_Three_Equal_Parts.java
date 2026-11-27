package com.leetcode.arrays_hashing_greedy;

class Solution0927 {
    private int[] arr;

    public int[] threeEqualParts(int[] arr) {
        this.arr = arr;
        int cnt = 0;
        int n = arr.length;
        for (int v : arr) {
            cnt += v;
        }
        if (cnt % 3 != 0) {
            return new int[] {-1, -1};
        }
        if (cnt == 0) {
            return new int[] {0, n - 1};
        }
        cnt /= 3;

        int i = find(1), j = find(cnt + 1), k = find(cnt * 2 + 1);
        for (; k < n && arr[i] == arr[j] && arr[j] == arr[k]; ++i, ++j, ++k) {
        }
        return k == n ? new int[] {i - 1, j} : new int[] {-1, -1};
    }

    private int find(int x) {
        int s = 0;
        for (int i = 0; i < arr.length; ++i) {
            s += arr[i];
            if (s == x) {
                return i;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0927 _tcSol = new Solution0927();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,0,1,0,1]");
        try {
            int[] arr = new int[]{1, 0, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeEqualParts(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,0,1,1]");
        try {
            int[] arr = new int[]{1, 1, 0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeEqualParts(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,1,0,0,1]");
        try {
            int[] arr = new int[]{1, 1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeEqualParts(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2]");
        System.out.println();
    }
}
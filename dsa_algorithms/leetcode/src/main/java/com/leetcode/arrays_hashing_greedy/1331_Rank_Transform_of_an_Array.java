package com.leetcode.arrays_hashing_greedy;

class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] t = arr.clone();
        Arrays.sort(t);
        int m = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || t[i] != t[i - 1]) {
                t[m++] = t[i];
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = Arrays.binarySearch(t, 0, m, arr[i]) + 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1331 _tcSol = new Solution1331();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [40,10,20,30]");
        try {
            int[] arr = new int[]{40, 10, 20, 30};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayRankTransform(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,1,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [100,100,100]");
        try {
            int[] arr = new int[]{100, 100, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayRankTransform(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [37,12,28,9,100,56,80,5,12]");
        try {
            int[] arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayRankTransform(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,3,4,2,8,6,7,1,3]");
        System.out.println();
    }
}
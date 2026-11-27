package com.leetcode.arrays_hashing_greedy;

class Solution1299 {
    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, mx = -1; i >= 0; --i) {
            int x = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, x);
        }
        return arr;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1299 _tcSol = new Solution1299();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [17,18,5,4,6,1]");
        try {
            int[] arr = new int[]{17, 18, 5, 4, 6, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceElements(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[18,6,6,6,1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [400]");
        try {
            int[] arr = new int[]{400};
            System.out.println("  Output  : " + _tcShow(_tcSol.replaceElements(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();
    }
}

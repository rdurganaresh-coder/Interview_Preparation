package com.leetcode.arrays_hashing_greedy;

class Solution0845_2 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int l = 0, r = 0; l + 2 < n; l = r) {
            r = l + 1;
            if (arr[l] < arr[r]) {
                while (r + 1 < n && arr[r] < arr[r + 1]) {
                    ++r;
                }
                if (r + 1 < n && arr[r] > arr[r + 1]) {
                    while (r + 1 < n && arr[r] > arr[r + 1]) {
                        ++r;
                    }
                    ans = Math.max(ans, r - l + 1);
                } else {
                    ++r;
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0845_2 _tcSol = new Solution0845_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,1,4,7,3,2,5]");
        try {
            int[] arr = new int[]{2, 1, 4, 7, 3, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestMountain(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,2,2]");
        try {
            int[] arr = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestMountain(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
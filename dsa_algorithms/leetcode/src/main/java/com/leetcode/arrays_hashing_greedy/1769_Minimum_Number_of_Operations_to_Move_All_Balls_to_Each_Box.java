package com.leetcode.arrays_hashing_greedy;

class Solution1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1, cnt = 0; i < n; ++i) {
            if (boxes.charAt(i - 1) == '1') {
                ++cnt;
            }
            left[i] = left[i - 1] + cnt;
        }
        for (int i = n - 2, cnt = 0; i >= 0; --i) {
            if (boxes.charAt(i + 1) == '1') {
                ++cnt;
            }
            right[i] = right[i + 1] + cnt;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = left[i] + right[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1769 _tcSol = new Solution1769();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "boxes = \"110\"");
        try {
            String boxes = "110";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "boxes = \"001011\"");
        try {
            String boxes = "001011";
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(boxes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[11,8,5,4,3,4]");
        System.out.println();
    }
}
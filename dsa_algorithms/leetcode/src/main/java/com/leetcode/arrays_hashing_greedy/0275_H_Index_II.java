package com.leetcode.arrays_hashing_greedy;

class Solution0275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (citations[mid] >= n - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0275 _tcSol = new Solution0275();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "citations = [0,1,3,5,6]");
        try {
            int[] citations = new int[]{0, 1, 3, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.hIndex(citations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "citations = [1,2,100]");
        try {
            int[] citations = new int[]{1, 2, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.hIndex(citations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
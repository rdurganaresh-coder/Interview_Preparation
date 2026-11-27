package com.leetcode.arrays_hashing_greedy;

class Solution2418_2 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {heights[i], i};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[arr[i][1]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2418_2 _tcSol = new Solution2418_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "names = [\"Mary\",\"John\",\"Emma\"], heights = [180,165,170]");
        try {
            String[] names = new String[]{"Mary", "John", "Emma"};
            int[] heights = new int[]{180, 165, 170};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortPeople(names, heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Mary\",\"Emma\",\"John\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "names = [\"Alice\",\"Bob\",\"Bob\"], heights = [155,185,150]");
        try {
            String[] names = new String[]{"Alice", "Bob", "Bob"};
            int[] heights = new int[]{155, 185, 150};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortPeople(names, heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Bob\",\"Alice\",\"Bob\"]");
        System.out.println();
    }
}
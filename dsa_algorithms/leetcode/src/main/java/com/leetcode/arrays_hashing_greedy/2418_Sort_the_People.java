package com.leetcode.arrays_hashing_greedy;

class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> heights[j] - heights[i]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[idx[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2418 _tcSol = new Solution2418();
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
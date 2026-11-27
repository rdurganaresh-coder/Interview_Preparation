package com.leetcode.arrays_hashing_greedy;

class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        return new HashSet<>(cnt.values()).size() == cnt.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1207 _tcSol = new Solution1207();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,2,1,1,3]");
        try {
            int[] arr = new int[]{1, 2, 2, 1, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueOccurrences(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2]");
        try {
            int[] arr = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueOccurrences(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [-3,0,1,-3,1,1,1,-3,10,0]");
        try {
            int[] arr = new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.uniqueOccurrences(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
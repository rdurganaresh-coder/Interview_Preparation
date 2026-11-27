package com.leetcode.sliding_window_two_pointers;

class Solution0898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        for (int x : arr) {
            Set<Integer> t = new HashSet<>();
            for (int y : s) {
                t.add(x | y);
            }
            t.add(x);
            ans.addAll(t);
            s = t;
        }
        return ans.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0898 _tcSol = new Solution0898();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [0]");
        try {
            int[] arr = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayBitwiseORs(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,2]");
        try {
            int[] arr = new int[]{1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayBitwiseORs(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,4]");
        try {
            int[] arr = new int[]{1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarrayBitwiseORs(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
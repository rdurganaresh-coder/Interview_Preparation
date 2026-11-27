package com.leetcode.arrays_hashing_greedy;

class Solution2855 {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int i = 1;
        while (i < n && nums.get(i - 1) < nums.get(i)) {
            ++i;
        }
        int k = i + 1;
        while (k < n && nums.get(k - 1) < nums.get(k) && nums.get(k) < nums.get(0)) {
            ++k;
        }
        return k < n ? -1 : n - i;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2855 _tcSol = new Solution2855();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,5,1,2]");
        try {
            List<Integer> nums = _tcL(3, 4, 5, 1, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRightShifts(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,5]");
        try {
            List<Integer> nums = _tcL(1, 3, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRightShifts(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,1,4]");
        try {
            List<Integer> nums = _tcL(2, 1, 4);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRightShifts(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
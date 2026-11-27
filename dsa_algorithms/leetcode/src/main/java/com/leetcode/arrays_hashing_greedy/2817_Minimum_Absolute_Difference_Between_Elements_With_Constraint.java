package com.leetcode.arrays_hashing_greedy;

class Solution2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int ans = 1 << 30;
        for (int i = x; i < nums.size(); ++i) {
            tm.merge(nums.get(i - x), 1, Integer::sum);
            Integer key = tm.ceilingKey(nums.get(i));
            if (key != null) {
                ans = Math.min(ans, key - nums.get(i));
            }
            key = tm.floorKey(nums.get(i));
            if (key != null) {
                ans = Math.min(ans, nums.get(i) - key);
            }
        }
        return ans;
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
        Solution2817 _tcSol = new Solution2817();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,4], x = 2");
        try {
            List<Integer> nums = _tcL(4, 3, 2, 4);
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteDifference(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,3,2,10,15], x = 1");
        try {
            List<Integer> nums = _tcL(5, 3, 2, 10, 15);
            int x = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteDifference(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], x = 3");
        try {
            List<Integer> nums = _tcL(1, 2, 3, 4);
            int x = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsoluteDifference(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
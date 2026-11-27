package com.leetcode.arrays_hashing_greedy;

class Solution2869 {
    public int minOperations(List<Integer> nums, int k) {
        boolean[] isAdded = new boolean[k];
        int n = nums.size();
        int count = 0;
        for (int i = n - 1;; i--) {
            if (nums.get(i) > k || isAdded[nums.get(i) - 1]) {
                continue;
            }
            isAdded[nums.get(i) - 1] = true;
            count++;
            if (count == k) {
                return n - i;
            }
        }
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
        Solution2869 _tcSol = new Solution2869();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,5,4,2], k = 2");
        try {
            List<Integer> nums = _tcL(3, 1, 5, 4, 2);
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,5,4,2], k = 5");
        try {
            List<Integer> nums = _tcL(3, 1, 5, 4, 2);
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,5,3,1], k = 3");
        try {
            List<Integer> nums = _tcL(3, 2, 5, 3, 1);
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
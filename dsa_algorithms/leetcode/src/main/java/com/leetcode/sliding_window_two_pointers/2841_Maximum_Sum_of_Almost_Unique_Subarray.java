package com.leetcode.sliding_window_two_pointers;

class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.size();
        long s = 0;
        for (int i = 0; i < k; ++i) {
            cnt.merge(nums.get(i), 1, Integer::sum);
            s += nums.get(i);
        }
        long ans = cnt.size() >= m ? s : 0;
        for (int i = k; i < n; ++i) {
            cnt.merge(nums.get(i), 1, Integer::sum);
            if (cnt.merge(nums.get(i - k), -1, Integer::sum) == 0) {
                cnt.remove(nums.get(i - k));
            }
            s += nums.get(i) - nums.get(i - k);
            if (cnt.size() >= m) {
                ans = Math.max(ans, s);
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
        Solution2841 _tcSol = new Solution2841();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,6,7,3,1,7], m = 3, k = 4");
        try {
            List<Integer> nums = _tcL(2, 6, 7, 3, 1, 7);
            int m = 3;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,9,9,2,4,5,4], m = 1, k = 3");
        try {
            List<Integer> nums = _tcL(5, 9, 9, 2, 4, 5, 4);
            int m = 1;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "23");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2,1], m = 3, k = 3");
        try {
            List<Integer> nums = _tcL(1, 2, 1, 2, 1, 2, 1);
            int m = 3;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
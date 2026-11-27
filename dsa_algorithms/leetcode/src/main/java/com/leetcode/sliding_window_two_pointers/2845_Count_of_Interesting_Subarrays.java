package com.leetcode.sliding_window_two_pointers;

class Solution2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = nums.get(i) % modulo == k ? 1 : 0;
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        long ans = 0;
        int s = 0;
        for (int x : arr) {
            s += x;
            ans += cnt.getOrDefault((s - k + modulo) % modulo, 0);
            cnt.merge(s % modulo, 1, Integer::sum);
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
        Solution2845 _tcSol = new Solution2845();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,4], modulo = 2, k = 1");
        try {
            List<Integer> nums = _tcL(3, 2, 4);
            int modulo = 2;
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countInterestingSubarrays(nums, modulo, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,9,6], modulo = 3, k = 0");
        try {
            List<Integer> nums = _tcL(3, 1, 9, 6);
            int modulo = 3;
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countInterestingSubarrays(nums, modulo, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
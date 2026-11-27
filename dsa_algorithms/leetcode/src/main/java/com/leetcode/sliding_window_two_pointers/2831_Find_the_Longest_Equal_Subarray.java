package com.leetcode.sliding_window_two_pointers;

class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0, l = 0;
        for (int r = 0; r < nums.size(); ++r) {
            cnt.merge(nums.get(r), 1, Integer::sum);
            mx = Math.max(mx, cnt.get(nums.get(r)));
            if (r - l + 1 - mx > k) {
                cnt.merge(nums.get(l++), -1, Integer::sum);
            }
        }
        return mx;
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
        Solution2831 _tcSol = new Solution2831();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,2,3,1,3], k = 3");
        try {
            List<Integer> nums = _tcL(1, 3, 2, 3, 1, 3);
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestEqualSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,2,1,1], k = 2");
        try {
            List<Integer> nums = _tcL(1, 1, 2, 2, 1, 1);
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestEqualSubarray(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
package com.leetcode.sliding_window_two_pointers;

class Solution2831_2 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            g[nums.get(i)].add(i);
        }
        int ans = 0;
        for (List<Integer> ids : g) {
            int l = 0;
            for (int r = 0; r < ids.size(); ++r) {
                while (ids.get(r) - ids.get(l) - (r - l) > k) {
                    ++l;
                }
                ans = Math.max(ans, r - l + 1);
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
        Solution2831_2 _tcSol = new Solution2831_2();
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
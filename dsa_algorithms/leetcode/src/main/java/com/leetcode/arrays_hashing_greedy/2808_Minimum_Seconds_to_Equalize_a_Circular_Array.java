package com.leetcode.arrays_hashing_greedy;

class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> d = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            d.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        int ans = 1 << 30;
        for (List<Integer> idx : d.values()) {
            int m = idx.size();
            int t = idx.get(0) + n - idx.get(m - 1);
            for (int i = 1; i < m; ++i) {
                t = Math.max(t, idx.get(i) - idx.get(i - 1));
            }
            ans = Math.min(ans, t / 2);
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
        Solution2808 _tcSol = new Solution2808();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2]");
        try {
            List<Integer> nums = _tcL(1, 2, 1, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,3,3,2]");
        try {
            List<Integer> nums = _tcL(2, 1, 3, 3, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,5,5,5]");
        try {
            List<Integer> nums = _tcL(5, 5, 5, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSeconds(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
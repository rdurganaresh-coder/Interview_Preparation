package com.leetcode.arrays_hashing_greedy;

class Solution2848_2 {
    public int numberOfPoints(List<List<Integer>> nums) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (var e : nums) {
            int start = e.get(0), end = e.get(1);
            d.merge(start, 1, Integer::sum);
            d.merge(end + 1, -1, Integer::sum);
        }
        int ans = 0, s = 0, last = 0;
        for (var e : d.entrySet()) {
            int cur = e.getKey(), v = e.getValue();
            if (s > 0) {
                ans += cur - last;
            }
            s += v;
            last = cur;
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
        Solution2848_2 _tcSol = new Solution2848_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[3,6],[1,5],[4,7]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(3, 6), _tcL(1, 5), _tcL(4, 7));
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPoints(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1,3],[5,8]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(1, 3), _tcL(5, 8));
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPoints(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}

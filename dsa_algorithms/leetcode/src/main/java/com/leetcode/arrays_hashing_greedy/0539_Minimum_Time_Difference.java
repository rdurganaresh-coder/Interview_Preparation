package com.leetcode.arrays_hashing_greedy;

class Solution0539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        int n = timePoints.size();
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            String[] t = timePoints.get(i).split(":");
            nums[i] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
        Arrays.sort(nums, 0, n);
        nums[n] = nums[0] + 1440;
        int ans = 1 << 30;
        for (int i = 1; i <= n; ++i) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
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
        Solution0539 _tcSol = new Solution0539();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "timePoints = [\"23:59\",\"00:00\"]");
        try {
            List<String> timePoints = _tcL("23:59", "00:00");
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinDifference(timePoints)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "timePoints = [\"00:00\",\"23:59\",\"00:00\"]");
        try {
            List<String> timePoints = _tcL("00:00", "23:59", "00:00");
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinDifference(timePoints)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
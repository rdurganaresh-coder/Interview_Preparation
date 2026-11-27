package com.leetcode.arrays_hashing_greedy;

class Solution3371 {
    public int getLargestOutlier(int[] nums) {
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            s += x;
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = Integer.MIN_VALUE;
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int t = s - x;
            if (t % 2 != 0 || !cnt.containsKey(t / 2)) {
                continue;
            }
            if (x != t / 2 || v > 1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3371 _tcSol = new Solution3371();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,5,10]");
        try {
            int[] nums = new int[]{2, 3, 5, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLargestOutlier(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2,-1,-3,-6,4]");
        try {
            int[] nums = new int[]{-2, -1, -3, -6, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLargestOutlier(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1,5,5]");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLargestOutlier(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}

package com.leetcode.dynamic_programming;

class Solution2967 {
    private static long[] ps;
    private int[] nums;

    static {
        ps = new long[2 * (int) 1e5];
        for (int i = 1; i <= 1e5; i++) {
            String s = Integer.toString(i);
            String t1 = new StringBuilder(s).reverse().toString();
            String t2 = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            ps[2 * i - 2] = Long.parseLong(s + t1);
            ps[2 * i - 1] = Long.parseLong(s + t2);
        }
        Arrays.sort(ps);
    }

    public long minimumCost(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        int i = Arrays.binarySearch(ps, nums[nums.length / 2]);
        i = i < 0 ? -i - 1 : i;
        long ans = 1L << 60;
        for (int j = i - 1; j <= i + 1; j++) {
            if (0 <= j && j < ps.length) {
                ans = Math.min(ans, f(ps[j]));
            }
        }
        return ans;
    }

    private long f(long x) {
        long ans = 0;
        for (int v : nums) {
            ans += Math.abs(v - x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2967 _tcSol = new Solution2967();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [10,12,13,14,15]");
        try {
            int[] nums = new int[]{10, 12, 13, 14, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [22,33,22,33,22]");
        try {
            int[] nums = new int[]{22, 33, 22, 33, 22};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();
    }
}
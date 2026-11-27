package com.leetcode.arrays_hashing_greedy;

class Solution2702 {
    private int[] nums;
    private int x;
    private int y;

    public int minOperations(int[] nums, int x, int y) {
        this.nums = nums;
        this.x = x;
        this.y = y;
        int l = 0, r = 0;
        for (int v : nums) {
            r = Math.max(r, v);
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int t) {
        long cnt = 0;
        for (int v : nums) {
            if (v > (long) t * y) {
                cnt += (v - (long) t * y + x - y - 1) / (x - y);
            }
        }
        return cnt <= t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2702 _tcSol = new Solution2702();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,1,7,6], x = 4, y = 2");
        try {
            int[] nums = new int[]{3, 4, 1, 7, 6};
            int x = 4;
            int y = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1], x = 2, y = 1");
        try {
            int[] nums = new int[]{1, 2, 1};
            int x = 2;
            int y = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, x, y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
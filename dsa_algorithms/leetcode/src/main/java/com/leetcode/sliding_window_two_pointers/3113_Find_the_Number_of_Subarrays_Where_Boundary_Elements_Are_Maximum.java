package com.leetcode.sliding_window_two_pointers;

class Solution3113 {
    public long numberOfSubarrays(int[] nums) {
        Deque<int[]> stk = new ArrayDeque<>();
        long ans = 0;
        for (int x : nums) {
            while (!stk.isEmpty() && stk.peek()[0] < x) {
                stk.pop();
            }
            if (stk.isEmpty() || stk.peek()[0] > x) {
                stk.push(new int[] {x, 1});
            } else {
                stk.peek()[1]++;
            }
            ans += stk.peek()[1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3113 _tcSol = new Solution3113();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,3,3,2]");
        try {
            int[] nums = new int[]{1, 4, 3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,3,3]");
        try {
            int[] nums = new int[]{3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
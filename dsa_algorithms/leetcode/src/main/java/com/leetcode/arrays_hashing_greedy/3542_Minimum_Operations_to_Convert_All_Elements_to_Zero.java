package com.leetcode.arrays_hashing_greedy;

class Solution3542 {
    public int minOperations(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        for (int x : nums) {
            while (!stk.isEmpty() && stk.peek() > x) {
                ans++;
                stk.pop();
            }
            if (x != 0 && (stk.isEmpty() || stk.peek() != x)) {
                stk.push(x);
            }
        }
        ans += stk.size();
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3542 _tcSol = new Solution3542();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,2]");
        try {
            int[] nums = new int[]{0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,2,1]");
        try {
            int[] nums = new int[]{3, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2,1,2]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}

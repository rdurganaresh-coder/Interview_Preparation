package com.leetcode.stacks_queues;

class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && stk.peek() < heights[i]) {
                stk.pop();
                ++ans[i];
            }
            if (!stk.isEmpty()) {
                ++ans[i];
            }
            stk.push(heights[i]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1944 _tcSol = new Solution1944();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [10,6,8,5,11,9]");
        try {
            int[] heights = new int[]{10, 6, 8, 5, 11, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.canSeePersonsCount(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,2,1,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [5,1,2,3,10]");
        try {
            int[] heights = new int[]{5, 1, 2, 3, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.canSeePersonsCount(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,1,1,1,0]");
        System.out.println();
    }
}
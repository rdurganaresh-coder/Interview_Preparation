package com.leetcode.stacks_queues;

class Solution0946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stk = new ArrayDeque<>();
        int i = 0;
        for (int x : pushed) {
            stk.push(x);
            while (!stk.isEmpty() && stk.peek() == popped[i]) {
                stk.pop();
                ++i;
            }
        }
        return i == popped.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0946 _tcSol = new Solution0946();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pushed = [1,2,3,4,5], popped = [4,5,3,2,1]");
        try {
            int[] pushed = new int[]{1, 2, 3, 4, 5};
            int[] popped = new int[]{4, 5, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateStackSequences(pushed, popped)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pushed = [1,2,3,4,5], popped = [4,3,5,1,2]");
        try {
            int[] pushed = new int[]{1, 2, 3, 4, 5};
            int[] popped = new int[]{4, 3, 5, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateStackSequences(pushed, popped)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
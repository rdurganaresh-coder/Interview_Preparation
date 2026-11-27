package com.leetcode.trees_tries;

class Solution0255 {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stk = new ArrayDeque<>();
        int last = Integer.MIN_VALUE;
        for (int x : preorder) {
            if (x < last) {
                return false;
            }
            while (!stk.isEmpty() && stk.peek() < x) {
                last = stk.poll();
            }
            stk.push(x);
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0255 _tcSol = new Solution0255();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "preorder = [5,2,1,3,6]");
        try {
            int[] preorder = new int[]{5, 2, 1, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.verifyPreorder(preorder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "preorder = [5,2,6,1,3]");
        try {
            int[] preorder = new int[]{5, 2, 6, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.verifyPreorder(preorder)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
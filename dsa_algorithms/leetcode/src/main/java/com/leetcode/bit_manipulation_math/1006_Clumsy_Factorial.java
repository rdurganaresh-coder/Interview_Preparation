package com.leetcode.bit_manipulation_math;

class Solution1006 {
    public int clumsy(int n) {
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(n);
        int k = 0;
        for (int x = n - 1; x > 0; --x) {
            if (k == 0) {
                stk.push(stk.pop() * x);
            } else if (k == 1) {
                stk.push(stk.pop() / x);
            } else if (k == 2) {
                stk.push(x);
            } else {
                stk.push(-x);
            }
            k = (k + 1) % 4;
        }
        return stk.stream().mapToInt(Integer::intValue).sum();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1006 _tcSol = new Solution1006();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4");
        try {
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.clumsy(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.clumsy(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}
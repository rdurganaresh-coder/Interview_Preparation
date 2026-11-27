package com.leetcode.stacks_queues;

class Solution0735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int x : asteroids) {
            if (x > 0) {
                stk.offerLast(x);
            } else {
                while (!stk.isEmpty() && stk.peekLast() > 0 && stk.peekLast() < -x) {
                    stk.pollLast();
                }
                if (!stk.isEmpty() && stk.peekLast() == -x) {
                    stk.pollLast();
                } else if (stk.isEmpty() || stk.peekLast() < 0) {
                    stk.offerLast(x);
                }
            }
        }
        return stk.stream().mapToInt(Integer::valueOf).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0735 _tcSol = new Solution0735();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "asteroids = [5,10,-5]");
        try {
            int[] asteroids = new int[]{5, 10, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.asteroidCollision(asteroids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "asteroids = [8,-8]");
        try {
            int[] asteroids = new int[]{8, -8};
            System.out.println("  Output  : " + _tcShow(_tcSol.asteroidCollision(asteroids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "asteroids = [10,2,-5]");
        try {
            int[] asteroids = new int[]{10, 2, -5};
            System.out.println("  Output  : " + _tcShow(_tcSol.asteroidCollision(asteroids)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10]");
        System.out.println();
    }
}
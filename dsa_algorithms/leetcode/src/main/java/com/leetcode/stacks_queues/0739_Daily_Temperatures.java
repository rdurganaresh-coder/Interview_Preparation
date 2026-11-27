package com.leetcode.stacks_queues;

class Solution0739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek() - i;
            }
            stk.push(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0739 _tcSol = new Solution0739();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "temperatures = [73,74,75,71,69,72,76,73]");
        try {
            int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
            System.out.println("  Output  : " + _tcShow(_tcSol.dailyTemperatures(temperatures)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,4,2,1,1,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "temperatures = [30,40,50,60]");
        try {
            int[] temperatures = new int[]{30, 40, 50, 60};
            System.out.println("  Output  : " + _tcShow(_tcSol.dailyTemperatures(temperatures)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,1,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "temperatures = [30,60,90]");
        try {
            int[] temperatures = new int[]{30, 60, 90};
            System.out.println("  Output  : " + _tcShow(_tcSol.dailyTemperatures(temperatures)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,1,0]");
        System.out.println();
    }
}

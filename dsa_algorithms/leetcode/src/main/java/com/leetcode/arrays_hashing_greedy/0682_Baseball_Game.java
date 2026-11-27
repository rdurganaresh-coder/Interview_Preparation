package com.leetcode.arrays_hashing_greedy;

class Solution0682 {
    public int calPoints(String[] operations) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String op : operations) {
            if ("+".equals(op)) {
                int a = stk.pop();
                int b = stk.peek();
                stk.push(a);
                stk.push(a + b);
            } else if ("D".equals(op)) {
                stk.push(stk.peek() << 1);
            } else if ("C".equals(op)) {
                stk.pop();
            } else {
                stk.push(Integer.valueOf(op));
            }
        }
        return stk.stream().mapToInt(Integer::intValue).sum();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0682 _tcSol = new Solution0682();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ops = [\"5\",\"2\",\"C\",\"D\",\"+\"]");
        try {
            String[] operations = new String[]{"5", "2", "C", "D", "+"};
            System.out.println("  Output  : " + _tcShow(_tcSol.calPoints(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "30");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ops = [\"5\",\"-2\",\"4\",\"C\",\"D\",\"9\",\"+\",\"+\"]");
        try {
            String[] operations = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
            System.out.println("  Output  : " + _tcShow(_tcSol.calPoints(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "ops = [\"1\",\"C\"]");
        try {
            String[] operations = new String[]{"1", "C"};
            System.out.println("  Output  : " + _tcShow(_tcSol.calPoints(operations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
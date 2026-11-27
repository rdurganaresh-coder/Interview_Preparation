package com.leetcode.arrays_hashing_greedy;

class Solution0150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                stk.push(Integer.parseInt(t));
            } else {
                int y = stk.pop();
                int x = stk.pop();
                switch (t) {
                case "+":
                    stk.push(x + y);
                    break;
                case "-":
                    stk.push(x - y);
                    break;
                case "*":
                    stk.push(x * y);
                    break;
                default:
                    stk.push(x / y);
                    break;
                }
            }
        }
        return stk.pop();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0150 _tcSol = new Solution0150();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tokens = [\"2\",\"1\",\"+\",\"3\",\"*\"]");
        try {
            String[] tokens = new String[]{"2", "1", "+", "3", "*"};
            System.out.println("  Output  : " + _tcShow(_tcSol.evalRPN(tokens)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tokens = [\"4\",\"13\",\"5\",\"/\",\"+\"]");
        try {
            String[] tokens = new String[]{"4", "13", "5", "/", "+"};
            System.out.println("  Output  : " + _tcShow(_tcSol.evalRPN(tokens)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tokens = [\"10\",\"6\",\"9\",\"3\",\"+\",\"-11\",\"*\",\"/\",\"*\",\"17\",\"+\",\"5\",\"+\"]");
        try {
            String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
            System.out.println("  Output  : " + _tcShow(_tcSol.evalRPN(tokens)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();
    }
}
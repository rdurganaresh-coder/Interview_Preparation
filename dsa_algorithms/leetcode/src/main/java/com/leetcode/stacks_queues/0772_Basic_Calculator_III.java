package com.leetcode.stacks_queues;

class Solution0772 {
    public int calculate(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        return dfs(q);
    }

    private int dfs(Deque<Character> q) {
        long num = 0;
        char sign = '+';
        List<Long> stk = new ArrayList<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = dfs(q);
            }
            if ("+-*/)".indexOf(c) >= 0 || q.isEmpty()) {
                if (sign == '+') {
                    stk.add(num);
                } else if (sign == '-') {
                    stk.add(-num);
                } else if (sign == '*') {
                    stk.set(stk.size() - 1, stk.get(stk.size() - 1) * num);
                } else {
                    stk.set(stk.size() - 1, stk.get(stk.size() - 1) / num);
                }
                num = 0;
                sign = c;
            }
            if (c == ')') {
                break;
            }
        }
        long ans = 0;
        for (long x : stk) {
            ans += x;
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0772 _tcSol = new Solution0772();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1+1\"");
        try {
            String s = "1+1";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculate(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"6-4/2\"");
        try {
            String s = "6-4/2";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculate(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"2*(5+5*2)/3+(6/2+8)\"");
        try {
            String s = "2*(5+5*2)/3+(6/2+8)";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculate(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}

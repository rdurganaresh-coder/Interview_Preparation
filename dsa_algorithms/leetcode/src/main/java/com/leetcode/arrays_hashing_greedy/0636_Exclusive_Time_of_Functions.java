package com.leetcode.arrays_hashing_greedy;

class Solution0636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        int pre = 0;
        for (var log : logs) {
            var parts = log.split(":");
            int i = Integer.parseInt(parts[0]);
            int cur = Integer.parseInt(parts[2]);
            if (parts[1].charAt(0) == 's') {
                if (!stk.isEmpty()) {
                    ans[stk.peek()] += cur - pre;
                }
                stk.push(i);
                pre = cur;
            } else {
                ans[stk.pop()] += cur - pre + 1;
                pre = cur + 1;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution0636 _tcSol = new Solution0636();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, logs = [\"0:start:0\",\"1:start:2\",\"1:end:5\",\"0:end:6\"]");
        try {
            int n = 2;
            List<String> logs = _tcL("0:start:0", "1:start:2", "1:end:5", "0:end:6");
            System.out.println("  Output  : " + _tcShow(_tcSol.exclusiveTime(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, logs = [\"0:start:0\",\"0:start:2\",\"0:end:5\",\"0:start:6\",\"0:end:6\",\"0:end:7\"]");
        try {
            int n = 1;
            List<String> logs = _tcL("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
            System.out.println("  Output  : " + _tcShow(_tcSol.exclusiveTime(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[8]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, logs = [\"0:start:0\",\"0:start:2\",\"0:end:5\",\"1:start:6\",\"1:end:6\",\"0:end:7\"]");
        try {
            int n = 2;
            List<String> logs = _tcL("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
            System.out.println("  Output  : " + _tcShow(_tcSol.exclusiveTime(n, logs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,1]");
        System.out.println();
    }
}

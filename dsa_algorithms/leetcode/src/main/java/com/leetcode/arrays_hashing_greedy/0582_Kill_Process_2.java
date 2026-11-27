package com.leetcode.arrays_hashing_greedy;

class Solution0582_2 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = pid.size();
        for (int i = 0; i < n; ++i) {
            g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(kill);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            ans.add(i);
            List<Integer> children = g.getOrDefault(i, List.of());
            for (int k = children.size() - 1; k >= 0; --k) {
                stk.push(children.get(k));
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
        Solution0582_2 _tcSol = new Solution0582_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5");
        try {
            List<Integer> pid = _tcL(1, 3, 10, 5);
            List<Integer> ppid = _tcL(3, 0, 5, 3);
            int kill = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.killProcess(pid, ppid, kill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pid = [1], ppid = [0], kill = 1");
        try {
            List<Integer> pid = _tcL(1);
            List<Integer> ppid = _tcL(0);
            int kill = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.killProcess(pid, ppid, kill)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}

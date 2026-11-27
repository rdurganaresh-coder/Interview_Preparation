package com.leetcode.arrays_hashing_greedy;

class Solution0582 {
    private Map<Integer, List<Integer>> g = new HashMap<>();
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        for (int i = 0; i < n; ++i) {
            g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }
        dfs(kill);
        return ans;
    }

    private void dfs(int i) {
        ans.add(i);
        for (int j : g.getOrDefault(i, Collections.emptyList())) {
            dfs(j);
        }
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
        Solution0582 _tcSol = new Solution0582();
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

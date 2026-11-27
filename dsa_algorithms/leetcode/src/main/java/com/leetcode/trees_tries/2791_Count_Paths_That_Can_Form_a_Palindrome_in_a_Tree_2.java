package com.leetcode.trees_tries;

class Solution2791_2 {
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            int p = parent.get(i);
            g[p].add(new int[] {i, 1 << (s.charAt(i) - 'a')});
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        long ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], xor = cur[1];
            for (int[] e : g[i]) {
                int j = e[0], v = e[1];
                int x = xor ^ v;
                ans += cnt.getOrDefault(x, 0);
                for (int k = 0; k < 26; ++k) {
                    ans += cnt.getOrDefault(x ^ (1 << k), 0);
                }
                cnt.merge(x, 1, Integer::sum);
                stk.push(new int[] {j, x});
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
        Solution2791_2 _tcSol = new Solution2791_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "parent = [-1,0,0,1,1,2], s = \"acaabc\"");
        try {
            List<Integer> parent = _tcL(-1, 0, 0, 1, 1, 2);
            String s = "acaabc";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPalindromePaths(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "parent = [-1,0,0,0,0], s = \"aaaaa\"");
        try {
            List<Integer> parent = _tcL(-1, 0, 0, 0, 0);
            String s = "aaaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.countPalindromePaths(parent, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}

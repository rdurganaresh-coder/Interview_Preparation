package com.leetcode.dynamic_programming;

class Solution3412 {
    public long calculateScore(String s) {
        Map<Character, List<Integer>> d = new HashMap<>(26);
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            char x = s.charAt(i);
            char y = (char) ('a' + 'z' - x);
            if (d.containsKey(y)) {
                var ls = d.get(y);
                int j = ls.remove(ls.size() - 1);
                if (ls.isEmpty()) {
                    d.remove(y);
                }
                ans += i - j;
            } else {
                d.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3412 _tcSol = new Solution3412();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aczzx\"");
        try {
            String s = "aczzx";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateScore(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcdef\"");
        try {
            String s = "abcdef";
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateScore(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}

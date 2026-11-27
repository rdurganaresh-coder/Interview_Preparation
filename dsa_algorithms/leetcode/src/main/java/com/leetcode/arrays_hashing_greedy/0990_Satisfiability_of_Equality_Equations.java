package com.leetcode.arrays_hashing_greedy;

class Solution0990 {
    private int[] p;

    public boolean equationsPossible(String[] equations) {
        p = new int[26];
        for (int i = 0; i < 26; ++i) {
            p[i] = i;
        }
        for (String e : equations) {
            int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '=') {
                p[find(a)] = find(b);
            }
        }
        for (String e : equations) {
            int a = e.charAt(0) - 'a', b = e.charAt(3) - 'a';
            if (e.charAt(1) == '!' && find(a) == find(b)) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0990 _tcSol = new Solution0990();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "equations = [\"a==b\",\"b!=a\"]");
        try {
            String[] equations = new String[]{"a==b", "b!=a"};
            System.out.println("  Output  : " + _tcShow(_tcSol.equationsPossible(equations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "equations = [\"b==a\",\"a==b\"]");
        try {
            String[] equations = new String[]{"b==a", "a==b"};
            System.out.println("  Output  : " + _tcShow(_tcSol.equationsPossible(equations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
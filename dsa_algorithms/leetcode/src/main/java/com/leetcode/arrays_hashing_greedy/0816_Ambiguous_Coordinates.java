package com.leetcode.arrays_hashing_greedy;

class Solution0816 {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < n - 1; ++i) {
            for (String x : f(s, 1, i)) {
                for (String y : f(s, i, n - 1)) {
                    ans.add(String.format("(%s, %s)", x, y));
                }
            }
        }
        return ans;
    }

    private List<String> f(String s, int i, int j) {
        List<String> res = new ArrayList<>();
        for (int k = 1; k <= j - i; ++k) {
            String l = s.substring(i, i + k);
            String r = s.substring(i + k, j);
            boolean ok = ("0".equals(l) || !l.startsWith("0")) && !r.endsWith("0");
            if (ok) {
                res.add(l + (k < j - i ? "." : "") + r);
            }
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0816 _tcSol = new Solution0816();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"(123)\"");
        try {
            String s = "(123)";
            System.out.println("  Output  : " + _tcShow(_tcSol.ambiguousCoordinates(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"(1, 2.3)\",\"(1, 23)\",\"(1.2, 3)\",\"(12, 3)\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"(0123)\"");
        try {
            String s = "(0123)";
            System.out.println("  Output  : " + _tcShow(_tcSol.ambiguousCoordinates(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"(0, 1.23)\",\"(0, 12.3)\",\"(0, 123)\",\"(0.1, 2.3)\",\"(0.1, 23)\",\"(0.12, 3)\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"(00011)\"");
        try {
            String s = "(00011)";
            System.out.println("  Output  : " + _tcShow(_tcSol.ambiguousCoordinates(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"(0, 0.011)\",\"(0.001, 1)\"]");
        System.out.println();
    }
}
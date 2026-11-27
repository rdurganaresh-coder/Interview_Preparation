package com.leetcode.strings;

class Solution2337 {
    public boolean canChange(String start, String target) {
        List<int[]> a = f(start);
        List<int[]> b = f(target);
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); ++i) {
            int[] x = a.get(i);
            int[] y = b.get(i);
            if (x[0] != y[0]) {
                return false;
            }
            if (x[0] == 1 && x[1] < y[1]) {
                return false;
            }
            if (x[0] == 2 && x[1] > y[1]) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> f(String s) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                res.add(new int[] {1, i});
            } else if (s.charAt(i) == 'R') {
                res.add(new int[] {2, i});
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
        Solution2337 _tcSol = new Solution2337();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "start = \"_L__R__R_\", target = \"L______RR\"");
        try {
            String start = "_L__R__R_";
            String target = "L______RR";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "start = \"R_L_\", target = \"__LR\"");
        try {
            String start = "R_L_";
            String target = "__LR";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "start = \"_R\", target = \"R_\"");
        try {
            String start = "_R";
            String target = "R_";
            System.out.println("  Output  : " + _tcShow(_tcSol.canChange(start, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
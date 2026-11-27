package com.leetcode.backtracking;

class Solution1694 {
    public String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int n = number.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n / 3; ++i) {
            ans.add(number.substring(i * 3, i * 3 + 3));
        }
        if (n % 3 == 1) {
            ans.set(ans.size() - 1, ans.get(ans.size() - 1).substring(0, 2));
            ans.add(number.substring(n - 2));
        } else if (n % 3 == 2) {
            ans.add(number.substring(n - 2));
        }
        return String.join("-", ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1694 _tcSol = new Solution1694();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "number = \"1-23-45 6\"");
        try {
            String number = "1-23-45 6";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatNumber(number)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123-456\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "number = \"123 4-567\"");
        try {
            String number = "123 4-567";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatNumber(number)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123-45-67\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "number = \"123 4-5678\"");
        try {
            String number = "123 4-5678";
            System.out.println("  Output  : " + _tcShow(_tcSol.reformatNumber(number)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"123-456-78\"");
        System.out.println();
    }
}
package com.leetcode.strings;

class Solution0043 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int b = num2.charAt(j) - '0';
                arr[i + j + 1] += a * b;
            }
        }
        for (int i = arr.length - 1; i > 0; --i) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        int i = arr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        for (; i < arr.length; ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0043 _tcSol = new Solution0043();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num1 = \"2\", num2 = \"3\"");
        try {
            String num1 = "2";
            String num2 = "3";
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"6\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num1 = \"123\", num2 = \"456\"");
        try {
            String num1 = "123";
            String num2 = "456";
            System.out.println("  Output  : " + _tcShow(_tcSol.multiply(num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"56088\"");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution0482 {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        int cnt = (int) (n - s.chars().filter(ch -> ch == '-').count()) % k;
        if (cnt == 0) {
            cnt = k;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            ans.append(Character.toUpperCase(c));
            --cnt;
            if (cnt == 0) {
                cnt = k;
                if (i != n - 1) {
                    ans.append('-');
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0482 _tcSol = new Solution0482();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"5F3Z-2e-9-w\", k = 4");
        try {
            String s = "5F3Z-2e-9-w";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.licenseKeyFormatting(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"5F3Z-2E9W\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"2-5g-3-J\", k = 2");
        try {
            String s = "2-5g-3-J";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.licenseKeyFormatting(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2-5G-3J\"");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution0165 {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        for (int i = 0, j = 0; i < m || j < n; ++i, ++j) {
            int a = 0, b = 0;
            while (i < m && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i++) - '0');
            }
            while (j < n && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j++) - '0');
            }
            if (a != b) {
                return a < b ? -1 : 1;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0165 _tcSol = new Solution0165();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "version1 = \"1.2\", version2 = \"1.10\"");
        try {
            String version1 = "1.2";
            String version2 = "1.10";
            System.out.println("  Output  : " + _tcShow(_tcSol.compareVersion(version1, version2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "version1 = \"1.01\", version2 = \"1.001\"");
        try {
            String version1 = "1.01";
            String version2 = "1.001";
            System.out.println("  Output  : " + _tcShow(_tcSol.compareVersion(version1, version2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "version1 = \"1.0\", version2 = \"1.0.0.0\"");
        try {
            String version1 = "1.0";
            String version2 = "1.0.0.0";
            System.out.println("  Output  : " + _tcShow(_tcSol.compareVersion(version1, version2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
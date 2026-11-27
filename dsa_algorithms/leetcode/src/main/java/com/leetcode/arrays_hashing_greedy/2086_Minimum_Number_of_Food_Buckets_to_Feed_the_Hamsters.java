package com.leetcode.arrays_hashing_greedy;

class Solution2086 {
    public int minimumBuckets(String street) {
        int n = street.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (street.charAt(i) == 'H') {
                if (i + 1 < n && street.charAt(i + 1) == '.') {
                    ++ans;
                    i += 2;
                } else if (i > 0 && street.charAt(i - 1) == '.') {
                    ++ans;
                } else {
                    return -1;
                }
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
        Solution2086 _tcSol = new Solution2086();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hamsters = \"H..H\"");
        try {
            String street = "H..H";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumBuckets(street)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hamsters = \".H.H.\"");
        try {
            String street = ".H.H.";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumBuckets(street)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "hamsters = \".HHH.\"");
        try {
            String street = ".HHH.";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumBuckets(street)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
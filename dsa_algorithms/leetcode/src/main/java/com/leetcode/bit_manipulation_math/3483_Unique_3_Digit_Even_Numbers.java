package com.leetcode.bit_manipulation_math;

class Solution3483 {
    public int totalNumbers(int[] digits) {
        Set<Integer> s = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; ++i) {
            if (digits[i] % 2 == 1) {
                continue;
            }
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; ++k) {
                    if (digits[k] == 0 || k == i || k == j) {
                        continue;
                    }
                    s.add(digits[k] * 100 + digits[j] * 10 + digits[i]);
                }
            }
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3483 _tcSol = new Solution3483();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = [1,2,3,4]");
        try {
            int[] digits = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = [0,2,2]");
        try {
            int[] digits = new int[]{0, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "digits = [6,6,6]");
        try {
            int[] digits = new int[]{6, 6, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "digits = [1,3,5]");
        try {
            int[] digits = new int[]{1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.totalNumbers(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}

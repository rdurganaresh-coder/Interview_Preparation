package com.leetcode.arrays_hashing_greedy;

class Solution0420 {
    public int strongPasswordChecker(String password) {
        int types = countTypes(password);
        int n = password.length();
        if (n < 6) {
            return Math.max(6 - n, 3 - types);
        }
        char[] chars = password.toCharArray();
        if (n <= 20) {
            int replace = 0;
            int cnt = 0;
            char prev = '~';
            for (char curr : chars) {
                if (curr == prev) {
                    ++cnt;
                } else {
                    replace += cnt / 3;
                    cnt = 1;
                    prev = curr;
                }
            }
            replace += cnt / 3;
            return Math.max(replace, 3 - types);
        }
        int replace = 0, remove = n - 20;
        int remove2 = 0;
        int cnt = 0;
        char prev = '~';
        for (char curr : chars) {
            if (curr == prev) {
                ++cnt;
            } else {
                if (remove > 0 && cnt >= 3) {
                    if (cnt % 3 == 0) {
                        --remove;
                        --replace;
                    } else if (cnt % 3 == 1) {
                        ++remove2;
                    }
                }
                replace += cnt / 3;
                cnt = 1;
                prev = curr;
            }
        }
        if (remove > 0 && cnt >= 3) {
            if (cnt % 3 == 0) {
                --remove;
                --replace;
            } else if (cnt % 3 == 1) {
                ++remove2;
            }
        }
        replace += cnt / 3;

        int use2 = Math.min(Math.min(replace, remove2), remove / 2);
        replace -= use2;
        remove -= use2 * 2;

        int use3 = Math.min(replace, remove / 3);
        replace -= use3;
        remove -= use3 * 3;
        return (n - 20) + Math.max(replace, 3 - types);
    }

    private int countTypes(String s) {
        int a = 0, b = 0, c = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                a = 1;
            } else if (Character.isUpperCase(ch)) {
                b = 1;
            } else if (Character.isDigit(ch)) {
                c = 1;
            }
        }
        return a + b + c;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0420 _tcSol = new Solution0420();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "password = \"a\"");
        try {
            String password = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordChecker(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "password = \"aA1\"");
        try {
            String password = "aA1";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordChecker(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "password = \"1337C0d3\"");
        try {
            String password = "1337C0d3";
            System.out.println("  Output  : " + _tcShow(_tcSol.strongPasswordChecker(password)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
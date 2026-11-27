package com.leetcode.backtracking;

class Solution3491 {
    public boolean phonePrefix(String[] numbers) {
        Arrays.sort(numbers, (a, b) -> Integer.compare(a.length(), b.length()));
        for (int i = 0; i < numbers.length; i++) {
            String s = numbers[i];
            for (int j = 0; j < i; j++) {
                if (s.startsWith(numbers[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3491 _tcSol = new Solution3491();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "numbers = [\"1\",\"2\",\"4\",\"3\"]");
        try {
            String[] numbers = new String[]{"1", "2", "4", "3"};
            System.out.println("  Output  : " + _tcShow(_tcSol.phonePrefix(numbers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "numbers = [\"001\",\"007\",\"15\",\"00153\"]");
        try {
            String[] numbers = new String[]{"001", "007", "15", "00153"};
            System.out.println("  Output  : " + _tcShow(_tcSol.phonePrefix(numbers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}

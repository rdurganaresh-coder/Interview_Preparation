package com.leetcode.sliding_window_two_pointers;

class Solution2489 {
    public long fixedRatio(String s, int num1, int num2) {
        long n0 = 0, n1 = 0;
        long ans = 0;
        Map<Long, Long> cnt = new HashMap<>();
        cnt.put(0L, 1L);
        for (char c : s.toCharArray()) {
            n0 += c == '0' ? 1 : 0;
            n1 += c == '1' ? 1 : 0;
            long x = n1 * num1 - n0 * num2;
            ans += cnt.getOrDefault(x, 0L);
            cnt.put(x, cnt.getOrDefault(x, 0L) + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2489 _tcSol = new Solution2489();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0110011\", num1 = 1, num2 = 2");
        try {
            String s = "0110011";
            int num1 = 1;
            int num2 = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.fixedRatio(s, num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"10101\", num1 = 3, num2 = 1");
        try {
            String s = "10101";
            int num1 = 3;
            int num2 = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.fixedRatio(s, num1, num2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
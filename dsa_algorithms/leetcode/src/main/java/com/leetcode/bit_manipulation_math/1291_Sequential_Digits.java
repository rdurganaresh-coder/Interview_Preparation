package com.leetcode.bit_manipulation_math;

class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 9; ++i) {
            int x = i;
            for (int j = i + 1; j < 10; ++j) {
                x = x * 10 + j;
                if (x >= low && x <= high) {
                    ans.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1291 _tcSol = new Solution1291();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "low = 100, high = 300");
        try {
            int low = 100;
            int high = 300;
            System.out.println("  Output  : " + _tcShow(_tcSol.sequentialDigits(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[123,234]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "low = 1000, high = 13000");
        try {
            int low = 1000;
            int high = 13000;
            System.out.println("  Output  : " + _tcShow(_tcSol.sequentialDigits(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1234,2345,3456,4567,5678,6789,12345]");
        System.out.println();
    }
}
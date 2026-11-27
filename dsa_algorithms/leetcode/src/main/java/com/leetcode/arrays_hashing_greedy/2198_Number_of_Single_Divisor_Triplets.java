package com.leetcode.arrays_hashing_greedy;

class Solution2198 {
    public long singleDivisorTriplet(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            ++cnt[x];
        }
        long ans = 0;
        for (int a = 1; a <= 100; ++a) {
            for (int b = 1; b <= 100; ++b) {
                for (int c = 1; c <= 100; ++c) {
                    int s = a + b + c;
                    int x = cnt[a], y = cnt[b], z = cnt[c];
                    int t = 0;
                    t += s % a == 0 ? 1 : 0;
                    t += s % b == 0 ? 1 : 0;
                    t += s % c == 0 ? 1 : 0;
                    if (t == 1) {
                        if (a == b) {
                            ans += 1L * x * (x - 1) * z;
                        } else if (a == c) {
                            ans += 1L * x * (x - 1) * y;
                        } else if (b == c) {
                            ans += 1L * x * y * (y - 1);
                        } else {
                            ans += 1L * x * y * z;
                        }
                    }
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
        Solution2198 _tcSol = new Solution2198();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,6,7,3,2]");
        try {
            int[] nums = new int[]{4, 6, 7, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleDivisorTriplet(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleDivisorTriplet(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.singleDivisorTriplet(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
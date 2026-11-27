package com.leetcode.arrays_hashing_greedy;

class Solution1390 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans += f(x);
        }
        return ans;
    }

    private int f(int x) {
        int cnt = 2, s = x + 1;
        for (int i = 2; i <= x / i; ++i) {
            if (x % i == 0) {
                ++cnt;
                s += i;
                if (i * i != x) {
                    ++cnt;
                    s += x / i;
                }
            }
        }
        return cnt == 4 ? s : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1390 _tcSol = new Solution1390();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [21,4,7]");
        try {
            int[] nums = new int[]{21, 4, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumFourDivisors(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "32");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [21,21]");
        try {
            int[] nums = new int[]{21, 21};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumFourDivisors(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "64");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumFourDivisors(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
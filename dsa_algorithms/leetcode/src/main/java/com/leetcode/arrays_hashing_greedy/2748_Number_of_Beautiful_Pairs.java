package com.leetcode.arrays_hashing_greedy;

class Solution2748 {
    public int countBeautifulPairs(int[] nums) {
        int[] cnt = new int[10];
        int ans = 0;
        for (int x : nums) {
            for (int y = 0; y < 10; ++y) {
                if (cnt[y] > 0 && gcd(x % 10, y) == 1) {
                    ans += cnt[y];
                }
            }
            while (x > 9) {
                x /= 10;
            }
            ++cnt[x];
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2748 _tcSol = new Solution2748();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,1,4]");
        try {
            int[] nums = new int[]{2, 5, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBeautifulPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [11,21,12]");
        try {
            int[] nums = new int[]{11, 21, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.countBeautifulPairs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
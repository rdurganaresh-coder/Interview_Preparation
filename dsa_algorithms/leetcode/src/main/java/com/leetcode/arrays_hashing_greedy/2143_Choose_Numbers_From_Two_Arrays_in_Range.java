package com.leetcode.arrays_hashing_greedy;

class Solution2143 {
    public int countSubranges(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();
        int[][] f = new int[n][s1 + s2 + 1];
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            int a = nums1[i], b = nums2[i];
            f[i][a + s2]++;
            f[i][-b + s2]++;
            if (i > 0) {
                for (int j = 0; j <= s1 + s2; ++j) {
                    if (j >= a) {
                        f[i][j] = (f[i][j] + f[i - 1][j - a]) % mod;
                    }
                    if (j + b <= s1 + s2) {
                        f[i][j] = (f[i][j] + f[i - 1][j + b]) % mod;
                    }
                }
            }
            ans = (ans + f[i][s2]) % mod;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2143 _tcSol = new Solution2143();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,5], nums2 = [2,6,3]");
        try {
            int[] nums1 = new int[]{1, 2, 5};
            int[] nums2 = new int[]{2, 6, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubranges(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0,1], nums2 = [1,0]");
        try {
            int[] nums1 = new int[]{0, 1};
            int[] nums2 = new int[]{1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubranges(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
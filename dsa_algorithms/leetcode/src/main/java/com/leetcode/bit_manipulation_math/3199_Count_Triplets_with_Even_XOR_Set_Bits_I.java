package com.leetcode.bit_manipulation_math;

class Solution3199 {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int[] cnt1 = new int[2];
        int[] cnt2 = new int[2];
        int[] cnt3 = new int[2];
        for (int x : a) {
            ++cnt1[Integer.bitCount(x) & 1];
        }
        for (int x : b) {
            ++cnt2[Integer.bitCount(x) & 1];
        }
        for (int x : c) {
            ++cnt3[Integer.bitCount(x) & 1];
        }
        int ans = 0;
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if ((i + j + k) % 2 == 0) {
                        ans += cnt1[i] * cnt2[j] * cnt3[k];
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
        Solution3199 _tcSol = new Solution3199();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = [1], b = [2], c = [3]");
        try {
            int[] a = new int[]{1};
            int[] b = new int[]{2};
            int[] c = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.tripletCount(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = [1,1], b = [2,3], c = [1,5]");
        try {
            int[] a = new int[]{1, 1};
            int[] b = new int[]{2, 3};
            int[] c = new int[]{1, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.tripletCount(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
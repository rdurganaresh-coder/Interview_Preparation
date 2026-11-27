package com.leetcode.arrays_hashing_greedy;

class Solution0888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int s1 = 0, s2 = 0;
        Set<Integer> s = new HashSet<>();
        for (int a : aliceSizes) {
            s1 += a;
        }
        for (int b : bobSizes) {
            s.add(b);
            s2 += b;
        }
        int diff = (s1 - s2) >> 1;
        for (int a : aliceSizes) {
            int b = a - diff;
            if (s.contains(b)) {
                return new int[] {a, b};
            }
        }
        return null;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0888 _tcSol = new Solution0888();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "aliceSizes = [1,1], bobSizes = [2,2]");
        try {
            int[] aliceSizes = new int[]{1, 1};
            int[] bobSizes = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.fairCandySwap(aliceSizes, bobSizes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "aliceSizes = [1,2], bobSizes = [2,3]");
        try {
            int[] aliceSizes = new int[]{1, 2};
            int[] bobSizes = new int[]{2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.fairCandySwap(aliceSizes, bobSizes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "aliceSizes = [2], bobSizes = [1,3]");
        try {
            int[] aliceSizes = new int[]{2};
            int[] bobSizes = new int[]{1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.fairCandySwap(aliceSizes, bobSizes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();
    }
}

package com.leetcode.arrays_hashing_greedy;

class Solution3285 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < height.length; ++i) {
            if (height[i - 1] > threshold) {
                ans.add(i);
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
        Solution3285 _tcSol = new Solution3285();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "height = [1,2,3,4,5], threshold = 2");
        try {
            int[] height = new int[]{1, 2, 3, 4, 5};
            int threshold = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.stableMountains(height, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "height = [10,1,10,1,10], threshold = 3");
        try {
            int[] height = new int[]{10, 1, 10, 1, 10};
            int threshold = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.stableMountains(height, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "height = [10,1,10,1,10], threshold = 10");
        try {
            int[] height = new int[]{10, 1, 10, 1, 10};
            int threshold = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.stableMountains(height, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}

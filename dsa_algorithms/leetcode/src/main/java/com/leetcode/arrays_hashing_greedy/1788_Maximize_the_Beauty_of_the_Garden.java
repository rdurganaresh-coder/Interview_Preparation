package com.leetcode.arrays_hashing_greedy;

class Solution1788 {
    public int maximumBeauty(int[] flowers) {
        int n = flowers.length;
        int[] s = new int[n + 1];
        Map<Integer, Integer> d = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int v = flowers[i];
            if (d.containsKey(v)) {
                ans = Math.max(ans, s[i] - s[d.get(v) + 1] + v * 2);
            } else {
                d.put(v, i);
            }
            s[i + 1] = s[i] + Math.max(v, 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1788 _tcSol = new Solution1788();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flowers = [1,2,3,1,2]");
        try {
            int[] flowers = new int[]{1, 2, 3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(flowers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flowers = [100,1,1,-3,1]");
        try {
            int[] flowers = new int[]{100, 1, 1, -3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(flowers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "flowers = [-1,-2,0,-1]");
        try {
            int[] flowers = new int[]{-1, -2, 0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(flowers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-2");
        System.out.println();
    }
}
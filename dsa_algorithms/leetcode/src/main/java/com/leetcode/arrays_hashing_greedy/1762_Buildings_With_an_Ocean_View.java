package com.leetcode.arrays_hashing_greedy;

class Solution1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> ans = new ArrayList<>();
        int mx = 0;
        for (int i = heights.length - 1; i >= 0; --i) {
            if (heights[i] > mx) {
                ans.add(i);
                mx = heights[i];
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1762 _tcSol = new Solution1762();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [4,2,3,1]");
        try {
            int[] heights = new int[]{4, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBuildings(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [4,3,2,1]");
        try {
            int[] heights = new int[]{4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBuildings(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1,2,3]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [1,3,2,4]");
        try {
            int[] heights = new int[]{1, 3, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findBuildings(heights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3]");
        System.out.println();
    }
}
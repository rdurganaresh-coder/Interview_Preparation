package com.leetcode.arrays_hashing_greedy;

class Solution2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; ++i) {
            if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
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
        Solution2951 _tcSol = new Solution2951();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mountain = [2,4,4]");
        try {
            int[] mountain = new int[]{2, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeaks(mountain)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mountain = [1,4,3,8,5]");
        try {
            int[] mountain = new int[]{1, 4, 3, 8, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findPeaks(mountain)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3]");
        System.out.println();
    }
}
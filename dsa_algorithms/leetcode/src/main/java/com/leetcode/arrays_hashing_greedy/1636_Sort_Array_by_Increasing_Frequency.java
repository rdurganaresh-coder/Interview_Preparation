package com.leetcode.arrays_hashing_greedy;

class Solution1636 {
    public int[] frequencySort(int[] nums) {
        int[] cnt = new int[201];
        List<Integer> t = new ArrayList<>();
        for (int v : nums) {
            v += 100;
            ++cnt[v];
            t.add(v);
        }
        t.sort((a, b) -> cnt[a] == cnt[b] ? b - a : cnt[a] - cnt[b]);
        int[] ans = new int[nums.length];
        int i = 0;
        for (int v : t) {
            ans[i++] = v - 100;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1636 _tcSol = new Solution1636();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,2,2,2,3]");
        try {
            int[] nums = new int[]{1, 1, 2, 2, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,1,1,2,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,1,3,2]");
        try {
            int[] nums = new int[]{2, 3, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,3,3,2,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,1,-6,4,5,-6,1,4,1]");
        try {
            int[] nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.frequencySort(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,-1,4,4,-6,-6,1,1,1]");
        System.out.println();
    }
}
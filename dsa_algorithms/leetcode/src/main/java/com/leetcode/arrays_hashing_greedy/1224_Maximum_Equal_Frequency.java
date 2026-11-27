package com.leetcode.arrays_hashing_greedy;

class Solution1224 {
    private static int[] cnt = new int[100010];
    private static int[] ccnt = new int[100010];

    public int maxEqualFreq(int[] nums) {
        Arrays.fill(cnt, 0);
        Arrays.fill(ccnt, 0);
        int ans = 0;
        int mx = 0;
        for (int i = 1; i <= nums.length; ++i) {
            int v = nums[i - 1];
            if (cnt[v] > 0) {
                --ccnt[cnt[v]];
            }
            ++cnt[v];
            mx = Math.max(mx, cnt[v]);
            ++ccnt[cnt[v]];
            if (mx == 1) {
                ans = i;
            } else if (ccnt[mx] * mx + ccnt[mx - 1] * (mx - 1) == i && ccnt[mx] == 1) {
                ans = i;
            } else if (ccnt[mx] * mx + 1 == i && ccnt[1] == 1) {
                ans = i;
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
        Solution1224 _tcSol = new Solution1224();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,2,1,1,5,3,3,5]");
        try {
            int[] nums = new int[]{2, 2, 1, 1, 5, 3, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEqualFreq(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]");
        try {
            int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxEqualFreq(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}
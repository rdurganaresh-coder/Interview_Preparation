package com.leetcode.arrays_hashing_greedy;

class Solution2122 {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1, n = nums.length; i < n; ++i) {
            int d = nums[i] - nums[0];
            if (d == 0 || d % 2 == 1) {
                continue;
            }
            boolean[] vis = new boolean[n];
            vis[i] = true;
            List<Integer> t = new ArrayList<>();
            t.add((nums[0] + nums[i]) >> 1);
            for (int l = 1, r = i + 1; r < n; ++l, ++r) {
                while (l < n && vis[l]) {
                    ++l;
                }
                while (r < n && nums[r] - nums[l] < d) {
                    ++r;
                }
                if (r == n || nums[r] - nums[l] > d) {
                    break;
                }
                vis[r] = true;
                t.add((nums[l] + nums[r]) >> 1);
            }
            if (t.size() == (n >> 1)) {
                int[] ans = new int[t.size()];
                int idx = 0;
                for (int e : t) {
                    ans[idx++] = e;
                }
                return ans;
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
        Solution2122 _tcSol = new Solution2122();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,10,6,4,8,12]");
        try {
            int[] nums = new int[]{2, 10, 6, 4, 8, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,7,11]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,3,3]");
        try {
            int[] nums = new int[]{1, 1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,435]");
        try {
            int[] nums = new int[]{5, 435};
            System.out.println("  Output  : " + _tcShow(_tcSol.recoverArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[220]");
        System.out.println();
    }
}
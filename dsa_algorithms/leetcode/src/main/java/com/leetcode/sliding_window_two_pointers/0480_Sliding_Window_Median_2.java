package com.leetcode.sliding_window_two_pointers;

class Solution0480_2 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> l = new TreeMap<>();
        TreeMap<Integer, Integer> r = new TreeMap<>();
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int lSize = 0, rSize = 0;
        for (int i = 0; i < n; ++i) {
            r.merge(nums[i], 1, Integer::sum);
            int x = r.firstKey();
            if (r.merge(x, -1, Integer::sum) == 0) {
                r.remove(x);
            }
            l.merge(x, 1, Integer::sum);
            ++lSize;
            while (lSize - rSize > 1) {
                x = l.lastKey();
                if (l.merge(x, -1, Integer::sum) == 0) {
                    l.remove(x);
                }
                r.merge(x, 1, Integer::sum);
                --lSize;
                ++rSize;
            }
            int j = i - k + 1;
            if (j >= 0) {
                ans[j] = k % 2 == 1 ? l.lastKey() : ((double) l.lastKey() + r.firstKey()) / 2;
                if (l.containsKey(nums[j])) {
                    if (l.merge(nums[j], -1, Integer::sum) == 0) {
                        l.remove(nums[j]);
                    }
                    --lSize;
                } else {
                    if (r.merge(nums[j], -1, Integer::sum) == 0) {
                        r.remove(nums[j]);
                    }
                    --rSize;
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
        Solution0480_2 _tcSol = new Solution0480_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,-1,-3,5,3,6,7], k = 3");
        try {
            int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.medianSlidingWindow(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,2,3,1,4,2], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.medianSlidingWindow(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]");
        System.out.println();
    }
}

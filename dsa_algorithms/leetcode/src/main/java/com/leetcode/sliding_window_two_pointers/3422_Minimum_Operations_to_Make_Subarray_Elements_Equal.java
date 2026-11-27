package com.leetcode.sliding_window_two_pointers;

class Solution3422 {
    public long minOperations(int[] nums, int k) {
        TreeMap<Integer, Integer> l = new TreeMap<>();
        TreeMap<Integer, Integer> r = new TreeMap<>();
        long s1 = 0, s2 = 0;
        int sz1 = 0, sz2 = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            l.merge(nums[i], 1, Integer::sum);
            s1 += nums[i];
            ++sz1;
            int y = l.lastKey();
            if (l.merge(y, -1, Integer::sum) == 0) {
                l.remove(y);
            }
            s1 -= y;
            --sz1;
            r.merge(y, 1, Integer::sum);
            s2 += y;
            ++sz2;
            if (sz2 - sz1 > 1) {
                y = r.firstKey();
                if (r.merge(y, -1, Integer::sum) == 0) {
                    r.remove(y);
                }
                s2 -= y;
                --sz2;
                l.merge(y, 1, Integer::sum);
                s1 += y;
                ++sz1;
            }
            if (i >= k - 1) {
                ans = Math.min(ans, s2 - 1L * r.firstKey() * sz2 + 1L * r.firstKey() * sz1 - s1);
                int j = i - k + 1;
                if (r.containsKey(nums[j])) {
                    if (r.merge(nums[j], -1, Integer::sum) == 0) {
                        r.remove(nums[j]);
                    }
                    s2 -= nums[j];
                    --sz2;
                } else {
                    if (l.merge(nums[j], -1, Integer::sum) == 0) {
                        l.remove(nums[j]);
                    }
                    s1 -= nums[j];
                    --sz1;
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
        Solution3422 _tcSol = new Solution3422();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,-3,2,1,-4,6], k = 3");
        try {
            int[] nums = new int[]{4, -3, 2, 1, -4, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2,-2,3,1,4], k = 2");
        try {
            int[] nums = new int[]{-2, -2, 3, 1, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}

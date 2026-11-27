package com.leetcode.arrays_hashing_greedy;

class Solution1681 {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int m = n / k;
        int[] g = new int[1 << n];
        Arrays.fill(g, -1);
        for (int i = 1; i < 1 << n; ++i) {
            if (Integer.bitCount(i) != m) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            int mi = 20, mx = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    if (!s.add(nums[j])) {
                        break;
                    }
                    mi = Math.min(mi, nums[j]);
                    mx = Math.max(mx, nums[j]);
                }
            }
            if (s.size() == m) {
                g[i] = mx - mi;
            }
        }
        int[] f = new int[1 << n];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 0; i < 1 << n; ++i) {
            if (f[i] == inf) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            int mask = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 0 && !s.contains(nums[j])) {
                    s.add(nums[j]);
                    mask |= 1 << j;
                }
            }
            if (s.size() < m) {
                continue;
            }
            for (int j = mask; j > 0; j = (j - 1) & mask) {
                if (g[j] != -1) {
                    f[i | j] = Math.min(f[i | j], f[i] + g[j]);
                }
            }
        }
        return f[(1 << n) - 1] == inf ? -1 : f[(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1681 _tcSol = new Solution1681();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,4], k = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIncompatibility(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,3,8,1,3,1,2,2], k = 4");
        try {
            int[] nums = new int[]{6, 3, 8, 1, 3, 1, 2, 2};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIncompatibility(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [5,3,3,6,3,3], k = 3");
        try {
            int[] nums = new int[]{5, 3, 3, 6, 3, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumIncompatibility(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
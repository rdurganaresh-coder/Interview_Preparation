package com.leetcode.arrays_hashing_greedy;

class Solution3117_2 {
    public int minimumValueSum(int[] nums, int[] andValues) {
        final int inf = 1 << 29;
        int n = nums.length, m = andValues.length;
        final int stride = 100001;
        Map<Integer, Integer> f = new HashMap<>();
        f.put(0, 0);
        for (int i = 0; i < n; ++i) {
            Map<Integer, Integer> g = new HashMap<>();
            for (var e : f.entrySet()) {
                int key = e.getKey(), cost = e.getValue();
                int j = key / stride;
                int a = key % stride - 1;
                if (n - i < m - j) {
                    continue;
                }
                int na = a & nums[i];
                if (na < andValues[j]) {
                    continue;
                }
                int nk = j * stride + na + 1;
                g.put(nk, Math.min(g.getOrDefault(nk, inf), cost));
                if (na == andValues[j]) {
                    int t = cost + nums[i];
                    if (j + 1 == m) {
                        if (i == n - 1) {
                            int done = m * stride;
                            g.put(done, Math.min(g.getOrDefault(done, inf), t));
                        }
                    } else {
                        int nk2 = (j + 1) * stride;
                        g.put(nk2, Math.min(g.getOrDefault(nk2, inf), t));
                    }
                }
            }
            f = g;
        }
        int ans = f.getOrDefault(m * stride, inf);
        return ans >= inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3117_2 _tcSol = new Solution3117_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,3,3,2], andValues = [0,3,3,2]");
        try {
            int[] nums = new int[]{1, 4, 3, 3, 2};
            int[] andValues = new int[]{0, 3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,7,7,7,5], andValues = [0,7,5]");
        try {
            int[] nums = new int[]{2, 3, 5, 7, 7, 7, 5};
            int[] andValues = new int[]{0, 7, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], andValues = [2]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int[] andValues = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumValueSum(nums, andValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}

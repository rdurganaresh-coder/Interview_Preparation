package com.leetcode.bit_manipulation_math;

class Solution1787 {
    public int minChanges(int[] nums, int k) {
        int n = 1 << 10;
        Map<Integer, Integer>[] cnt = new Map[k];
        Arrays.setAll(cnt, i -> new HashMap<>());
        int[] size = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            int j = i % k;
            cnt[j].merge(nums[i], 1, Integer::sum);
            size[j]++;
        }
        int[] f = new int[n];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 0; i < k; ++i) {
            int[] g = new int[n];
            Arrays.fill(g, min(f) + size[i]);
            for (int j = 0; j < n; ++j) {
                for (var e : cnt[i].entrySet()) {
                    int v = e.getKey(), c = e.getValue();
                    g[j] = Math.min(g[j], f[j ^ v] + size[i] - c);
                }
            }
            f = g;
        }
        return f[0];
    }

    private int min(int[] arr) {
        int mi = arr[0];
        for (int v : arr) {
            mi = Math.min(mi, v);
        }
        return mi;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1787 _tcSol = new Solution1787();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,0,3,0], k = 1");
        try {
            int[] nums = new int[]{1, 2, 0, 3, 0};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,4,5,2,1,7,3,4,7], k = 3");
        try {
            int[] nums = new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,4,1,2,5,1,2,6], k = 3");
        try {
            int[] nums = new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
package com.leetcode.bit_manipulation_math;

class Solution2975 {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hs = f(hFences, m);
        Set<Integer> vs = f(vFences, n);
        hs.retainAll(vs);
        int ans = -1;
        final int mod = (int) 1e9 + 7;
        for (int x : hs) {
            ans = Math.max(ans, x);
        }
        return ans > 0 ? (int) (1L * ans * ans % mod) : -1;
    }

    private Set<Integer> f(int[] nums, int k) {
        int n = nums.length;
        nums = Arrays.copyOf(nums, n + 2);
        nums[n] = 1;
        nums[n + 1] = k;
        Arrays.sort(nums);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                s.add(nums[i] - nums[j]);
            }
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2975 _tcSol = new Solution2975();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 4, n = 3, hFences = [2,3], vFences = [2]");
        try {
            int m = 4;
            int n = 3;
            int[] hFences = new int[]{2, 3};
            int[] vFences = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSquareArea(m, n, hFences, vFences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 6, n = 7, hFences = [2], vFences = [4]");
        try {
            int m = 6;
            int n = 7;
            int[] hFences = new int[]{2};
            int[] vFences = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSquareArea(m, n, hFences, vFences)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
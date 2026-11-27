package com.leetcode.bit_manipulation_math;

class Solution1998 {
    private int[] p;

    public boolean gcdSort(int[] nums) {
        int n = 100010;
        p = new int[n];
        Map<Integer, List<Integer>> f = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        for (int i = 2; i <= mx; ++i) {
            if (f.containsKey(i)) {
                continue;
            }
            for (int j = i; j <= mx; j += i) {
                f.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
            }
        }
        for (int i : nums) {
            for (int j : f.get(i)) {
                p[find(i)] = find(j);
            }
        }
        int[] s = new int[nums.length];
        System.arraycopy(nums, 0, s, 0, nums.length);
        Arrays.sort(s);
        for (int i = 0; i < nums.length; ++i) {
            if (s[i] != nums[i] && find(nums[i]) != find(s[i])) {
                return false;
            }
        }
        return true;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1998 _tcSol = new Solution1998();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,21,3]");
        try {
            int[] nums = new int[]{7, 21, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.gcdSort(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,2,6,2]");
        try {
            int[] nums = new int[]{5, 2, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.gcdSort(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
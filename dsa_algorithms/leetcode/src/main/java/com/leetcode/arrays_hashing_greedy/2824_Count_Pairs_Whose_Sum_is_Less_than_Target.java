package com.leetcode.arrays_hashing_greedy;

class Solution2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0;
        for (int j = 0; j < nums.size(); ++j) {
            int x = nums.get(j);
            int i = search(nums, target - x, j);
            ans += i;
        }
        return ans;
    }

    private int search(List<Integer> nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2824 _tcSol = new Solution2824();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,1,2,3,1], target = 2");
        try {
            List<Integer> nums = _tcL(-1, 1, 2, 3, 1);
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-6,2,5,-2,-7,-1,3], target = -2");
        try {
            List<Integer> nums = _tcL(-6, 2, 5, -2, -7, -1, 3);
            int target = -2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
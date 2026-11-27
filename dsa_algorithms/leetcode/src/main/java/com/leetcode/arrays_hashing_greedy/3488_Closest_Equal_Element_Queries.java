package com.leetcode.arrays_hashing_greedy;

class Solution3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = n * 2;
        int[] d = new int[m];
        Arrays.fill(d, m);

        Map<Integer, Integer> left = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = nums[i % n];
            if (left.containsKey(x)) {
                d[i] = Math.min(d[i], i - left.get(x));
            }
            left.put(x, i);
        }

        Map<Integer, Integer> right = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = nums[i % n];
            if (right.containsKey(x)) {
                d[i] = Math.min(d[i], right.get(x) - i);
            }
            right.put(x, i);
        }

        for (int i = 0; i < n; i++) {
            d[i] = Math.min(d[i], d[i + n]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            ans.add(d[query] >= n ? -1 : d[query]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3488 _tcSol = new Solution3488();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1,4,1,3,2], queries = [0,3,5]");
        try {
            int[] nums = new int[]{1, 3, 1, 4, 1, 3, 2};
            int[] queries = new int[]{0, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.solveQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,-1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4], queries = [0,1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int[] queries = new int[]{0, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.solveQueries(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,-1,-1]");
        System.out.println();
    }
}

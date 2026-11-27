package com.leetcode.dynamic_programming;

class Solution1755_2 {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        dfs(nums, 0, n >> 1, 0, left);
        dfs(nums, n >> 1, n, 0, right);
        List<Integer> rs = new ArrayList<>(right);
        Collections.sort(rs);
        int ans = Integer.MAX_VALUE;
        for (int x : left) {
            int y = goal - x;
            int l = 0, r = rs.size();
            while (l < r) {
                int mid = (l + r) >> 1;
                if (rs.get(mid) >= y) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l < rs.size()) {
                ans = Math.min(ans, Math.abs(y - rs.get(l)));
            }
            if (l > 0) {
                ans = Math.min(ans, Math.abs(y - rs.get(l - 1)));
            }
        }
        return ans;
    }

    private void dfs(int[] arr, int i, int n, int s, Set<Integer> res) {
        if (i == n) {
            res.add(s);
            return;
        }
        dfs(arr, i + 1, n, s, res);
        dfs(arr, i + 1, n, s + arr[i], res);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1755_2 _tcSol = new Solution1755_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,-7,3,5], goal = 6");
        try {
            int[] nums = new int[]{5, -7, 3, 5};
            int goal = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDifference(nums, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,-9,15,-2], goal = -5");
        try {
            int[] nums = new int[]{7, -9, 15, -2};
            int goal = -5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDifference(nums, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], goal = -7");
        try {
            int[] nums = new int[]{1, 2, 3};
            int goal = -7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minAbsDifference(nums, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}
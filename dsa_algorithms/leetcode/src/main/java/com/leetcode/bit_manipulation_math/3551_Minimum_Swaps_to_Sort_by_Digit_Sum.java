package com.leetcode.bit_manipulation_math;

class Solution3551 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = f(nums[i]);
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d.put(arr[i][1], i);
        }
        boolean[] vis = new boolean[n];
        int ans = n;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans--;
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = d.get(nums[j]);
                }
            }
        }
        return ans;
    }

    private int f(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3551 _tcSol = new Solution3551();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [37,100]");
        try {
            int[] nums = new int[]{37, 100};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [22,14,33,7]");
        try {
            int[] nums = new int[]{22, 14, 33, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [18,43,34,16]");
        try {
            int[] nums = new int[]{18, 43, 34, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}

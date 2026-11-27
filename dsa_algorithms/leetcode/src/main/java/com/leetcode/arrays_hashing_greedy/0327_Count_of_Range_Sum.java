package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree0327 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0327(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] += v;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x != 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution0327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        long[] arr = new long[n * 3 + 3];
        for (int i = 0, j = 0; i <= n; ++i, j += 3) {
            arr[j] = s[i];
            arr[j + 1] = s[i] - lower;
            arr[j + 2] = s[i] - upper;
        }
        Arrays.sort(arr);
        int m = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[m++] = arr[i];
            }
        }
        BinaryIndexedTree0327 tree = new BinaryIndexedTree0327(m);
        int ans = 0;
        for (long x : s) {
            int l = search(arr, m, x - upper);
            int r = search(arr, m, x - lower);
            ans += tree.query(r) - tree.query(l - 1);
            tree.update(search(arr, m, x), 1);
        }
        return ans;
    }

    private int search(long[] nums, int r, long x) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0327 _tcSol = new Solution0327();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-2,5,-1], lower = -2, upper = 2");
        try {
            int[] nums = new int[]{-2, 5, -1};
            int lower = -2;
            int upper = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countRangeSum(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0], lower = 0, upper = 0");
        try {
            int[] nums = new int[]{0};
            int lower = 0;
            int upper = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.countRangeSum(nums, lower, upper)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
package com.leetcode.dynamic_programming;

class Solution0300_2 {
    public int lengthOfLIS(int[] nums) {
        int[] s = nums.clone();
        Arrays.sort(s);
        int m = 0;
        int n = s.length;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || s[i] != s[i - 1]) {
                s[m++] = s[i];
            }
        }
        BinaryIndexedTree0300_2 tree = new BinaryIndexedTree0300_2(m);
        for (int x : nums) {
            x = search(s, x, m);
            int t = tree.query(x - 1) + 1;
            tree.update(x, t);
        }
        return tree.query(m);
    }

    private int search(int[] nums, int x, int r) {
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
        Solution0300_2 _tcSol = new Solution0300_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,9,2,5,3,7,101,18]");
        try {
            int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0,3,2,3]");
        try {
            int[] nums = new int[]{0, 1, 0, 3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [7,7,7,7,7,7,7]");
        try {
            int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLIS(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}

class BinaryIndexedTree0300_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0300_2(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mx = 0;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}
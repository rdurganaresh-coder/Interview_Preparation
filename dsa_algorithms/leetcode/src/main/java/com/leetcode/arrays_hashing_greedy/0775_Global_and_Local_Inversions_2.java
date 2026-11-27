package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree0775_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0775_2(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution0775_2 {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        BinaryIndexedTree0775_2 tree = new BinaryIndexedTree0775_2(n);
        int cnt = 0;
        for (int i = 0; i < n && cnt >= 0; ++i) {
            cnt += (i < n - 1 && nums[i] > nums[i + 1] ? 1 : 0);
            cnt -= (i - tree.query(nums[i]));
            tree.update(nums[i] + 1, 1);
        }
        return cnt == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0775_2 _tcSol = new Solution0775_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,2]");
        try {
            int[] nums = new int[]{1, 0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isIdealPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,0]");
        try {
            int[] nums = new int[]{1, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.isIdealPermutation(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
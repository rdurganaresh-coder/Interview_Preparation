package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2519 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2519(int n) {
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

class Solution2519 {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        BinaryIndexedTree2519 tree1 = new BinaryIndexedTree2519(n);
        BinaryIndexedTree2519 tree2 = new BinaryIndexedTree2519(n);
        for (int v : nums) {
            tree2.update(v, 1);
        }
        int ans = 0;
        for (int v : nums) {
            tree2.update(v, -1);
            if (tree1.query(v - 1) >= k && tree2.query(v - 1) >= k) {
                ++ans;
            }
            tree1.update(v, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2519 _tcSol = new Solution2519();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,6,5,2,3], k = 2");
        try {
            int[] nums = new int[]{2, 3, 6, 5, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kBigIndices(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 3");
        try {
            int[] nums = new int[]{1, 1, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kBigIndices(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
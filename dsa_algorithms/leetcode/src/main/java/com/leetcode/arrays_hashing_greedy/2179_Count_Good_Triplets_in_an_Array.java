package com.leetcode.arrays_hashing_greedy;

class Solution2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        BinaryIndexedTree2179 tree = new BinaryIndexedTree2179(n);
        for (int i = 0; i < n; ++i) {
            pos[nums2[i]] = i + 1;
        }
        long ans = 0;
        for (int num : nums1) {
            int p = pos[num];
            long left = tree.query(p);
            long right = n - p - (tree.query(n) - tree.query(p));
            ans += left * right;
            tree.update(p, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2179 _tcSol = new Solution2179();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [2,0,1,3], nums2 = [0,1,2,3]");
        try {
            int[] nums1 = new int[]{2, 0, 1, 3};
            int[] nums2 = new int[]{0, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]");
        try {
            int[] nums1 = new int[]{4, 0, 1, 3, 2};
            int[] nums2 = new int[]{4, 1, 0, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.goodTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}

class BinaryIndexedTree2179 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2179(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= lowbit(x);
        }
        return s;
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}
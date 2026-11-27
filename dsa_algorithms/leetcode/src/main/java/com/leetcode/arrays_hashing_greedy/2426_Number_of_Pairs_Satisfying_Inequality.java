package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2426 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2426(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public static final int lowbit(int x) {
        return x & -x;
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
}

class Solution2426 {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        BinaryIndexedTree2426 tree = new BinaryIndexedTree2426(100000);
        long ans = 0;
        for (int i = 0; i < nums1.length; ++i) {
            int v = nums1[i] - nums2[i];
            ans += tree.query(v + diff + 40000);
            tree.update(v + 40000, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2426 _tcSol = new Solution2426();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [3,2,5], nums2 = [2,2,1], diff = 1");
        try {
            int[] nums1 = new int[]{3, 2, 5};
            int[] nums2 = new int[]{2, 2, 1};
            int diff = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(nums1, nums2, diff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,-1], nums2 = [-2,2], diff = -1");
        try {
            int[] nums1 = new int[]{3, -1};
            int[] nums2 = new int[]{-2, 2};
            int diff = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfPairs(nums1, nums2, diff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
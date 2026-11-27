package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree2659 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2659(int n) {
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

class Solution2659 {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.put(nums[i], i);
        }
        Arrays.sort(nums);
        long ans = pos.get(nums[0]) + 1;
        BinaryIndexedTree2659 tree = new BinaryIndexedTree2659(n);
        for (int k = 0; k < n - 1; ++k) {
            int i = pos.get(nums[k]), j = pos.get(nums[k + 1]);
            long d = j - i - (tree.query(j + 1) - tree.query(i + 1));
            ans += d + (n - k) * (i > j ? 1 : 0);
            tree.update(i + 1, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2659 _tcSol = new Solution2659();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,4,-1]");
        try {
            int[] nums = new int[]{3, 4, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countOperationsToEmptyArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,4,3]");
        try {
            int[] nums = new int[]{1, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countOperationsToEmptyArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countOperationsToEmptyArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
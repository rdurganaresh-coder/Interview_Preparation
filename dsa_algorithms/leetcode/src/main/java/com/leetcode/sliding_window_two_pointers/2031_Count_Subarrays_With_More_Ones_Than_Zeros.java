package com.leetcode.sliding_window_two_pointers;

class BinaryIndexedTree2031 {
    private int n;
    private int[] c;

    public BinaryIndexedTree2031(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int v) {
        for (; x <= n; x += x & -x) {
            c[x] += v;
        }
    }

    public int query(int x) {
        int s = 0;
        for (; x > 0; x -= x & -x) {
            s += c[x];
        }
        return s;
    }
}

class Solution2031 {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        int base = n + 1;
        BinaryIndexedTree2031 tree = new BinaryIndexedTree2031(n + base);
        tree.update(base, 1);
        final int mod = (int) 1e9 + 7;
        int ans = 0, s = 0;
        for (int x : nums) {
            s += x == 0 ? -1 : 1;
            ans += tree.query(s - 1 + base);
            ans %= mod;
            tree.update(s + base, 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2031 _tcSol = new Solution2031();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1,0,1]");
        try {
            int[] nums = new int[]{0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysWithMoreZerosThanOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0]");
        try {
            int[] nums = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysWithMoreZerosThanOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1]");
        try {
            int[] nums = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysWithMoreZerosThanOnes(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
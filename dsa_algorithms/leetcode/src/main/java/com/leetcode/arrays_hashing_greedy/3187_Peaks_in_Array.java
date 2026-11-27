package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree3187 {
    private int n;
    private int[] c;

    public BinaryIndexedTree3187(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int delta) {
        for (; x <= n; x += x & -x) {
            c[x] += delta;
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

class Solution3187 {
    private BinaryIndexedTree3187 tree;
    private int[] nums;

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        this.nums = nums;
        tree = new BinaryIndexedTree3187(n - 1);
        for (int i = 1; i < n - 1; ++i) {
            update(i, 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (var q : queries) {
            if (q[0] == 1) {
                int l = q[1] + 1, r = q[2] - 1;
                ans.add(l > r ? 0 : tree.query(r) - tree.query(l - 1));
            } else {
                int idx = q[1], val = q[2];
                for (int i = idx - 1; i <= idx + 1; ++i) {
                    update(i, -1);
                }
                nums[idx] = val;
                for (int i = idx - 1; i <= idx + 1; ++i) {
                    update(i, 1);
                }
            }
        }
        return ans;
    }

    private void update(int i, int val) {
        if (i <= 0 || i >= nums.length - 1) {
            return;
        }
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
            tree.update(i, val);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3187 _tcSol = new Solution3187();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,4,2,5], queries = [[2,3,4],[1,0,4]]");
        try {
            int[] nums = new int[]{3, 1, 4, 2, 5};
            int[][] queries = new int[][]{new int[]{2, 3, 4}, new int[]{1, 0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfPeaks(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,1,4,2,1,5], queries = [[2,2,4],[1,0,2],[1,0,4]]");
        try {
            int[] nums = new int[]{4, 1, 4, 2, 1, 5};
            int[][] queries = new int[][]{new int[]{2, 2, 4}, new int[]{1, 0, 2}, new int[]{1, 0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countOfPeaks(nums, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,1]");
        System.out.println();
    }
}
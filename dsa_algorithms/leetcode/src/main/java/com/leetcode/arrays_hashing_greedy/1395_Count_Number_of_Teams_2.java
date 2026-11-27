package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree1395_2 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1395_2(int n) {
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
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution1395_2 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] nums = rating.clone();
        Arrays.sort(nums);
        int m = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[m++] = nums[i];
            }
        }
        BinaryIndexedTree1395_2 tree1 = new BinaryIndexedTree1395_2(m);
        BinaryIndexedTree1395_2 tree2 = new BinaryIndexedTree1395_2(m);
        for (int v : rating) {
            int x = search(nums, v);
            tree2.update(x, 1);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = search(nums, rating[i]);
            tree1.update(x, 1);
            tree2.update(x, -1);
            int l = tree1.query(x - 1);
            int r = n - i - 1 - tree2.query(x);
            ans += l * r;
            ans += (i - l) * (n - i - 1 - r);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
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
        Solution1395_2 _tcSol = new Solution1395_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rating = [2,5,3,4,1]");
        try {
            int[] rating = new int[]{2, 5, 3, 4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rating = [2,1,3]");
        try {
            int[] rating = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rating = [1,2,3,4]");
        try {
            int[] rating = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTeams(rating)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
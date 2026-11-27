package com.leetcode.arrays_hashing_greedy;

class BinaryIndexedTree3072 {
    private int n;
    private int[] c;

    public BinaryIndexedTree3072(int n) {
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

class Solution3072 {
    public int[] resultArray(int[] nums) {
        int[] st = nums.clone();
        Arrays.sort(st);
        int n = st.length;
        BinaryIndexedTree3072 tree1 = new BinaryIndexedTree3072(n + 1);
        BinaryIndexedTree3072 tree2 = new BinaryIndexedTree3072(n + 1);
        tree1.update(Arrays.binarySearch(st, nums[0]) + 1, 1);
        tree2.update(Arrays.binarySearch(st, nums[1]) + 1, 1);
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int i = 1, j = 1;
        for (int k = 2; k < n; ++k) {
            int x = Arrays.binarySearch(st, nums[k]) + 1;
            int a = i - tree1.query(x);
            int b = j - tree2.query(x);
            if (a > b) {
                arr1[i++] = nums[k];
                tree1.update(x, 1);
            } else if (a < b) {
                arr2[j++] = nums[k];
                tree2.update(x, 1);
            } else if (i <= j) {
                arr1[i++] = nums[k];
                tree1.update(x, 1);
            } else {
                arr2[j++] = nums[k];
                tree2.update(x, 1);
            }
        }
        for (int k = 0; k < j; ++k) {
            arr1[i++] = arr2[k];
        }
        return arr1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3072 _tcSol = new Solution3072();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,3]");
        try {
            int[] nums = new int[]{2, 1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,14,3,1,2]");
        try {
            int[] nums = new int[]{5, 14, 3, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,3,1,2,14]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3,3,3]");
        try {
            int[] nums = new int[]{3, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.resultArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,3,3]");
        System.out.println();
    }
}
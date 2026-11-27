package com.leetcode.dynamic_programming;

class BinaryIndexedTree1713 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1713(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int v) {
        for (; x <= n; x += x & -x) {
            c[x] = Math.max(c[x], v);
        }
    }

    public int query(int x) {
        int ans = 0;
        for (; x > 0; x -= x & -x) {
            ans = Math.max(ans, c[x]);
        }
        return ans;
    }
}

class Solution1713 {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length;
        Map<Integer, Integer> d = new HashMap<>(m);
        for (int i = 0; i < m; i++) {
            d.put(target[i], i + 1);
        }
        List<Integer> nums = new ArrayList<>();
        for (int x : arr) {
            if (d.containsKey(x)) {
                nums.add(d.get(x));
            }
        }
        BinaryIndexedTree1713 tree = new BinaryIndexedTree1713(m);
        int ans = 0;
        for (int x : nums) {
            int v = tree.query(x - 1) + 1;
            ans = Math.max(ans, v);
            tree.update(x, v);
        }
        return m - ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1713 _tcSol = new Solution1713();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = [5,1,3], arr = [9,4,2,3,4]");
        try {
            int[] target = new int[]{5, 1, 3};
            int[] arr = new int[]{9, 4, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(target, arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]");
        try {
            int[] target = new int[]{6, 4, 8, 1, 3, 2};
            int[] arr = new int[]{4, 7, 6, 2, 3, 8, 6, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(target, arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
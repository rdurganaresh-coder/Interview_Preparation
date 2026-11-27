package com.leetcode.arrays_hashing_greedy;

class Solution0315 {
    public List<Integer> countSmaller(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        List<Integer> alls = new ArrayList<>(s);
        alls.sort(Comparator.comparingInt(a -> a));
        int n = alls.size();
        Map<Integer, Integer> m = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            m.put(alls.get(i), i + 1);
        }
        BinaryIndexedTree0315 tree = new BinaryIndexedTree0315(n);
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int x = m.get(nums[i]);
            tree.update(x, 1);
            ans.addFirst(tree.query(x - 1));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0315 _tcSol = new Solution0315();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,6,1]");
        try {
            int[] nums = new int[]{5, 2, 6, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSmaller(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1,1,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1]");
        try {
            int[] nums = new int[]{-1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSmaller(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-1,-1]");
        try {
            int[] nums = new int[]{-1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countSmaller(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();
    }
}

class BinaryIndexedTree0315 {
    private int n;
    private int[] c;

    public BinaryIndexedTree0315(int n) {
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
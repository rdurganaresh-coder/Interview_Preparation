package com.leetcode.arrays_hashing_greedy;

class Solution0315_2 {
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
        SegmentTree0315_2 tree = new SegmentTree0315_2(n);
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int x = m.get(nums[i]);
            tree.modify(1, x, 1);
            ans.addFirst(tree.query(1, 1, x - 1));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0315_2 _tcSol = new Solution0315_2();
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

class Node0315_2 {
    int l;
    int r;
    int v;
}

class SegmentTree0315_2 {
    private Node0315_2[] tr;

    public SegmentTree0315_2(int n) {
        tr = new Node0315_2[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node0315_2();
        }
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    public void modify(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v += v;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, v);
        } else {
            modify(u << 1 | 1, x, v);
        }
        pushup(u);
    }

    public void pushup(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v += query(u << 1, l, r);
        }
        if (r > mid) {
            v += query(u << 1 | 1, l, r);
        }
        return v;
    }
}
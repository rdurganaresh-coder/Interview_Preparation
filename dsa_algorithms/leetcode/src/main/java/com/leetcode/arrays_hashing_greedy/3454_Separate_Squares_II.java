package com.leetcode.arrays_hashing_greedy;

class Node3454 {
    int l, r, cnt, length;
}

class SegmentTree3454 {
    private Node3454[] tr;
    private int[] nums;

    public SegmentTree3454(int[] nums) {
        this.nums = nums;
        int n = nums.length - 1;
        tr = new Node3454[n << 2];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node3454();
        }
        build(1, 0, n - 1);
    }

    private void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l != r) {
            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }
    }

    public void modify(int u, int l, int r, int k) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].cnt += k;
        } else {
            int mid = (tr[u].l + tr[u].r) >> 1;
            if (l <= mid) {
                modify(u << 1, l, r, k);
            }
            if (r > mid) {
                modify(u << 1 | 1, l, r, k);
            }
        }
        pushup(u);
    }

    private void pushup(int u) {
        if (tr[u].cnt > 0) {
            tr[u].length = nums[tr[u].r + 1] - nums[tr[u].l];
        } else if (tr[u].l == tr[u].r) {
            tr[u].length = 0;
        } else {
            tr[u].length = tr[u << 1].length + tr[u << 1 | 1].length;
        }
    }

    public int query() {
        return tr[1].length;
    }
}

class Solution3454 {
    public double separateSquares(int[][] squares) {
        Set<Integer> xs = new HashSet<>();
        List<int[]> segs = new ArrayList<>();
        for (int[] sq : squares) {
            int x1 = sq[0], y1 = sq[1], l = sq[2];
            int x2 = x1 + l, y2 = y1 + l;
            xs.add(x1);
            xs.add(x2);
            segs.add(new int[] {y1, x1, x2, 1});
            segs.add(new int[] {y2, x1, x2, -1});
        }
        segs.sort(Comparator.comparingInt(a -> a[0]));
        int[] st = new int[xs.size()];
        int i = 0;
        for (int x : xs) {
            st[i++] = x;
        }
        Arrays.sort(st);
        SegmentTree3454 tree = new SegmentTree3454(st);
        Map<Integer, Integer> d = new HashMap<>(st.length);
        for (i = 0; i < st.length; i++) {
            d.put(st[i], i);
        }
        double area = 0.0;
        int y0 = 0;
        for (int[] s : segs) {
            int y = s[0], x1 = s[1], x2 = s[2], k = s[3];
            area += (double) (y - y0) * tree.query();
            tree.modify(1, d.get(x1), d.get(x2) - 1, k);
            y0 = y;
        }
        double target = area / 2.0;
        area = 0.0;
        y0 = 0;
        for (int[] s : segs) {
            int y = s[0], x1 = s[1], x2 = s[2], k = s[3];
            double t = (double) (y - y0) * tree.query();
            if (area + t >= target) {
                return y0 + (target - area) / tree.query();
            }
            area += t;
            tree.modify(1, d.get(x1), d.get(x2) - 1, k);
            y0 = y;
        }
        return 0.0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3454 _tcSol = new Solution3454();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "squares = [[0,0,1],[2,2,1]]");
        try {
            int[][] squares = new int[][]{new int[]{0, 0, 1}, new int[]{2, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateSquares(squares)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "squares = [[0,0,2],[1,1,1]]");
        try {
            int[][] squares = new int[][]{new int[]{0, 0, 2}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.separateSquares(squares)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1.00000");
        System.out.println();
    }
}

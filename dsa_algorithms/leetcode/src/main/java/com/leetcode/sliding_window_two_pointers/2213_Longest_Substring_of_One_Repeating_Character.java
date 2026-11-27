package com.leetcode.sliding_window_two_pointers;

class Node2213 {
    int l, r;
    int lmx, rmx, mx;

    Node2213(int l, int r) {
        this.l = l;
        this.r = r;
        lmx = rmx = mx = 1;
    }
}

class SegmentTree2213 {
    private char[] s;
    private Node2213[] tr;

    public SegmentTree2213(char[] s) {
        int n = s.length;
        this.s = s;
        tr = new Node2213[n << 2];
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u] = new Node2213(l, r);
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public void modify(int u, int x, char v) {
        if (tr[u].l == x && tr[u].r == x) {
            s[x - 1] = v;
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

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].mx;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int ans = 0;
        if (r <= mid) {
            ans = query(u << 1, l, r);
        }
        if (l > mid) {
            ans = Math.max(ans, query(u << 1 | 1, l, r));
        }
        return ans;
    }

    private void pushup(int u) {
        Node2213 root = tr[u];
        Node2213 left = tr[u << 1], right = tr[u << 1 | 1];
        root.mx = Math.max(left.mx, right.mx);
        root.lmx = left.lmx;
        root.rmx = right.rmx;
        int a = left.r - left.l + 1;
        int b = right.r - right.l + 1;
        if (s[left.r - 1] == s[right.l - 1]) {
            if (left.lmx == a) {
                root.lmx += right.lmx;
            }
            if (right.rmx == b) {
                root.rmx += left.rmx;
            }
            root.mx = Math.max(root.mx, left.rmx + right.lmx);
        }
    }
}

class Solution2213 {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree2213 tree = new SegmentTree2213(s.toCharArray());
        int k = queryIndices.length;
        int[] ans = new int[k];
        int n = s.length();
        for (int i = 0; i < k; ++i) {
            int x = queryIndices[i] + 1;
            char v = queryCharacters.charAt(i);
            tree.modify(1, x, v);
            ans[i] = tree.query(1, 1, n);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2213 _tcSol = new Solution2213();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"babacc\", queryCharacters = \"bcb\", queryIndices = [1,3,3]");
        try {
            String s = "babacc";
            String queryCharacters = "bcb";
            int[] queryIndices = new int[]{1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestRepeating(s, queryCharacters, queryIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,3,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abyzz\", queryCharacters = \"aa\", queryIndices = [2,1]");
        try {
            String s = "abyzz";
            String queryCharacters = "aa";
            int[] queryIndices = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestRepeating(s, queryCharacters, queryIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();
    }
}
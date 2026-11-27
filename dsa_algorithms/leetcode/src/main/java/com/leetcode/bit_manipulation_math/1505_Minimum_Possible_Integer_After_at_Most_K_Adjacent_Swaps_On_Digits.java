package com.leetcode.bit_manipulation_math;

class Solution1505 {
    public String minInteger(String num, int k) {
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = new ArrayDeque<>();
        }
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            pos[num.charAt(i) - '0'].offer(i + 1);
        }
        StringBuilder ans = new StringBuilder();
        BinaryIndexedTree1505 tree = new BinaryIndexedTree1505(n);
        for (int i = 1; i <= n; ++i) {
            for (int v = 0; v < 10; ++v) {
                if (!pos[v].isEmpty()) {
                    Queue<Integer> q = pos[v];
                    int j = q.peek();
                    int dist = tree.query(n) - tree.query(j) + j - i;
                    if (dist <= k) {
                        k -= dist;
                        q.poll();
                        ans.append(v);
                        tree.update(j, 1);
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1505 _tcSol = new Solution1505();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"4321\", k = 4");
        try {
            String num = "4321";
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minInteger(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1342\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"100\", k = 1");
        try {
            String num = "100";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minInteger(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"010\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"36789\", k = 1000");
        try {
            String num = "36789";
            int k = 1000;
            System.out.println("  Output  : " + _tcShow(_tcSol.minInteger(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"36789\"");
        System.out.println();
    }
}

class BinaryIndexedTree1505 {
    private int n;
    private int[] c;

    public BinaryIndexedTree1505(int n) {
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
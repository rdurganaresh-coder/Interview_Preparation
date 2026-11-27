package com.leetcode.arrays_hashing_greedy;

class Solution2613 {
    private List<int[]> points = new ArrayList<>();

    public int[] beautifulPair(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Long, List<Integer>> pl = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            long z = f(nums1[i], nums2[i]);
            pl.computeIfAbsent(z, k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; ++i) {
            long z = f(nums1[i], nums2[i]);
            if (pl.get(z).size() > 1) {
                return new int[] {i, pl.get(z).get(1)};
            }
            points.add(new int[] {nums1[i], nums2[i], i});
        }
        points.sort((a, b) -> a[0] - b[0]);
        int[] ans = dfs(0, points.size() - 1);
        return new int[] {ans[1], ans[2]};
    }

    private long f(int x, int y) {
        return x * 100001L + y;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private int[] dfs(int l, int r) {
        if (l >= r) {
            return new int[] {1 << 30, -1, -1};
        }
        int m = (l + r) >> 1;
        int x = points.get(m)[0];
        int[] t1 = dfs(l, m);
        int[] t2 = dfs(m + 1, r);
        if (t1[0] > t2[0]
            || (t1[0] == t2[0] && (t1[1] > t2[1] || (t1[1] == t2[1] && t1[2] > t2[2])))) {
            t1 = t2;
        }
        List<int[]> t = new ArrayList<>();
        for (int i = l; i <= r; ++i) {
            if (Math.abs(points.get(i)[0] - x) <= t1[0]) {
                t.add(points.get(i));
            }
        }
        t.sort((a, b) -> a[1] - b[1]);
        for (int i = 0; i < t.size(); ++i) {
            for (int j = i + 1; j < t.size(); ++j) {
                if (t.get(j)[1] - t.get(i)[1] > t1[0]) {
                    break;
                }
                int pi = Math.min(t.get(i)[2], t.get(j)[2]);
                int pj = Math.max(t.get(i)[2], t.get(j)[2]);
                int d = dist(t.get(i)[0], t.get(i)[1], t.get(j)[0], t.get(j)[1]);
                if (d < t1[0] || (d == t1[0] && (pi < t1[1] || (pi == t1[1] && pj < t1[2])))) {
                    t1 = new int[] {d, pi, pj};
                }
            }
        }
        return t1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2613 _tcSol = new Solution2613();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,3,2,4], nums2 = [2,3,1,2,3]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 2, 4};
            int[] nums2 = new int[]{2, 3, 1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulPair(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,4,3,2,5], nums2 = [1,4,2,3,5,1]");
        try {
            int[] nums1 = new int[]{1, 2, 4, 3, 2, 5};
            int[] nums2 = new int[]{1, 4, 2, 3, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulPair(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4]");
        System.out.println();
    }
}
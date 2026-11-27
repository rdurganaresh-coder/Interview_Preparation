package com.leetcode.sliding_window_two_pointers;

class Solution3318 {
    private TreeSet<int[]> l = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    private TreeSet<int[]> r = new TreeSet<>(l.comparator());
    private Map<Integer, Integer> cnt = new HashMap<>();
    private int s;

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            remove(v);
            cnt.merge(v, 1, Integer::sum);
            add(v);
            int j = i - k + 1;
            if (j < 0) {
                continue;
            }
            while (!r.isEmpty() && l.size() < x) {
                var p = r.pollLast();
                s += p[0] * p[1];
                l.add(p);
            }
            while (l.size() > x) {
                var p = l.pollFirst();
                s -= p[0] * p[1];
                r.add(p);
            }
            ans[j] = s;

            remove(nums[j]);
            cnt.merge(nums[j], -1, Integer::sum);
            add(nums[j]);
        }
        return ans;
    }

    private void remove(int v) {
        if (!cnt.containsKey(v)) {
            return;
        }
        var p = new int[] {cnt.get(v), v};
        if (l.contains(p)) {
            l.remove(p);
            s -= p[0] * p[1];
        } else {
            r.remove(p);
        }
    }

    private void add(int v) {
        if (!cnt.containsKey(v)) {
            return;
        }
        var p = new int[] {cnt.get(v), v};
        if (!l.isEmpty() && l.comparator().compare(l.first(), p) < 0) {
            l.add(p);
            s += p[0] * p[1];
        } else {
            r.add(p);
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3318 _tcSol = new Solution3318();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,2,2,3,4,2,3], k = 6, x = 2");
        try {
            int[] nums = new int[]{1, 1, 2, 2, 3, 4, 2, 3};
            int k = 6;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findXSum(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,10,12]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,8,7,8,7,5], k = 2, x = 2");
        try {
            int[] nums = new int[]{3, 8, 7, 8, 7, 5};
            int k = 2;
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findXSum(nums, k, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[11,15,15,15,12]");
        System.out.println();
    }
}

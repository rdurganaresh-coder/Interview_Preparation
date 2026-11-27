package com.leetcode.graphs_shortest_path;

class Solution3323 {
    public int minConnectedGroups(int[][] intervals, int k) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] < interval[0]) {
                merged.add(interval);
            } else {
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        int ans = merged.size();
        for (int i = 0; i < merged.size(); i++) {
            int[] interval = merged.get(i);
            int j = binarySearch(merged, interval[1] + k + 1);
            ans = Math.min(ans, merged.size() - (j - i - 1));
        }

        return ans;
    }

    private int binarySearch(List<int[]> nums, int x) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid)[0] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3323 _tcSol = new Solution3323();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "intervals = [[1,3],[5,6],[8,10]], k = 3");
        try {
            int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{5, 6}, new int[]{8, 10}};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minConnectedGroups(intervals, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "intervals = [[5,10],[1,1],[3,3]], k = 1");
        try {
            int[][] intervals = new int[][]{new int[]{5, 10}, new int[]{1, 1}, new int[]{3, 3}};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minConnectedGroups(intervals, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}

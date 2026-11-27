package com.leetcode.arrays_hashing_greedy;

class Solution2251_2 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int[] f : flowers) {
            d.merge(f[0], 1, Integer::sum);
            d.merge(f[1] + 1, -1, Integer::sum);
        }
        int s = 0;
        int m = people.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> people[i]));
        int[] ans = new int[m];
        for (int i : idx) {
            int t = people[i];
            while (!d.isEmpty() && d.firstKey() <= t) {
                s += d.pollFirstEntry().getValue();
            }
            ans[i] = s;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2251_2 _tcSol = new Solution2251_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]");
        try {
            int[][] flowers = new int[][]{new int[]{1, 6}, new int[]{3, 7}, new int[]{9, 12}, new int[]{4, 13}};
            int[] people = new int[]{2, 3, 7, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.fullBloomFlowers(flowers, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "flowers = [[1,10],[3,3]], people = [3,3,2]");
        try {
            int[][] flowers = new int[][]{new int[]{1, 10}, new int[]{3, 3}};
            int[] people = new int[]{3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.fullBloomFlowers(flowers, people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,1]");
        System.out.println();
    }
}
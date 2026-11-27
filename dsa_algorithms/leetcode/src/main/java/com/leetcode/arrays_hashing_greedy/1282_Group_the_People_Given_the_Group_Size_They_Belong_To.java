package com.leetcode.arrays_hashing_greedy;

class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            g[groupSizes[i]].add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < g.length; ++i) {
            List<Integer> v = g[i];
            for (int j = 0; j < v.size(); j += i) {
                ans.add(v.subList(j, j + i));
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1282 _tcSol = new Solution1282();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "groupSizes = [3,3,3,3,3,1,3]");
        try {
            int[] groupSizes = new int[]{3, 3, 3, 3, 3, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupThePeople(groupSizes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5],[0,1,2],[3,4,6]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "groupSizes = [2,1,3,3,3,2]");
        try {
            int[] groupSizes = new int[]{2, 1, 3, 3, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.groupThePeople(groupSizes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1],[0,5],[2,3,4]]");
        System.out.println();
    }
}
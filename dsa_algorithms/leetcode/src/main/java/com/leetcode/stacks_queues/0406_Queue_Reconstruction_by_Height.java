package com.leetcode.stacks_queues;

class Solution0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>(people.length);
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0406 _tcSol = new Solution0406();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]");
        try {
            int[][] people = new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{7, 1}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.reconstructQueue(people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]");
        try {
            int[][] people = new int[][]{new int[]{6, 0}, new int[]{5, 0}, new int[]{4, 0}, new int[]{3, 2}, new int[]{2, 2}, new int[]{1, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.reconstructQueue(people)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]");
        System.out.println();
    }
}
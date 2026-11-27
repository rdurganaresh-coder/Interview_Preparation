package com.leetcode.arrays_hashing_greedy;

class Solution1943 {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> d = new TreeMap<>();
        for (int[] e : segments) {
            int l = e[0], r = e[1], c = e[2];
            d.put(l, d.getOrDefault(l, 0L) + c);
            d.put(r, d.getOrDefault(r, 0L) - c);
        }
        List<List<Long>> ans = new ArrayList<>();
        long i = 0, j = 0;
        long cur = 0;
        for (Map.Entry<Integer, Long> e : d.entrySet()) {
            if (Objects.equals(e.getKey(), d.firstKey())) {
                i = e.getKey();
            } else {
                j = e.getKey();
                if (cur > 0) {
                    ans.add(Arrays.asList(i, j, cur));
                }
                i = j;
            }
            cur += e.getValue();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1943 _tcSol = new Solution1943();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "segments = [[1,4,5],[4,7,7],[1,7,9]]");
        try {
            int[][] segments = new int[][]{new int[]{1, 4, 5}, new int[]{4, 7, 7}, new int[]{1, 7, 9}};
            System.out.println("  Output  : " + _tcShow(_tcSol.splitPainting(segments)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4,14],[4,7,16]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "segments = [[1,7,9],[6,8,15],[8,10,7]]");
        try {
            int[][] segments = new int[][]{new int[]{1, 7, 9}, new int[]{6, 8, 15}, new int[]{8, 10, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.splitPainting(segments)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,6,9],[6,7,24],[7,8,15],[8,10,7]]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "segments = [[1,4,5],[1,4,7],[4,7,1],[4,7,11]]");
        try {
            int[][] segments = new int[][]{new int[]{1, 4, 5}, new int[]{1, 4, 7}, new int[]{4, 7, 1}, new int[]{4, 7, 11}};
            System.out.println("  Output  : " + _tcShow(_tcSol.splitPainting(segments)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[1,4,12],[4,7,12]]");
        System.out.println();
    }
}
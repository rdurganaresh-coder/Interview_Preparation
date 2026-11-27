package com.leetcode.graphs_shortest_path;

class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeSet<Integer> sunny = new TreeSet<>();
        Map<Integer, Integer> rainy = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int v = rains[i];
            if (v > 0) {
                if (rainy.containsKey(v)) {
                    Integer t = sunny.higher(rainy.get(v));
                    if (t == null) {
                        return new int[0];
                    }
                    ans[t] = v;
                    sunny.remove(t);
                }
                rainy.put(v, i);
            } else {
                sunny.add(i);
                ans[i] = 1;
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
        Solution1488 _tcSol = new Solution1488();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rains = [1,2,3,4]");
        try {
            int[] rains = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.avoidFlood(rains)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,-1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rains = [1,2,0,0,2,1]");
        try {
            int[] rains = new int[]{1, 2, 0, 0, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.avoidFlood(rains)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,2,1,-1,-1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "rains = [1,2,0,1,2]");
        try {
            int[] rains = new int[]{1, 2, 0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.avoidFlood(rains)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}
package com.leetcode.arrays_hashing_greedy;

class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> last = new HashMap<>(3);
        int ans = 0;
        for (int i = 0; i < garbage.length; ++i) {
            String s = garbage[i];
            ans += s.length();
            for (char c : s.toCharArray()) {
                last.put(c, i);
            }
        }
        int ts = 0;
        for (int i = 1; i <= travel.length; ++i) {
            ts += travel[i - 1];
            for (int j : last.values()) {
                if (i == j) {
                    ans += ts;
                }
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
        Solution2391 _tcSol = new Solution2391();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "garbage = [\"G\",\"P\",\"GP\",\"GG\"], travel = [2,4,3]");
        try {
            String[] garbage = new String[]{"G", "P", "GP", "GG"};
            int[] travel = new int[]{2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.garbageCollection(garbage, travel)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "garbage = [\"MMM\",\"PGM\",\"GP\"], travel = [3,10]");
        try {
            String[] garbage = new String[]{"MMM", "PGM", "GP"};
            int[] travel = new int[]{3, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.garbageCollection(garbage, travel)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "37");
        System.out.println();
    }
}
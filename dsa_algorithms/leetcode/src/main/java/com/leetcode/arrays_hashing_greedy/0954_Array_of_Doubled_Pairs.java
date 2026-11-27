package com.leetcode.arrays_hashing_greedy;

class Solution0954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : arr) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        if ((freq.getOrDefault(0, 0) & 1) != 0) {
            return false;
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort(Comparator.comparingInt(Math::abs));
        for (int k : keys) {
            if (freq.getOrDefault(k << 1, 0) < freq.get(k)) {
                return false;
            }
            freq.put(k << 1, freq.getOrDefault(k << 1, 0) - freq.get(k));
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0954 _tcSol = new Solution0954();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,1,3,6]");
        try {
            int[] arr = new int[]{3, 1, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.canReorderDoubled(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,1,2,6]");
        try {
            int[] arr = new int[]{2, 1, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.canReorderDoubled(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [4,-2,2,-4]");
        try {
            int[] arr = new int[]{4, -2, 2, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canReorderDoubled(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
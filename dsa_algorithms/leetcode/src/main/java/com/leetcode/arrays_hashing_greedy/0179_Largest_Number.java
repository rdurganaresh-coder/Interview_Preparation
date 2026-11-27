package com.leetcode.arrays_hashing_greedy;

class Solution0179 {
    public String largestNumber(int[] nums) {
        List<String> vs = new ArrayList<>();
        for (int v : nums) {
            vs.add(v + "");
        }
        vs.sort((a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(vs.get(0))) {
            return "0";
        }
        return String.join("", vs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0179 _tcSol = new Solution0179();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,2]");
        try {
            int[] nums = new int[]{10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"210\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,30,34,5,9]");
        try {
            int[] nums = new int[]{3, 30, 34, 5, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"9534330\"");
        System.out.println();
    }
}
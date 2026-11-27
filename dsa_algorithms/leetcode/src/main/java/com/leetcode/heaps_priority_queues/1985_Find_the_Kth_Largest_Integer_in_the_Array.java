package com.leetcode.heaps_priority_queues;

class Solution1985 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(
            nums, (a, b) -> a.length() == b.length() ? b.compareTo(a) : b.length() - a.length());
        return nums[k - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1985 _tcSol = new Solution1985();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [\"3\",\"6\",\"7\",\"10\"], k = 4");
        try {
            String[] nums = new String[]{"3", "6", "7", "10"};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestNumber(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"3\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [\"2\",\"21\",\"12\",\"1\"], k = 3");
        try {
            String[] nums = new String[]{"2", "21", "12", "1"};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestNumber(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [\"0\",\"0\"], k = 2");
        try {
            String[] nums = new String[]{"0", "0"};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLargestNumber(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();
    }
}
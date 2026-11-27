package com.leetcode.arrays_hashing_greedy;

class Solution2449 {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        List<Integer> b2 = new ArrayList<>();
        for (int v : nums) {
            if (v % 2 == 0) {
                a1.add(v);
            } else {
                a2.add(v);
            }
        }
        for (int v : target) {
            if (v % 2 == 0) {
                b1.add(v);
            } else {
                b2.add(v);
            }
        }
        long ans = 0;
        for (int i = 0; i < a1.size(); ++i) {
            ans += Math.abs(a1.get(i) - b1.get(i));
        }
        for (int i = 0; i < a2.size(); ++i) {
            ans += Math.abs(a2.get(i) - b2.get(i));
        }
        return ans / 4;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2449 _tcSol = new Solution2449();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,12,6], target = [2,14,10]");
        try {
            int[] nums = new int[]{8, 12, 6};
            int[] target = new int[]{2, 14, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSimilar(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,5], target = [4,1,3]");
        try {
            int[] nums = new int[]{1, 2, 5};
            int[] target = new int[]{4, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSimilar(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1], target = [1,1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            int[] target = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeSimilar(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
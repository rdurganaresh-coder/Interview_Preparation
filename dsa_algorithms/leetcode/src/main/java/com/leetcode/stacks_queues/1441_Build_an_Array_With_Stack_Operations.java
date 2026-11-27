package com.leetcode.stacks_queues;

class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int cur = 1;
        for (int x : target) {
            while (cur < x) {
                ans.addAll(List.of("Push", "Pop"));
                ++cur;
            }
            ans.add("Push");
            ++cur;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1441 _tcSol = new Solution1441();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = [1,3], n = 3");
        try {
            int[] target = new int[]{1, 3};
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.buildArray(target, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Push\",\"Push\",\"Pop\",\"Push\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = [1,2,3], n = 3");
        try {
            int[] target = new int[]{1, 2, 3};
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.buildArray(target, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Push\",\"Push\",\"Push\"]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = [1,2], n = 4");
        try {
            int[] target = new int[]{1, 2};
            int n = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.buildArray(target, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Push\",\"Push\"]");
        System.out.println();
    }
}

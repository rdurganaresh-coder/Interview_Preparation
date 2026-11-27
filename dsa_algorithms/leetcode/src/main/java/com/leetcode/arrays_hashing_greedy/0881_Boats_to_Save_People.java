package com.leetcode.arrays_hashing_greedy;

class Solution0881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int i = 0, j = people.length - 1; i <= j; --j) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
            ++ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0881 _tcSol = new Solution0881();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "people = [1,2], limit = 3");
        try {
            int[] people = new int[]{1, 2};
            int limit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRescueBoats(people, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "people = [3,2,2,1], limit = 3");
        try {
            int[] people = new int[]{3, 2, 2, 1};
            int limit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRescueBoats(people, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "people = [3,5,3,4], limit = 5");
        try {
            int[] people = new int[]{3, 5, 3, 4};
            int limit = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.numRescueBoats(people, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
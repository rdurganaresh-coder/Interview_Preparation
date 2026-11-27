package com.leetcode.arrays_hashing_greedy;

class Solution1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        List<Integer> ans = new ArrayList<>();
        for (int c = 0; i >= 0 || j >= 0 || c != 0; --i, --j) {
            int a = i < 0 ? 0 : arr1[i];
            int b = j < 0 ? 0 : arr2[j];
            int x = a + b + c;
            c = 0;
            if (x >= 2) {
                x -= 2;
                c -= 1;
            } else if (x == -1) {
                x = 1;
                c += 1;
            }
            ans.add(x);
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1073 _tcSol = new Solution1073();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,1,1,1,1], arr2 = [1,0,1]");
        try {
            int[] arr1 = new int[]{1, 1, 1, 1, 1};
            int[] arr2 = new int[]{1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.addNegabinary(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,0,0,0]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [0], arr2 = [0]");
        try {
            int[] arr1 = new int[]{0};
            int[] arr2 = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.addNegabinary(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr1 = [0], arr2 = [1]");
        try {
            int[] arr1 = new int[]{0};
            int[] arr2 = new int[]{1};
            System.out.println("  Output  : " + _tcShow(_tcSol.addNegabinary(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();
    }
}
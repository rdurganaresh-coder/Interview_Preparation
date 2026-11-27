package com.leetcode.matrices_grids;

class Solution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.get(i).size(); ++j) {
                arr.add(new int[] {i + j, j, nums.get(i).get(j)});
            }
        }
        arr.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            ans[i] = arr.get(i)[2];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution1424 _tcSol = new Solution1424();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [[1,2,3],[4,5,6],[7,8,9]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(1, 2, 3), _tcL(4, 5, 6), _tcL(7, 8, 9));
            System.out.println("  Output  : " + _tcShow(_tcSol.findDiagonalOrder(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,4,2,7,5,3,8,6,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]");
        try {
            List<List<Integer>> nums = _tcL(_tcL(1, 2, 3, 4, 5), _tcL(6, 7), _tcL(8), _tcL(9, 10, 11), _tcL(12, 13, 14, 15, 16));
            System.out.println("  Output  : " + _tcShow(_tcSol.findDiagonalOrder(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]");
        System.out.println();
    }
}
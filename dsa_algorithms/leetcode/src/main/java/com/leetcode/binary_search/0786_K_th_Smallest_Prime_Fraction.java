package com.leetcode.binary_search;

class Solution0786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Queue<Frac> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            pq.offer(new Frac(1, arr[i], 0, i));
        }
        for (int i = 1; i < k; i++) {
            Frac f = pq.poll();
            if (f.i + 1 < f.j) {
                pq.offer(new Frac(arr[f.i + 1], arr[f.j], f.i + 1, f.j));
            }
        }
        Frac f = pq.peek();
        return new int[] {f.x, f.y};
    }

    static class Frac implements Comparable {
        int x, y, i, j;

        public Frac(int x, int y, int i, int j) {
            this.x = x;
            this.y = y;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            return x * ((Frac) o).y - ((Frac) o).x * y;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0786 _tcSol = new Solution0786();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,5], k = 3");
        try {
            int[] arr = new int[]{1, 2, 3, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestPrimeFraction(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,7], k = 1");
        try {
            int[] arr = new int[]{1, 7};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestPrimeFraction(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,7]");
        System.out.println();
    }
}
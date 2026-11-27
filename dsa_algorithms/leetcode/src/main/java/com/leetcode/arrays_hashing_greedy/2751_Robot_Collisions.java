package com.leetcode.arrays_hashing_greedy;

class Solution2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        Deque<Integer> stk = new ArrayDeque<>();

        for (int i : idx) {
            if (directions.charAt(i) == 'R') {
                stk.push(i);
                continue;
            }

            while (!stk.isEmpty() && healths[i] > 0) {
                int j = stk.peek();

                if (healths[j] > healths[i]) {
                    healths[j]--;
                    healths[i] = 0;
                } else if (healths[j] < healths[i]) {
                    healths[i]--;
                    healths[j] = 0;
                    stk.pop();
                } else {
                    healths[i] = healths[j] = 0;
                    stk.pop();
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) {
                ans.add(h);
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
        Solution2751 _tcSol = new Solution2751();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = \"RRRRR\"");
        try {
            int[] positions = new int[]{5, 4, 3, 2, 1};
            int[] healths = new int[]{2, 17, 9, 15, 10};
            String directions = "RRRRR";
            System.out.println("  Output  : " + _tcShow(_tcSol.survivedRobotsHealths(positions, healths, directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,17,9,15,10]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "positions = [3,5,2,6], healths = [10,10,15,12], directions = \"RLRL\"");
        try {
            int[] positions = new int[]{3, 5, 2, 6};
            int[] healths = new int[]{10, 10, 15, 12};
            String directions = "RLRL";
            System.out.println("  Output  : " + _tcShow(_tcSol.survivedRobotsHealths(positions, healths, directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[14]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "positions = [1,2,5,6], healths = [10,10,11,11], directions = \"RLRL\"");
        try {
            int[] positions = new int[]{1, 2, 5, 6};
            int[] healths = new int[]{10, 10, 11, 11};
            String directions = "RLRL";
            System.out.println("  Output  : " + _tcShow(_tcSol.survivedRobotsHealths(positions, healths, directions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}

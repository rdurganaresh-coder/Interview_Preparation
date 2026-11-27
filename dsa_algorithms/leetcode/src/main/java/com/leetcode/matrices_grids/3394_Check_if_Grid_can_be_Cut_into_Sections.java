package com.leetcode.matrices_grids;

class Solution3394 {
    // Helper class to mimic C++ pair<int, int>
    static class Pair {
        int value;
        int type;

        Pair(int value, int type) {
            this.value = value;
            this.type = type;
        }
    }

    private boolean countLineIntersections(List<Pair> coordinates) {
        int lines = 0;
        int overlap = 0;

        for (Pair coord : coordinates) {
            if (coord.type == 0) {
                overlap--;
            } else {
                overlap++;
            }

            if (overlap == 0) {
                lines++;
            }
        }

        return lines >= 3;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<Pair> yCoordinates = new ArrayList<>();
        List<Pair> xCoordinates = new ArrayList<>();

        for (int[] rectangle : rectangles) {
            // rectangle = [x1, y1, x2, y2]
            yCoordinates.add(new Pair(rectangle[1], 1)); // y1, start
            yCoordinates.add(new Pair(rectangle[3], 0)); // y2, end

            xCoordinates.add(new Pair(rectangle[0], 1)); // x1, start
            xCoordinates.add(new Pair(rectangle[2], 0)); // x2, end
        }

        Comparator<Pair> comparator = (a, b) -> {
            if (a.value != b.value) return Integer.compare(a.value, b.value);
            return Integer.compare(a.type, b.type); // End (0) before Start (1)
        };

        Collections.sort(yCoordinates, comparator);
        Collections.sort(xCoordinates, comparator);

        return countLineIntersections(yCoordinates) || countLineIntersections(xCoordinates);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3394 _tcSol = new Solution3394();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]");
        try {
            int n = 5;
            int[][] rectangles = new int[][]{new int[]{1, 0, 5, 2}, new int[]{0, 2, 2, 4}, new int[]{3, 2, 5, 3}, new int[]{0, 4, 4, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidCuts(n, rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, rectangles = [[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]");
        try {
            int n = 4;
            int[][] rectangles = new int[][]{new int[]{0, 0, 1, 1}, new int[]{2, 0, 3, 4}, new int[]{0, 2, 2, 3}, new int[]{3, 0, 4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidCuts(n, rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, rectangles = [[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]");
        try {
            int n = 4;
            int[][] rectangles = new int[][]{new int[]{0, 2, 2, 4}, new int[]{1, 0, 3, 2}, new int[]{2, 2, 3, 4}, new int[]{3, 0, 4, 2}, new int[]{3, 2, 4, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.checkValidCuts(n, rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
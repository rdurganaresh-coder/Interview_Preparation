package com.leetcode.arrays_hashing_greedy;

class Solution1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> g = new HashMap<>();
        for (var r : regions) {
            String x = r.get(0);
            for (String y : r.subList(1, r.size())) {
                g.put(y, x);
            }
        }
        Set<String> s = new HashSet<>();
        for (String x = region1; x != null; x = g.get(x)) {
            s.add(x);
        }
        String x = region2;
        while (g.get(x) != null && !s.contains(x)) {
            x = g.get(x);
        }
        return x;
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
        Solution1257 _tcSol = new Solution1257();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "regions = [[\"Earth\",\"North America\",\"South America\"], [\"North America\",\"United States\",\"Canada\"], [\"United States\",\"New York\",\"Boston\"], [\"Canada\",\"Ontario\",\"Quebec\"], [\"South America\",\"Brazil\"]], region1 = \"Quebec\", region2 = \"New York\"");
        try {
            List<List<String>> regions = _tcL(_tcL("Earth", "North America", "South America"), _tcL("North America", "United States", "Canada"), _tcL("United States", "New York", "Boston"), _tcL("Canada", "Ontario", "Quebec"), _tcL("South America", "Brazil"));
            String region1 = "Quebec";
            String region2 = "New York";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestRegion(regions, region1, region2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"North America\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "regions = [[\"Earth\", \"North America\", \"South America\"],[\"North America\", \"United States\", \"Canada\"],[\"United States\", \"New York\", \"Boston\"],[\"Canada\", \"Ontario\", \"Quebec\"],[\"South America\", \"Brazil\"]], region1 = \"Canada\", region2 = \"South America\"");
        try {
            List<List<String>> regions = _tcL(_tcL("Earth", "North America", "South America"), _tcL("North America", "United States", "Canada"), _tcL("United States", "New York", "Boston"), _tcL("Canada", "Ontario", "Quebec"), _tcL("South America", "Brazil"));
            String region1 = "Canada";
            String region2 = "South America";
            System.out.println("  Output  : " + _tcShow(_tcSol.findSmallestRegion(regions, region1, region2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Earth\"");
        System.out.println();
    }
}

package com.leetcode.sql_database;

class Solution1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Node1152>> d = new HashMap<>();
        int n = username.length;
        for (int i = 0; i < n; ++i) {
            String user = username[i];
            int ts = timestamp[i];
            String site = website[i];
            d.computeIfAbsent(user, k -> new ArrayList<>()).add(new Node1152(user, ts, site));
        }
        Map<String, Integer> cnt = new HashMap<>();
        for (var sites : d.values()) {
            int m = sites.size();
            Set<String> s = new HashSet<>();
            if (m > 2) {
                Collections.sort(sites, (a, b) -> a.ts - b.ts);
                for (int i = 0; i < m - 2; ++i) {
                    for (int j = i + 1; j < m - 1; ++j) {
                        for (int k = j + 1; k < m; ++k) {
                            s.add(sites.get(i).site + "," + sites.get(j).site + ","
                                + sites.get(k).site);
                        }
                    }
                }
            }
            for (String t : s) {
                cnt.put(t, cnt.getOrDefault(t, 0) + 1);
            }
        }
        int mx = 0;
        String t = "";
        for (var e : cnt.entrySet()) {
            if (mx < e.getValue() || (mx == e.getValue() && e.getKey().compareTo(t) < 0)) {
                mx = e.getValue();
                t = e.getKey();
            }
        }
        return Arrays.asList(t.split(","));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1152 _tcSol = new Solution1152();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "username = [\"joe\",\"joe\",\"joe\",\"james\",\"james\",\"james\",\"james\",\"mary\",\"mary\",\"mary\"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = [\"home\",\"about\",\"career\",\"home\",\"cart\",\"maps\",\"home\",\"home\",\"about\",\"career\"]");
        try {
            String[] username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
            int[] timestamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            String[] website = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostVisitedPattern(username, timestamp, website)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"home\",\"about\",\"career\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "username = [\"ua\",\"ua\",\"ua\",\"ub\",\"ub\",\"ub\"], timestamp = [1,2,3,4,5,6], website = [\"a\",\"b\",\"a\",\"a\",\"b\",\"c\"]");
        try {
            String[] username = new String[]{"ua", "ua", "ua", "ub", "ub", "ub"};
            int[] timestamp = new int[]{1, 2, 3, 4, 5, 6};
            String[] website = new String[]{"a", "b", "a", "a", "b", "c"};
            System.out.println("  Output  : " + _tcShow(_tcSol.mostVisitedPattern(username, timestamp, website)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"a\"]");
        System.out.println();
    }
}

class Node1152 {
    String user;
    int ts;
    String site;

    Node1152(String user, int ts, String site) {
        this.user = user;
        this.ts = ts;
        this.site = site;
    }
}
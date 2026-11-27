package com.leetcode.arrays_hashing_greedy;

class Solution0332 {
    private Map<String, List<String>> g = new HashMap<>();
    private List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> b.get(1).compareTo(a.get(1)));
        for (List<String> ticket : tickets) {
            g.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String f) {
        while (g.containsKey(f) && !g.get(f).isEmpty()) {
            String t = g.get(f).remove(g.get(f).size() - 1);
            dfs(t);
        }
        ans.add(f);
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
        Solution0332 _tcSol = new Solution0332();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tickets = [[\"MUC\",\"LHR\"],[\"JFK\",\"MUC\"],[\"SFO\",\"SJC\"],[\"LHR\",\"SFO\"]]");
        try {
            List<List<String>> tickets = _tcL(_tcL("MUC", "LHR"), _tcL("JFK", "MUC"), _tcL("SFO", "SJC"), _tcL("LHR", "SFO"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findItinerary(tickets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"JFK\",\"MUC\",\"LHR\",\"SFO\",\"SJC\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tickets = [[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]");
        try {
            List<List<String>> tickets = _tcL(_tcL("JFK", "SFO"), _tcL("JFK", "ATL"), _tcL("SFO", "ATL"), _tcL("ATL", "JFK"), _tcL("ATL", "SFO"));
            System.out.println("  Output  : " + _tcShow(_tcSol.findItinerary(tickets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"JFK\",\"ATL\",\"JFK\",\"SFO\",\"ATL\",\"SFO\"]");
        System.out.println();
    }
}
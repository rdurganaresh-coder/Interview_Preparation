package com.leetcode.arrays_hashing_greedy;

class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            String name = keyName[i];
            String time = keyTime[i];
            int t
                = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            d.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }
        List<String> ans = new ArrayList<>();
        for (var e : d.entrySet()) {
            var ts = e.getValue();
            int n = ts.size();
            if (n > 2) {
                Collections.sort(ts);
                for (int i = 0; i < n - 2; ++i) {
                    if (ts.get(i + 2) - ts.get(i) <= 60) {
                        ans.add(e.getKey());
                        break;
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1604 _tcSol = new Solution1604();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "keyName = [\"daniel\",\"daniel\",\"daniel\",\"luis\",\"luis\",\"luis\",\"luis\"], keyTime = [\"10:00\",\"10:40\",\"11:00\",\"09:00\",\"11:00\",\"13:00\",\"15:00\"]");
        try {
            String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
            String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
            System.out.println("  Output  : " + _tcShow(_tcSol.alertNames(keyName, keyTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"daniel\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "keyName = [\"alice\",\"alice\",\"alice\",\"bob\",\"bob\",\"bob\",\"bob\"], keyTime = [\"12:01\",\"12:00\",\"18:00\",\"21:00\",\"21:20\",\"21:30\",\"23:00\"]");
        try {
            String[] keyName = new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"};
            String[] keyTime = new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"};
            System.out.println("  Output  : " + _tcShow(_tcSol.alertNames(keyName, keyTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"bob\"]");
        System.out.println();
    }
}
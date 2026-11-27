package com.leetcode.heaps_priority_queues;

class Solution2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
        String[] report, int[] student_id, int k) {
        Set<String> ps = new HashSet<>();
        Set<String> ns = new HashSet<>();
        for (var s : positive_feedback) {
            ps.add(s);
        }
        for (var s : negative_feedback) {
            ns.add(s);
        }
        int n = report.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            int sid = student_id[i];
            int t = 0;
            for (var s : report[i].split(" ")) {
                if (ps.contains(s)) {
                    t += 3;
                } else if (ns.contains(s)) {
                    t -= 1;
                }
            }
            arr[i] = new int[] {t, sid};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(arr[i][1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2512 _tcSol = new Solution2512();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "positive_feedback = [\"smart\",\"brilliant\",\"studious\"], negative_feedback = [\"not\"], report = [\"this student is studious\",\"the student is smart\"], student_id = [1,2], k = 2");
        try {
            String[] positive_feedback = new String[]{"smart", "brilliant", "studious"};
            String[] negative_feedback = new String[]{"not"};
            String[] report = new String[]{"this student is studious", "the student is smart"};
            int[] student_id = new int[]{1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.topStudents(positive_feedback, negative_feedback, report, student_id, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "positive_feedback = [\"smart\",\"brilliant\",\"studious\"], negative_feedback = [\"not\"], report = [\"this student is not studious\",\"the student is smart\"], student_id = [1,2], k = 2");
        try {
            String[] positive_feedback = new String[]{"smart", "brilliant", "studious"};
            String[] negative_feedback = new String[]{"not"};
            String[] report = new String[]{"this student is not studious", "the student is smart"};
            int[] student_id = new int[]{1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.topStudents(positive_feedback, negative_feedback, report, student_id, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,1]");
        System.out.println();
    }
}
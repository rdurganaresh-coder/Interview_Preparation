package com.leetcode.design_data_structures;

class LogSystem0635 {
    private List<Log0635> logs = new ArrayList<>();
    private Map<String, Integer> d = new HashMap<>();

    public LogSystem0635() {
        d.put("Year", 4);
        d.put("Month", 7);
        d.put("Day", 10);
        d.put("Hour", 13);
        d.put("Minute", 16);
        d.put("Second", 19);
    }

    public void put(int id, String timestamp) {
        logs.add(new Log0635(id, timestamp));
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> ans = new ArrayList<>();
        int i = d.get(granularity);
        String s = start.substring(0, i);
        String e = end.substring(0, i);
        for (var log : logs) {
            String t = log.ts.substring(0, i);
            if (s.compareTo(t) <= 0 && t.compareTo(e) <= 0) {
                ans.add(log.id);
            }
        }
        return ans;
    }
}

class Log0635 {
    int id;
    String ts;

    Log0635(int id, String ts) {
        this.id = id;
        this.ts = ts;
    }
}

/**
 * Your LogSystem0635 object will be instantiated and called as such:
 * LogSystem0635 obj = new LogSystem0635();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
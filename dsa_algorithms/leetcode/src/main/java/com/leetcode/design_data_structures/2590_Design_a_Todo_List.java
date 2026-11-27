package com.leetcode.design_data_structures;

class Task2590 {
    int taskId;
    String taskName;
    int dueDate;
    Set<String> tags;
    boolean finish;

    public Task2590(int taskId, String taskName, int dueDate, Set<String> tags) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.tags = tags;
    }
}

class TodoList2590 {
    private int i = 1;
    private Map<Integer, TreeSet<Task2590>> tasks = new HashMap<>();

    public TodoList2590() {
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        Task2590 task = new Task2590(i++, taskDescription, dueDate, new HashSet<>(tags));
        tasks.computeIfAbsent(userId, k -> new TreeSet<>(Comparator.comparingInt(a -> a.dueDate)))
            .add(task);
        return task.taskId;
    }

    public List<String> getAllTasks(int userId) {
        List<String> ans = new ArrayList<>();
        if (tasks.containsKey(userId)) {
            for (Task2590 task : tasks.get(userId)) {
                if (!task.finish) {
                    ans.add(task.taskName);
                }
            }
        }
        return ans;
    }

    public List<String> getTasksForTag(int userId, String tag) {
        List<String> ans = new ArrayList<>();
        if (tasks.containsKey(userId)) {
            for (Task2590 task : tasks.get(userId)) {
                if (task.tags.contains(tag) && !task.finish) {
                    ans.add(task.taskName);
                }
            }
        }
        return ans;
    }

    public void completeTask(int userId, int taskId) {
        if (tasks.containsKey(userId)) {
            for (Task2590 task : tasks.get(userId)) {
                if (task.taskId == taskId) {
                    task.finish = true;
                    break;
                }
            }
        }
    }
}

/**
 * Your TodoList2590 object will be instantiated and called as such:
 * TodoList2590 obj = new TodoList2590();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */
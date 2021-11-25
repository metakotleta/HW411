import java.util.*;

public class Planner {
    List<String> taskList = new ArrayList<>(5);
    List<Integer> tasksToRemove = new ArrayList<>(5);

    public void addTask(String task) {
        taskList.add(task);
    }

    public void getTask() {
        for (int i = 0; i < taskList.size(); i++ ) {
            System.out.println(i + 1 + ". " + taskList.get(i));
        }
    }

    protected void addTasksToRemove(Integer taskNum) {
        if (taskNum.compareTo(taskList.size()) < 0) {
            tasksToRemove.add(taskNum);
        }
    }

    protected void removeTasks(List<Integer> tasksToRemove) {
        Collections.sort(tasksToRemove, Collections.reverseOrder()); // честно загуглил способ сортировки, без понятия, что за компаратор
        for (int i = 0; i < tasksToRemove.size(); i++) {
            taskList.remove(tasksToRemove.get(i).intValue());
        }
        tasksToRemove.clear(); /* сначала пытался удалять в цикле каждый элемент с индексом i, не понимал, а чё не все таски чистит.
                                потом осознал, что tasksToRemove.size() постоянно уменьшается */
    }
}

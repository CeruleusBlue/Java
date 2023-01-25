import java.util.Comparator;

public class SortTaskByDate implements Comparator<Task>{
    public int compare(Task a, Task b)
    {
        return a.taskID - b.taskID;
    }
}

import java.util.Comparator;

public class SortTaskByID implements Comparator<Task>{
    
    public int compare(Task a, Task b)
    {
        long n1 = Long.parseLong(a.date.substring(6,10)+a.date.substring(3,5)+a.date.substring(0,2) +a.time.substring(0,2)+a.time.substring(3,5));
        long n2 = Long.parseLong(b.date.substring(6,10)+b.date.substring(3,5)+b.date.substring(0,2) +b.time.substring(0,2)+b.time.substring(3,5));
        return (int)(n1-n2);
    }
}

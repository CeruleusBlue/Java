public class Task {
    String title, date, time, location, desc, note;
    int taskID;
    static int countID=0;
    Task(String title, String date, String time, String location)
    {
        taskID=++countID;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location; 
        desc = "#no_value";
        note = "#no_value";
    }

    Task(String title, String date, String time, String location, String desc, String note)
    {
        taskID=++countID;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;    
        this.desc = desc;
        this.note = note;
    }

    Task()
    {
        title = "";
        date="";
        time="";
        location="";
        desc="";
        note="";
        taskID=++countID;
    }

    int getTaskID()
    {
        return taskID;    
    }

    String getTitle()
    {
        return title;
    }

    String getDate()
    {
        return date;
    }

    String getTime()
    {
        return time;
    }

    String getLocation()
    {
        return location;
    }

    String getDescription()
    {
        return desc;
    }

    String getNote()
    {
        return note;
    }
}

/*------------------------------------------------------ 
Name: Subhranil Choudhury	
Student number:  6848138
Email address:  sc177@uowmail.edu.au
Subject Code: CSIT111
Assignment number: 4 
-------------------------------------------------------*/ 
import java.util.*;
class ToDoList
{
    ArrayList<Task> task = new ArrayList<Task>();
    void addTask(String title, String date, String time, String location)
    {
        task.add(new Task(title,date,time,location));
    }

    void addTask(String title, String date, String time, String location, String desc, String note)
    {
        task.add(new Task(title,date,time,location, desc, note));
    }

    void deleteTask(int id)
    {
        task.remove(id-1);
    }

    void deleteAllTask()
    {
        task.clear();
    }

    void displayTask()
    { 
        Collections.sort(task, new SortTaskByID());
        System.out.print( "\n-------------------------\n");
        for(Task i: task)
        {
            System.out.printf("%d: %s, %s, %s, %s",i.getTaskID(),i.getTitle(),i.getDate(),i.getTime(),i.getLocation());
            if((i.getDescription()).equals("#no_value")==false)
                System.out.print(", "+i.getDescription());
            if((i.getNote()).equals("#no_value")==false)
                System.out.print(", "+i.getNote());
            System.out.println();
        }
        if(task.size()==0)
            System.out.println("List is empty");
        System.out.print( "\n-------------------------\n");
    }

    void sortTask()
    {
        Collections.sort(task, new SortTaskByDate());
        System.out.print( "\n-------------------------\n");
        for(Task i: task)
        {
            System.out.printf("%s, %s, %s, %s",i.getTitle(),i.getDate(),i.getTime(),i.getLocation());
            if((i.getDescription()).equals("#no_value")==false)
                System.out.print(", "+i.getDescription());
            if((i.getNote()).equals("#no_value")==false)
                System.out.print(", "+i.getNote());
            System.out.println();
        }
        if(task.size()==0)
            System.out.println("List is empty");
        System.out.print( "\n-------------------------\n");
    }

    void searchTask(String date)
    {
        int count =0;//To count number of tasks on the date
        System.out.print( "\n-------------------------\n");
        for(Task i: task)
        {
            if(date.equals(i.date))
            {
                count++;
                System.out.printf("%s, %s, %s, %s",i.getTitle(),i.getDate(),i.getTime(),i.getLocation());
                if((i.getDescription()).equals("#no_value")==false)
                    System.out.print(", "+i.getDescription());
                if((i.getNote()).equals("#no_value")==false)
                    System.out.print(", "+i.getNote());
				System.out.println();
            }
        }
        if(count==0)
            System.out.printf("No Tasks scheduled for %s",date);
        System.out.print( "\n-------------------------\n");
    }

    void displayMainMenu()
    {
        String arr[] = {"Add a Task","Delete a Task", "Delete all Tasks", "List all Tasks", "Exit the Program","Sort Task by Date", "Search Task using Date"};
        System.out.println( "#########################\n"); 
        for(int i =0;i<arr.length;i++)
        {
            System.out.printf("%d: %s\n",i+1,arr[i]);
        }
        System.out.println( "\n#########################");

    }

    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        ToDoList list = new ToDoList();
        int n = 0;// variable for switch case
        while (n!=-1)
        {
            if(n!=5)
            {
                list.displayMainMenu();
                System.out.print("\nEnter selection: ");            
                n = inp.nextInt();
                System.out.println("\n");
            }
            switch (n)
            {
                case 1:
                System.out.print( "\n*************************\n");
                System.out.print(   "*******ADD A TASK********");
                System.out.print( "\n*************************\n");
                do{
                     System.out.print("\n\nEnter Title, Date(dd/mm/yy), Time(hh:mm), Location: "+inp.nextLine());
                        String str = inp.nextLine();
                        int a = str.indexOf(',');
                        int b = str.indexOf(',', a+1);
                        int c = str.indexOf(',', b+1);
                        String title = str.substring(0,a);
                        String date = str.substring(a+1, b);
                        String time = str. substring(b+1, c);
                        String location = str.substring(c+1,str.length());	
                    String desc ="#no_value"; 
                    String note ="#no_value";
                    System.out.println("Do you wish to enter Description?");
                    System.out.print("Enter Y for yes: ");
                    if((inp.next()).equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter Description: "+inp.nextLine());
                        desc = inp.nextLine();
                    }
                    System.out.println("Do you wish to enter Note?");
                    System.out.print("Enter Y for yes: ");
                    if((inp.next()).equalsIgnoreCase("Y"))
                    {
                        System.out.println("Enter Note"+inp.nextLine());
                        note = inp.nextLine();
                    }                                       
                    list.addTask(title,date,time,location,desc,note);
                    System.out.println("Do you wish to add more Tasks?");
                    System.out.print("Enter Y for yes: ");
                }while((inp.next()).equalsIgnoreCase("Y"));
                System.out.println("\n");
                break;
                case 2: 
                System.out.print( "\n*************************\n");
                System.out.print(   "******DELETE A TASK******");
                System.out.print( "\n*************************\n");
                list.displayTask();
                do{
                    System.out.print("\nEnter Task ID for deletion: ");
                    list.deleteTask(inp.nextInt());
                    System.out.println("Do you wish to delete more Tasks?");
                    System.out.print("Enter Y for yes: ");
                }while((inp.next()).equalsIgnoreCase("Y"));
                System.out.println("\n");
                break;
                case 3:
                System.out.print( "\n*************************\n");
                System.out.print(   "*****DELETE ALL TASKS*****");
                System.out.print( "\n*************************\n");
                list.displayTask();
                System.out.println("Do you wish to delete all Tasks?");
                System.out.print("Enter Y to confirm: ");
                if((inp.next()).equalsIgnoreCase("Y"))
                    list.deleteAllTask();
                    System.out.println("\n");
                break;
                case 4:
                System.out.print( "\n*************************\n");
                System.out.print(   "*****LIST ALL TASKS******");
                System.out.print( "\n*************************\n");
                list.displayTask();
                System.out.println("\n");
                break;
                case 5:
                System.out.println("Goodbye, see you later!");
                n=-1;
                break;
                case 6:
                System.out.print( "\n*************************\n");
                System.out.print(   "****SORT TASK BY DATE****");
                System.out.print( "\n*************************\n");
                list.sortTask();
                System.out.println("\n");
                break;
                case 7:
                System.out.print( "\n**************************\n");
                System.out.print(   "**SEARCH TASK USING DATE**");
                System.out.print( "\n**************************\n");
                System.out.print("Enter date(dd/mm/yy): ");
                list.searchTask(inp.next());
                System.out.println("\n");
                break;
                default:
                System.out.println("Invalid Choice");
                System.out.println("\n");
            }
        }
    }
}
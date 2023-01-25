import java.util.ArrayList;

class CustomerOrder {
    private ArrayList<OrderDish> dishes = new ArrayList<OrderDish>();
    String customerName;
    int tableID; 
    double totalPrice;
    CustomerOrder(){
        customerName="";
        tableID=-1;
    }
    CustomerOrder(String customerName, int tableID){
        this.customerName = customerName;
        this.tableID = tableID;
    }
    String getCustomerName() {
        return customerName;
    }
    Integer getTableID() {
        return tableID;
    }
    void addDish(OrderDish dish) {
        dishes.add(dish);
        totalPrice+=dish.getPrice();
    }
    void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    void setTableID(int tableID) {
        this.tableID = tableID;
    }
    public String toString() {
        String str ="Customer Name: "+customerName;
        str+="\nTable ID: "+tableID+"\n";
        for(OrderDish i: dishes) {
            str+=i.toString();
            if(i.getVeg())
                str+=" Vegetarian";
            if(i.getGlutenFree())
                str+=" Gluten Free";
            str+="\n";
        }
        str+="\n-------------------------------\nTotal Price: "+getTotalPrice();
        return str;
    }
    String getDishes() {
        String str="";
        for(OrderDish i: dishes) {
            str+=i.toString();
            if(i.getVeg())
                str+=" Vegetarian";
            if(i.getGlutenFree())
                str+=" Gluten Free";
            str+="\n";
        }
        str+="\n-------------------------------\nTotal Price: "+getTotalPrice();
        return str;
    }
    double getTotalPrice() {
        return totalPrice;
    }
}
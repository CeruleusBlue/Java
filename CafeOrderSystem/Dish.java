import java.io.Serializable;
import java.util.ArrayList;

abstract class Dish implements Serializable {
    String dishName, desc;
    double price;
    boolean isVeg, isGlutenFree;
    Dish(){
        dishName="";
        desc="";
        price=0.0;
        isVeg = false;
        isGlutenFree = false;
    }
    Dish(String dishName,String desc, double price, boolean isVeg, boolean isGlutenFree){
        this.dishName=dishName;
        this.desc=desc;
        this.price = price;
        this.isVeg = isVeg;
        this.isGlutenFree = isGlutenFree;
    }
    public String toString() {
        String str= String.format("%s $%.2f",dishName, price);
        return str;
    }
    void setDishName(String dishName) {
        this.dishName=dishName;
    }
    void setDescription(String desc) {
        this.desc = desc;
    }
    void setPrice(double price) {
        this.price=price;
    }
    void setVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }
    void setGlutenFree(Boolean isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }
    abstract String getDishName();
    String getDescription() {
        String str="";
        if(isVeg)
            str+="Vegetarian\n";
        if(isGlutenFree)
            str+="GlutenFree\n";
        str+=desc;
        return str;
    }
    double getPrice() {
        return price;
    }
    Boolean getVeg() {
    return isVeg;
    }
    boolean getGlutenFree() {
        return isGlutenFree;
    }
}

class NMDish extends Dish{
	NMDish(){
		super();
	}
	NMDish(String dishName,String desc, double price, boolean isVeg, boolean isGlutenFree){
		super(dishName+"(NM)",desc,price,isVeg,isGlutenFree);
	}
	String getDishName() {
		return dishName;
	}
}

class MDish extends Dish {
	MDish(){
		super();
	}
	MDish(String dishName,String desc, double price, boolean isVeg, boolean isGlutenFree){
		super(dishName,desc,price,isVeg,isGlutenFree);
	}
	String getDishName() {
		return dishName;
	}
}



class OrderDish extends Dish {
	int quantity;
	OrderDish(){
		super();
		quantity = 0;
	}
	OrderDish(String dishName, String desc, double price, boolean isVeg, boolean isGlutenFree, int quantity ){
		super(dishName, desc, price, isGlutenFree, isGlutenFree);
		this.quantity = quantity;
		price*=quantity;
	}
	public String toString() {
		String str=String.format("%s\t\t\tQuantity:%d\t$%.2f", dishName,quantity,price);
		return str;
	}
	void setDish(Dish dish) {
		dishName = dish.getDishName();
		desc = dish.getDescription();
		price = dish.getPrice();
		isVeg = dish.getVeg();
		isGlutenFree = dish.getGlutenFree();
	}
	void setQuantity(int quantity) {
		this.quantity = quantity;
		price*=quantity;
	}
	int getQuantity() {
		return quantity;
	}
	String getDishName() {
		return dishName;
	}
}

class DishCategory implements Serializable {
	private String name;
	ArrayList<Dish> dishes = new ArrayList<Dish>();
	DishCategory(){
		name="";
	}
	DishCategory(String name){
		this.name = name;
	}
	public String toString() {
		String str = String.format("%30s",name);
		for(Dish i: dishes)
			str+="\n"+i.toString();
		return str;
	}
	String getCategoryName() {
		return name;
	}
	void addDish(Dish dish) {
		dishes.add(dish);
	}
	void removeDish(String dishName) {
		for(Dish i :dishes) {
			if(i.getDishName().equalsIgnoreCase(dishName)) {
				dishes.remove(i);
				break;		}
		}
	}
	ArrayList<Dish> getDishes(){
		return dishes;
	}
}



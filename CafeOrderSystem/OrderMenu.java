import java.util.ArrayList;
import java.io.*;

public class OrderMenu implements Serializable {
    ArrayList<DishCategory> categories = new ArrayList<DishCategory>();
    OrderMenu(){};
    OrderMenu(String[] categoryNames){
        for(String i: categoryNames)
            categories.add(new DishCategory(i));
    }
    public String toString() {
        String str =String.format("%30s", "Order Menu");
        for(DishCategory i: categories)
            str+="\n\n"+i.toString();
        return str;
    }
    void addCategory(DishCategory dishCategory) {
        categories.add(dishCategory);
    }
    void removeCategory(String categoryName) {
        for(DishCategory i : categories)
            if(i.getCategoryName().equalsIgnoreCase(categoryName)) {
                categories.remove(i);
                break;
            }
    }
    ArrayList<DishCategory> getCategories(){
        return categories;
    }
    public static void main(String[] args) throws IOException {
        String categoryNames[] = {"Pizzas","Burgers","Add Sides"};
        OrderMenu menu = new OrderMenu(categoryNames);
        menu.getCategories().get(0).addDish(new MDish("Tropicana Pizza","Ham and pineapple served on a tomato base with mozarella cheese.",10,false,false));
        menu.getCategories().get(0).addDish(new NMDish("Tropicana Pizza","Ham and pineapple served on a tomato base with mozarella cheese.",13,false,false));
        menu.getCategories().get(0).addDish(new MDish("BBQ Meat Lovers Pizza","Beef, bacon, ham, pepperoni, spanish onion, cherry tomatoes and mozarella cheese.",16,false,false));
        menu.getCategories().get(0).addDish(new NMDish("BBQ Meat Lovers Pizza","Beef, bacon, ham, pepperoni, spanish onion, cherry tomatoes and mozarella cheese.",19,false,false));
        menu.getCategories().get(0).addDish(new MDish("Pepperoni Pizza","Tomato base, chilli flakes, pepperoni, spinach and mozarella cheese.",9,false,false));
        menu.getCategories().get(0).addDish(new NMDish("Pepperoni Pizza","Tomato base, chilli flakes, pepperoni, spinach and mozarella cheese.",12,false,false));
        menu.getCategories().get(0).addDish(new MDish("Chicken, Mushroom & Brie Pizza","Tomato base, chicken, mushroom, spinach, brie and mozarella cheese.",14,false,false));
        menu.getCategories().get(0).addDish(new NMDish("Chicken, Mushroom & Brie Pizza","Tomato base, chicken, mushroom, spinach, brie and mozarella cheese.",17,false,false));
        menu.getCategories().get(0).addDish(new MDish("Garlic Pizza","Confit garlic, mozzarella cheese, rosemary topped with smoked salt.",8,true,false));
        menu.getCategories().get(0).addDish(new NMDish("Garlic Pizza","Confit garlic, mozzarella cheese, rosemary topped with smoked salt.",11,true,false));
        menu.getCategories().get(0).addDish(new MDish("Slow-Roasted Lamb Pizza","Tomato Base with slow-roasted lamb, rocket, sumac, tzatziki and mozarella cheese.",12,false,false));
        menu.getCategories().get(0).addDish(new NMDish("Slow-Roasted Lamb Pizza","Tomato Base with slow-roasted lamb, rocket, sumac, tzatziki and mozarella cheese.",15,false,false));
        menu.getCategories().get(0).addDish(new MDish("Green Pizza","Basil pesto base topped with rocket, broccoli, green olives and bocconcini.",12,true,false));
        menu.getCategories().get(0).addDish(new NMDish("Green Pizza","Basil pesto base topped with rocket, broccoli, green olives and bocconcini.",15,true,false));
        menu.getCategories().get(1).addDish(new MDish("Wagyu Burger","Wagyu beef, bacon, tomato, mesculin, beetroot, and aioli on a lightly toasted brioche bun, served with chips.",16.5,false,false));
        menu.getCategories().get(1).addDish(new NMDish("Wagyu Burger","Wagyu beef, bacon, tomato, mesculin, beetroot, and aioli on a lightly toasted brioche bun, served with chips.",19.5,false,false));
        menu.getCategories().get(1).addDish(new MDish("Cheeseburger","Milk bun topped with beef patty, cheese, tomato, and mustard served with chips.",10,false,false));
        menu.getCategories().get(1).addDish(new NMDish("Cheeseburger","Milk bun topped with beef patty, cheese, tomato, and mustard served with chips.",13,false,false));
        menu.getCategories().get(1).addDish(new MDish("Halloumi Burger","Milk bun topped with rocket, halloumi, egg and tomato relish, served with chips.",10,true,false));
        menu.getCategories().get(1).addDish(new NMDish("Halloumi Burger","Milk bun topped with rocket, halloumi, egg and tomato relish, served with chips.",13,true,false));
        menu.getCategories().get(1).addDish(new MDish("Steak Sandwich","120g rib fillet steak with caramelised onion, lettuce, cheese, tomato, beetroot, and barbeque sauce on a toasted sandwich clabatta, served with chips.",18.5,false,false));
        menu.getCategories().get(1).addDish(new NMDish("Steak Sandwich","120g rib fillet steak with caramelised onion, lettuce, cheese, tomato, beetroot, and barbeque sauce on a toasted sandwich clabatta, served with chips.",21.5,false,false));
        menu.getCategories().get(1).addDish(new MDish("Chicken Wrap","Southern chicken tenders wrapped in soft tortilla with sweet chilli aioli, lettuce, cheese, tomato, and carrot, served with chips.",9.9,false,false));
        menu.getCategories().get(1).addDish(new NMDish("Chicken Wrap","Southern chicken tenders wrapped in soft tortilla with sweet chilli aioli, lettuce, cheese, tomato, and carrot, served with chips.",12.9,false,false));
        menu.getCategories().get(2).addDish(new MDish("Sweet Potato Fries (Bowl)","Served with tomato relish.",6.5,true,false));
        menu.getCategories().get(2).addDish(new NMDish("Sweet Potato Fries (Bowl)","Served with tomato relish.",9.5,true,false));
        menu.getCategories().get(2).addDish(new MDish("Chips (Bowl)","Served with aioli, tomato sauce, and barbeque sauce.",5,true,false));
        menu.getCategories().get(2).addDish(new NMDish("Chips (Bowl)","Served with aioli, tomato sauce, and barbeque sauce.",8,true,false));
        menu.getCategories().get(2).addDish(new MDish("Wedges (Bowl)","Served with sweet chilli sauce and sour cream.",6.5,true,false));
        menu.getCategories().get(2).addDish(new NMDish("Wedges (Bowl)","Served with sweet chilli sauce and sour cream.",9.5,true,false));
        menu.getCategories().get(2).addDish(new MDish("Side Salad","",5,true,false));
        menu.getCategories().get(2).addDish(new NMDish("Side Salad","",8,true,false));
        FileOutputStream fileStream = new FileOutputStream("Menu.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileStream);
        out.writeObject(menu);
        out.close();
        fileStream.close();
        System.out.println(menu.toString());
    }
}

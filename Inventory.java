import java.util.ArrayList;

public class Inventory implements Cloneable {
    
/*     public Inventory(){

    } */

    public class Item {
        protected Weapon weapon;
        protected int price;

        Item(Weapon weapon, int price) {
            this.weapon = weapon;
            this.price = price;
        }

        public String toString() {
            return ("Weapon Name: " + this.weapon + "; Price: " + this.price);
        }
    }

    ArrayList<Item> inventoryItems;/* = new ArrayList<Item>(); */

    public ArrayList<String> listAllItems() {

        ArrayList<String> descriptions = new ArrayList<String>(inventoryItems.size());

        for (Item i : inventoryItems) {
            // descriptions.add("Weapon: " + toString(inventoryItems.get(i).weapon) + ";
            // Price: " + toString(inventoryItems.get(i).price));
            // Item item = inventoryItems[i];
            String m = i.toString();
            descriptions.add(m);
            System.out.println(m);
        }
        System.out.println();
        return descriptions;
    }

    public Inventory(int capacity) {
        inventoryItems = new ArrayList<Item>(capacity);
    }

    public void addItem(Weapon weapon, int price) {
        inventoryItems.add(new Item(weapon, price));
    }

    public Weapon removeItem(int index) {
        inventoryItems.remove(index);
        return inventoryItems.get(index).weapon;
    }

    public int getItemPrice(int index) {
        int price = inventoryItems.get(index).price;
        System.out.println("The price is: " + price);
        return price;
    }

    public Item getWeaponID(int ID) {
        return inventoryItems.get(ID);
    }



    public Inventory clone() {
        try {
            Inventory objectname = (Inventory) super.clone();
            return objectname;
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

} 
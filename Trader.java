public interface Trader {
    public int buy(Weapon item);
    public Weapon sell(int itemNumber);
    public int getPrice(int itemNumber);
    public void listAllItems();
    //public Inventory inventory = new Inventory(4);
}
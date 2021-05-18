public class WeaponTrader implements Trader{
    Inventory inventory = new Inventory(4);

    public WeaponTrader(Inventory inventory) {
        // inventory = new Inventory(4);

        Weapon w1 = new Weapon("pan", 5, 10);
        inventory.addItem(w1, 30);

        Weapon w2 = new Weapon("Mother's flip flops", 10, 15);
        inventory.addItem(w2, 60);

        Weapon w3 = new Weapon("Launchable maniac", 8, 18);
        inventory.addItem(w3, 60);

        Weapon w4 = new Weapon("gun", 7, 20);
        inventory.addItem(w4, 40);
        
    }

    @Override
    public int buy(Weapon item) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Weapon sell(int itemNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPrice(int itemNumber) {
        // TODO Auto-generated method stub
        return 0;
    }

	@Override
	public void listAllItems() {
		inventory.listAllItems();
		
	}
}
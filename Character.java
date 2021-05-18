public abstract class Character {
    protected String name;
    protected int health;
    protected int accuracy;
    protected Weapon weapon;

    public Character(String name, int health, int accuracy, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.accuracy = accuracy;
        this.weapon = weapon;
    }

    public Character(Character character){
        this.name = character.name;
        this.health = character.health;
        this.accuracy = character.accuracy;
        this.weapon = new Weapon(character.weapon);
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public abstract void attack(Character player);

    public abstract void takeDamage(int damage);

    public abstract void displayHealth();

}

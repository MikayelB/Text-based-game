public class Weapon {
    private String name;
    private Range damageRange;

    public Weapon(String name, int low, int high) {
        this.name = name;
        this.damageRange = new Range(low, high);
    }

    public Weapon(Weapon weapon) {
        this.name = weapon.name;
        this.damageRange = new Range(weapon.damageRange.getLow(),weapon.damageRange.getHigh());
    }

    public String getName() {
        return name;
    }

    public Range getDamageRange() {
        return damageRange;
    }

}

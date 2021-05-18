public class Enemy extends Character {

    private int experienceReward;
    private Shield shield;

    public Enemy(String name, int health, int accuracy, int experienceReward, Weapon weapon, Shield shield) {
        super(name, health, accuracy, weapon);
        this.experienceReward = experienceReward;
        this.shield = shield;
    }

    public Enemy(Enemy enemy) {
        super(enemy);
        this.experienceReward= enemy.experienceReward;
        this.shield = new Shield(enemy.shield);
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public void attack(Character player) {
        System.out.println("A " + this.name + " attacks you with a " + this.weapon.getName());
        if (Utility.random(0, 20) < accuracy) {
            int damage = Utility.random(weapon.getDamageRange());
            System.out.println("You are hit for " + damage + " damage!");
            player.takeDamage(damage);
        } else {
            System.out.println("The " + name + " missed!");
        }
        System.out.println();
    }

    public void takeDamage(int damage) {
        int newResistance = shield.getResistance() - damage;
        if(newResistance <= 0){
            shield.setResistance(0);
            health += newResistance;
        }else{
            shield.setResistance(newResistance);
        }
    }


    public void displayHealth() {
        int totalHealth = health + shield.getResistance();
        System.out.println(name + "'s health = " + totalHealth);
    }

}

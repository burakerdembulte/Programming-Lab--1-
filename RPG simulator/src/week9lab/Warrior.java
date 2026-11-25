package week9lab;

public class Warrior extends GameCharacter implements Attacker{

    private int armor;

    public Warrior(int armor, String name, int level, int maxHealth) {
        super(name, level, maxHealth);
        if(armor > 0 && armor < 100) {
            this.armor = armor;
        }else if(armor < 0) {
            this.armor = 0;
        }else {
            this.armor = 100;
        }
    }

    @Override
    public String getCharacterInfo() {
        return String.format("Name: %s | Level: %d | Max Health: %d | Health: %d | Armor: %d", getName(), getLevel(), getMaxHealth(), getHealth(), armor);
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 10) + (armor * 2);
    }

    @Override
    public int takeDamage(int damage) {
        return super.takeDamage(damage - (armor / 2)); 
    }

    @Override
    public int attack(GameCharacter target) {
        return target.takeDamage(calculatePower() / 4);
    }
        
}

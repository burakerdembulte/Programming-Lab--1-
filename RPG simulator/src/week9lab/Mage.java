package week9lab;

public class Mage extends GameCharacter implements Attacker, Supporter{
    
    private int mana;

    public Mage(int mana, String name, int level, int maxHealth) {
        super(name, level, maxHealth);
        if(mana > 0 && mana < 200) {
            this.mana = mana;
        }else if(mana < 0) {
            this.mana = 0;
        }else {
            this.mana = 200;
        }
    }

    @Override
    public String getCharacterInfo() {
        return String.format("Name: %s | Level: %d | Max Health: %d | Health: %d | Mana: %d", getName(), getLevel(), getMaxHealth(), getHealth(), mana);
    }

    @Override
    public int calculatePower() {
        return (getLevel() * 8) + mana;
    }

    @Override
    public int attack(GameCharacter target) {
        if(mana - 20 < 0) {
            System.out.println("Not enough mana!");
            return 0;
        }
        int damage = calculatePower() / 3;
        mana -= 20;
        return target.takeDamage(damage);
    }

    @Override
    public int heal(GameCharacter target) {
        if(mana - 15 < 0) {
            System.out.println("Not enough mana!");
            return 0;
        }
        mana -= 15;
        return target.restoreHealth(getLevel() * 2);
    }
    
    
}

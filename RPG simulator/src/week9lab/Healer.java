package week9lab;

public class Healer extends GameCharacter implements Supporter{

    private int healAmount;

    public Healer(int healAmount, String name, int level, int maxHealth) {
        super(name, level, maxHealth);
        if(healAmount > 0 && healAmount < 200) {
            this.healAmount = healAmount;
        }else {
            this.healAmount = 100;
        }
    }

    @Override
    public String getCharacterInfo() {
        return String.format("Name: %s | Level: %d | Max Health: %d | Health: %d | Heal Amount: %d", getName(), getLevel(), getMaxHealth(), getHealth(), healAmount);
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        return target.restoreHealth(healAmount + getLevel());
    }
      
}

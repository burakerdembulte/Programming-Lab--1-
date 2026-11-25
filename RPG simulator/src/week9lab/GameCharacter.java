package week9lab;

public abstract class GameCharacter {
    
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        if(level >= 0 && level < 100) {
            this.level = level;
        }else {
            System.out.println("You entered invalid value!");
            this.level = 10;
        }
        if(maxHealth > 0 && maxHealth <= 2000) {
            this.maxHealth = maxHealth;
        }else {
            System.out.println("You entered invalid value!");
            this.health = 200;
        }
        this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public int takeDamage(int damage) {
        if(damage <= 0) return 0;
        health -= damage;
        if(health < 0) {
            health = 0;
            return health;
        }        
        return damage;
    }
    
    public int restoreHealth(int amount) {
        health += amount;
        int tempHealth = health;
        if(health > maxHealth) {
            health = maxHealth;
            return maxHealth - tempHealth;
        }
        return amount;
    }
    
    //  ABSTRACT CLASSES
    
    public abstract String getCharacterInfo();
    public abstract int calculatePower();
}

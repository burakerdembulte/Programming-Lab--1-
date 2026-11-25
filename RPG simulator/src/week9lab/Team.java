package week9lab;

import java.util.ArrayList;

public class Team {
    
    private ArrayList<GameCharacter> team = new ArrayList<>();
    
    public void addCharacter(GameCharacter character) {
        for (GameCharacter g : team) {
            if(g.getName().equals(character.getName())) {
                System.out.println("Two characters with the same name cannot be in the team!");
                return;
            }
        }
        team.add(character);
    }
    
    public void removeCharacter(String name) {
        for (GameCharacter g : team) {
            if(g.getName().equals(name)) {
                team.remove(g);
                System.out.println(name + " removed!");
                return;
            }
        }
        System.out.println("Character not found!");
    }
    
    public GameCharacter findByName(String name) {
        for (GameCharacter g : team) {
            if(g.getName().equals(name)) {
                return g;
            }
        }
        System.out.println("Character not found!");
        return null;
    }
    
    public void attackAll(GameCharacter target) {
        for (GameCharacter g : team) {
            if(g instanceof Attacker && g.isAlive()) {
                ((Attacker) g).attack(target);
            }
        }
    }
    
    public void healTeam() {
        double minRatio = 1;
        GameCharacter tempGameCharacter = null;
        for (GameCharacter g : team) {
            double healthRatio = (double) g.getHealth() / g.getMaxHealth();
            if(g.isAlive() && healthRatio < minRatio) {
                minRatio = healthRatio;
                tempGameCharacter = g;
            }
        }
        
        for (GameCharacter g : team) {
            if(g instanceof Supporter && g.isAlive()) {
                ((Supporter) g).heal(team.get(team.indexOf(tempGameCharacter)));
            }
        }
    }
    
    public int getTotalPower() {
        int totalPower = 0;
        for (GameCharacter g : team) {
            if(g.isAlive()) {
                totalPower += g.calculatePower();
            }
        }
        return totalPower;
    }
    
    public void displayInfo() {
        for (GameCharacter g : team) {
            System.out.println(g.getCharacterInfo() + " | Is Alive: " + g.isAlive());
        }
    }
}

package week9lab;

public class Week9Lab {

    public static void main(String[] args) {
        Team team = new Team();
        
        GameCharacter c1 = new Warrior(110, "Garen", 45, 660);
        GameCharacter c2 = new Mage(175, "Karma", 40, 450);
        GameCharacter c3 = new Healer(90, "Nunu", 32, 320);
        
        team.addCharacter(c1);
        team.addCharacter(c2);
        team.addCharacter(c3);
        
        Warrior enemy = new Warrior(200, "Aatrox", 65, 1400);
        
        System.out.println("---------------------ROUND 1---------------------");
        System.out.println("");
        
        team.attackAll(enemy);
        enemy.attack(c3);
        enemy.attack(c2);
        enemy.attack(c1);
        
        team.displayInfo();
        System.out.println("");
        System.out.println(enemy.getCharacterInfo());
        
        System.out.println("");
        team.removeCharacter("Karma");
        
        System.out.println("---------------------ROUND 2---------------------");
        System.out.println("");
        
        team.healTeam();
        team.attackAll(enemy);
        enemy.attack(c3);
        enemy.attack(c1);
        
        team.displayInfo();
        System.out.println("");
        System.out.println(enemy.getCharacterInfo());
        
        GameCharacter c4 = new Healer(110, "Nunu", 45, 220);
        team.addCharacter(c4);
        
        GameCharacter c5 = new Warrior(100, "Qiyana", -12, 400);
        
    }

}

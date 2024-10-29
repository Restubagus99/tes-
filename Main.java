import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("As'ad Sakai", 100, 15);
        Villain villain = new Villain("Zhafran Khan", 100, 15);

        Random random = new Random();
        boolean heroTurn = true;

        hero.showCharacter();
        villain.showCharacter();
        System.out.println();

        while (!hero.dead() && !villain.dead()) {
            if (heroTurn) {
                if (random.nextDouble() > 0.25) { // 25% chance to dodge
                    hero.attack(villain);
                } else {
                    System.out.println(villain.getName() + " dodge your attack!");
                }
            } else {
                if (random.nextDouble() > 0.25) { // 25% chance to dodge
                    villain.attack(hero);
                } else {
                    System.out.println(hero.getName() + " dodge " + villain.getName() + " attack!");
                }
            }

            // Show health status after each attack or dodge
            System.out.println(hero.getName() + " | " + hero.getHealth());
            System.out.println(villain.getName() + " | " + villain.getHealth());
            System.out.println();

            // Apply special skill if health is below 50
            if (hero.getHealth() < 50)
                hero.specialSkill();
            if (villain.getHealth() < 50)
                villain.specialSkill();

            heroTurn = !heroTurn;
        }

        if (hero.dead()) {
            System.out.println("Villain " + villain.getName() + " wins!!! Hero " + hero.getName() + " Defeated.");
        } else {
            System.out.println("Hero " + hero.getName() + " wins!!! Villain " + villain.getName() + " Defeated.");
        }
    }
}

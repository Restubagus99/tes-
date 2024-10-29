import java.util.Random;

class Hero extends Character implements Behaviour {
    private static int count = 0;
    private boolean specialUsed = false;

    public Hero(String name, int health, int attack) {
        super(name, health, attack);
    }

    @Override
    public void showCharacter() {
        System.out.println("Hero: " + name + " | Health: " + health + " | Attack: " + attack);
    }

    public void attack(Character target) {
        System.out.println(name + " attack " + target.getName() + " with normal attack!");
        target.receiveDamage(attack);
    }

    public void specialSkill() {
        if (health < 50 && !specialUsed) {
            Random random = new Random();
            int skillType = random.nextInt(2);
            if (skillType == 0) {
                int healAmount = 20;
                health += healAmount;
                System.out.println(name + " uses special skill, Heal! Health increased by " + healAmount);
            } else {
                System.out.println(name + " uses special skill, Double Damage!");
                attack *= 2;
            }
            specialUsed = true;
        }
    }

    public boolean dead() {
        return isDead();
    }
}
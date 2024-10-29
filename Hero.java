import java.util.Random;

// Kelas Hero ini merupakan subclass dari Character dan juga mengimplementasikan interface Behaviour.
// Kelas ini merepresentasikan karakter Hero dalam game, yang memiliki skill khusus dan kemampuan menyerang.
class Hero extends Character implements Behaviour {

    // Atribut `count` berfungsi untuk melacak jumlah Hero yang dibuat
    private static int count = 0;

    // Atribut `specialUsed` adalah flag untuk memastikan bahwa special skill hanya
    // bisa digunakan sekali.
    private boolean specialUsed = false;

    // Constructor untuk Hero yang menerima `name`, `health`, dan `attack` sebagai
    // parameter.
    // Constructor ini memanggil constructor superclass (Character) untuk
    // menginisialisasi atribut dasar.
    public Hero(String name, int health, int attack) {
        super(name, health, attack);
    }

    // Override metode `showCharacter()` dari superclass Character untuk menampilkan
    // informasi Hero.
    public void showCharacter() {
        System.out.println("Hero: " + name + " | Health: " + health + " | Attack: " + attack);
    }

    // Metode `attack()` untuk melakukan serangan normal pada target (karakter
    // lain).
    // Metode ini akan mengurangi `health` dari target sesuai dengan nilai `attack`
    // dari Hero.
    public void attack(Character target) {
        System.out.println(name + " attack " + target.getName() + " with normal attack!");
        target.receiveDamage(attack);
    }

    // Override metode `specialSkill()` dari interface Behaviour untuk mengaktifkan
    // skill khusus Hero.
    // Jika `health` kurang dari 50 dan `specialUsed` masih `false`, skill akan
    // diaktifkan.
    public void specialSkill() {
        if (health < 50 && !specialUsed) {
            // Membuat objek Random untuk menentukan jenis skill secara acak.
            Random random = new Random();
            int skillType = random.nextInt(2); // Menghasilkan angka 0 atau 1

            if (skillType == 0) {
                // Jika `skillType` 0, maka skill yang digunakan adalah "Heal"
                int healAmount = 20;
                health += healAmount;
                System.out.println(name + " uses special skill, Heal! Health increased by " + healAmount);
            } else {
                // Jika `skillType` 1, maka skill yang digunakan adalah "Double Damage"
                System.out.println(name + " uses special skill, Double Damage!");
                attack *= 2;
            }

            // Mengubah `specialUsed` menjadi `true` agar skill hanya bisa digunakan sekali.
            specialUsed = true;
        }
    }

    // Override metode `dead()` dari interface Behaviour untuk mengecek apakah Hero
    // sudah mati.
    // Metode ini mengembalikan `true` jika `health` Hero sudah habis (<= 0).
    public boolean dead() {
        return isDead();
    }
}

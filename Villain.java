import java.util.Random;

// Kelas Villain adalah subclass dari Character dan mengimplementasikan interface Behaviour.
// Kelas ini merepresentasikan karakter Villain dalam game, yang memiliki skill khusus dan kemampuan menyerang.
class Villain extends Character implements Behaviour {

    // Atribut `count` berfungsi untuk melacak jumlah Villain yang dibuat (tidak
    // digunakan dalam kode ini,
    // tetapi dapat digunakan jika ingin menambahkan fitur penghitung Villain).
    private static int count = 0;

    // Atribut `specialUsed` adalah flag untuk memastikan bahwa special skill hanya
    // bisa digunakan sekali.
    private boolean specialUsed = false;

    // Constructor untuk Villain yang menerima `name`, `health`, dan `attack`
    // sebagai parameter.
    // Constructor ini memanggil constructor superclass (Character) untuk
    // menginisialisasi atribut dasar.
    public Villain(String name, int health, int attack) {
        super(name, health, attack);
    }

    // Override metode `showCharacter()` dari superclass Character untuk menampilkan
    // informasi Villain.
    @Override
    public void showCharacter() {
        System.out.println("Villain: " + name + " | Health: " + health + " | Attack: " + attack);
    }

    // Metode `attack()` untuk melakukan serangan normal pada target (karakter
    // lain).
    // Metode ini akan mengurangi `health` dari target sesuai dengan nilai `attack`
    // dari Villain.
    public void attack(Character target) {
        System.out.println(name + " hit " + target.getName() + " with normal attack!");
        target.receiveDamage(attack);
    }

    // Override metode `specialSkill()` dari interface Behaviour untuk mengaktifkan
    // skill khusus Villain.
    // Jika `health` kurang dari 50 dan `specialUsed` masih `false`, skill akan
    // diaktifkan.
    public void specialSkill() {
        if (health < 50 && !specialUsed) {
            // Membuat objek Random untuk menentukan jenis skill secara acak.
            Random random = new Random();
            int skillType = random.nextInt(2); // Menghasilkan angka 0 atau 1

            if (skillType == 0) {
                // Jika `skillType` adalah 0, maka skill yang digunakan adalah "Heal"
                int healAmount = 20;
                health += healAmount;
                System.out.println(name + " uses special skill, Heal! Health increased by " + healAmount);
            } else {
                // Jika `skillType` adalah 1, maka skill yang digunakan adalah "Double Damage"
                System.out.println(name + " uses special skill, Double Damage!");
                attack *= 2;
            }

            // Mengubah `specialUsed` menjadi `true` agar skill hanya bisa digunakan sekali.
            specialUsed = true;
        }
    }

    // Override metode `dead()` dari interface Behaviour untuk mengecek apakah
    // Villain sudah mati.
    // Metode ini mengembalikan `true` jika `health` Villain sudah habis (<= 0).
    public boolean dead() {
        return isDead();
    }
}

// Kelas Character adalah kelas abstrak yang berfungsi sebagai dasar (template) 
// bagi semua karakter dalam game, seperti "Hero" dan "Villain".
// Kelas ini mendefinisikan atribut dasar dan beberapa metode umum yang dibutuhkan 
// oleh semua karakter, tetapi tidak sepenuhnya terimplementasi (memiliki metode abstrak).

public abstract class Character {

    // Atribut `name` menyimpan nama karakter.
    protected String name;

    // Atribut `health` menyimpan nilai kesehatan karakter. Jika nilainya mencapai
    // 0, karakter dianggap mati.
    protected int health;

    // Atribut `attack` menyimpan kekuatan serangan karakter.
    protected int attack;

    // Constructor ini digunakan untuk menginisialisasi karakter dengan nama,
    // kesehatan, dan kekuatan serangan tertentu.
    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    // Metode abstrak `showCharacter()` dideklarasikan di sini, namun tidak
    // diimplementasikan.
    // Setiap kelas yang mewarisi `Character` harus mengimplementasikan metode ini
    // untuk
    // menampilkan informasi karakter dengan caranya sendiri.
    public abstract void showCharacter();

    // Metode `setName()` untuk mengubah nama karakter.
    public void setName(String name) {
        this.name = name;
    }

    // Metode `getName()` untuk mengambil atau mendapatkan nama karakter.
    public String getName() {
        return name;
    }

    // Metode `getHealth()` untuk mendapatkan nilai kesehatan karakter saat ini.
    public int getHealth() {
        return health;
    }

    // Metode `getAttack()` untuk mendapatkan nilai serangan karakter.
    public int getAttack() {
        return attack;
    }

    // Metode `receiveDamage()` digunakan untuk mengurangi nilai `health` karakter
    // sesuai jumlah `damage` yang diterima. Jika `health` menjadi kurang dari 0,
    // maka akan diatur menjadi 0 (tidak bisa negatif).
    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0)
            health = 0;
    }

    // Metode `isDead()` digunakan untuk memeriksa apakah karakter sudah mati.
    // Metode ini mengembalikan `true` jika `health` karakter sudah 0 atau kurang,
    // dan `false` jika karakter masih hidup.
    public boolean isDead() {
        return health <= 0;
    }
}

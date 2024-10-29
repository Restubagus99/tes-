
// Mengimpor kelas Random untuk menghasilkan angka acak.
import java.util.Random;

// Mendefinisikan kelas utama bernama Main
public class Main {

    // Fungsi utama yang akan dijalankan saat program dieksekusi.
    public static void main(String[] args) {
        // Membuat objek Hero dengan nama "As'ad Sakai", health 100, dan attack power
        // 15.
        Hero hero = new Hero("As'ad Sakai", 100, 15);
        // Membuat objek Villain dengan nama "Zhafran Khan", health 100, dan attack
        // power 15.
        Villain villain = new Villain("Zhafran Khan", 100, 15);

        Random random = new Random(); // Membuat objek Random untuk menghasilkan angka acak.
        boolean heroTurn = true; // Menandai giliran, mulai dengan giliran hero.

        // Menampilkan informasi karakter hero dan villain.
        hero.showCharacter();
        villain.showCharacter();
        System.out.println(); // Menambahkan baris kosong untuk pemisah.

        // Loop yang akan berjalan selama baik hero maupun villain masih hidup.
        while (!hero.dead() && !villain.dead()) {
            if (heroTurn) { // Jika giliran hero.
                if (random.nextDouble() > 0.25) { // 75% kemungkinan serangan berhasil (25% untuk menghindar).
                    hero.attack(villain); // Hero menyerang villain.
                } else {
                    System.out.println(villain.getName() + " dodge your attack!"); // Villain menghindar dari serangan
                                                                                   // hero.
                }
            } else { // Jika giliran villain.
                if (random.nextDouble() > 0.25) { // 75% kemungkinan serangan berhasil (25% untuk menghindar).
                    villain.attack(hero); // Villain menyerang hero.
                } else {
                    System.out.println(hero.getName() + " dodge " + villain.getName() + " attack!"); // Hero menghindar
                                                                                                     // dari serangan
                                                                                                     // villain.
                }
            }

            // Menampilkan status kesehatan setelah setiap serangan atau penghindaran.
            System.out.println(hero.getName() + " | " + hero.getHealth());
            System.out.println(villain.getName() + " | " + villain.getHealth());
            System.out.println(); // Menambahkan baris kosong untuk pemisah.

            // Jika kesehatan hero di bawah 50, gunakan skill khusus hero.
            if (hero.getHealth() < 50)
                hero.specialSkill();
            // Jika kesehatan villain di bawah 50, gunakan skill khusus villain.
            if (villain.getHealth() < 50)
                villain.specialSkill();

            heroTurn = !heroTurn; // Mengganti giliran antara hero dan villain.
        }

        // Menampilkan hasil akhir setelah salah satu karakter kalah.
        if (hero.dead()) {
            System.out.println("Villain " + villain.getName() + " wins!!! Hero " + hero.getName() + " Defeated.");
        } else {
            System.out.println("Hero " + hero.getName() + " wins!!! Villain " + villain.getName() + " Defeated.");
        }
    }
}

// Interface Behaviour ini digunakan untuk menentukan perilaku (behaviour) umum 
// yang harus dimiliki oleh setiap karakter dalam game, seperti "Hero" dan "Villain".

public interface Behaviour {

    // Metode ini, specialSkill(), adalah kemampuan khusus yang dimiliki oleh setiap karakter.
    // Setiap karakter akan memiliki cara berbeda dalam mengimplementasikan special skill ini,
    // misalnya, bisa berupa healing (penyembuhan) atau double damage (serangan ganda).
    // Karena ini hanya "kerangka", kita tidak menentukan apa yang dilakukan skill ini di sini.
    void specialSkill();

    // Metode ini, dead(), berfungsi untuk memeriksa apakah karakter sudah mati atau belum.
    // Metode ini mengembalikan nilai boolean: 
    // - true jika karakter sudah mati (health sudah habis).
    // - false jika karakter masih hidup.
    boolean dead();
}

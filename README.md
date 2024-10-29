[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Pbfn6yDY)

# Modul 2: Interface dan Abstract Class dalam OOP

## Deskripsi

Program ini mensimulasikan pertarungan antara dua karakter, yaitu Hero dan Villain, yang memiliki atribut dasar seperti nama, health, dan attack. Kedua karakter ini memiliki kemampuan khusus yang dapat diaktifkan dalam kondisi tertentu selama pertarungan. Tujuan dari program ini adalah untuk menerapkan konsep abstraksi dan interface di dalam Java, sekaligus mempelajari mekanisme pertarungan berbasis giliran dengan fitur khusus seperti dodge dan special skill.

## Class Diagram

Diagram kelas telah dirancang untuk memberikan gambaran umum dari hubungan antar kelas dalam program ini. Berikut adalah deskripsi dari setiap komponen utama:

- Character (Abstract Class)
- Behaviour (Interface)
- Hero dan Villain (Concrete Classes)

## Code Explanation

### Abstract Class: Character

Kelas Character adalah kelas abstrak yang mendefinisikan atribut dan metode dasar yang dimiliki oleh semua karakter dalam pertarungan. Kelas ini mendefinisikan beberapa atribut seperti name, health, dan attack, serta beberapa metode penting.

- Atribut:
  - name: Nama karakter.
  - health: Menyimpan nilai kesehatan karakter. Jika mencapai nol, karakter dianggap mati.
  - attack: Menentukan kekuatan serangan karakter.
- Metode: - showCharacter(): Merupakan metode abstrak yang wajib diimplementasikan oleh kelas turunan untuk menampilkan informasi karakter. - receiveDamage(int damage): Mengurangi nilai health karakter sesuai jumlah damage yang diterima. - isDead(): Mengembalikan true jika health karakter sudah nol atau kurang.
  Kelas abstrak Character memberikan kerangka dasar bagi karakter yang akan dibuat (Hero dan Villain) tanpa mengharuskan pengembang menentukan detail implementasinya di kelas ini.

### Intervace:Behaviour

Interface Behaviour mendefinisikan kontrak perilaku untuk special skill yang dimiliki oleh karakter. Terdapat dua metode dalam interface ini: - specialSkill(): Metode yang akan digunakan untuk menerapkan skill khusus pada setiap karakter ketika kondisi tertentu terpenuhi (misalnya ketika health < 50). - dead(): Menyatakan apakah karakter tersebut mati.
Interface Behaviour memungkinkan kelas Hero dan Villain untuk mengimplementasikan special skill yang unik sesuai kebutuhan tanpa mempermasalahkan bagaimana mereka melakukannya.

### Concrete Class: Hero dan Villain

Kelas Hero dan Villain adalah turunan dari Character yang juga mengimplementasikan interface Behaviour. Kedua kelas ini mengatur karakteristik masing-masing jenis karakter dan cara mereka bertarung.

- Hero:
  - Mewarisi atribut dan metode dasar dari Character.
  - Menerapkan metode specialSkill() untuk memberikan skill khusus berupa Healing atau Double Damage saat health di bawah 50.
  - Menggunakan attack() untuk menyerang Villain.
- Villain:
  - Mewarisi atribut dan metode dasar dari Character.
  - Menerapkan metode specialSkill() dengan efek yang sama seperti Hero.
  - Menggunakan attack() untuk menyerang Hero.

## Special Skills dan Battle Flow

Pertarungan berlangsung dengan kondisi berikut:

1. Turn-based Attack: Pertarungan dilakukan secara bergiliran, dan setiap karakter menyerang lawan dengan attack() mereka. Jika lawan menghindar, serangan akan gagal.
2. Dodge Mechanism: Setiap karakter memiliki peluang 25% untuk menghindari serangan lawan.
3. Special Skill Activation: Jika health karakter di bawah 50 dan skill belum digunakan, karakter akan memiliki kesempatan untuk menggunakan skill khusus yang dipilih secara acak antara Healing dan Double Damage.
   - Healing: Menambahkan 20 health pada karakter.
   - Double Damage: Menggandakan nilai attack karakter untuk satu kali serangan.
4. Battle Outcome: Pertarungan akan berlanjut hingga salah satu karakter memiliki health <= 0, dan karakter tersebut dinyatakan kalah.

## Gambar Hasil Run

![Hasil Run](/1.png)

![Hasil Run](/2.png)

## Kesimpulan

Program ini menggunakan abstract class dan interface dalam Java untuk menerapkan konsep pewarisan dan kontrak perilaku yang berbeda antara Hero dan Villain. Dengan abstract class Character, kita dapat mendefinisikan atribut dasar dan kerangka untuk kelas turunan tanpa harus menentukan semua detail implementasi di kelas induk. Interface Behaviour memberikan fleksibilitas agar kelas turunan dapat mengimplementasikan metode spesifik yang memenuhi kontrak perilaku yang diharapkan tanpa memperhatikan bagaimana kelas tersebut melakukannya.
Program ini berhasil menunjukkan penerapan konsep OOP di Java, serta mengilustrasikan cara kerja mekanisme pertarungan yang melibatkan peluang menghindar dan penggunaan skill khusus yang terkontrol.

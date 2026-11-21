# Aplikasi Cek Bintang (Zodiak)

Aplikasi desktop sederhana berbasis **Java Swing** untuk menentukan zodiak pengguna berdasarkan nama, tanggal lahir, dan bulan lahir.

---

### 1. Top-Level Container Class
Wadah utama paling atas yang menjadi jendela aplikasi di sistem operasi.
- **Kelas yang digunakan:** `JFrame`
- **Contoh di dalam kode:**
  ```java
  JFrame frame = new JFrame("Cek Bintang (Zodiak)");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  ```

### 2. Intermediate Container Class
Wadah perantara yang berfungsi untuk mengelompokkan komponen-komponen kecil sebelum dimasukkan ke dalam *Top-Level Container*.
- **Kelas yang digunakan:** `JPanel`
- **Contoh di dalam kode:**
  ```java
  JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
  JPanel panelBawah = new JPanel(new BorderLayout(5, 10));
  JPanel bungkusTombol = new JPanel(new FlowLayout());
  ```

### 3. Atomic Component Class
Komponen dasar yang berinteraksi langsung dengan pengguna (untuk menampilkan teks, menerima input, atau memicu aksi).
- **Kelas yang digunakan:** `JLabel`, `JTextField`, `JComboBox`, `JButton`, `JOptionPane`
- **Contoh di dalam kode:**
  ```java
  JLabel labelNama = new JLabel("Nama:");
  JTextField inputNama = new JTextField(15);
  JComboBox<Integer> pilihTanggal = new JComboBox<>(daftarTanggal);
  JComboBox<String> pilihBulan = new JComboBox<>(daftarBulan);
  JButton tombolCek = new JButton("Cek Bintang");
  JLabel labelHasil = new JLabel("Masukkan nama dan tanggal lahir Anda", SwingConstants.CENTER);
  ```

### 4. Layout Classes (Layout Managers)
Kelas pengatur tata letak dan posisi komponen di dalam *container*.
- **Kelas yang digunakan:** `BorderLayout`, `GridLayout`, `FlowLayout`
- **Contoh di dalam kode:**
  ```java
  // Mengatur tata letak jendela utama dan panel bawah
  frame.setLayout(new BorderLayout(100, 100));
  panelBawah.setLayout(new BorderLayout(5, 10));

  // Mengatur form input menjadi grid 3 baris x 2 kolom
  JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));

  // Menengahkan posisi tombol di dalam panel pembungkus
  JPanel bungkusTombol = new JPanel(new FlowLayout());
  ```

### 5. Event Listener
Mekanisme untuk menangkap dan merespons interaksi pengguna (seperti klik tombol).
- **Kelas/Interface yang digunakan:** `ActionListener`
- **Contoh di dalam kode:**
  ```java
  tombolCek.addActionListener(e -> {
      String nama = inputNama.getText().trim();
      // Validasi input & pemrosesan objek User
      Person pengguna = new User(nama, tanggal, bulan);
      labelHasil.setText(pengguna.greeting());
  });
  ```

---

## 🖼️ Hasil Eksekusi Program (Screenshot)

Berikut adalah tampilan antarmuka aplikasi saat dijalankan dan berhasil memproses data input pengguna:

![Hasil Aplikasi Cek Bintang](./HasilProgram.png)
import javax.swing.*;
import java.awt.*;

public class ZodiacApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Jendela utama
            JFrame frame = new JFrame("Cek Bintang (Zodiak)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(100, 100));

            // Untuk Panel bagian Inputnya
            JPanel panelForm = new JPanel(new GridLayout(3, 2, 8, 8));
            panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

            // Komponen input
            JLabel labelNama = new JLabel("Nama:");
            JTextField inputNama = new JTextField(15);

            JLabel labelTanggal = new JLabel("Tanggal Lahir:");
            Integer[] daftarTanggal = new Integer[31];
            for (int i = 0; i < 31; i++) {
                daftarTanggal[i] = i + 1;
            }
            JComboBox<Integer> pilihTanggal = new JComboBox<>(daftarTanggal); //ini buat yang fitu gulirr

            JLabel labelBulan = new JLabel("Bulan Lahir:");
            String[] daftarBulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };
            JComboBox<String> pilihBulan = new JComboBox<>(daftarBulan); //ini buat yang fitu gulirr

            //ini ditambahin dia ke menu pilihannya tu dengan basis dari panel yang dh dibuat sebelumnya
            panelForm.add(labelNama);
            panelForm.add(inputNama);
            panelForm.add(labelTanggal);
            panelForm.add(pilihTanggal);
            panelForm.add(labelBulan);
            panelForm.add(pilihBulan);

            // bagain bawahnya, tombol sama teks hasil
            JPanel panelBawah = new JPanel(new BorderLayout(5, 10));
            panelBawah.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));

            JButton tombolCek = new JButton("Cek Bintang");
            JLabel labelHasil = new JLabel("Masukkan nama dan tanggal lahir Anda", SwingConstants.CENTER);
            labelHasil.setFont(new Font("SansSerif", Font.BOLD, 13));
            labelHasil.setForeground(new Color(0, 102, 204));

            // pas tombolnya ditekan
            tombolCek.addActionListener(e -> {
                String nama = inputNama.getText().trim();

                if (nama.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Nama tidak boleh kosong!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                int tanggal = (Integer) pilihTanggal.getSelectedItem();
                int bulan = pilihBulan.getSelectedIndex() + 1; // Indeks mulai dari 0, jadi ntar bakal +1 dulu

                // Cek tanggal valid untuk bulan tertentu
                if ((bulan == 2 && tanggal > 29) ||
                   ((bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) && tanggal > 30)) {
                    labelHasil.setText("Tanggal tidak valid untuk bulan tersebut!");
                    return;
                }

                // Buat objek User dan langsung tampilkan hasilnya
                Person pengguna = new User(nama, tanggal, bulan);
                labelHasil.setText(pengguna.greeting());
            });

            JPanel bungkusTombol = new JPanel(new FlowLayout());
            bungkusTombol.add(tombolCek);

            panelBawah.add(bungkusTombol, BorderLayout.NORTH);
            panelBawah.add(labelHasil, BorderLayout.CENTER);

            // biar semua panel-panel tadi ke jendela utama
            frame.add(panelForm, BorderLayout.CENTER);
            frame.add(panelBawah, BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null); // biar muncul di tengah layar
            frame.setVisible(true);
        });
    }
}
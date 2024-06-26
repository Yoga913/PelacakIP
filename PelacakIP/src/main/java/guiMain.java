import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;


public class guiMain extends JFrame{

	private JMenuBar bar;
	private JPanel panel1;
	private JPanel panel2;
	private JTextArea textArea;
	private JTextField tf;
	private JLabel label;
	private JButton button;
	private JScrollPane scrollPane;
	private JSplitPane pane;
	
	public guiMain() {
		
		this.setTitle("Pelacak IP");
		this.setSize(750,680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel1();
		this.add(pane);
		setMenuBar();
		this.setJMenuBar(bar);
		ImageIcon appIcon = new ImageIcon(getClass().getResource("/globe.png"));
		this.setIconImage(appIcon.getImage());
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public void setMenuBar() {
		
	
		bar = new JMenuBar();
                bar.setBackground(Color.DARK_GRAY);
                bar.setForeground(Color.WHITE);
		JMenu menu = new JMenu("File");
                menu.setForeground(Color.WHITE);
		JMenuItem item1 = new JMenuItem("Expor Hasil");
		item1.addActionListener(new export());
		JMenuItem item2 = new JMenuItem("Keluar");
		item2.addActionListener(new exit());
		
		menu.add(item1);
		menu.add(item2);
		bar.add(menu);
		
	}
	
        public void setPanel1() {
            panel1 = new JPanel();
            panel2 = new JPanel();

            panel1.setBackground(new Color(45, 52, 54));
            panel2.setBackground(new Color(45, 52, 54));

            ImageIcon icon = new ImageIcon(getClass().getResource("/globe.png"));
            button = new JButton();
            button.setIcon(icon);
            button.setBackground(new Color(52, 152, 219));
            button.setForeground(Color.WHITE);
            button.addActionListener(new lookup());

           textArea = new JTextArea(30, 60);
           textArea.setText("Hasil:\n\n");
           textArea.setEditable(false);
           textArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
               "Informasi IP:", TitledBorder.RIGHT, TitledBorder.TOP,
                    new Font("Arial", Font.BOLD, 14), Color.WHITE));
            textArea.setBackground(new Color(33, 47, 61));
            textArea.setForeground(Color.WHITE);
            textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

            scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            tf = new JTextField(12);
            tf.setBackground(Color.BLACK);
            tf.setForeground(Color.WHITE);

            panel1.setLayout(new BorderLayout());
            panel1.add(scrollPane, BorderLayout.CENTER);

            panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            panel2.add(tf);
            panel2.add(button);

            pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            pane.add(panel1);
            pane.add(panel2);
            pane.setDividerSize(5);
            pane.setDividerLocation(500);
            pane.setBorder(null);
        }
	
	
	//ACTION LISTENER TO BUTTON:
	private class lookup implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			
			
			String ip = tf.getText();
			
			if(ip.equals(null)) {
				
				JOptionPane.showMessageDialog(null,"NIlai IP TIdak Benar!","ERROR!",JOptionPane.ERROR_MESSAGE);
				return;
				
			} else {
			
			tf.setText(null);
			textArea.setText(null);
			
			try {
				webRequests request = new webRequests(ip);
				ipObject object = request.CreateObject();
				String text  = object.GetObjectValue();
				textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
				textArea.setText(text);
				System.out.println(object.GetObjectValue());
			
			
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
				
			}
			
			}
		}
	}




	private class export implements ActionListener{

		public void actionPerformed(ActionEvent e){

			String username = System.getProperty("user.name");
			String directory = "C:/Users/"+username+"Documents";

			JOptionPane.showMessageDialog(null, "Pilih folder tujuan kemudian beri nama file Anda!", "Information", JOptionPane.INFORMATION_MESSAGE);

			String sb = textArea.getText();
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File(directory));
			int retrival = chooser.showSaveDialog(null);
			if (retrival == JFileChooser.APPROVE_OPTION) {
				try {
					FileWriter fw = new FileWriter(chooser.getSelectedFile());
					fw.write(sb.toString());
					fw.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}


		}

	}

	private class exit implements ActionListener{


		public void actionPerformed(ActionEvent e){

			System.exit(0);

		}


	}

	
	
	public static void main(String []args) {
		
		new guiMain();
		
	}
	
	
}

/* 
 * Berikut adalah penjelasan dari setiap bagian kode program dan alur pada program:

```java
// Import library yang dibutuhkan
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

// Deklarasi kelas utama yang merupakan turunan dari JFrame
public class guiMain extends JFrame {

    // Deklarasi komponen GUI
    private JMenuBar bar;
    private JPanel panel1;
    private JPanel panel2;
    private JTextArea textArea;
    private JTextField tf;
    private JLabel label;
    private JButton button;
    private JScrollPane scrollPane;
    private JSplitPane pane;

    // Konstruktor utama untuk inisialisasi GUI
    public guiMain() {
        this.setTitle("Pelacak IP"); // Set judul jendela
        this.setSize(750, 680); // Set ukuran jendela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set aksi saat jendela ditutup
        setPanel1(); // Panggil metode untuk mengatur panel
        this.add(pane); // Tambahkan JSplitPane ke jendela
        setMenuBar(); // Panggil metode untuk mengatur menu bar
        this.setJMenuBar(bar); // Set menu bar di jendela
        ImageIcon appIcon = new ImageIcon(getClass().getResource("/globe.png")); // Set ikon aplikasi
        this.setIconImage(appIcon.getImage());
        this.setResizable(false); // Set jendela tidak dapat diubah ukurannya
        this.setVisible(true); // Tampilkan jendela
    }

    // Metode untuk mengatur menu bar
    public void setMenuBar() {
        bar = new JMenuBar();
        bar.setBackground(Color.DARK_GRAY);
        bar.setForeground(Color.WHITE);
        JMenu menu = new JMenu("File");
        menu.setForeground(Color.WHITE);
        JMenuItem item1 = new JMenuItem("Expor Hasil");
        item1.addActionListener(new export()); // Tambahkan ActionListener untuk item menu "Expor Hasil"
        JMenuItem item2 = new JMenuItem("Keluar");
        item2.addActionListener(new exit()); // Tambahkan ActionListener untuk item menu "Keluar"
        
        menu.add(item1); // Tambahkan item menu ke menu
        menu.add(item2);
        bar.add(menu); // Tambahkan menu ke menu bar
    }

    // Metode untuk mengatur panel
    public void setPanel1() {
        panel1 = new JPanel();
        panel2 = new JPanel();

        panel1.setBackground(new Color(45, 52, 54));
        panel2.setBackground(new Color(45, 52, 54));

        ImageIcon icon = new ImageIcon(getClass().getResource("/globe.png"));
        button = new JButton();
        button.setIcon(icon);
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.addActionListener(new lookup()); // Tambahkan ActionListener untuk tombol

        textArea = new JTextArea(30, 60);
        textArea.setText("Hasil:\n\n");
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
            "Informasi IP:", TitledBorder.RIGHT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14), Color.WHITE));
        textArea.setBackground(new Color(33, 47, 61));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));

        scrollPane = new JScrollPane(textArea, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        tf = new JTextField(12);
        tf.setBackground(Color.BLACK);
        tf.setForeground(Color.WHITE);

        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel2.add(tf);
        panel2.add(button);

        pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        pane.add(panel1);
        pane.add(panel2);
        pane.setDividerSize(5);
        pane.setDividerLocation(500);
        pane.setBorder(null);
    }

    // Kelas untuk menangani aksi tombol lookup
    private class lookup implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String ip = tf.getText(); // Ambil teks dari JTextField
            
            if (ip.equals(null)) { // Cek apakah IP kosong
                JOptionPane.showMessageDialog(null, "NIlai IP TIdak Benar!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                tf.setText(null); // Bersihkan JTextField
                textArea.setText(null); // Bersihkan JTextArea

                try {
                    webRequests request = new webRequests(ip); // Buat objek webRequests dengan IP
                    ipObject object = request.CreateObject(); // Buat objek ipObject dari request
                    String text = object.GetObjectValue(); // Ambil nilai dari objek
                    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
                    textArea.setText(text); // Set teks pada JTextArea
                    System.out.println(object.GetObjectValue());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    // Kelas untuk menangani aksi ekspor
    private class export implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = System.getProperty("user.name"); // Ambil nama pengguna sistem
            String directory = "C:/Users/" + username + "Documents"; // Tentukan direktori default

            JOptionPane.showMessageDialog(null, "Pilih folder tujuan kemudian beri nama file Anda!", "Information", JOptionPane.INFORMATION_MESSAGE);

            String sb = textArea.getText(); // Ambil teks dari JTextArea
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(directory)); // Set direktori default di file chooser
            int retrival = chooser.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter fw = new FileWriter(chooser.getSelectedFile()); // Buat FileWriter dengan file yang dipilih
                    fw.write(sb.toString()); // Tulis teks ke file
                    fw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Kelas untuk menangani aksi keluar
    private class exit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0); // Keluar dari program
        }
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        new guiMain(); // Buat instance dari guiMain
    }
}
```

### Penjelasan Singkat Alur Program:
1. **Inisialisasi dan Konfigurasi GUI**: Program memulai dengan menginisialisasi komponen GUI di dalam konstruktor `guiMain()`, termasuk menyiapkan panel, menu bar, ikon aplikasi, dan tampilan jendela utama.
2. **Pengaturan Panel dan Menu Bar**: Metode `setPanel1()` dan `setMenuBar()` digunakan untuk mengatur layout dan properti dari panel dan menu bar.
3. **Action Listeners**: Program memiliki beberapa action listeners untuk menangani event seperti klik tombol dan menu item. 
    - `lookup` untuk mengambil dan menampilkan informasi IP.
    - `export` untuk menyimpan hasil pencarian ke file.
    - `exit` untuk keluar dari aplikasi.
4. **Main Method**: Metode `main` untuk menjalankan aplikasi dengan membuat instance baru dari `guiMain`.
 */

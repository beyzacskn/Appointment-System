import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class UyeOlustur extends JFrame {

	private JPanel contentPane;
	private JTextField txTCKimlik;
	private JTextField txAd;
	private JTextField txSoyad;
	private JTextField txDogumYeri;
	private JTextField txEPosta;
	private JTextField txTel;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private List<kullanicilar> liste = new ArrayList<kullanicilar>();


	public boolean sayiIncele(String gelenSayi)
	{
		int x;
		String s;
		for (int i = 0 ; i<gelenSayi.length();i++)
		{
			s = ""+gelenSayi.charAt(i);
			try
			{
				x = Integer.parseInt(s);
			}
			catch (Exception e)
			{
				return false;
			}

		}
		return true;
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public UyeOlustur() throws ClassNotFoundException, IOException {
		setTitle("Kay\u0131t Ol");
		liste = dosya.dosyadanOku();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblyeKayd = new JLabel("\u00DCye Kayd\u0131");
		lblyeKayd.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblyeKayd.setBounds(152, 13, 109, 22);
		contentPane.add(lblyeKayd);

		JLabel lblTcKimlikNo = new JLabel("T.C. Kimlik No:");
		lblTcKimlikNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTcKimlikNo.setBounds(43, 48, 101, 20);
		contentPane.add(lblTcKimlikNo);

		JLabel lblAd = new JLabel("Ad:");
		lblAd.setFont(new Font("Arial", Font.BOLD, 14));
		lblAd.setBounds(122, 70, 22, 20);
		contentPane.add(lblAd);

		JLabel lblSoyad = new JLabel("Soyad:");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoyad.setBounds(94, 91, 50, 20);
		contentPane.add(lblSoyad);

		JLabel lblCinsiyet = new JLabel("Cinsiyet:");
		lblCinsiyet.setFont(new Font("Arial", Font.BOLD, 14));
		lblCinsiyet.setBounds(84, 112, 60, 20);
		contentPane.add(lblCinsiyet);

		JLabel lblDoumYeri = new JLabel("Do\u011Fum Yeri:");
		lblDoumYeri.setFont(new Font("Arial", Font.BOLD, 14));
		lblDoumYeri.setBounds(58, 133, 86, 20);
		contentPane.add(lblDoumYeri);

		JLabel lblEposta = new JLabel("E-Posta:");
		lblEposta.setFont(new Font("Arial", Font.BOLD, 14));
		lblEposta.setBounds(84, 154, 60, 20);
		contentPane.add(lblEposta);

		JLabel lblTel = new JLabel("Tel No:");
		lblTel.setFont(new Font("Arial", Font.BOLD, 14));
		lblTel.setBounds(90, 174, 56, 20);
		contentPane.add(lblTel);

		JLabel lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Arial", Font.BOLD, 14));
		lblParola.setBounds(90, 196, 50, 20);
		contentPane.add(lblParola);

		JLabel lblParolaTekrar = new JLabel("Parola Tekrar:");
		lblParolaTekrar.setFont(new Font("Arial", Font.BOLD, 14));
		lblParolaTekrar.setBounds(43, 217, 97, 20);
		contentPane.add(lblParolaTekrar);

		txTCKimlik = new JTextField();
		txTCKimlik.setBounds(152, 48, 116, 20);
		contentPane.add(txTCKimlik);
		txTCKimlik.setColumns(10);

		txAd = new JTextField();
		txAd.setBounds(152, 70, 116, 20);
		contentPane.add(txAd);
		txAd.setColumns(10);

		txSoyad = new JTextField();
		txSoyad.setBounds(152, 91, 116, 22);
		contentPane.add(txSoyad);
		txSoyad.setColumns(10);

		JRadioButton rdbtnBay = new JRadioButton("Bay");
		rdbtnBay.setBounds(152, 112, 52, 20);
		contentPane.add(rdbtnBay);

		JRadioButton rdbtnBayan = new JRadioButton("Bayan");
		rdbtnBayan.setBounds(203, 112, 63, 20);
		contentPane.add(rdbtnBayan);
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnBay);
		bG.add(rdbtnBayan);

		txDogumYeri = new JTextField();
		txDogumYeri.setBounds(152, 133, 116, 20);
		contentPane.add(txDogumYeri);
		txDogumYeri.setColumns(10);

		txEPosta = new JTextField();
		txEPosta.setBounds(152, 154, 116, 20);
		contentPane.add(txEPosta);
		txEPosta.setColumns(10);

		txTel = new JTextField();
		txTel.setBounds(152, 175, 116, 20);
		contentPane.add(txTel);
		txTel.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(152, 196, 116, 20);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(152, 217, 116, 20);
		contentPane.add(passwordField_1);

		JButton btnyeOl = new JButton("\u00DCye Ol");
		btnyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(txAd.getText().equals("") || txDogumYeri.getText().equals("") || txEPosta.getText().equals("") || txTel.getText().equals("") 
						|| txSoyad.getText().equals("")  || txTCKimlik.getText().equals("") 
						|| passwordField.getText().equals("") || passwordField_1.getText().equals(""))) 
				{

					if (txTCKimlik.getText().length()== 11)
					{
						if (sayiIncele(txTCKimlik.getText()))
						{
							if (passwordField.getText().equals(passwordField_1.getText())) {
								String cins = "Bayan";
								if (rdbtnBay.isSelected()) {
									cins = "Bay";
								}
								hasta hasta2 = new hasta(3, txTCKimlik.getText(), txAd.getText(), txSoyad.getText(), passwordField.getText(), cins);
								liste.add(hasta2);
								try {
									dosya.dosyayaYaz(liste);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								UyeOlustur.this.dispose();

							} 
							else 
							{
								JOptionPane.showMessageDialog(null, "Þifre Tekrarý Yanlýþ!!","ERROR",JOptionPane.ERROR_MESSAGE);
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"T.C Kimlik Numarasýný Doðru Formatta Giriniz!!","ERROR",JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"T.C Kimlik Numarasýný Doðru Formatta Giriniz!!","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Lütfen Tüm Boþluklarý Doldurunuz");
				}
			}



		});

		btnyeOl.setFont(new Font("Arial", Font.BOLD, 14));
		btnyeOl.setBounds(334, 257, 97, 25);
		contentPane.add(btnyeOl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(43, 40, 388, 2);
		contentPane.add(separator);
	}
}

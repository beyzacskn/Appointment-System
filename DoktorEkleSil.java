import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DoktorEkleSil extends JFrame {

	private JPanel contentPane;
	private JTextField tx›sim;
	private JTextField txSoy›sim;
	private JTextField txKullaniciAdi;
	private JPasswordField passwordField;
	private List<doktor> DoktorListesi = new ArrayList<doktor>();
	private DosyaIslemleri dosya = new DosyaIslemleri();

	/**
	 * Launch the application.
	 */
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
	public DoktorEkleSil(String kilinik,int i) throws ClassNotFoundException, IOException {
		dosya.olustur(3);
		DoktorListesi = dosya.doktorOku();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoktorAd˝ = new JLabel("\u0130sim:");
		lblDoktorAd˝.setFont(new Font("Arial", Font.BOLD, 14));
		lblDoktorAd˝.setBounds(136, 73, 32, 25);
		contentPane.add(lblDoktorAd˝);

		JLabel lblNewLabel = new JLabel("Soy \u0130sim:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(107, 111, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblTcKimlikNo = new JLabel("T.C. Kimlik No:");
		lblTcKimlikNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTcKimlikNo.setBounds(68, 35, 100, 25);
		contentPane.add(lblTcKimlikNo);

		JLabel lblifre = new JLabel("\u015Eifre:");
		lblifre.setFont(new Font("Arial", Font.BOLD, 14));
		lblifre.setBounds(127, 143, 41, 16);
		contentPane.add(lblifre);

		tx›sim = new JTextField();
		tx›sim.setBounds(168, 73, 116, 22);
		contentPane.add(tx›sim);
		tx›sim.setColumns(10);

		txSoy›sim = new JTextField();
		txSoy›sim.setBounds(168, 108, 116, 22);
		contentPane.add(txSoy›sim);
		txSoy›sim.setColumns(10);

		txKullaniciAdi = new JTextField();
		txKullaniciAdi.setBounds(168, 38, 116, 22);
		contentPane.add(txKullaniciAdi);
		txKullaniciAdi.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(168, 140, 116, 22);
		contentPane.add(passwordField);



		if (i == 1)
		{
			JButton btnDoktorEkle = new JButton("Doktor Ekle");
			btnDoktorEkle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!(tx›sim.getText().equals("") || txSoy›sim.getText().equals("") || txKullaniciAdi.getText().equals("") || passwordField.getText().equals("")))
					{
						{
							if (txKullaniciAdi.getText().length() == 11)
							{
								if (sayiIncele(txKullaniciAdi.getText()))
								{
									doktor d2 = new doktor(2, txKullaniciAdi.getText(), tx›sim.getText(), txSoy›sim.getText(), passwordField.getText(), "", kilinik);
									DoktorListesi.add(d2);
									try {
										dosya.doktorYaz(DoktorListesi);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									DoktorEkleSil.this.dispose();
								}
							}
						}
					}
				}});

			btnDoktorEkle.setBounds(127, 194, 97, 25);
			contentPane.add(btnDoktorEkle);
		}
		else if (i == 2)
		{
			JButton btnDoktorSil = new JButton("Doktor Sil");
			btnDoktorSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tx›sim.getText().equals("") || txSoy›sim.getText().equals("") || txKullaniciAdi.getText().equals(""))
					{
						if (txKullaniciAdi.getText().length() == 11)
						{
							if (sayiIncele(txKullaniciAdi.getText()))
							{
								for (int i = 0 ; i< DoktorListesi.size() ; i++)
								{
									if (DoktorListesi.get(i).get›sim().equals(tx›sim.getText()) && DoktorListesi.get(i).getSoy›sim().equals(txSoy›sim.getText()) && DoktorListesi.get(i).getTCKimlik().equals(txKullaniciAdi.getText()))
									{
										DoktorListesi.remove(i);
									}
								}
								try {
									dosya.doktorYaz(DoktorListesi);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								DoktorEkleSil.this.dispose();
							}
						}
					}
				}
			});

			btnDoktorSil.setBounds(127, 194, 97, 25);
			contentPane.add(btnDoktorSil);
		}
	}
}

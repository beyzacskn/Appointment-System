

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JSeparator;

public class giris {

	private JFrame frmHastaneRandevuSistemi;
	private JPasswordField passwordField;
	private JTextField textField;
	static Scanner x;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	yonetici a;
	private List<kullanicilar> liste = new ArrayList<kullanicilar>();
	private List<doktor> DoktorListesi = new ArrayList<doktor>();
	private int ro;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris window = new giris();
					window.frmHastaneRandevuSistemi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public giris() throws IOException, ClassNotFoundException {
		initialize();
		dosya.olustur(1);
		dosya.olustur(2);
		dosya.olustur(3);
		dosya.olustur(4);
		liste = dosya.dosyadanOku();
		DoktorListesi = dosya.doktorOku();

	}
	public int dogrulama(String kullaniciadi,String passw)
	{
		for (int i = 0 ; i<liste.size();i++)
		{
			if(liste.get(i).getTCKimlik().equals(kullaniciadi)&&liste.get(i).getSifre().equals(passw))
			{
				return i;
			}
		}
		
		return (-1);
	}
	public int dogrulama2 (String kullaniciadi,String passw)
	{
		for (int i = 0 ; i<DoktorListesi.size();i++)
		{
			if(DoktorListesi.get(i).getTCKimlik().equals(kullaniciadi)&&DoktorListesi.get(i).getSifre().equals(passw))
			{
				return i;
			}
		}
		return (-1);
	}

	/**
	 * Initialize the contents of the frame.
	 */


	private void initialize() {
		frmHastaneRandevuSistemi = new JFrame("Hastane RAndevu Sistemi");
		frmHastaneRandevuSistemi.setBackground(Color.WHITE);
		frmHastaneRandevuSistemi.getContentPane().setBackground(new Color(102, 205, 170));
		frmHastaneRandevuSistemi.setTitle("Hastane Randevu Sistemi");
		frmHastaneRandevuSistemi.setBounds(100, 100, 457, 355);
		frmHastaneRandevuSistemi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHastaneRandevuSistemi.getContentPane().setLayout(null);

		JButton btnGiris = new JButton("Giris");
		btnGiris.setFont(new Font("Arial", Font.BOLD, 14));
		btnGiris.setBounds(302, 206, 97, 25);
		frmHastaneRandevuSistemi.getContentPane().add(btnGiris);
		btnGiris.setVisible(true);

		JButton btnyeOl = new JButton("\u00DCye Ol");
		btnyeOl.setFont(new Font("Arial", Font.BOLD, 14));

		btnyeOl.setBounds(71, 206, 97, 25);
		frmHastaneRandevuSistemi.getContentPane().add(btnyeOl);
		btnyeOl.setVisible(true);

		JLabel lblSifre = new JLabel("\u015Eifre:");
		lblSifre.setFont(new Font("Arial", Font.BOLD, 15));
		lblSifre.setBounds(71, 145, 56, 22);
		frmHastaneRandevuSistemi.getContentPane().add(lblSifre);
		lblSifre.setVisible(true);

		JLabel label = new JLabel("");
		label.setBounds(320, 147, 30, 20);
		frmHastaneRandevuSistemi.getContentPane().add(label);		


		Image img = new ImageIcon(this.getClass().getResource("/images.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passwordField.setEchoChar('\0');
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				passwordField.setEchoChar('*');
			}
		});


		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(179, 147, 138, 22);
		frmHastaneRandevuSistemi.getContentPane().add(passwordField);
		passwordField.setVisible(true);

		textField = new JTextField();
		textField.setBounds(179, 100, 138, 22);
		frmHastaneRandevuSistemi.getContentPane().add(textField);
		textField.setColumns(10);



		JButton parolamiUnuttum = new JButton("Parolam\u0131 Unuttum");
		parolamiUnuttum.setFont(new Font("Arial", Font.BOLD, 14));
		parolamiUnuttum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		parolamiUnuttum.setBounds(261, 270, 166, 25);
		frmHastaneRandevuSistemi.getContentPane().add(parolamiUnuttum);
		
		JLabel lblTcKimlikNo = new JLabel("T.C. Kimlik No:");
		lblTcKimlikNo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTcKimlikNo.setBounds(71, 103, 108, 16);
		frmHastaneRandevuSistemi.getContentPane().add(lblTcKimlikNo);
		
		JLabel lblGiriEkran = new JLabel("G\u0130R\u0130\u015E EKRANI");
		lblGiriEkran.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblGiriEkran.setBounds(143, 13, 152, 34);
		frmHastaneRandevuSistemi.getContentPane().add(lblGiriEkran);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 40, 415, 2);
		frmHastaneRandevuSistemi.getContentPane().add(separator);
		textField.setVisible(true);
		label.setVisible(true);
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a = dogrulama(textField.getText(), passwordField.getText());
				int c =dogrulama2(textField.getText(), passwordField.getText());
				if (dogrulama(textField.getText(), passwordField.getText())>=0)
				{
					int b = dogrulama(textField.getText(), passwordField.getText());
					if(liste.get(a).getRole()==1)
					{
						
						YoneticiGirisi yFrame = null;
						try {
							yFrame = new YoneticiGirisi(liste.get(a).getÝsim(), liste.get(a).getSoyÝsim());
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						yFrame.setVisible(true);
						
					}
					
					else if (liste.get(b).getRole()==3)
					{
						try {
							HastaGirisi hFrame = new HastaGirisi(liste.get(b).getÝsim(),liste.get(b).getSoyÝsim());
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if (c>=0)
				{
					doktorGirisi dFrame;
					try {
						dFrame = new doktorGirisi(DoktorListesi.get(c).getÝsim(),DoktorListesi.get(c).getSoyÝsim());
						dFrame.setVisible(true);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Kullanýcý Adý yada Þifre yanlýþ!");
				}
			}});
		btnyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UyeOlustur yeniUye;
				try {
					yeniUye = new UyeOlustur();
					yeniUye.setVisible(true);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

	}
}
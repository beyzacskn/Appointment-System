import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import java.awt.TextArea;
import javax.swing.JComboBox;

public class YoneticiGirisi extends JFrame {

	private JPanel contentPane;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private String ad,soyad;
	private List<kullanicilar> liste = new ArrayList<kullanicilar>();
	private List<doktor> DoktorListesi = new ArrayList<doktor>();
	private List<klinikler> KlinikListesi = new ArrayList<klinikler>();
	private int btnkilimik = 0;
	private Object rowData;
	private JTable table;
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public YoneticiGirisi(String girilen›sim,String girilenSoyisim) throws IOException, ClassNotFoundException {
		setTitle("Y\u00F6netici Giri\u015Fi");
		dosya.olustur(1);
		dosya.olustur(2);
		dosya.olustur(3);
		liste = dosya.dosyadanOku();
		DoktorListesi = dosya.doktorOku();
		KlinikListesi = dosya.KlinikOku();		

		ad = girilen›sim;
		soyad = girilenSoyisim;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		int t = 0;
		for (int i = 0 ; i < liste.size() ; i++)
		{
			if (liste.get(i).getRole() == 3)
			{
				t++;
			}
		}
		String[] columnTitles = { "T.C. Kimlik", "Ad", "Soyad",};
		Object[][] rowData = new String[t+1][3];
		int sira = 0;
		for(int i = 0; i<liste.size();i++)
		{
			if (liste.get(i).getRole() == 3)
			{
				rowData[sira][0]=liste.get(i).getTCKimlik();
				rowData[sira][1]=liste.get(i).get›sim();
				rowData[sira][2]=liste.get(i).getSoy›sim();
				sira++;
			}
		}


		JLabel lblHogeldin = new JLabel("HO\u015EGELD\u0130N\u0130Z <dynamic> <dynamic>");
		lblHogeldin.setFont(new Font("Arial", Font.BOLD, 13));
		lblHogeldin.setBounds(12, 0, 451, 51);
		contentPane.add(lblHogeldin);

		JPanel KilinikveDoktorPanel = new JPanel();
		KilinikveDoktorPanel.setBounds(293, 412, 367, 358);
		contentPane.add(KilinikveDoktorPanel);
		KilinikveDoktorPanel.setLayout(null);

		JButton btnKilinikekle = new JButton("+");
		btnKilinikekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKilinikekle.setBounds(12, 295, 51, 25);
		KilinikveDoktorPanel.add(btnKilinikekle);

		JButton btnKiliniksil = new JButton("-");


		btnKiliniksil.setBounds(75, 295, 54, 25);
		KilinikveDoktorPanel.add(btnKiliniksil);

		JButton btnKilinikGncelle = new JButton("G\u00FCncelle");
		btnKilinikGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKilinikGncelle.setBounds(22, 333, 97, 25);
		KilinikveDoktorPanel.add(btnKilinikGncelle);

		JButton btnDoktorEkle = new JButton("+");
		btnDoktorEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoktorEkle.setBounds(166, 295, 51, 25);
		KilinikveDoktorPanel.add(btnDoktorEkle);

		JButton btnDoktorSil = new JButton("-");


		btnDoktorSil.setBounds(229, 295, 54, 25);
		KilinikveDoktorPanel.add(btnDoktorSil);

		JButton btnDoktorGuncelle = new JButton("G\u00FCncelle");

		btnDoktorGuncelle.setBounds(176, 333, 97, 25);
		KilinikveDoktorPanel.add(btnDoktorGuncelle);

		JLabel lblKlinikler = new JLabel("K\u0131linikler");
		lblKlinikler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKlinikler.setBounds(12, 0, 72, 25);
		KilinikveDoktorPanel.add(lblKlinikler);

		JLabel lblDoktorlar = new JLabel("Doktorlar");
		lblDoktorlar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoktorlar.setBounds(161, 0, 79, 25);
		KilinikveDoktorPanel.add(lblDoktorlar);

		TextArea doktorListesi = new TextArea();
		doktorListesi.setBounds(166, 21, 158, 268);
		KilinikveDoktorPanel.add(doktorListesi);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 38, 124, 22);
		KilinikveDoktorPanel.add(comboBox);
		comboBox.addItem("(Klinik SeÁiniz)");

		JButton btnKlinikVeyaDoktor = new JButton("Klinik veya Doktor Ekle");
		btnKlinikVeyaDoktor.setFont(new Font("Arial", Font.BOLD, 13));

		btnKlinikVeyaDoktor.setBounds(12, 107, 189, 51);
		contentPane.add(btnKlinikVeyaDoktor);

		JButton btnUyeler = new JButton("\u00DCye Listesi");
		btnUyeler.setFont(new Font("Arial", Font.BOLD, 13));

		btnUyeler.setBounds(12, 194, 189, 51);
		contentPane.add(btnUyeler);

		JButton btncikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btncikis.setFont(new Font("Arial", Font.BOLD, 13));

		btncikis.setBounds(12, 288, 189, 51);
		contentPane.add(btncikis);

		JPanel UyePaneli = new JPanel();
		UyePaneli.setBounds(12, 412, 295, 358);
		contentPane.add(UyePaneli);

		JButton button_5 = new JButton("+");
		button_5.setBounds(88, 282, 51, 25);
		
		UyePaneli.setLayout(null);
		UyePaneli.add(button_5);

		JButton button_6 = new JButton("-");
		button_6.setBounds(173, 282, 54, 25);

		UyePaneli.add(button_6);

		JButton button_7 = new JButton("G\u00FCncelle");
		button_7.setBounds(112, 320, 97, 25);

		UyePaneli.add(button_7);

		JLabel lblyeListesi = new JLabel("\u00DCye Listesi");
		lblyeListesi.setBounds(12, 1, 87, 25);
		lblyeListesi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UyePaneli.add(lblyeListesi);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 43, 195, 226);
		UyePaneli.add(scrollPane);






		btnKlinikVeyaDoktor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnkilimik==0)
				{
					for (int i = 0 ; i < KlinikListesi.size();i++)
					{
						comboBox.addItem((KlinikListesi.get(i).getklinik()));
					}
				}


				setBounds(100, 100, 587, 480);
				KilinikveDoktorPanel.setBounds(216, 53, 295, 358);
				UyePaneli.setBounds(48, 423, 295, 358);

				btnKilinikekle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String	s =JOptionPane.showInputDialog(null, "Eklemek istediiniz K˝linii giriniz:");
						klinikler k2 = new klinikler();
						k2.setklinik(s);
						KlinikListesi.add(k2);
						try {
							dosya.klinikyaz(KlinikListesi);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				btnKiliniksil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						String	s =JOptionPane.showInputDialog(null, "Silmek istediiniz K˝linii giriniz:");
						for (int i = 0 ; i < KlinikListesi.size();i++)
						{
							if(KlinikListesi.get(i).getklinik().equals(s))
							{
								KlinikListesi.remove(i);
							}
							try {
								dosya.klinikyaz(KlinikListesi);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				btnKilinikGncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBox.removeAllItems();
						comboBox.addItem("(Klinik SeÁiniz)");
						for (int i = 0 ; i < KlinikListesi.size();i++)
						{
							comboBox.addItem(KlinikListesi.get(i).getklinik());
						}
					}
				});

				btnDoktorEkle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							DoktorEkleSil frame2 = new DoktorEkleSil(KlinikListesi.get(comboBox.getSelectedIndex()-1).getklinik(),1);
							frame2.setVisible(true);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnDoktorSil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							DoktorEkleSil frame2 = new DoktorEkleSil(comboBox.getName(),2);
							frame2.setVisible(true);
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnDoktorGuncelle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						doktorListesi.setText(" ");
						try {
							DoktorListesi = dosya.doktorOku();
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String doktor =" ";
						for (int i = 0 ; i < DoktorListesi.size();i++)
						{
							if (comboBox.getSelectedItem().equals(DoktorListesi.get(i).getKlinik()))
							{
								doktor += DoktorListesi.get(i).get›sim()+" " +DoktorListesi.get(i).getSoy›sim() +"\n";
							}
						}
						doktorListesi.setText(doktor);
					}
				});

				btnkilimik++;
			}});
		btnUyeler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							UyeOlustur u1 = new UyeOlustur();
							u1.setVisible(true);
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				setBounds(100, 100, 587, 480);
				UyePaneli.setBounds(216, 53, 295, 358);
				KilinikveDoktorPanel.setBounds(329, 450, 295, 358);
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						table = new JTable(rowData,columnTitles);
						scrollPane.setViewportView(table);
						table.setCellSelectionEnabled(true);
						ListSelectionModel cellSelectionModel = table.getSelectionModel();
						cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

						cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								String selectedData = null;
								int sira = 0;
								int[] selectedRow = table.getSelectedRows();
								int[] selectedColumns = table.getSelectedColumns();

								for (int i = 0; i < selectedRow.length; i++) {
									for (int j = 0; j < selectedColumns.length; j++) {
										selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
										sira = i;
									}
								}
							}

						});
					}
				});

			}
		});
		btncikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}
}


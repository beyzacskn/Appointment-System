import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class HastaGirisi {

	private JFrame frmRandevuAl;
	DosyaIslemleri dosya = new DosyaIslemleri();
	private List<doktor> DoktorListesi = new ArrayList<doktor>();
	private List<klinikler> KlinikListesi = new ArrayList<klinikler>();
	private List<randevular> randevulistesi = new ArrayList<randevular>();
	DefaultTableModel model;
	Calendar cal = new GregorianCalendar();
	JLabel label;
	private JTextField txtRandevuTarihi;
	private String ad, soyad ,tarih;
	private String[] randevuSaatleri = {"9.00","9.10","9.20","9.30","9.40","9.50","10.00","10.10","10.20","10.30","10.40","10.50","11.00","11.10","11.00","11.10","11.20","11.30","11.40","11.50","13.00","13.10","13.20","13.30","13.40","13.50","14.00","14.10","14.20","14.30","14.40","14.50","15.00","15.10","15.20","15.30","15.40","15.50","16.00","16.10","16.20","16.30","16.40","16.50"};

	public void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("tr-TR"));
		int year = cal.get(Calendar.YEAR);
		label.setText(month + " " + year);

		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}

	}

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public HastaGirisi(String gelenad ,String gelensoyad) throws ClassNotFoundException, IOException {
		ad=gelenad;
		soyad = gelensoyad;

		initialize();
		frmRandevuAl.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, IOException {

		DoktorListesi = dosya.doktorOku();
		KlinikListesi = dosya.KlinikOku();
		randevulistesi = dosya.randevuoku();

		frmRandevuAl = new JFrame();
		frmRandevuAl.getContentPane().setBackground(new Color(102, 205, 170));
		frmRandevuAl.setTitle("Randevu Al");
		frmRandevuAl.setBounds(100, 100, 450, 323);
		frmRandevuAl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandevuAl.getContentPane().setLayout(null);

		JLabel lblHogeldin = new JLabel("HO\u015EGELD\u0130N\u0130Z <dynamic> <dynamic>");
		lblHogeldin.setFont(new Font("Arial", Font.BOLD, 16));
		lblHogeldin.setBounds(42, 10, 328, 25);
		frmRandevuAl.getContentPane().add(lblHogeldin);

		JLabel lblKlinik = new JLabel("KL\u0130N\u0130K");
		lblKlinik.setFont(new Font("Arial", Font.BOLD, 13));
		lblKlinik.setBounds(42, 58, 43, 16);
		frmRandevuAl.getContentPane().add(lblKlinik);

		JComboBox cbDoktor = new JComboBox();

		cbDoktor.setBounds(138, 90, 182, 22);
		frmRandevuAl.getContentPane().add(cbDoktor);

		JComboBox cbKlinik = new JComboBox();

		cbKlinik.setBounds(138, 55, 182, 22);
		frmRandevuAl.getContentPane().add(cbKlinik);
		cbKlinik.addItem("lütfen klinik seçiniz");

		for (int i = 0 ; i<KlinikListesi.size();i++)
		{
			cbKlinik.addItem(KlinikListesi.get(i).getklinik());
		}

		cbKlinik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbDoktor.removeAllItems();
				for (int i = 0 ; i < DoktorListesi.size();i++)
				{
					if(cbKlinik.getSelectedItem().equals(DoktorListesi.get(i).getKlinik()))
					{
						String str = (String)DoktorListesi.get(i).getÝsim() + " " + (String)DoktorListesi.get(i).getSoyÝsim();
						cbDoktor.addItem(str);
					}
				}

			}
		});

		JLabel lblDoktor = new JLabel("DOKTOR");
		lblDoktor.setFont(new Font("Arial", Font.BOLD, 13));
		lblDoktor.setBounds(42, 90, 64, 16);
		frmRandevuAl.getContentPane().add(lblDoktor);




		JLabel lblRandevuTarihi = new JLabel("RANDEVU TAR\u0130H\u0130 :");
		lblRandevuTarihi.setFont(new Font("Arial", Font.BOLD, 13));
		lblRandevuTarihi.setBounds(60, 137, 130, 16);
		frmRandevuAl.getContentPane().add(lblRandevuTarihi);

		JLabel lblRandevuSaati = new JLabel("RANDEVU SAAT\u0130:");
		lblRandevuSaati.setFont(new Font("Arial", Font.BOLD, 13));
		lblRandevuSaati.setBounds(60, 169, 131, 16);
		frmRandevuAl.getContentPane().add(lblRandevuSaati);

		JComboBox cbRandevuSaati = new JComboBox();
		cbRandevuSaati.setBounds(202, 166, 151, 22);
		frmRandevuAl.getContentPane().add(cbRandevuSaati);


		JButton btnRandevuAl = new JButton("RANDEVU AL");

		btnRandevuAl.setFont(new Font("Arial", Font.BOLD, 13));
		btnRandevuAl.setBounds(232, 215, 121, 25);
		frmRandevuAl.getContentPane().add(btnRandevuAl);

		txtRandevuTarihi = new JTextField();

		txtRandevuTarihi.setText("(randevu tarihi)");
		txtRandevuTarihi.setBounds(202, 134, 151, 22);
		frmRandevuAl.getContentPane().add(txtRandevuTarihi);
		txtRandevuTarihi.setColumns(10);

		for (int i = 0 ; i < randevuSaatleri.length;i++)
		{
			cbRandevuSaati.addItem(randevuSaatleri[i]);
		}
		JPanel panel = new JPanel();
		panel.setBounds(400, 10, 500, 20);

		panel.setVisible(false);
		panel.setLayout(new BorderLayout());

		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JButton b1 = new JButton("<-");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});

		JButton b2 = new JButton("->");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});
		panel.setLayout(new BorderLayout());
		panel.add(b1,BorderLayout.WEST);
		panel.add(label,BorderLayout.CENTER);
		panel.add(b2,BorderLayout.EAST);

		String [] columns = {"pazar","pazartesi","salý","çarþamba","perþembe","cuma","cumartesi"};
		model = new DefaultTableModel(null,columns);
		JTable table = new JTable(model);
		table.setSize(500, 200);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(400, 30, 500, 119);
		pane.setVisible(false);
		frmRandevuAl.getContentPane().add(panel);
		frmRandevuAl.getContentPane().add(pane);
		updateMonth();


		txtRandevuTarihi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(true);
				pane.setVisible(true);
				frmRandevuAl.setBounds(100, 100, 950, 300);
				ListSelectionModel cellSelectionModel = table.getSelectionModel();
				cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedData = 0;
						int sira = 0;
						int[] selectedRow = table.getSelectedRows();
						int[] selectedColumns = table.getSelectedColumns();

						for (int i = 0; i < selectedRow.length; i++) {
							for (int j = 0; j < selectedColumns.length; j++) {
								selectedData = (int) table.getValueAt(selectedRow[i], selectedColumns[j]);
							}
						}
						tarih = selectedData + " " + label.getText();
					}

				});
			}

			int j = 0;

			@Override
			public void mouseEntered(MouseEvent e) {
				txtRandevuTarihi.setText(tarih);
				panel.setVisible(false);
				pane.setVisible(false);
				frmRandevuAl.setBounds(100, 100, 450, 300);


				String s = (String)cbDoktor.getSelectedItem();
				String [] info = s.split(" ");
				for (int i = 0 ; i < randevulistesi.size();i++) {

					if (randevulistesi.get(i).getDoktorAdý().equals(info[0])&&randevulistesi.get(i).getDoktorSoyAdý().equals(info[1]))
					{
						if (randevulistesi.get(i).getRandevuTarihi().equals(txtRandevuTarihi.getText()))
						{
							cbRandevuSaati.removeItem(randevulistesi.get(i).getRandevuSaati());
						}
					}
				}
				btnRandevuAl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s = (String)cbDoktor.getSelectedItem();
						String [] info = s.split(" ");
						randevular r1 = new randevular((String)(cbKlinik.getSelectedItem()), ad, soyad, info[0], info[1], txtRandevuTarihi.getText(),(String)(cbRandevuSaati.getSelectedItem()));
						randevulistesi.add(r1);
						try {
							dosya.randevuyaz(randevulistesi);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.exit(0);
					}
				});
			}
		});



	}
}

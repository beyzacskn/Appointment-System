import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class doktorGirisi extends JFrame {

	private JPanel contentPane;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private List<randevular> randevu = new ArrayList<randevular>();
	private String ad,soyad;
	private String s = "";
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public doktorGirisi(String ad , String soyad) throws ClassNotFoundException, IOException {
		this.ad = ad;
		this.soyad = soyad;
		randevu = dosya.randevuoku();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("HO\u015EGELD\u0130N\u0130Z Dr."+ad+" "+soyad);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 24, 440, 35);
		contentPane.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(24, 121, 440, 180);
		contentPane.add(textArea);
		for (int i = 0 ; i< randevu.size();i++)
		{
			s += randevu.get(i).getHastaAdý()+" " + randevu.get(i).getHastaSoyAdý() +" "+randevu.get(i).getRandevuTarihi() + " "+randevu.get(i).getRandevuSaati()+ "\n";
		}
		textArea.setText(s);
		
		
	}
}

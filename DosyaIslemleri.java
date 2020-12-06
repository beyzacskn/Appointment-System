import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri {

	private List<kullanicilar> liste = new ArrayList<kullanicilar>();
	private List<doktor> DoktorListesi = new ArrayList<doktor>();
	private List<klinikler> KlinikListesi = new ArrayList<klinikler>();
	private List<randevular> randevulistesi = new ArrayList<randevular>();
	private File f = new File("Kullanýcýlar.ser");
	private File klinik = new File("kilinikList.ser");
	private File doktor = new File("doktorlist.ser");
	private File randevu = new File("randevu.ser");

	public void olustur(int flag) throws IOException
	{  
		if (flag == 1)

		{
			if(f.exists())
				;

			else
			{
				FileOutputStream fos;

				fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.reset();

				yonetici y1 = new yonetici(1, "10000000000", "Taha", "BARAN", "123", "erkek");

				oos.writeObject(y1);


				hasta h1 = new hasta(3,"10000000001","Enes","ÖZKAN","1122","erkek");
				oos.writeObject(h1);

				fos.close();
				oos.close();
			}
		}
		else if (flag == 2)
		{
			if(klinik.exists())
				;

			else
			{
					FileOutputStream fos;

					fos = new FileOutputStream(klinik);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.reset();

					klinikler k1 = new klinikler();
					k1.setklinik("Beyin Cerrahý");
					oos.writeObject(k1);
					fos.close();
					oos.close();
				
			}
		}
		else if (flag == 3)
		{
			if(doktor.exists())
				;
			else
			{
				FileOutputStream fos;

				fos = new FileOutputStream(doktor);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.reset();
				doktor d1 = new doktor(2,"11000000000","Beyza","COÞKUN","12345","kadýn","Beyin Cerrahý");
				DoktorListesi.add(d1);
				oos.writeObject(d1);
			}
		}
		else if (flag == 4)
		{
			if(randevu.exists())
				;
			else
			{
				FileOutputStream fos;

				fos = new FileOutputStream(randevu);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.reset();
				randevular r1 = new randevular("Beyin Cerrahý","Enes","ÖZKAN","Beyza","COÞKUN","30.04.2018","9.10");
				randevulistesi.add(r1);
				oos.writeObject(r1);
			}
		}
	}

	public List<kullanicilar> dosyadanOku() throws IOException, ClassNotFoundException
	{

		FileInputStream fis;
		fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while(fis.available()>0)
		{
			liste.add((kullanicilar) ois.readObject());
		}
		ois.close();
		return liste;
	}

	public void dosyayaYaz(List<kullanicilar> gelenListe) throws IOException
	{
		FileOutputStream fos;
		fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(int i = 0; i < gelenListe.size(); i++)
		{
			oos.writeObject(gelenListe.get(i));
		}

		fos.close();
		oos.close();

	}
	public List<klinikler> KlinikOku() throws IOException, ClassNotFoundException
	{
		FileInputStream fis;
		fis = new FileInputStream(klinik);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while(fis.available()>0)
		{
			KlinikListesi.add((klinikler) ois.readObject());
		}
		ois.close();
		return KlinikListesi;
	}
	public List<doktor> doktorOku() throws IOException, ClassNotFoundException
	{

		FileInputStream fis;
		fis = new FileInputStream(doktor);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while(fis.available()>0)
		{
			DoktorListesi.add((doktor) ois.readObject());
		}
		ois.close();
		
		return DoktorListesi;
	}
	public void klinikyaz(List<klinikler> gelenListe) throws IOException
	{
		FileOutputStream fos;
		fos = new FileOutputStream(klinik);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(int i = 0; i < gelenListe.size(); i++)
		{
			oos.writeObject(gelenListe.get(i));
		}

		fos.close();
		oos.close();

	}
	public void doktorYaz(List<doktor> gelenListe) throws IOException
	{
		FileOutputStream fos;
		fos = new FileOutputStream(doktor);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(int i = 0; i < gelenListe.size(); i++)
		{
			oos.writeObject(gelenListe.get(i));
		}

		fos.close();
		oos.close();

	}
	public List<randevular> randevuoku() throws IOException, ClassNotFoundException
	{

		FileInputStream fis;
		fis = new FileInputStream(randevu);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while(fis.available()>0)
		{
			randevulistesi.add((randevular) ois.readObject());
		}
		ois.close();
		
		return randevulistesi;
	}
	public void randevuyaz(List<randevular> gelenListe) throws IOException
	{
		FileOutputStream fos;
		fos = new FileOutputStream(randevu);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for(int i = 0; i < gelenListe.size(); i++)
		{
			oos.writeObject(gelenListe.get(i));
		}

		fos.close();
		oos.close();

	}


}

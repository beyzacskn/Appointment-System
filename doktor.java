import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class doktor extends kullanicilar implements Serializable {
	
	private String Klinik;
	
	public doktor(int role, String TCKimlik, String isim, String soy›sim, String sifre, String cinsiyet
			, String Klinik) {
		super(role, TCKimlik, isim, soy›sim, sifre, cinsiyet);
		this.Klinik = Klinik;
	}
	public doktor()
	{
		
	}
	
	public String getKlinik()
	{
		return Klinik;
	}
	
}

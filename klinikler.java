import java.awt.Component;
import java.io.Serializable;

public class klinikler implements Serializable {

	private String klinik;
	
	public klinikler()
	{
		
	}
	public void setklinik(String gelenKlinik)
	{
		klinik = gelenKlinik;
	}
	public String getklinik()
	{
		return klinik;
	}
	
}

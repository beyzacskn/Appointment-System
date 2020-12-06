import java.io.Serializable;

public class randevular implements Serializable {

	private String klinikAdý ;
	private String TCKimlik;
	private String hastaAdý;
	private String hastaSoyAdý;
	private String doktorAdý;
	private String doktorSoyAdý;
	private String randevutarihi;
	private String randevuSaati;
	
	randevular(String klinikAdý , String hastaAdý , String hastaSoyAdý ,String doktorAdý ,String doktorSoyAdý,String randevutarihi ,String randevuSaati)
	{
		this.doktorAdý = doktorAdý;
		this.doktorSoyAdý = doktorSoyAdý;
		this.hastaAdý = hastaAdý;
		this.hastaSoyAdý =hastaSoyAdý;
		this.klinikAdý = klinikAdý;
		this.randevuSaati = randevuSaati;
		this.randevutarihi = randevutarihi;
		this.TCKimlik = TCKimlik;
	}
	public String getDoktorAdý()
	{
		return doktorAdý;
	}
	public String getDoktorSoyAdý()
	{
		return doktorSoyAdý;
	}
	public String getHastaAdý()
	{
		return hastaAdý;
	}
	public String getHastaSoyAdý()
	{
		return hastaSoyAdý;
	}
	public String getklinikAdi()
	{
		return klinikAdý;
	}
	public String getTCKimlik()
	{
		return TCKimlik;
	}
	public String getRandevuSaati()
	{
		return randevuSaati;
	}
	public String getRandevuTarihi()
	{
		return randevutarihi;
	}
	
}

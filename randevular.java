import java.io.Serializable;

public class randevular implements Serializable {

	private String klinikAdı ;
	private String TCKimlik;
	private String hastaAdı;
	private String hastaSoyAdı;
	private String doktorAdı;
	private String doktorSoyAdı;
	private String randevutarihi;
	private String randevuSaati;
	
	randevular(String klinikAdı , String hastaAdı , String hastaSoyAdı ,String doktorAdı ,String doktorSoyAdı,String randevutarihi ,String randevuSaati)
	{
		this.doktorAdı = doktorAdı;
		this.doktorSoyAdı = doktorSoyAdı;
		this.hastaAdı = hastaAdı;
		this.hastaSoyAdı =hastaSoyAdı;
		this.klinikAdı = klinikAdı;
		this.randevuSaati = randevuSaati;
		this.randevutarihi = randevutarihi;
		this.TCKimlik = TCKimlik;
	}
	public String getDoktorAdı()
	{
		return doktorAdı;
	}
	public String getDoktorSoyAdı()
	{
		return doktorSoyAdı;
	}
	public String getHastaAdı()
	{
		return hastaAdı;
	}
	public String getHastaSoyAdı()
	{
		return hastaSoyAdı;
	}
	public String getklinikAdi()
	{
		return klinikAdı;
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

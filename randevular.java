import java.io.Serializable;

public class randevular implements Serializable {

	private String klinikAd� ;
	private String TCKimlik;
	private String hastaAd�;
	private String hastaSoyAd�;
	private String doktorAd�;
	private String doktorSoyAd�;
	private String randevutarihi;
	private String randevuSaati;
	
	randevular(String klinikAd� , String hastaAd� , String hastaSoyAd� ,String doktorAd� ,String doktorSoyAd�,String randevutarihi ,String randevuSaati)
	{
		this.doktorAd� = doktorAd�;
		this.doktorSoyAd� = doktorSoyAd�;
		this.hastaAd� = hastaAd�;
		this.hastaSoyAd� =hastaSoyAd�;
		this.klinikAd� = klinikAd�;
		this.randevuSaati = randevuSaati;
		this.randevutarihi = randevutarihi;
		this.TCKimlik = TCKimlik;
	}
	public String getDoktorAd�()
	{
		return doktorAd�;
	}
	public String getDoktorSoyAd�()
	{
		return doktorSoyAd�;
	}
	public String getHastaAd�()
	{
		return hastaAd�;
	}
	public String getHastaSoyAd�()
	{
		return hastaSoyAd�;
	}
	public String getklinikAdi()
	{
		return klinikAd�;
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

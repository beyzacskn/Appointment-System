import java.io.Serializable;

public class kullanicilar implements Serializable{
	private String TCKimlik;
	private int role;
	private String isim;
	private String soyIsim;
	private String sifre;
	private String cinsiyet;
	
	public kullanicilar(int role,String TCKimlik,String isim,String soyIsim,String sifre,String cinsiyet)
	{
		this.TCKimlik = TCKimlik;
		this.role=role;
		this.isim=isim;
		this.soyIsim=soyIsim;
		this.sifre=sifre;
		this.cinsiyet=cinsiyet;
	}
	public kullanicilar()
	{
		
	}

	public String getTCKimlik()

	{
		return TCKimlik;
	}
	
	public int getRole()
	{
		return role;
	}
	
	public String getIsim()
	{
		return isim;
	}
	
	public String getSoyIsim()
	{
		return soy›sim;
	}
	
	public String getSifre()
	{
		return sifre;
	}
	
	public String getCinsiyet()
	{
		return cinsiyet;
	}

}


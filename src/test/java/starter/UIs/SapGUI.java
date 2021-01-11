package starter.UIs;
 
import net.thucydides.core.annotations.Step;

public class SapGUI { 
	 
	SAPSistemGir SAPGir;
	
	
	@Step
	public void SapGUISistemDegiskenBelirle(String SapClient, String SapLang) {
		try {
			SAPGir = new SAPSistemGir();
			SAPGir.SistemDegiskenGir(SapClient, SapLang);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}	
		
	}

	@Step
	public void SapGUIKullaniciBilgileriGir(String kullaniciAdi,String kullaniciSifre) {
		try {
			SAPGir = new SAPSistemGir();
			SAPGir.KullaniciBilgilerigir(kullaniciAdi, kullaniciSifre);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}			
	}

	@Step
	public void SapGUIGiris() {
		try {
			SAPGir = new SAPSistemGir();
			SAPGir.GirisYap();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}	
	}

}

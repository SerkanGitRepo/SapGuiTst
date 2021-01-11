package starter.UIs;
 
import net.thucydides.core.annotations.Step;

public class SapLogon {
	
	SAPSistemAc SAPlgn=new SAPSistemAc(); 
	 
	@Step
	public void SapLogonYukle(String Sapsistem) {
		try {
			SAPlgn.SapLogonAc(Sapsistem); 
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("zaloo");
		}
		
		
	}
	
}

package starter.UIs;

import net.thucydides.core.annotations.Step;


public class STable {

	WorkerSTable WStable;
	{
	WStable = new WorkerSTable();
	}
	@Step
	public void SE16IslemKoduCagir(String sessionId) {
		try {
			
			WStable.conSessionId=sessionId;
			WStable.Se16Ac();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}
	
	@Step
	public void TabloASorguCagir(String sessionId) {
		try {
//			WStable = new WorkerSTable();
			WStable.conSessionId=sessionId;
			WStable.TabloAdiGirCagir();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}

	@Step
	public void DegiskenleriDoldur(String dateSearch,String sessionId) {
		try {
//			WStable = new WorkerSTable();
			WStable.conSessionId=sessionId;
			WStable.AlanlariGirCalistir(dateSearch);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}

	@Step
	public void MesajKontrolEt(String sessionId) {
		try {
			WStable.conSessionId=sessionId;
			WStable.SonucKontrol();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}
	
//	@Step
//	public void CikisKontrol() {
//		try {
//
//			WStable.Cikis();
//		}catch(Exception ex)
//		{
//			System.out.println(ex.getMessage());
//			System.out.println("Given");
//		}
//	}
}

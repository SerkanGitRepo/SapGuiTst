package starter.UIs;
 
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.jacob.activeX.*;

public class SAPSistemGir {
	
	ActiveXComponent SAPROTWr, GUIApp, Connection, Session, Obj;
	Dispatch ROTEntry;
	Variant ScriptEngine;
	 
	 
//	{
//	ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
//	ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
//	ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
//	ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
//	ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
//	Session = new ActiveXComponent(Connection.invoke("Children", 0).toDispatch());
//	ComThread.InitSTA();
//	} 
	
	public void SistemDegiskenGir(String UstBirim,String OturumDili) {
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",0).toDispatch());
			ComThread.InitSTA();
		
			
		ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/txtRSYST-MANDT").toDispatch());
		Obj.setProperty("Text", UstBirim);
		
		ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/txtRSYST-LANGU").toDispatch());
		Obj2.setProperty("Text", OturumDili);
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			ComThread.Release();
		}
	}
	
	public void KullaniciBilgilerigir(String KullaniciAdi, String Sifre) {
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",0).toDispatch());
			ComThread.InitSTA();
			
			
		ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/txtRSYST-BNAME").toDispatch());
		Obj.setProperty("Text", KullaniciAdi);
		
		ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/pwdRSYST-BCODE").toDispatch());
		Obj2.setProperty("Text", Sifre);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			ComThread.Release(); 
		}
	}
	
	public void GirisYap() {
		ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
		Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
		Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
		ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
		ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
		ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",0).toDispatch());
		ComThread.InitSTA();
		
		ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]").toDispatch());
		Obj.invoke("sendVKey", 0);
		ComThread.Release();
		
	}

}

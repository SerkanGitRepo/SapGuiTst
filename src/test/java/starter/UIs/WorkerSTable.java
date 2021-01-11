package starter.UIs;

import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import com.jacob.activeX.*;

public class WorkerSTable {
	//public String conSessionId; 
	
	ActiveXComponent SAPROTWr, GUIApp, Connection, Session, Obj;
	Dispatch ROTEntry;
	Variant ScriptEngine;
	String conSessionId; 


	public void Se16Ac() {
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ComThread.InitSTA();
			
			
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",Integer.parseInt(conSessionId)).toDispatch());
			
			ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/tbar[0]/okcd").toDispatch());
			Obj.setProperty("Text", "/nSE16");
			
			ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[0]").toDispatch());
			Obj2.invoke("sendVKey", 0);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getMessage());
			ComThread.Release(); 
		}
	}

	public void TabloAdiGirCagir() {
		
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ComThread.InitSTA();
			
			
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",Integer.parseInt(conSessionId)).toDispatch());
			ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/ctxtDATABROWSE-TABLENAME").toDispatch());
			Obj.setProperty("Text", "ZFI_GNS_T2001");
			
			ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[0]").toDispatch());
			Obj2.invoke("sendVKey", 0);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			ComThread.Release(); 
		}

	}

	public void AlanlariGirCalistir(String dateSearch) {
		
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ComThread.InitSTA();
			

			
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",Integer.parseInt(conSessionId)).toDispatch());
			ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/txtI4-LOW").toDispatch());
			Obj.setProperty("Text", "0046");
			
			ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[0]/usr/ctxtI9-LOW").toDispatch());
			Obj2.setProperty("Text", dateSearch);
			
			ActiveXComponent Obj3 = new ActiveXComponent(Session.invoke("FindById","wnd[0]/tbar[1]/btn[8]").toDispatch());
			Obj3.invoke("press");
			Thread.sleep(1000);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			ComThread.Release(); 
		}
		
	}

	public void SonucKontrol() {
		
		try {
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ComThread.InitSTA();
			
	
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",Integer.parseInt(conSessionId)).toDispatch());
			ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/sbar/pane[0]").toDispatch());
			System.out.println(Obj.getProperty("Text").toString());

			if (Obj.getProperty("Text").toString().contains("Bu anah")) {
				
				throw new Exception("Sonuç Bulunamadı");
			}
			ComThread.Release();
			
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			ComThread.Release(); 
		}
		
	}

//	@SuppressWarnings("rawtypes")
//	public void Cikis() {
//		try {
//			
//			DesiredCapabilities appCapabilities = new DesiredCapabilities();
//			appCapabilities.setCapability("app", "C:\\Program Files (x86)\\SAP\\FrontEnd\\SapGui\\saplogon.exe");
//			appCapabilities.setCapability("platformName", "Windows");
//			appCapabilities.setCapability("deviceName", "WindowsPC");
//			 
//			SAPLogonApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
//			SAPLogonApp.close();
//
//
//			}
//			catch(Exception e){
//				System.out.println("aloo");
//			}
//		
//	}
}

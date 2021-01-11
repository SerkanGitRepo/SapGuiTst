package starter;

import io.cucumber.junit.CucumberOptions; 
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import com.jacob.activeX.*;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/"
)
public class CucumberTestSuite {
	@SuppressWarnings("rawtypes")
	public static WindowsDriver SAPLogonApp = null;
	
	public static ActiveXComponent SAPROTWr, GUIApp, Connection, Session, Obj;
	public static Dispatch ROTEntry;
	public static Variant ScriptEngine;
	
	@BeforeClass
	public static void startup() {
		try { 

			Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
			Thread.sleep(1000);
			
			System.out.println("Çalıştı mı?");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@AfterClass
	@SuppressWarnings("rawtypes")
    public static void teardown() {

		
		try {
			
			ActiveXComponent SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
			Dispatch ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
			Variant ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
			ActiveXComponent GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());
			ActiveXComponent Connection = new ActiveXComponent(GUIApp.invoke("Children", 0).toDispatch());
			ComThread.InitSTA();
			
			
			ActiveXComponent Session = new ActiveXComponent(Connection.invoke("Children",0).toDispatch());
			
			ActiveXComponent Obj = new ActiveXComponent(Session.invoke("FindById","wnd[0]/mbar/menu[4]/menu[12]").toDispatch());
			Obj.invoke("select");
			
			Thread.sleep(2000);
			
			ActiveXComponent Obj2 = new ActiveXComponent(Session.invoke("FindById","wnd[1]/usr/btnSPOP-OPTION1").toDispatch());
			Obj2.invoke("press");
			
		}catch(Exception e){
			System.out.println("SAP Pencere Kapanmadı");
			ComThread.Release();
		} finally {
		
			ComThread.Release();
			
				try {
					
					DesiredCapabilities appCapabilities = new DesiredCapabilities();
					appCapabilities.setCapability("app", "C:\\Program Files (x86)\\SAP\\FrontEnd\\SapGui\\saplogon.exe");
					appCapabilities.setCapability("platformName", "Windows");
					appCapabilities.setCapability("deviceName", "WindowsPC");
					 
					SAPLogonApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
					SAPLogonApp.close();
		
		
					}
					catch(Exception e){
						System.out.println("Sap GUI Kapanmadı");
					}
				}
    }
}

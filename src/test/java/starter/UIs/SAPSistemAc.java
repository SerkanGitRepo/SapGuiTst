package starter.UIs;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class SAPSistemAc {  
	@SuppressWarnings("rawtypes")
	public static WindowsDriver SAPLogonApp = null;
	
	@SuppressWarnings("rawtypes")
	public void SapLogonAc(String SapSistem) {
		try {
			
		DesiredCapabilities appCapabilities = new DesiredCapabilities();
		appCapabilities.setCapability("app", "C:\\Program Files (x86)\\SAP\\FrontEnd\\SapGui\\saplogon.exe");
		appCapabilities.setCapability("platformName", "Windows");
		appCapabilities.setCapability("deviceName", "WindowsPC");

		 
			SAPLogonApp = new WindowsDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
			SAPLogonApp.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			SAPLogonApp.findElement(By.className("Edit")).click();
			SAPLogonApp.findElement(By.className("Edit")).clear();
			Thread.sleep(1000);
			SAPLogonApp.findElement(By.className("Edit")).sendKeys(SapSistem);
			SAPLogonApp.findElement(By.className("Edit")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println("aloo");
		}
		
	}

}

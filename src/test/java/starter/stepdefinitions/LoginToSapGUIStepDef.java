package starter.stepdefinitions;

import starter.UIs.SapGUI;
import starter.UIs.SapLogon;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginToSapGUIStepDef {

	
	@Steps
	SapLogon SAPLUI;
	
    @Steps
	SapGUI SAPGUI;

	@Given("^User Open SAP Logon App \"(.*)\"$")
	public void user_Open_SAP_Logon_App(String SapSistem) {
		try {
			SAPLUI=new SapLogon();
			SAPLUI.SapLogonYukle(SapSistem);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}

		
	}

	@When("^User enter \"(.*)\" and \"(.*)\" and send enter$")
	public void user_enter_and_and_send_enter(String kullaniciAdi, String kullaniciSifre) {

		try {
			SAPGUI=new SapGUI();
			SAPGUI.SapGUIKullaniciBilgileriGir(kullaniciAdi,kullaniciSifre);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("When");
		}

	}

	@And("^SAP Sys \"(.*)\" Info \"(.*)\" fill$")
	public void sap_Sys_Info_fill(String SAPClient, String SAPLang) {

		try {
			SAPGUI=new SapGUI();
			SAPGUI.SapGUISistemDegiskenBelirle(SAPClient,SAPLang);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("And");
		}

	}


	@Then("User should be login")
	public void user_should_be_login() {

		try {
			SAPGUI=new SapGUI();
			SAPGUI.SapGUIGiris();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Then");
		}

	}


}

package starter.stepdefinitions;

import starter.UIs.STable;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;


public class Se16GUIStepDef {
	
	@Steps
	STable SAPTable; 
	
	
	@Given("^Se16 transaction \"(.*)\" code call$")
	public void se16_transaction_code_call(String sessionId) {
		try {
			SAPTable=new STable();
			SAPTable.SE16IslemKoduCagir(sessionId);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}

	@When("^User \"(.*)\" type table name into textbox$")
	public void user_type_table_name_into_textbox(String sessionId) {
		try {
			SAPTable=new STable();
			SAPTable.TabloASorguCagir(sessionId);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}

	@And("^User fill \"(.*)\" BUDAT \"(.*)\" and POSBN field$")
	public void user_fill_BUDAT_and_POSBN_field(String dateSearch,String sessionId) {
		try {
			SAPTable=new STable();
			SAPTable.DegiskenleriDoldur(dateSearch,sessionId);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}
	}

	@Then("^Statusbar text \"(.*)\" control$")
	public void statusbar_text_control(String sessionId) {
		try {
			SAPTable=new STable();
			SAPTable.MesajKontrolEt(sessionId);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Given");
		}

	}

	
}



package all_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import streams_ucc_UDF.UDF_All_Methods;
import test_data.Constants;

public class ULM_Login extends UDF_All_Methods{

	public ULM_Login(WebDriver driver) {
		super(driver);
	
	}

	
	
	public  void ULMLogin() throws Exception
	{
		driver.get(Constants.strIndependentULmBeta_URL);
//		driver.get(Constants.strIndependentULmDCE_URL);
		username.clear();
		username.sendKeys("ulm@iosclient");
//		username.sendKeys("bala@add.mlb");
		password.clear();
		password.sendKeys("abc@1234",Keys.ENTER);
		ULMCompleteLoading();
		
		
		/*** PreSetup For ULM****/
		StoreAllQueuesDetails();
		SelectAllQueues_CheckBox(true);
		String strShow="1";
		setViewFilterButton();
		setView_Options(ViewFilter_Loggedin_Checkbox, strShow);
		setView_Options(ViewFilter_CallsinQueue_CheckBox, strShow);
		setView_Options(ViewFilter_ActiveCalls_CheckBox, strShow);
		setView_Options(ViewFilter_LogoutAgents_CheckBox, strShow);
		setSaveButton_ViewFilter();
  		SetQueueDivListLoading(true);
  		
  		
  		System.out.println("[ULMLogin] Success " +GetAgentLoginStatus_AllQueues("ulm@iosclient"));
	}
}

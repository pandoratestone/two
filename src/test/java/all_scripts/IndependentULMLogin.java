package all_scripts;

import org.openqa.selenium.WebDriver;
import output_results.Logs;
import streams_ucc_UDF.UDF_All_Methods;

public class IndependentULMLogin extends UDF_All_Methods {

	public IndependentULMLogin(WebDriver driver) {
		super(driver);
		
	}
	
	public void IndependentULM_LOGIN_Brnading(int Branding,String strNetwork)
	{
			try {
				System.out.println("\n------IndependentULM_LOGIN_Brnading-------\n");
					
				int LoginPageBrandingStatus=IsIndependentULMLoginPageBrandingStatus(Branding, strNetwork);
				if (LoginPageBrandingStatus==1) 
				{
					System.out.println("\nIndependentULM_LOGIN_Brnading  Pass\n");
				}	
				else
				{
					System.out.println("\nIndependentULM_LOGIN_Brnading  Faill\n");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	
	
	
	
	public void IndependentULM_ForGotPage_Brnading(int Branding,String strNetwork)
	{
			try {
				System.out.println("\n------IndependentULM_ForGotPage_Brnading--------\n");
					
				boolean ISLoginPageBrandingStatus=ISIndependentUMForgotPageBrandings(Branding, strNetwork);
				if (ISLoginPageBrandingStatus==true) 
				{
					System.out.println("\nIndependentULM_ForGotPage_Brnading  pass\n");
				}	
				else
				{
					System.out.println("\nIndependentULM_ForGotPage_Brnading  Faill\n");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	
	public void IndependentULM_ForGotPageHomeLink_Brnading(int Branding,String strNetwork)
	{
			try {
				System.out.println("\n------IndependentULM_ForGotPageHomeLink_Brnading--------\n");

				boolean ISLoginPageBrandingStatus=ISHomeLInkIndependetULMFogotpageStatus(Branding, strNetwork);
				if (ISLoginPageBrandingStatus==true) 
				{
					System.out.println("\nIndependentULM_ForGotPageHomeLink_Brnading Passs\n");
				}	
				else
				{
					System.out.println("\nIndependentULM_ForGotPageHomeLink_Brnading  Fail\n");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	
	
	public void IndepenDenetULM_PrivacyPolicyPage_Branding(int Branding,String strNetwork)
	{
		try {
			System.out.println("\n------IndepenDenetULM_PrivacyPolicyPage_Branding--------\n");
			int Status=PrivacyPolicyBranding(Branding, strNetwork);
			
			if(Status==1)
			{
				System.out.println("\nIndepenDenetULM_PrivacyPolicyPage_Branding Passss\n");
			}
			else
			{
				System.out.println("\nIndepenDenetULM_PrivacyPolicyPage_Branding FAILLL\n");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public void Independent_ULM_HomePage_Branding(int Branding,String strNetwork)
	{
		try {
			System.out.println("\n------IndependentUM_HomePage_Branding--------\n");
			int Status=IndependentULM_Homepage_Branding(Branding, strNetwork);
			if(Status==1)
			{
				System.out.println("\nIndependentUM_HomePage_Branding Pass\n");
			}
			else
			{
				System.out.println("\nIndependentUM_HomePage_Branding  Fail\n");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void IndependentULM_SignoutPage(int Branding,String strNetwork)
	{
		try {
			System.out.println("\n------IndependentULM_SignoutPage--------\n");
			int SignoutpageStatus=IndependentULM_SognoutPage_Status(Branding, strNetwork);
			if(SignoutpageStatus==1)
			{
				System.out.println("\nIndependentULM_SignoutPage   pass\n");
			}
			else
			{
				System.out.println("\nIndependentULM_SignoutPage   Fail\n");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}

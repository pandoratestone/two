package all_scripts;

import org.openqa.selenium.WebDriver;

import streams_ucc_UDF.UDF_All_Methods;

public class ViewFilters extends UDF_All_Methods{

	public ViewFilters(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public  void AllQueueViewType() throws Exception
	{
		int isPass=AllQueueFilter(strAllQueueViewType);
		System.out.println("Yes pass : : "+isPass);
	}
	
	public  void PerQueueViewType() throws Exception
	{
		int isPass=AllQueueFilter(strPerQueueViewType);
		System.out.println("Yes pass : : "+isPass);
	}
	/**Logged Agents Section Stared
	 * @strshow 1 Show, 0 Hide 
	 * ***/
	public  void LoginAgents_Section_AllQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		SelectAllQueues_CheckBox(true);
		int Result=SHow_Hide_Filters(ViewFilter_Loggedin_Checkbox, strAllQueueViewType, strShow, LoggedinAgents_Label);
		System.out.println("[LoginAgents_Section_AllQueues] strShow="+strShow+ " and Result="+Result);
	}
	
	
	public  void LoginAgents_Section_PerQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		SelectAllQueues_CheckBox(true);
		int Result=SHow_Hide_Filters(ViewFilter_Loggedin_Checkbox, strPerQueueViewType, strShow, LoggedinAgents_Label);
		System.out.println("[LoginAgents_Section_PerQueues] strShow="+strShow+" Result="+Result);
		
	}
	
	/**Call in Queue Section Stared***/
	public  void CallsInQueue_Section_AllQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		SelectAllQueues_CheckBox(true);
		int Result=SHow_Hide_Filters(ViewFilter_CallsinQueue_CheckBox, strAllQueueViewType, strShow, CallsinQueue_Label);
		System.out.println("[CallsInQueue_Section_AllQueues] strShow="+strShow+" Result="+Result);
		
	}
	public  void CallsInQueue_Section_PerQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		SelectAllQueues_CheckBox(true);
		int Result=SHow_Hide_Filters(ViewFilter_CallsinQueue_CheckBox, strPerQueueViewType, strShow, CallsinQueue_Label);
		System.out.println("[CallsInQueue_Section_PerQueues] strShow="+strShow+" Result="+Result);
		
	}
	
	/**Active Calls Section Stared***/
	
	public  void Activecalls_Section_AllQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_ActiveCalls_CheckBox, strAllQueueViewType, strShow, Activecalls_Label);
		System.out.println("[Activecalls_Section_AllQueues] strShow="+strShow+" Result="+Result);
		
	}
	public  void Activecalls_Section_PerQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_ActiveCalls_CheckBox, strPerQueueViewType, strShow, Activecalls_Label);
		System.out.println("[Activecalls_Section_PerQueues] strShow="+strShow+" Result="+Result);
	}
	
	/**SLAKPI Section Stared***/
	
	public  void SLAKPI_Section_AllQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_SLAKPI_CheckBox, strAllQueueViewType, strShow, SLAKPI_Label);
		System.out.println("[SLAKPI_Section_AllQueues] strShow="+strShow+" Result="+Result);
	}
	public  void SLAKPI_Section_PerQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_SLAKPI_CheckBox, strPerQueueViewType, strShow, SLAKPI_Label);
		System.out.println("[SLAKPI_Section_PerQueues] strShow="+strShow+" Result="+Result);
	}
	
	/*** Logout Section Started ****/
	public  void Logout_Section_AllQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_LogoutAgents_CheckBox, strAllQueueViewType, strShow, Logout_Label);
		System.out.println("[Logout_Section_AllQueues] strShow="+strShow+" Result="+Result);	
	}
	public  void Logout_Section_PerQueues(String strShow) throws Exception
	{
		System.out.println("\n\n***************\n\n");
		int Result=SHow_Hide_Filters(ViewFilter_LogoutAgents_CheckBox, strPerQueueViewType, strShow, Logout_Label);
		System.out.println("Logout_Section_PerQueues] strShow="+strShow+" Result="+Result);
	}
	
	
	

}

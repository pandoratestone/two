package all_scripts;

import org.openqa.selenium.WebDriver;

import streams_ucc_UDF.UDF_All_Methods;

public class Login_Logout_Agents_Validations extends UDF_All_Methods
{

	public Login_Logout_Agents_Validations(WebDriver driver) {
		super(driver);
	}

	
	public void Logged_In_Agentes_Count_AllQueues() throws Exception
	{
		int Result=Logged_IN_AgentesCount_AllQueues();
		System.out.println("[Logged_In_Agentes_Count_AllQueues] Result="+Result);
	}
	
	public void Logged_OUT_Agentes_Count_AllQueues() throws Exception
	{
		int Result=Logged_OUT_AgentesCount_AllQueues();
		System.out.println("[Logged_OUT_Agentes_Count_AllQueues] Result="+Result);
	}
	
	
	public void Logged_In_Agentes_Count_PerQueues() throws Exception
	{
		int Result=Logged_IN_AgentesCount_PerQueues(ACDGroups.iterator().next());
		System.out.println("[Logged_In_Agentes_Count_PerQueues] Result="+Result);
	}
	
	public void Logged_OUT_Agentes_Count_perQueues() throws Exception
	{
		int Result=Logged_OUT_AgentesCount_PerQueues(ACDGroups.iterator().next());
		System.out.println("[Logged_OUT_Agentes_Count_perQueues] Result="+Result);
	}
	
	public void AgentLoggedinStatus_AllQueues() throws Exception
	{
		int Result=AgentLoggedinAllQueues("ulm@iosclient");
		System.out.println("[AgentLoggedinStatus_AllQueues] Result="+Result);
	}
	
	public void AgentLoggedOUTStatus_AllQueues() throws Exception
	{
		int Result=AgentLogedOutinAllQueues("ulm@iosclient");
		System.out.println("[AgentLoggedOUTStatus_AllQueues] Result="+Result);
	}
	
	public  void LoginAgent_in_AllQueues() throws Exception
	{
		int Result=LoginAgentin_AllQueues("ulm@iosclient");
		System.out.println("[LoginAgent_in_AllQueues] Result: "+Result);
	}
	
	
}

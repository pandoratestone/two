package all_scripts;

import org.openqa.selenium.WebDriver;

import streams_ucc_UDF.UDF_All_Methods;

public class ULM_QueueFilters extends UDF_All_Methods 
{

	public ULM_QueueFilters(WebDriver driver) {
		super(driver);
	}
	
	public  void SelectACDQueue() throws Exception
	{
		SelectAllQueues_CheckBox(false);
		boolean isPass=ACDQueueEnable(ACDGroups.iterator().next());
		System.out.println("Is ACD Passed: : "+isPass);
	}
	
	public void SelectHuntGroup() throws Exception
	{
		SelectAllQueues_CheckBox(false);
		boolean isPass=HuntEnable(HuntGroups.iterator().next());
		System.out.println("HuntGroupEnabled "+isPass);
	}
	
	
	public  void SelectAllQueues() throws Exception
	{
		boolean isPass=isAllQueueEnabled();
		System.out.println("[SelectAllQueues]  :"+isPass);
	}

}

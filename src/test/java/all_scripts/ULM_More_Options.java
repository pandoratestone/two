package all_scripts;

import org.openqa.selenium.WebDriver;

import streams_ucc_UDF.UDF_All_Methods;

public class ULM_More_Options extends UDF_All_Methods{

	public ULM_More_Options(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	/*** Soft Phone call Monitoring Form *****/
	public  void SoftPhone_callMonitorForm_AllQueues() throws Exception
	{
		QueueViewType(strAllQueueViewType);
		int Result=CallmonitorForm(SofTphoe_CallMonitoringForm);
		System.out.println("[SoftPhone_callMonitorForm] All Queue Views Result="+Result);
	}
	
	public  void SoftPhone_callMonitorForm_PerQueues() throws Exception
	{
		QueueViewType(strPerQueueViewType);
		int Result=CallmonitorForm(SofTphoe_CallMonitoringForm);
		System.out.println("[SoftPhone_callMonitorForm] Per Queue Views Result="+Result);
	}
	
	/*** IP1 Phone call Monitoring Form *****/
	public  void IP1_callMonitorForm_AllQueues() throws Exception
	{
		QueueViewType(strAllQueueViewType);
		int Result=CallmonitorForm(IP1_CallMonitoringForm);
		System.out.println("[IP1_callMonitorForm] All Queues Result="+Result);
	}
	
	public  void IP1_callMonitorForm_PerQueues() throws Exception
	{
		QueueViewType(strPerQueueViewType);
		int Result=CallmonitorForm(IP1_CallMonitoringForm);
		System.out.println("[IP1_callMonitorForm] Per Queues Result="+Result);
	}
	
	/*** IP2 Phone call Monitoring Form *****/
	public  void IP2_callMonitorForm_AllQueues() throws Exception
	{
		QueueViewType(strAllQueueViewType);
		int Result=CallmonitorForm(IP2_CallMonitoringForm);
		System.out.println("[IP2_callMonitorForm] All Queues Result="+Result);
	}
	
	public  void IP2_callMonitorForm_PerQueues() throws Exception
	{
		QueueViewType(strPerQueueViewType);
		int Result=CallmonitorForm(IP2_CallMonitoringForm);
		System.out.println("[IP2_callMonitorForm] Pew Queue Result="+Result);
	}
	
	/** Refresh ULM ****/
	public void RefreshULM_AllQueues() throws Exception
	{
		QueueViewType(strAllQueueViewType);
		int Result=Refesh_Button();
		System.out.println("[RefreshULM] All Queues Result="+Result);
	}
	
	public void RefreshULM_PerQueues() throws Exception
	{
		QueueViewType(strPerQueueViewType);
		int Result=Refesh_Button();
		System.out.println("[RefreshULM] Per Queues Result="+Result);
	}
}

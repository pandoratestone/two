package test_data;


import org.openqa.selenium.WebDriver;

import streams_ucc_UDF.UDF_All_Methods;

public class Constants 
{
	protected static String Date;
	static WebDriver driver;
	//-- Chrome driver path ---//
	public static final String Chromedriverpath="E:\\Selenium\\Softwares\\Jar_Drivers\\Chrome drive\\chromedriver.exe";
	
	//-- Production streams URL----//
	public static final String streamsproductionurldcw="https://streams.us";
	public static final String streamsproductionurldce="https://dce.streams.us";
	public static final String streamsproductionurlbeta="https://gostreams.beta-wspbx.com";
	public static final String SteramsStagingURL="https://stg.streams.us";
	public static final String strIndependentULmBeta_URL="http://gostreams.beta-wspbx.com/livemonitor.jsp";
	public static final String strIndependentULmDCE_URL=streamsproductionurldce+"/livemonitor.jsp";
	
	
	public static final String sheetpathdce="E:/Selenium/Scripts/Com.streama_UCC.com/src/test/java/test_data/Streams_Dce.xls";
	public static final String sheetpathbeta1="E:\\Selenium\\Scripts\\Com.streama_UCC.com\\src\\test\\java\\test_data\\Streams_BETA1.xls";
	public static final String outputpath="E:\\Selenium\\Results\\Sanity_Smartbox_Streams.xls";

	//-- DCE user name and password--//
	public static final String dceuname="bala@add.mlb";
	public static final String commonpassword="abc@1234";
	
	//Autoit exe paths
	public static final String excelfile="E:\\Selenium\\Auto_IT\\Smartbox\\excel.exe";
//	public static final String excelfile="E:\\Selenium\\Auto_IT\\excel.exe";
	public static final String Singleimage="E:\\Selenium\\Auto_IT\\Smartbox\\image.exe";
	public static final String textfile="E:\\Selenium\\Auto_IT\\Smartbox\\text.exe";
	public static final String uploadfolder="E:\\Selenium\\Auto_IT\\Smartbox\\uploadfolder.exe";
	public static final String audio_file="E:\\Selenium\\Auto_IT\\Smartbox\\Audio.exe";
	public static final String image2_jpg="E:\\Selenium\\Auto_IT\\Smartbox\\second_image.exe";


	/*** Independent ULM BETA URLS ********/
	
	public static final String strIndependentULLink="/livemonitor.jsp";
	
	public static final String IDPStreamsBETAURL="https://gostreams.beta-wspbx.com"+strIndependentULLink;
	public static final String IDPMcgrawBETAURL="https://mcgrawgostreams.beta-wspbx.com"+strIndependentULLink;
	public static final String IDpKonnectBETAdURL="https://konnectgostreams.beta-wspbx.com"+strIndependentULLink;
	public static final String IDPQuorumtechBETAURL="https://quorum.streams.us"+strIndependentULLink;
	

	/*** Independent UL Production URLS ****/
	
	
	
	public static final String IDPStreamsProdURL="http://streams.us"+strIndependentULLink;
	public static final String IDPMcgrawProdURL="http://inpacket.streams.us"+strIndependentULLink;
	public static final String IDpKonnectProdURL="http://konnect.streams.us"+strIndependentULLink;
	public static final String IDPQuorumtechProdURL="http://quorum.streams.us"+strIndependentULLink;
	

	/** Wholesales Company URLS ***/
	public static final String McgrawCompay_URl="http://www.bcmone.com/";
	public static final String KumoCompay_URl="https://www.joinkumo.com/";
	
	/*** Production Wholesales Copy Rights ****/
	public static final String strCopyRight_Sterams_Beta="©"+UDF_All_Methods.strCurrentYear()+" PanTerra Networks, Inc. All rights reserved.";
	public static final String strCopyRight_Mcgraw_Beta="© "+UDF_All_Methods.strCurrentYear()+" BCM One";
	public static final String strCopyRight_Konnect_Beta="© "+UDF_All_Methods.strCurrentYear()+" Beta-BCSKUMO Networks, Inc.";
	public static final String strCopyRight_Quorumtech_Beta="© 2002-"+UDF_All_Methods.strCurrentYear()+" Quorum Technologies";
	
	
	public static final String strCopyRight_Sterams_Productioon="©"+UDF_All_Methods.strCurrentYear()+" PanTerra Networks, Inc. All rights reserved.";
	public static final String strCopyRight_Mcgraw_Productioon="© "+UDF_All_Methods.strCurrentYear()+" BCM One";
	public static final String strCopyRight_Konnect_Productioon="© "+UDF_All_Methods.strCurrentYear()+" Kumo Cloud Solutions";
	public static final String strCopyRight_Quorumtech_Productioon="© 2002-"+UDF_All_Methods.strCurrentYear()+" Quorum Technologies";
	
	
//	public static final String strCopyRight_Mcgraw_Productioon="© 2018 BCM One, Inc. All rights reserved |";
	/*public static final String strCopyRight_Konnect_Productioon="© 2018 Kumo Cloud Solutions. All rights reserved |";
	public static final String strCopyRight_Quorumtech_Productioon="© 2002-2018 Quorum Technologies, Inc. All rights reserved";*/
	
//	public static final String strCopyRight_Mcgraw_Productioon="2018 BCM One, Inc. All rights reserved";
//	public static final String strCopyRight_Konnect_Productioon="© 2018 Kumo Cloud Solutions. All rights reserved |";
//	public static final String strCopyRight_Quorumtech_Productioon="© 2002-2018 Quorum Technologies, Inc. All rights reserved";
	
	/** Test Result paths ****/
	public static String srrFolderPath="E:\\OutputResults\\"+UDF_All_Methods.DirectoryPath(UDF_All_Methods.setDirectry_Path());
	public static String strImagesPath=srrFolderPath+"\\"+UDF_All_Methods.milliseconds+"\\Images\\";
	public static String strTestcaseSourcePath="E:\\Selenium\\Scripts\\Com.streama_UCC.com\\Test_Cases\\TestCases.xls";
	public static String strExtendReportpath=srrFolderPath+"\\"+UDF_All_Methods.milliseconds+"\\";
	public static String strTestcaseTargetPath=srrFolderPath+"\\"+UDF_All_Methods.milliseconds+"\\TestCases.xls";







}




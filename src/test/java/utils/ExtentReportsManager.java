package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {
	
	public static ExtentReports reports;
	
	public static ExtentReports getExtentReports()
	{
		if(reports==null)
		{
			String reportsFolder=System.getProperty("user.dir")+"\\reports";
			
			new File(reportsFolder).mkdir();
			
			reports=new ExtentReports();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			date=date.replace(":", "-");
			System.out.println(date);
			
			File reportsHtmlFile=new File(reportsFolder+"\\"+date+".html");
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportsHtmlFile);
			
			reporter.config().setDocumentTitle("API Automation Tests");
			
			reporter.config().setReportName("GoRest API Test");
			
			reporter.config().setTheme(Theme.DARK);
			
			reports.attachReporter(reporter);
			
			
		}
		
		return reports;
		
	}
	

}

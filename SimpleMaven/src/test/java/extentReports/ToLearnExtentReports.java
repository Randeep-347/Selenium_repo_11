package extentReports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createReport() {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		
		//Step 1: Create an Instance of ExtentSparkReporter
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_reports/"+timeStamp+"ExtentReport.html");
		
		//step2: Create an instance of ExtentReports
		ExtentReports extReport= new ExtentReports();
		
		//Step3: Attach ExtentSparkRepriter to ExtentReports
		extReport.attachReporter(spark);
		
		//Step4: Create an instance of ExtentTest
		ExtentTest test = extReport.createTest("createReport");
		
		//Step5: call log() to provide status and message
		test.log(Status.PASS, "message added into Report");
		test.log(Status.INFO, "adding info Status");
		
		// STep 6: call flush()
		extReport.flush();
		
	}

}

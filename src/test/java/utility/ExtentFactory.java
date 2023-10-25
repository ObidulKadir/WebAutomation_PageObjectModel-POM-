package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {
	
	public static final ExtentReports  extendsReports = new ExtentReports();
	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/Report.html");
		reporter.config().setReportName("Sample Extend Report");
		extendsReports.attachReporter(reporter);
		
		return extendsReports;
		
	}

}

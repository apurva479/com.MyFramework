package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	//private static final String File = null;

	public org.apache.logging.log4j.Logger logger;  //log4j

	public static WebDriver driver;
	public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser"})	
	
	public void setUp(String br) throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");  //read value from config.property file
		p=new Properties();
		p.load(file);
		//logger=LogManager.getLogger(this.getClass()); log4j
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: System.out.println("invalid broswer..");
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));  //reading url from peroperties file
		driver.manage().window().maximize();
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);  //create random string
		return generatedString;
		
	}
	public String randomeNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);   //create random number
		return generatedNumber;
		
	}
	public String randomeAlphaNumberic() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(10);   //create randomnumber and string
		return (generatedString+generatedNumber);
		
	}
	public String captureScreen(String tname) throws IOException {
		String timeStamp=new SimpleDateFormat("yyyyMMddmmss").format(new Date(0));
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File souceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilepath=System.getProperty("user.dir")+"..screenshots\\" +tname+ "_" +timeStamp + ".png";
		File targetFile=new File(targetFilepath);
		souceFile.renameTo(targetFile);
		
		
		return targetFilepath;
	}


}

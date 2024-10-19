package com.classplusapp.base.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.b2b.mobile.tests.base.B2BBaseMobileAutomationTest;
import com.classplusapp.login.pages.ClassplusMobileLoginPage;
import com.classplusapp.login.pages.ClassplusWebLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.b2b.mobile.util.B2BBaseTestListener.class)

public class ClassplusBaseMobileAutomationTest extends B2BBaseMobileAutomationTest {

	private ClassplusMobileLoginPage mobileLoginPage = null;
	private ClassplusWebLoginPage webLoginPage = null;

	protected String loginURL = null;
	protected WebDriver web_driver = null;
	protected String time = null;
	Dimension size;
	protected List<WebDriver> lstWebDriver = new ArrayList<WebDriver>();
	protected List<WebDriver> lstAppiumDriver = new ArrayList<WebDriver>();

	private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();

	private static final Logger logger = Logger.getLogger(ClassplusBaseMobileAutomationTest.class);
	protected WebDriver childWebDriver = null;

	static String CODE = "learn";
	protected static String EMAIL = "gunjan@classplusappp.com";
	protected static String TUTOR_NUMBER = "7607984444";
	protected static String FACULTY_NUMBER = "9966119838";
	protected static String STUDENT_NUMBER = "8763006001";

	protected static final String ORG_CODE = ((System.getProperty("orgCode") == null)) ? CODE
			: (System.getProperty("orgCode"));
	protected static final String emailAddress = ((System.getProperty("store_email_address") == null)) ? EMAIL
			: System.getProperty("store_email_address");
	protected static final String TUTOR_MOBILE = ((System.getProperty("store_tutor_mobile_number") == null))
			? TUTOR_NUMBER
			: System.getProperty("store_tutor_mobile_number");
	protected static final String FACULTY_MOBILE = ((System.getProperty("store_faculty_mobile_number") == null))
			? FACULTY_NUMBER
			: System.getProperty("store_faculty_mobile_number");
	protected static String STUDENT_MOBILE = ((System.getProperty("store_student_mobile_number") == null))
			? STUDENT_NUMBER
			: System.getProperty("store_student_mobile_number");
	
	protected static final String tutorMobileNumber = System.getProperty("store_tutor_mobile_number") != null
			? System.getProperty("store_tutor_mobile_number")
			: "7607984444";
	protected static final String studentMobileNumber = System.getProperty("store_student_mobile_number") != null
			? System.getProperty("store_student_mobile_number")
			: "8763006001";
	protected static final String facultyOneMobileNumber = System.getProperty("store_faculty_mobile_number") != null
			? System.getProperty("store_faculty_mobile_number")
			: "9966119838";
	protected static final String parentMobileNumber = System.getProperty("store_parent_mobile_number") != null
			? System.getProperty("store_parent_mobile_number")
			: "9899805993";
	protected static final String facultyTwoMobileNumber = System.getProperty("store_faculty_two_mobile_number") != null
			? System.getProperty("store_faculty_two_mobile_number")
			: "9885672403";
	protected static final String tutorTwoMobileNumber = System.getProperty("store_tutor_two_mobile_number") != null
			? System.getProperty("store_tutor_two_mobile_number")
			: "6868594886";
	protected static final String orgCode = System.getProperty("orgCode") != null ? System.getProperty("orgCode")
			: "learn";

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "language" })
	public void initAutomation(@Optional("en")String language) {

		this.initApplication(language);

		logger.debug("Site URL :{} ");
	}

	public enum WEB_DRIVER {

		TUTOR_DRIVER, STUDENT_ONE_DRIVER, STUDENT_TWO_DRIVER;
	}

	protected synchronized WebDriver getWebDriver(String browser) {
		logger.info("Starting of method getWebDriver");

		String osPath = System.getProperty("os.name");

		/*
		 * WebDriver web_driver = webDriverPool.get(webDriver);
		 * 
		 * 
		 * 
		 * // Use existing web_driver if (web_driver != null) {
		 * log.debug("Using existing web web_driver " + webDriver); return web_driver; }
		 */

		if (osPath.contains("Linux")) {

			if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				// chromeOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("allow-file-access-from-files");
				firefoxOptions.addArguments("use-fake-device-for-media-stream");
				firefoxOptions.addArguments("use-fake-ui-for-media-stream");
				web_driver = new FirefoxDriver(firefoxOptions);
			} else if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");

				web_driver = new ChromeDriver(chromeOptions);
			}
		} else if (osPath.contains("Mac OS X")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();

				options.setHeadless(false);
				options.addArguments("--no-sandbox");
				options.addArguments("allow-file-access-from-files");
				options.addArguments("use-fake-device-for-media-stream");
				options.addArguments("use-fake-ui-for-media-stream");
				/*
				 * options.addArguments("enable-automation");
				 * 
				 * options.addArguments("--disable-extensions");
				 * options.addArguments("--dns-prefetch-disable");
				 * options.addArguments("--disable-gpu");
				 * options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				 */
				web_driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				web_driver = new FirefoxDriver();

			}
		} else {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setHeadless(false);

				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");

				/*
				 * chromeOptions.addArguments("allow-file-access-from-files");
				 * chromeOptions.addArguments("use-default-device-for-media-stream");
				 * chromeOptions.addArguments("use-fake-ui-for-media-stream");
				 */
				chromeOptions.addArguments("--no-sandbox");

				/*
				 * chromeOptions.addArguments("--incognito");
				 * 
				 * DesiredCapabilities cap = DesiredCapabilities.chrome();
				 * cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				 * chromeOptions.merge(cap);
				 */

				// chromeOptions.setHeadless(true); chromeOptions.addArguments("--no-sandbox");

				web_driver = new ChromeDriver(chromeOptions);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(false);
				firefoxOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("allow-file-access-from-files");
				firefoxOptions.addArguments("use-fake-device-for-media-stream");
				firefoxOptions.addArguments("use-fake-ui-for-media-stream");
				web_driver = new FirefoxDriver(firefoxOptions);
			} else if (browser.equalsIgnoreCase("Chromium")) {
				WebDriverManager.chromiumdriver().setup();
				web_driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("IEDriverServer")) {
				WebDriverManager.iedriver().setup();
				web_driver = new InternetExplorerDriver();
			}
		}

		web_driver.manage().window().maximize();
		web_driver.manage().deleteAllCookies();
		web_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		web_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("********* Driver Successfully Created ******** " + web_driver.getTitle());
		logger.info("End of method getWebDriver");

		// webDriverPool.put(webDriver, web_driver);
		lstWebDriver.add(web_driver);
		return web_driver;
	}

	protected synchronized void quitDriver(WEB_DRIVER webDriver) {
		logger.info("Starting of method quitDriver in BaseClassplusAutomationTest ");

		WebDriver web_driver = webDriverPool.get(webDriver);
		try {
			if (web_driver != null) {
				web_driver.quit();
				web_driver = null;
				webDriverPool.remove(webDriver);
				logger.debug(webDriver + " Web web_driver quit successfully in BaseClassplusAutomationTest ");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			web_driver = null;
		}
		logger.info("Ending of method quitDriver in BaseClassplusAutomationTest");
	}

	public synchronized void goToSite(String siteURL, WebDriver web_driver) {
		logger.info("starting of method goToSite");

		logger.debug("Login URL is" + siteURL);
		web_driver.get(siteURL);

		logger.info("Ending of method goToSite");
	}

	public WebDriver getChildWebDriver() {
		return this.childWebDriver;
	}

	public List<WebDriver> getWebDriversList() {
		return lstWebDriver;
	}

	/**
	 * public List<AppiumDriver<WebElement>> getAppiumDriverList() { return
	 * lstAppiumDriver; }
	 */

	public void siteLogin(String strOrgCode, String strMobileNumber, String strEmailAddress, WebDriver driver) {
		logger.info("Starting siteLogin method");

		driver.get(loginURL);
		this.webLoginPage.clickOutside();
		this.webLoginPage.loginToClassplusUsingMobileNumber(strOrgCode, strMobileNumber, strEmailAddress);

		logger.info("Ending siteLogin method");
	}

	public void loginToApplication(ClassplusWebLoginPage loginPage, WebDriver driver, String orgCode, String mobileNum,
			String emailAddress, String otp,String siteURL) throws Exception {
		// launchWebSite(driver);
		driver.get(siteURL);
		loginPage.clickOutside();
		loginPage.loginToClassplusUsingMobileNumber(orgCode, mobileNum, emailAddress);
		loginPage.setOTP(otp);
		loginPage.clickVerifyOTP();
	}

	public List<String> getPropertyList(String name) {
		List<String> list = Arrays.asList(name.toString().split("\\,"));
		System.out.println(list);
		return list;
	}

}
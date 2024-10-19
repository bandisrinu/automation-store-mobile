package com.classplusapp.base.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.b2b.vo.B2BMobileConfigurationVO;
import com.classplus.mobile.util.ClassplusConstants;
import com.classplusapp.base.test.ClassplusBaseMobileAutomationTest;
import com.classplusapp.login.pages.ClassplusMobileLoginPage;
import com.classplusapp.login.pages.ClassplusWebLoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login")
@Feature("Tutor Login")
public class ClassplusMobileLoginTest extends ClassplusBaseMobileAutomationTest {
	private static final Logger logger = LogManager.getLogger(ClassplusMobileLoginTest.class);
	ClassplusMobileLoginPage tutorLoginPage = null;

	@BeforeClass
	@Parameters({ "deviceName_one", "udid_one", "platformName_one", "platformVersion_one", "url","clientApiKey","browser"})
	public void initClass(String deviceName_one, String udid_one, String platformName_one, String platformVersion_one,String url,String clientApiKey,String browser,String otp) throws Exception {
		logger.info("Starting of LoginClass method in LoginTest");

		B2BMobileConfigurationVO mobileConfigurationVO = new B2BMobileConfigurationVO(deviceName_one, udid_one, platformName_one,platformVersion_one,clientApiKey);
		this.getWebDriver(browser);
		this.initMobileDriver(mobileConfigurationVO,url);
		this.tutorLoginPage.loginToClassplusUsingMobileNumber(TUTOR_NUMBER, otp);

		this.tutorLoginPage = new ClassplusMobileLoginPage(this.getMobileDriver(udid_one));

		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Change Environment in CLP-Staging")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify Change Environment in CLP-Staging")
	@Story("Verify Change Environment in CLP-Staging")
	public void testChangeEnvironment() {
		logger.info("Starting of testChangeEnvironment method ");

		try {
			tutorLoginPage.clickOnNoneOfTheAbove();
			tutorLoginPage.clickOnImgInfo();
			tutorLoginPage.clickOnChangeEnvironmentButton();
			tutorLoginPage.clickOnNoneOfTheAbove();
			
			// Assertion for LoginOrSignUp Page Title
			String lblLoginOrSignUp = tutorLoginPage.getLblLoginOrSignUpText();
			Assert.assertEquals(lblLoginOrSignUp, expectedAssertionsProp.getProperty(ClassplusConstants.LOGIN_OR_SIGNUP_TXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Change Environment : " + e.getMessage());
			logger.error("Error occured while testing Change Environment ", e);
		}

		logger.info("Ending of testChangeEnvironment method");
	}

	@Test(priority = 2, description = " Verify Login With Valid Number in Login or SignUp Page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:  Verify Login With Valid Number in Login or SignUp Page")
	@Story("Verify Login With Valid Number in Login or SignUp")
	public void testLoginWithValidNumber() {
		logger.info("Starting of testLoginWithValidNumber method");

		try {
			tutorLoginPage.setMobileNumber(TUTOR_NUMBER);

			// Assertion for Verify Your Mobile Number Page Title
			String lblverifyNumber = tutorLoginPage.getLblVerifyNumberText();
			Assert.assertEquals(lblverifyNumber, expectedAssertionsProp.getProperty(ClassplusConstants.VERIFY_YOUR_MOBILE_NUMBER_TXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing  Login With Valid Number : " + e.getMessage());
			logger.error("Error occured while testing Login With Valid Number", e);
		}

		logger.info("Ending of testLoginWithValidNumber method");
	}

	
	@Test(priority = 3, description = "Verify OTP")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify OTP")
	@Story("Verify OTP")
	public void testVerifyOTP() {
		logger.info("Starting of testVerifyOTP method");

		try {
			tutorLoginPage.setOTP(testDataProp.getProperty("otp.text"));

			// Assertion for CongratesInfo PopUp Page Info
			String lblCongratesInfoPopUp = tutorLoginPage.getLblPopUpDescriptionText();
			Assert.assertEquals(lblCongratesInfoPopUp, expectedAssertionsProp.getProperty(ClassplusConstants.CONGRATES_INFO_POPUP_TXT));

			tutorLoginPage.clickOnCloseButton();

			// Assertion for btnClose in PopUp Page Info
			String btnClose = tutorLoginPage.getLblHomeTitleText();
			Assert.assertEquals(btnClose, expectedAssertionsProp.getProperty("homePage.title"));
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Verify OTP : " + e.getMessage());
			logger.error("Error occured while testing  Verify OTP ", e);
		}

		logger.info("Ending of testVerifyOTP method");
	}
	
	@Parameters({ "udid_one" })
	@AfterClass
	public void quitDriver(String udid1) {
		logger.info("Starting of quitDriver method in LoginTest");
		try {
			quitMobileDriver(udid1);
		} catch (Exception e) {
			logger.error("Error occured while testing quitDriver", e);
		}
		logger.info("Ending of quitDriver method in LoginTest"); 
	}
}

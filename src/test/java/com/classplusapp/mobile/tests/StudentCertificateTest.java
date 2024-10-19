package com.classplusapp.mobile.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.vo.B2BMobileConfigurationVO;
import com.classplusapp.common.StoreUtility;
import com.classplusapp.login.pages.ClassplusMobileLoginPage;
import com.classplusapp.login.pages.ClassplusWebLoginPage;
import com.classplusapp.mobile.pages.MobileCourseMarkFeaturedPage;
import com.classplusapp.mobile.pages.MobileStudentCertificatePage;
import com.classplusapp.web.pages.ContentPage;
import com.classplusapp.web.pages.CourseOverviewPage;
import com.classplusapp.web.pages.CreateCoursePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login")
@Feature("Tutor Login")
public class StudentCertificateTest extends StoreUtility {
	private static final Logger logger = LogManager.getLogger(StudentCertificateTest.class);
	ClassplusWebLoginPage tutorLoginPage = null;
	MobileCourseMarkFeaturedPage mobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage studentMobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage facultyMobileCourseMarkFeaturedPage = null;

	MobileStudentCertificatePage mobileStudentCertificatePage = null;
	MobileStudentCertificatePage mobileStudentCertificateStudentPage = null;
	MobileStudentCertificatePage mobileFacultyStudentCertificatePage = null;

	CreateCoursePage createCoursePage = null;
	ContentPage contentPage = null;
	CourseOverviewPage courseOverviewPage = null;
	ClassplusMobileLoginPage mobileLoginPage = null;
	ClassplusMobileLoginPage studentMobileLoginPage = null;
	ClassplusMobileLoginPage facultyMobileLoginPage = null;

	@BeforeClass
	@Parameters({ "deviceName_one", "udid_one", "udid_two", "udid_three", "platformName_one", "platformVersion_one",
			"url", "clientApiKey", "browser", "otp", "siteURL" })
	public void initClass(String deviceName_one, String udid_one, String udid_two, String udid_three,
			String platformName_one, String platformVersion_one, String url, String clientApiKey, String browser,
			String otp, String siteURL) throws Exception {
		logger.info("Starting of LoginClass method in LoginTest");

		B2BMobileConfigurationVO mobileConfigurationVO = new B2BMobileConfigurationVO(deviceName_one, udid_one,
				platformName_one, platformVersion_one, clientApiKey);

		B2BMobileConfigurationVO mobileConfigurationVO1 = new B2BMobileConfigurationVO(deviceName_one, udid_two,
				platformName_one, platformVersion_one, clientApiKey);

		B2BMobileConfigurationVO mobileConfigurationVO2 = new B2BMobileConfigurationVO(deviceName_one, udid_three,
				platformName_one, platformVersion_one, clientApiKey);

		web_driver = this.getWebDriver(browser);
		this.initMobileDriver(mobileConfigurationVO, url);

		this.initMobileDriver(mobileConfigurationVO1, url);
		this.initMobileDriver(mobileConfigurationVO2, url);

		mobileLoginPage = new ClassplusMobileLoginPage(this.getMobileDriver(udid_one));
		studentMobileLoginPage = new ClassplusMobileLoginPage(this.getMobileDriver(udid_two));
		facultyMobileLoginPage = new ClassplusMobileLoginPage(this.getMobileDriver(udid_three));

		tutorLoginPage = new ClassplusWebLoginPage(web_driver);
		// Tutor login from web
		this.loginToApplication(tutorLoginPage, web_driver, ORG_CODE, tutorMobileNumber, emailAddress, "1234", siteURL);
		// Tutor login from mobile
		mobileLoginPage.loginToClassplusUsingMobileNumber(TUTOR_NUMBER, otp);
		this.tutorLoginPage = new ClassplusWebLoginPage(this.getMobileDriver(udid_one));
		this.mobileCourseMarkFeaturedPage = new MobileCourseMarkFeaturedPage(this.getMobileDriver(udid_one));
		// Student login from mobile

		mobileLoginPage.loginToClassplusUsingMobileNumber(STUDENT_NUMBER, otp);
		this.studentMobileCourseMarkFeaturedPage = new MobileCourseMarkFeaturedPage(this.getMobileDriver(udid_two)); // Faculty
		// login from mobile
		mobileLoginPage.loginToClassplusUsingMobileNumber(FACULTY_NUMBER, otp);
		this.facultyMobileCourseMarkFeaturedPage = new MobileCourseMarkFeaturedPage(this.getMobileDriver(udid_three));

		this.mobileStudentCertificatePage = new MobileStudentCertificatePage(this.getMobileDriver(udid_one));
		this.mobileFacultyStudentCertificatePage = new MobileStudentCertificatePage(this.getMobileDriver(udid_one));
		this.mobileStudentCertificateStudentPage = new MobileStudentCertificatePage(this.getMobileDriver(udid_one));

		this.createCoursePage = new CreateCoursePage(web_driver);
		this.contentPage = new ContentPage(web_driver);
		this.courseOverviewPage = new CourseOverviewPage(web_driver);

		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify that tutor is able to see student certification course at Store tab in mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor is able to see student certification course at Store tab in mobile")
	@Story("Verify that tutor is able to see student certification course at Store tab in mobile")
	public void testStudentCertificationCourse() {
		logger.info("Starting of testStudentCertificationCourse method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
					testDataProp.getProperty("course.student.certificate"), true,
					testDataProp.getProperty("course.30days.after.purchase"));
			createCoursePage.clickOnTermsAndConditionCheckBox();

			mobileCourseMarkFeaturedPage.clickOnStoreTab();
			mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertTrue(mobileStudentCertificatePage.isDisplayedRedStarMark());

			Assert.assertEquals(mobileStudentCertificatePage.getCourseCertificateAvailableLabel(),
					expectedAssertionsProp.getProperty("label.course.certification.available"));

			courseOverviewPage.clickOnOverviewLeftPanel();

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that tutor is able to see student certification course at Store tab in mobile : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that tutor is able to see student certification course at Store tab in mobile ",
					e);
		}

		logger.info("Ending of testStudentCertificationCourse method");
	}

	@Test(priority = 2, description = "Verify that tutor is able to see course certification label in overview screen")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor is able to see course certification label in overview screen")
	@Story("Verify that tutor is able to see course certification label in overview screen")
	public void testStudentCertificationCourseInOverviewScreen() {
		logger.info("Starting of testStudentCertificationCourseInOverviewScreen method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
					testDataProp.getProperty("course.student.certificate"), true,
					testDataProp.getProperty("course.30days.after.purchase"));
			createCoursePage.clickOnTermsAndConditionCheckBox();
			mobileCourseMarkFeaturedPage.clickOnStoreTab();
			mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
			mobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertEquals(mobileStudentCertificatePage.getOverviewLabel(),
					expectedAssertionsProp.getProperty("label.course.overview"));

			Assert.assertEquals(mobileStudentCertificatePage.getCertificationAvailableLabel(),
					expectedAssertionsProp.getProperty("label.course.certification.available"));

			courseOverviewPage.clickOnOverviewLeftPanel();
			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that tutor is able to see course certification label in overview screen : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that tutor is able to see course certification label in overview screen ",
					e);
		}

		logger.info("Ending of testStudentCertificationCourseInOverviewScreen method");
	}

	@Test(priority = 3, description = "Verify that tutor is not able to see student certification course at Store tab and overview screen in mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor is not able to see student certification course at Store tab and overview screen in mobile")
	@Story("Verify that tutor is not able to see student certification course at Store tab and overview screen in mobile")
	public void testNotAbleToSeeStudentCertificationCourse() {
		logger.info("Starting of testNotAbleToSeeStudentCertificationCourse method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"), "",
					true, "");
			createCoursePage.clickOnTermsAndConditionCheckBox();
			mobileCourseMarkFeaturedPage.clickOnStoreTab();
			mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertFalse(mobileStudentCertificatePage.isDisplayedRedStarMark());

			Assert.assertFalse(mobileStudentCertificatePage.isDisplayedCertificateAvailable());

			courseOverviewPage.clickOnOverviewLeftPanel();
			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that tutor is not able to see student certification course at Store tab and overview screen in mobile : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that tutor is not able to see student certification course at Store tab and overview screen in mobile ",
					e);
		}

		logger.info("Ending of testNotAbleToSeeStudentCertificationCourse method");
	}

	@Test(priority = 4, description = "Verify that faculty is able to see studentcertification course at Store tab in mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that faculty is able to see student certification course at Store tab in mobile")
	@Story("Verify that faculty is able to see student certification course at Store tab in mobile")
	public void testStudentCertificationCourseAtFacultyEnd() {
		logger.info("Starting of testStudentCertificationCourseAtFacultyEnd method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
					testDataProp.getProperty("course.student.certificate"), true,
					testDataProp.getProperty("course.30days.after.purchase"));
			createCoursePage.clickOnTermsAndConditionCheckBox();
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			super.addFacultyToCourse(courseOverviewPage);

			facultyMobileCourseMarkFeaturedPage.clickOnStoreTab();
			facultyMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertTrue(mobileFacultyStudentCertificatePage.isDisplayedRedStarMark());

			Assert.assertEquals(mobileFacultyStudentCertificatePage.getCourseCertificateAvailableLabel(),
					expectedAssertionsProp.getProperty("label.course.certification.available"));

			courseOverviewPage.clickOnOverviewLeftPanel();
			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that faculty is able to see student certification course at Store tab in mobile : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that faculty is able to see student certification course at Store tab in mobile ",
					e);
		}

		logger.info("Ending of testStudentCertificationCourseAtFacultyEnd method");
	}

	@Test(priority = 5, description = "Verify that faculty is able to see course certification label in overview screen")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that faculty is able to see course certification label in overview screen")
	@Story("Verify that faculty is able to see course certification label in overview screen")
	public void testStudentCertificationCourseInFacultyOverviewScreen() {
		logger.info("Starting of testStudentCertificationCourseInFacultyOverviewScreen method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
					testDataProp.getProperty("course.student.certificate"), true,
					testDataProp.getProperty("course.30days.after.purchase"));
			createCoursePage.clickOnTermsAndConditionCheckBox();
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			super.addFacultyToCourse(courseOverviewPage);

			facultyMobileCourseMarkFeaturedPage.clickOnStoreTab();
			facultyMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
			facultyMobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertEquals(mobileFacultyStudentCertificatePage.getOverviewLabel(),
					expectedAssertionsProp.getProperty("label.course.overview"));

			Assert.assertEquals(mobileFacultyStudentCertificatePage.getCertificationAvailableLabel(),
					expectedAssertionsProp.getProperty("label.course.certification.available"));

			courseOverviewPage.clickOnOverviewLeftPanel();

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that faculty is able to see course certification label in overview screen : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that faculty is able to see course certification label in overview screen ",
					e);
		}

		logger.info("Ending of testStudentCertificationCourseInFacultyOverviewScreen method");
	}

	@Test(priority = 6, description = "Verify that faculty is not able to see student certification course at Store tab and overview screen in mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that faculty is not able to see student certification course at Store tab and overview screen in mobile")
	@Story("Verify that faculty is not able to see student certification course at Store tab and overview screen in mobile")
	public void testNotAbleToSeeStudentCertificationCourseAtFacultyEnd() {
		logger.info("Starting of testNotAbleToSeeStudentCertificationCourseAtFacultyEnd method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"), "",
					true, "");
			createCoursePage.clickOnTermsAndConditionCheckBox();
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			super.addFacultyToCourse(courseOverviewPage);
			mobileCourseMarkFeaturedPage.clickOnStoreTab();
			mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertFalse(mobileFacultyStudentCertificatePage.isDisplayedRedStarMark());

			Assert.assertFalse(mobileFacultyStudentCertificatePage.isDisplayedCertificateAvailable());

			courseOverviewPage.clickOnOverviewLeftPanel();

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that faculty is not able to see student certification course at Store tab and overview screen in mobile : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that faculty is not able to see student certification course at Store tab and overview screen in mobile ",
					e);
		}

		logger.info("Ending of testNotAbleToSeeStudentCertificationCourseAtFacultyEnd method");
	}

	@Test(priority = 7, description = "Verify that student is able to see course certification in overview screen")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that student is able to see course certification in overview screen")
	@Story("Verify that student is able to see course certification in overview screen")
	public void testStudentCertificationAtStudentEnd() {
		logger.info("Starting of testStudentCertificationAtStudentEnd method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
					testDataProp.getProperty("course.student.certificate"), true,
					testDataProp.getProperty("course.30days.after.purchase"));
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();

			studentMobileCourseMarkFeaturedPage.clickOnStoreTab();
			studentMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
			studentMobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertEquals(mobileStudentCertificateStudentPage.getWhatElseCardLabels(),
					this.getPropertyList(expectedAssertionsProp.getProperty("label.what.else.card.text")));

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that student is able to see course certification in overview screen : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that student is able to see course certification in overview screen ",
					e);
		}

		logger.info("Ending of testCourseMarkFeature method");
	}

	@Test(priority = 8, description = "Verify that student is not able to see certification in overview screen")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:Verify that student is not able to see course certification in overview screen")
	@Story("Verify that student is not able to see course certification in overview screen")
	public void testNotAbleToSeeStudentCertificationAtStudentEnd() {
		logger.info("Starting of testCourseMarkFeature method ");

		try {
			String courseName = "TestAutomationCourse" + System.currentTimeMillis();
			String description = "TestAutomationDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			super.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
					testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
					testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false,
					"", "", "", testDataProp.getProperty("course.live.classes"),
					testDataProp.getProperty("course.web.video"), testDataProp.getProperty("course.video.restrictions"),
					testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"), "",
					true, "");
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			studentMobileCourseMarkFeaturedPage.clickOnStoreTab();
			studentMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
			studentMobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertFalse(mobileStudentCertificateStudentPage.isDisplayedWhatElseCardLabels());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that student is not able to see course certification in overview screen : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing that student is not able to see course certification in overview screen ",
					e);
		}

		logger.info("Ending of testCourseMarkFeature method");
	}

	@Parameters({ "udid_one", "udid_two", "udid_three" })
	@AfterClass
	public void quitDriver(String udid_one, String udid_two, String udid_three) {
		logger.info("Starting of quitDriver method ");
		try {
			this.mobileLoginPage.clickOnSignOut();
			this.studentMobileLoginPage.clickOnSignOut();
			this.facultyMobileLoginPage.clickOnSignOut();

			quitMobileDriver(udid_one);
			quitMobileDriver(udid_two);
			quitMobileDriver(udid_three);
		} catch (Exception e) {
			logger.error("Error occured while testing quitDriver", e);
		}
		logger.info("Ending of quitDriver method ");
	}

}

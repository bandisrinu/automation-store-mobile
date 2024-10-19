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
import com.classplusapp.mobile.pages.MobilePhysicalDeliveryPage;
import com.classplusapp.mobile.pages.MobileStudentCertificatePage;
import com.classplusapp.web.pages.ContentPage;
import com.classplusapp.web.pages.CourseOverviewPage;
import com.classplusapp.web.pages.CreateCoursePage;
import com.classplusapp.web.pages.InstallmentsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login")
@Feature("Tutor Login")
public class PhysicalDeliveryTest extends StoreUtility {
	private static final Logger logger = LogManager.getLogger(PhysicalDeliveryTest.class);
	ClassplusWebLoginPage tutorLoginPage = null;
	MobileCourseMarkFeaturedPage mobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage studentMobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage facultyMobileCourseMarkFeaturedPage = null;

	MobilePhysicalDeliveryPage mobilePhysicalDeliveryPage = null;
	MobilePhysicalDeliveryPage mobileStudentPhysicalDeliveryPage = null;
	MobilePhysicalDeliveryPage mobileFacultyPhysicalDeliveryPage = null;

	CreateCoursePage createCoursePage = null;
	ContentPage contentPage = null;
	CourseOverviewPage courseOverviewPage = null;
	InstallmentsPage installmentsPage = null;

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
		this.mobilePhysicalDeliveryPage = new MobilePhysicalDeliveryPage(this.getMobileDriver(udid_one));
		this.mobileFacultyPhysicalDeliveryPage = new MobilePhysicalDeliveryPage(this.getMobileDriver(udid_one));
		this.mobileStudentPhysicalDeliveryPage = new MobilePhysicalDeliveryPage(this.getMobileDriver(udid_one));

		this.createCoursePage = new CreateCoursePage(web_driver);
		this.contentPage = new ContentPage(web_driver);
		this.courseOverviewPage = new CourseOverviewPage(web_driver);
		this.installmentsPage = new InstallmentsPage(web_driver);

		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Physical delivery tag displayed on tutor/student /faculty end at mobile side ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:Verify Physical delivery tag displayed on tutor/student /faculty end at mobile side ")
	@Story("Verify Physical delivery tag displayed on tutor/student /faculty end at mobile side ")
	public void testPhysicalDeliveryTag() {
		logger.info("Starting of testPhysicalDeliveryTag method ");

		try {
			String courseName = "TestPhysicalDeliveryCourse" + System.currentTimeMillis();
			String description = "TestPhysicalDeliveryDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			this.createCourse(createCoursePage, courseName,
					testDataProp.getProperty("physical.delivery.course.description"),
					testDataProp.getProperty("bankexam.category"), testDataProp.getProperty("ibps.subcategory"),
					testDataProp.getProperty("announcement.course.price"),
					testDataProp.getProperty("announcement.course.discount"), "", "", false, "", "", "", "", false, "",
					testDataProp.getProperty("course.offline.shipment"), true, "", "", "", "", "", "", "", "", "",
					false, "");
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

			Assert.assertTrue(mobilePhysicalDeliveryPage.isDisplayedPhysicalMaterialTag());

			mobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertEquals(mobilePhysicalDeliveryPage.getOfflineShipmentLabel(),
					expectedAssertionsProp.getProperty("label.offline.shipment"));

			super.selectCourseAtMobileEnd(studentMobileCourseMarkFeaturedPage, courseName);

			Assert.assertEquals(mobileStudentPhysicalDeliveryPage.getPhysicalMaterialLabel(),
					expectedAssertionsProp.getProperty("label.physical.material"));

			Assert.assertEquals(mobileStudentPhysicalDeliveryPage.getOfflineShipmentLabel(),
					expectedAssertionsProp.getProperty("label.offline.shipment"));

			facultyMobileCourseMarkFeaturedPage.clickOnStoreTab();
			facultyMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertEquals(mobileFacultyPhysicalDeliveryPage.getPhysicalMaterialLabel(),
					expectedAssertionsProp.getProperty("label.physical.material"));

			facultyMobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertEquals(mobileFacultyPhysicalDeliveryPage.getOfflineShipmentLabel(),
					expectedAssertionsProp.getProperty("label.offline.shipment"));

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that Physical delivery tag displayed on tutor/student /faculty end at mobile side  : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that Physical delivery tag displayed on tutor/student /faculty end at mobile side  ",
					e);
		}

		logger.info("Ending of testPhysicalDeliveryTag method");
	}

	@Test(priority = 2, description = "Verify Tentative Days Visible at mobile end if tutor/student/faculty check the tentative days in mobile  ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:Verify Tentative Days Visible at mobile end if tutor/student/faculty check the tentative days in mobile  ")
	@Story("Verify Tentative Days Visible at mobile end if tutor/student/faculty check the tentative days in mobile  ")
	public void testTentavtiveDeliveryDays() {
		logger.info("Starting of testTentavtiveDeliveryDays method ");

		try {
			String courseName = "TestPhysicalDeliveryCourse" + System.currentTimeMillis();
			String description = "TestPhysicalDeliveryDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			this.createCourse(createCoursePage, courseName,
					testDataProp.getProperty("physical.delivery.course.description"),
					testDataProp.getProperty("bankexam.category"), testDataProp.getProperty("ibps.subcategory"),
					testDataProp.getProperty("announcement.course.price"),
					testDataProp.getProperty("announcement.course.discount"), "", "", false, "", "", "", "", false, "",
					testDataProp.getProperty("course.offline.shipment"), true, "", "", "", "", "", "", "", "", "",
					false, "");
			createCoursePage.clickOnTermsAndConditionCheckBox();
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			super.addFacultyToCourse(courseOverviewPage);

			super.selectCourseAtMobileEnd(mobileCourseMarkFeaturedPage, courseName);
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobilePhysicalDeliveryPage.clickOnEditCourseDetailsButton();
			mobilePhysicalDeliveryPage.clickOnTentativeDeliveryCheckBox();
			mobilePhysicalDeliveryPage.clickOnSaveChangesButton();

			Assert.assertEquals(mobilePhysicalDeliveryPage.getTentativeDeliveryLabel(),
					expectedAssertionsProp.getProperty("label.tentative.delivery.3days"));

			courseOverviewPage.clickOnOverviewLeftPanel();

			Assert.assertEquals(courseOverviewPage.getOfflineMaterialShipmentIndicator(),
					expectedAssertionsProp.getProperty("on.indicator.physical.material"));

			Assert.assertEquals(courseOverviewPage.getTenativeDeliveryLabel(),
					expectedAssertionsProp.getProperty("label.tentativedays.text"));

			super.selectCourseAtMobileEnd(studentMobileCourseMarkFeaturedPage, courseName);

			Assert.assertEquals(mobileStudentPhysicalDeliveryPage.getWhatElseCardLabels(),
					this.getPropertyList(expectedAssertionsProp.getProperty("label.tentative.delivery.text")));

			super.selectCourseAtMobileEnd(facultyMobileCourseMarkFeaturedPage, courseName);

			Assert.assertEquals(mobileFacultyPhysicalDeliveryPage.getOfflineShipmentLabel(),
					expectedAssertionsProp.getProperty("label.offline.shipment"));

			Assert.assertEquals(mobilePhysicalDeliveryPage.getTentativeDeliveryLabel(),
					expectedAssertionsProp.getProperty("label.tentative.delivery.3days"));

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that Tentative Days Visible at mobile end if tutor/student/faculty check the tentative days in mobile  : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that Tentative Days Visible at mobile end if tutor/student/faculty check the tentative days in mobile  ",
					e);
		}

		logger.info("Ending of testTentavtiveDeliveryDays method");
	}

	@Test(priority = 3, description = "Verify Physical Delivery Tag removed at mobile end if tutor/student/faculty off the shipment toggle  ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:Verify Physical Delivery Tag removed at mobile end if tutor/student/faculty off the shipment toggle   ")
	@Story("Verify Physical Delivery Tag removed at mobile end if tutor/student/faculty off the shipment toggle  ")
	public void testUnableToSeePhysicalDeliveryTag() {
		logger.info("Starting of testUnableToSeePhysicalDeliveryTag method ");

		try {
			String courseName = "TestPhysicalDeliveryCourse" + System.currentTimeMillis();
			String description = "TestPhysicalDeliveryDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			this.createCourse(createCoursePage, courseName,
					testDataProp.getProperty("physical.delivery.course.description"),
					testDataProp.getProperty("bankexam.category"), testDataProp.getProperty("ibps.subcategory"),
					testDataProp.getProperty("announcement.course.price"),
					testDataProp.getProperty("announcement.course.discount"), "", "", false, "", "", "", "", false, "",
					testDataProp.getProperty("course.offline.shipment"), true, "", "", "", "", "", "", "", "", "",
					false, "");
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
			mobileCourseMarkFeaturedPage.clickOnCourseSelect();
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobilePhysicalDeliveryPage.clickOnEditCourseDetailsButton();
			mobilePhysicalDeliveryPage.clickOnOfflineShipmentToggle();
			mobilePhysicalDeliveryPage.clickOnSaveChangesButton();

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getToastdMessage(),
					expectedAssertionsProp.getProperty("course.updated.message"));

			Assert.assertFalse(mobilePhysicalDeliveryPage.isDisplayedOfflineShipment());

			super.selectCourseAtMobileEnd(studentMobileCourseMarkFeaturedPage, courseName);

			Assert.assertFalse(mobileStudentPhysicalDeliveryPage.isDisplayedWhatElseCardLabels());

			super.selectCourseAtMobileEnd(facultyMobileCourseMarkFeaturedPage, courseName);

			Assert.assertFalse(mobileFacultyPhysicalDeliveryPage.isDisplayedOfflineShipment());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that Physical Delivery Tag removed at mobile end if tutor/student/faculty off the shipment toggle   : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that Physical Delivery Tag removed at mobile end if tutor/student/faculty off the shipment toggle   ",
					e);
		}

		logger.info("Ending of testUnableToSeePhysicalDeliveryTag method");
	}

	@Test(priority = 4, description = "Verify Physical delivery tag displayed on tutorStudent/Faculty end at mobile side when tutor edit at mobile end ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description:Verify Physical delivery tag displayed on tutorStudent/Faculty end at mobile side when tutor edit at mobile end")
	@Story("Verify Physical delivery tag displayed on tutorStudent/Faculty end at mobile side when tutor edit at mobile end")
	public void testPhysicalDeliveryTagOnEditScreen() {
		logger.info("Starting of testPhysicalDeliveryTagOnEditScreen method ");

		try {
			String courseName = "TestPhysicalDeliveryCourse" + System.currentTimeMillis();
			String description = "TestPhysicalDeliveryDescription" + System.currentTimeMillis();

			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			this.createCourse(createCoursePage, courseName,
					testDataProp.getProperty("physical.delivery.course.description"),
					testDataProp.getProperty("bankexam.category"), testDataProp.getProperty("ibps.subcategory"),
					testDataProp.getProperty("announcement.course.price"),
					testDataProp.getProperty("announcement.course.discount"), "", "", false, "", "", "", "", false, "",
					testDataProp.getProperty("course.offline.shipment"), true, "", "", "", "", "", "", "", "", "",
					false, "");
			createCoursePage.clickOnTermsAndConditionCheckBox();
			super.addCourseContent(contentPage, "", "", "", "", "", "", "", "", "Document",
					"TestDocument" + System.currentTimeMillis(), "TestDescription" + System.currentTimeMillis(),
					"contentdocument.pdf", "", "", "", "", "");
			courseOverviewPage.clickOnOverviewLeftPanel();
			super.createInstallment(courseOverviewPage, installmentsPage);
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			super.addFacultyToCourse(courseOverviewPage);

			mobileCourseMarkFeaturedPage.clickOnStoreTab();
			mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertFalse(mobilePhysicalDeliveryPage.isDisplayedPhysicalMaterialTag());

			mobileCourseMarkFeaturedPage.clickOnCourseSelect();
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobilePhysicalDeliveryPage.clickOnEditCourseDetailsButton();
			mobilePhysicalDeliveryPage.clickOnOfflineShipmentToggle();

			Assert.assertEquals(mobilePhysicalDeliveryPage.getRemovedInstallmentsLabel(),
					expectedAssertionsProp.getProperty("label.removed.installments"));

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that Physical delivery tag displayed on tutorStudent/Faculty end at mobile side when tutor edit at mobile end  : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that Physical delivery tag displayed on tutorStudent/Faculty end at mobile side when tutor edit at mobile end   ",
					e);
		}

		logger.info("Ending of testPhysicalDeliveryTagOnEditScreen method");
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

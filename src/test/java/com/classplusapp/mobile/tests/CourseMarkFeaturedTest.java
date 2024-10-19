package com.classplusapp.mobile.tests;

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
import com.classplusapp.common.StoreUtility;
import com.classplusapp.login.pages.ClassplusMobileLoginPage;
import com.classplusapp.login.pages.ClassplusWebLoginPage;
import com.classplusapp.mobile.pages.MobileCourseMarkFeaturedPage;
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
public class CourseMarkFeaturedTest extends StoreUtility {
	private static final Logger logger = LogManager.getLogger(CourseMarkFeaturedTest.class);
	ClassplusWebLoginPage tutorLoginPage = null;
	MobileCourseMarkFeaturedPage mobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage studentMobileCourseMarkFeaturedPage = null;
	MobileCourseMarkFeaturedPage facultyMobileCourseMarkFeaturedPage = null;
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
		this.studentMobileCourseMarkFeaturedPage = new MobileCourseMarkFeaturedPage(this.getMobileDriver(udid_two));
		// Faculty login from mobile
		mobileLoginPage.loginToClassplusUsingMobileNumber(FACULTY_NUMBER, otp);
		this.facultyMobileCourseMarkFeaturedPage = new MobileCourseMarkFeaturedPage(this.getMobileDriver(udid_three));

		this.createCoursePage = new CreateCoursePage(web_driver);
		this.contentPage = new ContentPage(web_driver);
		this.courseOverviewPage = new CourseOverviewPage(web_driver);

		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify that tutor can mark a course featured from mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor can mark a course featured from mobile")
	@Story("Verify that tutor can mark a course featured from mobile")
	public void testCourseMarkFeature() {
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
			super.selectCourseAtMobileEnd(mobileCourseMarkFeaturedPage, courseName);
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobileCourseMarkFeaturedPage.clickOnMarkAsFeaturedButton();

			Assert.assertTrue(mobileCourseMarkFeaturedPage.isDisplayedStarMark());

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getToastdMessage(),
					expectedAssertionsProp.getProperty("course.markfeatured.message"));

			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getFeaturedCourse(),
					expectedAssertionsProp.getProperty("label.course.unmarkfeatured"));

			mobileCourseMarkFeaturedPage.clickOnCourseCancelButton();
			mobileCourseMarkFeaturedPage.hardBack();
			Assert.assertTrue(mobileCourseMarkFeaturedPage.isDisplayedStarMark());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing that tutor can mark a course featured from mobile : "
					+ e.getMessage());
			logger.error("Error occured while testing  that tutor can mark a course featured from mobile ", e);
		}

		logger.info("Ending of testCourseMarkFeature method");
	}

	@Test(priority = 2, description = "Verify that tutor can unmark a course featured from mobile")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor can unmark a course featured from mobile")
	@Story("Verify that tutor can unmark a course featured from mobile")
	public void testCourseUnMarkFeature() {
		logger.info("Starting of testCourseUnMarkFeature method ");

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
			super.selectCourseAtMobileEnd(mobileCourseMarkFeaturedPage, courseName);
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobileCourseMarkFeaturedPage.clickOnMarkAsFeaturedButton();
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobileCourseMarkFeaturedPage.clickOnMarkAsFeaturedButton();

			Assert.assertFalse(mobileCourseMarkFeaturedPage.isDisplayedStarMark());

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getToastdMessage(),
					expectedAssertionsProp.getProperty("course.removed.feature.message"));

			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getFeaturedCourse(),
					expectedAssertionsProp.getProperty("label.course.markfeatured"));

			mobileCourseMarkFeaturedPage.clickOnCourseCancelButton();

			mobileCourseMarkFeaturedPage.hardBack();

			Assert.assertFalse(mobileCourseMarkFeaturedPage.isDisplayedStarMark());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing that tutor can unmark a course featured from mobile : "
					+ e.getMessage());
			logger.error("Error occured while testing that tutor can unmark a course featured from mobile ", e);
		}

		logger.info("Ending of testCourseUnMarkFeature method");
	}

	@Test(priority = 3, description = "Verify that tutor can not mark as featured for unpublished course")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify that tutor can not mark as featured for unpublished course")
	@Story("Verify that tutor can not mark as featured for unpublished course")
	public void testMarkFeaturedForUnPUblishCourse() {
		logger.info("Starting of testMarkFeaturedForUnPUblishCourse method ");

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
			super.selectCourseAtMobileEnd(mobileCourseMarkFeaturedPage, courseName);
			mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			mobileCourseMarkFeaturedPage.clickOnMarkAsFeaturedButton();

			Assert.assertEquals(mobileCourseMarkFeaturedPage.getToastdMessage(),
					expectedAssertionsProp.getProperty("course.feature.inactive.message"));

			courseOverviewPage.clickOnOverviewLeftPanel();
			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing that tutor can not mark as featured for unpublished course : "
					+ e.getMessage());
			logger.error("Error occured while testing that tutor can not mark as featured for unpublished course ", e);
		}

		logger.info("Ending of testMarkFeaturedForUnPUblishCourse method");
	}

	@Test(priority = 4, description = "Verify Student can see the featured courses in featured courses list on Home page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify Student can see the featured courses in featured courses list on Home page")
	@Story("Verify Student can see the featured courses in featured courses list on Home page")
	public void testMarkFeaturedCourseList() {
		logger.info("Starting of testMarkFeaturedCourseList method ");

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
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickDots();
			courseOverviewPage.hardWait(10);
			courseOverviewPage.clickMarkFeatured();
			courseOverviewPage.clickOkayMarkFeatured();

			Assert.assertTrue(studentMobileCourseMarkFeaturedPage.lstFeaturedCourses());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that Student can see the featured courses in featured courses list on Home page : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that Student can see the featured courses in featured courses list on Home page ",
					e);
		}

		logger.info("Ending of testMarkFeaturedCourseList method");
	}

	@Test(priority = 5, description = "Verify course should be updated for Student when tutor can mark as featured/unmark from web ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify course should be updated for Student when tutor can mark as featured/unmark from web ")
	@Story("Verify course should be updated for Student when tutor can mark as featured/unmark from web ")
	public void testCourseUpdatedAtStudentEnd() {
		logger.info("Starting of testCourseUpdatedAtStudentEnd method ");

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
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickDots();
			courseOverviewPage.hardWait(10);
			courseOverviewPage.clickMarkFeatured();
			courseOverviewPage.clickOkayMarkFeatured();

			studentMobileCourseMarkFeaturedPage.clickOnStoreTab();
			studentMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);

			Assert.assertTrue(studentMobileCourseMarkFeaturedPage.isDisplayedCourseSelect());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing that course should be updated for Student when tutor can mark as featured/unmark from web  : "
							+ e.getMessage());
			logger.error(
					"Error occured while testing  that course should be updated for Student when tutor can mark as featured/unmark from web ",
					e);
		}

		logger.info("Ending of testCourseUpdatedAtStudentEnd method");
	}

	@Test(priority = 6, description = "Verify faculty cannot mark/unmark feature course")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Verify faculty cannot mark/unmark feature course ")
	@Story("Verify faculty cannot mark/unmark feature course")
	public void testUnableToMarkCourseAtFacultyEnd() {
		logger.info("Starting of testUnableToMarkCourseAtFacultyEnd method ");

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
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickDots();
			courseOverviewPage.hardWait(10);
			courseOverviewPage.clickMarkFeatured();
			courseOverviewPage.clickOkayMarkFeatured();
			super.addFacultyToCourse(courseOverviewPage);
			facultyMobileCourseMarkFeaturedPage.clickOnStoreTab();
			facultyMobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
			facultyMobileCourseMarkFeaturedPage.clickOnCourseSelect();

			Assert.assertTrue(facultyMobileCourseMarkFeaturedPage.isDisplayedStarMark());

			super.selectCourseAtMobileEnd(facultyMobileCourseMarkFeaturedPage, courseName);

			facultyMobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
			facultyMobileCourseMarkFeaturedPage.clickOnMarkAsFeaturedButton();
			facultyMobileCourseMarkFeaturedPage.refreshPage();
			facultyMobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();

			Assert.assertFalse(facultyMobileCourseMarkFeaturedPage.isDisplayedMarkFeaturedLabel());

			super.testRemoveCourse(courseOverviewPage);

		} catch (Exception e) {
			Assert.fail("Exception occured while testing that faculty cannot mark/unmark feature course  : "
					+ e.getMessage());
			logger.error("Error occured while testing  that faculty cannot mark/unmark feature course ", e);
		}

		logger.info("Ending of testUnableToMarkCourseAtFacultyEnd method");
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
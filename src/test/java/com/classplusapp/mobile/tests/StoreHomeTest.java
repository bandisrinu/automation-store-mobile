package com.classplusapp.mobile.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.vo.B2BMobileConfigurationVO;
import com.classplusapp.common.StoreUtility;
import com.classplusapp.login.pages.ClassplusMobileLoginPage;
import com.classplusapp.login.pages.ClassplusWebLoginPage;
import com.classplusapp.mobile.pages.MobileCourseMarkFeaturedPage;
import com.classplusapp.mobile.pages.StoreHomePage;
import com.classplusapp.web.pages.CourseOverviewPage;
import com.classplusapp.web.pages.CreateCoursePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StoreHomeTest extends StoreUtility {
	private static final Logger logger = LogManager.getLogger(CourseMarkFeaturedTest.class);
	ClassplusWebLoginPage tutorLoginPage = null;
	MobileCourseMarkFeaturedPage courseMarkFeaturedPage = null;
	ClassplusMobileLoginPage mobileLoginPage = null;
	CreateCoursePage createCoursePage = null;
	StoreHomePage tutorStoreHomePage = null;
	StoreHomePage facultyStoreHomePage = null;
	StoreHomePage studentStoreHomePage = null;

	CourseOverviewPage courseOverviewPage = null;

	@BeforeClass
	@Parameters({ "deviceName_one", "udid_one", "udid_two", "udid_three", "platformName_one", "platformVersion_one",
			"url", "clientApiKey", "browser", "otp", "siteURL" })
	public void initClass(@Optional("Galaxy") String deviceName_one, @Optional("RZ8R81QJAFR") String udid_one,
			@Optional("RZ8R81QJAFR") String udid_two, @Optional("RZ8R81QJAFR") String udid_three,
			@Optional("Android") String platformName_one, @Optional("12") String platformVersion_one,
			@Optional("local") String url, @Optional("6746f86b-0d3b-4746-a042-5e9d2beeeeac") String clientApiKey,
			@Optional("chrome") String browser, @Optional("1234") String otp,
			@Optional("https://webp-gcp.classplusapp.com/") String siteURL) throws Exception {
		logger.info("Starting of LoginClass method in LoginTest");

		B2BMobileConfigurationVO mobileConfigurationVO = new B2BMobileConfigurationVO(deviceName_one, udid_one,
				platformName_one, platformVersion_one, clientApiKey);
		this.getWebDriver(browser);
		this.initMobileDriver(mobileConfigurationVO, url);
		mobileLoginPage = new ClassplusMobileLoginPage(this.getMobileDriver(udid_one));
		tutorLoginPage = new ClassplusWebLoginPage(web_driver);
		// Tutor login from web
		this.loginToApplication(tutorLoginPage, web_driver, ORG_CODE, tutorMobileNumber, emailAddress, "1234", siteURL);
		mobileLoginPage.loginToClassplusUsingMobileNumber(TUTOR_NUMBER, otp);
		this.createCoursePage = new CreateCoursePage(web_driver);
		this.tutorLoginPage = new ClassplusWebLoginPage(this.getMobileDriver(udid_one));
		this.tutorStoreHomePage = new StoreHomePage(this.getMobileDriver(udid_one));
		// this.facultyStoreHomePage = new
		// StoreHomePage(this.getMobileDriver(udid_two));
		// this.studentStoreHomePage = new
		// StoreHomePage(this.getMobileDriver(udid_three));

		this.courseOverviewPage = new CourseOverviewPage(web_driver);
		logger.info("Ending of LoginClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Tutor Store Home Page Labels")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Tutor Store Home Page Labels")
	@Story("Verify Tutor Store Home Page Labels")
	public void testTutorStoreHomePageLabels() {
		logger.info("Starting of testTutorStoreHomePageLabels method ");

		try {
			verifyStoreHomePageLabels(tutorStoreHomePage);

			Assert.assertEquals(tutorStoreHomePage.getViewAllCoursesLabel(),
					expectedAssertionsProp.getProperty("view.all.courses.label"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Tutor Store Home Page Labels : " + e.getMessage());
			logger.error("Error occured while testing Tutor Store Home Page Labels ", e);
		}

		logger.info("Ending of testTutorStoreHomePageLabels method");
	}

	@Test(priority = 2, description = "Verify Faculty Store Home Page Labels")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Faculty Store Home Page Labels")
	@Story("Verify Faculty Store Home Page Labels")
	public void testFacultyStoreHomePageLabels() {
		logger.info("Starting of testFacultyStoreHomePageLabels method ");

		try {
			verifyStoreHomePageLabels(facultyStoreHomePage);

			Assert.assertEquals(tutorStoreHomePage.getViewAllCoursesLabel(),
					expectedAssertionsProp.getProperty("view.all.courses.label"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Faculty Store Home Page Labels : " + e.getMessage());
			logger.error("Error occured while testing Faculty Store Home Page Labels ", e);
		}

		logger.info("Ending of testFacultyStoreHomePageLabels method");
	}

	@Test(priority = 3, description = "Verify Search bar At Tutor End")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Search bar At Tutor End")
	@Story("Verify Search bar At Tutor End")
	public void testSearchBarAtTutorEnd() {
		logger.info("Starting of testSearchBarAtTutorEnd method ");

		try {
			verifySearchBar(tutorStoreHomePage);
			Assert.assertTrue(tutorStoreHomePage.isClickableSearchBar());

			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search bar At Tutor End : " + e.getMessage());
			logger.error("Error occured while testing Search bar At Tutor End ", e);
		}

		logger.info("Ending of testSearchBarAtTutorEnd method");
	}

	@Test(priority = 4, description = "Verify Search bar at faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Search bar at faculty end")
	@Story("Verify Search bar at faculty end")
	public void testSearchBarAtFacultyEnd() {
		logger.info("Starting of testSearchBarAtFacultyEnd method ");

		try {
			verifySearchBar(facultyStoreHomePage);
			Assert.assertTrue(tutorStoreHomePage.isClickableSearchBar());

			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Search bar at faculty end : " + e.getMessage());
			logger.error("Error occured while testing Search bar at faculty end ", e);
		}

		logger.info("Ending of testSearchBarAtFacultyEnd method");
	}

	@Test(priority = 5, description = "Verify Functionality Of Search bar at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at tutor end")
	@Story("Verify Functionality Of Search bar at tutor end")
	public void testFunctionalityOfSearchBarOnStoreTabAtTutorEnd() {
		logger.info("Starting of testFunctionalityOfSearchBarAtTutorEnd method ");

		try {
			verifyFunctionalityOfSearchBar(tutorStoreHomePage);

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesListAfterClickingOnSearch());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Functionality Of Search bar at tutor end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at tutor end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarAtTutorEnd method");
	}

	@Test(priority = 6, description = "Verify Functionality Of Search bar at Faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at Faculty end")
	@Story("Verify Functionality Of Search bar at Faculty end")
	public void testFunctionalityOfSearchBarOnStoreTabAtFacultyEnd() {
		logger.info("Starting of testFunctionalityOfSearchBarAtFacultyEnd method ");

		try {
			verifyFunctionalityOfSearchBar(facultyStoreHomePage);

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesListAfterClickingOnSearch());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Functionality Of Search bar at Faculty end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at Faculty end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarAtFacultyEnd method");
	}

	@Test(priority = 7, description = "Verify Functionality Of Search bar In my courses section at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at tutor end")
	@Story("Verify Functionality Of Search bar at tutor end")
	public void testFunctionalityOfSearchBarInMyCoursesScreenAtTutorEnd() {
		logger.info("Starting of testFunctionalityOfSearchBarInMyCoursesScreenAtTutorEnd method ");

		try {
			String courseName = functionalityOfSearchBarInMyCoursesScreen(tutorStoreHomePage, createCoursePage);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Functionality Of Search bar at tutor end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at tutor end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarInMyCoursesScreenAtTutorEnd method");
	}

	@Test(priority = 8, description = "Verify Functionality Of Search bar In my courses section at Faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at Faculty end")
	@Story("Verify Functionality Of Search bar at Faculty end")
	public void testFunctionalityOfSearchBarInMyCoursesScreenAtFacultyEnd() {
		logger.info("Starting of testFunctionalityOfSearchBarInMyCoursesScreenAtFacultyEnd method ");

		try {
			String courseName = functionalityOfSearchBarInMyCoursesScreen(facultyStoreHomePage, createCoursePage);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Functionality Of Search bar at Faculty end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at Faculty end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarInMyCoursesScreenAtFacultyEnd method");
	}

	@Test(priority = 9, description = "Verify Functionality Of Search bar at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at tutor end")
	@Story("Verify Functionality Of Search bar at tutor end")
	public void testFunctionalityOfSearchBarAcceptsSpecialCharactersInMyCoursesScreen() {
		logger.info("Starting of testFunctionalityOfSearchBarAcceptsSpecialCharactersInMyCoursesScreen method ");

		try {
			String courseName = testDataProp.getProperty("store.home.page.course.name.special.characters")
					+ System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name.special.characters")
					+ System.currentTimeMillis();
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

			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnSearchByName(courseName);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Functionality Of Search bar at tutor end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at tutor end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarAcceptsSpecialCharactersInMyCoursesScreen method");
	}

	@Test(priority = 10, description = "Verify sort & filter Labels")
	@Description("Test Description:Verify sort & filter Labels")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify sort & filter Labels")
	public void testSortAndFilterLabels() {
		logger.info("Starting of testSortAndFilterLabels method");

		try {
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnSearchBar();
			tutorStoreHomePage.clickOnFiltersIcon();

			Assert.assertEquals(tutorStoreHomePage.getFiltersLabel(),
					expectedAssertionsProp.getProperty("label.sort.and.filter"));

			Assert.assertEquals(tutorStoreHomePage.getFiltersTypesLabels(),
					this.getPropertyList(expectedAssertionsProp.getProperty("filter.type.labels")));

			Assert.assertEquals(tutorStoreHomePage.getFiltersHeadingsLabels(),
					this.getPropertyList(expectedAssertionsProp.getProperty("filter.heading.labels")));
			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing sort & filter Labels: " + e.getMessage());
			logger.error("Error occured while testing sort & filter Labels ", e);
		}
		logger.info("Ending of testSortAndFilterLabels, method");
	}

	@Test(priority = 11, description = "Verify Functionality of courses filter in sort and filters")
	@Description("Test Description:Verify Functionality of courses filter in sort and filters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Functionality of courses filter in sort and filters")
	public void testFunctionalityOfCoursesFilterInSortAndFilters() {
		logger.info("Starting of testCreatedByMeFilter method");

		try {
			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			getFiltersScreen(tutorStoreHomePage);

			Assert.assertEquals(tutorStoreHomePage.getFiltersLabel(),
					expectedAssertionsProp.getProperty("label.sort.and.filter"));

			tutorStoreHomePage.clickOnFilterCheckBox(testDataProp.getProperty("filters.created.by.me.label"));

			Assert.assertEquals(
					tutorStoreHomePage
							.isSelectedFiltersCheckbox(testDataProp.getProperty("filters.created.by.me.label")),
					expectedAssertionsProp.getProperty("label.true"));

			tutorStoreHomePage.clickOnApplyButton();

			Assert.assertTrue(tutorStoreHomePage
					.getCreatedByYouLabels(testDataProp.getProperty("filters.created.by.you.labels")));

			tutorStoreHomePage.clickOnSearchByName(courseName);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing Functionality of courses filter in sort and filters: "
					+ e.getMessage());
			logger.error("Error occured while testing Functionality of courses filter in sort and filters ", e);
		}

		logger.info("Ending of testCreatedByMeFilter method");
	}

	@Test(priority = 12, description = "Verify Functionality Of Published And UnPublished Filter In Sort And Filters")
	@Description("Test Description:Verify Functionality Of Published And UnPublished Filter In Sort And Filters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Functionality Of Published And UnPublished Filter In Sort And Filters")
	public void testFunctionalityOfPublishedAndUnPublishedFilterInSortAndFilters() {
		logger.info("Starting of testCreatedByMeFilter method");

		try {
			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseAction();
			courseOverviewPage.closePublishModal();
			getFiltersScreen(tutorStoreHomePage);
			tutorStoreHomePage.clickOnFilterCheckBox(testDataProp.getProperty("filters.published.label"));

			Assert.assertEquals(
					tutorStoreHomePage.isSelectedFiltersCheckbox(testDataProp.getProperty("filters.published.label")),
					expectedAssertionsProp.getProperty("label.true"));
			tutorStoreHomePage.clickOnApplyButton();
			tutorStoreHomePage.clickOnSearchByName(courseName);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

			tutorStoreHomePage.clickOnCourseSelect();
			tutorStoreHomePage.clickOnThreeDottedMenuButton();
			Assert.assertEquals(tutorStoreHomePage.getUnPublishCourseLabel(),
					expectedAssertionsProp.getProperty("unpublish.text"));
			for (int i = 0; i <= 1; i++) {
				tutorStoreHomePage.hardBack();
			}
			courseOverviewPage.clickOnOverviewLeftPanel();
			courseOverviewPage.clickPublishCourseBtn();
			courseOverviewPage.clickPublishCourseBtn();

			getFiltersScreen(tutorStoreHomePage);
			tutorStoreHomePage.clickOnFilterCheckBox(testDataProp.getProperty("filters.unpublished.label"));
			tutorStoreHomePage.clickOnApplyButton();

			Assert.assertTrue(
					tutorStoreHomePage.getUnPublishedLabels(testDataProp.getProperty("filters.unpublished.labels")));

			tutorStoreHomePage.clickOnSearchByName(courseName);
			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));
			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Functionality Of Published And UnPublished Filter In Sort And Filters: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing Functionality Of Published And UnPublished Filter In Sort And Filters ",
					e);
		}

		logger.info("Ending of testCreatedByMeFilter method");
	}

	/**
	 * 
	 * 9th manual test case is pending
	 */
	@Test(priority = 13, description = "Verify Functionality Of Sort And Order Filter In Sort And Filters")
	@Description("Test Description:Verify Functionality Of Sort And Order Filter In Sort And Filters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Functionality Of Sort And Order Filter In Sort And Filters")
	public void testFunctionalityOfSortAndOrderFilterInSortAndFilters() {
		logger.info("Starting of testPriceLowToHighCoursesFilter method");

		try {
			super.getFiltersScreen(tutorStoreHomePage);
			tutorStoreHomePage.clickOnSortAndOrderRadioButton(testDataProp.getProperty("filters.low.to.high.course"));

			Assert.assertEquals(
					tutorStoreHomePage
							.isSelectedFiltersCheckbox(testDataProp.getProperty("filters.low.to.high.course")),
					expectedAssertionsProp.getProperty("label.true"));

			tutorStoreHomePage.clickOnApplyButton();

			Assert.assertTrue(tutorStoreHomePage.getLowToHighPriceRangeCourses());

			tutorStoreHomePage.clickOnFiltersIcon();
			tutorStoreHomePage.clickOnSortAndOrderRadioButton(testDataProp.getProperty("filters.high.to.low.course"));

			tutorStoreHomePage.clickOnApplyButton();

			Assert.assertTrue(tutorStoreHomePage.getHighToLowPriceRangeCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Functionality Of Sort And Order Filter In Sort And Filters: "
					+ e.getMessage());
			logger.error("Error occured while testing Functionality Of Sort And Order Filter In Sort And Filters ", e);
		}
		logger.info("Ending of testCreatedByMeFilter method");

	}

	@Test(priority = 14, description = "Verify stats cards")
	@Description("Test Description:Verify stats cards")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify stats cards")
	public void testStatsCards() {
		logger.info("Starting of testStatsCards method");

		try {
			tutorStoreHomePage.clickOnStoreTab();

			Assert.assertTrue(tutorStoreHomePage.isScrollableStatsCards());

			Assert.assertTrue(tutorStoreHomePage
					.isDisplayedNumberOfCards(Integer.parseInt(testDataProp.getProperty("two.stats.cards"))));

			Assert.assertEquals(tutorStoreHomePage.getStatsCardsNames(),
					getPropertyList(expectedAssertionsProp.getProperty("stats.cards.names")));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing stats cards: " + e.getMessage());
			logger.error("Error occured while testing stats cards ", e);
		}
		logger.info("Ending of testStatsCards method");

	}

	@Test(priority = 15, description = "Verify CouponCode Cards")
	@Description("Test Description:Verify CouponCode Cards")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify CouponCode Cards")
	public void testCouponCodeCards() {
		logger.info("Starting of testCouponCodeCards method");

		try {
			tutorStoreHomePage.clickOnStoreTab();

			Assert.assertTrue(tutorStoreHomePage
					.isDisplayedNumberOfCards(Integer.parseInt(testDataProp.getProperty("two.stats.cards"))));

			Assert.assertTrue(tutorStoreHomePage.isScrollableCouponCodeCards());

			Assert.assertTrue(tutorStoreHomePage
					.isDisplayedNumberOfCards(Integer.parseInt(testDataProp.getProperty("ten.stats.cards"))));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing CouponCode Cards: " + e.getMessage());
			logger.error("Error occured while testing CouponCode Cards ", e);
		}

		logger.info("Ending of testCouponCodeCards method");
	}

	@Test(priority = 16, description = "Verify Categories And Sub-Categories")
	@Description("Test Description:Verify Categories And Sub-Categories")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Categories And Sub-Categories")
	public void testCategoriesAndSubCategories() {
		logger.info("Starting of testCategoriesAndSubCategories method");

		try {
			tutorStoreHomePage.clickOnStoreTab();

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCategories());

			Assert.assertTrue(tutorStoreHomePage.isScrollableCategoriesAndSubCategories());

			Assert.assertEquals(tutorStoreHomePage.getViewAllText(),
					expectedAssertionsProp.getProperty("view.all.text"));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Categories And Sub-Categories: " + e.getMessage());
			logger.error("Error occured while testing Categories And Sub-Categories ", e);
		}
		logger.info("Ending of testCategoriesAndSubCategories method");

	}

	@Test(priority = 17, description = "Validate the functionality of  CATEGORIES/SUB-CATEGORIES when tutor click any one category")
	@Description("Test Description:Validate the functionality of  CATEGORIES/SUB-CATEGORIES when tutor click any one category")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate the functionality of  CATEGORIES/SUB-CATEGORIES when tutor click any one category")
	public void testFunctionalityOfCategoriesSubCategoriesWhenTutorClicksAnyOneCategory() {
		logger.info("Starting of testFunctionalityOfCategoriesSubCategoriesWhenTutorClicksAnyOneCategory method");

		try {

			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			tutorStoreHomePage.clickOnStoreTab();

			tutorStoreHomePage.clickOnSelectedCategory(testDataProp.getProperty("bankexam.category"));

			Assert.assertTrue(tutorStoreHomePage.isDisplayedSubCategories());

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesListAfterClickingOnSearch());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing functionality of  CATEGORIES/SUB-CATEGORIES when tutor click any one category: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing functionality of  CATEGORIES/SUB-CATEGORIES when tutor click any one category ",
					e);
		}
		logger.info("Ending of testFunctionalityOfCategoriesSubCategoriesWhenTutorClicksAnyOneCategory method");

	}

	@Test(priority = 18, description = "Validate the functionality of search bar in My Courses Screen when tutor click on any category")
	@Description("Test Description:Validate the functionality of search bar in My Courses Screen when tutor click on any category")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate the functionality of search bar in My Courses Screen when tutor click on any category")
	public void testFunctionalityOfSearchBarInMyCoursesScreenWhenTutorClicksAnyOneCategory() {
		logger.info("Starting of testFunctionalityOfSearchBarInMyCoursesScreenWhenTutorClicksAnyOneCategory method");

		try {

			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnSelectedCategory(testDataProp.getProperty("bankexam.category"));
			tutorStoreHomePage.clickOnSearchByName(courseName);
			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing functionality of search bar in My Courses Screen when tutor click on any category: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing functionality of search bar in My Courses Screen when tutor click on any category ",
					e);
		}
		logger.info("Ending of testFunctionalityOfSearchBarInMyCoursesScreenWhenTutorClicksAnyOneCategory method");
	}

	@Test(priority = 19, description = "Validate the functionality of SUB-CATEGORIES  in My Courses Screen when tutor click on any sub- category")
	@Description("Test Description:Validate the functionality of SUB-CATEGORIES  in My Courses Screen when tutor click on any sub- category")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate the functionality of SUB-CATEGORIES  in My Courses Screen when tutor click on any sub- category")
	public void testFunctionalityOfSubCategoriesInMyCoursesScreenWhenTutorClicksAnyOneCategory() {
		logger.info(
				"Starting of testFunctionalityOfSubCategoriesInMyCoursesScreenWhenTutorClicksAnyOneCategory method");

		try {
			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnSelectedCategory(testDataProp.getProperty("bankexam.category"));
			List<String> coursesListBeforeSelectingSubcategory = tutorStoreHomePage.getCourseNames();

			tutorStoreHomePage.clickOnSelectedSubCategory(testDataProp.getProperty("ibps.subcategory"));

			List<String> coursesListAfterSelectingSubcategory = tutorStoreHomePage.getCourseNames();

			Assert.assertNotEquals(coursesListBeforeSelectingSubcategory, coursesListAfterSelectingSubcategory);

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing functionality of SUB-CATEGORIES  in My Courses Screen when tutor click on any sub- category: "
							+ e.getMessage());
			logger.error(
					"Error occured while testing functionality of SUB-CATEGORIES  in My Courses Screen when tutor click on any sub- category ",
					e);
		}
		logger.info("Ending of testFunctionalityOfSubCategoriesInMyCoursesScreenWhenTutorClicksAnyOneCategory method");
	}

	/**
	 * from here jira tickets 2,4,6,8
	 */
	@Test(priority = 20, description = "Validate VIEW ALL option in CATEGORIES/SUB-CATEGORIES")
	@Description("Test Description:Validate VIEW ALL option in CATEGORIES/SUB-CATEGORIES")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate VIEW ALL option in CATEGORIES/SUB-CATEGORIES")
	public void testViewAllOptionInCategoriesSubCategories() {
		logger.info("Starting of testViewAllOptionInCategoriesSubCategories method");

		try {
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnViewAllInCategoriesAndSubCategories();

			Assert.assertTrue(tutorStoreHomePage.isScrollableCategories());

			Assert.assertTrue(tutorStoreHomePage.isDisplayedSearchCategory());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing VIEW ALL option in CATEGORIES/SUB-CATEGORIES: " + e.getMessage());
			logger.error("Error occured while testing VIEW ALL option in CATEGORIES/SUB-CATEGORIES ", e);
		}
		logger.info("Ending of testViewAllOptionInCategoriesSubCategories method");
	}

	@Test(priority = 21, description = "Validate functionality of search bar in View All option")
	@Description("Test Description:Validate functionality of search bar in View All option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate functionality of search bar in View All option")
	public void testFunctionalityOfSearchBarInViewAllOption() {
		logger.info("Starting of testFunctionalityOfSearchBarInViewAllOption method");

		try {
			createCoursePage.clickOnStoreTab();
			createCoursePage.clickCreateCourseBtn();
			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnViewAllInCategoriesAndSubCategories();

			tutorStoreHomePage.clickOnSelectedSubCategory(testDataProp.getProperty("bankexam.category"));
			tutorStoreHomePage.clickOnSearchByName(courseName);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing functionality of search bar in View All option: "
					+ e.getMessage());
			logger.error("Error occured while testing functionality of search bar in View All option ", e);
		}
		logger.info("Ending of testFunctionalityOfSearchBarInViewAllOption method");
	}

	@Test(priority = 22, description = "Validate functionality of list of categories in View All option")
	@Description("Test Description:Validate functionality of search bar in View All option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate functionality of search bar in View All option")
	public void testFunctionalityOfListOfCategoriesInViewAllOption() {
		logger.info("Starting of testFunctionalityOfListOfCategoriesInViewAllOption method");

		try {
			String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
			String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
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
			tutorStoreHomePage.clickOnStoreTab();
			tutorStoreHomePage.clickOnViewAllInCategoriesAndSubCategories();
			Assert.assertEquals(tutorStoreHomePage.getMyCoursesLabel(),
					expectedAssertionsProp.getProperty("my.courses.label"));

			tutorStoreHomePage.clickOnSelectedSubCategory(testDataProp.getProperty("bankexam.category"));
			tutorStoreHomePage.clickOnSearchByName(courseName);

			Assert.assertTrue(tutorStoreHomePage.getSearchedCourseNameLabel(courseName));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing functionality of search bar in View All option: "
					+ e.getMessage());
			logger.error("Error occured while testing functionality of search bar in View All option ", e);
		}
		logger.info("Ending of testFunctionalityOfListOfCategoriesInViewAllOption method");
	}

	
	
	
	@Test(priority = 23, description = "Validate Courses on Store tab at tutor end")
	@Description("Test Description:Validate Courses on Store tab at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate Courses on Store tab at tutor end")
	public void testCoursesOnStoreTabAtTutorEnd() {
		logger.info("Starting of testCoursesOnStoreTabAtTutorEnd method");

		try {
			tutorStoreHomePage.clickOnStoreTab();

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesList());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Courses on Store tab at tutor end: " + e.getMessage());
			logger.error("Error occured while testing Courses on Store tab at tutor end ", e);
		}
		logger.info("Ending of testCoursesOnStoreTabAtTutorEnd method");
	}

	@Test(priority = 24, description = "Validate Courses on Store tab at faculty end")
	@Description("Test Description:Validate Courses on Store tab at faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate Courses on Store tab at faculty end")
	public void testCoursesOnStoreTabAtFacultyEnd() {
		logger.info("Starting of testCoursesOnStoreTabAtFacultyEnd method");

		try {
			facultyStoreHomePage.clickOnStoreTab();

			Assert.assertTrue(facultyStoreHomePage.isDisplayedCoursesList());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing Courses on Store tab at faculty end: " + e.getMessage());
			logger.error("Error occured while testing Courses on Store tab at faculty end ", e);
		}
		logger.info("Ending of testCoursesOnStoreTabAtFacultyEnd method");
	}

	@Test(priority = 25, description = "validate tags are visible on created courses at tutor end")
	@Description("Test Description:validate tags are visible on created courses at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Story("validate tags are visible on created courses at tutor end")
	public void testTagsAreVisibleOnCreatedCoursesAtTutorEnd() {
		logger.info("Starting of testTagsAreVisibleOnCreatedCoursesAtTutorEnd method");

		try {
			super.verifyTagsAreVisibleInCourses(facultyStoreHomePage);

			Assert.assertTrue(tutorStoreHomePage.isDisplayedTagsOnCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing tags are visible on created courses at tutor end: "
					+ e.getMessage());
			logger.error("Error occured while testing tags are visible on created courses at tutor end ", e);
		}
		logger.info("Ending of testTagsAreVisibleOnCreatedCoursesAtTutorEnd method");
	}

	@Test(priority = 26, description = "validate tags are visible on created courses at faculty end")
	@Description("Test Description:validate tags are visible on created courses at faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Story("validate tags are visible on created courses at faculty end")
	public void testTagsAreVisibleOnCreatedCoursesAtFacultyEnd() {
		logger.info("Starting of testTagsAreVisibleOnCreatedCoursesAtFacultyEnd method");

		try {
			super.verifyTagsAreVisibleInCourses(facultyStoreHomePage);

			Assert.assertTrue(facultyStoreHomePage.isDisplayedTagsOnCourses());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing tags are visible on created courses at faculty end: "
					+ e.getMessage());
			logger.error("Error occured while testing tags are visible on created courses at faculty end ", e);
		}
		logger.info("Ending of testTagsAreVisibleOnCreatedCoursesAtFacultyEnd method");
	}

	@Test(priority = 27, description = "Validate View All Courses on Store tab at tutor end")
	@Description("Test Description:Validate View All Courses on Store tab at tutor end")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate View All Courses on Store tab at tutor end")
	public void testViewAllCoursesOnStoretabAtTutorEnd() {
		logger.info("Starting of testViewAllCoursesOnStoretabAtTutorEnd method");

		try {
			super.verifyVIewAllCourses(tutorStoreHomePage);

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesList());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing View All Courses on Store tab at tutor end: " + e.getMessage());
			logger.error("Error occured while testing View All Courses on Store tab at tutor end ", e);
		}
		logger.info("Ending of testViewAllCoursesOnStoretabAtTutorEnd method");
	}

	@Test(priority = 28, description = "Validate View All Courses on Store tab at faculty end")
	@Description("Test Description:Validate View All Courses on Store tab at faculty end")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate View All Courses on Store tab at faculty end")
	public void testViewAllCoursesOnStoretabAtFacultyEnd() {
		logger.info("Starting of testViewAllCoursesOnStoretabAtFacultyEnd method");

		try {
			super.verifyVIewAllCourses(facultyStoreHomePage);

			Assert.assertTrue(tutorStoreHomePage.isDisplayedCoursesList());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing View All Courses on Store tab at faculty end: " + e.getMessage());
			logger.error("Error occured while testing View All Courses on Store tab at faculty end ", e);
		}
		logger.info("Ending of testViewAllCoursesOnStoretabAtFacultyEnd method");
	}
	/**0
	 * student side
	 */

	@Test(priority = 29, description = "Validate Search bar should be visible on top of Store page at student end")
	@Description("Test Description:Validate Search bar should be visible on top of Store page at student end.")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate Search bar should be visible on top of Store page at student end.")
	public void testSearchBarAtStudentEnd() {
		logger.info("Starting of testViewAllCoursesOnStoretabAtStudentEnd method");

		try {
			verifySearchBar(studentStoreHomePage);
			Assert.assertTrue(studentStoreHomePage.isClickableSearchBar());

			tutorStoreHomePage.hardBack();
		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing View All Courses on Store tab at Student end: " + e.getMessage());
			logger.error("Error occured while testing View All Courses on Store tab at Student end ", e);
		}
		logger.info("Ending of testViewAllCoursesOnStoretabAtStudentEnd method");
	}

	@Test(priority = 30, description = "Verify Functionality Of Search bar at Student end")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: Verify Functionality Of Search bar at Student end")
	@Story("Verify Functionality Of Search bar at Student end")
	public void testFunctionalityOfSearchBarOnStoreTabAtStudentEnd() {
		logger.info("Starting of testFunctionalityOfSearchBarAtStudentEnd method ");

		try {
			verifyFunctionalityOfSearchBar(studentStoreHomePage);

			Assert.assertTrue(studentStoreHomePage.isDisplayedCoursesListAfterClickingOnSearch());

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing Functionality Of Search bar at Student end: " + e.getMessage());
			logger.error("Error occured while testing Functionality Of Search bar at Student end", e);
		}

		logger.info("Ending of testFunctionalityOfSearchBarAtStudentEnd method");
	}
	
}
package com.classplusapp.common;

import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.classplusapp.base.test.ClassplusBaseMobileAutomationTest;
import com.classplusapp.mobile.pages.MobileCourseMarkFeaturedPage;
import com.classplusapp.mobile.pages.StoreHomePage;
import com.classplusapp.web.pages.ContentPage;
import com.classplusapp.web.pages.CourseOverviewPage;
import com.classplusapp.web.pages.CreateCoursePage;
import com.classplusapp.web.pages.InstallmentsPage;

public class StoreUtility extends ClassplusBaseMobileAutomationTest {
	private static final Logger logger = LogManager.getLogger(CreateCoursePage.class);

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd-HH:mm:ss");
	private String courseName = null;

	public void enterCreateCourseValues(CreateCoursePage createCoursePage, String courseName, String description,
			String category, String subcategory, String price, String discount, String internetHandeling,
			String taxDetails, boolean taxCheckFlag, String taxPercentage, String duration, String durationPeriod,
			String courseSharing, boolean minCourseValue, String minValueFromResller, String shipmentMaterial,
			boolean tentativeDays, String OfflinePermissions, String pdfDownloadPermissions,
			String pdfDownloadPermissionsApp, String liveClass, String videoWeb, String videoRestrictions,
			String maxView, String previewCourse, String studentCertificate, boolean autoSendCertificate,
			String daysAfterPurchase) {
		createCoursePage.setCourseName(courseName);
		createCoursePage.setDescription(description);
		createCoursePage.selectDropdownValueFromCategories(category);
		createCoursePage.selectDropdownValueFromSubCategories(subcategory);
		createCoursePage.setPrice(price);
		createCoursePage.setDiscount(discount);

		if (internetHandeling.equalsIgnoreCase("Internet Handling Charges")) {
			createCoursePage.clickOnInternetHandelingCharge();
		}
		if (taxDetails.equals("Tax Details") && taxCheckFlag == true)
			createCoursePage.selectTaxPercentage(taxPercentage);

		else if (taxDetails.equals("Tax Details") && taxCheckFlag == false)
			createCoursePage.uncheckTaxDetails();

		if (duration.equals("Single Validity")) {
			createCoursePage.selectValidity(duration, durationPeriod);
		} else if (duration.equals("Course Expiry Date")) {
			createCoursePage.selectExpiry(duration);
		} else if (duration.equals("Lifetime Validity")) {
			createCoursePage.selectLifetimeRadio(duration);
		}

		if (courseSharing.equals("Course Sharing"))
			createCoursePage.checkCourseGlobalSharing(minCourseValue, minValueFromResller);

		if (shipmentMaterial.equals("Course has offline material for shipment") && tentativeDays == false)
			createCoursePage.checkOfflineShipmentMaterial();
		else if (shipmentMaterial.equals("Course has offline material for shipment") && tentativeDays == true) {
			createCoursePage.checkOfflineShipmentMaterial();
			createCoursePage.setTentativeDaysForShipmentMaterial();
		}
		if (OfflinePermissions.equals("Offline access permissions")) {
			createCoursePage.checkOfflineAccessPermissions();
		}
		if (pdfDownloadPermissions.equals("Pdf download permissions")) {
			createCoursePage.checkPdfDownloadPermissions();
		}

		if (pdfDownloadPermissionsApp.equals("Allow PDF Download within App")) {
			createCoursePage.checkPdfDownloadOnApp();
		}
		if (liveClass.equals("Live Classes")) {
			createCoursePage.checkLiveClass();
		}

		if (videoWeb.equals("Web Video")) {
			createCoursePage.allowVideoOnWeb();
		}
		if (videoRestrictions.equals("Video Restrictions")) {
			createCoursePage.restrictVideo();
			createCoursePage.setMaxViews(maxView);
			createCoursePage.setMaxViewsDuration();

		}

		if (previewCourse.equals("Preview Course Feature")) {
			createCoursePage.checkPreviewCourse();
		}

		if (studentCertificate.equals("Student Certificate") && autoSendCertificate == true) {
			createCoursePage.checkStudentCertificate();
			createCoursePage.enterDaysAfterStudentPurchase(daysAfterPurchase);
		} else if (studentCertificate.equals("Student Certificate") && autoSendCertificate == false) {
			createCoursePage.uncheckAutoSendCertificate();
		}
	}

	public void createCourse(CreateCoursePage createCoursePage, String courseName, String description, String category,
			String subcategory, String price, String discount, String internetHandeling, String taxDetails,
			boolean taxCheckFlag, String taxPercentage, String duration, String durationPeriod, String courseSharing,
			boolean minCourseValue, String minValueFromResller, String shipmentMaterial, boolean tentativeDays,
			String OfflinePermissions, String pdfDownloadPermissions, String pdfDownloadPermissionsApp,
			String liveClass, String videoWeb, String videoRestrictions, String maxView, String previewCourse,
			String studentCertificate, boolean autoSendCertificate, String daysAfterPurchase) {

		enterCreateCourseValues(createCoursePage, courseName, description, category, subcategory, price, discount,
				internetHandeling, taxDetails, taxCheckFlag, taxPercentage, duration, durationPeriod, courseSharing,
				minCourseValue, minValueFromResller, shipmentMaterial, tentativeDays, OfflinePermissions,
				pdfDownloadPermissions, pdfDownloadPermissionsApp, liveClass, videoWeb, videoRestrictions, maxView,
				previewCourse, studentCertificate, autoSendCertificate, daysAfterPurchase);

		createCoursePage.clickOnTermsAndConditionCheckBox();
		createCoursePage.clickOnAddContentButton();

	}

	public void addCourseContent(ContentPage contentPage, String addImage, String imageName, String imageDescription,
			String uploadImage, String addFolder, String nameFolder, String addVideo, String uploadVideo,
			String addDocument, String documentName, String documentDescription, String uploadDocument,
			String addZipFile, String nameZipFile, String descriptionZipFile, String uploadZipFile,
			String addSubjectiveTest) {
		if (addImage.equals("Image")) {
			contentPage.clickOnAddImageButton();
			contentPage.setImageName(imageName);
			contentPage.setImageDescription(imageDescription);
			contentPage.clickOnUploadImageButton(uploadImage);
			contentPage.clickOnBtnUploadImageButton();
		}
		if (addFolder.equals("Folder")) {
			contentPage.clickOnAddFolderButton();
			contentPage.setFolderName(nameFolder);
			contentPage.clickOnBtnFolderSave();
		}
		if (addDocument.equals("Document")) {
			contentPage.clickOnAddDocumentButton();
			contentPage.setDocumentName(documentName);
			contentPage.setDocumentDescription(documentDescription);
			contentPage.clickOnSelectDocumentButton(uploadDocument);
			contentPage.clickOnUploadDocumentButton();
		}
		if (addVideo.equals("Video")) {
			contentPage.clickOnAddVideo();
			contentPage.hardWait(3);
			contentPage.clickOnBtnUploadVideo(uploadVideo);
			contentPage.clickOnBtnDone();
			contentPage.clickOnEnablePreview();
		}
		if (addZipFile.equals("Zip Folder")) {
			contentPage.clickOnAddZipFile();
			contentPage.setZipFileName(nameZipFile);
			contentPage.setZipFileDescription(descriptionZipFile);
			contentPage.clickOnSelectZipFile(uploadZipFile);
			contentPage.clickOnUploadZipFile();

		}
		if (addSubjectiveTest.equals("Subjective Test")) {
			contentPage.clickOnSubjectiveTestButton();
			contentPage.clickOnAddSubjectiveTestButton();
		}
		contentPage.hardWait(5);

	}

	public void removeCourse(MobileCourseMarkFeaturedPage mobileCourseMarkFeaturedPage) {
		mobileCourseMarkFeaturedPage.clickOnThreeDottedMenuButton();
		mobileCourseMarkFeaturedPage.clickOnRemoveCourseButton();
		mobileCourseMarkFeaturedPage.clickOnRemoveCourseConfirmButton();
	}

	public void getFiltersScreen(StoreHomePage storeHomePage) {
		storeHomePage.clickOnStoreTab();
		storeHomePage.clickOnSearchBar();
		storeHomePage.clickOnFiltersIcon();
	}

	public void verifyStoreHomePageLabels(StoreHomePage storeHomePage) throws Exception {
		storeHomePage.clickOnStoreTab();
		Assert.assertEquals(storeHomePage.getMyCoursesAndContentMarketLabels(),
				this.getPropertyList(expectedAssertionsProp.getProperty("mycourses.and.content.market.labels")));

		Assert.assertTrue(storeHomePage.isDisplayedSearchBar());

		Assert.assertEquals(storeHomePage.getStatsAndCouponCodesLabels(),
				this.getPropertyList(expectedAssertionsProp.getProperty("stats.and.couponcode.label")));

		Assert.assertEquals(storeHomePage.getCategoriesAndSubCategoriesLabel(),
				expectedAssertionsProp.getProperty("categories.and.subcategories.label"));

		Assert.assertEquals(storeHomePage.getCoursesLabel(), expectedAssertionsProp.getProperty("courses.label"));

		Assert.assertTrue(storeHomePage.isDisplayedStatsCardsCouponCardsCategoriesAndSubCategoriesLabels());

		Assert.assertTrue(storeHomePage.isDisplayedCoursesList());
	}

	public void verifySearchBar(StoreHomePage storeHomePage) throws Exception {

		storeHomePage.clickOnStoreTab();

		Assert.assertTrue(storeHomePage.isDisplayedSearchBar());
	}

	public void verifyFunctionalityOfSearchBar(StoreHomePage storeHomePage) {

		storeHomePage.clickOnStoreTab();

		Assert.assertTrue(storeHomePage.isDisplayedSearchBar());

		storeHomePage.clickOnSearchBar();

		Assert.assertEquals(storeHomePage.getMyCoursesLabel(), expectedAssertionsProp.getProperty("my.courses.label"));

		Assert.assertTrue(storeHomePage.isDisplayedFiltersIcon());
	}

	public String functionalityOfSearchBarInMyCoursesScreen(StoreHomePage storeHomePage,
			CreateCoursePage createCoursePage) {
		String courseName = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
		String description = testDataProp.getProperty("store.home.page.course.name") + System.currentTimeMillis();
		createCoursePage.clickOnStoreTab();
		createCoursePage.clickCreateCourseBtn();
		this.createCourse(createCoursePage, courseName, description, testDataProp.getProperty("bankexam.category"),
				testDataProp.getProperty("ibps.subcategory"), testDataProp.getProperty("course.price100"),
				testDataProp.getProperty("course.discount0"), "", "", false, "", "", "", "", false, "", "", false, "",
				"", "", testDataProp.getProperty("course.live.classes"), testDataProp.getProperty("course.web.video"),
				testDataProp.getProperty("course.video.restrictions"),
				testDataProp.getProperty("course.video.maxview1"), testDataProp.getProperty("course.preview"),
				testDataProp.getProperty("course.student.certificate"), true,
				testDataProp.getProperty("course.30days.after.purchase"));

		storeHomePage.clickOnStoreTab();
		storeHomePage.clickOnSearchByName(courseName);

		return courseName;
	}

	public void verifyTagsAreVisibleInCourses(StoreHomePage storeHomePage) throws Exception {
		storeHomePage.clickOnStoreTab();

		Assert.assertTrue(storeHomePage.isDisplayedCoursesList());

	}

	public void verifyVIewAllCourses(StoreHomePage storeHomePage) throws InterruptedException {
		storeHomePage.clickOnStoreTab();
		storeHomePage.clickOnViewAllCourses();

		Assert.assertTrue(storeHomePage.isDisplayedSearchBar());

		Assert.assertTrue(storeHomePage.isDisplayedFiltersIcon());
	}

	public void testRemoveCourse(CourseOverviewPage courseOverviewPage) {

		if (courseOverviewPage.isDisplayedGotItPopup() == true) {
			courseOverviewPage.closeInstallmentGotItPopup();
		}
		courseOverviewPage.clickOnOverviewLeftPanel();
		courseOverviewPage.clickDots();
		courseOverviewPage.removeCourse();
		courseOverviewPage.clickOnRemove();
	}

	public void addFacultyToCourse(CourseOverviewPage courseOverviewPage) {

		courseOverviewPage.clickOnAddButton();
		courseOverviewPage.setfacultyName(testDataProp.getProperty("txt.faculty.name"));
		courseOverviewPage.setFacultyMobileNumber(testDataProp.getProperty("txt.add.faculty.mobilenumber"));
		courseOverviewPage.enterEmail(testDataProp.getProperty("txt.faculty.email"));
		courseOverviewPage.hardWait(3);
		courseOverviewPage.clickOnAddFacultyButton();
		courseOverviewPage.clickOnCloseButton();

	}

	public void selectCourseAtMobileEnd(MobileCourseMarkFeaturedPage mobileCourseMarkFeaturedPage, String courseName) {

		mobileCourseMarkFeaturedPage.clickOnStoreTab();
		mobileCourseMarkFeaturedPage.clickOnSearchByName(courseName);
		mobileCourseMarkFeaturedPage.clickOnCourseSelect();

	}

	public void createInstallment(CourseOverviewPage courseOverviewPage, InstallmentsPage installmentsPage)
			throws Exception {
		if (courseOverviewPage.isDisplayedGotItPopup() == true) {
			courseOverviewPage.closeInstallmentGotItPopup();
		}
		courseOverviewPage.clickOnCreateInstallment();
		installmentsPage.txtInstallments(testDataProp.getProperty("number.of.installments"));
		installmentsPage.clickOnInstallmentPeriod();
		installmentsPage.clickOnCreateInstallmentButton();
		installmentsPage.clickOnSetInstallmentButton();
		installmentsPage.clickOnDoneButton();

	}
}

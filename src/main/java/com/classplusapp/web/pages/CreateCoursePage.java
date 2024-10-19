package com.classplusapp.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusBaseWebAutomationPage;
import com.classplusapp.base.page.ClassplusappBasePage;

public class CreateCoursePage extends ClassplusappBasePage {

	private static final Logger log = LogManager.getLogger(CreateCoursePage.class);

	@B2BFindBy(xpath = "{btnStore}")
	private WebElement btnStore;

	@B2BFindBy(xpath = "{inpcourseName}")
	private WebElement inpCourseName;

	@B2BFindBy(xpath = "{txtDescription}")
	private WebElement txtDescription;

	@B2BFindBy(xpath = "{ddCategories}")
	private WebElement ddCategories;

	@B2BFindBy(xpath = "{ddAfterSelectingCategory}")
	private WebElement ddAfterSelectingCategory;

	@B2BFindBys(@B2BFindBy(xpath = "{txtCategory}"))
	private List<WebElement> txtCategory;

	@B2BFindBys(@B2BFindBy(xpath = "{txtSubCategory}"))
	private List<WebElement> txtSubCategory;

	@B2BFindBy(xpath = "{txtPrice}")
	private WebElement txtPrice;

	@B2BFindBy(xpath = "{chkTermsAndConditions}")
	private WebElement chkTermsAndConditions;

	@B2BFindBy(xpath = "{btnAddContent}")
	private WebElement btnAddContent;

	@B2BFindBy(xpath = "{publishCourseBtn}")
	private WebElement publishCourseBtn;

	@B2BFindBy(xpath = "{tglInternetCharges}")
	private WebElement tglInternetCharges;

	@B2BFindBy(xpath = "{tglTaxDetails}")
	private WebElement tglTaxDetails;

	@B2BFindBy(xpath = "{ddSubCategories}")
	private WebElement ddSubCategories;

	@B2BFindBys(@B2BFindBy(xpath = "{courseleftLabels}"))
	private List<WebElement> courseleftLabels;

	@B2BFindBy(xpath = "{ddTaxPercentage}")
	private WebElement ddTaxPercentage;

	@B2BFindBys(@B2BFindBy(xpath = "{txtTaxPercentage}"))
	private List<WebElement> txtTaxPercentage;

	@B2BFindBy(xpath = "{tglShipmentMaterial}")
	private WebElement tglShipmentMaterial;

	@B2BFindBy(xpath = "{imgTentativeDays}")
	private WebElement imgTentativeDays;

	@B2BFindBy(xpath = "{selectTentativeDays}")
	private WebElement selectTentativeDays;

	@B2BFindBy(xpath = "{tglOfflineAccessPermisions}")
	private WebElement tglOfflineAccessPermisions;

	@B2BFindBy(xpath = "{tglPdfDownloadPermisions}")
	private WebElement tglPdfDownloadPermisions;

	@B2BFindBy(xpath = "{tglpdfDownloadWithApp}")
	private WebElement tglpdfDownloadWithApp;

	@B2BFindBy(xpath = "{tglLiveClasses}")
	private WebElement tglLiveClasses;

	@B2BFindBy(xpath = "{tglVideoWebView}")
	private WebElement tglVideoWebView;

	@B2BFindBy(xpath = "{tglVideoRestrictions}")
	private WebElement tglVideoRestrictions;

	@B2BFindBy(xpath = "{chkMaxViewDuration}")
	private WebElement chkMaxViewDuration;

	@B2BFindBy(xpath = "{chkMaxViews}")
	private WebElement chkMaxViews;

	@B2BFindBy(xpath = "{inpMaxViews}")
	private WebElement inpMaxViews;

	@B2BFindBy(xpath = "{inpMaxViewDuration}")
	private WebElement inpMaxViewDuration;

	@B2BFindBy(xpath = "{ddTimePicker}")
	private WebElement ddTimePicker;

	@B2BFindBy(xpath = "{tglPreviewCourseFeature}")
	private WebElement tglPreviewCourseFeature;

	@B2BFindBy(xpath = "{tglStudentCertificate}")
	private WebElement tglStudentCertificate;

	@B2BFindBy(xpath = "{chkAutoSendCertificate}")
	private WebElement chkAutoSendCertificate;

	@B2BFindBy(xpath = "{inpAutoSendCertifications}")
	private WebElement inpAutoSendCertifications;

	@B2BFindBy(xpath = "{inpDiscount}")
	private WebElement inpDiscount;

	@B2BFindBy(xpath = "{chkCourseGlobal}")
	private WebElement chkCourseGlobal;

	@B2BFindBy(xpath = "{toastCheckGlobalShipment}")
	private WebElement toastCheckGlobalShipment;

	@B2BFindBy(xpath = "{inpMinimumCourse}")
	private WebElement inpMinimumCourse;

	@B2BFindBy(xpath = "{idValidityRadio}")
	private WebElement idValidityRadio;

	@B2BFindBy(xpath = "{inpCourseDurationValidity}")
	private WebElement inpCourseDurationValidity;

	@B2BFindBy(xpath = "{idExpiryRadio}")
	private WebElement idExpiryRadio;

	@B2BFindBy(xpath = "{inpExpiry}")
	private WebElement inpExpiry;

	@B2BFindBy(xpath = "{arrowCalenderNext}")
	private WebElement arrowCalenderNext;

	@B2BFindBy(xpath = "{dateTimer}")
	private WebElement dateTimer;

	@B2BFindBy(xpath = "{idLifetimeRadio}")
	private WebElement idLifetimeRadio;

	@B2BFindBy(xpath = "{chkSetTentativeDays}")
	private WebElement chkSetTentativeDays;

	@B2BFindBy(xpath = "{titleCreateCourse}")
	private WebElement titleCreateCourse;

	@B2BFindBy(xpath = "{titleToastMsg}")
	private WebElement titleToastMsg;

	@B2BFindBy(xpath = "{chlCourseAsPrivate}")
	private WebElement chlCourseAsPrivate;

	@B2BFindBy(xpath = "{inpPercentageShare}")
	private WebElement inpPercentageShare;

	@B2BFindBy(xpath = "{listTaxPercentage}")
	private WebElement listTaxPercentage;

	@B2BFindBy(xpath = "{chkExistingVideos}")
	private WebElement chkExistingVideos;

	@B2BFindBy(xpath = "{lblShipment}")
	private WebElement lblShipment;

	@B2BFindBy(xpath = "{icnI}")
	private WebElement icnOfflineShipmentInformation4;

	@B2BFindBy(xpath = "{lblIIconText}")
	private WebElement lblInformationIconText;

	@B2BFindBy(xpath = "{chkCourseSharing}")
	private WebElement chkCourseSharing;

	@B2BFindBy(xpath = "{lblErrorShipmentDescription}")
	private WebElement lblErrorShipmentDescription;

	@B2BFindBy(xpath = "{lbltentativeDelivery}")
	private WebElement lbltentativeDelivery;

	@B2BFindBy(xpath = "{chkTentativeDelivery}")
	private WebElement chkTentativeDelivery;

	@B2BFindBy(xpath = "{drpTentativeDays}")
	private WebElement drpTentativeDays;

	@B2BFindBy(xpath = "{drpPeriod}")
	private WebElement drpPeriod;

	@B2BFindBy(xpath = "{drpSelectPeriod}")
	private WebElement drpSelectPeriod;

	/*
	 * @B2BFindBy(xpath = "{btnSaveCourse}") private WebElement btnSaveCourse;
	 */

	@B2BFindBy(xpath = "{btnSaveCourseInEditCourse}")
	private WebElement btnSaveCourseInEditCourse;

	@B2BFindBy(xpath = "{btnDiscardCourse}")
	private WebElement btnDiscardCourse;

	@B2BFindBy(xpath = "{inpUploadPhoto}")
	private WebElement inpUploadPhoto;

	@B2BFindBy(xpath = "{txtUploadImage}")
	private WebElement txtUploadImage;

	@B2BFindBy(xpath = "{imgUploadThumbnail}")
	private WebElement imgUploadThumbnail;

	@B2BFindBy(xpath = "{btnAddAnotherCategory}")
	private WebElement btnAddAnotherCategory;

	@B2BFindBys(@B2BFindBy(xpath = "{delIconSubcategoryCross}"))
	private List<WebElement> delIconSubcategoryCross;

	@B2BFindBy(xpath = "{subcategoryList}")
	private List<WebElement> subcategoryList;

	@B2BFindBy(xpath = "{divSubcategory}")
	private WebElement divSubcategory;

	@B2BFindBy(xpath = "{iconDeleteCategory}")
	private List<WebElement> iconDeleteCategory;

	@B2BFindBys(@B2BFindBy(xpath = "{imgDeleteSubcategory}"))
	private List<WebElement> imgDeleteSubcategory;

	@B2BFindBy(xpath = "{selCategoryOptions}")
	private WebElement selCategoryOptions;

	@B2BFindBy(xpath = "{inpSubCategory}")
	private WebElement inpSubCategory;

	@B2BFindBy(xpath = "{inpEffectivePrice}")
	private WebElement inpEffectivePrice;

	@B2BFindBy(xpath = "{priceInternet}")
	private WebElement priceInternet;

	@B2BFindBy(xpath = "{valTaxDetails}")
	private WebElement valTaxDetails;

	@B2BFindBy(xpath = "{ddCourseDuration}")
	private WebElement ddCourseDuration;

	@B2BFindBys(@B2BFindBy(xpath = "{selectCourseDuration}"))
	private List<WebElement> selectCourseDuration;

	@B2BFindBy(xpath = "{lnkViewPermissions}")
	private WebElement lnkViewPermissions;

	@B2BFindBy(xpath = "{tglEditPermissionsName}")
	private WebElement tglEditPermissionsName;

	@B2BFindBy(xpath = "{btnSavePermissions}")
	private WebElement btnSavePermissions;

	@B2BFindBy(xpath = "{titleMsg}")
	private WebElement titleMsg;

	@B2BFindBy(xpath = "{msgRemoveBanner}")
	private WebElement msgRemoveBanner;

	@B2BFindBy(xpath = "{dpnCourseValidity}")
	private WebElement dpnCourseValidity;

	@B2BFindBys(@B2BFindBy(xpath = "{selCourseValidityValies}"))
	private List<WebElement> selCourseValidityValies;

	@B2BFindBy(xpath = "{inpCourseExpiryDate}")
	private WebElement inpCourseExpiryDate;

	@B2BFindBy(xpath = "{inpCourseDuration}")
	private WebElement inpCourseDuration;

	@B2BFindBy(xpath = "{installmentRemoveModal}")
	private WebElement installmentRemoveModal;

	@B2BFindBy(xpath = "{installmentRemoveModalHeading}")
	private WebElement installmentRemoveModalHeading;

	@B2BFindBy(xpath = "{installmentRemoveModalSaveChangesBtn}")
	private WebElement installmentRemoveModalSaveChangesBtn;

	@B2BFindBy(xpath = "{editCourseWindow}")
	private WebElement editCourseWindow;

	@B2BFindBy(xpath = "{editPermissionsWindow}")
	private WebElement editPermissionsWindow;

	@B2BFindBy(xpath = "{btnDiscardEditPermissions}")
	private WebElement btnDiscardEditPermissions;

	@B2BFindBy(xpath = "{excludeTaxDetailsLbl}")
	private WebElement excludeTaxDetailsLbl;

	@B2BFindBy(xpath = "{btnCancel}")
	private WebElement btnCancelExcludeTaxDetailsWindow;

	@B2BFindBy(xpath = "{btnSwitchOnToggle}")
	private WebElement btnSwitchOnToggle;

	@B2BFindBy(xpath = "{btnCreateCourse}")
	private WebElement btnCreateCourse;

	public CreateCoursePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);

	}

	public void clickOnStoreTab() {
		log.info("starting of clickOnStoreTab method");

		try {
			clickOnWebElement(btnStore);
		} catch (Exception e) {
			btnStore.click();
		}

		log.info("Ending of clickOnStoreTab method");
	}

	public void clickCreateCourseBtn() {

		try {
			btnCreateCourse.click();
		} catch (Exception e) {
			this.refresh();
			this.hardWait(4);
			this.clickOnWebElement(btnCreateCourse);
		}

	}

	public void setCourseName(String courseName) {
		deleteInputFields(inpCourseName);
		inpCourseName.sendKeys(courseName);
	}

	public void setDescription(String description) {
		this.hardWait(3);
		deleteInputFields(txtDescription);
		txtDescription.sendKeys(description);
	}

	public void selectDropdownValueFromValidity() {
		hardWait(3);
		clickOnWebElement(drpPeriod);
		drpSelectPeriod.click();
	}

	public void selectDropdownValueFromCategories(String text) {
		ddCategories.click();
		pickFromWebElement(txtCategory, text);
	}

	public boolean isValuePresentInDropdownValuesFromCategories(String text) {
		ddCategories.click();
		boolean flag = isPresentInWebElementList(txtCategory, text);
		ddAfterSelectingCategory.click();
		return flag;
	}

	public void selectDropdownValueFromSubCategories(String subcategory) {
		ddSubCategories.click();
		pickFromWebElement(txtSubCategory, subcategory);
	}

	public void setPrice(String strPrice) {

		scrollDown(300);
		deleteInputFields(txtPrice);
		txtPrice.sendKeys(strPrice);

	}

	public void setDiscount(String discount) {
		deleteInputFields(inpDiscount);
		inpDiscount.sendKeys(discount);
	}

	public void clickOnAddContentButton() {
		hardWait(3);
		clickOnWebElement(btnAddContent);
	}

	public void clickOnTermsAndConditionCheckBox() {
		clickOnWebElement(chkTermsAndConditions);
	}

	public void clickOnPublishButton() {

		try {
			Thread.sleep(5000);
			publishCourseBtn.click();
		} catch (Exception e) {
			clickOnWebElement(publishCourseBtn);
		}

	}

	public void clickOnInternetHandelingCharge() {
		if (!tglInternetCharges.getAttribute("class").contains("checked")) {
			scrollIntoView(tglInternetCharges);
			clickOnWebElement(tglInternetCharges);
		}

	}

	public void uncheckTaxDetails() {
		if (tglTaxDetails.getAttribute("class").contains("checked")) {
			clickOnWebElement(tglTaxDetails);
		}

	}

	public void checkTaxDetails() {
		if (!tglTaxDetails.getAttribute("class").contains("checked")) {
			clickOnWebElement(tglTaxDetails);
		}

	}

	public void selectTaxPercentage(String taxPercentage) {
		if (tglTaxDetails.getAttribute("class").contains("checked")) {
			ddTaxPercentage.click();
			pickFromWebElement(txtTaxPercentage, taxPercentage);
		}

	}

	public String getLeftMenuLabels() throws Exception {
		log.info("Starting of getLeftMenuLabels method");
		log.info("Ending of getLeftMenuLabels method");
		log.info(courseleftLabels);
		log.info(btnStore);
		Thread.sleep(2000);
		List<String> courseList = new ArrayList<String>();
		// WebElement e1;
		for (WebElement e : courseleftLabels) {
			// courseList.add(e.getText());
			if (e.getText().equals("Content")) {

				return e.getText();
			}

		}
		return null;
	}

	public void checkOfflineShipmentMaterial() {
		if (!tglShipmentMaterial.getAttribute("class").contains("checked")) {
			scrollIntoView(tglShipmentMaterial);
			clickOnWebElement(tglShipmentMaterial);
		}
	}

	public void setTentativeDaysForShipmentMaterial() {
		if (!chkSetTentativeDays.getAttribute("class").contains("checked")) {
			scrollIntoView(chkSetTentativeDays);
			clickOnWebElement(chkSetTentativeDays);
			clickOnWebElement(imgTentativeDays);
			selectTentativeDays.click();
		}
	}

	public void checkOfflineAccessPermissions() {
		if (!tglOfflineAccessPermisions.getAttribute("class").contains("checked")) {
			scrollIntoView(tglOfflineAccessPermisions);
			clickOnWebElement(tglOfflineAccessPermisions);
		}
	}

	public void checkPdfDownloadPermissions() {
		if (!tglPdfDownloadPermisions.getAttribute("class").contains("checked")) {
			scrollIntoView(tglPdfDownloadPermisions);
			clickOnWebElement(tglPdfDownloadPermisions);
		}
	}

	public boolean isPdfDownloadPermissionsChecked() {
		log.info("Starting of isPdfDownloadPermissionsChecked method");
		if (tglPdfDownloadPermisions.getAttribute("class").contains("checked")) {
			return true;
		}
		log.info("Ending of isPdfDownloadPermissionsChecked method");
		return false;
	}

	public void checkPdfDownloadOnApp() {
		if (!tglpdfDownloadWithApp.getAttribute("class").contains("checked")) {
			scrollIntoView(tglpdfDownloadWithApp);
			clickOnWebElement(tglpdfDownloadWithApp);
		}
	}

	public boolean isPdfDownloadOnAppChecked() {
		log.info("Starting of isPdfDownloadOnAppChecked method");
		if (tglpdfDownloadWithApp.getAttribute("class").contains("checked")) {
			return true;
		}
		log.info("Ending of isPdfDownloadOnAppChecked method");
		return false;
	}

	public void checkLiveClass() {
		if (!tglLiveClasses.getAttribute("class").contains("checked")) {
			scrollIntoView(tglLiveClasses);
			tglLiveClasses.click();
		}
	}

	public void allowVideoOnWeb() {
		if (!tglVideoWebView.getAttribute("class").contains("checked")) {
			scrollIntoView(tglVideoWebView);
			tglVideoWebView.click();
		}
	}

	public void restrictVideo() {
		if (!tglVideoRestrictions.getAttribute("class").contains("checked")) {
			scrollIntoView(tglVideoRestrictions);
			tglVideoRestrictions.click();
		}
	}

	public void setMaxViews(String maxViews) {
		if (!chkMaxViews.getAttribute("class").contains("checked"))
			chkMaxViews.click();
		inpMaxViews.clear();
		inpMaxViews.sendKeys(maxViews);

	}

	public String getValueFrommaxView() {
		log.info("Starting of decreaseMaxViewsWithDownwardArrow method");
		hardWait(5);
		scrollIntoView(tglVideoRestrictions);
		log.info("Ending of decreaseMaxViewsWithDownwardArrow method");
		return inpMaxViews.getAttribute("Value");
	}

	public void decreaseMaxViewsWithDownwardArrow(int count) {
		log.info("Starting of decreaseMaxViewsWithDownwardArrow method");
		int i = 0;
		hardWait(2);
		scrollIntoView(tglVideoRestrictions);
		inpMaxViews.click();
		while (i <= count) {
			this.inpMaxViews.sendKeys(Keys.ARROW_DOWN);
			i++;
		}
		hardWait(2);

		log.info("Ending of decreaseMaxViewsWithDownwardArrow method");
	}

	public void increaseMaxViewsWithUpwardArrow(int count) {
		log.info("Starting of increaseMaxViewsWithUpwardArrow method");
		hardWait(2);
		// value starts with 1
		int i = 1;
		scrollIntoView(tglVideoRestrictions);
		inpMaxViews.click();
		while (i <= count) {
			this.inpMaxViews.sendKeys(Keys.ARROW_UP);
			i++;
		}
		hardWait(2);

		log.info("Ending of increaseMaxViewsWithUpwardArrow method");
	}

	public void checkMaxViews() {
		chkMaxViews.click();
	}

	public void setMaxViewsDuration() {

		chkMaxViewDuration.click();
		inpMaxViewDuration.click();
		ddTimePicker.click();
	}

	public void checkMaxViewsDuration() {
		chkMaxViewDuration.click();
	}

	public void checkPreviewCourse() {
		if (!tglPreviewCourseFeature.getAttribute("class").contains("checked")) {
			scrollIntoView(tglPreviewCourseFeature);
			tglPreviewCourseFeature.click();
		}
	}

	public void checkStudentCertificate() {
		if (!tglStudentCertificate.getAttribute("class").contains("checked")) {
			scrollIntoView(tglStudentCertificate);
			tglStudentCertificate.click();
		}
	}

	public void uncheckAutoSendCertificate() {
		if (chkAutoSendCertificate.getAttribute("class").contains("checked")) {
			scrollIntoView(chkAutoSendCertificate);
			chkAutoSendCertificate.click();
		}
	}

	public void enterDaysAfterStudentPurchase(String daysPurchase) {
		super.deleteInputFields(inpAutoSendCertifications);
		// inpAutoSendCertifications.clear();
		inpAutoSendCertifications.sendKeys(daysPurchase);
	}

	public boolean isEnableEnterDaysAfterStudentPurchase() {
		try {
			if (inpAutoSendCertifications.isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void checkCourseGlobalSharing(boolean minCourseValue, String courseValue) {
		if (!chkCourseGlobal.getAttribute("class").contains("checked")) {
			chkCourseGlobal.click();
			if (minCourseValue == true) {
				inpMinimumCourse.clear();
				inpMinimumCourse.sendKeys(courseValue);
			}

		}
	}

	public boolean isVisibleInstallmentToastcheckCourseGlobalSharing() {
		log.info("Ending of isVisibleInstallmentToastcheckCourseGlobalSharing method");
		boolean flag = false;
		try {
			if (toastCheckGlobalShipment.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		log.info("Ending of isVisibleInstallmentToastcheckCourseGlobalSharing method");
		return flag;
	}

	public void selectValidity(String validityName, String validity) {
//		if (idValidityRadio.isSelected() == true) {
//			inpCourseDurationValidity.clear();
//			inpCourseDurationValidity.sendKeys(validity);
//
//		}
//
//		else
//			clickOnWebElement(idValidityRadio);

		clickOnWebElement(dpnCourseValidity);
		pickFromWebElement(selCourseValidityValies, validityName);
		inpCourseDuration.clear();
		inpCourseDuration.sendKeys(validity);
	}

	public void selectExpiry(String validityName) {
//		if (idExpiryRadio.isSelected() == false) {
//			clickOnWebElement(idExpiryRadio);
//			// inpExpiry.clear();
//			inpExpiry.click();
//			arrowCalenderNext.click();
//			System.out.println(dateTimer.getText());
//			clickOnWebElement(dateTimer);
//
//			// inpExpiry.sendKeys(expiry);
//		}

		clickOnWebElement(dpnCourseValidity);
		pickFromWebElement(selCourseValidityValies, validityName);
		clickOnWebElement(inpCourseExpiryDate);
		clickOnWebElement(arrowCalenderNext);

		System.out.println(dateTimer.getText());
		clickOnWebElement(dateTimer);

	}

	public void selectLifetimeRadio(String validityName) {
//		if (idLifetimeRadio.isSelected() == false) {
//			clickOnWebElement(idLifetimeRadio);
//
//		}

		clickOnWebElement(dpnCourseValidity);
		pickFromWebElement(selCourseValidityValies, validityName);
	}

	public String getCoursePageHeading() {
		return titleCreateCourse.getText();
	}

	public String getToastMessageTitle() {
		// explicitWait(titleToastMsg);
		hardWait(3);
		return titleToastMsg.getText();
	}

	public String getSuccessToastMessageTitle() {
		explicitWait(titleMsg);
		// hardWait(2);
		return titleMsg.getText();
	}

	public String getRemoveBannerMessage() {
		log.info("Starting of getRemoveBannerMessage method");
		log.info("Ending of getRemoveBannerMessage method");

		explicitWait(msgRemoveBanner);
		// hardWait(2);
		return msgRemoveBanner.getText();
	}

	public void checkCoursePrivate() {
		if (!chlCourseAsPrivate.getAttribute("class").contains("checked")) {
			clickOnWebElement(chlCourseAsPrivate);
		}
	}

	public void setPercentageShare(String share) {
		explicitWait(inpPercentageShare);
		inpPercentageShare.click();
//		inpPercentageShare.clear();
		deleteInputFields(inpPercentageShare);
		inpPercentageShare.sendKeys(share);

	}

	public void clearPercentageShare() {
		inpPercentageShare.clear();

	}

	public void checkUpdateExistingVideos() {
		if (!chkExistingVideos.getAttribute("class").contains("checked")) {
			clickOnWebElement(chkExistingVideos);
		}
	}

	public String fetchExpiryDate() {
		hardWait(2);
		return inpCourseExpiryDate.getAttribute("value");
	}

	public String getShipmentLabel() {
		log.info("Starting of getShipmentLabel method");
		log.info("Ending of getShipmentLabel method");
		return lblShipment.getText();

	}

	public boolean isDisplayedOfflineShipmentInformationIcon() {
		log.info("Starting of getIIcon method");
		log.info("Ending of getIIcon method");
		return icnOfflineShipmentInformation4.isDisplayed();
	}

	public String getInformationIconText() {
		log.info("Starting of getInformationIconText method");

		this.mouseHover(icnOfflineShipmentInformation4);

		log.info("Ending of getInformationIconText method");
		return lblInformationIconText.getText();
	}

	public boolean isCheckedCourseSharingCheckBox() {
		log.info("Starting of isCheckedCourseSharingToggle method");
		log.info("Ending of isCheckedCourseSharingToggle method");

		if (chkCourseSharing.getAttribute("class").contains("checked")) {

			return true;
		}
		return false;
	}

	public boolean isEnabledShipmentToggle() {
		log.info("Starting of isEnabledShipmentToggle method");
		log.info("Ending of isEnabledShipmentToggle method");

		this.scrollIntoView(tglShipmentMaterial);
		if (tglShipmentMaterial.getAttribute("class").contains("disabled")) {
			return true;
		}
		return false;
	}

	public void clickOnCourseSharingCheckBox() {
		log.info("Starting of clickOnCourseSharingCheckBox method");

		this.scrollIntoView(chkCourseSharing);
		try {
			this.clickOnWebElement(chkCourseSharing);

		} catch (Exception e) {
			this.chkCourseSharing.click();
		}

		log.info("Ending of clickOnCourseSharingCheckBox method");

	}

	public String getErrorShipmentDescriptionLabel() {
		log.info("Starting of getErrorShipmentDescriptionLabel method");
		log.info("Ending of getErrorShipmentDescriptionLabel method");
		return lblErrorShipmentDescription.getText().substring(2);
	}

	public boolean isDisplayedTentativeDeliveryCheckBox() {
		log.info("Starting of isDisplayedTentativeDeliveryCheckBox method");
		log.info("Ending of isDisplayedTentativeDeliveryCheckBox method");

		return lbltentativeDelivery.isDisplayed();
	}

	public void clickOnTentativeDeliveryCheckBox() {
		log.info("Starting of clickOnTentativeDeliveryCheckBox method");

		this.clickOnWebElement(chkTentativeDelivery);

		log.info("Ending of clickOnTentativeDeliveryCheckBox method");

	}

	public void clickOnTentativeDeliveryDropDown() {
		log.info("Starting of clickOnTentativeDeliveryDropDown method");

		this.clickOnWebElement(drpTentativeDays);

		log.info("Ending of clickOnTentativeDeliveryDropDown method");

	}

	public boolean isDisplayedSevenDaysLabel(String days) {
		log.info("Starting of isEnabledShipmentToggle method");
		log.info("Ending of isEnabledShipmentToggle method");

		if (drpTentativeDays.getAttribute("value").contains(days)) {

			return true;
		}
		return false;
	}

	public void saveCourse() {
		clickOnWebElement(btnSaveCourseInEditCourse);
	}

	public void discardCourse() {

		clickOnWebElement(btnDiscardCourse);
	}

	public void uploadCourseThumbnailPhoto(String image) {
		uploadImage(inpUploadPhoto, image);

	}

	public String getAspectRatioThumbnailImage() {
		hardWait(5);
		return txtUploadImage.getText();
	}

	public String getSrcOfUploadThumbnail() {
		String imgSrc = imgUploadThumbnail.getAttribute("src");
		String actualSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
		return actualSrc;
	}

	public void addAnotherCategory() {
		try {
			explicitWait(btnAddAnotherCategory);
			btnAddAnotherCategory.click();
		} catch (Exception e) {
			clickOnWebElement(btnAddAnotherCategory);
		}

	}

	public Boolean isDisplayedAddAnotherCategoryButton() {
		log.info("starting of isDisplayedAddAnotherCategoryButton method");
		try {
			hardWait(3);
			if (btnAddAnotherCategory.isDisplayed())
				return true;
		} catch (Exception e) {
			return false;
		}
		log.info("starting of isDisplayedAddAnotherCategoryButton method");
		return false;
	}

	public void selectAnotherValueFromCategory(String text) {
		selCategoryOptions.click();
		pickFromWebElement(txtCategory, text);
	}

	public void selectAnotherValueFromSubCategory(String subcategory) {
		divSubcategory.click();
		pickFromWebElement(txtSubCategory, subcategory);
	}

	public void deleteSubcsategory(String replaceText) {

		pickFromWebElementListRadio(delIconSubcategoryCross, subcategoryList, replaceText);
	}

	public void enterSubCategory(String subcategory) {
		divSubcategory.click();
		Actions action = new Actions(driver);
		action.sendKeys(inpSubCategory, subcategory).sendKeys(Keys.ENTER).build().perform();

	}

	public void deleteIconCategory(String replaceText) {
		hardWait(3);
		pickFromWebElementList(imgDeleteSubcategory, iconDeleteCategory, replaceText);
	}

	public int getSizeOfDeleteSubcategory() {
		hardWait(3);
		return imgDeleteSubcategory.size();
	}

	public String getEffectivePrice() {
		String effectivePrice;
		if (inpEffectivePrice.getText().split("\\.")[1].equals("00")) {
			effectivePrice = inpEffectivePrice.getText().split("\\.")[0];
		} else {
			effectivePrice = inpEffectivePrice.getText();
		}

		System.out.println(effectivePrice);

		return effectivePrice;
	}

	public String fetchAttributeOfDiscount(String attributeValue) {
		return inpDiscount.getAttribute(attributeValue);
	}

	public int evaluateEffectivePrice() {
		String price = txtPrice.getAttribute("value");
		String discount = inpDiscount.getAttribute("value");
		int effectivePrice = Integer.parseInt(price) - Integer.parseInt(discount);

		return effectivePrice;
	}

	public void uncheckInternetHandelingCharge() {
		if (tglInternetCharges.getAttribute("class").contains("checked")) {
			scrollIntoView(tglInternetCharges);
			clickOnWebElement(tglInternetCharges);
		}

	}

	public double evaluateEffectivePriceWithInternetCharges() {
		String price = txtPrice.getAttribute("value");
		String discount = inpDiscount.getAttribute("value");
		String internetPrice = priceInternet.getText().split("₹ ")[1].split("\\)")[0];
		double effectivePrice = (double) ((Integer.parseInt(price) - Integer.parseInt(discount))
				+ Double.parseDouble(internetPrice));
		return effectivePrice;
	}

	public String getTaxDetailsPercentageValue() {
		hardWait(1);
		this.explicitWait(valTaxDetails);
		return valTaxDetails.getText();
	}

	public List<String> taxPercentageDropdownListValues() {
		ddTaxPercentage.click();
		List<String> percentageDropdownList = new ArrayList<String>();
		for (WebElement e : txtTaxPercentage) {
			percentageDropdownList.add(e.getText());
		}
		return percentageDropdownList;
	}

	public void selectCourseDurationPeriod(String duration) {
		ddCourseDuration.click();
		pickFromWebElement(selectCourseDuration, duration);
	}

	public void uncheckOfflineShipmentMaterial() {
		if (tglShipmentMaterial.getAttribute("class").contains("checked")) {
			scrollIntoView(tglShipmentMaterial);
			clickOnWebElement(tglShipmentMaterial);
		}
	}

	public boolean checkCourseGlobalCheckboxStatus() {
		if (chkCourseGlobal.getAttribute("class").contains("disabled"))
			return true;
		else
			return false;
	}

	public void editNamePermissions() {
		lnkViewPermissions.click();
		if (!tglEditPermissionsName.getAttribute("class").contains("checked")) {
			clickOnWebElement(tglEditPermissionsName);
		}
		btnSavePermissions.click();
	}

	public void clickViewPermissions() {
		log.info("Starting of clickViewPermissions method");
		lnkViewPermissions.click();
		log.info("Ending of clickViewPermissions method");

	}

	public boolean isInstallmentRemoveModalVisible() {
		log.info("Starting of isInstallmentRemoveModalVisible method");
		log.info("Ending of isInstallmentRemoveModalVisible method");
		try {
			return installmentRemoveModal.isDisplayed();

		} catch (Exception e) {
			return false;
		}

	}

	public String getInstallmentRemoveModalHeading() {
		log.info("Starting of getInstallmentRemoveModalHeading method");
		log.info("Ending of getInstallmentRemoveModalHeading method");
		return installmentRemoveModalHeading.getText();
	}

	public void clickOnInstallmentRemoveModalSaveChangesBtn() {
		log.info("Starting of clickOnInstallmentRemoveModalSaveChangesBtn method");
		installmentRemoveModalSaveChangesBtn.click();
		log.info("Ending of clickOnInstallmentRemoveModalSaveChangesBtn method");
	}

	public boolean isDisplayedEditCourseWindow() {
		log.info("Starting of isEditCourseWindowVisible method");
		try {
			if (editCourseWindow.isDisplayed())
				return true;

		} catch (Exception e) {
			return false;

		}
		log.info("Ending of isEditCourseWindowVisible method");
		return false;

	}

	public boolean isDisplayedEditPermissionsWindow() {
		log.info("Starting of isDisplayedEditPermissionsWindow method");
		try {
			if (editPermissionsWindow.isDisplayed())
				return true;

		} catch (Exception e) {
			return false;

		}
		log.info("Ending of isDisplayedEditPermissionsWindow method");
		return false;

	}

	public void clickOnEditPermissionsDiscardButton() {
		log.info("Starting of clickOnEditPermissionsDiscardButton method");
		btnDiscardEditPermissions.click();
		log.info("Ending of clickOnEditPermissionsDiscardButton method");
	}

	public String getExcludeTaxDetailsLbl() {
		log.info("Starting of getExcludeTaxDetailsLbl method");
		log.info("Ending of getExcludeTaxDetailsLbl method");
		return excludeTaxDetailsLbl.getText();
	}

	public void clickOnExcludeTaxDetailsCancelButton() {
		log.info("Starting of clickOnExcludeTaxDetailsCancelButton method");
		btnCancelExcludeTaxDetailsWindow.click();
		log.info("Ending of clickOnExcludeTaxDetailsCancelButton method");
	}

	public void clickSwitchOnToggleButton() {
		log.info("Starting of clickSwitchOnToggleButton method");
		btnSwitchOnToggle.click();
		log.info("Ending of clickSwitchOnToggleButton method");
	}
}
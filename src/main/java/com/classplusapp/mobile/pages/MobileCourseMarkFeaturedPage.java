package com.classplusapp.mobile.pages;

import org.openqa.selenium.WebElement;

import com.b2b.mobile.pages.base.B2BVisualComparisionPage;
import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusBaseMobileAutomationPage;

import io.appium.java_client.AppiumDriver;

public class MobileCourseMarkFeaturedPage extends ClassplusBaseMobileAutomationPage {

	@B2BFindBy(xpath = "{mobileCourseMarkFeaturedPage.btnStore.xpath}")
	private WebElement btnStore;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.txtSearchByName.id}")
	private WebElement txtSearchByName;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnCourseSelect.id}")
	private WebElement btnCourseSelect;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnThreeDottedMenu.id}")
	private WebElement btnThreeDottedMenu;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnMarkAsFeatured.id}")
	private WebElement btnMarkAsFeatured;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.lblFeaturedStarMark.id}")
	private WebElement lblFeaturedStarMark;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.toastMessage.id}")
	private WebElement toastMessage;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnCancel.id}")
	private WebElement btnCancel;
	
	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnRemoveCourse.id}")
	private WebElement btnRemoveCourse;

	@B2BFindBy(id = "{mobileCourseMarkFeaturedPage.btnRemoveCourseConfirm.id}")
	private WebElement btnRemoveCourseConfirm;

	@B2BFindBy(xpath = "{mobileCourseMarkFeaturedPage.lstFeaturedCourseCard.xpath}")
	private WebElement lstFeaturedCourseCard;

	public MobileCourseMarkFeaturedPage(AppiumDriver<WebElement> driver) {
		super(driver);
		logger.info("Starting of MobileCourseMarkFeaturedPage method");

		B2BPageFactory.initElements(driver, this);
		visualComparisionPage = new B2BVisualComparisionPage(driver);

		logger.info("Ending of MobileCourseMarkFeaturedPage method");
	}

	public void clickOnStoreTab() {
		logger.info("starting of clickOnStoreTab method");

		try {
			this.hardWait(5);
			this.btnStore.click();

		} catch (Exception e) {
			this.clickOnWebElement(btnStore);
		}

		logger.info("Ending of clickOnStoreTab method");
	}

	public void clickOnSearchByName(String courses) {
		logger.info("Starting of clickOnSearchByName method");

		try {
			this.hardWait(3);
			this.txtSearchByName.click();
			this.hardWait(3);
			this.txtSearchByName.sendKeys(courses);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Ending of clickOnSearchByName method");
	}

	public void clickOnCourseSelect() {
		logger.info("starting of clickOnCourseSelect method ");

		this.hardWait(3);
		this.btnCourseSelect.click();

		logger.info("ending of clickOnCourseSelect method");
	}

	public void clickOnMarkAsFeaturedButton() {
		logger.info("starting of clickOnStudentsTab method ");

		hardWait(3);
		this.btnMarkAsFeatured.click();

		logger.info("ending of clickOnStudentsTab method");
	}

	public void clickOnThreeDottedMenuButton() {
		logger.info("starting of clickOnThreeDottedMenuButton method ");

		hardWait(5);
		this.btnThreeDottedMenu.click();

		logger.info("ending of clickOnThreeDottedMenuButton method");
	}

	public boolean isDisplayedStarMark() {
		logger.info("Starting of isDisplayedStarMark method ");
		logger.info("Ending of isDisplayedStarMark method");
		try {
hardWait(2);
			return lblFeaturedStarMark.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getToastdMessage() {
		logger.info("Starting of getToastdMessage method");
		logger.info("Ending of getToastdMessage method");

		return toastMessage.getText();
	}

	public String getFeaturedCourse() {
		logger.info("Starting of getFeaturedCourse method ");
		logger.info("Ending of getFeaturedCourse method");

		return btnMarkAsFeatured.getText();

	}

	public void clickOnCourseCancelButton() {
		logger.info("Starting of clickOnCourseCancelButton method ");
		
		hardWait(2);
		this.btnCancel.click();

		logger.info("Ending of clickOnCourseCancelButton method");
	}

	public void clickOnRemoveCourseButton() {
		logger.info("starting of clickOnRemoveCourseButton method ");

		this.btnRemoveCourse.click();

		logger.info("ending of clickOnRemoveCourseButton method");
	}

	public void clickOnRemoveCourseConfirmButton() {
		logger.info("starting of clickOnRemoveCourseConfirmButton method ");

		this.btnRemoveCourseConfirm.click();

		logger.info("ending of clickOnRemoveCourseConfirmButton method");
	}

	public boolean lstFeaturedCourses() throws InterruptedException {

		for (int i = 0; i <= 8; i++) {
			this.verticalScroll();

		}
		try {
			if (lstFeaturedCourseCard.isDisplayed()) {
				this.horizontalScroll(lstFeaturedCourseCard);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isDisplayedCourseSelect() {
		logger.info("starting of isDisplayedCourseSelect method ");
		logger.info("ending of isDisplayedCourseSelect method");

		return btnCourseSelect.isDisplayed();
	}
	
	public boolean isDisplayedMarkFeaturedLabel() {
		logger.info("Starting of isDisplayedMarkFeaturedLabel method");
		logger.info("Ending of isDisplayedMarkFeaturedLabel method");

		try {
			btnMarkAsFeatured.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

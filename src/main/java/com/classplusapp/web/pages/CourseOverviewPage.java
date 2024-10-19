package com.classplusapp.web.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;

import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusappBasePage;

public class CourseOverviewPage extends ClassplusappBasePage {


	private static final Logger logger = LogManager.getLogger(CourseOverviewPage.class);

	@B2BFindBy(xpath = "{lftPnlOverview}")
	private WebElement lftPnlOverview;

	@B2BFindBy(xpath = "{btnPublishCourse}")
	private WebElement btnPublishCourse;

	@B2BFindBy(xpath = "{btnPublishCourseFinalAction}")
	private WebElement btnPublishCourseFinalAction;

	@B2BFindBy(xpath = "{btnPublishScreenCross}")
	private WebElement btnPublishScreenCross;

	@B2BFindBy(xpath = "{btnInstallmentGotItPopup}")
	private WebElement btnInstallmentGotItPopup;

	@B2BFindBy(xpath = "{dotsOverview}")
	private WebElement dotsOverview;

	@B2BFindBy(xpath = "{removeCourse}")
	private WebElement removeCourse;

	@B2BFindBy(xpath = "{lblRemoveConfirmationText}")
	private WebElement lblRemoveConfirmationText;

	@B2BFindBy(xpath = "{btnRemoveCourseConfirmation}")
	private WebElement btnRemoveCourseConfirmation;

	@B2BFindBy(xpath = "{markFeaturedCourse}")
	private WebElement markFeaturedCourse;

	@B2BFindBy(xpath = "{btnCourseFeaturedOkay}")
	private WebElement btnCourseFeaturedOkay;

	@B2BFindBy(xpath = "{btnAddFacultyInOverViewScreen}")
	private WebElement btnAddFacultyInOverViewScreen;

	@B2BFindBy(xpath = "{txtFacultyName}")
	private WebElement txtFacultyName;

	@B2BFindBy(xpath = "{txtFacultyMobileNumber}")
	private WebElement txtFacultyMobileNumber;

	@B2BFindBy(xpath = "{txtFacultyEmail}")
	private WebElement txtFacultyEmail;

	@B2BFindBy(xpath = "{btnAddFacultyInFacultyScreen}")
	private WebElement btnAddFacultyInFacultyScreen;

	@B2BFindBy(xpath = "{btnClose}")
	private WebElement btnClose;

	@B2BFindBy(xpath = "{lblAddedFaculty}")
	private WebElement lblAddedFaculty;

	@B2BFindBy(xpath = "{tentativeDelivery}")
	private WebElement tentativeDelivery;

	@B2BFindBy(xpath = "{indicatorOfflineShipmet}")
	private WebElement indicatorOfflineShipmet;

	@B2BFindBy(xpath = "{btnOverViewCreateInstallment}")
	private WebElement btnOverViewCreateInstallment;

	public CourseOverviewPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}


	public void clickOnOverviewLeftPanel() {
		hardWait(2);
		lftPnlOverview.click();
	}

	public void clickPublishCourseBtn() {

		this.hardWait(8);
		try {
			// this.explicitWait(btnPublishCourse);
			btnPublishCourse.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPublishCourse);
		}
	}

	public String getPublishCourse() {
		return btnPublishCourse.getText();

	}
	/*
	 * public void clickUnPublishCourseBtn() {
	 * 
	 * this.hardWait(2); try { // this.explicitWait(btnPublishCourse);
	 * btnUnPublish.click(); } catch (Exception e) {
	 * this.clickOnWebElement(btnUnPublish); } }
	 */
	

	public void closePublishModal() {
		logger.info("Starting of clickOnCrossButton method");

		try {
			btnPublishScreenCross.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnPublishScreenCross);
		}

		logger.info("Ending of clickOnCrossButton method");
	}

	public void clickPublishCourseAction() {
		try {
			btnPublishCourseFinalAction.click();
		} catch (Exception e) {
			clickOnWebElement(btnPublishCourseFinalAction);
		}
	}


	public boolean isDisplayedGotItPopup() {
		logger.info("Starting of isDisplayedGotItPopup method");
		boolean flag = false;
		logger.info("Ending of isDisplayedGotItPopup method");
		try {
			if (this.btnInstallmentGotItPopup.isDisplayed())
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void closeInstallmentGotItPopup() {
		logger.info("Starting of closeInstallmentGotItPopup method");

		try {
			this.btnInstallmentGotItPopup.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnInstallmentGotItPopup);
		}

		logger.info("Ending of closeInstallmentGotItPopup method");
	}

	public void clickDots() {
		// scrollIntoView(dotsOverview);
		clickOnWebElement(dotsOverview);
	}

	public void removeCourse() {
		this.hardWait(1);
		removeCourse.click();
	}

	public String getRemoveConfirmationTitle() {
		logger.info("Starting of getRemoveConfirmationText method");
		logger.info("Ending of getRemoveConfirmationText method");

		return lblRemoveConfirmationText.getText();
	}

	public void clickOnRemove() {
		hardWait(1);
		btnRemoveCourseConfirmation.click();
	}

	public void clickMarkFeatured() {
		try {
			markFeaturedCourse.click();
		} catch (Exception e) {
			clickOnWebElement(markFeaturedCourse);
		}

	}

	public void clickOkayMarkFeatured() {
		btnCourseFeaturedOkay.click();
	}

	public void clickOnAddButton() {
		logger.info("starting of clickOnAddButton  method");

		this.clickOnWebElement(btnAddFacultyInOverViewScreen);

		logger.info("Ending of clickOnAddButton method");
	}

	public void setfacultyName(String facultyName) {
		logger.info("Starting of setfacultyName method");

		this.txtFacultyName.sendKeys(facultyName);

		logger.info("Ending of setfacultyName method");
	}

	public void setFacultyMobileNumber(String FacultyMobileNumber) {
		logger.info("Starting of setFacultyMobileNumber method");

		this.txtFacultyMobileNumber.sendKeys(FacultyMobileNumber);

		logger.info("Ending of setFacultyMobileNumber method");
	}

	public void clickOnAddFacultyButton() {
		logger.info("starting of clickOnAddFacultyButton  method");

		this.clickOnWebElement(btnAddFacultyInFacultyScreen);

		logger.info("Ending of clickOnAddFacultyButton method");
	}

	public void enterEmail(String email) {
		logger.info("Starting of enterEmail method");

		try {
			this.txtFacultyEmail.sendKeys(email);
		} catch (Exception e) {
			// this.clickOnWebElement(txtFacultyEmail);
		}

		logger.info("Ending of enterEmail method");
	}

	public void clickOnCloseButton() {
		logger.info("starting of clickOnCloseButton  method");

		this.clickOnWebElement(btnClose);

		logger.info("Ending of clickOnCloseButton method");
	}

	public String getOfflineMaterialShipmentIndicator() {
		return indicatorOfflineShipmet.getText();
	}

	public boolean isDisplayedTenativeDeliveryLabel() {
		logger.info("starting of isDisplayedTenativeDeliveryLabel method");
		logger.info("Ending of isDisplayedTenativeDeliveryLabel method");

		try {
			this.explicitWait(tentativeDelivery);
			tentativeDelivery.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnCreateInstallment() {
		logger.info("Starting of ClickOnCreateInstallment method");

		try {
			explicitWait(btnOverViewCreateInstallment);
			this.btnOverViewCreateInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(btnOverViewCreateInstallment);
		}

		hardWait(2);

		logger.info("Ending of ClickOnCreateInstallment method");
	}

	public String getTenativeDeliveryLabel() {
		logger.info("starting of getTenativeDeliveryLabel method");
		logger.info("Ending of getTenativeDeliveryLabel method");
		
		return tentativeDelivery.getText();

	}}

package com.classplusapp.mobile.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.b2b.mobile.pages.base.B2BVisualComparisionPage;
import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusBaseMobileAutomationPage;

import io.appium.java_client.AppiumDriver;

public class MobilePhysicalDeliveryPage extends ClassplusBaseMobileAutomationPage {

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.lblOfflineShipment.id}")
	private WebElement lblOfflineShipment;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.lblPhysicalShipment.id}")
	private WebElement lblPhysicalMaterial;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.btnEditCourseDetails.id}")
	private WebElement btnEditCourseDetails;

	@B2BFindBy(xpath = "{mobilePhysicalDeliveryPage.btnSaveChanges.xpath}")
	private WebElement btnSaveChanges;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.chkTentativeDelivery.id}")
	private WebElement chkTentativeDelivery;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.lblTentativeDelivery.id}")
	private WebElement lblTentativeDelivery;

	@B2BFindBys(@B2BFindBy(xpath = "{mobileStudentCertificatePage.lblWhatElseCard.xpath}"))
	private List<WebElement> lblWhatElseCard;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.tglOfflineShipment.id}")
	private WebElement tglOfflineShipment;

	@B2BFindBy(id = "{mobilePhysicalDeliveryPage.lblRemovedIntallments.id}")
	private WebElement lblRemovedIntallments;

	public MobilePhysicalDeliveryPage(AppiumDriver<WebElement> driver) {
		super(driver);
		logger.info("Starting of MobileCourseMarkFeaturedPage method");

		B2BPageFactory.initElements(driver, this);
		visualComparisionPage = new B2BVisualComparisionPage(driver);

		logger.info("Ending of MobileCourseMarkFeaturedPage method");
	}

	public String getPhysicalMaterialLabel() {
		logger.info("Starting of getPhysicalMaterialLabel method ");
		logger.info("Ending of getPhysicalMaterialLabel method");

		return lblPhysicalMaterial.getText();

	}

	public String getOfflineShipmentLabel() {
		logger.info("Starting of getOfflineShipmentLabel method ");
		logger.info("Ending of getOfflineShipmentLabel method");

		return lblOfflineShipment.getText();

	}

	public void clickOnEditCourseDetailsButton() {
		logger.info("starting of clickOnStudentsTab method ");

		this.btnEditCourseDetails.click();

		logger.info("ending of clickOnStudentsTab method");
	}

	public void clickOnTentativeDeliveryCheckBox() throws InterruptedException {
		logger.info("starting of clickOnTentativeDeliveryCheckBox method ");

		for (int i = 0; i <= 4; i++) {
			verticalScroll();
		}

		this.chkTentativeDelivery.click();

		logger.info("ending of clickOnTentativeDeliveryCheckBox method");
	}

	public void clickOnSaveChangesButton() {
		logger.info("starting of clickOnSaveChangesButton method ");

		this.btnSaveChanges.click();

		logger.info("ending of clickOnSaveChangesButton method");
	}

	public String getTentativeDeliveryLabel() {
		logger.info("Starting of getTentativeDeliveryLabel method ");
		logger.info("Ending of getTentativeDeliveryLabel method");

		return lblTentativeDelivery.getText();

	}

	public String getWhatElseCardLabels() {
		return lblWhatElseCard.get(lblWhatElseCard.size() - 1).getText();
	}

	public void clickOnOfflineShipmentToggle() throws InterruptedException {
		logger.info("starting of clickOnOfflineShipmentToggle method ");

		for (int i = 0; i <= 4; i++) {
			verticalScroll();
		}

		this.tglOfflineShipment.click();

		logger.info("ending of clickOnOfflineShipmentToggle method");
	}

	public boolean isDisplayedWhatElseCardLabels() {
		List<String> whatElseCard = new ArrayList<String>();

		try {
			return lblWhatElseCard.get(1).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isDisplayedOfflineShipment() {
		logger.info("Starting of isDisplayedOfflineShipment method");
		logger.info("Ending of isDisplayedOfflineShipment method");

		try {
			lblOfflineShipment.getText();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getRemovedInstallmentsLabel() {
		logger.info("Starting of getRemovedInstallmentsLabel method ");
		logger.info("Ending of getRemovedInstallmentsLabel method");

		return lblRemovedIntallments.getText();

	}

	public boolean isDisplayedPhysicalMaterialTag() {
		logger.info("Starting of isDisplayedPhysicalMaterialTag method");
		logger.info("Ending of isDisplayedPhysicalMaterialTag method");

		try {
			return lblPhysicalMaterial.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
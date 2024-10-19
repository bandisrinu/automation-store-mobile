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

public class MobileStudentCertificatePage extends ClassplusBaseMobileAutomationPage {

	@B2BFindBy(id = "{mobileStudentCertificatePage.lblRedStarMark.id}")
	private WebElement lblRedStarMark;

	@B2BFindBy(id = "{mobileStudentCertificatePage.lblCourseCertificateAvailable.id}")
	private WebElement lblCourseCertificateAvailable;

	@B2BFindBy(xpath = "{mobileStudentCertificatePage.lblOverview.xpath}")
	private WebElement lblOverview;

	@B2BFindBy(id = "{mobileStudentCertificatePage.lblCertificationAvailable.id}")
	private WebElement lblCertificationAvailable;

	@B2BFindBys(@B2BFindBy(xpath = "{mobileStudentCertificatePage.lblWhatElseCard.xpath}"))
	private List<WebElement> lblWhatElseCard;

	public MobileStudentCertificatePage(AppiumDriver<WebElement> driver) {
		super(driver);
		logger.info("Starting of MobileCourseMarkFeaturedPage method");

		B2BPageFactory.initElements(driver, this);
		visualComparisionPage = new B2BVisualComparisionPage(driver);

		logger.info("Ending of MobileCourseMarkFeaturedPage method");
	}

	public boolean isDisplayedRedStarMark() {
		logger.info("Starting of isDisplayedStarMark method ");
		logger.info("Ending of isDisplayedStarMark method");
		try {
			hardWait(2);
			return lblRedStarMark.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getCourseCertificateAvailableLabel() {
		logger.info("Starting of getCourseCertificateAvailableLabel method");
		logger.info("Ending of getCourseCertificateAvailableLabel method");

		return lblCourseCertificateAvailable.getText();
	}

	public String getOverviewLabel() {
		logger.info("Starting of getOverviewLabel method ");
		logger.info("Ending of getOverviewLabel method");

		return lblOverview.getText();

	}

	public String getCertificationAvailableLabel() {
		logger.info("Starting of getCertificationAvailableLabel method ");
		logger.info("Ending of getCertificationAvailableLabel method");

		return lblCertificationAvailable.getText();

	}

	public List<String> getWhatElseCardLabels() {
		List<String> whatElseCard = new ArrayList<String>();

		for (int i = 1; i <= lblWhatElseCard.size(); i++) {

			whatElseCard.add(lblWhatElseCard.get(i).getText());

		}

		return whatElseCard;
	}

	public boolean isDisplayedWhatElseCardLabels() {
		List<String> whatElseCard = new ArrayList<String>();

		try {
			return lblWhatElseCard.get(1).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isDisplayedCertificateAvailable() {
		logger.info("Starting of isDisplayedCertificateAvailable method");
		logger.info("Ending of isDisplayedCertificateAvailable method");

		try {
			return lblCourseCertificateAvailable.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

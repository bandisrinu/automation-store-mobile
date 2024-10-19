package com.classplusapp.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusappBasePage;

public class InstallmentsPage extends ClassplusappBasePage {

	@B2BFindBy(xpath = "{txtGiveInstallments}")
	private WebElement txtGiveInstallments;

	@B2BFindBy(xpath = "{inputInstallmentPeriod}")
	private WebElement txtInstallmentPeriod;

	@B2BFindBy(xpath = "{txtSelectBiWkly}")
	private WebElement txtSelectBiWkly;

	@B2BFindBy(xpath = "{icnCloseInstallment}")
	private WebElement icnCloseInstallment;

	@B2BFindBy(xpath = "{btnCreateInstallmentInInstallments}")
	private WebElement btnCreateInstallmentInInstallments;

	@B2BFindBy(xpath = "{btnSetInstallment}")
	private WebElement btnSetInstallment;

	@B2BFindBy(xpath = "{btnDoneInInstallmentsPage}")
	private WebElement btnDoneInInstallmentsPage;

	public InstallmentsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	private static final Logger log = LogManager.getLogger(InstallmentsPage.class);

	public void clickOnInstallmentPeriod() {
		log.info("Starting of clickOnInstallmentPeriod method");
		try {
			this.txtInstallmentPeriod.click();
		} catch (Exception e) {
			this.clickOnWebElement(txtInstallmentPeriod);
		}

		log.info("Ending of clickOnInstallmentPeriod method");
	}

	public void txtInstallments(String Installments) {
		log.info("Starting of txtInstallments method");

		hardWait(2);
		txtGiveInstallments.click();
		this.txtGiveInstallments.clear();
		this.txtGiveInstallments.sendKeys(Installments);
		hardWait(2);

		log.info("Ending of txtInstallments method");
	}

	public void selectBiWkly() {
		log.info("Starting of selectBiWkly");

		this.txtSelectBiWkly.click();

		log.info("Ending of selectBiWkly");
	}

	public void clickOnCloseIcon() {
		log.info("Starting of selectBiWkly");

		clickOnWebElement(icnCloseInstallment);

		log.info("Ending of selectBiWkly");
	}

	public void clickOnCreateInstallmentButton() {
		log.info("Starting of clickOnCreateInstallmentButton method");

		hardWait(3);
		try {
			this.clickOnWebElement(btnCreateInstallmentInInstallments);
		} catch (Exception e) {
			this.btnCreateInstallmentInInstallments.click();
		}
		hardWait(2);

		log.info("Ending of clickOnCreateInstallmentButton method");
	}

	public void clickOnSetInstallmentButton() throws InterruptedException {
		log.info("Starting of ClickOnSetInstallmentButton");

		hardWait(3);

		try {
			this.btnSetInstallment.click();
		} catch (Exception e) {
			this.clickOnWebElement(this.btnSetInstallment);
		}

		log.info("Ending of ClickOnSetInstallmentButton");
	}

	public void clickOnDoneButton() {
		log.info("Starting of ClickDoneButton");

		hardWait(2);
		btnDoneInInstallmentsPage.click();
		hardWait(5);

		log.info("Ending of ClickDoneButton");
	}
}
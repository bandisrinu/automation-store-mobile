/**
 * 
 */
package com.classplusapp.base.test;

import java.net.MalformedURLException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.b2b.support.ParameterProvider;

import com.classplusapp.login.pages.ClassplusWebLoginPage;


/**
 * @author b2bte
 *
 */

public class ClassplusLoginBaseTest extends ClassplusBaseMobileAutomationTest {
	private static final Logger log = LogManager.getLogger(ClassplusLoginBaseTest.class);

	protected ClassplusWebLoginPage loginPage;

	/*
	 * public void launchWebSite(WebDriver webDriver) throws Exception {
	 * super.launchWebSite(webDriver); this.loginPage = new
	 * ClassplusWebLoginPage(webDriver); }
	 */

	public void siteLogin(String strOrgCode, String strMobileNumber, String strEmailAddress, WebDriver driver) {
		log.info("Starting siteLogin method");

		driver.get(loginURL);
		this.loginPage.clickOutside();
		this.loginPage.loginToClassplusUsingMobileNumber(strOrgCode, strMobileNumber, strEmailAddress);
		
		log.info("Ending siteLogin method");
	}

	public void logOut() {
		// this.loginPage.logOut();
	}

	public String getProperty(String fileName, String property) {
		return ParameterProvider.getInstance().getParameter(fileName, property);
	}
	

}
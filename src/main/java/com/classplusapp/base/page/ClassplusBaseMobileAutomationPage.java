package com.classplusapp.base.page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.b2b.mobile.pages.base.B2BBaseMobileAutomationPage;
import com.b2b.mobile.pages.base.B2BVisualComparisionPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class ClassplusBaseMobileAutomationPage extends B2BBaseMobileAutomationPage {

	protected AppiumDriver<WebElement> driver = null;

	protected B2BVisualComparisionPage visualComparisionPage = null;

	public static final Logger logger = LogManager.getLogger(ClassplusBaseMobileAutomationPage.class);

	public ClassplusBaseMobileAutomationPage(AppiumDriver<WebElement> driver) {
		super(driver);
	}

	public List<String> getListElementsText(List<WebElement> element) {
		logger.info("starting of getListElementsText method ");
		logger.info("ending of getListElementsText method");

		List<String> filterType = new ArrayList<String>();
		for (WebElement e : element) {
			filterType.add(e.getText());
		}
		return filterType;
	}

	public boolean isDisplayedCards(List<WebElement> element) {
		logger.info("starting of isDisplayedCards method ");
		logger.info("ending of isDisplayedCards method");

		try {
			if (element.get(0).isDisplayed()) {
				if (element.size() > 0) {
					return true;
				}
			}
		} catch (NoSuchElementException e) {
			return false;
		}
		return false;
	}

	public void clickOnFilterCheckBox(String filterType, List<WebElement> lblBeforeCheckBox,
			List<WebElement> chkelement) {
		logger.info("starting of clickOnFilterCheckBox method ");

		for (int i = 0; i < lblBeforeCheckBox.size(); i++) {
			System.out.println(lblBeforeCheckBox.get(i).getText());
			if (lblBeforeCheckBox.get(i).getText().equalsIgnoreCase(filterType)) {
				chkelement.get(i).click();
				break;
			}
		}
		logger.info("ending of clickOnFilterCheckBox method");
	}

	public boolean getFilteredLabels(List<WebElement> element, String filterType) {
		logger.info("starting of getFilteredLabels method ");
		logger.info("ending of getFilteredLabels method");
		for (int i = 0; i < element.size(); i++) {
			if (!(element.get(i).getText().trim().contains(filterType))) {
				return false;
			}
		}
		return true;
	}

	public void horizontalScroll(WebElement ele01) {
		logger.info("Starting of horizontalScroll Method");

		// Scrollable Element
		// WebElement ele01 = driver.findElement(AppiumBy.id("elementID"));

		int centerY = ele01.getRect().y + (ele01.getSize().height / 2);

		double startX = ele01.getRect().x + (ele01.getSize().width * 0.9);

		double endX = ele01.getRect().x + (ele01.getSize().width * 0.1);
		// Type of Pointer Input
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		// Creating Sequence object to add actions
		Sequence swipe = new Sequence(finger, 1);
		// Move finger into starting position
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
		// Finger comes down into contact with screen
		swipe.addAction(finger.createPointerDown(0));
		// Finger moves to end position
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
		// Get up Finger from screen
		swipe.addAction(finger.createPointerUp(0));

		// Perform the actions

		driver.perform(Arrays.asList(swipe));

		logger.info("Ending of horizontalScroll Method");
	}

	public boolean isScrollableStatsCards(WebElement element) {
		try {
			if (element.isDisplayed()) {
				horizontalScroll(element);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isDisplayedListOfElements(List<WebElement> element) {
		for (int i = 0; i <= element.size(); i++) {
			if (!element.get(i).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public void refreshPage() {
		logger.info("Starting of refreshPage method");

		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.9);

		int endX = startX;

		int startY = (int) (size.height * 0.2);

		int endY = (int) (size.height * 0.9);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		// Creating Sequence object to add actions
		Sequence swipe = new Sequence(finger, 1);
		// Move finger into starting position
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, (int) startY));
		// Finger comes down into contact with screen
		swipe.addAction(finger.createPointerDown(0));
		// Finger moves to end position
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(5000), PointerInput.Origin.viewport(), startX, (int) endY));
		// Get up Finger from Srceen
		swipe.addAction(finger.createPointerUp(0));

		// Perform the actions
		driver.perform(Arrays.asList(swipe));

		logger.info("Ending of refreshPage method");
	}

	public void androidScrollUsingText(String text) {
		logger.info("Starting of androidScrollUsingText method");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

		logger.info("Ending of androidScrollUsingText method");
	}
}


package com.classplusapp.mobile.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.b2b.mobile.pages.base.B2BVisualComparisionPage;
import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusBaseMobileAutomationPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class StoreHomePage extends ClassplusBaseMobileAutomationPage {

	@B2BFindBy(xpath = "{storeHomePage.btnStore.xpath}")
	private WebElement btnStore;

	@B2BFindBy(id = "{storeHomePage.txtSearchByName.id}")
	private WebElement txtSearchByName;

	@B2BFindBy(id = "{storeHomePage.btnCourseSelect.id}")
	private WebElement btnCourseSelect;

	@B2BFindBy(xpath = "{storeHomePage.lstMyCoursesAndContentMarket.xpath}")
	private List<WebElement> lstMyCoursesAndContentMarket;

	@B2BFindBy(xpath = "{storeHomePage.lstStatsAndCouponCode.xpath}")
	private List<WebElement> lstStatsAndCouponCode;

	@B2BFindBy(xpath = "{storeHomePage.inpSearchForCourses.xpath}")
	private WebElement inpSearchForCourses;

	@B2BFindBy(xpath = "{storeHomePage.lstStatsCards.xpath}")
	private List<WebElement> lstStatsCards;

	@B2BFindBy(xpath = "{storeHomePage.lstCouponCards.xpath}")
	private List<WebElement> lstCouponCards;

	@B2BFindBy(xpath = "{storeHomePage.lblCategoriesAndSubCategories.xpath}")
	private WebElement lblCategoriesAndSubCategories;

	@B2BFindBy(xpath = "{storeHomePage.lstCategoriesAndSubCategories.xpath}")
	private List<WebElement> lstCategoriesAndSubCategories;

	@B2BFindBy(xpath = "{storeHomePage.lblCourses.xpath}")
	private WebElement lblCourses;

	@B2BFindBy(xpath = "{storeHomePage.lstCourses.xpath}")
	private List<WebElement> lstCourses;

	@B2BFindBy(id = "{storeHomePage.lblViewAllCourses.id}")
	private WebElement lblViewAllCourses;

	@B2BFindBy(id = "{storeHomePage.icnFilters.id}")
	private WebElement icnFilter;

	@B2BFindBy(xpath = "{storeHomePage.lblMyCourses.xpath}")
	private WebElement lblMyCourses;

	@B2BFindBy(xpath = "{storeHomePage.lstCoursesAfterClickingOnSearch.xpath}")
	private List<WebElement> lstCoursesAfterClickingOnSearch;

	@B2BFindBy(xpath = "{storeHomePage.lblCourseName.xpath}")
	private List<WebElement> lblCourseName;

	@B2BFindBy(xpath = "{storeHomePage.lblFilters.xpath}")
	private WebElement lblFilters;

	@B2BFindBy(xpath = "{storeHomePage.lblFiltersTypes.xpath}")
	private List<WebElement> lblFiltersTypes;

	@B2BFindBy(xpath = "{storeHomePage.lblFiltersTypesHeadings.xpath}")
	private List<WebElement> lblFiltersTypesHeadings;

	@B2BFindBy(xpath = "{storeHomePage.lblFiltersInFiltersScreen.xpath}")
	private WebElement lblFiltersInFiltersScreen;

	@B2BFindBy(xpath = "{storeHomePage.chkFilters.xpath}")
	private List<WebElement> chkFilters;

	@B2BFindBy(id = "{storeHomePage.btnApply.id}")
	private WebElement btnApply;

	@B2BFindBy(id = "{storeHomePage.btnThreeDottedMenu.id}")
	private WebElement btnThreeDottedMenu;

	@B2BFindBy(xpath = "{storeHomePage.lblCreatedByYou.xpath}")
	private List<WebElement> lblCreatedByYou;

	@B2BFindBy(id = "{storeHomePage.btnUnPublishCourse.id}")
	private WebElement btnUnPublishCourse;

	@B2BFindBy(xpath = "{storeHomePage.lblUnPublished.xpath}")
	private List<WebElement> lblUnPublished;

	@B2BFindBy(xpath = "{storeHomePage.lblSortAndFiltersTypes.xpath}")
	private List<WebElement> lblSortAndOrderFiltersTypes;

	@B2BFindBy(xpath = "{storeHomePage.chkSortAndOrder.xpath}")
	private List<WebElement> rdoSortAndOrder;

	@B2BFindBy(xpath = "{storeHomePage.lblPricesInCourses.xpath}")
	private List<WebElement> lblPricesInCourses;

	@B2BFindBy(xpath = "{storeHomePage.lblFirstCoursePrice.xpath}")
	private WebElement lblFirstCoursePrice;

	@B2BFindBy(xpath = "{storeHomePage.lstStatsCardsName.xpath}")
	private List<WebElement> lstStatsCardsName;

	@B2BFindBy(xpath = "{storeHomePage.scrollStatsCards.xpath}")
	private WebElement scrollStatsCards;

	@B2BFindBy(xpath = "{storeHomePage.lstCouponCodes.xpath}")
	private WebElement lstCouponCodes;

	@B2BFindBy(xpath = "{storeHomePage.ScrollCategories.xpath}")
	private WebElement ScrollCategories;

	@B2BFindBy(xpath = "{storeHomePage.btnViewAll.xpath}")
	private WebElement btnViewAll;

	@B2BFindBy(xpath = "{storeHomePage.lblCategory.xpath}")
	private List<WebElement> lblCategory;

	@B2BFindBy(xpath = "{storeHomePage.lstSubCategory.xpath}")
	private List<WebElement> lstSubCategory;

	@B2BFindBy(xpath = "{storeHomePage.lstCategoryInAllCategoriesAndSubCategories.xpath}")
	private List<WebElement> lstCategoryInAllCategoriesAndSubCategories;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc = 'open']")
	private WebElement imgMenuBar;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Settings']")
	private WebElement lblSettings;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Sign Out']")
	private WebElement lblSignOut;

	@FindBy(xpath = "co.classplus.app.test:id/b_option_left")
	private WebElement btnCancel;

	@FindBy(xpath = "//android.widget.Button[@text = 'SIGN OUT']")
	private WebElement btnSignOut;

	public WebElement scrollToElement = null;

	public StoreHomePage(AppiumDriver<WebElement> driver) {
		super(driver);
		logger.info("Starting of CourseSortAndFilterPage method");

		B2BPageFactory.initElements(driver, this);
		visualComparisionPage = new B2BVisualComparisionPage(driver);

		logger.info("Starting of CourseSortAndFilterPage method");
	}

	public boolean isDisplayedStatsCardsCouponCardsCategoriesAndSubCategoriesLabels() {
		logger.info("starting of isDisplayedStatsCardsCouponCardsCategoriesAndSubCategoriesLabels method ");
		logger.info("ending of isDisplayedStatsCardsCouponCardsCategoriesAndSubCategoriesLabels method");

		if (isDisplayedCards(lstStatsCards) && isDisplayedCards(lstCouponCards)
				&& isDisplayedCards(lstCategoriesAndSubCategories) == true) {
			return true;
		}
		return false;
	}

	public boolean isDisplayedCoursesList() throws Exception {
		logger.info("starting of isDisplayedCoursesList method ");
		logger.info("ending of isDisplayedCoursesList method");

		this.verticalScroll();
		return isDisplayedCards(lstCourses);
	}

	public boolean isDisplayedCoursesListAfterClickingOnSearch() throws Exception {
		logger.info("starting of isDisplayedCoursesListAfterClickingOnSearch method ");
		logger.info("ending of isDisplayedCoursesListAfterClickingOnSearch method");

		return isDisplayedCards(lstCourses);
	}

	public String getCoursesLabel() {
		logger.info("starting of getCoursesLabel method ");
		logger.info("ending of getCoursesLabel method");

		return lblCourses.getText();
	}

	public boolean isDisplayedSubCategoriesList() throws Exception {
		logger.info("starting of isDisplayedCoursesListAfterClickingOnSearch method ");
		logger.info("ending of isDisplayedCoursesListAfterClickingOnSearch method");

		return isDisplayedCards(lstCategoryInAllCategoriesAndSubCategories);
	}

	public String getMyCoursesLabel() {
		logger.info("starting of getMyCoursesLabel method ");
		logger.info("ending of getMyCoursesLabel method");

		return lblMyCourses.getText();
	}

	public boolean getSearchedCourseNameLabel(String courseName) {
		logger.info("starting of getSearchedCourseNameLabel method ");

		for (int i = 0; i <= lblCourseName.size(); i++) {
			if (!(lblCourseName.get(i).getText().contains(courseName))) {
				return false;
			}
		}
		logger.info("ending of getSearchedCourseNameLabel method");
		return true;
	}

	public String getCategoriesAndSubCategoriesLabel() {
		logger.info("starting of isDisplayedViewAllCoursesLabel method ");
		logger.info("ending of isDisplayedViewAllCoursesLabel method");

		return lblCategoriesAndSubCategories.getText();
	}

	public String getViewAllCoursesLabel() throws Exception {
		logger.info("starting of getViewAllCoursesLabel method ");
		logger.info("ending of getViewAllCoursesLabel method");
		for (int i = 0; i <= 1; i++) {
			this.verticalScroll();
		}
		return lblViewAllCourses.getText();
	}

	public void clickOnViewAllCourses() throws InterruptedException {
		logger.info("starting of clickOnViewAllCourses method ");
		for (int i = 0; i <= 2; i++) {
			verticalScroll();
		}
		this.lblViewAllCourses.click();

		logger.info("ending of clickOnViewAllCourses method");
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

	public List<String> getMyCoursesAndContentMarketLabels() {
		logger.info("starting of getMyCoursesAndContentMarketLabels method ");
		logger.info("ending of getMyCoursesAndContentMarketLabels method");

		return getListElementsText(lstMyCoursesAndContentMarket);
	}

	public List<String> getStatsAndCouponCodesLabels() {
		logger.info("starting of getStatsAndCouponCodesLabels method ");
		logger.info("ending of getStatsAndCouponCodesLabels method");

		return getListElementsText(lstStatsAndCouponCode);
	}

	public String getSearchForCourses() {
		logger.info("starting of getSearchForCourses method ");
		logger.info("ending of getSearchForCourses method");

		return inpSearchForCourses.getText();
	}

	public void clickOnSearchBar() {
		logger.info("starting of clickOnSearchBar method ");

		inpSearchForCourses.click();

		logger.info("ending of clickOnSearchBar method");
	}

	public boolean isClickableSearchBar() {
		logger.info("starting of isClickableSearchBar method ");
		logger.info("ending of isClickableSearchBar method");

		try {
			if (inpSearchForCourses.isDisplayed()) {
				inpSearchForCourses.click();
				return true;
			}
		} catch (ElementClickInterceptedException e) {
			return false;
		}
		return false;
	}

	public boolean isDisplayedSearchBar() {
		logger.info("starting of isDisplayedFiltersIcon method ");
		logger.info("ending of isDisplayedFiltersIcon method");

		return inpSearchForCourses.isDisplayed();
	}

	public boolean isDisplayedFiltersIcon() {
		logger.info("starting of isDisplayedFiltersIcon method ");
		logger.info("ending of isDisplayedFiltersIcon method");

		try {
			return icnFilter.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnFiltersIcon() {
		logger.info("starting of clickOnFiltersIcon method ");

		icnFilter.click();

		logger.info("ending of clickOnFiltersIcon method");
	}

	public String getFiltersLabel() {
		logger.info("Starting of getFiltersLabel method");

		explicitWait(lblFilters);

		logger.info("Ending of getFiltersLabel method");
		return lblFilters.getText();
	}

	public List<String> getFiltersTypesLabels() throws Exception {
		logger.info("starting of getFiltersTypesLabels method ");
		logger.info("ending of getFiltersTypesLabels method");

		List<String> filterType = new ArrayList<String>();
		for (int i = 0; i < lblFiltersTypes.size(); i++) {
			if (i == 7) {
				continue;
			}
			filterType.add(lblFiltersTypes.get(i).getText());
			// if(i==lblFiltersTypes.size()/2) {
			this.verticalScroll();
			// }
		}
		return filterType;
	}

	public List<String> getFiltersHeadingsLabels() {
		logger.info("starting of getFiltersHeadingsLabels method ");
		logger.info("ending of getFiltersHeadingsLabels method");

		List<String> filterType = new ArrayList<String>();
		for (WebElement e : lblFiltersTypesHeadings) {
			filterType.add(e.getText());
		}
		return filterType;
	}

	public String getFiltersLabelInFiltersScreen() {
		logger.info("Starting of getFiltersLabelInFiltersScreen method");

		explicitWait(lblFiltersInFiltersScreen);

		logger.info("Ending of getFiltersLabelInFiltersScreen method");
		return lblFilters.getText();
	}

	public void clickOnFilterCheckBox(String filterType) {
		logger.info("starting of clickOnFiltersIcon method ");

		clickOnFilterCheckBox(filterType, lblFiltersTypes, chkFilters);

		logger.info("ending of clickOnFiltersIcon method");
	}

	public String isSelectedFiltersCheckbox(String filterType) {
		logger.info("starting of isSelectedFiltersCheckbox method ");
		logger.info("ending of isSelectedFiltersCheckbox method");
		String lblFilters = null;
		for (int i = 0; i < chkFilters.size(); i++) {
			System.out.println();
			if (lblFiltersTypes.get(i).getText().equalsIgnoreCase(filterType)) {
				lblFilters = chkFilters.get(i).getAttribute("checked");
				return lblFilters;
			}
		}
		return lblFilters;
	}

	public void clickOnApplyButton() {
		logger.info("starting of clickOnFiltersIcon method ");

		btnApply.click();

		logger.info("ending of clickOnFiltersIcon method");
	}

	public boolean getCreatedByYouLabels(String filterType) {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		return getFilteredLabels(lblCreatedByYou, filterType);
	}

	public void clickOnThreeDottedMenuButton() {
		logger.info("starting of clickOnThreeDottedMenuButton method ");

		this.btnThreeDottedMenu.click();

		logger.info("ending of clickOnThreeDottedMenuButton method");
	}

	public String getUnPublishCourseLabel() {
		logger.info("Starting of getUnPublishCourseLabel method");

		explicitWait(btnUnPublishCourse);

		logger.info("Ending of getUnPublishCourseLabel method");
		return btnUnPublishCourse.getText();
	}

	public boolean getUnPublishedLabels(String unPublished) {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		return getFilteredLabels(lblUnPublished, unPublished);
	}

	public boolean isDisplayedTagsOnCourses() {
		for (int i = 0; i <= lblUnPublished.size(); i++) {
			if (!(lblUnPublished.get(i).getText().contains("LIVE COURSE")
					|| lblUnPublished.get(i).getText().contains("UNPUBLISHED")
					|| lblUnPublished.get(i).getText().contains("Physical material"))) {
				return false;
			}
		}
		return true;
	}

	public void clickOnSortAndOrderRadioButton(String filterType) {
		logger.info("starting of clickOnSortAndOrderRadioButton method ");

		super.clickOnFilterCheckBox(filterType, lblSortAndOrderFiltersTypes, rdoSortAndOrder);

		logger.info("Ending of clickOnSortAndOrderRadioButton method ");

	}

	public boolean getLowToHighPriceRangeCourses() {
		logger.info("Starting of getLowToHighPriceRangeCourses method");

		int firstCoursePriceValue = Integer.parseInt(lblPricesInCourses.get(0).getText().substring(2));
		for (WebElement e : lblPricesInCourses) {
			this.explicitWait(e);
			if (!(firstCoursePriceValue <= Integer.parseInt(e.getText().substring(2)))) {
				return false;
			}
		}

		logger.info("Ending of getLowToHighPriceRangeCourses method");
		return true;
	}

	public boolean getHighToLowPriceRangeCourses() {
		logger.info("Starting of getLowToHighPriceRangeCourses method");
		long firstCoursePriceValue = Long.parseLong(lblFirstCoursePrice.getText().substring(2).replace(",", ""));
		for (WebElement e : lblPricesInCourses) {

			this.explicitWait(e);
			if (e.getText().startsWith("Imported")) {
				continue;
			} else {
				if (!(firstCoursePriceValue >= Long.parseLong(e.getText().substring(2).replace(",", "")))) {
					return false;
				}
			}
		}
		logger.info("Ending of getLowToHighPriceRangeCourses method");
		return true;
	}

	public List<String> getStatsCardsNames() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");
		List<String> statsCardsName = new ArrayList<String>();
		for (int i = 0; i <= lstStatsCardsName.size(); i++) {
			statsCardsName.add(lstStatsCardsName.get(i).getText());
			horizontalScroll(scrollStatsCards);
		}
		return statsCardsName;
	}

	public boolean isScrollableStatsCards() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");
		return isScrollableStatsCards(scrollStatsCards);
	}

	public boolean isScrollableCouponCodeCards() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		return isScrollableStatsCards(lstCouponCodes);
	}

	public boolean isDisplayedNumberOfCards(int i) {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");
		if (lstStatsCardsName.size() == i) {
			return true;
		}
		return false;
	}

	public boolean isScrollableCategoriesAndSubCategories() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");
		if (isScrollableStatsCards(ScrollCategories) == true) {
			lblCategory.get(0).click();
			hardBack();
			return true;
		}
		return false;
	}

	public String getViewAllText() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");
		return btnViewAll.getText();
	}

	public boolean isDisplayedCategories() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		return isDisplayedListOfElements(lblCategory);
	}

	public void clickOnSelectedCategory(String category) {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		for (int i = 0; i <= lblCategory.size(); i++) {
			if (lblCategory.get(i).getText().contains(category)) {
				lblCategory.get(i).click();
			}
		}
	}

	public boolean isDisplayedSubCategories() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		return isDisplayedListOfElements(lstSubCategory);
	}

	public boolean isDisplayedSearchCategory() {
		logger.info("starting of isDisplayedSearchCategory method ");
		logger.info("ending of isDisplayedSearchCategory method");

		return txtSearchByName.isDisplayed();
	}

	public List<String> getCourseNames() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		List<String> statsCardsName = new ArrayList<String>();
		for (int i = 0; i <= lblCourseName.size(); i++) {
			statsCardsName.add(lblCourseName.get(i).getText());
		}
		return statsCardsName;
	}

	public void clickOnSelectedSubCategory(String category) {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		for (int i = 0; i <= lblCategory.size(); i++) {
			if (lblCategory.get(i).getText().contains(category)) {
				lblCategory.get(i).click();
			}
		}
	}

	public void clickOnViewAllInCategoriesAndSubCategories() {
		logger.info("starting of clickOnViewAllInCategoriesAndSubCategories method ");

		btnViewAll.click();

		logger.info("ending of clickOnViewAllInCategoriesAndSubCategories method");
	}

	public boolean isScrollableCategories() {
		logger.info("starting of getCreatedByYouLabels method ");
		logger.info("ending of getCreatedByYouLabels method");

		try {
			this.verticalScroll();
			return true;
		} catch (Exception e) {
			return false;
		}
		// return false;
	}

	public void clickOnMenuBar() {
		logger.info("Starting of clickOnMenuBar method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.imgMenuBar.click();

		logger.info("Ending of clickOnMenuBar method");
	}

	public void clickOnSettingsButton() {
		logger.info("Starting of clickOnSettingsButton method");

		try {

			scrollToElement = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Settings\"));\""));

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.lblSettings.click();

		logger.info("Ending of clickOnSettingsButton method");
	}

	public void clickOnSignOutLabel() {
		logger.info("Starting of clickOnSignOutButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.lblSignOut.click();

		logger.info("Ending of clickOnSignOutButton method");
	}

	public void clickOnCancelButton() {
		logger.info("Starting of clickOnCancelButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.btnCancel.click();

		logger.info("Ending of clickOnCancelButton method");
	}

	public void clickOnSignOutButton() {
		logger.info("Starting of clickOnSignOutButton method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.btnSignOut.click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.lblSignOut.click();

		logger.info("Ending of clickOnSignOutButton method");

	}

	public void clickOnSignOut() {
		logger.info("Starting of clickOnSignOut method");

		this.clickOnMenuBar();
		this.clickOnSettingsButton();
		this.clickOnSignOutLabel();
		this.clickOnSignOutButton();

		logger.info("Ending of clickOnSignOut method");
	}
}

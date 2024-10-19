package com.classplusapp.web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.classplusapp.base.page.ClassplusappBasePage;

public class CourseMarkFeaturedPage extends ClassplusappBasePage {

	private static final Logger log = LogManager.getLogger(CourseMarkFeaturedPage.class);

	
	

	public CourseMarkFeaturedPage(WebDriver driver) {
		super(driver);
		log.info("Starting of CourseMarkFeaturedPage method");
		B2BPageFactory.initElements(driver, this);
		log.info("Ending of CourseMarkFeaturedPage method");
	}
}

	
package com.classplusapp.base.page;

import org.openqa.selenium.WebDriver;

import com.b2b.support.ParameterProvider;


public abstract class ClassplusappBasePage extends ClassplusBaseWebAutomationPage{
	
	public String getProperty(String fileName, String property) {
		return ParameterProvider.getInstance().getParameter(fileName, property);
	}
	
	
	public ClassplusappBasePage(WebDriver driver) {
		super(driver);
	}


}

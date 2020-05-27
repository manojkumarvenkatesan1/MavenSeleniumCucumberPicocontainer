package com.MavenSeleniumCucumberPicocontainer;


public class TextContext {


	
	 private WebDriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;


	 
	 public TestContext(){
	 webDriverManager = new WebDriverManager();
	 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	 }
	 
	 public WebDriverManager getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 
	}



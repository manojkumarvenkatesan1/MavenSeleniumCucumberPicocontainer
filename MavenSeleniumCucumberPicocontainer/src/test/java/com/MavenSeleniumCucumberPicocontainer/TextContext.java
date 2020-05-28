package com.MavenSeleniumCucumberPicocontainer;

import pageObjectManagement.PageObjectManager;
import webDriverManagement.WebDriverManager;

public class TextContext {

	 private WebDriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;
	 public ScenarioContext scenarioContext;

	 
	 public void TestContext(){
	 webDriverManager = new WebDriverManager();
	 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	 scenarioContext = new ScenarioContext();
	 }
	 
	 public WebDriverManager getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 public ScenarioContext getScenarioContext() {
	 return scenarioContext;
	 }
	 
	}



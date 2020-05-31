package com.MavenSeleniumCucumberPicocontainer;

import pageObjectManagement.PageObjectManager;
import webDriverManagement.WebDriverManager;

public class TextContext {

	
//How to Sharing Test Context between Cucumber Step Definitions using PicoContainer
/*	Add PicoContainer to the Project
	Create a Test Context class which will hold all the objects state
	Divide the Steps class into multiple steps classes with logical separation
	Write Constructor to share Test Context*/
	
	
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



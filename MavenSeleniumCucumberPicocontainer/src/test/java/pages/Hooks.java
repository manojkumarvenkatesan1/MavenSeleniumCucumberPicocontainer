package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.MavenSeleniumCucumberPicocontainer.TextContext;
import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	TextContext testContext;
	 
	 public Hooks(TextContext context) {
	 testContext = context;
	 }
	 
	 @Before
	 public void beforeScenario(Scenario scenario) {
	     Reporter.assignAuthor("ToolsQA - Lakshay Sharma");
	 }
	 
	 @After(order = 1)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
	 //This takes a screenshot from the driver at save it to the specified location
	 File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 }
	 }
	 

	 @After(order = 0)
	 public void AfterSteps() {
	 testContext.getWebDriverManager().closeDriver();
	 }
	 
	 
}

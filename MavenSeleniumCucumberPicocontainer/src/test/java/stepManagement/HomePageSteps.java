package stepManagement;

import com.MavenSeleniumCucumberPicocontainer.TextContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomePageSteps {

	TextContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TextContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		homePage.navigateTo_HomePage();	
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product)  {
		homePage.perform_Search(product);
	}
	
}

package com.swaglabs.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.swaglabs.pages.HomePage;

public class HomeSteps {

    private final String HOME_NOT_DISPLAYED_MESSAGE = "Home view is not displayed.";
    private HomePage homeView;
    
    private HomePage getHomeView() {
        if (homeView == null) {
            homeView = new HomePage();
        }
        return homeView;
    }
    
    @Then("The Home view is displayed")
    public void isHomeViewDisplayed() {
        Assert.assertTrue(getHomeView().isHomeDisplayed(), HOME_NOT_DISPLAYED_MESSAGE);
    }

    @When("The Home view is displayed and add an article in the cart")
    public void isHomeDisplayedAndAddArticle() {
    	HomePage homeView = getHomeView();
    	
    	if(homeView.isHomeDisplayed()) {
    		homeView.addArticle(1);
    	}

    }

    @Then("The Shopping Cart is not empty")
    public void isShoppingCartNotEmpty() {
    	Assert.assertTrue(Integer.parseInt(homeView.getCartArticle()) > 0);
    }
    
}

package com.swaglabs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import com.swaglabs.pages.LoginPage;

public class LoginSteps {

    private final String LOGIN_NOT_DISPLAYED_MESSAGE = "Login view is not Present.";
    private LoginPage loginView;
    
    private LoginPage getLoginView() {
        if (loginView == null) {
            loginView = new LoginPage();
        }
        return loginView;
    }
    
    @Given("The User is in Swaglabs Login Page")
    public void goToLoginPage() {
        getLoginView().goToBaseUrl();
        Assert.assertTrue(getLoginView().isLoginPresent(), LOGIN_NOT_DISPLAYED_MESSAGE);
    }

    @When("The User do the Login with '(.*)' and '(.*)'")
    public void doLoginProcess(String user, String password) {
        LoginPage loginView = getLoginView();
        loginView.setUser(user);
        loginView.setPassword(password);
        loginView.signIn();
    }

    @Then("The message '(.*)' is displayed")
    public void isErrorMessageDisplayed(String message) {
        Assert.assertEquals(getLoginView().getErrorMessage(), message);
    }

    @Given("The user is located in swaglabs Login page and logs in with '(.*)' and '(.*)'")
    public void doLogin(String user, String password) {
        LoginPage loginView = getLoginView();     
        loginView.goToBaseUrl();
        loginView.setUser(user);
        loginView.setPassword(password);
        loginView.signIn();
    }
}

package com.swaglabs.pages;

import org.openqa.selenium.By;

import com.swaglabs.PageCommons.PageCommons;

public class LoginPage extends PageCommons {

    private final String USERNAME_ID = "user-name";
    private final String PASSWORD_ID = "password";
    private final String SIGN_IN_ID = "login-button";
    private final String ERROR_MESSAGE_CSS = "h3[data-test='error']";

    
    public boolean isLoginPresent() {
        return isPresent(By.id(USERNAME_ID));
    }
    
    public void setUser(String user) {
        setInput(By.id(USERNAME_ID), user);
    }

    public void setPassword(String password) {
        setInput(By.id(PASSWORD_ID), password);
    }
    
    public void signIn() {
        click(By.id(SIGN_IN_ID));
    }
    
    public String getErrorMessage() {
        return getText(By.cssSelector(ERROR_MESSAGE_CSS));
    }
}

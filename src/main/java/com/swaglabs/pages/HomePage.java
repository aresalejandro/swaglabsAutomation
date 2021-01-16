package com.swaglabs.pages;

import org.openqa.selenium.By;

import com.swaglabs.PageCommons.PageCommons;

public class HomePage extends PageCommons {

    private final String INVENTORY_CONTAINER_ID = "inventory_container";
    private final String ADD_ARTICLE_XPATH = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button";
    private final String CART_ARTICLE_XPATH = "//*[@id=\"shopping_cart_container\"]/a/span";
    
    
    public boolean isHomeDisplayed() {
        return isPresent(By.id(INVENTORY_CONTAINER_ID));
    }
    
    public void addArticle(int article) {
        click(By.xpath(ADD_ARTICLE_XPATH));
    }
    
    public String getCartArticle() {
        return getText(By.xpath(CART_ARTICLE_XPATH));
    }
}

package org.example.pages;

import org.example.methods.Method;
import org.openqa.selenium.By;

public class BasketPage {
    Method method;
    FavoritePage favoritePage;
    public BasketPage(){
        method=new Method();
        favoritePage=new FavoritePage();
    }
    public void increaseQuantity(){
        favoritePage.removeProdFromFav();
        method.sendKeys(By.xpath("//input[@name='quantity']"),"3");
    }

}

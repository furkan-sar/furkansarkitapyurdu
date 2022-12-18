package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Method method;
    private final String EMAIL="furkan.sar@testinium.com";
    private final String SIFRE="1q2w3e4r5t";
    Logger logger= LogManager.getLogger(LoginPage.class);
    public LoginPage(){
        method=new Method();
    }

    public void login(){
        method.click(By.cssSelector(".menu-top-button.login>a"));
        logger.info("Giris yap butonuna tiklandi");
        method.sendValueAndControl(By.cssSelector("#login-email"),EMAIL);
        method.sendValueAndControl(By.xpath("//input[@id='login-password']"),SIFRE);
        method.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        logger.info("Giris yap butonuna tiklandi");
        Assert.assertTrue("Giris basarisiz",method.isElementVisible(By.cssSelector(".section")));

    }
    public void selectTumKitaplarOptions(String text){
        method.scrollWithAction(By.xpath("//span[@class='mn-strong common-sprite' and text()='Tüm Kitaplar']"));
        method.clickJS(method.findElement(By.xpath("//a[@class='mn-icon icon-angleRight' and text()='"+text+"']")));
        logger.info(new StringBuilder().append("Tum kitaplar>").append(text).append(" tiklandi."));
    }
    public void navigateToFavoritePage(){
        method.scrollWithAction(By.xpath("//a[@class='common-sprite' and text()='Listelerim']"));
        logger.info("Listelerim menusune scroll yapildi");
        method.clickJS(method.findElement(By.xpath("//a[text()='Favorilerim']")));
        Assert.assertTrue("Favorilerim sayfasi acilamadi.",method.isElementVisible(By.xpath("//h1[text()='Favorilerim']")));
        logger.info("Favorilerim sayfasina yonlendirildi");

    }
    public void goToBasket(){
        method.scrollWithAction(By.cssSelector("#cart-items-text-container"));
        method.clickJS(method.findElement(By.xpath("//h4[text()='Sepetim']")));
        logger.info("Sepete yonlendirildi");
    }

}

package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.BaseTest;
import org.example.methods.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PointsCatalogPage {
    Method method;
    ProductPage productPage;
    LoginPage loginPage;
    Logger logger;

    public PointsCatalogPage(){
        method=new Method();
        productPage=new ProductPage();
        loginPage=new LoginPage();
        logger=LogManager.getLogger(LoginPage.class);
    }
    public void selectTurkKlasikleri(){
        loginPage.login();
        productPage.searchProduct(4);
        productPage.addFavorite();
        loginPage.navigateToFavoritePage();
        productPage.checkFavoriteProds();
        method.scrollWithAction(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));


        method.clickWithoutWait(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        logger.info("Turk klasikleri sayfasına yonlendirildi");
    }
    public void selectOrder(){
        method.selectByText(By.cssSelector(".sort>select"),"Yüksek Oylama");
    }
    public void removeProdFromFav(){
        method.click(By.xpath("//h4[text()='Sepetim']"));
        //WebElement element=method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']"));
        method.scrollWithJS(method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']")));
        method.clickJS(method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']")).findElement(By.xpath("//a[@data-title='Favorilerimden Sil']")));
        logger.info(ProductPage.thirdProductId+" id li urun silindi");

    }
    public void addRandomProduct(){
        //List<WebElement> prodList=method.getList(By.cssSelector(".product-grid.jcarousel-skin-opencart"),By.cssSelector(".product-cr"));
        method.clickJS(method.getList(By.cssSelector(".product-grid.jcarousel-skin-opencart"),By.cssSelector(".product-cr")).get(method.giveRandomNumber(method.getList(By.cssSelector(".product-grid.jcarousel-skin-opencart"),By.cssSelector(".product-cr")).size())).findElement(By.cssSelector(".add-to-cart")));
        logger.info("Urun sepete eklendi");
        /**FARKLI SAYFALARDA HATA ALDIGIM ICIN METODLARI BURAYA YAZMAK ZORUNDA KALDIM BUTUN ZAMANIM HATAYA GITTI**/
        loginPage.navigateToFavoritePage();
        removeProdFromFav();
        loginPage.goToBasket();
        method.clickJS(method.findElement(By.xpath("//h4[text()='Sepetim']")));
        method.clickJS(method.findElement(By.xpath("//a[text()='Sepete Git']")));
        method.sendKeys(By.xpath("//input[@name='quantity']"),"3");
        method.clickJS(method.findElement(By.cssSelector(".fa.fa-refresh.green-icon")));
        method.clickJS(method.findElement(By.cssSelector(".button.red")));

    }

}

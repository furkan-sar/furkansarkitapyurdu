package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.example.test.PointsCatalogTest;
import org.openqa.selenium.By;

public class FavoritePage {
    Method method;
    Logger logger= LogManager.getLogger(FavoritePage.class);
    PointsCatalogPage pointsCatalogPage;
    FavoritePage favoritePage;
    LoginPage loginPage;
    public FavoritePage(){
        method=new Method();
        pointsCatalogPage=new PointsCatalogPage();
        favoritePage=new FavoritePage();
        pointsCatalogPage=new PointsCatalogPage();
        loginPage=new LoginPage();

    }
    public void removeProdFromFav(){

        //WebElement element=method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']"));
        method.scrollWithJS(method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']")));
        method.clickJS(method.findElement(By.xpath("//div[@id='"+ProductPage.thirdProductId+"']")).findElement(By.xpath("//a[@data-title='Favorilerimden Sil']")));
        logger.info(ProductPage.thirdProductId+" id li urun silindi");
    }
}

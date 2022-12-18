package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Method;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage {
    Method method;
    public static List<String> addedFavProd=new ArrayList<>();
    public static List<String> favoritePageProd=new ArrayList<>();
    public static String thirdProductId;
    public static List<WebElement> productList;
    Logger logger= LogManager.getLogger(ProductPage.class);
    public ProductPage(){
        method=new Method();
    }

    public List<WebElement> searchProduct(int numberOfItemSelected){
        method.sendValueAndControl(By.xpath("//input[@id='search-input']"),"oyuncak");
        method.click(By.cssSelector(".common-sprite.button-search"));
        productList=method.getList(By.cssSelector(".product-list"),By.cssSelector(".product-cr"));
        method.scrollWithActionWithMessage(productList.get(6),By.cssSelector("span"));
        Collections.shuffle(productList);
        productList.subList(numberOfItemSelected,productList.size()).clear();
        return productList;
    }

    public void addFavorite(){

        for(WebElement product:productList){
            method.clickJS(product.findElement(By.cssSelector(".add-to-favorites")));
            addedFavProd.add(product.findElement(By.cssSelector("span")).getText());
            logger.info(product.findElement(By.cssSelector("span")).getText()+" favorilere eklendi");
        }
        thirdProductId=productList.get(2).getAttribute("id");
        System.out.println(thirdProductId);

    }



    public void checkFavoriteProds(){
        List<WebElement> favProds=method.getList(By.cssSelector(".product-list"),By.cssSelector(".product-cr"));
        for(WebElement product:favProds){
            ProductPage.favoritePageProd.add(product.findElement(By.cssSelector(".name")).getText());
        }
        Collections.sort(ProductPage.favoritePageProd);
        Collections.sort(ProductPage.addedFavProd);
        Assert.assertTrue("Urunler favorilere eklenemedi",ProductPage.favoritePageProd.equals(ProductPage.addedFavProd));
        logger.info("Urunler favorilere eklendi");
        method.click(By.cssSelector(".logo-text>a"));
        method.click(By.xpath("//a[@href='puan-katalogu']"));
    }



}

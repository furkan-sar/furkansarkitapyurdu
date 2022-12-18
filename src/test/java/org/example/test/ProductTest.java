package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.junit.Before;
import org.junit.Test;


public class ProductTest extends BaseTest {
    ProductPage productPage;
    LoginPage loginPage;
    @Before
    public void ProductTest(){
        productPage=new ProductPage();
        loginPage=new LoginPage();
        loginPage.login();
    }

    @Test
    public void searchProductTest(){
        productPage.searchProduct(4);
    }
    @Test
    public void addFavoriteTest(){
        productPage.searchProduct(4);
        productPage.addFavorite();
    }
    @Test
    public void favoriteProductTest(){
        productPage.searchProduct(4);
        productPage.addFavorite();
        loginPage.navigateToFavoritePage();
        productPage.checkFavoriteProds();
    }

}

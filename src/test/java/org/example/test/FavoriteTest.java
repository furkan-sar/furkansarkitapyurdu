package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.FavoritePage;
import org.example.pages.LoginPage;
import org.example.pages.PointsCatalogPage;
import org.junit.Test;

public class FavoriteTest extends BaseTest {
    FavoritePage favoritePage;
    PointsCatalogPage pointsCatalogPage;
    LoginPage loginPage;
    @Test
    public void removeFromFavTest(){
        favoritePage=new FavoritePage();
        pointsCatalogPage=new PointsCatalogPage();
        loginPage=new LoginPage();
        pointsCatalogPage.selectTurkKlasikleri();
        pointsCatalogPage.selectOrder();
        loginPage.selectTumKitaplarOptions("Hobi");
        pointsCatalogPage.addRandomProduct();
        loginPage.navigateToFavoritePage();
        favoritePage.removeProdFromFav();
        loginPage.goToBasket();
    }
}

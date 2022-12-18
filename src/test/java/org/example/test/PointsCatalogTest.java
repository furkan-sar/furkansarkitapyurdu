package org.example.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.PointsCatalogPage;
import org.example.pages.ProductPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class PointsCatalogTest extends BaseTest {
    PointsCatalogPage pointsCatalogPage;
    LoginPage loginPage;

    @Before
    public void PointsCatalogTest(){
        pointsCatalogPage=new PointsCatalogPage();
        loginPage=new LoginPage();
    }
    @Test
    public void selectTurkKlasikleriTest(){
        pointsCatalogPage.selectTurkKlasikleri();
    }
    @Test
    public void selectOrderTest(){
        pointsCatalogPage.selectTurkKlasikleri();
        pointsCatalogPage.selectOrder();
    }

    @Test
    public void addRandomProductTest(){
        pointsCatalogPage.selectTurkKlasikleri();
        pointsCatalogPage.selectOrder();
        loginPage.selectTumKitaplarOptions("Hobi");
        pointsCatalogPage.addRandomProduct();

    }

}

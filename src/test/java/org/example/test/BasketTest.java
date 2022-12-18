package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.BasketPage;
import org.junit.Test;

public class BasketTest extends BaseTest {
    BasketPage basketPage;
    @Test
    public void increaseQuantityTest(){
        basketPage=new BasketPage();
        basketPage.increaseQuantity();
    }
}

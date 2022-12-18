package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void loginTest() {
        loginPage=new LoginPage();
        loginPage.login();
    }
}

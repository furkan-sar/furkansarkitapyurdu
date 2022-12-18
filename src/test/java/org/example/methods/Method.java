package org.example.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Method {
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsDriver;
    Logger logger= LogManager.getLogger(Method.class);
    public Method(){
        wait=new FluentWait<>(BaseTest.driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsDriver=(JavascriptExecutor)BaseTest.driver;

    }
    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public List<WebElement> getList(By paretLocator,By childLocator){
        return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(paretLocator,childLocator));
    }


    public void sendKeys(By by,String text){
        try {
            findElement(by).sendKeys(text);
        }
        catch (Exception e){
            logger.info(by+" ELEMENTINE "+text+" DEGERI GONDERILEMEDI");
        }
    }
    public void click(By by) {
            findElement(by).click();
            logger.info(getValue(by));
    }
    public void clickJS(WebElement element){
        jsDriver.executeScript("arguments[0].click();", element);
    }
    public void clickWithoutWait(By by){
        BaseTest.driver.findElement(by).click();
    }

    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public String getValue(By by){
        return findElement(by).getAttribute("value");
    }
    public void sendValueAndControl(By by,String value){
        sendKeys(by,value);
        logger.info(new StringBuilder().append("Deger girildi: ").append(value).append(" - Ilgili Element Locator: ").append(by));
        Assert.assertEquals("Degerler esit degil",value,getValue(by));
        logger.info(new StringBuilder().append("Degerler Esit - Gonderilen deger:").append(value).append(" - Alinan deger:").append(getValue(by)));
    }
    public void scrollWithActionWithMessage(WebElement webElement,By valueLocator){
        Actions actions=new Actions(BaseTest.driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(new StringBuilder().append(webElement.findElement(valueLocator).getText()).append(" urune scroll yapildi"));
    }

    public void scrollWithAction(By by){
        Actions actions=new Actions(BaseTest.driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by,String text){
        getSelect(by).selectByVisibleText(text);

    }
    public int giveRandomNumber(int endNumber){
        return new Random().nextInt(endNumber);
    }
    public void scrollWithJS(WebElement webElement){
        jsDriver.executeScript("arguments[0].scrollIntoView();",webElement);
    }

}

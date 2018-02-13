package stepDefinition;

import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class HelpSteps  {
WebDriver driver = InitialSteps.getDriver();
    public void pushButton(String button)
    {
        WebElement element = driver.findElement(By.xpath("//self::node()[text()='"+button+"']"));
        isElementPresent(element,30);
        element.click();
    }

    public void pushButton2(String button)
    {
        WebElement element = driver.findElement(By.xpath("(//self::node()[text()='"+button+"'])[2]"));
        isElementPresent(element,30);
        element.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(driver.findElement(By.xpath("//button[text()=\"Да\"]")).isDisplayed()) driver.findElement(By.xpath("//button[text()=\"Да\"]")).click();
    }

    public void enterData (String id, String placeholder, String data)
    {
        WebElement element = driver.findElement(By.xpath("//input[@id='"+id+"'][@placeholder='"+placeholder+"']"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData0 (String id, String data)
    {
        WebElement element = driver.findElement(By.xpath("//input[@name=\""+id+"\"]"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData2 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"accountNum\"]"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData3 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"balanceInitial\"]"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData4 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"balanceInitialCur\"]"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData5 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"balanceCur\"]"));
        element.clear();
        element.sendKeys(data);
    }

    public void enterData6 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"startDate\"]"));
        element.clear();
       // element.click();
        element.sendKeys(data);
    }

    public void enterData7 (String data)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//input[@name=\"endDate\"]"));
        element.clear();
       // element.click();
        element.sendKeys(data);
    }

    public boolean checkEnterDataDE ()
    {
        WebElement element = driver.findElement(By.xpath("//input[@class=\"form-control ng-pristine ng-untouched ng-valid\"]"));
        if(element.isEnabled()) return false;
        return true;
    }

    public boolean checkEnterDataE ()
    {
        WebElement element = driver.findElement(By.xpath("//select[@class=\"form-control ng-pristine ng-invalid ng-invalid-required ng-touched\"]"));
        if(element.isEnabled()) return true;
        return false;
    }

    public void checkElement(String element)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement el = driver.findElement(By.xpath("//self::node()[text()='"+element+"']"));
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        isElementPresent(el,30);
        el.isDisplayed();
        //assertEquals(el.getText(), element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    public void checkEl(String element)
    {

        WebElement el = driver.findElement(By.xpath("(//*[contains(text(),'"+element+"')])[1]"));
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        isElementPresent(el,30);
        el.isDisplayed();
        //assertEquals(el.getText(), element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }

    public void checkEl2(String element)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement el = driver.findElement(By.xpath("(//*[contains(text(),'"+element+"')])[2]"));
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
        isElementPresent(el,30);
        el.isDisplayed();
        //assertEquals(el.getText(), element);
        assertTrue(el.getText().equalsIgnoreCase(element));
    }


    public boolean isElementPresent (WebElement elementName, int timeout)
    {
        try
        {
         WebDriverWait wait = new WebDriverWait(driver,timeout);
         Thread.sleep(1000);
         wait.until(ExpectedConditions.visibilityOf(elementName));
          //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("jhj"));
         return  true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void chooseOptionInModalWindow(String element)
    {
        WebElement el = driver.findElement(By.xpath("//option[text()='"+element+"']"));
        isElementPresent(el, 30);
        el.click();
        //el.sendKeys(Keys.ESCAPE);
    }

    public void activeModalWin() {
/*
        if(driver.getWindowHandles().size() == 2)
        {
            for(String window : driver.getWindowHandles())
            {
                if(!window.equals(driver.getWindowHandle()))
                {

                    driver.switchTo().window(window);
                    break;
                }
            }

        }
*/
        driver.findElement(By.xpath("//button[text()=\"Да\"]")).click();
/*
     Actions actions = new Actions(driver);
     //actions.moveToElement(driver.findElement(By.xpath("//*[@class=\"modal-content\"]")));
        actions.moveToElement(driver.findElement(By.xpath("//h4[text()=\" Предупреждение\"]"))).click().build().perform();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//button[text()=\"Да\"]"))).click().build().perform();
       // actions.moveToElement(driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]")));
*/

      }

  }

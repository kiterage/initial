package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static stepDefinition.InitialSteps.driver;

public class header extends HelpSteps {

    public header (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }


    @FindBy(how = How.XPATH,
            using = "//img[@class='logo']")
    public WebElement logo;

    public void checkLogo(String el)
    {
       Assert.assertTrue(logo.getAttribute("title").equals(el));
    }

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
    public List<WebElement> navigationItems;

    public void clickOnNavigationItem(String el)
    {
        for (WebElement item : navigationItems)
        {
            if (item.getText().contains(el))
            {
                item.click();
            }
        }
    }

    @FindBy(how = How.XPATH, using = "//select[@class=\"form-control ng-pristine ng-invalid ng-invalid-required ng-touched\"]")
    public WebElement select;
    public void clickSelect()
    {
                   select.click();
    }

    @FindBy(how = How.XPATH, using = "//li/a[contains(@sua-access, '.list')]")
    public List<WebElement> itemsDropDownList;

    public void itemsDrop(String el) throws InterruptedException {
        Thread.sleep(4000);
        for (WebElement item : itemsDropDownList)
        {
            if (item.getText().contains(el))
            {
                item.click();
            }
        }
    }



    @FindAll({@FindBy(how=How.XPATH, using = "//*[@id=\"myTab\"]/li")})
    private List<WebElement> navigationElements;

/*    public List<String> getNavigationElementLabels()
    {
        return navigationElements
                .stream().limit(13)
                .map(WebElement :: getText)
                .collect(Collectors.toList());
    }*/


    public List<String> getNavigationElementLabels()
    {
        List<String> list = new ArrayList<String>();
        int i = 0;
        for(WebElement el : navigationElements)
        {
            System.out.println(el.getText());
            list.add(el.getText());
            i++;
            if(i == 13) break;
        }

       return list;
    }

    public boolean checkMoreElements (List<String> list)
    {
        for (int i = 0; i<=list.size();i++)
        {
            for(int j =0; j<=navigationElements.size(); j++)
            {
                if(list.get(i).contains((navigationElements.get(j)).getText())) break;
                else return false;
            }
        }
        return true;
      }

}

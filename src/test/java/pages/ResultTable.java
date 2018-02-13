package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;

public class ResultTable extends HelpSteps {


    public ResultTable (WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50),this);
    }

    @FindBy(how = How.XPATH, using = "//form/ol//*")
    public List<WebElement> tableTitle;

    public void checkTitle(String el) throws InterruptedException
    {
        for (WebElement item : tableTitle)
        {
            Assert.assertEquals(item.getText(), el);
        }
    }

    @FindBy(how = How.XPATH, using = "(//span[@class='ui-icon fa fa-search fa-fw'])[1]")
    public WebElement buttonSearch;

    public void pushSearchButton() throws InterruptedException
    {
       isElementPresent(buttonSearch, 30);
       buttonSearch.click();
    }

    @FindBy(how = How.XPATH, using = "//td[contains(test(),'')]")
    public List<WebElement> items;

    public boolean checkItems(String el)
    {
        for(WebElement element : items)
        {
            if (element.getText().equals(el)) return true;
        }
      return false;
    }

}

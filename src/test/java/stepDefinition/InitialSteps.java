package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginForm;
import pages.ModalWindowSearchTable;
import pages.ResultTable;
import pages.header;

public class InitialSteps {

    public static WebDriver driver;
    public static header header;
    public static LoginForm loginForm;
    public static ResultTable resultTable;
    public static ModalWindowSearchTable MWS;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    "chromedriver.exe"
            );
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");
            driver = new ChromeDriver(options);
            //       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            //       capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            //      driver = new ChromeDriver(capabilities);
            //driver.get("http://172.26.25.86:8081/sua/login");
            header = new header(driver);
            loginForm = new LoginForm(driver);
            resultTable = new ResultTable(driver);
            MWS = new ModalWindowSearchTable(driver);
        }
        return driver;
    }

    @Before
  //  @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser() throws Throwable {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
    }

    @Before
    public void af0() throws InterruptedException

    {
        driver.findElement(By.xpath("//input[@id=\"username\"][@placeholder=\"Имя пользователя\"]")).sendKeys("sua_all");
        driver.findElement(By.xpath("//input[@id=\"password\"][@placeholder=\"Пароль\"]")).sendKeys("Q1w2e3r4");
        driver.findElement(By.xpath("//self::node()[text()=\"Войти\"]")).click();
        Thread.sleep(1000);
    }


     @Before
     public void af() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//self::node()[text()=\"Поиск\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[text()=\"Балансовая стоимость\"]")).click();
        driver.findElement(By.xpath("//option[text()=//*[@class=\"input-elm\"]")).sendKeys("202");
        driver.findElement(By.xpath("//self::node()[text()=\"Найти\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@ng-model=\"allChecked\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//self::node()[text()=\"Удалить\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//self::node()[text()=\"Да\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//self::node()[text()=\"Закрыть\"]")).click();
    }

    @Before
     public void браузер_закрыт() throws Throwable {
        driver.quit();
        driver = null;
    }


}

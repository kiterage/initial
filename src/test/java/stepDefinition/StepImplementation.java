package stepDefinition;


import cucumber.api.DataTable;
import cucumber.api.java.ru.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static stepDefinition.InitialSteps.loginForm;
import static stepDefinition.InitialSteps.header;
import static stepDefinition.InitialSteps.resultTable;
import static stepDefinition.InitialSteps.MWS;

public class StepImplementation extends HelpSteps {

    @Пусть("^открывается модальное окно \"([^\"]*)\"$")
    @А("^открывается страница с сообщение \"([^\"]*)\"$")
    @И("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    @Тогда("^открывается модальнольное окно \"([^\"]*)\"$")
    // @Дано("^открывается страница с формой \"([^\"]*)\"$")
    public void openPageForm(String window) throws Throwable {
        checkElement(window);
    }

    @Дано("^открывается страница с формой \"([^\"]*)\"$")
    public void openPageForma(String window) throws Throwable {
        checkElement(window);
    }

    @Дано("^открывается страница \"([^\"]*)\"$")
    public void openPageForma2(String window) throws Throwable {
        checkEl2(window);
    }

    @И("^пользователь вводит в поле \"Пароль\" значением \"([^\"]*)\"$")
    public void userFillsPasswordField(String password) throws Throwable {
        enterData("password", "Пароль", password);
    }

    @А("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\" типа КО$")
    @И("^пользователь нажимает \"([^\"]*)\" в контекстном меню$")
    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void clickOnEl(String element) throws Throwable {
        pushButton(element);
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void oopenPage(String logo) throws Throwable {
        header.checkLogo(logo);
    }

    @Когда("^пользователь заполняет поля \"Имя пользователя\" и \"Пароль\" значениями$")
    public void полльзователь_заполняет_поля_Пароль_значениями(DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0));
        enterData("password", "Пароль", list.get(1));

    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void userFillsLoginForm(String fieldName, String value) throws Throwable {
        loginForm.enterDataLoginForm(fieldName, value);
    }

    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_с_выпадающим_списком(String element) throws Throwable {
        header.clickOnNavigationItem(element);
    }

    @Тогда("^польльзователь выбирает пункт \"([^\"]*)\"$")
    public void польльзователь_выбирает_пункт(String element) throws Throwable {
        header.itemsDrop(element);
    }


    @Тогда("^открывается страница с таблицей \"([^\"]*)\"$")
    public void openPageWithTable(String value) throws Throwable {
        resultTable.checkTitle(value);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void userPush(String arg1) throws Throwable {
        resultTable.pushSearchButton();
    }

    @И("^польльзователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"Тип актива функциональный\"$")
    @Пусть("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"содержит\"$")
    @То("^пользователь выбирает пункт \"([^\"]*)\" в выпадащем списке \"ID Плана Счетов\"$")
    public void choosenOption(String value) throws Throwable {
        chooseOptionInModalWindow(value);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void userFills(String value) throws Throwable {
        MWS.inputDate(value);
    }

    @Тогда("^отображается \"Номер счёта 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void checkPresens(String el) throws Throwable {
        resultTable.checkItems(el);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Тогда("^\"Наименование ФО \" должно быть недоступено для заполнения$")
    public void должно_быть_недоступено_для_заполнения() throws Throwable {
        checkEnterDataDE();
    }

    @Тогда("^\"Тип актива функциональный \" должен быть доступен для заполнения$")
    public void должен_быть_доступен_для_заполнения() throws Throwable {
        checkEnterDataE();
    }

    @Тогда("^пользователь нажимает на всплывающее меню \"Тип актива функциональный \"$")
    public void пользователь_нажимает_на_всплывающее_меню() throws Throwable {
        header.clickSelect();
    }

    @Тогда("^элементы присутствуют на странице$")
    public void элементы_присутствуют_на_странице(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
      /*Assert.assertEquals(list,header.getNavigationElementLabels());
        System.out.println(list);
        System.out.println(header.getNavigationElementLabels());*/
        header.checkMoreElements(list);
    }

    @Тогда("^пользователь заполняет поле 2 \"Номер счёта\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String data) throws Throwable {
        enterData2(data);
    }

    @Тогда("^пользователь заполняет поле 3 \"Начальная балансовая стоимость\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением2(String data) throws Throwable {
        enterData3(data);
    }

    @Тогда("^пользователь заполняет поле 4 \"В валюте счёта\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением3(String data) throws Throwable {
        enterData4(data);
    }

    @Тогда("^пользователь заполняет поле 5 \"В валюте счёта 2\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением4(String data) throws Throwable {
        enterData5(data);
    }

    @Тогда("^пользователь заполняет поле 6 \"Дата начала действия актива\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значение54(String data) throws Throwable {
       enterData6(data);
    }

    @Тогда("^пользователь заполняет поле 7 \"Дата окончания действия актива\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением6(String data) throws Throwable {
        enterData7(data);
    }

    @Когда("^пользователь нажимает кнопку 2 \"([^\"]*)\"$")
    public void pushButton23(String element) throws Throwable {
        pushButton2(element);

    }


}
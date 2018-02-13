# language: ru
Функционал: Создание нового актива типа "Доли в уставных капиталах обществ" для ФО типа КО

  Предыстория:
    Дано открыт браузер и осуществлен переход по ссылке
    И открывается страница с формой "Вход в систему"
    Когда пользователь заполняет поле "Имя пользователя" значением "sua_all"
    И пользователь вводит в поле "Пароль" значением "Q1w2e3r4"
    И пользователь нажимает кнопку "Войти"
    Тогда открывается модальное окно "Выбор финансовой организации"
    Когда пользователь выбирает финансовую организацию "10" типа КО
    И пользователь нажимает кнопку "Выбрать"
    Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
    Тогда открывается страница с финансовой организацией "10"


  @11120
  Сценарий: Создание нового актива типа "Доли в уставных капиталах обществ" для ФО типа КО
    И пользователь нажимает кнопку с выпадающим списком "Сбор и ведение данных"
    И польльзователь выбирает пункт "Список активов"
    Тогда открывается страница "Список активов"
    И пользователь нажимает кнопку "Создать"
    Тогда открывается страница с формой "Создание актива (первый этап)"
    Тогда "Наименование ФО " должно быть недоступено для заполнения
    И польльзователь выбирает пункт "Доли в уставных капитала" в выпадающем списке "Тип актива функциональный"
    И пользователь нажимает кнопку "Далее"
    Тогда открывается страница с формой "Создание актива (второй этап)"
    И элементы присутствуют на странице
      | Основная информация |
      | Приём               |

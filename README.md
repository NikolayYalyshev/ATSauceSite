# ATSauceSite
Автоматизированный тест на базе Selenide с использованием паттерна PageObject и подхода Steps.
Стек:
    язык : java
    фраймворк : junit5, maven
    библиотеки : selenide, aeonbits, allure
Требования:
    SDK : java11 и выше
    driver : default selenide
Структура проекта: 
    src/main/java/pages - PO pattern
    src/main/java/helpers - входные данные для тестов
    src/test/java/tests - тесты
Тестируем: 
  [x] Авторизация с валидными данными.
  [x] Добавление товара в корзину.
  [x] Проверить что добавился один выбранный товар в корзину.
Отчёт:
    В проекте настроена генерация подробных отчетов Allure. После завершения тестов выполните команду:
'mvn allure:serve'

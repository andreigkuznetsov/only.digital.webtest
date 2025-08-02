# Only.Digital Web UI Autotest

[![Java](https://img.shields.io/badge/Java-21+-orange)](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
[![Selenide](https://img.shields.io/badge/Selenide-6.19.1-brightgreen)](https://selenide.org/)

## Описание

Автоматизированный UI-тест для сайта [only.digital](https://only.digital), написанный на Java с использованием Selenide, JUnit 5, Gradle.  
Тест проверяет корректность отображения и функциональность футера сайта в десктопной версии.

## Технологии и инструменты

- Java 21
- Selenide 6.19.1
- Selenium 4.13.0
- JUnit 5
- Gradle
- ChromeDriver

## Как запустить тесты

Перед запуском убедитесь, что установлен [Chrome](https://www.google.com/chrome/) последней версии и прописан [chromedriver](https://chromedriver.chromium.org/downloads) в `PATH` (обычно Selenide скачивает его сам).

### Через терминал

```bash
./gradlew clean test
```

### Через IntelliJ IDEA

1. **Откройте проект** в IntelliJ IDEA.
2. **Запустите тест:**
    - Чтобы запустить весь класс с тестами — нажмите на иконку ▶ рядом с именем класса.
    - Чтобы запустить отдельный тестовый метод — нажмите на иконку ▶ рядом с методом.

---

### Параметры запуска

Для тестов доступны параметры конфигурации через переменные окружения или system properties:

```bash
- `-Dselenide.browser=chrome` — браузер для запуска (по умолчанию chrome)
- `-Dselenide.headless=true` — запуск без UI (headless mode)
- `-Dselenide.browserSize=1920x1080` — размер окна браузера
```
---

### Пример запуска тестов с параметрами

```sh
./gradlew clean test -Dselenide.browser=chrome -Dselenide.headless=true -Dselenide.browserSize=1920x1080

package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FooterTest {

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        open("https://only.digital/");
        closeCookieIfExists();
    }

    @Test
    void footerElementsShouldBePresentOnDesktop() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        SelenideElement footer = $(".Footer_root___6Q28").shouldBe(visible, Duration.ofSeconds(10));
        footer.$("button.Footer_button__RHd0Q").shouldHave(text("Начать проект"));
        footer.$("svg.Footer_logo__2QEhf").should(exist);
        footer.$(".Footer_socials__C39yX a[href*='behance']").shouldHave(text("be"));
        footer.$(".Footer_socials__C39yX a[href*='dprofile']").shouldHave(text("dp"));
        footer.$(".Footer_socials__C39yX a[href*='t.me/onlycreativedigitalagency']").shouldHave(text("tg"));
        footer.$(".Footer_socials__C39yX a[href*='vk.com']").shouldHave(text("vk"));
        footer.$(".Footer_telegram__Y0DSn").shouldBe(visible, Duration.ofSeconds(6))
                .shouldHave(text("Telegram для связи"));
        footer.$(".Footer_telegram__Y0DSn a[href*='t.me/onlydigitalagency']")
                .shouldBe(visible, Duration.ofSeconds(6))
                .shouldHave(text("@onlydigitalagency"));
        footer.$(".Footer_contacts__s7c9v a[href^='mailto:']").shouldHave(text("hello@only.digital"));
        footer.$(".Footer_contacts__s7c9v a[href^='tel:']").shouldHave(text("+7 (495) 740 99 79"));
        footer.$(".Footer_text___ATim").shouldHave(text("Создаем digital-продукт"));
        footer.$(".Footer_documents___mRvU a[href$='.pdf']").shouldHave(text("pdf"));
        footer.$(".Footer_documents___mRvU a[href*='pitch']").shouldHave(text("pitch"));
        footer.$(".Footer_year__nyNCc").shouldHave(text("© 2014 - 2025"));
        SelenideElement creativeBlock = footer.$(".FooterText_root___Rdpb").shouldBe(visible, Duration.ofSeconds(8));
        creativeBlock.$$(".word").shouldHave(CollectionCondition.texts("creative", "digital", "production"));
        footer.$(".Footer_privacy__NdtU9").shouldHave(text("Политика конфиденциальности"));
    }

    void closeCookieIfExists() {
        if ($$("button").findBy(text("ok")).exists()) {
            $$("button").findBy(text("ok")).click();
        }
    }
}
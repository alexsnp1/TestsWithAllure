import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Tests {

    @Test
    void allureTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $("[data-action='click:qbsearch-input#searchInputContainerClicked']").click();
        $("#query-builder-test").setValue("qa-guru").pressEnter();
        $("[href='/qa-guru/niffler-ng-6']").click();
        $("#issues-tab").click();
        $("[data-testid='issue-pr-title-link']").shouldHave(text("[BUG] Тестовый баг для проверка работы аннотации"));

    }

    @Test
    void lambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Открываем строку поиска", () -> {
            $("[data-action='click:qbsearch-input#searchInputContainerClicked']").click();
        });
        step("Ищем репозиторий", () -> {
            $("#query-builder-test").setValue("qa-guru").pressEnter();
        });
        step("Кликаем по ссылке репозитория", () -> {
            $("[href='/qa-guru/niffler-ng-6']").click();
        });
        step("Открываем Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем название Issue", () -> {
            $("[data-testid='issue-pr-title-link']")
                    .shouldHave(text("[BUG] Тестовый баг для проверка работы аннотации"));
        });

    }
    @Test
    public void stepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Stepiki stepiki = new Stepiki();
        stepiki.openMainPage();
        stepiki.openSearchBar();
        stepiki.searchForRepository();
        stepiki.openRepositoryLink();
        stepiki.openIssuesTab();
        stepiki.checkIssueName();
    }
}

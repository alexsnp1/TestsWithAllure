import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Stepiki {
    @Step ("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }
    @Step ("Открываем строку поиска")
    public void openSearchBar() {
        $("[data-action='click:qbsearch-input#searchInputContainerClicked']").click();
    }
    @Step ("Ищем репозиторий")
    public void searchForRepository() {
        $("#query-builder-test").setValue("qa-guru").pressEnter();
    }
    @Step ("Кликаем по ссылке репозитория")
    public void OpenRepositoryLink() {
        $("[href='/qa-guru/niffler-ng-6']").click();
    }
    @Step ("Открываем Issues")
    public void OpenIssuesTab() {
        $("#issues-tab").click();
    }
    @Step ("Проверяем название Issue")
    public void checkIssueName() {
        $("[data-testid='issue-pr-title-link']")
                .shouldHave(text("[BUG] Тестовый баг для проверка работы аннотации"));
    }

}

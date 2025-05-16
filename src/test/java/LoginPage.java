import org.openqa.selenium.By;

public class LoginPage extends PageObjects{

    public static final String URL_DASHBOARD = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    public static final String URL_LOGIN = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public LoginPage() {
        super(null);
        browser.navigate().to(URL_LOGIN);
    }

    public DashboardPage inserirDadosParaLogin(String username, String password) {
        browser.findElement(By.name("username")).sendKeys(username);
        browser.findElement(By.name("password")).sendKeys(password);
        browser.findElement(By.cssSelector(".oxd-form")).submit();

        return new DashboardPage(browser);
    }

    public boolean isAtualUrlIgualUrlDashboard() {
        return browser.getCurrentUrl().equals(URL_DASHBOARD);
    }

    public boolean isElementoDashboardInexistente() {
        return browser.findElements(By.cssSelector(".oxd-grid-3.orangehrm-dashboard-grid")).isEmpty();
    }

    public boolean isAtualUrlIgualUrlLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isElementoFormularioLoginInexistente() {
        return browser.findElements(By.cssSelector(".oxd-form")).isEmpty();
    }

    public String getSpanRequired() {
        return browser.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")).getText();
    }

    public String getAlertInvalidCredentials() {
        return browser.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
    }
}

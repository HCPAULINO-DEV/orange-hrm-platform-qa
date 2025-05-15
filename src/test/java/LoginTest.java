import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach(){
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        loginPage.quit();
    }

    @Test
    public void deveRealizarLogin(){
        loginPage.inserirDadosParaLogin("Admin", "admin123");

        Assertions.assertTrue(loginPage.isAtualUrlIgualUrlHome());
        Assertions.assertTrue(!loginPage.isElementoDashboardInexistente());
        Assertions.assertFalse(loginPage.isAtualUrlIgualUrlLogin());
        Assertions.assertFalse(!loginPage.isElementoFormularioLoginInexistente());
    }

    @Test
    public void naoDeveRealizarLoginComDadosInvalidos(){
        loginPage.inserirDadosParaLogin("", "");

        Assertions.assertFalse(loginPage.isAtualUrlIgualUrlHome());
        Assertions.assertFalse(!loginPage.isElementoDashboardInexistente());
        Assertions.assertTrue(loginPage.isAtualUrlIgualUrlLogin());
        Assertions.assertTrue(!loginPage.isElementoFormularioLoginInexistente());
    }


}

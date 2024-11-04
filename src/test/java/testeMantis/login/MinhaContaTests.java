package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade Minha Conta")

public class MinhaContaTests {
    @Test
    @DisplayName("Visualisar Minha Conta")
    public void testAcessarMinhaConta () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        LoginTests novoLogin = new LoginTests();
        novoLogin.testRegistrarUmNovoUsuarioComDadosValidos(navegador, "Lucas_Silva", "FR?8Q46E<tn");

        // Espera 5 segundos até chamar alguma excessão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        try {
            // Abrir o sub-menu do meu usuário com a classe ace-icon fa fa-angle-down
            navegador.findElement(By.cssSelector(".ace-icon.fa.fa-angle-down")).click();

            // Clicar na opção Minha Conta com a classe ace-icon fa fa-user
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            WebElement minhaConta = navegador.findElement(By.xpath("//*[contains(@class, 'ace-icon') and contains(@class, 'fa') and contains(@class, 'fa-user')]"));
            js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible';", minhaConta);

        } finally {
            //Fecha o navegador
            //navegador.quit();
        }
    }
}

package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade Sair")

public class SairTests {
    //@Test
    @DisplayName("Sair da minha conta")
    public void testSairDaMinhaConta (){

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        LoginTests novoLogin = new LoginTests();
        novoLogin.testRegistrarUmNovoUsuarioComDadosValidos(navegador, "Lucas_Silva", "FR?8Q46E<tn");

        // Espera 5 segundos até chamar alguma excessão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try{
            // Abrir o sub-menu do meu usuário com a classe ace-icon fa fa-angle-down
            navegador.findElement(By.cssSelector(".ace-icon.fa.fa-angle-down")).click();
            // Clicar na opção Sair com a classe ace-icon fa fa-sign-out
            navegador.findElement(By.cssSelector(".ace-icon.fa.fa-sign-out")).click();
        } finally {
            //Fecha o navegador
            //navegador.quit();
        }
    }
}

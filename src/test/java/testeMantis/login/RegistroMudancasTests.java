package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade Resgistro de Mudanças")

public class RegistroMudancasTests {

    @DisplayName("Visualisar os resgistros de mudancas")
    public void testVisualizarRegistroDeMudancas (){

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        LoginTests novoLogin = new LoginTests();
        novoLogin.testRegistrarUmNovoUsuarioComDadosValidos(navegador, "Lucas_Silva", "FR?8Q46E<tn");

        // Espera 5 segundos até chamar alguma excessão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try{
            // Clicar na opção Registro de Mudancas com a classe menu-icon menu-icon fa fa-retweet
            navegador.findElement(By.cssSelector(".menu-icon.fa.fa-retweet")).click();
        } finally {
            //Fecha o navegador
            //navegador.quit();
        }
    }
}

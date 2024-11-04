package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade Tarefa")

public class VerTarefasTests {

    @DisplayName("Visualisar as tarefas criadas")
    public void testVerTarefasCriadas (){

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        LoginTests novoLogin = new LoginTests();
        novoLogin.testRegistrarUmNovoUsuarioComDadosValidos(navegador, "Lucas_Silva", "FR?8Q46E<tn");
        // Espera 5 segundos até chamar alguma excessão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try{
            // Clicar na opção Ver Tarefas com a classe menu-icon fa fa-list-alt
            navegador.findElement(By.cssSelector(".menu-icon.fa.fa-list-alt")).click();
         } finally {
            //Fecha o navegador
            //navegador.quit();
        }
    }
}

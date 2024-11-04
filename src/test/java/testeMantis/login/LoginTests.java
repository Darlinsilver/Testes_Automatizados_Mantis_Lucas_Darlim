package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes automatizados da funcionalidade login")

public class LoginTests {

    @DisplayName("Resgistrar um novo usuários com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(WebDriver navegador, String nomeUsuario, String senhaUsuario) {
        // Abrir o Chrome
        WebDriverManager.chromedriver().setup();
        //WebDriver navegador = new ChromeDriver();

        try {
            // Abrir a plataforma do Mantis
            navegador.get("https://mantis-prova.base2.com.br/login_page.php?return=%2Fmy_view_page.php%3Frefresh%3Dtrue");

            // Inserir o nome do usuário com ID igual a username
            WebElement userName = navegador.findElement(By.id("username"));
            userName.sendKeys(nomeUsuario);

            // Clicar no botão entrar com Value Entrar
            navegador.findElement(By.cssSelector("input[value='Entrar']")).click();

            // Inserir a senha do usuário com ID igual a password
            WebElement userPassword = navegador.findElement(By.id("password"));
            userPassword.sendKeys(senhaUsuario);

            // Clicar no botão entrar com Value Entrar
            navegador.findElement(By.cssSelector("input[value='Entrar']")).click();

        } finally {
            // Fechar o navegador
            //navegador.quit();
        }
    }
}

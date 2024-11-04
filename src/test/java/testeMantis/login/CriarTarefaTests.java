package testeMantis.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade Criar Tarefa")

public class CriarTarefaTests {
    @Test
    @DisplayName("Criar uma nova Tarefa")
    public void testCriarUmaNovaTarefa() {

        // Configurar o caminho para o driver do Chrome
        // System.setProperty("webdriver.chrome.driver", "https://mantis-prova.base2.com.br/my_view_page.php");

        //Inicializar o WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        // Espera 5 segundos até chamar alguma excessão
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Torna visível elementos que estão ocultos
        JavascriptExecutor tornarVisivel = (JavascriptExecutor) navegador;

        LoginTests novoLogin = new LoginTests();
        novoLogin.testRegistrarUmNovoUsuarioComDadosValidos(navegador,"Lucas_Silva", "FR?8Q46E<tn");

        try {
            // Navegar para a página principal do Mantis
            // navegador.get("https://mantis-prova.base2.com.br/my_view_page.php");

            // Clicar no botão Criar Tarefa com a classe btn.btn-primary.btn-sm
            navegador.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();

            // Selecionar a categoria com o ID category_id
            navegador.findElement(By.id("category_id")).sendKeys("[Todos os Projetos] categoria teste");

            // Selecionar a frequencia com o ID reproducibility
            navegador.findElement(By.id("reproducibility")).sendKeys("às vezes");

            // Selecionar a gravidade com o ID severity
            navegador.findElement(By.id("severity")).sendKeys("trivial");

            // Selecionar a prioridade com o ID priority
            navegador.findElement(By.id("priority")).sendKeys("urgente");

            // Abrir as opcões do perfil com title +
            // WebElement profileClosed = navegador.findElement(By.cssSelector(".fa.fa-minus-square-o"));
            WebElement profileOpen = navegador.findElement(By.cssSelector(".fa.fa-plus-square-o"));
            if (profileOpen.isDisplayed()) {
                navegador.findElement(By.cssSelector(".fa.fa-plus-square-o")).click();
            }

            // Preencher o campo Plataforma com o ID platform
            navegador.findElement(By.id("platform")).sendKeys("Web");

            // Preencher o campo SO com o ID os
            navegador.findElement(By.id("os")).sendKeys("Windows");

            // Preencher o campo Versão SO com o ID os_build
            navegador.findElement(By.id("os_build")).sendKeys("11");

            // Preencher o campo Resumo com o name sumary
            navegador.findElement(By.name("summary")).sendKeys("Teste resumo da nova tarefa.");

            // Preencher o campo Descrição com o name description
            navegador.findElement(By.name("description")).sendKeys("Teste descrição detalhada da nova tarefa.");

            // Preencher o campo Passos para reproduzir com o name steps_to_reproduce
            navegador.findElement(By.name("steps_to_reproduce")).sendKeys("Teste passos para reproduzir o apontamento da nova tarefa.");

            // Preencher o campo Informações adicionais com o name additional_info
            navegador.findElement(By.name("additional_info")).sendKeys("Teste informações adicionais da nova tarefa.");

            // Aplicar marcadores com o name tag_string
            navegador.findElement(By.name("tag_string")).sendKeys("Atividade, bug, Desenvolvimento, Novo_Marcador_Teste");

            // Localizar o elemento do tipo input file dz-hidden-input
            WebElement uploadFile = navegador.findElement(By.xpath("//input[@type='file' and contains(@class, 'dz-hidden-input')]"));
            // Usar JavaScript para tornar o elemento input file visível
            tornarVisivel.executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.position = 'static'; arguments[0].style.height = 'auto'; arguments[0].style.width = 'auto';", uploadFile);
            // Enviar um arquivo com o name TesteUpload
            uploadFile.sendKeys("C:\\Users\\darli\\Downloads\\TesteUpload.png");

            // Selecionar a opção Privado do tipo radio
            WebElement radioButton = navegador.findElement(By.xpath("//input[@type='radio' and @name='view_state' and @value='50']"));
            // Usar JavaScript para tornar o elemento rádio button visível
            tornarVisivel.executeScript("arguments[0].click();", radioButton);

            // Selecionar a opção "Continuar relatando" no elemento do tipo checkbox
            // WebElement checkBox = navegador.findElement(By.xpath("//input[@type='checkbox' and @name='report_stay']"));
            // Usar JavaScript para liberar o click na checkbox
            // tornarVisivel.executeScript("arguments[0].click();", checkBox);

            // Clicar no botão "Enviar Relatório"
            navegador.findElement(By.cssSelector("input[value='Criar Nova Tarefa']")).click();

        } finally {
            // Fechar o navegador
            //navegador.quit();
        }
    }
}

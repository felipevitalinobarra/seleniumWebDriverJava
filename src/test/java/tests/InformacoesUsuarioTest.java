package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAddInformacaoAdicionalDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\felip\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        // Validação
        assertEquals(1,1);
    }
}

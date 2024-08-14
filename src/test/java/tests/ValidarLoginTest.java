package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidarLoginTest {
    @Test
    public void testValidarLogin(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\felip\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navegando para a página "saucedemo"
            navegador.get("https://www.saucedemo.com/");

        // Cenário 1: Teste de login bem-sucedido

        // Cenário 2: Teste de login com nome de usuário incorreto

        // Cenário 3: Teste de login com senha incorreta

        // Cenário 4: Teste de campos vazios

        // Validação
        assertEquals(1,1);
    }
}
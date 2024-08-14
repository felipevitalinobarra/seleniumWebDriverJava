package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ValidarLoginTest {
    @Test
    public void testValidarLogin(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\felip\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        // Navegando para a página "saucedemo"
        navegador.get("https://www.saucedemo.com/");

        /*
        *
        * Identificadores dos campos:
        *
        * [TXT] Username - id = user-name
        * [TXT] Password - id = password
        * [BTN] Login - id = login-button
        *
        */

        WebElement txt_username = navegador.findElement(By.id("user-name"));
        WebElement txt_password = navegador.findElement(By.id("password"));
        WebElement btn_login = navegador.findElement(By.id("login-button"));

        // Cenário 1: Teste de login bem-sucedido
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();
        navegador.quit();

        // Cenário 2: Teste de login com nome de usuário incorreto
        txt_username.sendKeys("felipe");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();
        navegador.quit();

        // Cenário 3: Teste de login com senha incorreta
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("123456");
        btn_login.click();
        navegador.quit();

        // Cenário 4: Teste de campos vazios
        txt_username.sendKeys();
        txt_password.sendKeys();
        btn_login.click();
        navegador.quit();
    }
}
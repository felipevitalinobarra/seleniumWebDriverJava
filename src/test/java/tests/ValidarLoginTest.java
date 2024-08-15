package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ValidarLoginTest {
    private WebDriver navegador;
    private WebElement txt_username;
    private WebElement txt_password;
    private WebElement btn_login;

    @Before
    public void setUp(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\felip\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();

        // Navegando para a página "saucedemo"
        navegador.get("https://www.saucedemo.com/");

        txt_username = navegador.findElement(By.id("user-name"));
        txt_password = navegador.findElement(By.id("password"));
        btn_login = navegador.findElement(By.id("login-button"));
    }

    /*
     *
     * Identificadores dos campos:
     *
     * [TXT] Username - id = user-name
     * [TXT] Password - id = password
     * [BTN] Login - id = login-button
     *
     */

    @Test
    public void testValidarLoginComSucesso() {
        // Cenário 1: Teste de login bem-sucedido
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();
    }

    @Test
    public void testValidarLoginComUsuarioIncorreto() {
        // Cenário 2: Teste de login com nome de usuário incorreto
        txt_username.sendKeys("felipe");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();
    }

    @Test
    public void testValidarLoginComSenhaIncorreta() {
        // Cenário 3: Teste de login com senha incorreta
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("123456");
        btn_login.click();
    }

    @Test
    public void testValidarCamposVazios(){
        // Cenário 4: Teste de campos vazios
        btn_login.click();
    }

    @Test
    public void testValidarCamposPasswordVazio(){
        // Cenário 5: Tentativa de login apenas digitando o username
        txt_username.sendKeys("standard_user");
        btn_login.click();

        WebElement senhaEmBranco = navegador.findElement(By.className("error-message-container"));
        String textoSenhaEmBranco = senhaEmBranco.getText();
        assertEquals("Epic sadface: Password is required",textoSenhaEmBranco);
    }

    @Test
    public void testValidarCampoUsernameVazio(){
        // Cenário 6: Tentativa de login apenas digitando a senha
        txt_password.sendKeys("123456");
        btn_login.click();

       WebElement usernameEmBranco = navegador.findElement(By.className("error-message-container"));
       String textoUsernameEmBranco = usernameEmBranco.getText();
       assertEquals("Epic sadface: Username is required",textoUsernameEmBranco);
    }

    @After
    public void tearDown(){
        // Fechar o navegador
        navegador.quit();
    }
}
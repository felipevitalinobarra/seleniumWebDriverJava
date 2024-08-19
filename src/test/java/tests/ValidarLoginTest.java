package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "ValidarLoginTest.csv")

public class ValidarLoginTest {
    private WebDriver navegador;
    private WebElement txt_username;
    private WebElement txt_password;
    private WebElement btn_login;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        navegador = Web.createChrome();
        txt_username = navegador.findElement(By.id("user-name"));
        txt_password = navegador.findElement(By.id("password"));
        btn_login = navegador.findElement(By.id("login-button"));
    }

    @Test
    public void testValidarAcessos(@Param(name="usuario")String usuario,@Param(name="senha")String senha){
        // Validar os usuários: locked_out_user, problem_user, performance_glitch_user, error_user, visual_user
        txt_username.sendKeys(usuario);
        txt_password.sendKeys(senha);
        btn_login.click();
    }

    @Test
    public void testValidarLoginComSucesso() {
        // Cenário 1: Teste de login bem-sucedido
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @Test
    public void testValidarLoginComUsuarioIncorreto() {
        // Cenário 2: Teste de login com nome de usuário incorreto
        txt_username.sendKeys("felipe");
        txt_password.sendKeys("secret_sauce");
        btn_login.click();

        WebElement mensagemDeErro = navegador.findElement(By.className("error-message-container"));
        String textoMsgErro = mensagemDeErro.getText();
        assertEquals("Epic sadface: Username and password do not match any user in this service",textoMsgErro);

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @Test
    public void testValidarLoginComSenhaIncorreta() {
        // Cenário 3: Teste de login com senha incorreta
        txt_username.sendKeys("standard_user");
        txt_password.sendKeys("123456");
        btn_login.click();

        WebElement mensagemDeErro = navegador.findElement(By.className("error-message-container"));
        String textoMsgErro = mensagemDeErro.getText();
        assertEquals("Epic sadface: Username and password do not match any user in this service",textoMsgErro);

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @Test
    public void testValidarCamposVazios(){
        // Cenário 4: Teste de campos vazios
        btn_login.click();

        WebElement camposEmBranco = navegador.findElement(By.className("error-message-container"));
        String textoCamposEmBranco = camposEmBranco.getText();
        assertEquals("Epic sadface: Username is required",textoCamposEmBranco);

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @Test
    public void testValidarCamposPasswordVazio(){
        // Cenário 5: Tentativa de login apenas digitando o username
        txt_username.sendKeys("standard_user");
        btn_login.click();

        WebElement senhaEmBranco = navegador.findElement(By.className("error-message-container"));
        String textoSenhaEmBranco = senhaEmBranco.getText();
        assertEquals("Epic sadface: Password is required",textoSenhaEmBranco);

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @Test
    public void testValidarCampoUsernameVazio(){
        // Cenário 6: Tentativa de login apenas digitando a senha
        txt_password.sendKeys("123456");
        btn_login.click();

        WebElement usernameEmBranco = navegador.findElement(By.className("error-message-container"));
        String textoUsernameEmBranco = usernameEmBranco.getText();
        assertEquals("Epic sadface: Username is required",textoUsernameEmBranco);

        String screenshotArquivo = "D:/CURSOS/Udemy/SeleniumJava/Saucedemo/test-report/" + Generator.dataHoraArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,screenshotArquivo);
    }

    @After
    public void tearDown(){
        // Fechar o navegador
        navegador.quit();
    }
}
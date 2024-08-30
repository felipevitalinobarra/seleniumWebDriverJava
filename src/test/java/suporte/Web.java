package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static WebDriver createChrome(){
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\felip\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://www.saucedemo.com/");

        return navegador;
    }
}

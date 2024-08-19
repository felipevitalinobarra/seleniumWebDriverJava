package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import suporte.Web;

public class ValidarLoginPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test

    @After
    public void tearDown(){
        navegador.quit();
    }
}

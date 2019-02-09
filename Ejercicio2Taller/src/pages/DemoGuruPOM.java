package pages;

//Conflicto

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.security.SecureRandom;
import java.math.BigInteger;

/**
 *
 * @author Jose Daniel Restrepo
 */
 
 //Clase que contiene las interacciones entre el WebDriver y el navegador
 
public class DemoGuruPOM {
    WebDriver bot;
    String id,id2;   

    
    public void AbrirNavegador(String URL){
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        bot = new ChromeDriver();
        bot.get(URL);
        bot.manage().window().maximize();
    }
    
    public void CerrarNavegador(){
        bot.close();
    }
    
    public void EnviarTexto(String txt, String elemento){
        bot.findElement(By.name(elemento)).sendKeys(txt);
    }
    
    public void HacerClick(String elemento){
        bot.findElement(By.name(elemento)).click();
    }
    
     public void HacerClick2(String elemento){
        bot.findElement(By.xpath(elemento)).click();
    }
    
    public String CapturarElemento(String path){
        id = bot.findElement(By.xpath(path)).getText();
        System.out.println("El id de usuario es: "+id);
        return id;
    }
    
    public String CapturarElemento2(String path){
        id2 = bot.findElement(By.xpath(path)).getText();
        System.out.println("El id de cuenta es: "+id2);
        return id2;
    }
    
    public String generateRandomText() {
    SecureRandom random = new SecureRandom();
    String text = new BigInteger(130, random).toString(32);
    return text;
    }
}

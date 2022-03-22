package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class SearchTest {
    @Test
    public void testPesquisaValida() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();

        navegador.findElement(By.xpath("//*[@id='search-open']")).click();
        navegador.findElement(By.xpath("//header[1]/div[1]/div[2]/form[1]/label[1]/input[1]"))
                .sendKeys("Finanças");
        navegador.findElement(By.xpath("//header[1]/div[1]/div[2]/form[1]/input[1]")).click();

        String eleText = navegador.findElement(By.xpath("//header[1]/h1[1]")).getText();

        Assert.assertEquals("Resultados da busca por: Finanças", eleText);
    }

    @Test
    public void testPesquisaInvalida() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();

        navegador.findElement(By.xpath("//*[@id='search-open']")).click();
        navegador.findElement(By.xpath("//header[1]/div[1]/div[2]/form[1]/label[1]/input[1]"))
                .sendKeys("Abléabléablé");
        navegador.findElement(By.xpath("//header[1]/div[1]/div[2]/form[1]/input[1]")).click();

        String eleText = navegador.findElement(By.xpath("//header[1]/h1[1]")).getText();

        Assert.assertEquals("Nenhum resultado", eleText);
    }
}
